package com.tarnet.launch;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.EmptyResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Main {

    private static File getRootFolder() {
        try {
            File root;
            String runningJarPath = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()
                    .replaceAll("\\\\", "/");
            int lastIndexOf = runningJarPath.lastIndexOf("/target/");
            if (lastIndexOf < 0) {
                root = new File("");
            } else {
                root = new File(runningJarPath.substring(0, lastIndexOf));
            }
            System.out.println("application resolved root folder: " + root.getAbsolutePath());
            return root;
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static final String[] profiles = {
            "development",
    };

    public static void main(String[] args) throws Exception {
        System.getProperties().putIfAbsent("spring.profiles.active", String.join(",", profiles));

//        System.getProperties().putIfAbsent("logging.path", ".");

        File root = getRootFolder();
//        System.setProperty("org.apache.catalina.startup.EXIT_ON_INIT_FAILURE", "true");
        Tomcat tomcat = new Tomcat();
        Path tempPath = Files.createTempDirectory("tomcat-base-dir");
        tomcat.setBaseDir(tempPath.toString());

        tomcat.setPort(getPort());

        String webContentFolderAbsolutePath = getWebContentFolderAbsolutePath(root);

        StandardContext ctx = (StandardContext) tomcat.addWebapp("deneme", webContentFolderAbsolutePath);
        ctx.setReloadable(true);

        disableJarScan(ctx);

        // Set execution independent of current thread context classloader
        // (compatibility with exec:java mojo)
        ctx.setParentClassLoader(Main.class.getClassLoader());

        System.out.println("configuring app with basedir: " + webContentFolderAbsolutePath);

        ctx.setResources(getResources(root, ctx));

        tomcat.start();
        tomcat.getServer().await();
    }

    private static void disableJarScan(StandardContext ctx) {
        ctx.getJarScanner().setJarScanFilter((jarScanType, jarName) -> false);
    }

    private static String getWebContentFolderAbsolutePath(File root) throws IOException {
        // TODO
        String child = "src/main/webapp/";

        File webContentFolder = new File(root.getAbsolutePath(), child);

        if (webContentFolder.exists()) {
            return webContentFolder.getAbsolutePath();
        }
        return Files.createTempDirectory("default-doc-base").toFile().getAbsolutePath();
    }

    private static int getPort() {
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");
        return Integer.parseInt(port);
    }

    private static WebResourceRoot getResources(File root, StandardContext ctx) {
        WebResourceRoot resources = new StandardRoot(ctx);
        addPreresources(resources, "/WEB-INF/classes", new File(root.getAbsolutePath(), "build/classes/java/main"));

        addPreresources(resources, "/", new File(root.getAbsolutePath(), "src/main/webapp"));

        return resources;
    }

    private static void addPreresources(WebResourceRoot resources, String webAppMount, File directory) {
        resources.addPreResources(getWebResourceSet(
                resources,
                webAppMount,
                directory
        ));
    }

    private static WebResourceSet getWebResourceSet(WebResourceRoot resources, String webAppMount, File directory) {
        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work

        if (!directory.exists()) return new EmptyResourceSet(resources);
        return new DirResourceSet(
                resources,
                webAppMount,
                directory.getAbsolutePath(),
                "/"
        );
    }
}

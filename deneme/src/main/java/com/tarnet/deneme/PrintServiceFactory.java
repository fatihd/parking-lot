package com.tarnet.deneme;

import org.springframework.beans.factory.FactoryBean;

import java.io.PrintStream;

public class PrintServiceFactory implements FactoryBean<PrintStream> {
    @Override
    public PrintStream getObject() throws Exception {
        PrintStream out = System.out;
        return out;
    }

    @Override
    public Class<?> getObjectType() {
        return PrintStream.class;
    }
}

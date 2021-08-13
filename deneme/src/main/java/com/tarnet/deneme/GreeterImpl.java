package com.tarnet.deneme;

import com.tarnet.excluded.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Component
public class GreeterImpl implements Greeter {
    private final PrintStream out;

    private final DenemeService denemeService;

    public GreeterImpl(PrintStream out, @Qualifier("denemeService2Impl") DenemeService denemeService) {
        this.out = out;
        this.denemeService = denemeService;
    }

    @Override
    public void greet() {
        out.println("Hello, world!");
        denemeService.deneme();
    }
}

package com.tarnet.deneme;

import org.springframework.stereotype.Component;

@Component
public class Excluded {
    public void run() {
        System.out.println("Excluded.run");
    }
}

package com.tarnet.deneme;

import org.springframework.stereotype.Component;

@Component
public class DenemeService2Impl implements DenemeService {
    @Override
    public void deneme() {
        System.out.println("DenemeService2Impl.deneme");
    }
}

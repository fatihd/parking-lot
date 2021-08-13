package com.tarnet.deneme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class DenemeServiceImpl implements DenemeService {
    @Override
    public void deneme() {
        System.out.println("DenemeServiceImpl.deneme");
    }
}

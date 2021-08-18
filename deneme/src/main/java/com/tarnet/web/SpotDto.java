package com.tarnet.web;

import lombok.Data;

@Data
public class SpotDto {
    private Long id;
    private UserDto user;

    @Data
    public static class UserDto {
        private Long id;

        private String ad;
    }
}

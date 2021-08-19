package com.tarnet.web;

import lombok.Data;

@Data
public class ReservationDto {
    private Long id;
    private SpotDto spot;

    @Data
    public static class SpotDto {
        private Long id;
    }
}

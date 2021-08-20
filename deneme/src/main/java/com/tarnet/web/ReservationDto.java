package com.tarnet.web;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private Long id;
    private Long userId;
    private Long spotId;
    private LocalDateTime start;
    private LocalDateTime end;
}

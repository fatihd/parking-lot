package com.tarnet.deneme.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@FieldNameConstants
@Getter @Setter
public class Reservation extends AggregateRoot {
    long userId;
    long spotId;
    LocalDateTime start;
    LocalDateTime end;
}

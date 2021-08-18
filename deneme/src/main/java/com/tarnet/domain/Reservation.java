package com.tarnet.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
@Getter @Setter
public class Reservation {
    private Long id;

    private Spot spots;

}

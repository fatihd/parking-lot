package com.tarnet.deneme.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
@Getter @Setter
public class Spot extends AggregateRoot{
    String code;
}

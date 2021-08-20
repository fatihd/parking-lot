package com.tarnet.deneme.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@FieldNameConstants
@Getter @Setter
public class User extends AggregateRoot {
    private String ad;
}

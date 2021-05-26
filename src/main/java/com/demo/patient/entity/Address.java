package com.demo.patient.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Address {

    @Field(name = "locality")
    private String locality;

    @Field(name = "street")
    private String street;

    @Field(name = "zipcode")
    private String zipCode;
}

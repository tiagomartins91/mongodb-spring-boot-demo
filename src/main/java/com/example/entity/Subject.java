package com.example.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {

    @Field(name = "subject_name")
    private String subjectName;

    @Field(name = "marks_obtained")
    private Integer marksObtained;
}

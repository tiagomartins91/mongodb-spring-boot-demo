package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    // if the name are the same, doesnt needs to be provided
    //@Field(name = "name")
    private String name;

    @Field(name = "mail")
    private String email;

    @Field(name = "department")
    private Department department;

    @Field(name = "subjects")
    private List<Subject> subjects;

    @Transient
    private double percentage;

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }

    /* Constructors examples

    // Can be refactor to use Builder pattern?

    public Student(String id, Department department) {
        super();
        this.id = id;
        this.department = department;
    }

    //if have more than 1 constructor
    @PersistenceConstructor
    public Student(String id, String name, String email, Department department, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.subjects = subjects;
    }
     */

    public double getPercentage() {
        if (subjects != null && !subjects.isEmpty()) {
            int total = 0;
            for (Subject subject : subjects) {
                total += subject.getMarksObtained();
            }
            return total / subjects.size();
        }

        return 0.0;
    }

}

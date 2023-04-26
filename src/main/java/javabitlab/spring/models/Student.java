package javabitlab.spring.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;
}

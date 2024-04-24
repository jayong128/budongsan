package com.hello.myproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "cortar")
public class Cortar {
    @Id @GeneratedValue(generator = "uuid2")
    private String cortarNumber;
    private String cortarName;
    @Column(name = "map_x")
    private String mapX;
    @Column(name = "map_y")
    private String mapY;
    private String cortarType;

}

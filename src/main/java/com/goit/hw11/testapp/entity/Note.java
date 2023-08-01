package com.goit.hw11.testapp.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
    @Column
    public String title;
    @Column
    public String content;
}

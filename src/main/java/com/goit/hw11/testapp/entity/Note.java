package com.goit.hw11.testapp.entity;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Note {
    public long id;
    public String title;
    public String content;

}

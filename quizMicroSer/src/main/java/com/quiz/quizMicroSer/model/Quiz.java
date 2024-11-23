package com.quiz.quizMicroSer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data

public class Quiz {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    private String title;

    @ManyToMany
    private List<Questions> questions;
}

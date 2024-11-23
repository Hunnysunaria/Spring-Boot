package com.hunny.quizService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Quiz {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    private String title;

    @ElementCollection
    private List<Integer> questionIds;

}

package com.ot.backend.po;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Translate extends AbstractPersistentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String query;
    private String translation;
    private String answer;
    private String answerTranslation;

    @Builder
    public Translate(String query, String translation, String answer, String answerTranslation) {
       this.query = query;
       this.translation = translation;
       this.answer = answer;
       this.answerTranslation = answerTranslation;
    }
}

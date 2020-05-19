package hh.korona.kysely.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "optionId")
    private Long optionId;

    @Column(name = "optionText")
    private String optionText;

    @Column(name = "count")
    private int count = 0;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference
    private Question question;


    public Option() {
        super();
    }

    public Option(String optionText, Question question) {
        super();
        this.optionText = optionText;
        this.question = question;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getCount() {
        return count;
    }

    public void addCountOne() {
        this.count = count + 1;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Option [optionId=" + optionId + ", optionText=" + optionText + ", question=" + question + "]";
    }


}

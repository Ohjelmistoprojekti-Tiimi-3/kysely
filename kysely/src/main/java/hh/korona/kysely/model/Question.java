package hh.korona.kysely.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long question_id;

    @Column(name = "question", nullable = false, unique = true)
    private String question;

    @ManyToOne(cascade = CascadeType.ALL)
    private Query query;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answer;

    public Question() {
    }

    public Question(String question, Query query, Answer answer) {
        this.question = question;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }


    @Override
    public String toString() {
        return "Question{" +
                "user_id=" + user_id +
                ", question='" + question + '\'' +
                ", query=" + query +
                ", answer=" + answer +
                '}';
    }
}

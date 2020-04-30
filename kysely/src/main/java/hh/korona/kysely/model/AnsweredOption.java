package hh.korona.kysely.model;


import javax.persistence.*;

@Entity
public class AnsweredOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answeredOption_id")
    private Long answeredOption_id;

    @ManyToOne
    private Option option;

    @ManyToOne
    private Answer answer;


    public AnsweredOption() {
    }

    public AnsweredOption(Long answeredOption_id, Option option, Answer answer) {
        this.answeredOption_id = answeredOption_id;
        this.option = option;
        this.answer = answer;
    }


    public Long getAnsweredOption_id() {
        return answeredOption_id;
    }

    public void setAnsweredOption_id(Long answeredOption_id) {
        this.answeredOption_id = answeredOption_id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnsweredOption{" +
                "answeredOption_id=" + answeredOption_id +
                ", option=" + option +
                ", answer=" + answer +
                '}';
    }
}

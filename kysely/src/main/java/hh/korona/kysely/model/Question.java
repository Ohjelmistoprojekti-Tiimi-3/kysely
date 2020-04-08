package hh.korona.kysely.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "questionId")
    private Long questionId;

    @Column(name = "question", nullable = false, unique = true)
    private String question;

    @ManyToOne(cascade = CascadeType.ALL)
    private Query query;

    @OneToMany
    private List<Answer> answer;

    public Question() {
    }

    public Question(String question, Query query, Answer answer) {
        this.question = question;
    }

    public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", query=" + query +
                ", answer=" + answer +
                '}';
    }
}

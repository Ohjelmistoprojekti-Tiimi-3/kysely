package hh.korona.kysely.model;

import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long id;
	
	@Column(name = "answerText", nullable = false)
    private String answerText;

    @Column(name = "date")
    private Date date;

    @JsonIgnore
    @ManyToOne
	@JoinColumn(name = "questionId")
	private Question question;

	public Answer() {
		super();
	}

	public Answer(String answerText, Date date, Question question) {
		this.answerText = answerText;
		this.date = date;
		this.question = question;
	}

	public Answer(String answerText, Question question) {
		this.answerText = answerText;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	@Override
	public String toString() {
		return "Answer{" +
				"id=" + id +
				", answerText='" + answerText + '\'' +
				", date=" + date +
				", question=" + question +
				'}';
	}
}

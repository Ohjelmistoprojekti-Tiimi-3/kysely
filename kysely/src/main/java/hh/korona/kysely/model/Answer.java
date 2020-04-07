package hh.korona.kysely.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Answer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long id;
	
	@Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "date", nullable = false)
    private Date date;
    
    @ManyToOne(cascade = CascadeType.ALL)
	    private Question question;

	public Answer() {
		super();
	}

	public Answer(Long id, String answer, Date date, Question question) {
		super();
		this.id = id;
		this.answer = answer;
		this.date = date;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
		return "Answer [id=" + id + ", answer=" + answer + ", date=" + date + "]";
	}
    
    

}

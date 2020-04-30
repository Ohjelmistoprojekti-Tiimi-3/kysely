package hh.korona.kysely.model;

import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class QuestionType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "questionType_id")
    private Long id;
	
	@Column(name = "questionType_name", nullable = false) 
    private String name;
	
	@OneToMany
	@JoinColumn(name = "question_id")
	@JsonBackReference
	private Question question;

	public QuestionType() {
		super();
	}

	public QuestionType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionType [id=" + id + ", name=" + name + ", question=" + question + "]";
	}
	
}

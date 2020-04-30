package hh.korona.kysely.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class QuestionType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "questionType_id")
    private Long id;
	
	@Column(name = "questionType_name", nullable = false) 
    private String name;
	
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "questionType",fetch = FetchType.EAGER)
    @JsonManagedReference
	private List<Question> question;

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
	
	

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionType [id=" + id + ", name=" + name + "]";
	}
	
}

package hh.korona.kysely.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "optionId")
	private Long optionId;
	
	@Column(name = "optionText")
	private String optionText;
	
	@ManyToOne
	@JoinColumn(name = "questionId")
	@JsonBackReference
	private Question question;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "option", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<AnsweredOption> answeredOption;

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

	public List<AnsweredOption> getAnsweredOption() {
		return answeredOption;
	}

	public void setAnsweredOption(List<AnsweredOption> answeredOption) {
		this.answeredOption = answeredOption;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", optionText=" + optionText + ", question=" + question + "]";
	}
	
	
}

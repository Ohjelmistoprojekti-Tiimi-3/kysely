package hh.korona.kysely.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "questionId")
    private Long questionId;

    @Column(name = "questionString", length = 2500)

    private String questionString;

    @ManyToOne
    @JoinColumn(name = "query_id")
    @JsonBackReference
    private Query query;
    
    @ManyToOne
    @JoinColumn(name = "questionType_id")
    @JsonBackReference
    private QuestionType questionType;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Option> option;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Answer> answer;


    public Question(String questionString) {
		super();
		this.questionString = questionString;
	}

    public Question(Query query) {
        this.query = query;
    }

    public Question() {
    }

	public Question(String question, Query query, Answer answer) {
        this.questionString = question;
    }

	
    public Question(String questionString, Query query, QuestionType questionType, List<Option> option,
			List<Answer> answer) {
		super();
		this.questionString = questionString;
		this.query = query;
		this.questionType = questionType;
		this.option = option;
		this.answer = answer;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
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

    public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	@Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + questionString + '\'' +
                ", query=" + query +
                ", answer=" + answer +
                '}';
    }
}

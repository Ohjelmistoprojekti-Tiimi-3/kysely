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

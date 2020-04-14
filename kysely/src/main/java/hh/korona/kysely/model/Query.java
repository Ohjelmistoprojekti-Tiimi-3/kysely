package hh.korona.kysely.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "queryId")
    private Long queryId;
    
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Question> questions;


    public Query() {
    }

    public Query(Date date, User user, String title, List<Question> questions) {
        this.date = date;
        this.user = user;
        this.title = title;
        this.questions = questions;
    }


    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Query{" +
                "queryId=" + queryId +
                ", title=" + title +
                ", date=" + date +
                ", user=" + user +
                ", questions=" + questions +
                '}';
    }
}

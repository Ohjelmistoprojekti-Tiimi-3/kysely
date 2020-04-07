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

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Question> questions;


    public Query() {
    }

    public Query(Date date, User user, List<Question> questions) {
        this.date = date;
        this.user = user;
        this.questions = questions;
    }


    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
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
                ", date=" + date +
                ", user=" + user +
                ", questions=" + questions +
                '}';
    }
}

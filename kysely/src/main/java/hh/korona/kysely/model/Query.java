package hh.korona.kysely.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "query_id")
    private Long query_id;

    @Column(name = "question", nullable = false, unique = true)
    private String question;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    private User user;


    public Query() {
    }

    public Query(String question, Date date, User user) {
        this.question = question;
        this.date = date;
        this.user = user;
    }

    public Long getQuery_id() {
        return query_id;
    }

    public void setQuery_id(Long query_id) {
        this.query_id = query_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    @Override
    public String toString() {
        return "Query{" +
                "query_id=" + query_id +
                ", question='" + question + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}

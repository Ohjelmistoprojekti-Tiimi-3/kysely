package hh.korona.kysely.model;

import java.util.Date;

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
    @Column(name = "id")
    private Long id;
	
	@Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "date", nullable = false)
    private Date date;
    
	@ManyToOne
	@JsonIgnore
	  @JoinColumn(name = "question_id")
	    private User user;

}

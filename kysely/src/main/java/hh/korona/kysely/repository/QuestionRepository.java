package hh.korona.kysely.repository;

import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findByQuery(Query query);
	List<Question> findByQuestionId(Long questionId);
	
}

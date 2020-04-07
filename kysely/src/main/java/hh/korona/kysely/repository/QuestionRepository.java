package hh.korona.kysely.repository;

import hh.korona.kysely.model.Question;
import hh.korona.kysely.model.User;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}

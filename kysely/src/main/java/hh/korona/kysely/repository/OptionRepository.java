package hh.korona.kysely.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hh.korona.kysely.model.Option;
import hh.korona.kysely.model.Question;

public interface OptionRepository extends CrudRepository<Option, Long> {
	
	List<Option> findByQuestion(Question question);
	Option findByOptionId(Long optionId);
}

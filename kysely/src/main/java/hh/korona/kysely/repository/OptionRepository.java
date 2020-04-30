package hh.korona.kysely.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hh.korona.kysely.model.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {
	
	List<Option> findByOption(Option option);
	Option findByOptionId(Long optionId);
}

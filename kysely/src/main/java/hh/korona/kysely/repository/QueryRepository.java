package hh.korona.kysely.repository;

import hh.korona.kysely.model.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QueryRepository extends CrudRepository<Query, Long> {

   List<Query> findByQueryId(Long id);
   Query findOneByQueryId(Long id);
   List<Query> findByTitle(String title);

}

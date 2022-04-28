package piano.tz.compression.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import piano.tz.compression.entities.DictionaryValue;

import java.util.Optional;

@Repository
public interface DictionaryValueRepository extends CrudRepository<DictionaryValue, String> {
    Optional<DictionaryValue> findByValue(final String value);
}

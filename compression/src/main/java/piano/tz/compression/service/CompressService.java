package piano.tz.compression.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piano.tz.compression.dto.Url;
import piano.tz.compression.entities.DictionaryValue;
import piano.tz.compression.repository.DictionaryValueRepository;
import piano.tz.compression.util.Compressor;
import piano.tz.compression.util.SimpleCompressor;

import java.util.Optional;

@Service
public class CompressService {

    @Autowired
    protected DictionaryValueRepository dictionaryValueRepository;

    protected Compressor compressor = new SimpleCompressor();

    /**
     * @param url is the input Url dto
     * @return value of entity DictionaryValue if this entity exists and value of new saved entity else
     */
    public String compress(final Url url) {
        final Optional<DictionaryValue> dictionaryValue = dictionaryValueRepository.findById(url.getStr());
        if (dictionaryValue.isPresent()) {
            return dictionaryValue.get().getValue();
        } else {
            final String value = compressor.compress(url.getStr(), dictionaryValueRepository.count());
            DictionaryValue dictionaryValue1 = DictionaryValue.builder().id(url.getStr()).value(value).build();
            dictionaryValueRepository.save(dictionaryValue1);
            return dictionaryValue1.getValue();
        }
    }
}

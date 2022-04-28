package piano.tz.compression.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piano.tz.compression.dto.Url;
import piano.tz.compression.entities.DictionaryValue;
import piano.tz.compression.repository.DictionaryValueRepository;

import java.util.Optional;

@Service
public class DecompressService {

    @Autowired
    protected DictionaryValueRepository dictionaryValueRepository;

    /**
     * @param str is the input compressed string
     * @return decompressed string if compressed string exists in the dictionary and empty else
     */
    public Optional<Url> decompress(final String str) {
        final Optional<DictionaryValue> val = dictionaryValueRepository.findByValue(str);
        if (val.isPresent()) {
            return Optional.of(Url.builder().str(val.get().getId()).build());
        } else {
            return Optional.empty();
        }
    }
}

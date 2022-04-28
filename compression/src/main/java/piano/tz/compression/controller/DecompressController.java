package piano.tz.compression.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import piano.tz.compression.dto.Url;
import piano.tz.compression.service.DecompressService;

import java.util.Optional;

@RestController
public class DecompressController {

    @Autowired
    protected DecompressService decompressService;

    /**
     *
     * @param str is the input string which should be decompressed
     * @return decompressed status 200 and Url if str exists in the dictionary or status 418 else
     */
    @GetMapping("decompress")
    public ResponseEntity<Url> decompress(final String str) {
        final Optional<Url> urlOptional = decompressService.decompress(str);
        if (urlOptional.isPresent()) {
            return ResponseEntity.ok(urlOptional.get());
        } else {
            return new ResponseEntity<>(HttpStatus.valueOf(418));
        }
    }
}

package piano.tz.compression.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import piano.tz.compression.dto.Url;
import piano.tz.compression.service.CompressService;

@RestController
public class CompressController {

    @Autowired
    protected CompressService compressService;

    /**
     * @param str is the input string whoch should be compressed
     * @return 200 status and compressed string
     */
    @GetMapping("compress")
    public ResponseEntity<String> compress(final Url str) {
        return ResponseEntity.ok(compressService.compress(str));
    }
}

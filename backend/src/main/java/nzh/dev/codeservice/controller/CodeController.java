package nzh.dev.codeservice.controller;

import nzh.dev.codeservice.exception.CodeNotFoundException;
import nzh.domain.Code;
import nzh.dev.codeservice.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class CodeController {

    @Autowired
    private CodeRepository codeRepository;

    @GetMapping("/codes")
    public Page<Code> getCodes(Pageable pageable) {
        return codeRepository.findAll(pageable);
    }

    @GetMapping(value = "/codes/{codeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Code findCodeJson(@PathVariable Integer codeId) {
        return getCode(codeId);
    }

    private Code getCode(Integer codeId) {
        return codeRepository.findById(codeId).orElseThrow(() -> new CodeNotFoundException("Code not found with id " + codeId));
    }

    @PostMapping("/codes")
    public Code createCode(@Valid @RequestBody Code code) {
        return codeRepository.save(code);
    }

    @PutMapping("/codes/{codeId}")
    public Code updateCode(@PathVariable Integer codeId,
                                   @Valid @RequestBody Code codeRequest) {
        return codeRepository.findById(codeId)
                .map(code -> {
                    code.setCodeId(codeRequest.getCodeId());
                    code.setCodeText(codeRequest.getCodeText());
                    code.setValueId(codeRequest.getCodeId());
                    code.setValueText(codeRequest.getValueText());
                    code.setCreator("todo");
                    return codeRepository.save(code);
                }).orElseThrow(() -> new CodeNotFoundException("Code not found with id " + codeId));
    }

    @DeleteMapping("/codes/{codeId}")
    public ResponseEntity<?> deleteCode(@PathVariable Integer codeId) {
        return codeRepository.findById(codeId)
                .map(code -> {
                    codeRepository.delete(code);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new CodeNotFoundException("Code not found with id " + codeId));
    }
}
package nzh.dev.codeservice.controller;

import nzh.dev.codeservice.exception.CodeNotFoundException;
import nzh.domain.Code;
import nzh.dev.codeservice.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nzh-dev on 05/10/2019.
 */
@RestController
public class CodeController {

    @Autowired
    private CodeRepository codeRepository;

    @GetMapping("/codes")
    public Page<Code> getCodes(Pageable pageable) {
        return codeRepository.findAll(pageable);
    }

    @GetMapping(value = "/codes/{codeId}")
    public Code getCodeByCodeId(@PathVariable Integer codeId) {
        return codeRepository.findById(codeId).orElseThrow(() -> new CodeNotFoundException("Code not found with id " + codeId));
    }
}
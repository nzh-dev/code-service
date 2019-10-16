package nzh.dev.codeservice.controller;

import nzh.dev.codeservice.exception.CodeNotFoundException;
import nzh.domain.CodeEntity;
import nzh.dev.codeservice.repository.CodeRepository;
import nzh.dev.codeservice.model.Code;
import nzh.dev.codeservice.mapper.CodeEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nzh-dev on 05/10/2019.
 */
@RestController
public class CodeController {

    @Autowired
    private CodeRepository codeRepository;

    @GetMapping("/codes")
    public List<Code> getCodes(Pageable pageable) {

        Page<CodeEntity> codeEntityPage = codeRepository.findAll(pageable);
        CodeEntityMapper mapper = new CodeEntityMapper();
        List<Code> codes = codeEntityPage.stream().map(codeEntity -> mapper.map(codeEntity)).collect(Collectors.toList());

        return codes;
    }

    @GetMapping(value = "/codes/{setId}")
    public CodeEntity getCodeBySetId(@PathVariable Integer setId) {
        return codeRepository.findById(setId).orElseThrow(() -> new CodeNotFoundException("CodeEntity not found with set id " + setId));
    }
}
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

    @Autowired
    private CodeEntityMapper codeEntityMapper;

    @GetMapping("/codes")
    public List<Code> getCodes(Pageable pageable) {
        Page<CodeEntity> codeEntityPage = codeRepository.findAll(pageable);
        List<Code> codes = codeEntityPage.stream().map(codeEntity -> codeEntityMapper.map(codeEntity)).collect(Collectors.toList());
        return codes;
    }

    @GetMapping(value = "/codes/{setId}")
    public Code getCodeBySetId(@PathVariable Integer setId) {
        CodeEntity codeEntity = codeRepository.findById(setId).orElseThrow(() -> new CodeNotFoundException("CodeEntity not found with set id " + setId));
        return codeEntityMapper.map(codeEntity);
    }
}
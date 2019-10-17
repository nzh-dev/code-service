package nzh.dev.codeservice.mapper;

import nzh.dev.codeservice.model.Code;
import nzh.domain.CodeRelationEntity;
import nzh.domain.CodeEntity;
import org.modelmapper.PropertyMap;
import org.modelmapper.Converter;
import java.util.Collection;

import java.util.List;
import java.util.ArrayList;
import org.modelmapper.PropertyMap;
import java.util.stream.Collectors;

/**
 * Created by nzh-dev on 16/10/2019.
 */
public class CodeEntityMapper extends AbstractMapper {

    public CodeEntityMapper() {
        /**
         * Mapping for CodeEntity
         */
        getMapper().addMappings(new PropertyMap<CodeEntity, Code>() {
            @Override
            protected void configure() {
                map(source.getValueId()).setValueId(null);
                map(source.getValueText()).setValue(null);
                map(source.getSetId()).setSetId(null);
                map(source.getSetName()).setSetName(null);
            }
        });
    }

    /**
     * Map CodeEntity to Code
     */
    public Code map(CodeEntity source) {
        Code code = getMapper().map(source, Code.class);
        code.setParentValueIds(source.getParentCodeRelationsByValueId().stream()
                .map(CodeRelationEntity::getParentValueId)
                .collect(Collectors.toList()));
        return code;
    }

}

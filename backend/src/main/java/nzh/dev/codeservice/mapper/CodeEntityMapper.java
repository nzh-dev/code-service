package nzh.dev.codeservice.mapper;

import nzh.dev.codeservice.model.Code;
import nzh.domain.CodeEntity;
import org.modelmapper.PropertyMap;

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
                map(source.getValueId()).setId(null);
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
        return getMapper().map(source, Code.class);
    }

}

package nzh.dev.codeservice.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * Created by nzh-dev on 16/10/2019.
 */
public abstract class AbstractMapper {
    public ModelMapper modelMapper;

    public AbstractMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper getMapper() {
        return modelMapper;
    }

}


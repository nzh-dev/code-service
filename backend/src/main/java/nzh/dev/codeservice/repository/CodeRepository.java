package nzh.dev.codeservice.repository;

import nzh.domain.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nzh-dev on 05/10/2019.
 */
@Repository
public interface CodeRepository extends JpaRepository<CodeEntity, Integer> {
    List<CodeEntity> findBySetId(Integer setId);
}
package com.ot.backend.repository.translate;

import com.ot.backend.po.Translate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranslateRepository extends CrudRepository<Translate, Long> {
    Optional<Translate> findById(Long id);
    Translate findByQuery(String query);
}

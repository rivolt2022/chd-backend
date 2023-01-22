package com.ot.backend.repository.translate;

import com.ot.backend.po.Translate;
import com.ot.backend.repository.CustomRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranslateRepository extends CustomRepository<Translate, Long> {
    Optional<Translate> findById(Long id);
    Translate findByQuery(String query);
    void deleteById(Long id);
}

package com.ot.backend.repository.translate;

import com.ot.backend.po.Translate;
import com.ot.backend.repository.CustomRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TranslateRepository extends CustomRepository<Translate, Long> {

    @Query("SELECT t FROM Translate t WHERE t.query LIKE %:query%")
    List<Translate> findByQueryContaining(String query);

    @Modifying
    @Query("DELETE FROM Translate t WHERE t.id = :id")
    void deleteById(Long id);

}

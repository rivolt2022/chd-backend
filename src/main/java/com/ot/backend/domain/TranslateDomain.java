package com.ot.backend.domain;

import com.ot.backend.component.Transformer;
import com.ot.backend.controller.params.TranslateParam;
import com.ot.backend.po.Translate;
import com.ot.backend.repository.CustomRepository;
import com.ot.backend.repository.translate.TranslateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TranslateDomain extends BaseDomain<Translate, Long> {

    private final TranslateRepository translateRepository;

    @Transactional
    public Translate create(TranslateParam param) throws Exception {
//        Translate translate = new Translate(param.getQuery(), param.getTranslation());
        Translate translate = Translate.builder()
                .query(param.getQuery())
                .translation(param.getTranslation())
                .build();
        return super.create(Translate.class, translate);
    }

    public Translate findById(Long id) {
        Translate translate = translateRepository.findById(id).orElse(null);
        if (translate != null) {
            return translate;
        }
        return null;
    }

    public List<Translate> findByQuery(String query) {
        List<Translate> translate = translateRepository.findByQuery(query);
        if (translate != null) {
            return translate;
        }
        return null;
    }

    public void deleteById(Long id) {
        translateRepository.deleteById(id);
    }

    public Translate save(Translate currentTranslate) {
        return translateRepository.save(currentTranslate);
    }

    public TranslateDomain(CustomRepository<Translate, Long> repository, Transformer transformer,
                           TranslateRepository translateRepository) {
        super(repository, transformer);
        this.translateRepository = translateRepository;
    }

}

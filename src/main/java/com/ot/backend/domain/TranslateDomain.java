package com.ot.backend.domain;

import com.ot.backend.component.Transformer;
import com.ot.backend.controller.params.TranslateParam;
import com.ot.backend.po.Translate;
import com.ot.backend.repository.CustomRepository;
import com.ot.backend.repository.translate.TranslateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TranslateDomain extends BaseDomain<Translate, Long> {

    private final TranslateRepository translateRepository;

    @Transactional
    public Translate create(TranslateParam param) throws Exception {
        Translate translate = new Translate();
        translate.setQuery(param.getQuery());
        return super.create(Translate.class, translate);
    }

    public String findById(Long id) {
        Translate translate = translateRepository.findById(id).orElse(null);
        if(translate!=null) {
            return translate.getQuery();
        }
        return null;
    }

    public String findByQuery(String query) {
        Translate translate = translateRepository.findByQuery(query);
        if(translate!=null) {
            return translate. getQuery();
        }
        return null;
    }

    public TranslateDomain(CustomRepository<Translate, Long> repository, Transformer transformer,
                        TranslateRepository translateRepository) {
        super(repository, transformer);
        this.translateRepository = translateRepository;
    }

}

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
        Translate translate = Translate.builder()
                .query(param.getQuery())
                .translation(param.getTranslation())
                .answer(param.getAnswer())
                .answerTranslation(param.getAnswerTranslation())
                .build();
        return super.create(Translate.class, translate);
    }

    @Transactional(readOnly = true)
    public Translate findById(Long id) {
        return translateRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Translate> findByQuery(String query) {
        return translateRepository.findByQueryContaining(query);
    }

    @Transactional
    public void deleteById(Long id) {
        translateRepository.deleteById(id);
    }

    @Transactional
    public Translate update(Translate currentTranslate, Translate updatedTranslate) {
        currentTranslate.setQuery(updatedTranslate.getQuery());
        currentTranslate.setTranslation(updatedTranslate.getTranslation());
        currentTranslate.setAnswer(updatedTranslate.getAnswer());
        currentTranslate.setAnswerTranslation(updatedTranslate.getAnswerTranslation());
        return translateRepository.save(currentTranslate);
    }

    public TranslateDomain(CustomRepository<Translate, Long> repository, Transformer transformer,
                           TranslateRepository translateRepository) {
        super(repository, transformer);
        this.translateRepository = translateRepository;
    }

}

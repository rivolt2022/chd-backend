package com.ot.backend.domain;

import com.ot.backend.component.Transformer;
import com.ot.backend.controller.params.MemberParam;
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
        return super.createByPO(Translate.class, resourceParam2PO(param, new Translate()));
    }

    public TranslateDomain(CustomRepository<Translate, Long> repository, Transformer transformer,
                        TranslateRepository translateRepository) {
        super(repository, transformer);
        this.translateRepository = translateRepository;
    }

    private Translate resourceParam2PO(TranslateParam param, Translate translate)
            throws Exception {
        return transformer.param2PO(getClassT(), param, translate);
    }
}

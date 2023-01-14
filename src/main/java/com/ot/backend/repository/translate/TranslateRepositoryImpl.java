package com.ot.backend.repository.translate;

import com.ot.backend.po.Translate;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class TranslateRepositoryImpl extends QuerydslRepositorySupport implements TranslateRepositoryCustom {

    public TranslateRepositoryImpl() {
        super(Translate.class);
    }
}

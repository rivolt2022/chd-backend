package com.ot.backend.listener;

import com.ot.backend.constants.CommonsConstant;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;

import javax.persistence.PrePersist;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Objects;

public class PersistentListener {

    @PrePersist
    public void onCreate(Object object) {
        final String ID = "id";
        final String CREATED_AT = "created_at";
        final String UPDATED_AT = "updated_at";
        BeanUtilsBean beanUtilsBean = BeanUtilsBean2.getInstance();
        try {
            if (Objects.equals(beanUtilsBean.getProperty(object, ID), CommonsConstant.ZERO)) {
                beanUtilsBean.setProperty(object, CREATED_AT, LocalDateTime.now());
                beanUtilsBean.setProperty(object, UPDATED_AT, LocalDateTime.now());
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ignore) {}
    }
}

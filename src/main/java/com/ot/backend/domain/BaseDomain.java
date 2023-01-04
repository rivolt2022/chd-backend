package com.ot.backend.domain;

import com.ot.backend.component.Transformer;
import com.ot.backend.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public abstract class BaseDomain<T, ID extends Serializable> {

    private final CustomRepository<T, ID> repository;
    protected final Transformer transformer;

    @Autowired
    public BaseDomain(CustomRepository<T, ID> repository, Transformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }


    /**
     * Create <T> by param.
     *
     * @param voType      VO of some class
     * @param inputParam  input param
     * @param <VO>        VO extends to ResultVO
     * @return VO
     */
    @Transactional
    public <VO> VO create(Class<VO> voType, Object inputParam)
            throws Exception {
        T po = transformer.param2PO(getClassT(), inputParam, getClassT().newInstance());
        return createByPO(voType, po);
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getClassT() throws Exception {
        Type type = getClass().getGenericSuperclass();
        return (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

    @Transactional
    public <VO> VO createByPO(Class<VO> voType, T inputPO) throws Exception {
        return transformer.po2VO(voType, createByPO(inputPO));
    }

    @Transactional public T createByPO(T inputPO) throws Exception {
        return repository.save(inputPO);
    }
}

package com.ot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable>
        extends JpaSpecificationExecutor<T>, JpaRepository<T, ID> {

}

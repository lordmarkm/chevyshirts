package com.chevyshirts.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.chevyshirts.model.BaseEntity;

/**
 * 
 * @author Mark Martinez, created Nov 29, 2015
 *
 */
@NoRepositoryBean
public interface TyraelJpaService<E extends BaseEntity>
    extends JpaRepository<E, Long>, QueryDslPredicateExecutor<E> {

}

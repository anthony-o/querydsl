/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.hql.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author tiwe
 *
 */
public class DefaultSessionHolder implements JPASessionHolder{

    private final EntityManager entityManager;
    
    public DefaultSessionHolder(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public Query createQuery(String queryString) {
        return entityManager.createQuery(queryString);
    }

}
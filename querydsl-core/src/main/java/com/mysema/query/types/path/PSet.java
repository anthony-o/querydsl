/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.types.path;

import java.util.Set;

import com.mysema.commons.lang.Assert;
import com.mysema.query.types.Visitor;
import com.mysema.query.types.expr.EBoolean;
import com.mysema.query.types.expr.ECollectionBase;
import com.mysema.query.types.expr.Expr;
import com.mysema.query.util.NotEmpty;

/**
 * PSet represents set paths
 * 
 * @author tiwe
 * 
 * @param <E> component type
 */
@SuppressWarnings("serial")
public class PSet<E> extends ECollectionBase<Set<E>,E> implements Path<Set<E>> {
    
    private final Class<E> elementType;
    
    private final String entityName;
    
    private final Path<Set<E>> pathMixin;
    
    @SuppressWarnings("unchecked")
    public PSet(Class<? super E> type, @NotEmpty String entityName, PathMetadata<?> metadata) {
        super((Class)Set.class);
        this.elementType = (Class<E>) Assert.notNull(type,"type is null");        
        this.entityName = Assert.notNull(entityName,"entityName is null");
        this.pathMixin = new PathMixin<Set<E>>(this, metadata);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);        
    }

    @Override
    public Expr<Set<E>> asExpr() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return pathMixin.equals(o);
    }
    
    @Override
    public Class<E> getElementType() {
        return elementType;
    }
    
    /**
     * Get the entity name for this Entity collection path
     * 
     * @return
     */
    public String getEntityName() {
        return entityName;
    }
    
    @Override
    public PathMetadata<?> getMetadata() {
        return pathMixin.getMetadata();
    }

    @Override
    public Path<?> getRoot() {
        return pathMixin.getRoot();
    }

    @Override
    public int hashCode() {
        return pathMixin.hashCode();
    }

    @Override
    public EBoolean isNotNull() {
        return pathMixin.isNotNull();
    }
    
    @Override
    public EBoolean isNull() {
        return pathMixin.isNull();
    }

}
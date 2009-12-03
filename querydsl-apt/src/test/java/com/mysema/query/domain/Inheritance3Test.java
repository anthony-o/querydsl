package com.mysema.query.domain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import com.mysema.query.annotations.QueryEntity;
import com.mysema.query.types.path.PComparable;
import com.mysema.query.types.path.PSimple;
import com.mysema.query.types.path.PString;

public class Inheritance3Test extends AbstractTest{
    
    /*
     * TODO : map type variables to BeanModels 
     */
    
    @QueryEntity
    public class GenericSupertype<A>{
        A field;
        Collection<A> fieldCol;        
        Set<A> fieldSet;
        List<A> fieldList;
        Map<String,A> fieldMap1;
        Map<A,String> fieldMap2;
        
        String stringField;                
    }
    
    @QueryEntity
    public class GenericSupertypeC<D extends Comparable<D>> extends GenericSupertype<D>{
    
    }
        
    @QueryEntity
    public class GenericSupertypeS extends GenericSupertypeC<String>{
    
    }
    
    @Test
    @Ignore
    public void test() throws SecurityException, NoSuchFieldException{
        // FIXME
        cl = QGenericSupertype.class;
        match(PSimple.class, "field");
        
        cl = QGenericSupertypeC.class;
        match(PComparable.class, "field");
        
        cl = QGenericSupertypeS.class;
        match(PString.class, "field");
    }

}
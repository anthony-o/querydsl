/*
 * Copyright 2011, Mysema Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mysema.query.collections;

import java.util.Arrays;
import java.util.Collection;

import com.mysema.query.alias.Alias;
import com.mysema.query.types.Path;

/**
 * MiniApi provides static convenience methods for query construction
 *
 * @author tiwe
 */
public final class MiniApi {

    /**
     * Create a new delete clause 
     * 
     * @param path source expression
     * @param col source collection
     * @return
     */
    public static <A> ColDeleteClause<A> delete(Path<A> path, Collection<A> col) {
        return new ColDeleteClause<A>(path, col);
    }

    /**
     * Create a new query
     * 
     * @param alias source alias
     * @param col source collection
     * @return
     */
    public static <A> ColQuery from(A alias, Iterable<A> col) {
        return new ColQueryImpl().from(Alias.$(alias), col);
    }

    /**
     * Create a new query
     * 
     * @param path source expression
     * @param arr source array
     * @return
     */
    public static <A> ColQuery from(Path<A> path, A... arr) {
        return new ColQueryImpl().from(path, Arrays.asList(arr));
    }

    /**
     * Create a new query
     * 
     * @param path source expression
     * @param col source collection
     * @return
     */
    public static <A> ColQuery from(Path<A> path, Iterable<A> col) {
        return new ColQueryImpl().from(path, col);
    }

    /**
     * Create a new update clause
     * 
     * @param path source expression
     * @param col source collection
     * @return
     */
    public static <A> ColUpdateClause<A> update(Path<A> path, Iterable<A> col) {
        return new ColUpdateClause<A>(path, col);
    }

    private MiniApi() {}

}

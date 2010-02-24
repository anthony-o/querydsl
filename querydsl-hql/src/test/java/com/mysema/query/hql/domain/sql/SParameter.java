package com.mysema.query.hql.domain.sql;

import com.mysema.query.types.path.*;
import static com.mysema.query.types.path.PathMetadataFactory.*;
import com.mysema.query.types.expr.*;
import com.mysema.query.types.custom.*;

/**
 * SParameter is a Querydsl query type for SParameter
 */
@SuppressWarnings("serial")
@com.mysema.query.sql.Table(value="PARAMETER")
public class SParameter extends PEntity<SParameter> {

    public final PNumber<Long> id = createNumber("ID", Long.class);

    public SParameter(String variable) {
        super(SParameter.class, forVariable(variable));
    }

    public SParameter(PEntity<? extends SParameter> entity) {
        super(entity.getType(),entity.getMetadata());
    }

    public SParameter(PathMetadata<?> metadata) {
        super(SParameter.class, metadata);
    }

    public Expr<Object[]> all() {
        return CSimple.create(Object[].class, "{0}.*", this);
    }

}

package com.carbonsql.core.domain.tuple;

import com.carbonsql.core.types.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tuple {
    private String name;

    private Type type;

    public Tuple(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}

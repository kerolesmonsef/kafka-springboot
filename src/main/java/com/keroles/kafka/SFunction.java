package com.keroles.kafka;

public interface SFunction<V, R> {
    public R apply(V v);

    default <T> SFunction<V, T> andThen(SFunction<R, T> after) {
        return (V v) -> after.apply(this.apply(v));
    }
}

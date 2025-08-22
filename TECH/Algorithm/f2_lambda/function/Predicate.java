package com.mc.algorithm.f2_lambda.function;

@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}

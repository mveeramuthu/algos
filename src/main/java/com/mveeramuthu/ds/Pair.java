package com.mveeramuthu.ds;

public class Pair<N, V> {
    private final N first;
    private final V second;

    public Pair(N first, V second) {
        this.first = first;
        this.second = second;
    }

    public N getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static <N, V> Pair<N, V> pair(N name, V value) {
        return new Pair<>(name, value);
    }
    
    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}

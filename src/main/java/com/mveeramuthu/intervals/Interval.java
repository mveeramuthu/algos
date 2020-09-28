package com.mveeramuthu.intervals;

public class Interval {
    int start;
    int end;
    
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

package com.testproject.graphs;

import java.util.List;

public class TestUtils {
    public static <T> boolean equals(List<T> first, List<T> second) {
        return first.containsAll(second) && second.containsAll(first);
    }
}

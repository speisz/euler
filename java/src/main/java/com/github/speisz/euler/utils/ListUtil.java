package com.github.speisz.euler.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListUtil {
    public static <T> T getLastElement(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static List<Integer> copy(List<Integer> initial, Consumer<List<Integer>> transformation) {
        ArrayList<Integer> copied = new ArrayList<>(initial);
        transformation.accept(copied);
        return copied;
    }
}

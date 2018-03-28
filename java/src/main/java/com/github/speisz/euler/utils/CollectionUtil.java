package com.github.speisz.euler.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class CollectionUtil {
    public static <K, V> Map<K, V> hashMapOf(K key, V value) {
        return new HashMap<K, V>() {{
            put(key, value);
        }};
    }

    public static <K, V> List<Map<K, V>> crossMergeMaps(List<Map<K, V>> mapsToMerge, List<Map<K, V>> mapsToBeMergedInto) {
        return mapsToMerge.stream()
                .map(map -> mergeToAllOf(map, mapsToBeMergedInto))
                .flatMap(Collection::stream)
                .collect(toList());
    }

    private static <K, V> List<Map<K, V>> mergeToAllOf(Map<K, V> mapToMerge, List<Map<K, V>> mapsToBeMergedInto) {
        return mapsToBeMergedInto.stream()
                .map(map -> merge(map, mapToMerge))
                .collect(toList());
    }

    @SafeVarargs
    private static <K, V> Map<K, V> merge(Map<K, V> first, Map<K, V>... others) {
        HashMap<K, V> mergedMap = new HashMap<>(first);
        Stream.of(others).forEach(mergedMap::putAll);
        return mergedMap;
    }

    private CollectionUtil() {
    }
}

package com.marcelo.lotteryfx.models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Results {

    private static final Set<Set<Integer>> resultList = new LinkedHashSet<>();

    public static Set<Set<Integer>> getResultList() {
        return resultList;
    }

    public static void setResultList(Set<Integer> resultList) {
        Results.resultList.add(resultList);
    }
}

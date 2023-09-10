package com.marcelo.lotteryfx;

import java.util.HashSet;
import java.util.Set;

public class Results {

    private static final Set<Set<Integer>> resultList = new HashSet<>();

    public static Set<Set<Integer>> getResultList() {
        return resultList;
    }

    public static void setResultList(Set<Integer> resultList) {
        Results.resultList.add(resultList);
    }
}

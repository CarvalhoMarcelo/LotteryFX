package com.marcelo.lotteryfx.models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Bets {

    private static final Set<Set<Integer>> betList = new LinkedHashSet<>();

    public static Set<Set<Integer>> getBetList() {
        return betList;
    }

    public static void setBetList(Set<Integer> betList) {
        Bets.betList.add(betList);
    }

}

package model;

import java.util.Map;

public class ResultTemplate {
    private Map<Integer,Integer> resultMap;
    private double yield;

    public ResultTemplate(Map<Integer, Integer> resultMap, double yield) {
        this.resultMap = resultMap;
        this.yield = yield;
    }
}

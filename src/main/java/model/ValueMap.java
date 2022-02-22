package model;

import java.util.HashMap;
import java.util.Map;

public class ValueMap {
    public static Map<Integer, Long> valueMap = new HashMap<>();

    static {
        valueMap.put(3, 5000L);
        valueMap.put(4, 50000L);
        valueMap.put(5, 1500000L);
        valueMap.put(6, 2000000000L);
    }
}

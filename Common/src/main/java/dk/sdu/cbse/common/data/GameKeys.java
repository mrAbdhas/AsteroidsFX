package dk.sdu.cbse.common.data;

import java.util.HashMap;
import java.util.Map;

public class GameKeys {

    public static final String UP = "UP";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final String SPACE = "SPACE";

    private final Map<String, Boolean> keys = new HashMap<>();

    public void setKey(String key, boolean value) {
        keys.put(key, value);
    }

    public boolean isDown(String key) {
        return keys.getOrDefault(key, false);
    }
}

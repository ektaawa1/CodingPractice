package premiumPract;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    Map<String, Integer> messageMap;
    public LoggerRateLimiter() {
        messageMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!messageMap.containsKey(message)){
            messageMap.put(message, timestamp);
            return true;
        }
        if(timestamp-messageMap.get(message)>=10){
            messageMap.put(message,timestamp);
            return true;
        }
        return false;
    }
}
/**
 * | Operation            | Complexity                           |
 * | -------------------- | ------------------------------------ |
 * | `shouldPrintMessage` | **O(1)**                             |
 * | Space                | **O(n)** (number of unique messages) |
 */

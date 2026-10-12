import java.util.HashMap;

public class LogAnalyzer {
    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] logs = {
            "ERROR: Database connection failed",
            "INFO: User logged in",
            "ERROR: Database connection failed",
            "WARNING: Disk space is low",
            "INFO: User logged out",
            "ERROR: Invalid password",
            "WARNING: Disk space is low",
            "ERROR: Database connection failed",
            "INFO: User logged in",
            "ERROR: Invalid password"
        };

        for(String log : logs){
            String logType = log.split(":")[0];
            int count = hashMap.getOrDefault(logType, 0);
            hashMap.put(logType, count + 1);
        }

        System.out.println(hashMap);
    }
}

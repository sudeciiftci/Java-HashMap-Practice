import java.util.HashMap;

public class HashMapPractice{
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<>();

        grades.put("Sude", 80);
        grades.put("Arda", 85);
        grades.put("Kerem", 90);

        System.out.println(grades.get("Sude"));

        grades.put("Sude", 95);

        System.out.println(grades.get("Sude"));


    }
}
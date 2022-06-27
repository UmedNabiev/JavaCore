package Lesson4;

import java.util.*;

public class Task1 {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "Eagle", "Parrot", "Dove", "Raven", "Peacock",
                "Hawk", "Flamingo", "Seagull", "Parrot", "Raven",
                "Flamingo", "Raven", "Hawk", "Chicken", "Parrot",
                "Raven", "Hawk", "Flamingo", "Seagull", "Chicken"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Initial array");
        System.out.println(words.toString());
        System.out.println("-----------------");
        System.out.println("Unique words");
        System.out.println(unique.toString());
        System.out.println("-----------------");
        System.out.println("Word frequency");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}

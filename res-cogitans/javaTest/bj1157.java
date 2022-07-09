package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// public class Main{
public class Backjoon {
    
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String input = br.readLine();
        String input = "Mississipi"; 
        char[] charArray = input.toCharArray();

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : charArray) {
            if(countMap.get(c) == null) {
                countMap.put(c, 1);
            }
            else {
                Integer previous = countMap.get(c);
                countMap.put(c, ++previous);
            }
        }

        char previousChar = '?';
        int previous = 0;
        Set<Entry<Character, Integer>> entrySet = countMap.entrySet();
        for (Entry<Character,Integer> entry : entrySet) {
            if (entry.getValue() > previous) {
                previous = entry.getValue();
                previousChar = entry.getKey();
            }
            else if (entry.getValue() == previous){
                previousChar = '?';
            }
        }

        System.out.println(Character.toUpperCase(previousChar));
    }
}
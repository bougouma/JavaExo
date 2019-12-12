package com.company;
import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static  void getFileContent(Map<String, Integer> map) {
        String filePath = "notes.txt";
        String line;
        File f = new File(filePath);
        if(f.exists() && f.isFile() && f.canRead()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":", 2);
                    if (parts.length >= 2) {
                        String key = parts[0];
                        Integer value = Integer.valueOf(parts[1]);
                        map.put(key, value);
                    } else {
                        System.out.println("ignoring line: " + line);
                    }
                }
                reader.close();
                System.out.println("---File content---");
                for (String key : map.keySet()) {
                    System.out.println(key + ":" + map.get(key));
                }

            }  catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void getAverage(Map<String, Integer> map)
    {
        double average;
        System.out.println("--average");
        ArrayList <Integer> listStudent = new ArrayList <Integer> (map.values());
        double total = 0;
        for (Integer note : listStudent) {
            total += note;
        }
        if(listStudent.size() !=0) {
            average = total / listStudent.size();
            System.out.println("average :" + average);
        }

    }
    public static void getPoint(Map<String, Integer> map, String name)
    {
        System.out.println("---Notes of " + name +"---");
        if(map.containsKey(name)) System.out.println("Nom : " +name + " - note :" + map.get(name));
        else System.out.println("This student does not exist");

    }
    public static void main(String[] args) {
        Instant start = Instant.now() ;
        HashMap<String, Integer> map = new HashMap<>();
        getFileContent(map);
        getPoint(map, "Sarah");
        getAverage(map);
        map.clear();
        Duration duration = Duration.between(start, Instant.now()) ;
        //long milis = ChronoUnit.MILLIS.between(start, Instant.now());
        System.out.println("---Duration of execution---");
        System.out.println(duration);
    }
}



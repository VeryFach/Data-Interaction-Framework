package com.mycompany.projekbasdat;

import java.util.LinkedList;
import java.util.*;

public class TemporaryData {
    private static TemporaryData instance;
    private Queue<String> stored;

    private TemporaryData() {
        stored = new LinkedList<>();
    }

    public static TemporaryData getInstance() {
        if (instance == null) {
            instance = new TemporaryData();
        }
        return instance;
    }

    public void add(String data) {
        stored.offer(data);
    }

    public String poll() {
        return stored.poll();
    }

    public void display() {
        if (stored.isEmpty()) {
            System.out.println("KOSONG");
        } else {
            for (String string : stored) {
                System.out.println(string);
            }
        }
    }

    public void deleteAll() {
        System.out.println("Clearing all data");
        stored.clear();
    }
}

package com.babu.problems;

import java.util.*;

public class LogParser {

    public static void main(String[] args) {
        List<String> logs = List.of(
                "2024-03-22T12:00:00Z,user1,LOGIN",
                "2024-03-22T12:05:00Z,user2,LOGIN",
                "2024-03-22T12:10:00Z,user1,LOGOUT",
                "2024-03-22T12:15:00Z,user2,LOGIN"
        );
        Map<String, Set<String>> actionMap = new HashMap<>();
        for (String log : logs) {
            String[] items = log.split(",");
            String action = items[2];
            String user = items[1];
            actionMap.putIfAbsent(action, new HashSet<>());
            actionMap.get(action).add(user);
        }
        System.out.println("LOGIN:" + actionMap.get("LOGIN").size() + "unique users");
        System.out.println("LOGOUT:" + actionMap.get("LOGOUT").size() + "unique users");
    }
}

package com.babu.problems;

import java.util.*;

public class RateLimiter {
    private final int maxRequests; // N: Max requests allowed
    private final int timeWindow; // T: Time window in seconds
    private final Map<String, Deque<Long>> userRequests; // User request history

    public RateLimiter(int maxRequests, int timeWindow) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindow;
        this.userRequests = new HashMap<>();
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis() / 1000; // Convert to seconds
        userRequests.putIfAbsent(userId, new LinkedList<>());

        Deque<Long> timestamps = userRequests.get(userId);

        // Remove old requests outside the time window
        while (!timestamps.isEmpty() && timestamps.peekFirst() <= currentTime - timeWindow) {
            timestamps.pollFirst();
        }

        // Check if we can allow a new request
        if (timestamps.size() < maxRequests) {
            timestamps.offerLast(currentTime); // Add new request timestamp
            return true; // Request allowed
        }

        return false; // Request denied
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(3, 10); // Allow 3 requests per 10 seconds

        System.out.println(rateLimiter.allowRequest("user1")); // true
        System.out.println(rateLimiter.allowRequest("user1")); // true
        System.out.println(rateLimiter.allowRequest("user1")); // true
        System.out.println(rateLimiter.allowRequest("user1")); // false (4th request blocked)

        Thread.sleep(11000); // Wait for 11 seconds (exceeding the time window)
        System.out.println(rateLimiter.allowRequest("user1")); // true (since old requests expired)
    }
}

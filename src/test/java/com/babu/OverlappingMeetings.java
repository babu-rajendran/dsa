package com.babu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingMeetings {
    public static void main(String[] args) {
        int[][] meetings = {
                {1, 5}, {2, 6}, {8, 10}, {9, 12}
        };
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> overlaps = new ArrayList<>();
        int[] currentInterval = meetings[0];
        for (int[] meeting : meetings) {

        }
    }
}

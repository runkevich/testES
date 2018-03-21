package com.runkevich8.gmail.test.homework.hw6;

import java.util.Comparator;

public class SortByPrice implements Comparator<Schedule> {
    @Override
    public int compare(Schedule o1, Schedule o2) {
        int str1 = o1.getPrice();
        int str2 = o2.getPrice();

        if(str1 > str2) {
            return 1;
        }
        else if(str1 < str2) {
            return -1;
        }
        else {
            return 0;
        }

    }
}

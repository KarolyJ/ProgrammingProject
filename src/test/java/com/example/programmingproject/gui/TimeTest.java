package com.example.programmingproject.gui;

import com.example.programmingproject.objects.Time;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TimeTest {

    @Test
    public void testTime() {
        Time time1 = new Time(0, 0, 0);
        Time time2 = new Time("0:0:0");
        String string = time1.getCurrentTime();
        assertTrue(string.contains("0:0:0"));
        assertEquals(time1, time2);
    }

    @Test
    public void testOneSecondPast() {
        Time time = new Time(0, 0, 0);
        Time time1 = new Time(0,0,1);
        time.oneSecondPassed();
        assertEquals(time, time1);
    }


}

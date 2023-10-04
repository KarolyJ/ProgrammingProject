package com.example.programmingproject.gui;

import com.example.programmingproject.gui.holders.DifficultyHolder;
import com.example.programmingproject.gui.holders.TimerHolder;
import com.example.programmingproject.objects.Time;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HolderTest {

    @Test
    public void testDifficultyHolder() {
        DifficultyHolder holder = DifficultyHolder.getInstance();
        holder.setDifficulty(10);
        assertEquals(10, holder.getDifficulty());
    }
    @Test
    public void testTimerHolder() {
        TimerHolder holder = TimerHolder.getInstance();
        holder.setTime(new Time(10,10,10));
        assertEquals(holder.getTime(), new Time("10:10:10"));
    }
}

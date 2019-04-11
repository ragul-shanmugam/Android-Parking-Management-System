package com.example.myapplication1.com.cse5324.team6.util;

import java.sql.Date;
import java.sql.Time;

public class ReservationDetails {

    public int pid;
    public Date date;
    public Time startTime;
    public int duration = 0;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

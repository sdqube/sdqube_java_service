package com.sdqube.service.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:34 AM
 */
public class SDQubeDate {
    private DateTime dateTime;

    public SDQubeDate() {
        dateTime = new DateTime(DateTimeZone.UTC);
    }
    public long getTimestamp() {
        return this.dateTime.getMillis();
    }

    public static long timestamp() {
        try {
            return System.currentTimeMillis();
        } catch (UnsatisfiedLinkError ignore) {
            return System.currentTimeMillis();
        }
    }
}

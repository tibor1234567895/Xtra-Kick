package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference f3743a = new AtomicReference();

    private c0() {
    }

    public static DateFormat a(String str, Locale locale) {
        DateFormat g10 = DateFormat.getInstanceForSkeleton(str, locale);
        g10.setTimeZone(TimeZone.getTimeZone("UTC"));
        g10.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return g10;
    }

    public static Calendar b(Calendar calendar) {
        Calendar d10 = d(calendar);
        Calendar d11 = d((Calendar) null);
        d11.set(d10.get(1), d10.get(2), d10.get(5));
        return d11;
    }

    public static Calendar c() {
        b0 b0Var = (b0) f3743a.get();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return instance;
    }

    public static Calendar d(Calendar calendar) {
        Calendar instance = Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }
}

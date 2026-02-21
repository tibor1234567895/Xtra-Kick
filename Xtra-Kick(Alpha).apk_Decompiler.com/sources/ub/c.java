package ub;

import java.text.SimpleDateFormat;
import java.util.Locale;
import qb.h;

public final class c extends ThreadLocal {
    public final Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(h.f13494b);
        return simpleDateFormat;
    }
}

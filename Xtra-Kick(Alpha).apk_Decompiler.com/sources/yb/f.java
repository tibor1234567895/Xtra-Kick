package yb;

import android.util.Log;
import fb.a0;
import fb.y;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import xa.j;

public final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final f f17305a = new f();

    private f() {
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final void publish(LogRecord logRecord) {
        int i10;
        int min;
        j.f("record", logRecord);
        e eVar = e.f17302a;
        String loggerName = logRecord.getLoggerName();
        j.e("record.loggerName", loggerName);
        if (logRecord.getLevel().intValue() > Level.INFO.intValue()) {
            i10 = 5;
        } else if (logRecord.getLevel().intValue() == Level.INFO.intValue()) {
            i10 = 4;
        } else {
            i10 = 3;
        }
        String message = logRecord.getMessage();
        j.e("record.message", message);
        Throwable thrown = logRecord.getThrown();
        eVar.getClass();
        String str = (String) e.f17304c.get(loggerName);
        if (str == null) {
            str = a0.S(23, loggerName);
        }
        if (Log.isLoggable(str, i10)) {
            if (thrown != null) {
                message = message + 10 + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i11 = 0;
            while (i11 < length) {
                int t10 = y.t(message, 10, i11, false, 4);
                if (t10 == -1) {
                    t10 = length;
                }
                while (true) {
                    min = Math.min(t10, i11 + 4000);
                    String substring = message.substring(i11, min);
                    j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                    Log.println(i10, str, substring);
                    if (min >= t10) {
                        break;
                    }
                    i11 = min;
                }
                i11 = min + 1;
            }
        }
    }
}

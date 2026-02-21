package f0;

import android.app.NotificationChannel;

public abstract /* synthetic */ class g {
    public static /* synthetic */ NotificationChannel c(String str, CharSequence charSequence) {
        return new NotificationChannel(str, charSequence, 2);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void r() {
        /*
            android.app.NotificationChannel r0 = new android.app.NotificationChannel
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.g.r():void");
    }
}

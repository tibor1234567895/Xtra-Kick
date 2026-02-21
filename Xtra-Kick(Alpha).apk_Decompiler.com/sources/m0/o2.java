package m0;

import android.util.CloseGuard;

public abstract /* synthetic */ class o2 {
    public static /* synthetic */ CloseGuard c() {
        return new CloseGuard();
    }

    public static /* bridge */ /* synthetic */ CloseGuard d(Object obj) {
        return (CloseGuard) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void h() {
        /*
            android.util.CloseGuard r0 = new android.util.CloseGuard
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.o2.h():void");
    }
}

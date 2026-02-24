package q0;

import android.media.audiofx.DynamicsProcessing;

public abstract /* synthetic */ class x {
    public static /* synthetic */ DynamicsProcessing f(int i10) {
        return new DynamicsProcessing(0, i10, (DynamicsProcessing.Config) null);
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
            android.media.audiofx.DynamicsProcessing r0 = new android.media.audiofx.DynamicsProcessing
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.x.h():void");
    }
}

package s1;

import android.media.MediaCodecInfo;

public abstract /* synthetic */ class o {
    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint b(int i10, int i11, int i12) {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(i10, i11, i12);
    }

    public static /* bridge */ /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint c(Object obj) {
        return (MediaCodecInfo.VideoCapabilities.PerformancePoint) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void f() {
        /*
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r0 = new android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.o.f():void");
    }
}

package m0;

import android.media.AudioFocusRequest;

public abstract /* synthetic */ class r {
    public static /* synthetic */ AudioFocusRequest.Builder e(int i10) {
        return new AudioFocusRequest.Builder(i10);
    }

    public static /* synthetic */ AudioFocusRequest.Builder i(AudioFocusRequest audioFocusRequest) {
        return new AudioFocusRequest.Builder(audioFocusRequest);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void o() {
        /*
            android.media.AudioFocusRequest$Builder r0 = new android.media.AudioFocusRequest$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.r.o():void");
    }
}

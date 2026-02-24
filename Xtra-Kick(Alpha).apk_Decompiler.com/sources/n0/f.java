package n0;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.MediaDrmResetException;
import android.media.PlaybackParams;

public abstract /* synthetic */ class f {
    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void A() {
        /*
            android.media.AudioTrack$Builder r0 = new android.media.AudioTrack$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.f.A():void");
    }

    public static /* bridge */ /* synthetic */ AudioDeviceInfo e(Object obj) {
        return (AudioDeviceInfo) obj;
    }

    public static /* synthetic */ AudioTrack.Builder f() {
        return new AudioTrack.Builder();
    }

    public static /* synthetic */ PlaybackParams l() {
        return new PlaybackParams();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void q() {
        /*
            android.media.PlaybackParams r0 = new android.media.PlaybackParams
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.f.q():void");
    }

    public static /* bridge */ /* synthetic */ boolean t(Object obj) {
        return obj instanceof MediaDrmResetException;
    }

    public static /* bridge */ /* synthetic */ boolean u(Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}

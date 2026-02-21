package b0;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.ClipData;
import android.media.metrics.PlaybackErrorEvent;
import android.view.ContentInfo;

public abstract /* synthetic */ class b0 {
    public static /* bridge */ /* synthetic */ boolean A(Object obj) {
        return obj instanceof ForegroundServiceStartNotAllowedException;
    }

    public static /* synthetic */ PlaybackErrorEvent.Builder g() {
        return new PlaybackErrorEvent.Builder();
    }

    public static /* synthetic */ ContentInfo.Builder l(ClipData clipData, int i10) {
        return new ContentInfo.Builder(clipData, i10);
    }

    public static /* bridge */ /* synthetic */ ContentInfo o(Object obj) {
        return (ContentInfo) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void p() {
        /*
            android.view.ContentInfo$Builder r0 = new android.view.ContentInfo$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.b0.p():void");
    }
}

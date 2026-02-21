package android.support.v4.media.session;

import android.graphics.drawable.AnimatedImageDrawable;
import android.media.session.MediaSessionManager;
import android.text.PrecomputedText;
import android.text.Spannable;

public abstract /* synthetic */ class d0 {
    public static /* bridge */ /* synthetic */ boolean A(Object obj) {
        return obj instanceof AnimatedImageDrawable;
    }

    public static /* bridge */ /* synthetic */ AnimatedImageDrawable l(Object obj) {
        return (AnimatedImageDrawable) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void s() {
        /*
            android.media.session.MediaSessionManager$RemoteUserInfo r0 = new android.media.session.MediaSessionManager$RemoteUserInfo
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.d0.s():void");
    }

    public static /* synthetic */ void y(String str, int i10, int i11) {
        new MediaSessionManager.RemoteUserInfo(str, i10, i11);
    }

    public static /* bridge */ /* synthetic */ boolean z(Spannable spannable) {
        return spannable instanceof PrecomputedText;
    }
}

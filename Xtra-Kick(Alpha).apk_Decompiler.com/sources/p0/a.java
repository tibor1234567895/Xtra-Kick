package p0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

public abstract /* synthetic */ class a {
    public static /* synthetic */ InputContentInfo c(Uri uri, ClipDescription clipDescription, Uri uri2) {
        return new InputContentInfo(uri, clipDescription, uri2);
    }

    public static /* bridge */ /* synthetic */ InputContentInfo d(Object obj) {
        return (InputContentInfo) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void e() {
        /*
            android.view.inputmethod.InputContentInfo r0 = new android.view.inputmethod.InputContentInfo
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.a.e():void");
    }
}

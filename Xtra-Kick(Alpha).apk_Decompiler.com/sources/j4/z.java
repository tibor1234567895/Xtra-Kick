package j4;

import android.graphics.ImageDecoder;
import android.graphics.Rect;
import android.text.PrecomputedText;
import android.text.TextPaint;
import android.view.DisplayCutout;
import java.util.List;

public abstract /* synthetic */ class z {
    public static /* bridge */ /* synthetic */ ImageDecoder.Source e(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* bridge */ /* synthetic */ ImageDecoder f(Object obj) {
        return (ImageDecoder) obj;
    }

    public static /* synthetic */ PrecomputedText.Params.Builder j(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* synthetic */ DisplayCutout n(Rect rect, List list) {
        return new DisplayCutout(rect, list);
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
            android.text.PrecomputedText$Params$Builder r0 = new android.text.PrecomputedText$Params$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.z.p():void");
    }

    public static /* bridge */ /* synthetic */ void u(Object obj) {
        ImageDecoder.Source source = (ImageDecoder.Source) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void y() {
        /*
            android.view.DisplayCutout r0 = new android.view.DisplayCutout
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.z.y():void");
    }
}

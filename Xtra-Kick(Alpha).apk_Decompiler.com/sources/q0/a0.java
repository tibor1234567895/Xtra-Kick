package q0;

import android.graphics.Paint;
import android.os.Build;
import android.view.ActionMode;
import android.widget.TextView;
import l0.f;

public final class a0 {
    private a0() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r9 != 2) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        if (r4 != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        r9 = android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        r9 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static k0.g a(android.widget.TextView r9) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x0010
            k0.g r0 = new k0.g
            android.text.PrecomputedText$Params r9 = q0.y.b(r9)
            r0.<init>(r9)
            return r0
        L_0x0010:
            android.text.TextPaint r2 = new android.text.TextPaint
            android.text.TextPaint r3 = r9.getPaint()
            r2.<init>(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r5 = 23
            r6 = 1
            if (r3 < r5) goto L_0x0024
            r3 = 1
            r7 = 1
            goto L_0x0026
        L_0x0024:
            r3 = 0
            r7 = 0
        L_0x0026:
            android.text.TextDirectionHeuristic r8 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            if (r0 < r5) goto L_0x0032
            int r3 = q0.v.a(r9)
            int r7 = q0.v.d(r9)
        L_0x0032:
            android.text.method.TransformationMethod r5 = r9.getTransformationMethod()
            boolean r5 = r5 instanceof android.text.method.PasswordTransformationMethod
            if (r5 == 0) goto L_0x003d
        L_0x003a:
            android.text.TextDirectionHeuristic r9 = android.text.TextDirectionHeuristics.LTR
            goto L_0x0082
        L_0x003d:
            if (r0 < r1) goto L_0x0064
            int r0 = r9.getInputType()
            r0 = r0 & 15
            r1 = 3
            if (r0 != r1) goto L_0x0064
            java.util.Locale r9 = q0.u.d(r9)
            android.icu.text.DecimalFormatSymbols r9 = q0.w.a(r9)
            java.lang.String[] r9 = q0.y.a(r9)
            r9 = r9[r4]
            int r9 = r9.codePointAt(r4)
            byte r9 = java.lang.Character.getDirectionality(r9)
            if (r9 == r6) goto L_0x007a
            r0 = 2
            if (r9 != r0) goto L_0x003a
            goto L_0x007a
        L_0x0064:
            int r0 = q0.u.b(r9)
            if (r0 != r6) goto L_0x006b
            r4 = 1
        L_0x006b:
            int r9 = q0.u.c(r9)
            switch(r9) {
                case 2: goto L_0x007d;
                case 3: goto L_0x003a;
                case 4: goto L_0x007a;
                case 5: goto L_0x0077;
                case 6: goto L_0x0080;
                case 7: goto L_0x0074;
                default: goto L_0x0072;
            }
        L_0x0072:
            if (r4 == 0) goto L_0x0080
        L_0x0074:
            android.text.TextDirectionHeuristic r9 = android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL
            goto L_0x0082
        L_0x0077:
            android.text.TextDirectionHeuristic r9 = android.text.TextDirectionHeuristics.LOCALE
            goto L_0x0082
        L_0x007a:
            android.text.TextDirectionHeuristic r9 = android.text.TextDirectionHeuristics.RTL
            goto L_0x0082
        L_0x007d:
            android.text.TextDirectionHeuristic r9 = android.text.TextDirectionHeuristics.ANYRTL_LTR
            goto L_0x0082
        L_0x0080:
            android.text.TextDirectionHeuristic r9 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
        L_0x0082:
            k0.g r0 = new k0.g
            r0.<init>(r2, r9, r3, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.a0.a(android.widget.TextView):k0.g");
    }

    public static void b(TextView textView, int i10) {
        f.b(i10);
        if (Build.VERSION.SDK_INT >= 28) {
            y.c(textView, i10);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = t.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), i10 + i11, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void c(TextView textView, int i10) {
        f.b(i10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = t.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i10 - i11);
        }
    }

    public static void d(TextView textView, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i10);
        } else {
            textView.setTextAppearance(textView.getContext(), i10);
        }
    }

    public static ActionMode.Callback e(ActionMode.Callback callback) {
        if (!(callback instanceof z) || Build.VERSION.SDK_INT < 26) {
            return callback;
        }
        return ((z) callback).f13124a;
    }

    public static ActionMode.Callback f(ActionMode.Callback callback, TextView textView) {
        int i10 = Build.VERSION.SDK_INT;
        return (i10 < 26 || i10 > 27 || (callback instanceof z) || callback == null) ? callback : new z(callback, textView);
    }
}

package k0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import j4.z;
import l0.b;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f8951a;

    /* renamed from: b  reason: collision with root package name */
    public final TextDirectionHeuristic f8952b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8953c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8954d;

    public g(PrecomputedText.Params params) {
        this.f8951a = params.getTextPaint();
        this.f8952b = params.getTextDirection();
        this.f8953c = params.getBreakStrategy();
        this.f8954d = params.getHyphenationFrequency();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (g.a0.z(g.a0.h(r5), g.a0.h(r3)) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        if (r3.getTextLocale().equals(r5.getTextLocale()) == false) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof k0.g
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            k0.g r8 = (k0.g) r8
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 < r3) goto L_0x0020
            int r3 = r8.f8953c
            int r4 = r7.f8953c
            if (r4 == r3) goto L_0x0019
            goto L_0x0030
        L_0x0019:
            int r3 = r7.f8954d
            int r4 = r8.f8954d
            if (r3 == r4) goto L_0x0020
            goto L_0x0030
        L_0x0020:
            android.text.TextPaint r3 = r7.f8951a
            float r4 = r3.getTextSize()
            android.text.TextPaint r5 = r8.f8951a
            float r5 = r5.getTextSize()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0033
        L_0x0030:
            r1 = 0
            goto L_0x00b6
        L_0x0033:
            float r4 = r3.getTextScaleX()
            android.text.TextPaint r5 = r8.f8951a
            float r6 = r5.getTextScaleX()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0042
            goto L_0x0030
        L_0x0042:
            float r4 = r3.getTextSkewX()
            float r6 = r5.getTextSkewX()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x004f
            goto L_0x0030
        L_0x004f:
            float r4 = r3.getLetterSpacing()
            float r6 = r5.getLetterSpacing()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            goto L_0x0030
        L_0x005c:
            java.lang.String r4 = r3.getFontFeatureSettings()
            java.lang.String r6 = r5.getFontFeatureSettings()
            boolean r4 = android.text.TextUtils.equals(r4, r6)
            if (r4 != 0) goto L_0x006b
            goto L_0x0030
        L_0x006b:
            int r4 = r3.getFlags()
            int r6 = r5.getFlags()
            if (r4 == r6) goto L_0x0076
            goto L_0x0030
        L_0x0076:
            r4 = 24
            if (r1 < r4) goto L_0x0089
            android.os.LocaleList r1 = r3.getTextLocales()
            android.os.LocaleList r4 = r5.getTextLocales()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0098
            goto L_0x0030
        L_0x0089:
            java.util.Locale r1 = r3.getTextLocale()
            java.util.Locale r4 = r5.getTextLocale()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0098
            goto L_0x0030
        L_0x0098:
            android.graphics.Typeface r1 = r3.getTypeface()
            if (r1 != 0) goto L_0x00a5
            android.graphics.Typeface r1 = r5.getTypeface()
            if (r1 == 0) goto L_0x00b5
            goto L_0x0030
        L_0x00a5:
            android.graphics.Typeface r1 = r3.getTypeface()
            android.graphics.Typeface r3 = r5.getTypeface()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00b5
            goto L_0x0030
        L_0x00b5:
            r1 = 1
        L_0x00b6:
            if (r1 != 0) goto L_0x00b9
            return r2
        L_0x00b9:
            android.text.TextDirectionHeuristic r1 = r7.f8952b
            android.text.TextDirectionHeuristic r8 = r8.f8952b
            if (r1 == r8) goto L_0x00c0
            return r2
        L_0x00c0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = Build.VERSION.SDK_INT;
        int i11 = this.f8954d;
        int i12 = this.f8953c;
        TextDirectionHeuristic textDirectionHeuristic = this.f8952b;
        TextPaint textPaint = this.f8951a;
        if (i10 >= 24) {
            return b.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i12), Integer.valueOf(i11));
        }
        return b.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i12), Integer.valueOf(i11));
    }

    public final String toString() {
        StringBuilder sb2;
        Object textLocale;
        StringBuilder sb3 = new StringBuilder("{");
        StringBuilder sb4 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f8951a;
        sb4.append(textPaint.getTextSize());
        sb3.append(sb4.toString());
        sb3.append(", textScaleX=" + textPaint.getTextScaleX());
        sb3.append(", textSkewX=" + textPaint.getTextSkewX());
        int i10 = Build.VERSION.SDK_INT;
        sb3.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb3.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        if (i10 >= 24) {
            sb2 = new StringBuilder(", textLocale=");
            textLocale = textPaint.getTextLocales();
        } else {
            sb2 = new StringBuilder(", textLocale=");
            textLocale = textPaint.getTextLocale();
        }
        sb2.append(textLocale);
        sb3.append(sb2.toString());
        sb3.append(", typeface=" + textPaint.getTypeface());
        if (i10 >= 26) {
            sb3.append(", variationSettings=" + textPaint.getFontVariationSettings());
        }
        sb3.append(", textDir=" + this.f8952b);
        sb3.append(", breakStrategy=" + this.f8953c);
        sb3.append(", hyphenationFrequency=" + this.f8954d);
        sb3.append("}");
        return sb3.toString();
    }

    public g(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            z.p();
            z.j(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
        }
        this.f8951a = textPaint;
        this.f8952b = textDirectionHeuristic;
        this.f8953c = i10;
        this.f8954d = i11;
    }
}

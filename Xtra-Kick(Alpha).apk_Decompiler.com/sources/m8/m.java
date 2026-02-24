package m8;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

public final class m {

    /* renamed from: m  reason: collision with root package name */
    public static final int f10771m = (Build.VERSION.SDK_INT >= 23 ? 1 : 0);

    /* renamed from: n  reason: collision with root package name */
    public static boolean f10772n;

    /* renamed from: o  reason: collision with root package name */
    public static Constructor f10773o;

    /* renamed from: p  reason: collision with root package name */
    public static TextDirectionHeuristic f10774p;

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f10775a;

    /* renamed from: b  reason: collision with root package name */
    public final TextPaint f10776b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10777c;

    /* renamed from: d  reason: collision with root package name */
    public int f10778d;

    /* renamed from: e  reason: collision with root package name */
    public Layout.Alignment f10779e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public int f10780f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public float f10781g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f10782h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public int f10783i = f10771m;

    /* renamed from: j  reason: collision with root package name */
    public boolean f10784j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10785k;

    /* renamed from: l  reason: collision with root package name */
    public TextUtils.TruncateAt f10786l = null;

    public m(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f10775a = charSequence;
        this.f10776b = textPaint;
        this.f10777c = i10;
        this.f10778d = charSequence.length();
    }

    public final StaticLayout a() {
        boolean z10;
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2;
        if (this.f10775a == null) {
            this.f10775a = "";
        }
        int max = Math.max(0, this.f10777c);
        CharSequence charSequence = this.f10775a;
        int i10 = this.f10780f;
        TextPaint textPaint = this.f10776b;
        if (i10 == 1) {
            charSequence = TextUtils.ellipsize(charSequence, textPaint, (float) max, this.f10786l);
        }
        int min = Math.min(charSequence.length(), this.f10778d);
        this.f10778d = min;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            if (this.f10785k && this.f10780f == 1) {
                this.f10779e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder h10 = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
            h10.setAlignment(this.f10779e);
            h10.setIncludePad(this.f10784j);
            if (this.f10785k) {
                textDirectionHeuristic2 = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic2 = TextDirectionHeuristics.LTR;
            }
            h10.setTextDirection(textDirectionHeuristic2);
            TextUtils.TruncateAt truncateAt = this.f10786l;
            if (truncateAt != null) {
                h10.setEllipsize(truncateAt);
            }
            h10.setMaxLines(this.f10780f);
            float f10 = this.f10781g;
            if (!(f10 == 0.0f && this.f10782h == 1.0f)) {
                h10.setLineSpacing(f10, this.f10782h);
            }
            if (this.f10780f > 1) {
                h10.setHyphenationFrequency(this.f10783i);
            }
            return h10.build();
        }
        if (!f10772n) {
            try {
                if (!this.f10785k || i11 < 23) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                Class<TextDirectionHeuristic> cls = TextDirectionHeuristic.class;
                if (z10) {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                }
                f10774p = textDirectionHeuristic;
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2});
                f10773o = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f10772n = true;
            } catch (Exception e10) {
                throw new l(e10);
            }
        }
        try {
            Constructor constructor = f10773o;
            constructor.getClass();
            TextDirectionHeuristic textDirectionHeuristic3 = f10774p;
            textDirectionHeuristic3.getClass();
            return (StaticLayout) constructor.newInstance(new Object[]{charSequence, 0, Integer.valueOf(this.f10778d), textPaint, Integer.valueOf(max), this.f10779e, textDirectionHeuristic3, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f10784j), null, Integer.valueOf(max), Integer.valueOf(this.f10780f)});
        } catch (Exception e11) {
            throw new l(e11);
        }
    }
}

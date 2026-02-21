package m8;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.WeakHashMap;
import k0.l;
import k0.n;
import m0.c1;
import m0.i0;
import m0.j0;
import q0.f;
import q8.b;
import q8.g;
import q8.j;
import w7.a;

public final class d {
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public b D;
    public b E;
    public TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public boolean J = true;
    public Bitmap K;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int[] R;
    public boolean S;
    public final TextPaint T;
    public final TextPaint U;
    public TimeInterpolator V;
    public TimeInterpolator W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a  reason: collision with root package name */
    public final View f10719a;

    /* renamed from: a0  reason: collision with root package name */
    public ColorStateList f10720a0;

    /* renamed from: b  reason: collision with root package name */
    public float f10721b;

    /* renamed from: b0  reason: collision with root package name */
    public float f10722b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10723c;

    /* renamed from: c0  reason: collision with root package name */
    public float f10724c0;

    /* renamed from: d  reason: collision with root package name */
    public float f10725d;

    /* renamed from: d0  reason: collision with root package name */
    public float f10726d0;

    /* renamed from: e  reason: collision with root package name */
    public float f10727e;

    /* renamed from: e0  reason: collision with root package name */
    public ColorStateList f10728e0;

    /* renamed from: f  reason: collision with root package name */
    public int f10729f;

    /* renamed from: f0  reason: collision with root package name */
    public float f10730f0;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f10731g;

    /* renamed from: g0  reason: collision with root package name */
    public float f10732g0;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f10733h;

    /* renamed from: h0  reason: collision with root package name */
    public float f10734h0;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f10735i;

    /* renamed from: i0  reason: collision with root package name */
    public StaticLayout f10736i0;

    /* renamed from: j  reason: collision with root package name */
    public int f10737j = 16;

    /* renamed from: j0  reason: collision with root package name */
    public float f10738j0;

    /* renamed from: k  reason: collision with root package name */
    public int f10739k = 16;

    /* renamed from: k0  reason: collision with root package name */
    public float f10740k0;

    /* renamed from: l  reason: collision with root package name */
    public float f10741l = 15.0f;

    /* renamed from: l0  reason: collision with root package name */
    public float f10742l0;

    /* renamed from: m  reason: collision with root package name */
    public float f10743m = 15.0f;

    /* renamed from: m0  reason: collision with root package name */
    public CharSequence f10744m0;

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f10745n;

    /* renamed from: n0  reason: collision with root package name */
    public int f10746n0 = 1;

    /* renamed from: o  reason: collision with root package name */
    public ColorStateList f10747o;

    /* renamed from: o0  reason: collision with root package name */
    public float f10748o0 = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public int f10749p;

    /* renamed from: p0  reason: collision with root package name */
    public float f10750p0 = 1.0f;

    /* renamed from: q  reason: collision with root package name */
    public float f10751q;

    /* renamed from: q0  reason: collision with root package name */
    public int f10752q0 = m.f10771m;

    /* renamed from: r  reason: collision with root package name */
    public float f10753r;

    /* renamed from: s  reason: collision with root package name */
    public float f10754s;

    /* renamed from: t  reason: collision with root package name */
    public float f10755t;

    /* renamed from: u  reason: collision with root package name */
    public float f10756u;

    /* renamed from: v  reason: collision with root package name */
    public float f10757v;

    /* renamed from: w  reason: collision with root package name */
    public Typeface f10758w;

    /* renamed from: x  reason: collision with root package name */
    public Typeface f10759x;

    /* renamed from: y  reason: collision with root package name */
    public Typeface f10760y;

    /* renamed from: z  reason: collision with root package name */
    public Typeface f10761z;

    public d(View view) {
        this.f10719a = view;
        TextPaint textPaint = new TextPaint(129);
        this.T = textPaint;
        this.U = new TextPaint(textPaint);
        this.f10733h = new Rect();
        this.f10731g = new Rect();
        this.f10735i = new RectF();
        float f10 = this.f10725d;
        this.f10727e = f.f(1.0f, f10, 0.5f, f10);
        h(view.getContext().getResources().getConfiguration());
    }

    public static int a(int i10, float f10, int i11) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((((float) Color.alpha(i11)) * f10) + (((float) Color.alpha(i10)) * f11)), Math.round((((float) Color.red(i11)) * f10) + (((float) Color.red(i10)) * f11)), Math.round((((float) Color.green(i11)) * f10) + (((float) Color.green(i10)) * f11)), Math.round((((float) Color.blue(i11)) * f10) + (((float) Color.blue(i10)) * f11)));
    }

    public static float g(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        LinearInterpolator linearInterpolator = a.f16153a;
        return f.f(f11, f10, f12, f10);
    }

    public final boolean b(CharSequence charSequence) {
        l lVar;
        WeakHashMap weakHashMap = c1.f10054a;
        boolean z10 = true;
        if (j0.d(this.f10719a) != 1) {
            z10 = false;
        }
        if (!this.J) {
            return z10;
        }
        if (z10) {
            lVar = n.f8962d;
        } else {
            lVar = n.f8961c;
        }
        return lVar.b(charSequence, charSequence.length());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x010f, code lost:
        if (r12.I != false) goto L_0x0111;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(float r13, boolean r14) {
        /*
            r12 = this;
            java.lang.CharSequence r0 = r12.G
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.graphics.Rect r0 = r12.f10733h
            int r0 = r0.width()
            float r0 = (float) r0
            android.graphics.Rect r1 = r12.f10731g
            int r1 = r1.width()
            float r1 = (float) r1
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r13 - r2
            float r3 = java.lang.Math.abs(r3)
            r4 = 925353388(0x3727c5ac, float:1.0E-5)
            r5 = 1
            r6 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0026
            r3 = 1
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            r7 = 0
            if (r3 == 0) goto L_0x0033
            float r13 = r12.f10743m
            float r14 = r12.f10730f0
            r12.L = r2
            android.graphics.Typeface r1 = r12.f10758w
            goto L_0x0073
        L_0x0033:
            float r3 = r12.f10741l
            float r8 = r12.f10732g0
            android.graphics.Typeface r9 = r12.f10761z
            float r10 = r13 - r7
            float r10 = java.lang.Math.abs(r10)
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0045
            r4 = 1
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            if (r4 == 0) goto L_0x004b
            r12.L = r2
            goto L_0x005a
        L_0x004b:
            float r4 = r12.f10741l
            float r10 = r12.f10743m
            android.animation.TimeInterpolator r11 = r12.W
            float r13 = g(r4, r10, r13, r11)
            float r4 = r12.f10741l
            float r13 = r13 / r4
            r12.L = r13
        L_0x005a:
            float r13 = r12.f10743m
            float r4 = r12.f10741l
            float r13 = r13 / r4
            float r4 = r1 * r13
            if (r14 == 0) goto L_0x0064
            goto L_0x006f
        L_0x0064:
            int r14 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r14 <= 0) goto L_0x006f
            float r0 = r0 / r13
            float r13 = java.lang.Math.min(r0, r1)
            r0 = r13
            goto L_0x0070
        L_0x006f:
            r0 = r1
        L_0x0070:
            r13 = r3
            r14 = r8
            r1 = r9
        L_0x0073:
            android.text.TextPaint r3 = r12.T
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x00c7
            float r4 = r12.M
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0081
            r4 = 1
            goto L_0x0082
        L_0x0081:
            r4 = 0
        L_0x0082:
            float r7 = r12.f10734h0
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r7 == 0) goto L_0x008a
            r7 = 1
            goto L_0x008b
        L_0x008a:
            r7 = 0
        L_0x008b:
            android.graphics.Typeface r8 = r12.C
            if (r8 == r1) goto L_0x0091
            r8 = 1
            goto L_0x0092
        L_0x0091:
            r8 = 0
        L_0x0092:
            android.text.StaticLayout r9 = r12.f10736i0
            if (r9 == 0) goto L_0x00a1
            int r9 = r9.getWidth()
            float r9 = (float) r9
            int r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r9 == 0) goto L_0x00a1
            r9 = 1
            goto L_0x00a2
        L_0x00a1:
            r9 = 0
        L_0x00a2:
            if (r4 != 0) goto L_0x00b1
            if (r7 != 0) goto L_0x00b1
            if (r9 != 0) goto L_0x00b1
            if (r8 != 0) goto L_0x00b1
            boolean r4 = r12.S
            if (r4 == 0) goto L_0x00af
            goto L_0x00b1
        L_0x00af:
            r4 = 0
            goto L_0x00b2
        L_0x00b1:
            r4 = 1
        L_0x00b2:
            r12.M = r13
            r12.f10734h0 = r14
            r12.C = r1
            r12.S = r6
            float r13 = r12.L
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x00c2
            r13 = 1
            goto L_0x00c3
        L_0x00c2:
            r13 = 0
        L_0x00c3:
            r3.setLinearText(r13)
            goto L_0x00c8
        L_0x00c7:
            r4 = 0
        L_0x00c8:
            java.lang.CharSequence r13 = r12.H
            if (r13 == 0) goto L_0x00ce
            if (r4 == 0) goto L_0x0158
        L_0x00ce:
            float r13 = r12.M
            r3.setTextSize(r13)
            android.graphics.Typeface r13 = r12.C
            r3.setTypeface(r13)
            float r13 = r12.f10734h0
            r3.setLetterSpacing(r13)
            java.lang.CharSequence r13 = r12.G
            boolean r13 = r12.b(r13)
            r12.I = r13
            int r14 = r12.f10746n0
            if (r14 <= r5) goto L_0x00f1
            if (r13 == 0) goto L_0x00ef
            boolean r1 = r12.f10723c
            if (r1 == 0) goto L_0x00f1
        L_0x00ef:
            r1 = 1
            goto L_0x00f2
        L_0x00f1:
            r1 = 0
        L_0x00f2:
            if (r1 == 0) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r14 = 1
        L_0x00f6:
            if (r14 != r5) goto L_0x00fb
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ l -> 0x013e }
            goto L_0x0119
        L_0x00fb:
            int r1 = r12.f10737j     // Catch:{ l -> 0x013e }
            int r1 = android.view.Gravity.getAbsoluteGravity(r1, r13)     // Catch:{ l -> 0x013e }
            r1 = r1 & 7
            if (r1 == r5) goto L_0x0117
            r2 = 5
            if (r1 == r2) goto L_0x010d
            boolean r1 = r12.I     // Catch:{ l -> 0x013e }
            if (r1 == 0) goto L_0x0111
            goto L_0x0114
        L_0x010d:
            boolean r1 = r12.I     // Catch:{ l -> 0x013e }
            if (r1 == 0) goto L_0x0114
        L_0x0111:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ l -> 0x013e }
            goto L_0x0119
        L_0x0114:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ l -> 0x013e }
            goto L_0x0119
        L_0x0117:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ l -> 0x013e }
        L_0x0119:
            java.lang.CharSequence r2 = r12.G     // Catch:{ l -> 0x013e }
            int r0 = (int) r0     // Catch:{ l -> 0x013e }
            m8.m r4 = new m8.m     // Catch:{ l -> 0x013e }
            r4.<init>(r2, r3, r0)     // Catch:{ l -> 0x013e }
            android.text.TextUtils$TruncateAt r0 = r12.F     // Catch:{ l -> 0x013e }
            r4.f10786l = r0     // Catch:{ l -> 0x013e }
            r4.f10785k = r13     // Catch:{ l -> 0x013e }
            r4.f10779e = r1     // Catch:{ l -> 0x013e }
            r4.f10784j = r6     // Catch:{ l -> 0x013e }
            r4.f10780f = r14     // Catch:{ l -> 0x013e }
            float r13 = r12.f10748o0     // Catch:{ l -> 0x013e }
            float r14 = r12.f10750p0     // Catch:{ l -> 0x013e }
            r4.f10781g = r13     // Catch:{ l -> 0x013e }
            r4.f10782h = r14     // Catch:{ l -> 0x013e }
            int r13 = r12.f10752q0     // Catch:{ l -> 0x013e }
            r4.f10783i = r13     // Catch:{ l -> 0x013e }
            android.text.StaticLayout r13 = r4.a()     // Catch:{ l -> 0x013e }
            goto L_0x014d
        L_0x013e:
            r13 = move-exception
            java.lang.Throwable r14 = r13.getCause()
            java.lang.String r14 = r14.getMessage()
            java.lang.String r0 = "CollapsingTextHelper"
            android.util.Log.e(r0, r14, r13)
            r13 = 0
        L_0x014d:
            r13.getClass()
            r12.f10736i0 = r13
            java.lang.CharSequence r13 = r13.getText()
            r12.H = r13
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.d.c(float, boolean):void");
    }

    public final void d(Canvas canvas) {
        int save = canvas.save();
        if (this.H != null) {
            RectF rectF = this.f10735i;
            if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                TextPaint textPaint = this.T;
                textPaint.setTextSize(this.M);
                float f10 = this.f10756u;
                float f11 = this.f10757v;
                float f12 = this.L;
                if (f12 != 1.0f && !this.f10723c) {
                    canvas.scale(f12, f12, f10, f11);
                }
                boolean z10 = true;
                if (this.f10746n0 <= 1 || (this.I && !this.f10723c)) {
                    z10 = false;
                }
                if (!z10 || (this.f10723c && this.f10721b <= this.f10727e)) {
                    canvas.translate(f10, f11);
                    this.f10736i0.draw(canvas);
                } else {
                    int alpha = textPaint.getAlpha();
                    canvas.translate(this.f10756u - ((float) this.f10736i0.getLineStart(0)), f11);
                    if (!this.f10723c) {
                        textPaint.setAlpha((int) (this.f10742l0 * ((float) alpha)));
                        if (Build.VERSION.SDK_INT >= 31) {
                            float f13 = this.N;
                            float f14 = this.O;
                            float f15 = this.P;
                            int i10 = this.Q;
                            textPaint.setShadowLayer(f13, f14, f15, e0.a.d(i10, (Color.alpha(i10) * textPaint.getAlpha()) / 255));
                        }
                        this.f10736i0.draw(canvas);
                    }
                    if (!this.f10723c) {
                        textPaint.setAlpha((int) (this.f10740k0 * ((float) alpha)));
                    }
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 31) {
                        float f16 = this.N;
                        float f17 = this.O;
                        float f18 = this.P;
                        int i12 = this.Q;
                        textPaint.setShadowLayer(f16, f17, f18, e0.a.d(i12, (Color.alpha(i12) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = this.f10736i0.getLineBaseline(0);
                    CharSequence charSequence = this.f10744m0;
                    float f19 = (float) lineBaseline;
                    canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f19, textPaint);
                    if (i11 >= 31) {
                        textPaint.setShadowLayer(this.N, this.O, this.P, this.Q);
                    }
                    if (!this.f10723c) {
                        String trim = this.f10744m0.toString().trim();
                        if (trim.endsWith("…")) {
                            trim = trim.substring(0, trim.length() - 1);
                        }
                        String str = trim;
                        textPaint.setAlpha(alpha);
                        canvas.drawText(str, 0, Math.min(this.f10736i0.getLineEnd(0), str.length()), 0.0f, f19, textPaint);
                    }
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public final float e() {
        TextPaint textPaint = this.U;
        textPaint.setTextSize(this.f10743m);
        textPaint.setTypeface(this.f10758w);
        textPaint.setLetterSpacing(this.f10730f0);
        return -textPaint.ascent();
    }

    public final int f(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.R;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void h(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f10760y;
            if (typeface != null) {
                this.f10759x = j.a(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = j.a(configuration, typeface2);
            }
            Typeface typeface3 = this.f10759x;
            if (typeface3 == null) {
                typeface3 = this.f10760y;
            }
            this.f10758w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f10761z = typeface4;
            i(true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0237  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(boolean r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            android.view.View r2 = r0.f10719a
            int r3 = r2.getHeight()
            if (r3 <= 0) goto L_0x0012
            int r3 = r2.getWidth()
            if (r3 > 0) goto L_0x0014
        L_0x0012:
            if (r1 == 0) goto L_0x025a
        L_0x0014:
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.c(r3, r1)
            java.lang.CharSequence r4 = r0.H
            android.text.TextPaint r5 = r0.T
            if (r4 == 0) goto L_0x0030
            android.text.StaticLayout r6 = r0.f10736i0
            if (r6 == 0) goto L_0x0030
            int r6 = r6.getWidth()
            float r6 = (float) r6
            android.text.TextUtils$TruncateAt r7 = r0.F
            java.lang.CharSequence r4 = android.text.TextUtils.ellipsize(r4, r5, r6, r7)
            r0.f10744m0 = r4
        L_0x0030:
            java.lang.CharSequence r4 = r0.f10744m0
            r6 = 0
            r7 = 0
            if (r4 == 0) goto L_0x0041
            int r8 = r4.length()
            float r4 = r5.measureText(r4, r6, r8)
            r0.f10738j0 = r4
            goto L_0x0043
        L_0x0041:
            r0.f10738j0 = r7
        L_0x0043:
            int r4 = r0.f10739k
            boolean r8 = r0.I
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r8)
            r8 = r4 & 112(0x70, float:1.57E-43)
            android.graphics.Rect r9 = r0.f10733h
            r10 = 80
            r11 = 48
            r12 = 1073741824(0x40000000, float:2.0)
            if (r8 == r11) goto L_0x0075
            if (r8 == r10) goto L_0x006a
            float r8 = r5.descent()
            float r13 = r5.ascent()
            float r8 = r8 - r13
            float r8 = r8 / r12
            int r13 = r9.centerY()
            float r13 = (float) r13
            float r13 = r13 - r8
            goto L_0x0072
        L_0x006a:
            int r8 = r9.bottom
            float r8 = (float) r8
            float r13 = r5.ascent()
            float r13 = r13 + r8
        L_0x0072:
            r0.f10753r = r13
            goto L_0x007a
        L_0x0075:
            int r8 = r9.top
            float r8 = (float) r8
            r0.f10753r = r8
        L_0x007a:
            r8 = 8388615(0x800007, float:1.1754953E-38)
            r4 = r4 & r8
            r13 = 5
            r14 = 1
            if (r4 == r14) goto L_0x008e
            if (r4 == r13) goto L_0x0088
            int r4 = r9.left
            float r4 = (float) r4
            goto L_0x0097
        L_0x0088:
            int r4 = r9.right
            float r4 = (float) r4
            float r15 = r0.f10738j0
            goto L_0x0096
        L_0x008e:
            int r4 = r9.centerX()
            float r4 = (float) r4
            float r15 = r0.f10738j0
            float r15 = r15 / r12
        L_0x0096:
            float r4 = r4 - r15
        L_0x0097:
            r0.f10755t = r4
            r0.c(r7, r1)
            android.text.StaticLayout r1 = r0.f10736i0
            if (r1 == 0) goto L_0x00a6
            int r1 = r1.getHeight()
            float r1 = (float) r1
            goto L_0x00a7
        L_0x00a6:
            r1 = 0
        L_0x00a7:
            android.text.StaticLayout r4 = r0.f10736i0
            if (r4 == 0) goto L_0x00b5
            int r15 = r0.f10746n0
            if (r15 <= r14) goto L_0x00b5
            int r4 = r4.getWidth()
            float r4 = (float) r4
            goto L_0x00c3
        L_0x00b5:
            java.lang.CharSequence r4 = r0.H
            if (r4 == 0) goto L_0x00c2
            int r15 = r4.length()
            float r4 = r5.measureText(r4, r6, r15)
            goto L_0x00c3
        L_0x00c2:
            r4 = 0
        L_0x00c3:
            android.text.StaticLayout r15 = r0.f10736i0
            if (r15 == 0) goto L_0x00cc
            int r15 = r15.getLineCount()
            goto L_0x00cd
        L_0x00cc:
            r15 = 0
        L_0x00cd:
            r0.f10749p = r15
            int r15 = r0.f10737j
            boolean r3 = r0.I
            int r3 = android.view.Gravity.getAbsoluteGravity(r15, r3)
            r15 = r3 & 112(0x70, float:1.57E-43)
            android.graphics.Rect r6 = r0.f10731g
            if (r15 == r11) goto L_0x00f3
            if (r15 == r10) goto L_0x00e9
            float r1 = r1 / r12
            int r10 = r6.centerY()
            float r10 = (float) r10
            float r10 = r10 - r1
            r0.f10751q = r10
            goto L_0x00f8
        L_0x00e9:
            int r10 = r6.bottom
            float r10 = (float) r10
            float r10 = r10 - r1
            float r1 = r5.descent()
            float r1 = r1 + r10
            goto L_0x00f6
        L_0x00f3:
            int r1 = r6.top
            float r1 = (float) r1
        L_0x00f6:
            r0.f10751q = r1
        L_0x00f8:
            r1 = r3 & r8
            if (r1 == r14) goto L_0x0106
            if (r1 == r13) goto L_0x0102
            int r1 = r6.left
            float r1 = (float) r1
            goto L_0x010d
        L_0x0102:
            int r1 = r6.right
            float r1 = (float) r1
            goto L_0x010c
        L_0x0106:
            int r1 = r6.centerX()
            float r1 = (float) r1
            float r4 = r4 / r12
        L_0x010c:
            float r1 = r1 - r4
        L_0x010d:
            r0.f10754s = r1
            android.graphics.Bitmap r1 = r0.K
            r3 = 0
            if (r1 == 0) goto L_0x0119
            r1.recycle()
            r0.K = r3
        L_0x0119:
            float r1 = r0.f10721b
            r0.q(r1)
            float r1 = r0.f10721b
            boolean r4 = r0.f10723c
            android.graphics.RectF r8 = r0.f10735i
            if (r4 == 0) goto L_0x0131
            float r4 = r0.f10727e
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x012d
            r9 = r6
        L_0x012d:
            r8.set(r9)
            goto L_0x0167
        L_0x0131:
            int r4 = r6.left
            float r4 = (float) r4
            int r10 = r9.left
            float r10 = (float) r10
            android.animation.TimeInterpolator r11 = r0.V
            float r4 = g(r4, r10, r1, r11)
            r8.left = r4
            float r4 = r0.f10751q
            float r10 = r0.f10753r
            android.animation.TimeInterpolator r11 = r0.V
            float r4 = g(r4, r10, r1, r11)
            r8.top = r4
            int r4 = r6.right
            float r4 = (float) r4
            int r10 = r9.right
            float r10 = (float) r10
            android.animation.TimeInterpolator r11 = r0.V
            float r4 = g(r4, r10, r1, r11)
            r8.right = r4
            int r4 = r6.bottom
            float r4 = (float) r4
            int r6 = r9.bottom
            float r6 = (float) r6
            android.animation.TimeInterpolator r9 = r0.V
            float r4 = g(r4, r6, r1, r9)
            r8.bottom = r4
        L_0x0167:
            boolean r4 = r0.f10723c
            if (r4 == 0) goto L_0x0197
            float r4 = r0.f10727e
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x017e
            float r4 = r0.f10754s
            r0.f10756u = r4
            float r4 = r0.f10751q
            r0.f10757v = r4
            r0.q(r7)
            r4 = 0
            goto L_0x01b3
        L_0x017e:
            float r4 = r0.f10755t
            r0.f10756u = r4
            float r4 = r0.f10753r
            int r6 = r0.f10729f
            r8 = 0
            int r6 = java.lang.Math.max(r8, r6)
            float r6 = (float) r6
            float r4 = r4 - r6
            r0.f10757v = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r0.q(r4)
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01b3
        L_0x0197:
            float r4 = r0.f10754s
            float r6 = r0.f10755t
            android.animation.TimeInterpolator r8 = r0.V
            float r4 = g(r4, r6, r1, r8)
            r0.f10756u = r4
            float r4 = r0.f10751q
            float r6 = r0.f10753r
            android.animation.TimeInterpolator r8 = r0.V
            float r4 = g(r4, r6, r1, r8)
            r0.f10757v = r4
            r0.q(r1)
            r4 = r1
        L_0x01b3:
            r6 = 1065353216(0x3f800000, float:1.0)
            float r8 = r6 - r1
            a1.b r9 = w7.a.f16154b
            float r8 = g(r7, r6, r8, r9)
            float r8 = r6 - r8
            r0.f10740k0 = r8
            java.util.WeakHashMap r8 = m0.c1.f10054a
            m0.i0.k(r2)
            float r8 = g(r6, r7, r1, r9)
            r0.f10742l0 = r8
            m0.i0.k(r2)
            android.content.res.ColorStateList r6 = r0.f10747o
            android.content.res.ColorStateList r8 = r0.f10745n
            if (r6 == r8) goto L_0x01e4
            int r6 = r0.f(r8)
            android.content.res.ColorStateList r8 = r0.f10747o
            int r8 = r0.f(r8)
            int r4 = a(r6, r4, r8)
            goto L_0x01e8
        L_0x01e4:
            int r4 = r0.f(r6)
        L_0x01e8:
            r5.setColor(r4)
            float r4 = r0.f10730f0
            float r6 = r0.f10732g0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01f7
            float r4 = g(r6, r4, r1, r9)
        L_0x01f7:
            r5.setLetterSpacing(r4)
            float r4 = r0.f10722b0
            float r6 = r0.X
            float r4 = g(r4, r6, r1, r3)
            r0.N = r4
            float r4 = r0.f10724c0
            float r6 = r0.Y
            float r4 = g(r4, r6, r1, r3)
            r0.O = r4
            float r4 = r0.f10726d0
            float r6 = r0.Z
            float r3 = g(r4, r6, r1, r3)
            r0.P = r3
            android.content.res.ColorStateList r3 = r0.f10728e0
            int r3 = r0.f(r3)
            android.content.res.ColorStateList r4 = r0.f10720a0
            int r4 = r0.f(r4)
            int r3 = a(r3, r1, r4)
            r0.Q = r3
            float r4 = r0.N
            float r6 = r0.O
            float r8 = r0.P
            r5.setShadowLayer(r4, r6, r8, r3)
            boolean r3 = r0.f10723c
            if (r3 == 0) goto L_0x0257
            int r3 = r5.getAlpha()
            float r4 = r0.f10727e
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x024a
            float r6 = r0.f10725d
            r8 = 1065353216(0x3f800000, float:1.0)
            float r1 = w7.a.a(r8, r7, r6, r4, r1)
            goto L_0x0250
        L_0x024a:
            r8 = 1065353216(0x3f800000, float:1.0)
            float r1 = w7.a.a(r7, r8, r4, r8, r1)
        L_0x0250:
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            r5.setAlpha(r1)
        L_0x0257:
            m0.i0.k(r2)
        L_0x025a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.d.i(boolean):void");
    }

    public final void j(ColorStateList colorStateList) {
        if (this.f10747o != colorStateList || this.f10745n != colorStateList) {
            this.f10747o = colorStateList;
            this.f10745n = colorStateList;
            i(false);
        }
    }

    public final void k(int i10) {
        View view = this.f10719a;
        g gVar = new g(view.getContext(), i10);
        ColorStateList colorStateList = gVar.f13426j;
        if (colorStateList != null) {
            this.f10747o = colorStateList;
        }
        float f10 = gVar.f13427k;
        if (f10 != 0.0f) {
            this.f10743m = f10;
        }
        ColorStateList colorStateList2 = gVar.f13417a;
        if (colorStateList2 != null) {
            this.f10720a0 = colorStateList2;
        }
        this.Y = gVar.f13421e;
        this.Z = gVar.f13422f;
        this.X = gVar.f13423g;
        this.f10730f0 = gVar.f13425i;
        b bVar = this.E;
        if (bVar != null) {
            bVar.f13410c = true;
        }
        c cVar = new c(this, 0);
        gVar.a();
        this.E = new b(cVar, gVar.f13430n);
        gVar.c(view.getContext(), this.E);
        i(false);
    }

    public final void l(int i10) {
        if (this.f10739k != i10) {
            this.f10739k = i10;
            i(false);
        }
    }

    public final boolean m(Typeface typeface) {
        b bVar = this.E;
        if (bVar != null) {
            bVar.f13410c = true;
        }
        if (this.f10760y == typeface) {
            return false;
        }
        this.f10760y = typeface;
        Typeface a10 = j.a(this.f10719a.getContext().getResources().getConfiguration(), typeface);
        this.f10759x = a10;
        if (a10 == null) {
            a10 = this.f10760y;
        }
        this.f10758w = a10;
        return true;
    }

    public final void n(int i10) {
        View view = this.f10719a;
        g gVar = new g(view.getContext(), i10);
        ColorStateList colorStateList = gVar.f13426j;
        if (colorStateList != null) {
            this.f10745n = colorStateList;
        }
        float f10 = gVar.f13427k;
        if (f10 != 0.0f) {
            this.f10741l = f10;
        }
        ColorStateList colorStateList2 = gVar.f13417a;
        if (colorStateList2 != null) {
            this.f10728e0 = colorStateList2;
        }
        this.f10724c0 = gVar.f13421e;
        this.f10726d0 = gVar.f13422f;
        this.f10722b0 = gVar.f13423g;
        this.f10732g0 = gVar.f13425i;
        b bVar = this.D;
        if (bVar != null) {
            bVar.f13410c = true;
        }
        c cVar = new c(this, 1);
        gVar.a();
        this.D = new b(cVar, gVar.f13430n);
        gVar.c(view.getContext(), this.D);
        i(false);
    }

    public final boolean o(Typeface typeface) {
        b bVar = this.D;
        if (bVar != null) {
            bVar.f13410c = true;
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface a10 = j.a(this.f10719a.getContext().getResources().getConfiguration(), typeface);
        this.A = a10;
        if (a10 == null) {
            a10 = this.B;
        }
        this.f10761z = a10;
        return true;
    }

    public final void p(float f10) {
        float f11;
        int i10;
        float f12;
        if (f10 < 0.0f) {
            f10 = 0.0f;
        } else if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (f10 != this.f10721b) {
            this.f10721b = f10;
            boolean z10 = this.f10723c;
            RectF rectF = this.f10735i;
            Rect rect = this.f10733h;
            Rect rect2 = this.f10731g;
            if (z10) {
                if (f10 < this.f10727e) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = g((float) rect2.left, (float) rect.left, f10, this.V);
                rectF.top = g(this.f10751q, this.f10753r, f10, this.V);
                rectF.right = g((float) rect2.right, (float) rect.right, f10, this.V);
                rectF.bottom = g((float) rect2.bottom, (float) rect.bottom, f10, this.V);
            }
            if (!this.f10723c) {
                this.f10756u = g(this.f10754s, this.f10755t, f10, this.V);
                this.f10757v = g(this.f10751q, this.f10753r, f10, this.V);
                q(f10);
                f11 = f10;
            } else if (f10 < this.f10727e) {
                this.f10756u = this.f10754s;
                this.f10757v = this.f10751q;
                q(0.0f);
                f11 = 0.0f;
            } else {
                this.f10756u = this.f10755t;
                this.f10757v = this.f10753r - ((float) Math.max(0, this.f10729f));
                q(1.0f);
                f11 = 1.0f;
            }
            a1.b bVar = a.f16154b;
            this.f10740k0 = 1.0f - g(0.0f, 1.0f, 1.0f - f10, bVar);
            WeakHashMap weakHashMap = c1.f10054a;
            View view = this.f10719a;
            i0.k(view);
            this.f10742l0 = g(1.0f, 0.0f, f10, bVar);
            i0.k(view);
            ColorStateList colorStateList = this.f10747o;
            ColorStateList colorStateList2 = this.f10745n;
            TextPaint textPaint = this.T;
            if (colorStateList != colorStateList2) {
                i10 = a(f(colorStateList2), f11, f(this.f10747o));
            } else {
                i10 = f(colorStateList);
            }
            textPaint.setColor(i10);
            float f13 = this.f10730f0;
            float f14 = this.f10732g0;
            if (f13 != f14) {
                f13 = g(f14, f13, f10, bVar);
            }
            textPaint.setLetterSpacing(f13);
            this.N = g(this.f10722b0, this.X, f10, (TimeInterpolator) null);
            this.O = g(this.f10724c0, this.Y, f10, (TimeInterpolator) null);
            this.P = g(this.f10726d0, this.Z, f10, (TimeInterpolator) null);
            int a10 = a(f(this.f10728e0), f10, f(this.f10720a0));
            this.Q = a10;
            textPaint.setShadowLayer(this.N, this.O, this.P, a10);
            if (this.f10723c) {
                int alpha = textPaint.getAlpha();
                float f15 = this.f10727e;
                if (f10 <= f15) {
                    f12 = a.a(1.0f, 0.0f, this.f10725d, f15, f10);
                } else {
                    f12 = a.a(0.0f, 1.0f, f15, 1.0f, f10);
                }
                textPaint.setAlpha((int) (f12 * ((float) alpha)));
            }
            i0.k(view);
        }
    }

    public final void q(float f10) {
        c(f10, false);
        WeakHashMap weakHashMap = c1.f10054a;
        i0.k(this.f10719a);
    }

    public final boolean r(int[] iArr) {
        boolean z10;
        ColorStateList colorStateList;
        this.R = iArr;
        ColorStateList colorStateList2 = this.f10747o;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = this.f10745n) == null || !colorStateList.isStateful())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            return false;
        }
        i(false);
        return true;
    }
}

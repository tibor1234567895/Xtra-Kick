package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import f.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p0.b;

public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f997a;

    /* renamed from: b  reason: collision with root package name */
    public s4 f998b;

    /* renamed from: c  reason: collision with root package name */
    public s4 f999c;

    /* renamed from: d  reason: collision with root package name */
    public s4 f1000d;

    /* renamed from: e  reason: collision with root package name */
    public s4 f1001e;

    /* renamed from: f  reason: collision with root package name */
    public s4 f1002f;

    /* renamed from: g  reason: collision with root package name */
    public s4 f1003g;

    /* renamed from: h  reason: collision with root package name */
    public s4 f1004h;

    /* renamed from: i  reason: collision with root package name */
    public final b2 f1005i;

    /* renamed from: j  reason: collision with root package name */
    public int f1006j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f1007k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f1008l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1009m;

    public q1(TextView textView) {
        this.f997a = textView;
        this.f1005i = new b2(textView);
    }

    public static s4 c(Context context, h0 h0Var, int i10) {
        ColorStateList i11;
        synchronized (h0Var) {
            i11 = h0Var.f845a.i(context, i10);
        }
        if (i11 == null) {
            return null;
        }
        s4 s4Var = new s4();
        s4Var.f1058d = true;
        s4Var.f1055a = i11;
        return s4Var;
    }

    public static void h(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i10;
        int i11;
        boolean z10;
        int i12;
        CharSequence charSequence;
        int i13 = Build.VERSION.SDK_INT;
        if (i13 < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i13 >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            text.getClass();
            if (i13 >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            int i14 = editorInfo.initialSelStart;
            int i15 = editorInfo.initialSelEnd;
            if (i14 > i15) {
                i10 = i15 + 0;
            } else {
                i10 = i14 + 0;
            }
            if (i14 > i15) {
                i11 = i14 - 0;
            } else {
                i11 = i15 + 0;
            }
            int length = text.length();
            if (i10 >= 0 && i11 <= length) {
                int i16 = editorInfo.inputType & 4095;
                if (i16 == 129 || i16 == 225 || i16 == 18) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    if (length <= 2048) {
                        b.a(editorInfo, text, i10, i11);
                        return;
                    }
                    int i17 = i11 - i10;
                    if (i17 > 1024) {
                        i12 = 0;
                    } else {
                        i12 = i17;
                    }
                    int i18 = 2048 - i12;
                    int min = Math.min(text.length() - i11, i18 - Math.min(i10, (int) (((double) i18) * 0.8d)));
                    int min2 = Math.min(i10, i18 - min);
                    int i19 = i10 - min2;
                    if (Character.isLowSurrogate(text.charAt(i19))) {
                        i19++;
                        min2--;
                    }
                    if (Character.isHighSurrogate(text.charAt((i11 + min) - 1))) {
                        min--;
                    }
                    int i20 = min2 + i12 + min;
                    if (i12 != i17) {
                        charSequence = TextUtils.concat(new CharSequence[]{text.subSequence(i19, i19 + min2), text.subSequence(i11, min + i11)});
                    } else {
                        charSequence = text.subSequence(i19, i20 + i19);
                    }
                    int i21 = min2 + 0;
                    b.a(editorInfo, charSequence, i21, i12 + i21);
                    return;
                }
            }
            b.a(editorInfo, (CharSequence) null, 0, 0);
        }
    }

    public final void a(Drawable drawable, s4 s4Var) {
        if (drawable != null && s4Var != null) {
            h0.e(drawable, s4Var, this.f997a.getDrawableState());
        }
    }

    public final void b() {
        s4 s4Var = this.f998b;
        TextView textView = this.f997a;
        if (!(s4Var == null && this.f999c == null && this.f1000d == null && this.f1001e == null)) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f998b);
            a(compoundDrawables[1], this.f999c);
            a(compoundDrawables[2], this.f1000d);
            a(compoundDrawables[3], this.f1001e);
        }
        if (this.f1002f != null || this.f1003g != null) {
            Drawable[] a10 = l1.a(textView);
            a(a10[0], this.f1002f);
            a(a10[2], this.f1003g);
        }
    }

    public final ColorStateList d() {
        s4 s4Var = this.f1004h;
        if (s4Var != null) {
            return s4Var.f1055a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        s4 s4Var = this.f1004h;
        if (s4Var != null) {
            return s4Var.f1056b;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(android.util.AttributeSet r28, int r29) {
        /*
            r27 = this;
            r0 = r27
            r7 = r28
            r8 = r29
            android.widget.TextView r9 = r0.f997a
            android.content.Context r10 = r9.getContext()
            androidx.appcompat.widget.h0 r11 = androidx.appcompat.widget.h0.a()
            int[] r3 = f.a.f5399i
            androidx.appcompat.widget.u4 r12 = androidx.appcompat.widget.u4.m(r10, r7, r3, r8)
            android.content.Context r2 = r9.getContext()
            android.content.res.TypedArray r5 = r12.f1100b
            r1 = r9
            r4 = r28
            r6 = r29
            m0.c1.o(r1, r2, r3, r4, r5, r6)
            r13 = 0
            r14 = -1
            int r1 = r12.i(r13, r14)
            r15 = 3
            boolean r2 = r12.l(r15)
            if (r2 == 0) goto L_0x003b
            int r2 = r12.i(r15, r13)
            androidx.appcompat.widget.s4 r2 = c(r10, r11, r2)
            r0.f998b = r2
        L_0x003b:
            r6 = 1
            boolean r2 = r12.l(r6)
            if (r2 == 0) goto L_0x004c
            int r2 = r12.i(r6, r13)
            androidx.appcompat.widget.s4 r2 = c(r10, r11, r2)
            r0.f999c = r2
        L_0x004c:
            r5 = 4
            boolean r2 = r12.l(r5)
            if (r2 == 0) goto L_0x005d
            int r2 = r12.i(r5, r13)
            androidx.appcompat.widget.s4 r2 = c(r10, r11, r2)
            r0.f1000d = r2
        L_0x005d:
            r4 = 2
            boolean r2 = r12.l(r4)
            if (r2 == 0) goto L_0x006e
            int r2 = r12.i(r4, r13)
            androidx.appcompat.widget.s4 r2 = c(r10, r11, r2)
            r0.f1001e = r2
        L_0x006e:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 5
            boolean r16 = r12.l(r3)
            if (r16 == 0) goto L_0x0081
            int r4 = r12.i(r3, r13)
            androidx.appcompat.widget.s4 r4 = c(r10, r11, r4)
            r0.f1002f = r4
        L_0x0081:
            r4 = 6
            boolean r17 = r12.l(r4)
            if (r17 == 0) goto L_0x0092
            int r6 = r12.i(r4, r13)
            androidx.appcompat.widget.s4 r6 = c(r10, r11, r6)
            r0.f1003g = r6
        L_0x0092:
            r12.n()
            android.text.method.TransformationMethod r6 = r9.getTransformationMethod()
            boolean r6 = r6 instanceof android.text.method.PasswordTransformationMethod
            int[] r12 = f.a.f5415y
            r4 = 23
            r3 = 14
            if (r1 == r14) goto L_0x011a
            androidx.appcompat.widget.u4 r14 = new androidx.appcompat.widget.u4
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r1, r12)
            r14.<init>(r10, r1)
            if (r6 != 0) goto L_0x00bb
            boolean r1 = r14.l(r3)
            if (r1 == 0) goto L_0x00bb
            boolean r1 = r14.a(r3, r13)
            r21 = 1
            goto L_0x00be
        L_0x00bb:
            r1 = 0
            r21 = 0
        L_0x00be:
            r0.n(r10, r14)
            if (r2 >= r4) goto L_0x00ec
            boolean r22 = r14.l(r15)
            if (r22 == 0) goto L_0x00ce
            android.content.res.ColorStateList r22 = r14.b(r15)
            goto L_0x00d0
        L_0x00ce:
            r22 = 0
        L_0x00d0:
            boolean r23 = r14.l(r5)
            if (r23 == 0) goto L_0x00dc
            android.content.res.ColorStateList r23 = r14.b(r5)
            r5 = 5
            goto L_0x00df
        L_0x00dc:
            r5 = 5
            r23 = 0
        L_0x00df:
            boolean r20 = r14.l(r5)
            if (r20 == 0) goto L_0x00f0
            android.content.res.ColorStateList r24 = r14.b(r5)
            r5 = 15
            goto L_0x00f4
        L_0x00ec:
            r22 = 0
            r23 = 0
        L_0x00f0:
            r5 = 15
            r24 = 0
        L_0x00f4:
            boolean r19 = r14.l(r5)
            if (r19 == 0) goto L_0x0101
            java.lang.String r25 = r14.j(r5)
            r5 = 26
            goto L_0x0105
        L_0x0101:
            r5 = 26
            r25 = 0
        L_0x0105:
            if (r2 < r5) goto L_0x0114
            r5 = 13
            boolean r18 = r14.l(r5)
            if (r18 == 0) goto L_0x0114
            java.lang.String r26 = r14.j(r5)
            goto L_0x0116
        L_0x0114:
            r26 = 0
        L_0x0116:
            r14.n()
            goto L_0x0127
        L_0x011a:
            r1 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
        L_0x0127:
            androidx.appcompat.widget.u4 r5 = new androidx.appcompat.widget.u4
            android.content.res.TypedArray r12 = r10.obtainStyledAttributes(r7, r12, r8, r13)
            r5.<init>(r10, r12)
            if (r6 != 0) goto L_0x013e
            boolean r12 = r5.l(r3)
            if (r12 == 0) goto L_0x013e
            boolean r1 = r5.a(r3, r13)
            r21 = 1
        L_0x013e:
            if (r2 >= r4) goto L_0x0160
            boolean r3 = r5.l(r15)
            if (r3 == 0) goto L_0x014a
            android.content.res.ColorStateList r22 = r5.b(r15)
        L_0x014a:
            r12 = 4
            boolean r3 = r5.l(r12)
            if (r3 == 0) goto L_0x0155
            android.content.res.ColorStateList r23 = r5.b(r12)
        L_0x0155:
            r3 = 5
            boolean r4 = r5.l(r3)
            if (r4 == 0) goto L_0x0160
            android.content.res.ColorStateList r24 = r5.b(r3)
        L_0x0160:
            r4 = r22
            r14 = r23
            r3 = r24
            r12 = 15
            boolean r19 = r5.l(r12)
            if (r19 == 0) goto L_0x0172
            java.lang.String r25 = r5.j(r12)
        L_0x0172:
            r12 = r25
            r15 = 26
            if (r2 < r15) goto L_0x0185
            r15 = 13
            boolean r18 = r5.l(r15)
            if (r18 == 0) goto L_0x0187
            java.lang.String r26 = r5.j(r15)
            goto L_0x0187
        L_0x0185:
            r15 = 13
        L_0x0187:
            r22 = r11
            r15 = r26
            r11 = 28
            if (r2 < r11) goto L_0x01a0
            boolean r11 = r5.l(r13)
            if (r11 == 0) goto L_0x01a0
            r11 = -1
            int r23 = r5.d(r13, r11)
            if (r23 != 0) goto L_0x01a0
            r11 = 0
            r9.setTextSize(r13, r11)
        L_0x01a0:
            r0.n(r10, r5)
            r5.n()
            if (r4 == 0) goto L_0x01ab
            r9.setTextColor(r4)
        L_0x01ab:
            if (r14 == 0) goto L_0x01b0
            r9.setHintTextColor(r14)
        L_0x01b0:
            if (r3 == 0) goto L_0x01b5
            r9.setLinkTextColor(r3)
        L_0x01b5:
            if (r6 != 0) goto L_0x01bc
            if (r21 == 0) goto L_0x01bc
            r9.setAllCaps(r1)
        L_0x01bc:
            android.graphics.Typeface r1 = r0.f1008l
            if (r1 == 0) goto L_0x01ce
            int r3 = r0.f1007k
            r4 = -1
            if (r3 != r4) goto L_0x01cb
            int r3 = r0.f1006j
            r9.setTypeface(r1, r3)
            goto L_0x01ce
        L_0x01cb:
            r9.setTypeface(r1)
        L_0x01ce:
            if (r15 == 0) goto L_0x01d3
            androidx.appcompat.widget.o1.d(r9, r15)
        L_0x01d3:
            r11 = 24
            if (r12 == 0) goto L_0x01f0
            if (r2 < r11) goto L_0x01e1
            android.os.LocaleList r1 = androidx.appcompat.widget.n1.a(r12)
            androidx.appcompat.widget.n1.b(r9, r1)
            goto L_0x01f0
        L_0x01e1:
            java.lang.String r1 = ","
            java.lang.String[] r1 = r12.split(r1)
            r1 = r1[r13]
            java.util.Locale r1 = androidx.appcompat.widget.m1.a(r1)
            androidx.appcompat.widget.l1.c(r9, r1)
        L_0x01f0:
            int[] r12 = f.a.f5400j
            androidx.appcompat.widget.b2 r14 = r0.f1005i
            android.content.Context r15 = r14.f749j
            android.content.res.TypedArray r6 = r15.obtainStyledAttributes(r7, r12, r8, r13)
            android.widget.TextView r1 = r14.f748i
            android.content.Context r2 = r1.getContext()
            r5 = 5
            r3 = r12
            r11 = 2
            r4 = r28
            r11 = 5
            r5 = r6
            r13 = r6
            r6 = r29
            m0.c1.o(r1, r2, r3, r4, r5, r6)
            boolean r1 = r13.hasValue(r11)
            if (r1 == 0) goto L_0x021a
            r1 = 0
            int r2 = r13.getInt(r11, r1)
            r14.f740a = r2
        L_0x021a:
            r1 = 4
            boolean r2 = r13.hasValue(r1)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == 0) goto L_0x0228
            float r1 = r13.getDimension(r1, r3)
            goto L_0x022a
        L_0x0228:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x022a:
            r2 = 2
            boolean r4 = r13.hasValue(r2)
            if (r4 == 0) goto L_0x0237
            float r4 = r13.getDimension(r2, r3)
            r2 = 1
            goto L_0x023a
        L_0x0237:
            r2 = 1
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x023a:
            boolean r5 = r13.hasValue(r2)
            if (r5 == 0) goto L_0x0245
            float r5 = r13.getDimension(r2, r3)
            goto L_0x0247
        L_0x0245:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0247:
            r6 = 3
            boolean r8 = r13.hasValue(r6)
            if (r8 == 0) goto L_0x027f
            r8 = 0
            int r11 = r13.getResourceId(r6, r8)
            if (r11 <= 0) goto L_0x027f
            android.content.res.Resources r6 = r13.getResources()
            android.content.res.TypedArray r6 = r6.obtainTypedArray(r11)
            int r8 = r6.length()
            int[] r11 = new int[r8]
            if (r8 <= 0) goto L_0x027c
            r3 = 0
        L_0x0266:
            if (r3 >= r8) goto L_0x0273
            r2 = -1
            int r17 = r6.getDimensionPixelSize(r3, r2)
            r11[r3] = r17
            int r3 = r3 + 1
            r2 = 1
            goto L_0x0266
        L_0x0273:
            int[] r2 = androidx.appcompat.widget.b2.b(r11)
            r14.f745f = r2
            r14.h()
        L_0x027c:
            r6.recycle()
        L_0x027f:
            r13.recycle()
            boolean r2 = r14.i()
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x02c1
            int r2 = r14.f740a
            r6 = 1
            if (r2 != r6) goto L_0x02c4
            boolean r2 = r14.f746g
            if (r2 != 0) goto L_0x02bd
            android.content.res.Resources r2 = r15.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x02a9
            r4 = 1094713344(0x41400000, float:12.0)
            r8 = 2
            float r4 = android.util.TypedValue.applyDimension(r8, r4, r2)
            goto L_0x02aa
        L_0x02a9:
            r8 = 2
        L_0x02aa:
            int r11 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r11 != 0) goto L_0x02b4
            r5 = 1121976320(0x42e00000, float:112.0)
            float r5 = android.util.TypedValue.applyDimension(r8, r5, r2)
        L_0x02b4:
            int r2 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x02ba
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x02ba:
            r14.j(r4, r5, r1)
        L_0x02bd:
            r14.g()
            goto L_0x02c4
        L_0x02c1:
            r1 = 0
            r14.f740a = r1
        L_0x02c4:
            boolean r1 = androidx.appcompat.widget.l5.f925b
            if (r1 == 0) goto L_0x02f7
            int r1 = r14.f740a
            if (r1 == 0) goto L_0x02f7
            int[] r1 = r14.f745f
            int r2 = r1.length
            if (r2 <= 0) goto L_0x02f7
            int r2 = androidx.appcompat.widget.o1.a(r9)
            float r2 = (float) r2
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x02f3
            float r1 = r14.f743d
            int r1 = java.lang.Math.round(r1)
            float r2 = r14.f744e
            int r2 = java.lang.Math.round(r2)
            float r4 = r14.f742c
            int r4 = java.lang.Math.round(r4)
            r5 = 0
            androidx.appcompat.widget.o1.b(r9, r1, r2, r4, r5)
            goto L_0x02f7
        L_0x02f3:
            r5 = 0
            androidx.appcompat.widget.o1.c(r9, r1, r5)
        L_0x02f7:
            androidx.appcompat.widget.u4 r1 = new androidx.appcompat.widget.u4
            android.content.res.TypedArray r2 = r10.obtainStyledAttributes(r7, r12)
            r1.<init>(r10, r2)
            r2 = 8
            r4 = -1
            int r2 = r1.i(r2, r4)
            r5 = r22
            if (r2 == r4) goto L_0x0310
            android.graphics.drawable.Drawable r2 = r5.b(r10, r2)
            goto L_0x0311
        L_0x0310:
            r2 = 0
        L_0x0311:
            r6 = 13
            int r6 = r1.i(r6, r4)
            if (r6 == r4) goto L_0x031e
            android.graphics.drawable.Drawable r6 = r5.b(r10, r6)
            goto L_0x031f
        L_0x031e:
            r6 = 0
        L_0x031f:
            r7 = 9
            int r7 = r1.i(r7, r4)
            if (r7 == r4) goto L_0x032c
            android.graphics.drawable.Drawable r7 = r5.b(r10, r7)
            goto L_0x032d
        L_0x032c:
            r7 = 0
        L_0x032d:
            r8 = 6
            int r8 = r1.i(r8, r4)
            if (r8 == r4) goto L_0x0339
            android.graphics.drawable.Drawable r8 = r5.b(r10, r8)
            goto L_0x033a
        L_0x0339:
            r8 = 0
        L_0x033a:
            r11 = 10
            int r11 = r1.i(r11, r4)
            if (r11 == r4) goto L_0x0347
            android.graphics.drawable.Drawable r11 = r5.b(r10, r11)
            goto L_0x0348
        L_0x0347:
            r11 = 0
        L_0x0348:
            r12 = 7
            int r12 = r1.i(r12, r4)
            if (r12 == r4) goto L_0x0354
            android.graphics.drawable.Drawable r4 = r5.b(r10, r12)
            goto L_0x0355
        L_0x0354:
            r4 = 0
        L_0x0355:
            if (r11 != 0) goto L_0x03a3
            if (r4 == 0) goto L_0x035a
            goto L_0x03a3
        L_0x035a:
            if (r2 != 0) goto L_0x0362
            if (r6 != 0) goto L_0x0362
            if (r7 != 0) goto L_0x0362
            if (r8 == 0) goto L_0x03c2
        L_0x0362:
            android.graphics.drawable.Drawable[] r4 = androidx.appcompat.widget.l1.a(r9)
            r5 = 0
            r10 = r4[r5]
            if (r10 != 0) goto L_0x0390
            r11 = 2
            r12 = r4[r11]
            if (r12 == 0) goto L_0x0371
            goto L_0x0390
        L_0x0371:
            android.graphics.drawable.Drawable[] r4 = r9.getCompoundDrawables()
            if (r2 == 0) goto L_0x0378
            goto L_0x037a
        L_0x0378:
            r2 = r4[r5]
        L_0x037a:
            if (r6 == 0) goto L_0x037d
            goto L_0x0380
        L_0x037d:
            r5 = 1
            r6 = r4[r5]
        L_0x0380:
            if (r7 == 0) goto L_0x0383
            goto L_0x0386
        L_0x0383:
            r5 = 2
            r7 = r4[r5]
        L_0x0386:
            if (r8 == 0) goto L_0x0389
            goto L_0x038c
        L_0x0389:
            r5 = 3
            r8 = r4[r5]
        L_0x038c:
            r9.setCompoundDrawablesWithIntrinsicBounds(r2, r6, r7, r8)
            goto L_0x03c2
        L_0x0390:
            if (r6 == 0) goto L_0x0393
            goto L_0x0396
        L_0x0393:
            r2 = 1
            r6 = r4[r2]
        L_0x0396:
            r2 = 2
            r2 = r4[r2]
            if (r8 == 0) goto L_0x039c
            goto L_0x039f
        L_0x039c:
            r5 = 3
            r8 = r4[r5]
        L_0x039f:
            androidx.appcompat.widget.l1.b(r9, r10, r6, r2, r8)
            goto L_0x03c2
        L_0x03a3:
            android.graphics.drawable.Drawable[] r2 = androidx.appcompat.widget.l1.a(r9)
            if (r11 == 0) goto L_0x03aa
            goto L_0x03ad
        L_0x03aa:
            r5 = 0
            r11 = r2[r5]
        L_0x03ad:
            if (r6 == 0) goto L_0x03b0
            goto L_0x03b3
        L_0x03b0:
            r5 = 1
            r6 = r2[r5]
        L_0x03b3:
            if (r4 == 0) goto L_0x03b6
            goto L_0x03b9
        L_0x03b6:
            r4 = 2
            r4 = r2[r4]
        L_0x03b9:
            if (r8 == 0) goto L_0x03bc
            goto L_0x03bf
        L_0x03bc:
            r5 = 3
            r8 = r2[r5]
        L_0x03bf:
            androidx.appcompat.widget.l1.b(r9, r11, r6, r4, r8)
        L_0x03c2:
            r2 = 11
            boolean r4 = r1.l(r2)
            if (r4 == 0) goto L_0x03e2
            android.content.res.ColorStateList r2 = r1.b(r2)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r4 < r5) goto L_0x03d8
            q0.v.f(r9, r2)
            goto L_0x03e2
        L_0x03d8:
            boolean r4 = r9 instanceof q0.d0
            if (r4 == 0) goto L_0x03e2
            r4 = r9
            q0.d0 r4 = (q0.d0) r4
            r4.setSupportCompoundDrawablesTintList(r2)
        L_0x03e2:
            r2 = 12
            boolean r4 = r1.l(r2)
            if (r4 == 0) goto L_0x0409
            r4 = -1
            int r2 = r1.h(r2, r4)
            r4 = 0
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.i2.d(r2, r4)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 24
            if (r5 < r6) goto L_0x03fe
            q0.v.g(r9, r2)
            goto L_0x040a
        L_0x03fe:
            boolean r5 = r9 instanceof q0.d0
            if (r5 == 0) goto L_0x040a
            r5 = r9
            q0.d0 r5 = (q0.d0) r5
            r5.setSupportCompoundDrawablesTintMode(r2)
            goto L_0x040a
        L_0x0409:
            r4 = 0
        L_0x040a:
            r2 = 15
            r5 = -1
            int r2 = r1.d(r2, r5)
            r6 = 18
            int r6 = r1.d(r6, r5)
            r7 = 19
            int r7 = r1.d(r7, r5)
            r1.n()
            if (r2 == r5) goto L_0x0425
            q0.a0.b(r9, r2)
        L_0x0425:
            if (r6 == r5) goto L_0x042a
            q0.a0.c(r9, r6)
        L_0x042a:
            if (r7 == r5) goto L_0x043e
            l0.f.b(r7)
            android.text.TextPaint r1 = r9.getPaint()
            int r1 = r1.getFontMetricsInt(r4)
            if (r7 == r1) goto L_0x043e
            int r7 = r7 - r1
            float r1 = (float) r7
            r9.setLineSpacing(r1, r3)
        L_0x043e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q1.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i10) {
        String j10;
        ColorStateList b10;
        ColorStateList b11;
        ColorStateList b12;
        u4 u4Var = new u4(context, context.obtainStyledAttributes(i10, a.f5415y));
        boolean l10 = u4Var.l(14);
        TextView textView = this.f997a;
        if (l10) {
            textView.setAllCaps(u4Var.a(14, false));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            if (u4Var.l(3) && (b12 = u4Var.b(3)) != null) {
                textView.setTextColor(b12);
            }
            if (u4Var.l(5) && (b11 = u4Var.b(5)) != null) {
                textView.setLinkTextColor(b11);
            }
            if (u4Var.l(4) && (b10 = u4Var.b(4)) != null) {
                textView.setHintTextColor(b10);
            }
        }
        if (u4Var.l(0) && u4Var.d(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, u4Var);
        if (i11 >= 26 && u4Var.l(13) && (j10 = u4Var.j(13)) != null) {
            o1.d(textView, j10);
        }
        u4Var.n();
        Typeface typeface = this.f1008l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f1006j);
        }
    }

    public final void i(int i10, int i11, int i12, int i13) {
        b2 b2Var = this.f1005i;
        if (b2Var.i()) {
            DisplayMetrics displayMetrics = b2Var.f749j.getResources().getDisplayMetrics();
            b2Var.j(TypedValue.applyDimension(i13, (float) i10, displayMetrics), TypedValue.applyDimension(i13, (float) i11, displayMetrics), TypedValue.applyDimension(i13, (float) i12, displayMetrics));
            if (b2Var.g()) {
                b2Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i10) {
        b2 b2Var = this.f1005i;
        if (b2Var.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = b2Var.f749j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, (float) iArr[i11], displayMetrics));
                    }
                }
                b2Var.f745f = b2.b(iArr2);
                if (!b2Var.h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                b2Var.f746g = false;
            }
            if (b2Var.g()) {
                b2Var.a();
            }
        }
    }

    public final void k(int i10) {
        b2 b2Var = this.f1005i;
        if (!b2Var.i()) {
            return;
        }
        if (i10 == 0) {
            b2Var.f740a = 0;
            b2Var.f743d = -1.0f;
            b2Var.f744e = -1.0f;
            b2Var.f742c = -1.0f;
            b2Var.f745f = new int[0];
            b2Var.f741b = false;
        } else if (i10 == 1) {
            DisplayMetrics displayMetrics = b2Var.f749j.getResources().getDisplayMetrics();
            b2Var.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (b2Var.g()) {
                b2Var.a();
            }
        } else {
            throw new IllegalArgumentException(h.i("Unknown auto-size text type: ", i10));
        }
    }

    public final void l(ColorStateList colorStateList) {
        boolean z10;
        if (this.f1004h == null) {
            this.f1004h = new s4();
        }
        s4 s4Var = this.f1004h;
        s4Var.f1055a = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        s4Var.f1058d = z10;
        this.f998b = s4Var;
        this.f999c = s4Var;
        this.f1000d = s4Var;
        this.f1001e = s4Var;
        this.f1002f = s4Var;
        this.f1003g = s4Var;
    }

    public final void m(PorterDuff.Mode mode) {
        boolean z10;
        if (this.f1004h == null) {
            this.f1004h = new s4();
        }
        s4 s4Var = this.f1004h;
        s4Var.f1056b = mode;
        if (mode != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        s4Var.f1057c = z10;
        this.f998b = s4Var;
        this.f999c = s4Var;
        this.f1000d = s4Var;
        this.f1001e = s4Var;
        this.f1002f = s4Var;
        this.f1003g = s4Var;
    }

    public final void n(Context context, u4 u4Var) {
        String j10;
        Typeface typeface;
        Typeface typeface2;
        this.f1006j = u4Var.h(2, this.f1006j);
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 >= 28) {
            int h10 = u4Var.h(11, -1);
            this.f1007k = h10;
            if (h10 != -1) {
                this.f1006j = (this.f1006j & 2) | 0;
            }
        }
        int i11 = 10;
        if (u4Var.l(10) || u4Var.l(12)) {
            this.f1008l = null;
            if (u4Var.l(12)) {
                i11 = 12;
            }
            int i12 = this.f1007k;
            int i13 = this.f1006j;
            if (!context.isRestricted()) {
                try {
                    Typeface g10 = u4Var.g(i11, this.f1006j, new j1(this, i12, i13, new WeakReference(this.f997a)));
                    if (g10 != null) {
                        if (i10 >= 28 && this.f1007k != -1) {
                            g10 = p1.a(Typeface.create(g10, 0), this.f1007k, (this.f1006j & 2) != 0);
                        }
                        this.f1008l = g10;
                    }
                    this.f1009m = this.f1008l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1008l == null && (j10 = u4Var.j(i11)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1007k == -1) {
                    typeface = Typeface.create(j10, this.f1006j);
                } else {
                    Typeface create = Typeface.create(j10, 0);
                    int i14 = this.f1007k;
                    if ((this.f1006j & 2) != 0) {
                        z10 = true;
                    }
                    typeface = p1.a(create, i14, z10);
                }
                this.f1008l = typeface;
            }
        } else if (u4Var.l(1)) {
            this.f1009m = false;
            int h11 = u4Var.h(1, 1);
            if (h11 == 1) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (h11 == 2) {
                typeface2 = Typeface.SERIF;
            } else if (h11 == 3) {
                typeface2 = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.f1008l = typeface2;
        }
    }
}

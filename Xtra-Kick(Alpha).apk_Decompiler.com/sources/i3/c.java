package i3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c extends View implements m0 {

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f8032h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List f8033i = Collections.emptyList();

    /* renamed from: j  reason: collision with root package name */
    public int f8034j = 0;

    /* renamed from: k  reason: collision with root package name */
    public float f8035k = 0.0533f;

    /* renamed from: l  reason: collision with root package name */
    public d f8036l = d.f8064g;

    /* renamed from: m  reason: collision with root package name */
    public float f8037m = 0.08f;

    public c(Context context) {
        super(context, (AttributeSet) null);
    }

    public final void a(List list, d dVar, float f10, int i10, float f11) {
        this.f8033i = list;
        this.f8036l = dVar;
        this.f8035k = f10;
        this.f8034j = i10;
        this.f8037m = f11;
        while (true) {
            ArrayList arrayList = this.f8032h;
            if (arrayList.size() < list.size()) {
                arrayList.add(new l0(getContext()));
            } else {
                invalidate();
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0441, code lost:
        if (r6 < r3) goto L_0x0451;
     */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x043c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x043f  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x04f2  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchDraw(android.graphics.Canvas r44) {
        /*
            r43 = this;
            r0 = r43
            r1 = r44
            java.util.List r2 = r0.f8033i
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            int r3 = r43.getHeight()
            int r4 = r43.getPaddingLeft()
            int r5 = r43.getPaddingTop()
            int r6 = r43.getWidth()
            int r7 = r43.getPaddingRight()
            int r6 = r6 - r7
            int r7 = r43.getPaddingBottom()
            int r7 = r3 - r7
            if (r7 <= r5) goto L_0x0528
            if (r6 > r4) goto L_0x002e
            goto L_0x0528
        L_0x002e:
            int r8 = r7 - r5
            int r9 = r0.f8034j
            float r10 = r0.f8035k
            float r9 = i3.n0.c(r10, r9, r3, r8)
            r10 = 0
            int r11 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r11 > 0) goto L_0x003e
            return
        L_0x003e:
            int r11 = r2.size()
            r13 = 0
        L_0x0043:
            if (r13 >= r11) goto L_0x0528
            java.lang.Object r14 = r2.get(r13)
            i1.b r14 = (i1.b) r14
            int r15 = r14.f7987w
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            r34 = 1065353216(0x3f800000, float:1.0)
            if (r15 == r12) goto L_0x00c3
            java.lang.CharSequence r15 = r14.f7972h
            android.graphics.Bitmap r12 = r14.f7975k
            android.text.Layout$Alignment r10 = r14.f7974j
            r35 = r2
            int r2 = r14.f7985u
            r36 = r11
            float r11 = r14.f7986v
            float r1 = r14.f7981q
            r37 = r7
            float r7 = r14.f7982r
            r38 = r6
            boolean r6 = r14.f7983s
            r39 = r5
            int r5 = r14.f7984t
            r40 = r4
            int r4 = r14.f7987w
            r41 = r9
            float r9 = r14.f7988x
            r24 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r18 = 0
            r42 = r13
            int r13 = r14.f7977m
            float r0 = r14.f7976l
            if (r13 != 0) goto L_0x008b
            float r0 = r34 - r0
            r21 = r0
            r22 = 0
            goto L_0x0092
        L_0x008b:
            float r0 = -r0
            float r0 = r0 - r34
            r21 = r0
            r22 = 1
        L_0x0092:
            int r0 = r14.f7978n
            if (r0 == 0) goto L_0x009f
            r13 = 2
            if (r0 == r13) goto L_0x009c
            r23 = r0
            goto L_0x00a1
        L_0x009c:
            r23 = 0
            goto L_0x00a1
        L_0x009f:
            r23 = 2
        L_0x00a1:
            i1.b r14 = new i1.b
            r16 = r14
            r17 = r15
            r19 = r10
            r20 = r12
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r25 = r0
            r26 = r2
            r27 = r11
            r28 = r1
            r29 = r7
            r30 = r6
            r31 = r5
            r32 = r4
            r33 = r9
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            goto L_0x00d3
        L_0x00c3:
            r35 = r2
            r40 = r4
            r39 = r5
            r38 = r6
            r37 = r7
            r41 = r9
            r36 = r11
            r42 = r13
        L_0x00d3:
            int r0 = r14.f7985u
            float r1 = r14.f7986v
            float r0 = i3.n0.c(r1, r0, r3, r8)
            r1 = r43
            java.util.ArrayList r2 = r1.f8032h
            r12 = r42
            java.lang.Object r2 = r2.get(r12)
            i3.l0 r2 = (i3.l0) r2
            i3.d r4 = r1.f8036l
            float r5 = r1.f8037m
            r2.getClass()
            android.graphics.Bitmap r6 = r14.f7975k
            if (r6 != 0) goto L_0x00f4
            r7 = 1
            goto L_0x00f5
        L_0x00f4:
            r7 = 0
        L_0x00f5:
            java.lang.CharSequence r9 = r14.f7972h
            if (r7 == 0) goto L_0x0113
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L_0x0109
            r9 = r44
            r23 = r3
            r24 = r8
            r42 = r12
            goto L_0x01ee
        L_0x0109:
            boolean r10 = r14.f7983s
            if (r10 == 0) goto L_0x0110
            int r10 = r14.f7984t
            goto L_0x0115
        L_0x0110:
            int r10 = r4.f8067c
            goto L_0x0115
        L_0x0113:
            r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x0115:
            java.lang.CharSequence r11 = r2.f8124i
            if (r11 == r9) goto L_0x0124
            if (r11 == 0) goto L_0x0122
            boolean r11 = r11.equals(r9)
            if (r11 == 0) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r11 = 0
            goto L_0x0125
        L_0x0124:
            r11 = 1
        L_0x0125:
            android.text.TextPaint r13 = r2.f8121f
            float r15 = r14.f7982r
            float r1 = r14.f7981q
            r23 = r3
            int r3 = r14.f7980p
            r24 = r8
            float r8 = r14.f7979o
            r42 = r12
            int r12 = r14.f7978n
            r16 = r9
            int r9 = r14.f7977m
            r25 = r7
            float r7 = r14.f7976l
            android.text.Layout$Alignment r14 = r14.f7973i
            if (r11 == 0) goto L_0x020c
            android.text.Layout$Alignment r11 = r2.f8125j
            boolean r11 = j1.l0.a(r11, r14)
            if (r11 == 0) goto L_0x020c
            android.graphics.Bitmap r11 = r2.f8126k
            if (r11 != r6) goto L_0x020c
            float r11 = r2.f8127l
            int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r11 != 0) goto L_0x020c
            int r11 = r2.f8128m
            if (r11 != r9) goto L_0x020c
            int r11 = r2.f8129n
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r17 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            boolean r9 = j1.l0.a(r11, r9)
            if (r9 == 0) goto L_0x0209
            float r9 = r2.f8130o
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x0209
            int r9 = r2.f8131p
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            boolean r9 = j1.l0.a(r9, r11)
            if (r9 == 0) goto L_0x0209
            float r9 = r2.f8132q
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 != 0) goto L_0x0209
            float r9 = r2.f8133r
            int r9 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r9 != 0) goto L_0x0209
            int r9 = r2.f8134s
            int r11 = r4.f8065a
            if (r9 != r11) goto L_0x0209
            int r9 = r2.f8135t
            int r11 = r4.f8066b
            if (r9 != r11) goto L_0x0209
            int r9 = r2.f8136u
            if (r9 != r10) goto L_0x0209
            int r9 = r2.f8138w
            int r11 = r4.f8068d
            if (r9 != r11) goto L_0x0209
            int r9 = r2.f8137v
            int r11 = r4.f8069e
            if (r9 != r11) goto L_0x0209
            android.graphics.Typeface r9 = r13.getTypeface()
            android.graphics.Typeface r11 = r4.f8070f
            boolean r9 = j1.l0.a(r9, r11)
            if (r9 == 0) goto L_0x0209
            float r9 = r2.f8139x
            int r9 = (r9 > r41 ? 1 : (r9 == r41 ? 0 : -1))
            if (r9 != 0) goto L_0x0209
            float r9 = r2.f8140y
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 != 0) goto L_0x0209
            float r9 = r2.f8141z
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0209
            int r9 = r2.A
            r11 = r40
            if (r9 != r11) goto L_0x0202
            int r9 = r2.B
            r40 = r11
            r11 = r39
            if (r9 != r11) goto L_0x01fd
            int r9 = r2.C
            r39 = r11
            r11 = r38
            if (r9 != r11) goto L_0x01f8
            int r9 = r2.D
            r38 = r11
            r11 = r37
            if (r9 != r11) goto L_0x01f3
            r9 = r44
            r37 = r11
            r11 = r25
            r2.a(r9, r11)
        L_0x01ee:
            r0 = r9
            r8 = 0
            r10 = 0
            goto L_0x050f
        L_0x01f3:
            r9 = r44
            r37 = r11
            goto L_0x0206
        L_0x01f8:
            r9 = r44
            r38 = r11
            goto L_0x0206
        L_0x01fd:
            r9 = r44
            r39 = r11
            goto L_0x0206
        L_0x0202:
            r9 = r44
            r40 = r11
        L_0x0206:
            r11 = r25
            goto L_0x0212
        L_0x0209:
            r9 = r44
            goto L_0x0206
        L_0x020c:
            r17 = r9
            r11 = r25
            r9 = r44
        L_0x0212:
            r9 = r16
            r2.f8124i = r9
            r2.f8125j = r14
            r2.f8126k = r6
            r2.f8127l = r7
            r6 = r17
            r2.f8128m = r6
            r2.f8129n = r12
            r2.f8130o = r8
            r2.f8131p = r3
            r2.f8132q = r1
            r2.f8133r = r15
            int r1 = r4.f8065a
            r2.f8134s = r1
            int r1 = r4.f8066b
            r2.f8135t = r1
            r2.f8136u = r10
            int r1 = r4.f8068d
            r2.f8138w = r1
            int r1 = r4.f8069e
            r2.f8137v = r1
            android.graphics.Typeface r1 = r4.f8070f
            r13.setTypeface(r1)
            r1 = r41
            r2.f8139x = r1
            r2.f8140y = r0
            r2.f8141z = r5
            r0 = r40
            r2.A = r0
            r3 = r39
            r2.B = r3
            r6 = r38
            r2.C = r6
            r4 = r37
            r2.D = r4
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            if (r11 == 0) goto L_0x048a
            java.lang.CharSequence r7 = r2.f8124i
            r7.getClass()
            java.lang.CharSequence r7 = r2.f8124i
            boolean r8 = r7 instanceof android.text.SpannableStringBuilder
            if (r8 == 0) goto L_0x026c
            android.text.SpannableStringBuilder r7 = (android.text.SpannableStringBuilder) r7
            goto L_0x0273
        L_0x026c:
            android.text.SpannableStringBuilder r7 = new android.text.SpannableStringBuilder
            java.lang.CharSequence r8 = r2.f8124i
            r7.<init>(r8)
        L_0x0273:
            int r8 = r2.C
            int r9 = r2.A
            int r8 = r8 - r9
            int r9 = r2.D
            int r10 = r2.B
            int r9 = r9 - r10
            float r10 = r2.f8139x
            r13.setTextSize(r10)
            float r10 = r2.f8139x
            r12 = 1040187392(0x3e000000, float:0.125)
            float r10 = r10 * r12
            r12 = 1056964608(0x3f000000, float:0.5)
            float r10 = r10 + r12
            int r10 = (int) r10
            int r12 = r10 * 2
            int r14 = r8 - r12
            float r15 = r2.f8132q
            int r16 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r16 == 0) goto L_0x029a
            float r14 = (float) r14
            float r14 = r14 * r15
            int r14 = (int) r14
        L_0x029a:
            java.lang.String r15 = "SubtitlePainter"
            if (r14 > 0) goto L_0x02b4
            java.lang.String r5 = "Skipped drawing subtitle cue (insufficient space)"
            j1.v.g(r15, r5)
            r40 = r0
            r41 = r1
            r39 = r3
            r37 = r4
            r38 = r6
            r1 = r11
            r8 = 0
            r10 = 0
            r0 = r44
            goto L_0x050c
        L_0x02b4:
            float r5 = r2.f8140y
            r40 = r0
            r16 = 0
            int r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x02d5
            android.text.style.AbsoluteSizeSpan r5 = new android.text.style.AbsoluteSizeSpan
            float r0 = r2.f8140y
            int r0 = (int) r0
            r5.<init>(r0)
            int r0 = r7.length()
            r41 = r1
            r39 = r3
            r1 = 16711680(0xff0000, float:2.3418052E-38)
            r3 = 0
            r7.setSpan(r5, r3, r0, r1)
            goto L_0x02da
        L_0x02d5:
            r41 = r1
            r39 = r3
            r3 = 0
        L_0x02da:
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>(r7)
            int r1 = r2.f8138w
            r5 = 1
            if (r1 != r5) goto L_0x0300
            int r1 = r0.length()
            java.lang.Class<android.text.style.ForegroundColorSpan> r5 = android.text.style.ForegroundColorSpan.class
            java.lang.Object[] r1 = r0.getSpans(r3, r1, r5)
            android.text.style.ForegroundColorSpan[] r1 = (android.text.style.ForegroundColorSpan[]) r1
            int r3 = r1.length
            r5 = 0
        L_0x02f2:
            if (r5 >= r3) goto L_0x0300
            r17 = r3
            r3 = r1[r5]
            r0.removeSpan(r3)
            int r5 = r5 + 1
            r3 = r17
            goto L_0x02f2
        L_0x0300:
            int r1 = r2.f8135t
            int r1 = android.graphics.Color.alpha(r1)
            if (r1 <= 0) goto L_0x0338
            int r1 = r2.f8138w
            if (r1 == 0) goto L_0x0324
            r3 = 2
            if (r1 != r3) goto L_0x0310
            goto L_0x0324
        L_0x0310:
            android.text.style.BackgroundColorSpan r1 = new android.text.style.BackgroundColorSpan
            int r3 = r2.f8135t
            r1.<init>(r3)
            int r3 = r0.length()
            r37 = r4
            r4 = 0
            r5 = 16711680(0xff0000, float:2.3418052E-38)
            r0.setSpan(r1, r4, r3, r5)
            goto L_0x033a
        L_0x0324:
            r37 = r4
            r4 = 0
            r5 = 16711680(0xff0000, float:2.3418052E-38)
            android.text.style.BackgroundColorSpan r1 = new android.text.style.BackgroundColorSpan
            int r3 = r2.f8135t
            r1.<init>(r3)
            int r3 = r7.length()
            r7.setSpan(r1, r4, r3, r5)
            goto L_0x033a
        L_0x0338:
            r37 = r4
        L_0x033a:
            android.text.Layout$Alignment r1 = r2.f8125j
            if (r1 != 0) goto L_0x0340
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x0340:
            android.text.StaticLayout r3 = new android.text.StaticLayout
            float r4 = r2.f8119d
            float r5 = r2.f8120e
            r22 = 1
            r38 = r6
            r6 = r15
            r15 = r3
            r16 = r7
            r17 = r13
            r18 = r14
            r19 = r1
            r20 = r4
            r21 = r5
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r2.E = r3
            int r3 = r3.getHeight()
            android.text.StaticLayout r4 = r2.E
            int r4 = r4.getLineCount()
            r5 = 0
            r15 = 0
        L_0x0369:
            if (r5 >= r4) goto L_0x038a
            r16 = r4
            android.text.StaticLayout r4 = r2.E
            float r4 = r4.getLineWidth(r5)
            r27 = r10
            r26 = r11
            double r10 = (double) r4
            double r10 = java.lang.Math.ceil(r10)
            int r4 = (int) r10
            int r15 = java.lang.Math.max(r4, r15)
            int r5 = r5 + 1
            r4 = r16
            r11 = r26
            r10 = r27
            goto L_0x0369
        L_0x038a:
            r27 = r10
            r26 = r11
            float r4 = r2.f8132q
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x039a
            if (r15 >= r14) goto L_0x039a
            goto L_0x039b
        L_0x039a:
            r14 = r15
        L_0x039b:
            int r14 = r14 + r12
            float r4 = r2.f8130o
            int r10 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x03c8
            float r5 = (float) r8
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r2.A
            int r4 = r4 + r5
            int r8 = r2.f8131p
            r10 = 1
            if (r8 == r10) goto L_0x03b7
            r10 = 2
            if (r8 == r10) goto L_0x03b5
            goto L_0x03bc
        L_0x03b5:
            int r4 = r4 - r14
            goto L_0x03bc
        L_0x03b7:
            r10 = 2
            int r4 = r4 * 2
            int r4 = r4 - r14
            int r4 = r4 / r10
        L_0x03bc:
            int r4 = java.lang.Math.max(r4, r5)
            int r14 = r14 + r4
            int r5 = r2.C
            int r5 = java.lang.Math.min(r14, r5)
            goto L_0x03d0
        L_0x03c8:
            r10 = 2
            int r8 = r8 - r14
            int r8 = r8 / r10
            int r4 = r2.A
            int r4 = r4 + r8
            int r5 = r4 + r14
        L_0x03d0:
            int r5 = r5 - r4
            if (r5 > 0) goto L_0x03e0
            java.lang.String r0 = "Skipped drawing subtitle cue (invalid horizontal positioning)"
            j1.v.g(r6, r0)
            r0 = r44
            r1 = r26
            r8 = 0
            r10 = 0
            goto L_0x050c
        L_0x03e0:
            float r6 = r2.f8127l
            r8 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0444
            int r8 = r2.f8128m
            if (r8 != 0) goto L_0x0409
            float r8 = (float) r9
            float r8 = r8 * r6
            int r6 = java.lang.Math.round(r8)
            int r8 = r2.B
            int r6 = r6 + r8
            int r8 = r2.f8129n
            r9 = 2
            if (r8 != r9) goto L_0x03ff
            r8 = 0
            r10 = 0
            goto L_0x0435
        L_0x03ff:
            r10 = 1
            if (r8 != r10) goto L_0x0406
            int r6 = r6 * 2
            int r6 = r6 - r3
            int r6 = r6 / r9
        L_0x0406:
            r8 = 0
            r10 = 0
            goto L_0x0436
        L_0x0409:
            android.text.StaticLayout r6 = r2.E
            r8 = 0
            int r6 = r6.getLineBottom(r8)
            android.text.StaticLayout r9 = r2.E
            int r9 = r9.getLineTop(r8)
            int r6 = r6 - r9
            float r9 = r2.f8127l
            r10 = 0
            int r11 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x0429
            float r6 = (float) r6
            float r9 = r9 * r6
            int r6 = java.lang.Math.round(r9)
            int r9 = r2.B
            int r6 = r6 + r9
            goto L_0x0436
        L_0x0429:
            float r9 = r9 + r34
            float r6 = (float) r6
            float r9 = r9 * r6
            int r6 = java.lang.Math.round(r9)
            int r9 = r2.D
            int r6 = r6 + r9
        L_0x0435:
            int r6 = r6 - r3
        L_0x0436:
            int r9 = r6 + r3
            int r11 = r2.D
            if (r9 <= r11) goto L_0x043f
            int r6 = r11 - r3
            goto L_0x0450
        L_0x043f:
            int r3 = r2.B
            if (r6 >= r3) goto L_0x0450
            goto L_0x0451
        L_0x0444:
            r8 = 0
            r10 = 0
            int r6 = r2.D
            int r6 = r6 - r3
            float r3 = (float) r9
            float r9 = r2.f8141z
            float r3 = r3 * r9
            int r3 = (int) r3
            int r6 = r6 - r3
        L_0x0450:
            r3 = r6
        L_0x0451:
            android.text.StaticLayout r6 = new android.text.StaticLayout
            float r9 = r2.f8119d
            float r11 = r2.f8120e
            r12 = 1
            r22 = 1
            r15 = r6
            r16 = r7
            r17 = r13
            r18 = r5
            r19 = r1
            r20 = r9
            r21 = r11
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r2.E = r6
            android.text.StaticLayout r6 = new android.text.StaticLayout
            float r7 = r2.f8119d
            float r9 = r2.f8120e
            r15 = r6
            r16 = r0
            r20 = r7
            r21 = r9
            r22 = r12
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r2.F = r6
            r2.G = r4
            r2.H = r3
            r0 = r27
            r2.I = r0
            goto L_0x0508
        L_0x048a:
            r40 = r0
            r41 = r1
            r39 = r3
            r37 = r4
            r38 = r6
            r26 = r11
            r8 = 0
            r10 = 0
            android.graphics.Bitmap r0 = r2.f8126k
            r0.getClass()
            android.graphics.Bitmap r0 = r2.f8126k
            int r1 = r2.C
            int r3 = r2.A
            int r1 = r1 - r3
            int r4 = r2.D
            int r5 = r2.B
            int r4 = r4 - r5
            float r3 = (float) r3
            float r1 = (float) r1
            float r6 = r2.f8130o
            float r6 = r6 * r1
            float r6 = r6 + r3
            float r3 = (float) r5
            float r4 = (float) r4
            float r5 = r2.f8127l
            float r5 = r5 * r4
            float r5 = r5 + r3
            float r3 = r2.f8132q
            float r1 = r1 * r3
            int r1 = java.lang.Math.round(r1)
            float r3 = r2.f8133r
            r7 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x04c9
            goto L_0x04d5
        L_0x04c9:
            float r3 = (float) r1
            int r4 = r0.getHeight()
            float r4 = (float) r4
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r4 = r4 / r0
        L_0x04d5:
            float r4 = r4 * r3
            int r0 = java.lang.Math.round(r4)
            int r3 = r2.f8131p
            r4 = 2
            if (r3 != r4) goto L_0x04e2
            float r3 = (float) r1
            goto L_0x04e8
        L_0x04e2:
            r4 = 1
            if (r3 != r4) goto L_0x04e9
            int r3 = r1 / 2
            float r3 = (float) r3
        L_0x04e8:
            float r6 = r6 - r3
        L_0x04e9:
            int r3 = java.lang.Math.round(r6)
            int r4 = r2.f8129n
            r6 = 2
            if (r4 != r6) goto L_0x04f4
            float r4 = (float) r0
            goto L_0x04fa
        L_0x04f4:
            r6 = 1
            if (r4 != r6) goto L_0x04fb
            int r4 = r0 / 2
            float r4 = (float) r4
        L_0x04fa:
            float r5 = r5 - r4
        L_0x04fb:
            int r4 = java.lang.Math.round(r5)
            android.graphics.Rect r5 = new android.graphics.Rect
            int r1 = r1 + r3
            int r0 = r0 + r4
            r5.<init>(r3, r4, r1, r0)
            r2.J = r5
        L_0x0508:
            r0 = r44
            r1 = r26
        L_0x050c:
            r2.a(r0, r1)
        L_0x050f:
            int r13 = r42 + 1
            r1 = r0
            r3 = r23
            r8 = r24
            r2 = r35
            r11 = r36
            r7 = r37
            r6 = r38
            r5 = r39
            r4 = r40
            r9 = r41
            r0 = r43
            goto L_0x0043
        L_0x0528:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.c.dispatchDraw(android.graphics.Canvas):void");
    }
}

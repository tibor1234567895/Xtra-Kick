package i3;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import i1.b;
import j1.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class t0 extends FrameLayout implements m0 {

    /* renamed from: h  reason: collision with root package name */
    public final c f8170h;

    /* renamed from: i  reason: collision with root package name */
    public final r0 f8171i;

    /* renamed from: j  reason: collision with root package name */
    public List f8172j = Collections.emptyList();

    /* renamed from: k  reason: collision with root package name */
    public d f8173k = d.f8064g;

    /* renamed from: l  reason: collision with root package name */
    public float f8174l = 0.0533f;

    /* renamed from: m  reason: collision with root package name */
    public int f8175m = 0;

    /* renamed from: n  reason: collision with root package name */
    public float f8176n = 0.08f;

    public t0(Context context) {
        super(context, (AttributeSet) null);
        c cVar = new c(context);
        this.f8170h = cVar;
        r0 r0Var = new r0(context);
        this.f8171i = r0Var;
        r0Var.setBackgroundColor(0);
        addView(cVar);
        addView(r0Var);
    }

    public static int b(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? 0 : -100;
        }
        return -50;
    }

    public final void a(List list, d dVar, float f10, int i10, float f11) {
        this.f8173k = dVar;
        this.f8174l = f10;
        this.f8175m = i10;
        this.f8176n = f11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            b bVar = (b) list.get(i11);
            if (bVar.f7975k != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f8172j.isEmpty() || !arrayList2.isEmpty()) {
            this.f8172j = arrayList2;
            d();
        }
        this.f8170h.a(arrayList, dVar, f10, i10, f11);
        invalidate();
    }

    public final String c(int i10, float f10) {
        float c10 = n0.c(f10, i10, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (c10 == -3.4028235E38f) {
            return "unset";
        }
        return l0.l("%.2fpx", Float.valueOf(c10 / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v3, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x046e, code lost:
        if (((android.text.style.TypefaceSpan) r4).getFamily() != null) goto L_0x04bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01c6, code lost:
        if (r13 != false) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01c9, code lost:
        if (r13 != false) goto L_0x01ce;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x05a0  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x060f  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x062f  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0655  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0680  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x04fa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r40 = this;
            r0 = r40
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 4
            java.lang.Object[] r3 = new java.lang.Object[r2]
            i3.d r4 = r0.f8173k
            int r4 = r4.f8065a
            java.lang.String r4 = i3.g.a(r4)
            r5 = 0
            r3[r5] = r4
            int r4 = r0.f8175m
            float r6 = r0.f8174l
            java.lang.String r4 = r0.c(r4, r6)
            r6 = 1
            r3[r6] = r4
            r4 = 1067030938(0x3f99999a, float:1.2)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r7 = 2
            r3[r7] = r4
            i3.d r4 = r0.f8173k
            int r8 = r4.f8068d
            java.lang.String r9 = "unset"
            r10 = 3
            int r4 = r4.f8069e
            if (r8 == r6) goto L_0x006a
            if (r8 == r7) goto L_0x005b
            if (r8 == r10) goto L_0x004c
            if (r8 == r2) goto L_0x003d
            r2 = r9
            goto L_0x0078
        L_0x003d:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r4 = i3.g.a(r4)
            r2[r5] = r4
            java.lang.String r4 = "-0.05em -0.05em 0.15em %s"
            java.lang.String r2 = j1.l0.l(r4, r2)
            goto L_0x0078
        L_0x004c:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r4 = i3.g.a(r4)
            r2[r5] = r4
            java.lang.String r4 = "0.06em 0.08em 0.15em %s"
            java.lang.String r2 = j1.l0.l(r4, r2)
            goto L_0x0078
        L_0x005b:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r4 = i3.g.a(r4)
            r2[r5] = r4
            java.lang.String r4 = "0.1em 0.12em 0.15em %s"
            java.lang.String r2 = j1.l0.l(r4, r2)
            goto L_0x0078
        L_0x006a:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r4 = i3.g.a(r4)
            r2[r5] = r4
            java.lang.String r4 = "1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s"
            java.lang.String r2 = j1.l0.l(r4, r2)
        L_0x0078:
            r3[r10] = r2
            java.lang.String r2 = "<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>"
            java.lang.String r2 = j1.l0.l(r2, r3)
            r1.append(r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            i3.d r4 = r0.f8173k
            int r4 = r4.f8066b
            java.lang.String r4 = i3.g.a(r4)
            r3[r5] = r4
            java.lang.String r4 = "background-color:%s;"
            java.lang.String r3 = j1.l0.l(r4, r3)
            java.lang.String r7 = ".default_bg,.default_bg *"
            r2.put(r7, r3)
            r3 = 0
        L_0x00a0:
            java.util.List r7 = r0.f8172j
            int r7 = r7.size()
            if (r3 >= r7) goto L_0x069d
            java.util.List r7 = r0.f8172j
            java.lang.Object r7 = r7.get(r3)
            i1.b r7 = (i1.b) r7
            float r8 = r7.f7979o
            r10 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r11 = 1120403456(0x42c80000, float:100.0)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x00be
            float r8 = r8 * r11
            goto L_0x00c0
        L_0x00be:
            r8 = 1112014848(0x42480000, float:50.0)
        L_0x00c0:
            int r12 = r7.f7980p
            int r12 = b(r12)
            java.lang.String r15 = "%.2f%%"
            int r14 = r7.f7987w
            float r13 = r7.f7976l
            int r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r10 == 0) goto L_0x0126
            int r10 = r7.f7977m
            if (r10 == r6) goto L_0x00f1
            java.lang.Object[] r10 = new java.lang.Object[r6]
            float r13 = r13 * r11
            java.lang.Float r11 = java.lang.Float.valueOf(r13)
            r10[r5] = r11
            java.lang.String r5 = j1.l0.l(r15, r10)
            int r10 = r7.f7978n
            int r10 = b(r10)
            if (r14 != r6) goto L_0x00eb
            int r10 = -r10
        L_0x00eb:
            r11 = 1120403456(0x42c80000, float:100.0)
            r13 = 0
        L_0x00ee:
            r16 = r9
            goto L_0x0144
        L_0x00f1:
            java.lang.String r10 = "%.2fem"
            r11 = 0
            int r17 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            java.lang.Object[] r11 = new java.lang.Object[r6]
            if (r17 < 0) goto L_0x010c
            r16 = 1067030938(0x3f99999a, float:1.2)
            float r13 = r13 * r16
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            r11[r5] = r13
            java.lang.String r5 = j1.l0.l(r10, r11)
            r10 = 0
            r13 = 0
            goto L_0x0122
        L_0x010c:
            float r13 = -r13
            r16 = 1065353216(0x3f800000, float:1.0)
            float r13 = r13 - r16
            r16 = 1067030938(0x3f99999a, float:1.2)
            float r13 = r13 * r16
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            r11[r5] = r13
            java.lang.String r5 = j1.l0.l(r10, r11)
            r10 = 1
            r13 = 1
        L_0x0122:
            r11 = 1120403456(0x42c80000, float:100.0)
            r10 = 0
            goto L_0x00ee
        L_0x0126:
            java.lang.Object[] r10 = new java.lang.Object[r6]
            float r11 = r0.f8176n
            r13 = 1065353216(0x3f800000, float:1.0)
            float r11 = r13 - r11
            r13 = 1120403456(0x42c80000, float:100.0)
            float r11 = r11 * r13
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r10[r5] = r11
            java.lang.String r5 = j1.l0.l(r15, r10)
            r10 = -100
            r11 = 0
            r16 = r9
            r11 = 1120403456(0x42c80000, float:100.0)
            r13 = 0
        L_0x0144:
            float r9 = r7.f7981q
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r17 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r17 == 0) goto L_0x015d
            java.lang.Object[] r6 = new java.lang.Object[r6]
            float r9 = r9 * r11
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r11 = 0
            r6[r11] = r9
            java.lang.String r6 = j1.l0.l(r15, r6)
            goto L_0x015f
        L_0x015d:
            java.lang.String r6 = "fit-content"
        L_0x015f:
            java.lang.String r9 = "end"
            java.lang.String r11 = "start"
            java.lang.String r15 = "center"
            r17 = r9
            android.text.Layout$Alignment r9 = r7.f7973i
            if (r9 != 0) goto L_0x0172
            r9 = 2
            r18 = r10
            r19 = r11
            r10 = r15
            goto L_0x018e
        L_0x0172:
            int[] r18 = i3.s0.f8164a
            int r9 = r9.ordinal()
            r9 = r18[r9]
            r18 = r10
            r10 = 1
            if (r9 == r10) goto L_0x018a
            r10 = 2
            r19 = r11
            if (r9 == r10) goto L_0x0186
            r10 = r15
            goto L_0x0188
        L_0x0186:
            r10 = r17
        L_0x0188:
            r9 = 2
            goto L_0x018e
        L_0x018a:
            r9 = 2
            r10 = r11
            r19 = r10
        L_0x018e:
            r11 = 1
            if (r14 == r11) goto L_0x0199
            if (r14 == r9) goto L_0x0196
            java.lang.String r9 = "horizontal-tb"
            goto L_0x019b
        L_0x0196:
            java.lang.String r9 = "vertical-lr"
            goto L_0x019b
        L_0x0199:
            java.lang.String r9 = "vertical-rl"
        L_0x019b:
            int r11 = r7.f7985u
            r20 = r12
            float r12 = r7.f7986v
            java.lang.String r11 = r0.c(r11, r12)
            boolean r12 = r7.f7983s
            if (r12 == 0) goto L_0x01ac
            int r12 = r7.f7984t
            goto L_0x01b0
        L_0x01ac:
            i3.d r12 = r0.f8173k
            int r12 = r12.f8067c
        L_0x01b0:
            java.lang.String r12 = i3.g.a(r12)
            java.lang.String r21 = "left"
            java.lang.String r22 = "top"
            r23 = r15
            r15 = 1
            if (r14 == r15) goto L_0x01c9
            r15 = 2
            if (r14 == r15) goto L_0x01c6
            if (r13 == 0) goto L_0x01c4
            java.lang.String r22 = "bottom"
        L_0x01c4:
            r13 = 2
            goto L_0x01d5
        L_0x01c6:
            if (r13 == 0) goto L_0x01ce
            goto L_0x01cc
        L_0x01c9:
            if (r13 == 0) goto L_0x01cc
            goto L_0x01ce
        L_0x01cc:
            java.lang.String r21 = "right"
        L_0x01ce:
            r13 = 2
            r39 = r22
            r22 = r21
            r21 = r39
        L_0x01d5:
            if (r14 == r13) goto L_0x01e4
            r13 = 1
            if (r14 != r13) goto L_0x01db
            goto L_0x01e4
        L_0x01db:
            java.lang.String r13 = "width"
            r39 = r20
            r20 = r18
            r18 = r39
            goto L_0x01e6
        L_0x01e4:
            java.lang.String r13 = "height"
        L_0x01e6:
            android.content.Context r15 = r40.getContext()
            android.content.res.Resources r15 = r15.getResources()
            android.util.DisplayMetrics r15 = r15.getDisplayMetrics()
            float r15 = r15.density
            java.util.regex.Pattern r24 = i3.k0.f8115a
            java.lang.String r24 = "</span>"
            java.lang.String r0 = ""
            r25 = r1
            java.lang.CharSequence r1 = r7.f7972h
            if (r1 != 0) goto L_0x020a
            android.support.v4.media.n r1 = new android.support.v4.media.n
            d9.w1 r15 = d9.w1.f4691n
            r1.<init>((java.lang.String) r0, (java.util.Map) r15)
            r26 = r0
            goto L_0x021c
        L_0x020a:
            r26 = r0
            boolean r0 = r1 instanceof android.text.Spanned
            if (r0 != 0) goto L_0x022e
            android.support.v4.media.n r0 = new android.support.v4.media.n
            java.lang.String r1 = i3.k0.a(r1)
            d9.w1 r15 = d9.w1.f4691n
            r0.<init>((java.lang.String) r1, (java.util.Map) r15)
            r1 = r0
        L_0x021c:
            r30 = r4
            r38 = r6
            r28 = r7
            r35 = r9
            r37 = r10
            r31 = r11
            r29 = r12
            r27 = r14
            goto L_0x0592
        L_0x022e:
            android.text.Spanned r1 = (android.text.Spanned) r1
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r27 = r14
            int r14 = r1.length()
            r28 = r7
            java.lang.Class<android.text.style.BackgroundColorSpan> r7 = android.text.style.BackgroundColorSpan.class
            r29 = r12
            r12 = 0
            java.lang.Object[] r7 = r1.getSpans(r12, r14, r7)
            android.text.style.BackgroundColorSpan[] r7 = (android.text.style.BackgroundColorSpan[]) r7
            int r12 = r7.length
            r14 = 0
        L_0x024a:
            if (r14 >= r12) goto L_0x0260
            r30 = r7[r14]
            int r30 = r30.getBackgroundColor()
            r31 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r30)
            r0.add(r7)
            int r14 = r14 + 1
            r7 = r31
            goto L_0x024a
        L_0x0260:
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0269:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x02b4
            java.lang.Object r12 = r0.next()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            java.lang.String r14 = "bg_"
            java.lang.String r14 = android.support.v4.media.h.i(r14, r12)
            r30 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r31 = r11
            java.lang.String r11 = "."
            r0.<init>(r11)
            r0.append(r14)
            java.lang.String r11 = ",."
            r0.append(r11)
            r0.append(r14)
            java.lang.String r11 = " *"
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r11 = 1
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r12 = i3.g.a(r12)
            r14 = 0
            r11[r14] = r12
            java.lang.String r11 = j1.l0.l(r4, r11)
            r7.put(r0, r11)
            r0 = r30
            r11 = r31
            goto L_0x0269
        L_0x02b4:
            r31 = r11
            r0 = 0
            android.util.SparseArray r11 = new android.util.SparseArray
            r11.<init>()
            int r12 = r1.length()
            java.lang.Class<java.lang.Object> r14 = java.lang.Object.class
            java.lang.Object[] r0 = r1.getSpans(r0, r12, r14)
            int r12 = r0.length
            r14 = 0
        L_0x02c8:
            if (r14 >= r12) goto L_0x050c
            r30 = r4
            r4 = r0[r14]
            r32 = r0
            boolean r0 = r4 instanceof android.text.style.StrikethroughSpan
            r33 = 0
            if (r0 == 0) goto L_0x02e6
            java.lang.String r34 = "<span style='text-decoration:line-through;'>"
            r38 = r6
            r35 = r9
            r37 = r10
            r36 = r15
            r9 = r34
            r34 = r12
            goto L_0x0448
        L_0x02e6:
            r34 = r12
            boolean r12 = r4 instanceof android.text.style.ForegroundColorSpan
            if (r12 == 0) goto L_0x030e
            r12 = r4
            android.text.style.ForegroundColorSpan r12 = (android.text.style.ForegroundColorSpan) r12
            r35 = r9
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]
            int r12 = r12.getForegroundColor()
            java.lang.String r12 = i3.g.a(r12)
            r36 = 0
            r9[r36] = r12
            java.lang.String r12 = "<span style='color:%s;'>"
            java.lang.String r9 = j1.l0.l(r12, r9)
        L_0x0306:
            r38 = r6
            r37 = r10
            r36 = r15
            goto L_0x0448
        L_0x030e:
            r35 = r9
            r9 = 1
            boolean r12 = r4 instanceof android.text.style.BackgroundColorSpan
            if (r12 == 0) goto L_0x032d
            r12 = r4
            android.text.style.BackgroundColorSpan r12 = (android.text.style.BackgroundColorSpan) r12
            java.lang.Object[] r9 = new java.lang.Object[r9]
            int r12 = r12.getBackgroundColor()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r36 = 0
            r9[r36] = r12
            java.lang.String r12 = "<span class='bg_%s'>"
            java.lang.String r9 = j1.l0.l(r12, r9)
            goto L_0x0306
        L_0x032d:
            boolean r9 = r4 instanceof i1.e
            if (r9 == 0) goto L_0x0334
            java.lang.String r9 = "<span style='text-combine-upright:all;'>"
            goto L_0x0306
        L_0x0334:
            boolean r9 = r4 instanceof android.text.style.AbsoluteSizeSpan
            if (r9 == 0) goto L_0x035a
            r9 = r4
            android.text.style.AbsoluteSizeSpan r9 = (android.text.style.AbsoluteSizeSpan) r9
            boolean r12 = r9.getDip()
            int r9 = r9.getSize()
            float r9 = (float) r9
            if (r12 == 0) goto L_0x0347
            goto L_0x0348
        L_0x0347:
            float r9 = r9 / r15
        L_0x0348:
            r12 = 1
            java.lang.Object[] r12 = new java.lang.Object[r12]
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r36 = 0
            r12[r36] = r9
            java.lang.String r9 = "<span style='font-size:%.2fpx;'>"
            java.lang.String r9 = j1.l0.l(r9, r12)
            goto L_0x0306
        L_0x035a:
            r9 = 1
            boolean r12 = r4 instanceof android.text.style.RelativeSizeSpan
            if (r12 == 0) goto L_0x037b
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r12 = r4
            android.text.style.RelativeSizeSpan r12 = (android.text.style.RelativeSizeSpan) r12
            float r12 = r12.getSizeChange()
            r37 = 1120403456(0x42c80000, float:100.0)
            float r12 = r12 * r37
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            r36 = 0
            r9[r36] = r12
            java.lang.String r12 = "<span style='font-size:%.2f%%;'>"
            java.lang.String r9 = j1.l0.l(r12, r9)
            goto L_0x0306
        L_0x037b:
            r36 = 0
            boolean r9 = r4 instanceof android.text.style.TypefaceSpan
            if (r9 == 0) goto L_0x039f
            r9 = r4
            android.text.style.TypefaceSpan r9 = (android.text.style.TypefaceSpan) r9
            java.lang.String r9 = r9.getFamily()
            if (r9 == 0) goto L_0x0397
            r12 = 1
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r36] = r9
            java.lang.String r9 = "<span style='font-family:\"%s\";'>"
            java.lang.String r9 = j1.l0.l(r9, r12)
            goto L_0x0306
        L_0x0397:
            r38 = r6
            r37 = r10
            r36 = r15
            goto L_0x0446
        L_0x039f:
            r9 = 1
            boolean r12 = r4 instanceof android.text.style.StyleSpan
            if (r12 == 0) goto L_0x03c0
            r12 = r4
            android.text.style.StyleSpan r12 = (android.text.style.StyleSpan) r12
            int r12 = r12.getStyle()
            if (r12 == r9) goto L_0x03bc
            r9 = 2
            if (r12 == r9) goto L_0x03b8
            r9 = 3
            if (r12 == r9) goto L_0x03b4
            goto L_0x0397
        L_0x03b4:
            java.lang.String r9 = "<b><i>"
            goto L_0x0306
        L_0x03b8:
            java.lang.String r9 = "<i>"
            goto L_0x0306
        L_0x03bc:
            java.lang.String r9 = "<b>"
            goto L_0x0306
        L_0x03c0:
            boolean r9 = r4 instanceof i1.g
            if (r9 == 0) goto L_0x03df
            r9 = r4
            i1.g r9 = (i1.g) r9
            int r9 = r9.f7997b
            r12 = -1
            if (r9 == r12) goto L_0x03db
            r12 = 1
            if (r9 == r12) goto L_0x03d7
            r12 = 2
            if (r9 == r12) goto L_0x03d3
            goto L_0x0397
        L_0x03d3:
            java.lang.String r9 = "<ruby style='ruby-position:under;'>"
            goto L_0x0306
        L_0x03d7:
            java.lang.String r9 = "<ruby style='ruby-position:over;'>"
            goto L_0x0306
        L_0x03db:
            java.lang.String r9 = "<ruby style='ruby-position:unset;'>"
            goto L_0x0306
        L_0x03df:
            boolean r9 = r4 instanceof android.text.style.UnderlineSpan
            if (r9 == 0) goto L_0x03e7
            java.lang.String r9 = "<u>"
            goto L_0x0306
        L_0x03e7:
            boolean r9 = r4 instanceof i1.i
            if (r9 == 0) goto L_0x0397
            r9 = r4
            i1.i r9 = (i1.i) r9
            int r12 = r9.f7998a
            r36 = r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r37 = r10
            int r10 = r9.f7999b
            r38 = r6
            r6 = 1
            if (r10 == r6) goto L_0x0407
            r6 = 2
            if (r10 == r6) goto L_0x0404
            goto L_0x040d
        L_0x0404:
            java.lang.String r10 = "open "
            goto L_0x040a
        L_0x0407:
            r6 = 2
            java.lang.String r10 = "filled "
        L_0x040a:
            r15.append(r10)
        L_0x040d:
            if (r12 == 0) goto L_0x0423
            r10 = 1
            if (r12 == r10) goto L_0x0420
            if (r12 == r6) goto L_0x041d
            r6 = 3
            if (r12 == r6) goto L_0x041a
            r6 = r16
            goto L_0x0425
        L_0x041a:
            java.lang.String r6 = "sesame"
            goto L_0x0425
        L_0x041d:
            java.lang.String r6 = "dot"
            goto L_0x0425
        L_0x0420:
            java.lang.String r6 = "circle"
            goto L_0x0425
        L_0x0423:
            java.lang.String r6 = "none"
        L_0x0425:
            r15.append(r6)
            java.lang.String r6 = r15.toString()
            int r9 = r9.f8000c
            r10 = 2
            if (r9 == r10) goto L_0x0434
            java.lang.String r9 = "over right"
            goto L_0x0436
        L_0x0434:
            java.lang.String r9 = "under left"
        L_0x0436:
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r12 = 0
            r10[r12] = r6
            r6 = 1
            r10[r6] = r9
            java.lang.String r6 = "<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>"
            java.lang.String r6 = j1.l0.l(r6, r10)
            r9 = r6
            goto L_0x0448
        L_0x0446:
            r9 = r33
        L_0x0448:
            if (r0 != 0) goto L_0x04bc
            boolean r0 = r4 instanceof android.text.style.ForegroundColorSpan
            if (r0 != 0) goto L_0x04bc
            boolean r0 = r4 instanceof android.text.style.BackgroundColorSpan
            if (r0 != 0) goto L_0x04bc
            boolean r0 = r4 instanceof i1.e
            if (r0 != 0) goto L_0x04bc
            boolean r0 = r4 instanceof android.text.style.AbsoluteSizeSpan
            if (r0 != 0) goto L_0x04bc
            boolean r0 = r4 instanceof android.text.style.RelativeSizeSpan
            if (r0 != 0) goto L_0x04bc
            boolean r0 = r4 instanceof i1.i
            if (r0 == 0) goto L_0x0463
            goto L_0x04bc
        L_0x0463:
            boolean r0 = r4 instanceof android.text.style.TypefaceSpan
            if (r0 == 0) goto L_0x0471
            r0 = r4
            android.text.style.TypefaceSpan r0 = (android.text.style.TypefaceSpan) r0
            java.lang.String r0 = r0.getFamily()
            if (r0 == 0) goto L_0x04b9
            goto L_0x04bc
        L_0x0471:
            boolean r0 = r4 instanceof android.text.style.StyleSpan
            if (r0 == 0) goto L_0x048f
            r0 = r4
            android.text.style.StyleSpan r0 = (android.text.style.StyleSpan) r0
            int r0 = r0.getStyle()
            r6 = 1
            if (r0 == r6) goto L_0x048c
            r6 = 2
            if (r0 == r6) goto L_0x0489
            r6 = 3
            if (r0 == r6) goto L_0x0486
            goto L_0x04b9
        L_0x0486:
            java.lang.String r0 = "</i></b>"
            goto L_0x04af
        L_0x0489:
            java.lang.String r0 = "</i>"
            goto L_0x04af
        L_0x048c:
            java.lang.String r0 = "</b>"
            goto L_0x04af
        L_0x048f:
            boolean r0 = r4 instanceof i1.g
            if (r0 == 0) goto L_0x04b2
            r0 = r4
            i1.g r0 = (i1.g) r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r10 = "<rt>"
            r6.<init>(r10)
            java.lang.String r0 = r0.f7996a
            java.lang.String r0 = i3.k0.a(r0)
            r6.append(r0)
            java.lang.String r0 = "</rt></ruby>"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
        L_0x04af:
            r33 = r0
            goto L_0x04b9
        L_0x04b2:
            boolean r0 = r4 instanceof android.text.style.UnderlineSpan
            if (r0 == 0) goto L_0x04b9
            java.lang.String r0 = "</u>"
            goto L_0x04af
        L_0x04b9:
            r0 = r33
            goto L_0x04be
        L_0x04bc:
            r0 = r24
        L_0x04be:
            int r6 = r1.getSpanStart(r4)
            int r4 = r1.getSpanEnd(r4)
            if (r9 == 0) goto L_0x04fa
            r0.getClass()
            i3.i0 r10 = new i3.i0
            r10.<init>(r6, r4, r9, r0)
            java.lang.Object r0 = r11.get(r6)
            i3.j0 r0 = (i3.j0) r0
            if (r0 != 0) goto L_0x04e0
            i3.j0 r0 = new i3.j0
            r0.<init>()
            r11.put(r6, r0)
        L_0x04e0:
            java.util.ArrayList r0 = r0.f8112a
            r0.add(r10)
            java.lang.Object r0 = r11.get(r4)
            i3.j0 r0 = (i3.j0) r0
            if (r0 != 0) goto L_0x04f5
            i3.j0 r0 = new i3.j0
            r0.<init>()
            r11.put(r4, r0)
        L_0x04f5:
            java.util.ArrayList r0 = r0.f8113b
            r0.add(r10)
        L_0x04fa:
            int r14 = r14 + 1
            r4 = r30
            r0 = r32
            r12 = r34
            r9 = r35
            r15 = r36
            r10 = r37
            r6 = r38
            goto L_0x02c8
        L_0x050c:
            r30 = r4
            r38 = r6
            r35 = r9
            r37 = r10
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r4 = r1.length()
            r0.<init>(r4)
            r4 = 0
            r6 = 0
        L_0x051f:
            int r9 = r11.size()
            if (r4 >= r9) goto L_0x057a
            int r9 = r11.keyAt(r4)
            java.lang.CharSequence r6 = r1.subSequence(r6, r9)
            java.lang.String r6 = i3.k0.a(r6)
            r0.append(r6)
            java.lang.Object r6 = r11.get(r9)
            i3.j0 r6 = (i3.j0) r6
            java.util.ArrayList r10 = r6.f8113b
            j0.a r12 = i3.i0.f8105f
            java.util.Collections.sort(r10, r12)
            java.util.ArrayList r10 = r6.f8113b
            java.util.Iterator r10 = r10.iterator()
        L_0x0547:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x0559
            java.lang.Object r12 = r10.next()
            i3.i0 r12 = (i3.i0) r12
            java.lang.String r12 = r12.f8109d
            r0.append(r12)
            goto L_0x0547
        L_0x0559:
            java.util.ArrayList r6 = r6.f8112a
            j0.a r10 = i3.i0.f8104e
            java.util.Collections.sort(r6, r10)
            java.util.Iterator r6 = r6.iterator()
        L_0x0564:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0576
            java.lang.Object r10 = r6.next()
            i3.i0 r10 = (i3.i0) r10
            java.lang.String r10 = r10.f8108c
            r0.append(r10)
            goto L_0x0564
        L_0x0576:
            int r4 = r4 + 1
            r6 = r9
            goto L_0x051f
        L_0x057a:
            int r4 = r1.length()
            java.lang.CharSequence r1 = r1.subSequence(r6, r4)
            java.lang.String r1 = i3.k0.a(r1)
            r0.append(r1)
            android.support.v4.media.n r1 = new android.support.v4.media.n
            java.lang.String r0 = r0.toString()
            r1.<init>((java.lang.String) r0, (java.util.Map) r7)
        L_0x0592:
            java.util.Set r0 = r2.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x059a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x05c6
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.get(r4)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r2.put(r4, r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x05c1
            java.lang.Object r4 = r2.get(r4)
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x05bf
            goto L_0x05c1
        L_0x05bf:
            r4 = 0
            goto L_0x05c2
        L_0x05c1:
            r4 = 1
        L_0x05c2:
            j1.a.e(r4)
            goto L_0x059a
        L_0x05c6:
            r0 = 14
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r6 = 0
            r0[r6] = r4
            r4 = 1
            r0[r4] = r21
            java.lang.Float r4 = java.lang.Float.valueOf(r8)
            r6 = 2
            r0[r6] = r4
            r4 = 3
            r0[r4] = r22
            r4 = 4
            r0[r4] = r5
            r4 = 5
            r0[r4] = r13
            r4 = 6
            r0[r4] = r38
            r4 = 7
            r0[r4] = r37
            r4 = 8
            r0[r4] = r35
            r4 = 9
            r0[r4] = r31
            r4 = 10
            r0[r4] = r29
            r4 = 11
            java.lang.Integer r5 = java.lang.Integer.valueOf(r18)
            r0[r4] = r5
            r4 = 12
            java.lang.Integer r5 = java.lang.Integer.valueOf(r20)
            r0[r4] = r5
            r7 = r28
            float r4 = r7.f7988x
            r5 = 0
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x062f
            r5 = 2
            r6 = 1
            r8 = r27
            if (r8 == r5) goto L_0x061b
            if (r8 != r6) goto L_0x0618
            goto L_0x061b
        L_0x0618:
            java.lang.String r8 = "skewX"
            goto L_0x061d
        L_0x061b:
            java.lang.String r8 = "skewY"
        L_0x061d:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r9 = 0
            r5[r9] = r8
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r5[r6] = r4
            java.lang.String r4 = "%s(%.2fdeg)"
            java.lang.String r4 = j1.l0.l(r4, r5)
            goto L_0x0632
        L_0x062f:
            r6 = 1
            r4 = r26
        L_0x0632:
            r5 = 13
            r0[r5] = r4
            java.lang.String r4 = "<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>"
            java.lang.String r0 = j1.l0.l(r4, r0)
            r4 = r25
            r4.append(r0)
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r5 = "default_bg"
            r8 = 0
            r0[r8] = r5
            java.lang.String r5 = "<span class='%s'>"
            java.lang.String r0 = j1.l0.l(r5, r0)
            r4.append(r0)
            android.text.Layout$Alignment r0 = r7.f7974j
            if (r0 == 0) goto L_0x0680
            java.lang.Object[] r5 = new java.lang.Object[r6]
            int[] r7 = i3.s0.f8164a
            int r0 = r0.ordinal()
            r0 = r7[r0]
            r7 = 2
            if (r0 == r6) goto L_0x066a
            if (r0 == r7) goto L_0x0667
            r9 = r23
            goto L_0x066c
        L_0x0667:
            r9 = r17
            goto L_0x066c
        L_0x066a:
            r9 = r19
        L_0x066c:
            r0 = 0
            r5[r0] = r9
            java.lang.String r0 = "<span style='display:inline-block; text-align:%s;'>"
            java.lang.String r0 = j1.l0.l(r0, r5)
            r4.append(r0)
            java.lang.Object r0 = r1.f337i
            java.lang.String r0 = (java.lang.String) r0
            r4.append(r0)
            goto L_0x0686
        L_0x0680:
            java.lang.Object r0 = r1.f337i
            r24 = r0
            java.lang.String r24 = (java.lang.String) r24
        L_0x0686:
            r0 = r24
            r4.append(r0)
            java.lang.String r0 = "</span></div>"
            r4.append(r0)
            int r3 = r3 + 1
            r5 = 0
            r6 = 1
            r0 = r40
            r1 = r4
            r9 = r16
            r4 = r30
            goto L_0x00a0
        L_0x069d:
            r4 = r1
            java.lang.String r0 = "</div></body></html>"
            r4.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "<html><head><style>"
            r0.<init>(r1)
            java.util.Set r1 = r2.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x06b2:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x06d5
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            java.lang.String r5 = "{"
            r0.append(r5)
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            java.lang.String r3 = "}"
            r0.append(r3)
            goto L_0x06b2
        L_0x06d5:
            java.lang.String r1 = "</style></head>"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            r4.insert(r1, r0)
            java.lang.String r0 = r4.toString()
            java.nio.charset.Charset r1 = c9.h.f3035c
            byte[] r0 = r0.getBytes(r1)
            r1 = 1
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)
            java.lang.String r1 = "text/html"
            java.lang.String r2 = "base64"
            r3 = r40
            i3.r0 r4 = r3.f8171i
            r4.loadData(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.t0.d():void");
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10 && !this.f8172j.isEmpty()) {
            d();
        }
    }
}

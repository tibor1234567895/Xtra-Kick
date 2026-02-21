package v;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import s.e;
import u.f;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public int f15527a;

    /* renamed from: b  reason: collision with root package name */
    public int f15528b;

    /* renamed from: c  reason: collision with root package name */
    public int f15529c;

    /* renamed from: d  reason: collision with root package name */
    public int f15530d;

    /* renamed from: e  reason: collision with root package name */
    public int f15531e;

    /* renamed from: f  reason: collision with root package name */
    public int f15532f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f15533g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f15534h;

    public o(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f15534h = constraintLayout;
        this.f15533g = constraintLayout2;
    }

    public static boolean a(int i10, int i11, int i12) {
        if (i10 == i11) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i10);
        View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(u.f r19, v.b r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            int r3 = r1.f15095h0
            r4 = 8
            r5 = 0
            if (r3 != r4) goto L_0x0017
            r2.f15491e = r5
            r2.f15492f = r5
            r2.f15493g = r5
            return
        L_0x0017:
            u.f r3 = r1.U
            if (r3 != 0) goto L_0x001c
            return
        L_0x001c:
            int r3 = r2.f15487a
            int r4 = r2.f15488b
            int r6 = r2.f15489c
            int r7 = r2.f15490d
            int r8 = r0.f15527a
            int r9 = r0.f15528b
            int r8 = r8 + r9
            int r9 = r0.f15529c
            java.lang.Object r10 = r1.f15093g0
            android.view.View r10 = (android.view.View) r10
            int r11 = s.i.a(r3)
            r12 = 3
            r15 = 1
            r14 = 2
            u.e r13 = r1.L
            u.e r5 = r1.J
            if (r11 == 0) goto L_0x00a7
            if (r11 == r15) goto L_0x009d
            if (r11 == r14) goto L_0x005d
            if (r11 == r12) goto L_0x0045
            r6 = 0
            goto L_0x00ad
        L_0x0045:
            int r6 = r0.f15531e
            if (r5 == 0) goto L_0x0050
            int r11 = r5.f15077g
            r16 = 0
            int r11 = r11 + 0
            goto L_0x0051
        L_0x0050:
            r11 = 0
        L_0x0051:
            if (r13 == 0) goto L_0x0056
            int r12 = r13.f15077g
            int r11 = r11 + r12
        L_0x0056:
            int r9 = r9 + r11
            r11 = -1
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r11)
            goto L_0x00ad
        L_0x005d:
            int r6 = r0.f15531e
            r11 = -2
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r11)
            int r9 = r1.f15115s
            if (r9 != r15) goto L_0x006a
            r9 = 1
            goto L_0x006b
        L_0x006a:
            r9 = 0
        L_0x006b:
            int r11 = r2.f15496j
            if (r11 == r15) goto L_0x0075
            if (r11 != r14) goto L_0x0072
            goto L_0x0075
        L_0x0072:
            r11 = 1073741824(0x40000000, float:2.0)
            goto L_0x00ad
        L_0x0075:
            int r11 = r10.getMeasuredHeight()
            int r12 = r19.l()
            if (r11 != r12) goto L_0x0081
            r11 = 1
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            int r12 = r2.f15496j
            if (r12 == r14) goto L_0x0095
            if (r9 == 0) goto L_0x0095
            if (r9 == 0) goto L_0x008c
            if (r11 != 0) goto L_0x0095
        L_0x008c:
            boolean r9 = r19.A()
            if (r9 == 0) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r9 = 0
            goto L_0x0096
        L_0x0095:
            r9 = 1
        L_0x0096:
            if (r9 == 0) goto L_0x0072
            int r6 = r19.q()
            goto L_0x00a7
        L_0x009d:
            r11 = 1073741824(0x40000000, float:2.0)
            int r6 = r0.f15531e
            r12 = -2
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r12)
            goto L_0x00ad
        L_0x00a7:
            r11 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r11)
        L_0x00ad:
            int r9 = s.i.a(r4)
            if (r9 == 0) goto L_0x0128
            if (r9 == r15) goto L_0x011e
            if (r9 == r14) goto L_0x00d8
            r7 = 3
            if (r9 == r7) goto L_0x00bd
            r5 = 0
            goto L_0x012e
        L_0x00bd:
            int r7 = r0.f15532f
            if (r5 == 0) goto L_0x00c8
            u.e r5 = r1.K
            int r5 = r5.f15077g
            r9 = 0
            int r5 = r5 + r9
            goto L_0x00c9
        L_0x00c8:
            r5 = 0
        L_0x00c9:
            if (r13 == 0) goto L_0x00d0
            u.e r9 = r1.M
            int r9 = r9.f15077g
            int r5 = r5 + r9
        L_0x00d0:
            int r8 = r8 + r5
            r5 = -1
            int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r5)
            r5 = r7
            goto L_0x012e
        L_0x00d8:
            int r5 = r0.f15532f
            r7 = -2
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r5, r8, r7)
            int r7 = r1.f15116t
            if (r7 != r15) goto L_0x00e5
            r7 = 1
            goto L_0x00e6
        L_0x00e5:
            r7 = 0
        L_0x00e6:
            int r8 = r2.f15496j
            if (r8 == r15) goto L_0x00f0
            if (r8 != r14) goto L_0x00ed
            goto L_0x00f0
        L_0x00ed:
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x012e
        L_0x00f0:
            int r8 = r10.getMeasuredWidth()
            int r9 = r19.q()
            if (r8 != r9) goto L_0x00fc
            r8 = 1
            goto L_0x00fd
        L_0x00fc:
            r8 = 0
        L_0x00fd:
            int r9 = r2.f15496j
            if (r9 == r14) goto L_0x0110
            if (r7 == 0) goto L_0x0110
            if (r7 == 0) goto L_0x0107
            if (r8 != 0) goto L_0x0110
        L_0x0107:
            boolean r7 = r19.B()
            if (r7 == 0) goto L_0x010e
            goto L_0x0110
        L_0x010e:
            r7 = 0
            goto L_0x0111
        L_0x0110:
            r7 = 1
        L_0x0111:
            if (r7 == 0) goto L_0x00ed
            int r5 = r19.l()
            r9 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9)
            goto L_0x012e
        L_0x011e:
            r9 = 1073741824(0x40000000, float:2.0)
            int r5 = r0.f15532f
            r7 = -2
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r5, r8, r7)
            goto L_0x012e
        L_0x0128:
            r9 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
        L_0x012e:
            u.f r7 = r1.U
            u.g r7 = (u.g) r7
            java.lang.Object r8 = r0.f15534h
            if (r7 == 0) goto L_0x01a7
            r9 = r8
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            int r9 = r9.f1177p
            r11 = 256(0x100, float:3.59E-43)
            boolean r9 = u.m.b(r9, r11)
            if (r9 == 0) goto L_0x01a7
            int r9 = r10.getMeasuredWidth()
            int r11 = r19.q()
            if (r9 != r11) goto L_0x01a7
            int r9 = r10.getMeasuredWidth()
            int r11 = r7.q()
            if (r9 >= r11) goto L_0x01a7
            int r9 = r10.getMeasuredHeight()
            int r11 = r19.l()
            if (r9 != r11) goto L_0x01a7
            int r9 = r10.getMeasuredHeight()
            int r7 = r7.l()
            if (r9 >= r7) goto L_0x01a7
            int r7 = r10.getBaseline()
            int r9 = r1.f15083b0
            if (r7 != r9) goto L_0x01a7
            boolean r7 = r19.z()
            if (r7 != 0) goto L_0x01a7
            int r7 = r1.H
            int r9 = r19.q()
            boolean r7 = a(r7, r6, r9)
            if (r7 == 0) goto L_0x0193
            int r7 = r1.I
            int r9 = r19.l()
            boolean r7 = a(r7, r5, r9)
            if (r7 == 0) goto L_0x0193
            r7 = 1
            goto L_0x0194
        L_0x0193:
            r7 = 0
        L_0x0194:
            if (r7 == 0) goto L_0x01a7
            int r3 = r19.q()
            r2.f15491e = r3
            int r3 = r19.l()
            r2.f15492f = r3
            int r1 = r1.f15083b0
            r2.f15493g = r1
            return
        L_0x01a7:
            r7 = 3
            if (r3 != r7) goto L_0x01ac
            r9 = 1
            goto L_0x01ad
        L_0x01ac:
            r9 = 0
        L_0x01ad:
            if (r4 != r7) goto L_0x01b1
            r7 = 1
            goto L_0x01b2
        L_0x01b1:
            r7 = 0
        L_0x01b2:
            r11 = 4
            if (r4 == r11) goto L_0x01ba
            if (r4 != r15) goto L_0x01b8
            goto L_0x01ba
        L_0x01b8:
            r4 = 0
            goto L_0x01bb
        L_0x01ba:
            r4 = 1
        L_0x01bb:
            if (r3 == r11) goto L_0x01c2
            if (r3 != r15) goto L_0x01c0
            goto L_0x01c2
        L_0x01c0:
            r3 = 0
            goto L_0x01c3
        L_0x01c2:
            r3 = 1
        L_0x01c3:
            r11 = 0
            if (r9 == 0) goto L_0x01ce
            float r12 = r1.X
            int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x01ce
            r12 = 1
            goto L_0x01cf
        L_0x01ce:
            r12 = 0
        L_0x01cf:
            if (r7 == 0) goto L_0x01d9
            float r13 = r1.X
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x01d9
            r11 = 1
            goto L_0x01da
        L_0x01d9:
            r11 = 0
        L_0x01da:
            if (r10 != 0) goto L_0x01dd
            return
        L_0x01dd:
            android.view.ViewGroup$LayoutParams r13 = r10.getLayoutParams()
            x.d r13 = (x.d) r13
            int r0 = r2.f15496j
            if (r0 == r15) goto L_0x01fd
            if (r0 == r14) goto L_0x01fd
            if (r9 == 0) goto L_0x01fd
            int r0 = r1.f15115s
            if (r0 != 0) goto L_0x01fd
            if (r7 == 0) goto L_0x01fd
            int r0 = r1.f15116t
            if (r0 == 0) goto L_0x01f6
            goto L_0x01fd
        L_0x01f6:
            r0 = 0
            r3 = -1
            r4 = 0
            r14 = 0
            r15 = 0
            goto L_0x02a9
        L_0x01fd:
            boolean r0 = r10 instanceof x.r
            if (r0 == 0) goto L_0x020f
            boolean r0 = r1 instanceof u.n
            if (r0 == 0) goto L_0x020f
            r0 = r1
            u.n r0 = (u.n) r0
            r7 = r10
            x.r r7 = (x.r) r7
            r7.j(r0, r6, r5)
            goto L_0x0212
        L_0x020f:
            r10.measure(r6, r5)
        L_0x0212:
            r1.H = r6
            r1.I = r5
            r0 = 0
            r1.f15092g = r0
            int r0 = r10.getMeasuredWidth()
            int r7 = r10.getMeasuredHeight()
            int r9 = r10.getBaseline()
            int r14 = r1.f15118v
            if (r14 <= 0) goto L_0x022e
            int r14 = java.lang.Math.max(r14, r0)
            goto L_0x022f
        L_0x022e:
            r14 = r0
        L_0x022f:
            int r15 = r1.f15119w
            if (r15 <= 0) goto L_0x0237
            int r14 = java.lang.Math.min(r15, r14)
        L_0x0237:
            int r15 = r1.f15121y
            if (r15 <= 0) goto L_0x0242
            int r15 = java.lang.Math.max(r15, r7)
            r17 = r5
            goto L_0x0245
        L_0x0242:
            r17 = r5
            r15 = r7
        L_0x0245:
            int r5 = r1.f15122z
            if (r5 <= 0) goto L_0x024d
            int r15 = java.lang.Math.min(r5, r15)
        L_0x024d:
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            int r5 = r8.f1177p
            r8 = 1
            boolean r5 = u.m.b(r5, r8)
            if (r5 != 0) goto L_0x0272
            r5 = 1056964608(0x3f000000, float:0.5)
            if (r12 == 0) goto L_0x0267
            if (r4 == 0) goto L_0x0267
            float r3 = r1.X
            float r4 = (float) r15
            float r4 = r4 * r3
            float r4 = r4 + r5
            int r3 = (int) r4
            r14 = r3
            goto L_0x0272
        L_0x0267:
            if (r11 == 0) goto L_0x0272
            if (r3 == 0) goto L_0x0272
            float r3 = r1.X
            float r4 = (float) r14
            float r4 = r4 / r3
            float r4 = r4 + r5
            int r3 = (int) r4
            r15 = r3
        L_0x0272:
            if (r0 != r14) goto L_0x027b
            if (r7 == r15) goto L_0x0277
            goto L_0x027b
        L_0x0277:
            r4 = r9
            r0 = 0
        L_0x0279:
            r3 = -1
            goto L_0x02a9
        L_0x027b:
            if (r0 == r14) goto L_0x0284
            r0 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r0)
            goto L_0x0286
        L_0x0284:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x0286:
            if (r7 == r15) goto L_0x028d
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r0)
            goto L_0x028f
        L_0x028d:
            r5 = r17
        L_0x028f:
            r10.measure(r6, r5)
            r1.H = r6
            r1.I = r5
            r0 = 0
            r1.f15092g = r0
            int r16 = r10.getMeasuredWidth()
            int r3 = r10.getMeasuredHeight()
            int r4 = r10.getBaseline()
            r15 = r3
            r14 = r16
            goto L_0x0279
        L_0x02a9:
            if (r4 == r3) goto L_0x02ae
            r16 = 1
            goto L_0x02b0
        L_0x02ae:
            r16 = 0
        L_0x02b0:
            int r3 = r2.f15489c
            if (r14 != r3) goto L_0x02bb
            int r3 = r2.f15490d
            if (r15 == r3) goto L_0x02b9
            goto L_0x02bb
        L_0x02b9:
            r5 = 0
            goto L_0x02bc
        L_0x02bb:
            r5 = 1
        L_0x02bc:
            r2.f15495i = r5
            boolean r0 = r13.f16360c0
            if (r0 == 0) goto L_0x02c4
            r8 = 1
            goto L_0x02c6
        L_0x02c4:
            r8 = r16
        L_0x02c6:
            if (r8 == 0) goto L_0x02d2
            r0 = -1
            if (r4 == r0) goto L_0x02d2
            int r0 = r1.f15083b0
            if (r0 == r4) goto L_0x02d2
            r0 = 1
            r2.f15495i = r0
        L_0x02d2:
            r2.f15491e = r14
            r2.f15492f = r15
            r2.f15494h = r8
            r2.f15493g = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.o.b(u.f, v.b):void");
    }

    public o(p pVar, f fVar, e eVar, int i10) {
        this.f15534h = pVar;
        this.f15533g = new WeakReference(fVar);
        u.e eVar2 = fVar.J;
        eVar.getClass();
        this.f15527a = e.o(eVar2);
        this.f15528b = e.o(fVar.K);
        this.f15529c = e.o(fVar.L);
        this.f15530d = e.o(fVar.M);
        this.f15531e = e.o(fVar.N);
        this.f15532f = i10;
    }
}

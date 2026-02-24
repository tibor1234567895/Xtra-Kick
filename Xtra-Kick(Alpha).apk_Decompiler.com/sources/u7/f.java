package u7;

import android.support.v4.media.h;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m0.p;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final a f15392a;

    /* renamed from: b  reason: collision with root package name */
    public boolean[] f15393b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f15394c;

    /* renamed from: d  reason: collision with root package name */
    public long[] f15395d;

    /* renamed from: e  reason: collision with root package name */
    public long[] f15396e;

    public f(a aVar) {
        this.f15392a = aVar;
    }

    public static ArrayList e(int i10, int i11, List list) {
        ArrayList arrayList = new ArrayList();
        c cVar = new c();
        cVar.f15376g = (i10 - i11) / 2;
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (i12 == 0) {
                arrayList.add(cVar);
            }
            arrayList.add((c) list.get(i12));
            if (i12 == list.size() - 1) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static int[] r(int i10, ArrayList arrayList, SparseIntArray sparseIntArray) {
        Collections.sort(arrayList);
        sparseIntArray.clear();
        int[] iArr = new int[i10];
        Iterator it = arrayList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            e eVar = (e) it.next();
            int i12 = eVar.f15390h;
            iArr[i11] = i12;
            sparseIntArray.append(i12, eVar.f15391i);
            i11++;
        }
        return iArr;
    }

    public final void a(List list, c cVar, int i10, int i11) {
        cVar.f15382m = i11;
        this.f15392a.f(cVar);
        cVar.f15385p = i10;
        list.add(cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0208, code lost:
        if (r8 < (r13 + r15)) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        if (r1 == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ab, code lost:
        if ((r10 == r15 + -1 && r13 - r1 != 0) != false) goto L_0x00ad;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03b4 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(u7.d r29, int r30, int r31, int r32, int r33, int r34, java.util.List r35) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r34
            u7.a r5 = r0.f15392a
            boolean r6 = r5.j()
            int r7 = android.view.View.MeasureSpec.getMode(r30)
            int r8 = android.view.View.MeasureSpec.getSize(r30)
            if (r35 != 0) goto L_0x0020
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            goto L_0x0022
        L_0x0020:
            r9 = r35
        L_0x0022:
            r1.f15388a = r9
            r10 = -1
            if (r4 != r10) goto L_0x0029
            r13 = 1
            goto L_0x002a
        L_0x0029:
            r13 = 0
        L_0x002a:
            if (r6 == 0) goto L_0x0031
            int r14 = r5.getPaddingStart()
            goto L_0x0035
        L_0x0031:
            int r14 = r5.getPaddingTop()
        L_0x0035:
            if (r6 == 0) goto L_0x003c
            int r15 = r5.getPaddingEnd()
            goto L_0x0040
        L_0x003c:
            int r15 = r5.getPaddingBottom()
        L_0x0040:
            if (r6 == 0) goto L_0x0047
            int r16 = r5.getPaddingTop()
            goto L_0x004b
        L_0x0047:
            int r16 = r5.getPaddingStart()
        L_0x004b:
            if (r6 == 0) goto L_0x0052
            int r17 = r5.getPaddingBottom()
            goto L_0x0056
        L_0x0052:
            int r17 = r5.getPaddingEnd()
        L_0x0056:
            u7.c r12 = new u7.c
            r12.<init>()
            r10 = r33
            r12.f15384o = r10
            int r14 = r14 + r15
            r12.f15374e = r14
            int r15 = r5.getFlexItemCount()
            r18 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = 0
            r19 = 0
            r20 = 0
            r22 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x006f:
            if (r10 >= r15) goto L_0x03ce
            android.view.View r1 = r5.g(r10)
            if (r1 != 0) goto L_0x008c
            int r1 = r15 + -1
            if (r10 != r1) goto L_0x0086
            int r1 = r12.f15377h
            r33 = r13
            int r13 = r12.f15378i
            int r1 = r1 - r13
            if (r1 == 0) goto L_0x0088
            r1 = 1
            goto L_0x0089
        L_0x0086:
            r33 = r13
        L_0x0088:
            r1 = 0
        L_0x0089:
            if (r1 == 0) goto L_0x00b0
            goto L_0x00ad
        L_0x008c:
            r33 = r13
            int r13 = r1.getVisibility()
            r4 = 8
            if (r13 != r4) goto L_0x00be
            int r1 = r12.f15378i
            r4 = 1
            int r1 = r1 + r4
            r12.f15378i = r1
            int r13 = r12.f15377h
            int r13 = r13 + r4
            r12.f15377h = r13
            int r4 = r15 + -1
            if (r10 != r4) goto L_0x00aa
            int r13 = r13 - r1
            if (r13 == 0) goto L_0x00aa
            r1 = 1
            goto L_0x00ab
        L_0x00aa:
            r1 = 0
        L_0x00ab:
            if (r1 == 0) goto L_0x00b0
        L_0x00ad:
            r0.a(r9, r12, r10, r11)
        L_0x00b0:
            r13 = r33
            r1 = r34
            r26 = r7
            r7 = r9
            r23 = r15
            r4 = -1
            r15 = r32
            goto L_0x03c0
        L_0x00be:
            boolean r4 = r1 instanceof android.widget.CompoundButton
            if (r4 == 0) goto L_0x0100
            r4 = r1
            android.widget.CompoundButton r4 = (android.widget.CompoundButton) r4
            android.view.ViewGroup$LayoutParams r13 = r4.getLayoutParams()
            u7.b r13 = (u7.b) r13
            r23 = r15
            int r15 = r13.k()
            r24 = r9
            int r9 = r13.j()
            android.graphics.drawable.Drawable r4 = q0.d.a(r4)
            if (r4 != 0) goto L_0x00e0
            r25 = 0
            goto L_0x00e4
        L_0x00e0:
            int r25 = r4.getMinimumWidth()
        L_0x00e4:
            if (r4 != 0) goto L_0x00ea
            r4 = -1
            r26 = 0
            goto L_0x00f1
        L_0x00ea:
            int r4 = r4.getMinimumHeight()
            r26 = r4
            r4 = -1
        L_0x00f1:
            if (r15 != r4) goto L_0x00f5
            r15 = r25
        L_0x00f5:
            r13.o(r15)
            if (r9 != r4) goto L_0x00fc
            r9 = r26
        L_0x00fc:
            r13.a(r9)
            goto L_0x0104
        L_0x0100:
            r24 = r9
            r23 = r15
        L_0x0104:
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            u7.b r4 = (u7.b) r4
            int r9 = r4.e()
            r13 = 4
            if (r9 != r13) goto L_0x011a
            java.util.ArrayList r9 = r12.f15383n
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r9.add(r13)
        L_0x011a:
            if (r6 == 0) goto L_0x0121
            int r9 = r4.m()
            goto L_0x0125
        L_0x0121:
            int r9 = r4.c()
        L_0x0125:
            float r13 = r4.d()
            r15 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L_0x013e
            r13 = 1073741824(0x40000000, float:2.0)
            if (r7 != r13) goto L_0x013e
            float r9 = (float) r8
            float r13 = r4.d()
            float r13 = r13 * r9
            int r9 = java.lang.Math.round(r13)
        L_0x013e:
            if (r6 == 0) goto L_0x016a
            int r13 = r4.q()
            int r13 = r13 + r14
            int r15 = r4.i()
            int r15 = r15 + r13
            int r9 = r5.i(r2, r15, r9)
            int r13 = r16 + r17
            int r15 = r4.t()
            int r15 = r15 + r13
            int r13 = r4.p()
            int r13 = r13 + r15
            int r13 = r13 + r11
            int r15 = r4.c()
            int r13 = r5.c(r3, r13, r15)
            r1.measure(r9, r13)
            r0.v(r1, r10, r9, r13)
            goto L_0x0194
        L_0x016a:
            int r13 = r16 + r17
            int r15 = r4.q()
            int r15 = r15 + r13
            int r13 = r4.i()
            int r13 = r13 + r15
            int r13 = r13 + r11
            int r15 = r4.m()
            int r13 = r5.i(r3, r13, r15)
            int r15 = r4.t()
            int r15 = r15 + r14
            int r25 = r4.p()
            int r15 = r25 + r15
            int r9 = r5.c(r2, r15, r9)
            r1.measure(r13, r9)
            r0.v(r1, r10, r13, r9)
        L_0x0194:
            r5.h(r1, r10)
            r0.c(r1, r10)
            int r13 = r1.getMeasuredState()
            r15 = r19
            int r19 = android.view.View.combineMeasuredStates(r15, r13)
            int r13 = r12.f15374e
            if (r6 == 0) goto L_0x01ad
            int r15 = r1.getMeasuredWidth()
            goto L_0x01b1
        L_0x01ad:
            int r15 = r1.getMeasuredHeight()
        L_0x01b1:
            if (r6 == 0) goto L_0x01b8
            int r25 = r4.q()
            goto L_0x01bc
        L_0x01b8:
            int r25 = r4.t()
        L_0x01bc:
            int r25 = r25 + r15
            if (r6 == 0) goto L_0x01c5
            int r15 = r4.i()
            goto L_0x01c9
        L_0x01c5:
            int r15 = r4.p()
        L_0x01c9:
            int r15 = r15 + r25
            int r25 = r24.size()
            int r26 = r5.getFlexWrap()
            if (r26 != 0) goto L_0x01d6
            goto L_0x01e5
        L_0x01d6:
            boolean r26 = r4.l()
            if (r26 == 0) goto L_0x01e3
            r26 = r7
            r27 = r14
            r2 = r20
            goto L_0x020a
        L_0x01e3:
            if (r7 != 0) goto L_0x01ed
        L_0x01e5:
            r26 = r7
            r27 = r14
        L_0x01e9:
            r2 = r20
        L_0x01eb:
            r7 = 0
            goto L_0x020b
        L_0x01ed:
            int r2 = r5.getMaxLine()
            r26 = r7
            r7 = -1
            r27 = r14
            if (r2 == r7) goto L_0x01fe
            r7 = 1
            int r14 = r25 + 1
            if (r2 > r14) goto L_0x01fe
            goto L_0x01e9
        L_0x01fe:
            r2 = r20
            int r7 = r5.b(r1, r10, r2)
            if (r7 <= 0) goto L_0x0207
            int r15 = r15 + r7
        L_0x0207:
            int r13 = r13 + r15
            if (r8 >= r13) goto L_0x01eb
        L_0x020a:
            r7 = 1
        L_0x020b:
            if (r7 == 0) goto L_0x028b
            int r2 = r12.f15377h
            int r7 = r12.f15378i
            int r2 = r2 - r7
            if (r2 <= 0) goto L_0x0225
            if (r10 <= 0) goto L_0x021b
            int r2 = r10 + -1
            r7 = r24
            goto L_0x021e
        L_0x021b:
            r7 = r24
            r2 = 0
        L_0x021e:
            r0.a(r7, r12, r2, r11)
            int r2 = r12.f15376g
            int r11 = r11 + r2
            goto L_0x0227
        L_0x0225:
            r7 = r24
        L_0x0227:
            if (r6 == 0) goto L_0x0250
            int r2 = r4.c()
            r12 = -1
            if (r2 != r12) goto L_0x0279
            int r2 = r5.getPaddingTop()
            int r12 = r5.getPaddingBottom()
            int r12 = r12 + r2
            int r2 = r4.t()
            int r2 = r2 + r12
            int r12 = r4.p()
            int r12 = r12 + r2
            int r12 = r12 + r11
            int r2 = r4.c()
            int r2 = r5.c(r3, r12, r2)
            r1.measure(r9, r2)
            goto L_0x0276
        L_0x0250:
            int r2 = r4.m()
            r12 = -1
            if (r2 != r12) goto L_0x0279
            int r2 = r5.getPaddingLeft()
            int r12 = r5.getPaddingRight()
            int r12 = r12 + r2
            int r2 = r4.q()
            int r2 = r2 + r12
            int r12 = r4.i()
            int r12 = r12 + r2
            int r12 = r12 + r11
            int r2 = r4.m()
            int r2 = r5.i(r3, r12, r2)
            r1.measure(r2, r9)
        L_0x0276:
            r0.c(r1, r10)
        L_0x0279:
            u7.c r12 = new u7.c
            r12.<init>()
            r9 = 1
            r12.f15377h = r9
            r14 = r27
            r12.f15374e = r14
            r12.f15384o = r10
            r2 = 0
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x029b
        L_0x028b:
            r7 = r24
            r14 = r27
            r9 = 1
            int r13 = r12.f15377h
            int r13 = r13 + r9
            r12.f15377h = r13
            int r20 = r2 + 1
            r2 = r20
            r13 = r22
        L_0x029b:
            boolean r15 = r12.f15386q
            float r20 = r4.b()
            r21 = 0
            int r20 = (r20 > r21 ? 1 : (r20 == r21 ? 0 : -1))
            if (r20 == 0) goto L_0x02aa
            r20 = 1
            goto L_0x02ac
        L_0x02aa:
            r20 = 0
        L_0x02ac:
            r15 = r15 | r20
            r12.f15386q = r15
            boolean r15 = r12.f15387r
            float r20 = r4.f()
            int r20 = (r20 > r21 ? 1 : (r20 == r21 ? 0 : -1))
            if (r20 == 0) goto L_0x02bd
            r20 = 1
            goto L_0x02bf
        L_0x02bd:
            r20 = 0
        L_0x02bf:
            r15 = r15 | r20
            r12.f15387r = r15
            int[] r15 = r0.f15394c
            if (r15 == 0) goto L_0x02cd
            int r20 = r7.size()
            r15[r10] = r20
        L_0x02cd:
            int r15 = r12.f15374e
            if (r6 == 0) goto L_0x02d6
            int r20 = r1.getMeasuredWidth()
            goto L_0x02da
        L_0x02d6:
            int r20 = r1.getMeasuredHeight()
        L_0x02da:
            if (r6 == 0) goto L_0x02e1
            int r21 = r4.q()
            goto L_0x02e5
        L_0x02e1:
            int r21 = r4.t()
        L_0x02e5:
            int r21 = r21 + r20
            if (r6 == 0) goto L_0x02ee
            int r20 = r4.i()
            goto L_0x02f2
        L_0x02ee:
            int r20 = r4.p()
        L_0x02f2:
            int r20 = r20 + r21
            int r15 = r20 + r15
            r12.f15374e = r15
            float r15 = r12.f15379j
            float r20 = r4.b()
            float r15 = r20 + r15
            r12.f15379j = r15
            float r15 = r12.f15380k
            float r20 = r4.f()
            float r15 = r20 + r15
            r12.f15380k = r15
            r5.e(r1, r10, r2, r12)
            if (r6 == 0) goto L_0x0316
            int r15 = r1.getMeasuredHeight()
            goto L_0x031a
        L_0x0316:
            int r15 = r1.getMeasuredWidth()
        L_0x031a:
            if (r6 == 0) goto L_0x0321
            int r20 = r4.t()
            goto L_0x0325
        L_0x0321:
            int r20 = r4.q()
        L_0x0325:
            int r20 = r20 + r15
            if (r6 == 0) goto L_0x032e
            int r15 = r4.p()
            goto L_0x0332
        L_0x032e:
            int r15 = r4.i()
        L_0x0332:
            int r15 = r15 + r20
            int r20 = r5.k(r1)
            int r15 = r20 + r15
            int r13 = java.lang.Math.max(r13, r15)
            int r15 = r12.f15376g
            int r15 = java.lang.Math.max(r15, r13)
            r12.f15376g = r15
            if (r6 == 0) goto L_0x0372
            int r15 = r5.getFlexWrap()
            r9 = 2
            if (r15 == r9) goto L_0x035b
            int r9 = r12.f15381l
            int r1 = r1.getBaseline()
            int r4 = r4.t()
            int r4 = r4 + r1
            goto L_0x036c
        L_0x035b:
            int r9 = r12.f15381l
            int r15 = r1.getMeasuredHeight()
            int r1 = r1.getBaseline()
            int r15 = r15 - r1
            int r1 = r4.p()
            int r4 = r1 + r15
        L_0x036c:
            int r1 = java.lang.Math.max(r9, r4)
            r12.f15381l = r1
        L_0x0372:
            int r15 = r23 + -1
            if (r10 != r15) goto L_0x037f
            int r1 = r12.f15377h
            int r4 = r12.f15378i
            int r1 = r1 - r4
            if (r1 == 0) goto L_0x037f
            r4 = 1
            goto L_0x0380
        L_0x037f:
            r4 = 0
        L_0x0380:
            if (r4 == 0) goto L_0x0388
            r0.a(r7, r12, r10, r11)
            int r1 = r12.f15376g
            int r11 = r11 + r1
        L_0x0388:
            r1 = r34
            r4 = -1
            if (r1 == r4) goto L_0x03ae
            int r9 = r7.size()
            if (r9 <= 0) goto L_0x03ae
            int r9 = r7.size()
            int r9 = r9 + r4
            java.lang.Object r9 = r7.get(r9)
            u7.c r9 = (u7.c) r9
            int r9 = r9.f15385p
            if (r9 < r1) goto L_0x03ae
            if (r10 < r1) goto L_0x03ae
            if (r33 != 0) goto L_0x03ae
            int r9 = r12.f15376g
            int r9 = -r9
            r15 = r32
            r11 = r9
            r9 = 1
            goto L_0x03b2
        L_0x03ae:
            r15 = r32
            r9 = r33
        L_0x03b2:
            if (r11 <= r15) goto L_0x03bb
            if (r9 == 0) goto L_0x03bb
            r1 = r29
            r15 = r19
            goto L_0x03d2
        L_0x03bb:
            r20 = r2
            r22 = r13
            r13 = r9
        L_0x03c0:
            int r10 = r10 + 1
            r2 = r30
            r4 = r1
            r9 = r7
            r15 = r23
            r7 = r26
            r1 = r29
            goto L_0x006f
        L_0x03ce:
            r15 = r19
            r1 = r29
        L_0x03d2:
            r1.f15389b = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.f.b(u7.d, int, int, int, int, int, java.util.List):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            u7.b r0 = (u7.b) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.k()
            r4 = 1
            if (r1 >= r3) goto L_0x001a
            int r1 = r0.k()
            goto L_0x0024
        L_0x001a:
            int r3 = r0.s()
            if (r1 <= r3) goto L_0x0026
            int r1 = r0.s()
        L_0x0024:
            r3 = 1
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            int r5 = r0.j()
            if (r2 >= r5) goto L_0x0032
            int r2 = r0.j()
            goto L_0x003e
        L_0x0032:
            int r5 = r0.n()
            if (r2 <= r5) goto L_0x003d
            int r2 = r0.n()
            goto L_0x003e
        L_0x003d:
            r4 = r3
        L_0x003e:
            if (r4 == 0) goto L_0x0055
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.v(r7, r8, r1, r0)
            u7.a r0 = r6.f15392a
            r0.h(r7, r8)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.f.c(android.view.View, int):void");
    }

    public final void d(List list, int i10) {
        int i11 = this.f15394c[i10];
        if (i11 == -1) {
            i11 = 0;
        }
        if (list.size() > i11) {
            list.subList(i11, list.size()).clear();
        }
        int[] iArr = this.f15394c;
        int length = iArr.length - 1;
        if (i10 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i10, length, -1);
        }
        long[] jArr = this.f15395d;
        int length2 = jArr.length - 1;
        if (i10 > length2) {
            Arrays.fill(jArr, 0);
        } else {
            Arrays.fill(jArr, i10, length2, 0);
        }
    }

    public final ArrayList f(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            e eVar = new e(0);
            eVar.f15391i = ((b) this.f15392a.a(i11).getLayoutParams()).getOrder();
            eVar.f15390h = i11;
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public final void g(int i10, int i11, int i12) {
        int i13;
        int i14;
        ArrayList arrayList;
        a aVar = this.f15392a;
        int flexDirection = aVar.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            i13 = mode;
            i14 = size;
        } else if (flexDirection == 2 || flexDirection == 3) {
            i13 = View.MeasureSpec.getMode(i10);
            i14 = View.MeasureSpec.getSize(i10);
        } else {
            throw new IllegalArgumentException(h.i("Invalid flex direction: ", flexDirection));
        }
        List<c> flexLinesInternal = aVar.getFlexLinesInternal();
        if (i13 == 1073741824) {
            int sumOfCrossSize = aVar.getSumOfCrossSize() + i12;
            int i15 = 0;
            if (flexLinesInternal.size() == 1) {
                ((c) flexLinesInternal.get(0)).f15376g = i14 - i12;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = aVar.getAlignContent();
                if (alignContent != 1) {
                    if (alignContent != 2) {
                        if (alignContent != 3) {
                            if (alignContent != 4) {
                                if (alignContent == 5 && sumOfCrossSize < i14) {
                                    float size2 = ((float) (i14 - sumOfCrossSize)) / ((float) flexLinesInternal.size());
                                    int size3 = flexLinesInternal.size();
                                    float f10 = 0.0f;
                                    while (i15 < size3) {
                                        c cVar = (c) flexLinesInternal.get(i15);
                                        float f11 = ((float) cVar.f15376g) + size2;
                                        if (i15 == flexLinesInternal.size() - 1) {
                                            f11 += f10;
                                            f10 = 0.0f;
                                        }
                                        int round = Math.round(f11);
                                        float f12 = (f11 - ((float) round)) + f10;
                                        if (f12 > 1.0f) {
                                            round++;
                                            f12 -= 1.0f;
                                        } else if (f12 < -1.0f) {
                                            round--;
                                            f12 += 1.0f;
                                        }
                                        f10 = f12;
                                        cVar.f15376g = round;
                                        i15++;
                                    }
                                    return;
                                }
                                return;
                            } else if (sumOfCrossSize < i14) {
                                int size4 = (i14 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                                arrayList = new ArrayList();
                                c cVar2 = new c();
                                cVar2.f15376g = size4;
                                for (c add : flexLinesInternal) {
                                    arrayList.add(cVar2);
                                    arrayList.add(add);
                                    arrayList.add(cVar2);
                                }
                            }
                        } else if (sumOfCrossSize < i14) {
                            float size5 = ((float) (i14 - sumOfCrossSize)) / ((float) (flexLinesInternal.size() - 1));
                            arrayList = new ArrayList();
                            int size6 = flexLinesInternal.size();
                            float f13 = 0.0f;
                            while (i15 < size6) {
                                arrayList.add((c) flexLinesInternal.get(i15));
                                if (i15 != flexLinesInternal.size() - 1) {
                                    c cVar3 = new c();
                                    if (i15 == flexLinesInternal.size() - 2) {
                                        cVar3.f15376g = Math.round(f13 + size5);
                                        f13 = 0.0f;
                                    } else {
                                        cVar3.f15376g = Math.round(size5);
                                    }
                                    int i16 = cVar3.f15376g;
                                    float f14 = (size5 - ((float) i16)) + f13;
                                    if (f14 > 1.0f) {
                                        cVar3.f15376g = i16 + 1;
                                        f14 -= 1.0f;
                                    } else if (f14 < -1.0f) {
                                        cVar3.f15376g = i16 - 1;
                                        f14 += 1.0f;
                                    }
                                    arrayList.add(cVar3);
                                    f13 = f14;
                                }
                                i15++;
                            }
                        } else {
                            return;
                        }
                        aVar.setFlexLines(arrayList);
                        return;
                    }
                    arrayList = e(i14, sumOfCrossSize, flexLinesInternal);
                    aVar.setFlexLines(arrayList);
                    return;
                }
                int i17 = i14 - sumOfCrossSize;
                c cVar4 = new c();
                cVar4.f15376g = i17;
                flexLinesInternal.add(0, cVar4);
            }
        }
    }

    public final void h(int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        a aVar = this.f15392a;
        int flexItemCount = aVar.getFlexItemCount();
        boolean[] zArr = this.f15393b;
        int i16 = 0;
        if (zArr == null) {
            this.f15393b = new boolean[Math.max(flexItemCount, 10)];
        } else if (zArr.length < flexItemCount) {
            this.f15393b = new boolean[Math.max(zArr.length * 2, flexItemCount)];
        } else {
            Arrays.fill(zArr, false);
        }
        if (i12 < aVar.getFlexItemCount()) {
            int flexDirection = aVar.getFlexDirection();
            int flexDirection2 = aVar.getFlexDirection();
            if (flexDirection2 == 0 || flexDirection2 == 1) {
                int mode = View.MeasureSpec.getMode(i10);
                int size = View.MeasureSpec.getSize(i10);
                int largestMainSize = aVar.getLargestMainSize();
                if (mode != 1073741824) {
                    size = Math.min(largestMainSize, size);
                }
                i15 = aVar.getPaddingLeft();
                i13 = aVar.getPaddingRight();
            } else if (flexDirection2 == 2 || flexDirection2 == 3) {
                int mode2 = View.MeasureSpec.getMode(i11);
                i14 = View.MeasureSpec.getSize(i11);
                if (mode2 != 1073741824) {
                    i14 = aVar.getLargestMainSize();
                }
                i15 = aVar.getPaddingTop();
                i13 = aVar.getPaddingBottom();
            } else {
                throw new IllegalArgumentException(h.i("Invalid flex direction: ", flexDirection));
            }
            int i17 = i13 + i15;
            int[] iArr = this.f15394c;
            if (iArr != null) {
                i16 = iArr[i12];
            }
            List flexLinesInternal = aVar.getFlexLinesInternal();
            int size2 = flexLinesInternal.size();
            while (i16 < size2) {
                c cVar = (c) flexLinesInternal.get(i16);
                int i18 = cVar.f15374e;
                if (i18 < i14 && cVar.f15386q) {
                    l(i10, i11, cVar, i14, i17, false);
                } else if (i18 > i14 && cVar.f15387r) {
                    q(i10, i11, cVar, i14, i17, false);
                }
                i16++;
            }
        }
    }

    public final void i(int i10) {
        int[] iArr = this.f15394c;
        if (iArr == null) {
            this.f15394c = new int[Math.max(i10, 10)];
        } else if (iArr.length < i10) {
            this.f15394c = Arrays.copyOf(this.f15394c, Math.max(iArr.length * 2, i10));
        }
    }

    public final void j(int i10) {
        long[] jArr = this.f15395d;
        if (jArr == null) {
            this.f15395d = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f15395d = Arrays.copyOf(this.f15395d, Math.max(jArr.length * 2, i10));
        }
    }

    public final void k(int i10) {
        long[] jArr = this.f15396e;
        if (jArr == null) {
            this.f15396e = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f15396e = Arrays.copyOf(this.f15396e, Math.max(jArr.length * 2, i10));
        }
    }

    public final void l(int i10, int i11, c cVar, int i12, int i13, boolean z10) {
        int i14;
        int i15;
        float f10;
        int i16;
        a aVar;
        int i17;
        a aVar2;
        double d10;
        View view;
        a aVar3;
        double d11;
        c cVar2 = cVar;
        int i18 = i12;
        float f11 = cVar2.f15379j;
        if (f11 > 0.0f && i18 >= (i14 = cVar2.f15374e)) {
            float f12 = ((float) (i18 - i14)) / f11;
            cVar2.f15374e = i13 + cVar2.f15375f;
            if (!z10) {
                cVar2.f15376g = RecyclerView.UNDEFINED_DURATION;
            }
            int i19 = 0;
            boolean z11 = false;
            int i20 = 0;
            float f13 = 0.0f;
            while (i19 < cVar2.f15377h) {
                int i21 = cVar2.f15384o + i19;
                a aVar4 = this.f15392a;
                View g10 = aVar4.g(i21);
                if (g10 == null || g10.getVisibility() == 8) {
                    int i22 = i10;
                    i15 = i14;
                    f10 = f12;
                    int i23 = i11;
                } else {
                    b bVar = (b) g10.getLayoutParams();
                    int flexDirection = aVar4.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        a aVar5 = aVar4;
                        View view2 = g10;
                        int i24 = i10;
                        int measuredWidth = view2.getMeasuredWidth();
                        long[] jArr = this.f15396e;
                        if (jArr != null) {
                            measuredWidth = (int) jArr[i21];
                        }
                        int measuredHeight = view2.getMeasuredHeight();
                        long[] jArr2 = this.f15396e;
                        if (jArr2 != null) {
                            long j10 = jArr2[i21];
                            aVar = aVar5;
                            i17 = i14;
                            measuredHeight = (int) (j10 >> 32);
                        } else {
                            aVar = aVar5;
                            i17 = i14;
                        }
                        if (this.f15393b[i21] || bVar.b() <= 0.0f) {
                            i15 = i17;
                            f10 = f12;
                            aVar2 = aVar;
                            int i25 = i11;
                        } else {
                            float b10 = (bVar.b() * f12) + ((float) measuredWidth);
                            if (i19 == cVar2.f15377h - 1) {
                                b10 += f13;
                                f13 = 0.0f;
                            }
                            int round = Math.round(b10);
                            if (round > bVar.s()) {
                                round = bVar.s();
                                this.f15393b[i21] = true;
                                cVar2.f15379j -= bVar.b();
                                i15 = i17;
                                f10 = f12;
                                z11 = true;
                            } else {
                                float f14 = (b10 - ((float) round)) + f13;
                                i15 = i17;
                                f10 = f12;
                                double d12 = (double) f14;
                                if (d12 > 1.0d) {
                                    round++;
                                    d10 = d12 - 1.0d;
                                } else if (d12 < -1.0d) {
                                    round--;
                                    d10 = d12 + 1.0d;
                                } else {
                                    f13 = f14;
                                }
                                f13 = (float) d10;
                            }
                            int m10 = m(i11, bVar, cVar2.f15382m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            view2.measure(makeMeasureSpec, m10);
                            measuredWidth = view2.getMeasuredWidth();
                            measuredHeight = view2.getMeasuredHeight();
                            v(view2, i21, makeMeasureSpec, m10);
                            aVar2 = aVar;
                            aVar2.h(view2, i21);
                        }
                        i16 = Math.max(i20, aVar2.k(view2) + bVar.p() + bVar.t() + measuredHeight);
                        cVar2.f15374e = bVar.i() + bVar.q() + measuredWidth + cVar2.f15374e;
                    } else {
                        int measuredHeight2 = g10.getMeasuredHeight();
                        long[] jArr3 = this.f15396e;
                        if (jArr3 != null) {
                            measuredHeight2 = (int) (jArr3[i21] >> 32);
                        }
                        int measuredWidth2 = g10.getMeasuredWidth();
                        long[] jArr4 = this.f15396e;
                        a aVar6 = aVar4;
                        View view3 = g10;
                        if (jArr4 != null) {
                            measuredWidth2 = (int) jArr4[i21];
                        }
                        if (this.f15393b[i21] || bVar.b() <= 0.0f) {
                            int i26 = i10;
                            aVar3 = aVar6;
                            view = view3;
                        } else {
                            float b11 = (bVar.b() * f12) + ((float) measuredHeight2);
                            if (i19 == cVar2.f15377h - 1) {
                                b11 += f13;
                                f13 = 0.0f;
                            }
                            int round2 = Math.round(b11);
                            if (round2 > bVar.n()) {
                                round2 = bVar.n();
                                this.f15393b[i21] = true;
                                cVar2.f15379j -= bVar.b();
                                z11 = true;
                            } else {
                                float f15 = (b11 - ((float) round2)) + f13;
                                double d13 = (double) f15;
                                if (d13 > 1.0d) {
                                    round2++;
                                    d11 = d13 - 1.0d;
                                } else if (d13 < -1.0d) {
                                    round2--;
                                    d11 = d13 + 1.0d;
                                } else {
                                    f13 = f15;
                                }
                                f13 = (float) d11;
                            }
                            int n10 = n(i10, bVar, cVar2.f15382m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            View view4 = view3;
                            view4.measure(n10, makeMeasureSpec2);
                            measuredWidth2 = view4.getMeasuredWidth();
                            int measuredHeight3 = view4.getMeasuredHeight();
                            v(view4, i21, n10, makeMeasureSpec2);
                            aVar3 = aVar6;
                            aVar3.h(view4, i21);
                            view = view4;
                            measuredHeight2 = measuredHeight3;
                        }
                        i16 = Math.max(i20, aVar3.k(view) + bVar.i() + bVar.q() + measuredWidth2);
                        cVar2.f15374e = bVar.p() + bVar.t() + measuredHeight2 + cVar2.f15374e;
                        i15 = i14;
                        f10 = f12;
                        int i27 = i11;
                    }
                    cVar2.f15376g = Math.max(cVar2.f15376g, i16);
                    i20 = i16;
                }
                i19++;
                int i28 = i12;
                f12 = f10;
                i14 = i15;
            }
            int i29 = i10;
            int i30 = i11;
            int i31 = i14;
            if (z11 && i31 != cVar2.f15374e) {
                l(i10, i11, cVar, i12, i13, true);
            }
        }
    }

    public final int m(int i10, b bVar, int i11) {
        int i12;
        a aVar = this.f15392a;
        int c10 = aVar.c(i10, bVar.p() + bVar.t() + aVar.getPaddingBottom() + aVar.getPaddingTop() + i11, bVar.c());
        int size = View.MeasureSpec.getSize(c10);
        if (size > bVar.n()) {
            i12 = bVar.n();
        } else if (size >= bVar.j()) {
            return c10;
        } else {
            i12 = bVar.j();
        }
        return View.MeasureSpec.makeMeasureSpec(i12, View.MeasureSpec.getMode(c10));
    }

    public final int n(int i10, b bVar, int i11) {
        int i12;
        a aVar = this.f15392a;
        int i13 = aVar.i(i10, bVar.i() + bVar.q() + aVar.getPaddingRight() + aVar.getPaddingLeft() + i11, bVar.m());
        int size = View.MeasureSpec.getSize(i13);
        if (size > bVar.s()) {
            i12 = bVar.s();
        } else if (size >= bVar.k()) {
            return i13;
        } else {
            i12 = bVar.k();
        }
        return View.MeasureSpec.makeMeasureSpec(i12, View.MeasureSpec.getMode(i13));
    }

    public final void o(View view, c cVar, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int p10;
        int i19;
        b bVar = (b) view.getLayoutParams();
        a aVar = this.f15392a;
        int alignItems = aVar.getAlignItems();
        if (bVar.e() != -1) {
            alignItems = bVar.e();
        }
        int i20 = cVar.f15376g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    int t10 = ((bVar.t() + (i20 - view.getMeasuredHeight())) - bVar.p()) / 2;
                    int i21 = aVar.getFlexWrap() != 2 ? i11 + t10 : i11 - t10;
                    view.layout(i10, i21, i12, view.getMeasuredHeight() + i21);
                    return;
                } else if (alignItems == 3) {
                    int flexWrap = aVar.getFlexWrap();
                    int i22 = cVar.f15381l;
                    if (flexWrap != 2) {
                        i19 = Math.max(i22 - view.getBaseline(), bVar.t());
                        i15 = i11 + i19;
                    } else {
                        i16 = Math.max(view.getBaseline() + (i22 - view.getMeasuredHeight()), bVar.p());
                        p10 = i11 - i16;
                        i14 = i13 - i16;
                        view.layout(i10, i15, i12, i14);
                    }
                } else if (alignItems != 4) {
                    return;
                }
            } else if (aVar.getFlexWrap() != 2) {
                int i23 = i11 + i20;
                i18 = (i23 - view.getMeasuredHeight()) - bVar.p();
                i17 = i23 - bVar.p();
                view.layout(i10, i18, i12, i17);
                return;
            } else {
                i15 = bVar.t() + view.getMeasuredHeight() + (i11 - i20);
                i19 = view.getMeasuredHeight() + (i13 - i20);
                i13 = bVar.t();
            }
            i14 = i13 + i19;
            view.layout(i10, i15, i12, i14);
        }
        if (aVar.getFlexWrap() != 2) {
            i18 = bVar.t() + i11;
            i17 = bVar.t() + i13;
            view.layout(i10, i18, i12, i17);
            return;
        }
        p10 = i11 - bVar.p();
        i16 = bVar.p();
        i14 = i13 - i16;
        view.layout(i10, i15, i12, i14);
    }

    public final void p(View view, c cVar, boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        b bVar = (b) view.getLayoutParams();
        int alignItems = this.f15392a.getAlignItems();
        if (bVar.e() != -1) {
            alignItems = bVar.e();
        }
        int i16 = cVar.f15376g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int c10 = ((p.c(marginLayoutParams) + (i16 - view.getMeasuredWidth())) - p.b(marginLayoutParams)) / 2;
                    if (!z10) {
                        i15 = i10 + c10;
                        i14 = i12 + c10;
                    } else {
                        i15 = i10 - c10;
                        i14 = i12 - c10;
                    }
                    view.layout(i15, i11, i14, i13);
                } else if (!(alignItems == 3 || alignItems == 4)) {
                    return;
                }
            } else if (!z10) {
                i15 = ((i10 + i16) - view.getMeasuredWidth()) - bVar.i();
                i12 = (i12 + i16) - view.getMeasuredWidth();
                i14 = i12 - bVar.i();
                view.layout(i15, i11, i14, i13);
            } else {
                int q10 = bVar.q();
                view.layout(bVar.q() + view.getMeasuredWidth() + (i10 - i16), i11, q10 + view.getMeasuredWidth() + (i12 - i16), i13);
                return;
            }
        }
        if (!z10) {
            view.layout(bVar.q() + i10, i11, bVar.q() + i12, i13);
            return;
        }
        i15 = i10 - bVar.i();
        i14 = i12 - bVar.i();
        view.layout(i15, i11, i14, i13);
    }

    public final void q(int i10, int i11, c cVar, int i12, int i13, boolean z10) {
        float f10;
        int i14;
        View view;
        int i15;
        View view2;
        a aVar;
        int i16;
        c cVar2 = cVar;
        int i17 = i12;
        int i18 = cVar2.f15374e;
        float f11 = cVar2.f15380k;
        if (f11 > 0.0f && i17 <= i18) {
            float f12 = ((float) (i18 - i17)) / f11;
            cVar2.f15374e = i13 + cVar2.f15375f;
            if (!z10) {
                cVar2.f15376g = RecyclerView.UNDEFINED_DURATION;
            }
            int i19 = 0;
            boolean z11 = false;
            int i20 = 0;
            float f13 = 0.0f;
            while (i19 < cVar2.f15377h) {
                int i21 = cVar2.f15384o + i19;
                a aVar2 = this.f15392a;
                View g10 = aVar2.g(i21);
                if (g10 == null || g10.getVisibility() == 8) {
                    int i22 = i11;
                    f10 = f12;
                    z11 = z11;
                } else {
                    b bVar = (b) g10.getLayoutParams();
                    int flexDirection = aVar2.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        a aVar3 = aVar2;
                        View view3 = g10;
                        int i23 = i10;
                        int measuredWidth = view3.getMeasuredWidth();
                        long[] jArr = this.f15396e;
                        if (jArr != null) {
                            measuredWidth = (int) jArr[i21];
                        }
                        int measuredHeight = view3.getMeasuredHeight();
                        long[] jArr2 = this.f15396e;
                        if (jArr2 != null) {
                            long j10 = jArr2[i21];
                            view = view3;
                            measuredHeight = (int) (j10 >> 32);
                        } else {
                            view = view3;
                        }
                        if (this.f15393b[i21] || bVar.f() <= 0.0f) {
                            int i24 = i11;
                            f10 = f12;
                            z11 = z11;
                        } else {
                            float f14 = ((float) measuredWidth) - (bVar.f() * f12);
                            boolean z12 = true;
                            if (i19 == cVar2.f15377h - 1) {
                                f14 += f13;
                                f13 = 0.0f;
                            }
                            int round = Math.round(f14);
                            if (round < bVar.k()) {
                                i15 = bVar.k();
                                this.f15393b[i21] = true;
                                cVar2.f15380k -= bVar.f();
                                f10 = f12;
                            } else {
                                float f15 = (f14 - ((float) round)) + f13;
                                f10 = f12;
                                boolean z13 = z11;
                                double d10 = (double) f15;
                                if (d10 > 1.0d) {
                                    round++;
                                    f15 -= 1.0f;
                                } else if (d10 < -1.0d) {
                                    round--;
                                    f15 += 1.0f;
                                }
                                f13 = f15;
                                i15 = round;
                                z12 = z13;
                            }
                            int m10 = m(i11, bVar, cVar2.f15382m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                            view.measure(makeMeasureSpec, m10);
                            measuredWidth = view.getMeasuredWidth();
                            int measuredHeight2 = view.getMeasuredHeight();
                            v(view, i21, makeMeasureSpec, m10);
                            aVar3.h(view, i21);
                            z11 = z12;
                            measuredHeight = measuredHeight2;
                        }
                        i14 = Math.max(i20, aVar3.k(view) + bVar.p() + bVar.t() + measuredHeight);
                        cVar2.f15374e = bVar.i() + bVar.q() + measuredWidth + cVar2.f15374e;
                    } else {
                        int measuredHeight3 = g10.getMeasuredHeight();
                        long[] jArr3 = this.f15396e;
                        if (jArr3 != null) {
                            measuredHeight3 = (int) (jArr3[i21] >> 32);
                        }
                        int measuredWidth2 = g10.getMeasuredWidth();
                        long[] jArr4 = this.f15396e;
                        a aVar4 = aVar2;
                        View view4 = g10;
                        if (jArr4 != null) {
                            measuredWidth2 = (int) jArr4[i21];
                        }
                        if (this.f15393b[i21] || bVar.f() <= 0.0f) {
                            int i25 = i10;
                            aVar = aVar4;
                            view2 = view4;
                        } else {
                            float f16 = ((float) measuredHeight3) - (bVar.f() * f12);
                            if (i19 == cVar2.f15377h - 1) {
                                f16 += f13;
                                f13 = 0.0f;
                            }
                            int round2 = Math.round(f16);
                            if (round2 < bVar.j()) {
                                i16 = bVar.j();
                                this.f15393b[i21] = true;
                                cVar2.f15380k -= bVar.f();
                                z11 = true;
                            } else {
                                float f17 = (f16 - ((float) round2)) + f13;
                                double d11 = (double) f17;
                                if (d11 > 1.0d) {
                                    round2++;
                                    f17 -= 1.0f;
                                } else if (d11 < -1.0d) {
                                    round2--;
                                    f17 += 1.0f;
                                }
                                f13 = f17;
                                i16 = round2;
                            }
                            int n10 = n(i10, bVar, cVar2.f15382m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                            View view5 = view4;
                            view5.measure(n10, makeMeasureSpec2);
                            measuredWidth2 = view5.getMeasuredWidth();
                            int measuredHeight4 = view5.getMeasuredHeight();
                            v(view5, i21, n10, makeMeasureSpec2);
                            aVar = aVar4;
                            aVar.h(view5, i21);
                            view2 = view5;
                            measuredHeight3 = measuredHeight4;
                        }
                        i14 = Math.max(i20, aVar.k(view2) + bVar.i() + bVar.q() + measuredWidth2);
                        cVar2.f15374e = bVar.p() + bVar.t() + measuredHeight3 + cVar2.f15374e;
                        int i26 = i11;
                        f10 = f12;
                    }
                    cVar2.f15376g = Math.max(cVar2.f15376g, i14);
                    i20 = i14;
                }
                i19++;
                int i27 = i12;
                f12 = f10;
            }
            int i28 = i11;
            if (z11 && i18 != cVar2.f15374e) {
                q(i10, i11, cVar, i12, i13, true);
            }
        }
    }

    public final void s(View view, int i10, int i11) {
        b bVar = (b) view.getLayoutParams();
        int q10 = (i10 - bVar.q()) - bVar.i();
        a aVar = this.f15392a;
        int min = Math.min(Math.max(q10 - aVar.k(view), bVar.k()), bVar.s());
        long[] jArr = this.f15396e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? (int) (jArr[i11] >> 32) : view.getMeasuredHeight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        v(view, i11, makeMeasureSpec2, makeMeasureSpec);
        aVar.h(view, i11);
    }

    public final void t(View view, int i10, int i11) {
        b bVar = (b) view.getLayoutParams();
        int t10 = (i10 - bVar.t()) - bVar.p();
        a aVar = this.f15392a;
        int min = Math.min(Math.max(t10 - aVar.k(view), bVar.j()), bVar.n());
        long[] jArr = this.f15396e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? (int) jArr[i11] : view.getMeasuredWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        v(view, i11, makeMeasureSpec, makeMeasureSpec2);
        aVar.h(view, i11);
    }

    public final void u(int i10) {
        int i11;
        View g10;
        a aVar = this.f15392a;
        if (i10 < aVar.getFlexItemCount()) {
            int flexDirection = aVar.getFlexDirection();
            if (aVar.getAlignItems() == 4) {
                int[] iArr = this.f15394c;
                if (iArr != null) {
                    i11 = iArr[i10];
                } else {
                    i11 = 0;
                }
                List flexLinesInternal = aVar.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                while (i11 < size) {
                    c cVar = (c) flexLinesInternal.get(i11);
                    int i12 = cVar.f15377h;
                    for (int i13 = 0; i13 < i12; i13++) {
                        int i14 = cVar.f15384o + i13;
                        if (!(i13 >= aVar.getFlexItemCount() || (g10 = aVar.g(i14)) == null || g10.getVisibility() == 8)) {
                            b bVar = (b) g10.getLayoutParams();
                            if (bVar.e() == -1 || bVar.e() == 4) {
                                if (flexDirection == 0 || flexDirection == 1) {
                                    t(g10, cVar.f15376g, i14);
                                } else if (flexDirection == 2 || flexDirection == 3) {
                                    s(g10, cVar.f15376g, i14);
                                } else {
                                    throw new IllegalArgumentException(h.i("Invalid flex direction: ", flexDirection));
                                }
                            }
                        }
                    }
                    i11++;
                }
                return;
            }
            for (c cVar2 : aVar.getFlexLinesInternal()) {
                Iterator it = cVar2.f15383n.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        View g11 = aVar.g(num.intValue());
                        if (flexDirection == 0 || flexDirection == 1) {
                            t(g11, cVar2.f15376g, num.intValue());
                        } else if (flexDirection == 2 || flexDirection == 3) {
                            s(g11, cVar2.f15376g, num.intValue());
                        } else {
                            throw new IllegalArgumentException(h.i("Invalid flex direction: ", flexDirection));
                        }
                    }
                }
            }
        }
    }

    public final void v(View view, int i10, int i11, int i12) {
        long[] jArr = this.f15395d;
        if (jArr != null) {
            jArr[i10] = (((long) i11) & 4294967295L) | (((long) i12) << 32);
        }
        long[] jArr2 = this.f15396e;
        if (jArr2 != null) {
            jArr2[i10] = (((long) view.getMeasuredWidth()) & 4294967295L) | (((long) view.getMeasuredHeight()) << 32);
        }
    }
}

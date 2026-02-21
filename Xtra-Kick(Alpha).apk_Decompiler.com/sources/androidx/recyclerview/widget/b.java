package androidx.recyclerview.widget;

import androidx.fragment.app.p0;
import java.util.ArrayList;
import s.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final f f1933a = new f(30, 1);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1934b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1935c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final e1 f1936d;

    /* renamed from: e  reason: collision with root package name */
    public final p0 f1937e;

    /* renamed from: f  reason: collision with root package name */
    public int f1938f = 0;

    public b(e1 e1Var) {
        this.f1936d = e1Var;
        this.f1937e = new p0(2, this);
    }

    public final boolean a(int i10) {
        ArrayList arrayList = this.f1935c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = (a) arrayList.get(i11);
            int i12 = aVar.f1925a;
            if (i12 == 8) {
                if (f(aVar.f1928d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = aVar.f1926b;
                int i14 = aVar.f1928d + i13;
                while (i13 < i14) {
                    if (f(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public final void b() {
        ArrayList arrayList = this.f1935c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1936d.a((a) arrayList.get(i10));
        }
        l(arrayList);
        this.f1938f = 0;
    }

    public final void c() {
        b();
        ArrayList arrayList = this.f1934b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) arrayList.get(i10);
            int i11 = aVar.f1925a;
            e1 e1Var = this.f1936d;
            if (i11 == 1) {
                e1Var.a(aVar);
                int i12 = aVar.f1926b;
                int i13 = aVar.f1928d;
                RecyclerView recyclerView = e1Var.f1972a;
                recyclerView.offsetPositionRecordsForInsert(i12, i13);
                recyclerView.mItemsAddedOrRemoved = true;
            } else if (i11 == 2) {
                e1Var.a(aVar);
                int i14 = aVar.f1926b;
                int i15 = aVar.f1928d;
                RecyclerView recyclerView2 = e1Var.f1972a;
                recyclerView2.offsetPositionRecordsForRemove(i14, i15, true);
                recyclerView2.mItemsAddedOrRemoved = true;
                recyclerView2.mState.f2020c += i15;
            } else if (i11 == 4) {
                e1Var.a(aVar);
                int i16 = aVar.f1926b;
                int i17 = aVar.f1928d;
                Object obj = aVar.f1927c;
                RecyclerView recyclerView3 = e1Var.f1972a;
                recyclerView3.viewRangeUpdate(i16, i17, obj);
                recyclerView3.mItemsChanged = true;
            } else if (i11 == 8) {
                e1Var.a(aVar);
                int i18 = aVar.f1926b;
                int i19 = aVar.f1928d;
                RecyclerView recyclerView4 = e1Var.f1972a;
                recyclerView4.offsetPositionRecordsForMove(i18, i19);
                recyclerView4.mItemsAddedOrRemoved = true;
            }
        }
        l(arrayList);
        this.f1938f = 0;
    }

    public final void d(a aVar) {
        int i10;
        f fVar;
        boolean z10;
        int i11 = aVar.f1925a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int m10 = m(aVar.f1926b, i11);
        int i12 = aVar.f1926b;
        int i13 = aVar.f1925a;
        if (i13 == 2) {
            i10 = 0;
        } else if (i13 == 4) {
            i10 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + aVar);
        }
        int i14 = 1;
        int i15 = 1;
        while (true) {
            int i16 = aVar.f1928d;
            fVar = this.f1933a;
            if (i14 >= i16) {
                break;
            }
            int m11 = m((i10 * i14) + aVar.f1926b, aVar.f1925a);
            int i17 = aVar.f1925a;
            if (i17 == 2 ? m11 != m10 : !(i17 == 4 && m11 == m10 + 1)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i15++;
            } else {
                a h10 = h(aVar.f1927c, i17, m10, i15);
                e(h10, i12);
                h10.f1927c = null;
                fVar.e(h10);
                if (aVar.f1925a == 4) {
                    i12 += i15;
                }
                m10 = m11;
                i15 = 1;
            }
            i14++;
        }
        Object obj = aVar.f1927c;
        aVar.f1927c = null;
        fVar.e(aVar);
        if (i15 > 0) {
            a h11 = h(obj, aVar.f1925a, m10, i15);
            e(h11, i12);
            h11.f1927c = null;
            fVar.e(h11);
        }
    }

    public final void e(a aVar, int i10) {
        e1 e1Var = this.f1936d;
        e1Var.a(aVar);
        int i11 = aVar.f1925a;
        RecyclerView recyclerView = e1Var.f1972a;
        if (i11 == 2) {
            int i12 = aVar.f1928d;
            recyclerView.offsetPositionRecordsForRemove(i10, i12, true);
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f2020c += i12;
        } else if (i11 == 4) {
            recyclerView.viewRangeUpdate(i10, aVar.f1928d, aVar.f1927c);
            recyclerView.mItemsChanged = true;
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public final int f(int i10, int i11) {
        ArrayList arrayList = this.f1935c;
        int size = arrayList.size();
        while (i11 < size) {
            a aVar = (a) arrayList.get(i11);
            int i12 = aVar.f1925a;
            if (i12 == 8) {
                int i13 = aVar.f1926b;
                if (i13 == i10) {
                    i10 = aVar.f1928d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (aVar.f1928d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = aVar.f1926b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = aVar.f1928d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += aVar.f1928d;
                }
            }
            i11++;
        }
        return i10;
    }

    public final boolean g() {
        return this.f1934b.size() > 0;
    }

    public final a h(Object obj, int i10, int i11, int i12) {
        a aVar = (a) this.f1933a.j();
        if (aVar == null) {
            return new a(obj, i10, i11, i12);
        }
        aVar.f1925a = i10;
        aVar.f1926b = i11;
        aVar.f1928d = i12;
        aVar.f1927c = obj;
        return aVar;
    }

    public final void i(a aVar) {
        this.f1935c.add(aVar);
        int i10 = aVar.f1925a;
        e1 e1Var = this.f1936d;
        if (i10 == 1) {
            int i11 = aVar.f1926b;
            int i12 = aVar.f1928d;
            RecyclerView recyclerView = e1Var.f1972a;
            recyclerView.offsetPositionRecordsForInsert(i11, i12);
            recyclerView.mItemsAddedOrRemoved = true;
        } else if (i10 == 2) {
            int i13 = aVar.f1926b;
            int i14 = aVar.f1928d;
            RecyclerView recyclerView2 = e1Var.f1972a;
            recyclerView2.offsetPositionRecordsForRemove(i13, i14, false);
            recyclerView2.mItemsAddedOrRemoved = true;
        } else if (i10 == 4) {
            int i15 = aVar.f1926b;
            int i16 = aVar.f1928d;
            Object obj = aVar.f1927c;
            RecyclerView recyclerView3 = e1Var.f1972a;
            recyclerView3.viewRangeUpdate(i15, i16, obj);
            recyclerView3.mItemsChanged = true;
        } else if (i10 == 8) {
            int i17 = aVar.f1926b;
            int i18 = aVar.f1928d;
            RecyclerView recyclerView4 = e1Var.f1972a;
            recyclerView4.offsetPositionRecordsForMove(i17, i18);
            recyclerView4.mItemsAddedOrRemoved = true;
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + aVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015e, code lost:
        if (r5 > r12.f1926b) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0188, code lost:
        if (r5 >= r12.f1926b) goto L_0x018a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r16 = this;
            r0 = r16
            java.util.ArrayList r1 = r0.f1934b
            androidx.fragment.app.p0 r2 = r0.f1937e
            r2.getClass()
        L_0x0009:
            int r3 = r1.size()
            r4 = 1
            int r3 = r3 - r4
            r6 = 0
        L_0x0010:
            r7 = 8
            r8 = -1
            if (r3 < 0) goto L_0x0026
            java.lang.Object r9 = r1.get(r3)
            androidx.recyclerview.widget.a r9 = (androidx.recyclerview.widget.a) r9
            int r9 = r9.f1925a
            if (r9 != r7) goto L_0x0022
            if (r6 == 0) goto L_0x0023
            goto L_0x0027
        L_0x0022:
            r6 = 1
        L_0x0023:
            int r3 = r3 + -1
            goto L_0x0010
        L_0x0026:
            r3 = -1
        L_0x0027:
            r6 = 0
            r9 = 4
            r10 = 2
            if (r3 == r8) goto L_0x01d0
            int r7 = r3 + 1
            java.lang.Object r11 = r1.get(r3)
            androidx.recyclerview.widget.a r11 = (androidx.recyclerview.widget.a) r11
            java.lang.Object r12 = r1.get(r7)
            androidx.recyclerview.widget.a r12 = (androidx.recyclerview.widget.a) r12
            int r13 = r12.f1925a
            if (r13 == r4) goto L_0x01a6
            java.lang.Object r8 = r2.f1532i
            if (r13 == r10) goto L_0x00af
            if (r13 == r9) goto L_0x0045
            goto L_0x0009
        L_0x0045:
            int r5 = r11.f1928d
            int r10 = r12.f1926b
            if (r5 >= r10) goto L_0x0050
            int r10 = r10 + -1
            r12.f1926b = r10
            goto L_0x0065
        L_0x0050:
            int r13 = r12.f1928d
            int r10 = r10 + r13
            if (r5 >= r10) goto L_0x0065
            int r13 = r13 + -1
            r12.f1928d = r13
            r5 = r8
            androidx.recyclerview.widget.b r5 = (androidx.recyclerview.widget.b) r5
            int r10 = r11.f1926b
            java.lang.Object r13 = r12.f1927c
            androidx.recyclerview.widget.a r4 = r5.h(r13, r9, r10, r4)
            goto L_0x0066
        L_0x0065:
            r4 = r6
        L_0x0066:
            int r5 = r11.f1926b
            int r10 = r12.f1926b
            if (r5 > r10) goto L_0x0071
            int r10 = r10 + 1
            r12.f1926b = r10
            goto L_0x0088
        L_0x0071:
            int r13 = r12.f1928d
            int r10 = r10 + r13
            if (r5 >= r10) goto L_0x0088
            int r10 = r10 - r5
            r13 = r8
            androidx.recyclerview.widget.b r13 = (androidx.recyclerview.widget.b) r13
            int r5 = r5 + 1
            java.lang.Object r14 = r12.f1927c
            androidx.recyclerview.widget.a r5 = r13.h(r14, r9, r5, r10)
            int r9 = r12.f1928d
            int r9 = r9 - r10
            r12.f1928d = r9
            goto L_0x0089
        L_0x0088:
            r5 = r6
        L_0x0089:
            r1.set(r7, r11)
            int r7 = r12.f1928d
            if (r7 <= 0) goto L_0x0094
            r1.set(r3, r12)
            goto L_0x00a3
        L_0x0094:
            r1.remove(r3)
            androidx.recyclerview.widget.b r8 = (androidx.recyclerview.widget.b) r8
            r8.getClass()
            r12.f1927c = r6
            s.f r6 = r8.f1933a
            r6.e(r12)
        L_0x00a3:
            if (r4 == 0) goto L_0x00a8
            r1.add(r3, r4)
        L_0x00a8:
            if (r5 == 0) goto L_0x0009
            r1.add(r3, r5)
            goto L_0x0009
        L_0x00af:
            int r9 = r11.f1926b
            int r13 = r11.f1928d
            int r14 = r12.f1926b
            if (r9 >= r13) goto L_0x00c4
            if (r14 != r9) goto L_0x00c1
            int r15 = r12.f1928d
            int r9 = r13 - r9
            if (r15 != r9) goto L_0x00c1
            r5 = 0
            goto L_0x00ce
        L_0x00c1:
            r5 = 0
            r9 = 0
            goto L_0x00d3
        L_0x00c4:
            int r15 = r13 + 1
            if (r14 != r15) goto L_0x00d1
            int r15 = r12.f1928d
            int r9 = r9 - r13
            if (r15 != r9) goto L_0x00d1
            r5 = 1
        L_0x00ce:
            r9 = r5
            r5 = 1
            goto L_0x00d3
        L_0x00d1:
            r5 = 0
            r9 = 1
        L_0x00d3:
            if (r13 >= r14) goto L_0x00da
            int r14 = r14 + -1
            r12.f1926b = r14
            goto L_0x00fc
        L_0x00da:
            int r15 = r12.f1928d
            int r14 = r14 + r15
            if (r13 >= r14) goto L_0x00fc
            int r15 = r15 + -1
            r12.f1928d = r15
            r11.f1925a = r10
            r11.f1928d = r4
            int r3 = r12.f1928d
            if (r3 != 0) goto L_0x0009
            r1.remove(r7)
            androidx.recyclerview.widget.b r8 = (androidx.recyclerview.widget.b) r8
            r8.getClass()
            r12.f1927c = r6
            s.f r3 = r8.f1933a
            r3.e(r12)
            goto L_0x0009
        L_0x00fc:
            int r4 = r11.f1926b
            int r13 = r12.f1926b
            if (r4 > r13) goto L_0x0107
            int r13 = r13 + 1
            r12.f1926b = r13
            goto L_0x011e
        L_0x0107:
            int r14 = r12.f1928d
            int r13 = r13 + r14
            if (r4 >= r13) goto L_0x011e
            int r13 = r13 - r4
            r14 = r8
            androidx.recyclerview.widget.b r14 = (androidx.recyclerview.widget.b) r14
            int r4 = r4 + 1
            androidx.recyclerview.widget.a r4 = r14.h(r6, r10, r4, r13)
            int r10 = r11.f1926b
            int r13 = r12.f1926b
            int r10 = r10 - r13
            r12.f1928d = r10
            goto L_0x011f
        L_0x011e:
            r4 = r6
        L_0x011f:
            if (r5 == 0) goto L_0x0135
            r1.set(r3, r12)
            r1.remove(r7)
            androidx.recyclerview.widget.b r8 = (androidx.recyclerview.widget.b) r8
            r8.getClass()
            r11.f1927c = r6
            s.f r3 = r8.f1933a
            r3.e(r11)
            goto L_0x0009
        L_0x0135:
            if (r9 == 0) goto L_0x0161
            if (r4 == 0) goto L_0x014f
            int r5 = r11.f1926b
            int r6 = r4.f1926b
            if (r5 <= r6) goto L_0x0144
            int r6 = r4.f1928d
            int r5 = r5 - r6
            r11.f1926b = r5
        L_0x0144:
            int r5 = r11.f1928d
            int r6 = r4.f1926b
            if (r5 <= r6) goto L_0x014f
            int r6 = r4.f1928d
            int r5 = r5 - r6
            r11.f1928d = r5
        L_0x014f:
            int r5 = r11.f1926b
            int r6 = r12.f1926b
            if (r5 <= r6) goto L_0x015a
            int r6 = r12.f1928d
            int r5 = r5 - r6
            r11.f1926b = r5
        L_0x015a:
            int r5 = r11.f1928d
            int r6 = r12.f1926b
            if (r5 <= r6) goto L_0x018f
            goto L_0x018a
        L_0x0161:
            if (r4 == 0) goto L_0x0179
            int r5 = r11.f1926b
            int r6 = r4.f1926b
            if (r5 < r6) goto L_0x016e
            int r6 = r4.f1928d
            int r5 = r5 - r6
            r11.f1926b = r5
        L_0x016e:
            int r5 = r11.f1928d
            int r6 = r4.f1926b
            if (r5 < r6) goto L_0x0179
            int r6 = r4.f1928d
            int r5 = r5 - r6
            r11.f1928d = r5
        L_0x0179:
            int r5 = r11.f1926b
            int r6 = r12.f1926b
            if (r5 < r6) goto L_0x0184
            int r6 = r12.f1928d
            int r5 = r5 - r6
            r11.f1926b = r5
        L_0x0184:
            int r5 = r11.f1928d
            int r6 = r12.f1926b
            if (r5 < r6) goto L_0x018f
        L_0x018a:
            int r6 = r12.f1928d
            int r5 = r5 - r6
            r11.f1928d = r5
        L_0x018f:
            r1.set(r3, r12)
            int r5 = r11.f1926b
            int r6 = r11.f1928d
            if (r5 == r6) goto L_0x019c
            r1.set(r7, r11)
            goto L_0x019f
        L_0x019c:
            r1.remove(r7)
        L_0x019f:
            if (r4 == 0) goto L_0x0009
            r1.add(r3, r4)
            goto L_0x0009
        L_0x01a6:
            int r4 = r11.f1928d
            int r6 = r12.f1926b
            if (r4 >= r6) goto L_0x01ae
            r5 = -1
            goto L_0x01af
        L_0x01ae:
            r5 = 0
        L_0x01af:
            int r8 = r11.f1926b
            if (r8 >= r6) goto L_0x01b5
            int r5 = r5 + 1
        L_0x01b5:
            if (r6 > r8) goto L_0x01bc
            int r6 = r12.f1928d
            int r8 = r8 + r6
            r11.f1926b = r8
        L_0x01bc:
            int r6 = r12.f1926b
            if (r6 > r4) goto L_0x01c5
            int r8 = r12.f1928d
            int r4 = r4 + r8
            r11.f1928d = r4
        L_0x01c5:
            int r6 = r6 + r5
            r12.f1926b = r6
            r1.set(r3, r12)
            r1.set(r7, r11)
            goto L_0x0009
        L_0x01d0:
            int r2 = r1.size()
            r3 = 0
        L_0x01d5:
            if (r3 >= r2) goto L_0x02db
            java.lang.Object r11 = r1.get(r3)
            androidx.recyclerview.widget.a r11 = (androidx.recyclerview.widget.a) r11
            int r12 = r11.f1925a
            if (r12 == r4) goto L_0x02ce
            s.f r13 = r0.f1933a
            androidx.recyclerview.widget.e1 r14 = r0.f1936d
            if (r12 == r10) goto L_0x025f
            if (r12 == r9) goto L_0x01f2
            if (r12 == r7) goto L_0x01ec
            goto L_0x01ef
        L_0x01ec:
            r0.i(r11)
        L_0x01ef:
            r7 = 2
            goto L_0x02d2
        L_0x01f2:
            int r12 = r11.f1926b
            int r15 = r11.f1928d
            int r15 = r15 + r12
            r5 = r12
            r7 = 0
        L_0x01f9:
            if (r12 >= r15) goto L_0x0241
            androidx.recyclerview.widget.RecyclerView r10 = r14.f1972a
            androidx.recyclerview.widget.k2 r6 = r10.findViewHolderForPosition(r12, r4)
            if (r6 != 0) goto L_0x0205
        L_0x0203:
            r6 = 0
            goto L_0x0210
        L_0x0205:
            androidx.recyclerview.widget.k r10 = r10.mChildHelper
            android.view.View r9 = r6.itemView
            boolean r9 = r10.j(r9)
            if (r9 == 0) goto L_0x0210
            goto L_0x0203
        L_0x0210:
            if (r6 != 0) goto L_0x022b
            boolean r6 = r0.a(r12)
            if (r6 == 0) goto L_0x0219
            goto L_0x022b
        L_0x0219:
            if (r8 != r4) goto L_0x0228
            java.lang.Object r6 = r11.f1927c
            r9 = 4
            androidx.recyclerview.widget.a r5 = r0.h(r6, r9, r5, r7)
            r0.i(r5)
            r5 = r12
            r7 = 0
            goto L_0x0229
        L_0x0228:
            r9 = 4
        L_0x0229:
            r8 = 0
            goto L_0x023a
        L_0x022b:
            r9 = 4
            if (r8 != 0) goto L_0x0239
            java.lang.Object r6 = r11.f1927c
            androidx.recyclerview.widget.a r5 = r0.h(r6, r9, r5, r7)
            r0.d(r5)
            r5 = r12
            r7 = 0
        L_0x0239:
            r8 = 1
        L_0x023a:
            int r7 = r7 + r4
            int r12 = r12 + 1
            r6 = 0
            r9 = 4
            r10 = 2
            goto L_0x01f9
        L_0x0241:
            int r6 = r11.f1928d
            if (r7 == r6) goto L_0x0253
            java.lang.Object r6 = r11.f1927c
            r9 = 0
            r11.f1927c = r9
            r13.e(r11)
            r9 = 4
            androidx.recyclerview.widget.a r11 = r0.h(r6, r9, r5, r7)
            goto L_0x0254
        L_0x0253:
            r9 = 4
        L_0x0254:
            if (r8 != 0) goto L_0x025a
            r0.d(r11)
            goto L_0x025d
        L_0x025a:
            r0.i(r11)
        L_0x025d:
            r6 = 0
            goto L_0x01ef
        L_0x025f:
            int r5 = r11.f1926b
            int r6 = r11.f1928d
            int r6 = r6 + r5
            r7 = r5
            r8 = 0
            r10 = -1
        L_0x0267:
            if (r7 >= r6) goto L_0x02b2
            androidx.recyclerview.widget.RecyclerView r12 = r14.f1972a
            androidx.recyclerview.widget.k2 r15 = r12.findViewHolderForPosition(r7, r4)
            if (r15 != 0) goto L_0x0273
        L_0x0271:
            r15 = 0
            goto L_0x027e
        L_0x0273:
            androidx.recyclerview.widget.k r12 = r12.mChildHelper
            android.view.View r9 = r15.itemView
            boolean r9 = r12.j(r9)
            if (r9 == 0) goto L_0x027e
            goto L_0x0271
        L_0x027e:
            if (r15 != 0) goto L_0x0297
            boolean r9 = r0.a(r7)
            if (r9 == 0) goto L_0x0287
            goto L_0x0297
        L_0x0287:
            r9 = 0
            r12 = 2
            if (r10 != r4) goto L_0x0294
            androidx.recyclerview.widget.a r10 = r0.h(r9, r12, r5, r8)
            r0.i(r10)
            r10 = 1
            goto L_0x0295
        L_0x0294:
            r10 = 0
        L_0x0295:
            r9 = 0
            goto L_0x02a6
        L_0x0297:
            r9 = 0
            r12 = 2
            if (r10 != 0) goto L_0x02a4
            androidx.recyclerview.widget.a r10 = r0.h(r9, r12, r5, r8)
            r0.d(r10)
            r10 = 1
            goto L_0x02a5
        L_0x02a4:
            r10 = 0
        L_0x02a5:
            r9 = 1
        L_0x02a6:
            if (r10 == 0) goto L_0x02ac
            int r7 = r7 - r8
            int r6 = r6 - r8
            r8 = 1
            goto L_0x02ae
        L_0x02ac:
            int r8 = r8 + 1
        L_0x02ae:
            int r7 = r7 + r4
            r10 = r9
            r9 = 4
            goto L_0x0267
        L_0x02b2:
            int r6 = r11.f1928d
            if (r8 == r6) goto L_0x02c2
            r6 = 0
            r11.f1927c = r6
            r13.e(r11)
            r7 = 2
            androidx.recyclerview.widget.a r11 = r0.h(r6, r7, r5, r8)
            goto L_0x02c4
        L_0x02c2:
            r6 = 0
            r7 = 2
        L_0x02c4:
            if (r10 != 0) goto L_0x02ca
            r0.d(r11)
            goto L_0x02d2
        L_0x02ca:
            r0.i(r11)
            goto L_0x02d2
        L_0x02ce:
            r7 = 2
            r0.i(r11)
        L_0x02d2:
            int r3 = r3 + 1
            r7 = 8
            r8 = -1
            r9 = 4
            r10 = 2
            goto L_0x01d5
        L_0x02db:
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b.j():void");
    }

    public final void k(a aVar) {
        aVar.f1927c = null;
        this.f1933a.e(aVar);
    }

    public final void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            k((a) arrayList.get(i10));
        }
        arrayList.clear();
    }

    public final int m(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        ArrayList arrayList = this.f1935c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            int i18 = aVar.f1925a;
            if (i18 == 8) {
                int i19 = aVar.f1926b;
                int i20 = aVar.f1928d;
                if (i19 < i20) {
                    i14 = i19;
                    i13 = i20;
                } else {
                    i13 = i19;
                    i14 = i20;
                }
                if (i10 < i14 || i10 > i13) {
                    if (i10 < i19) {
                        if (i11 == 1) {
                            aVar.f1926b = i19 + 1;
                            i15 = i20 + 1;
                        } else if (i11 == 2) {
                            aVar.f1926b = i19 - 1;
                            i15 = i20 - 1;
                        }
                        aVar.f1928d = i15;
                    }
                } else if (i14 == i19) {
                    if (i11 == 1) {
                        i17 = i20 + 1;
                    } else {
                        if (i11 == 2) {
                            i17 = i20 - 1;
                        }
                        i10++;
                    }
                    aVar.f1928d = i17;
                    i10++;
                } else {
                    if (i11 == 1) {
                        i16 = i19 + 1;
                    } else {
                        if (i11 == 2) {
                            i16 = i19 - 1;
                        }
                        i10--;
                    }
                    aVar.f1926b = i16;
                    i10--;
                }
            } else {
                int i21 = aVar.f1926b;
                if (i21 > i10) {
                    if (i11 == 1) {
                        i12 = i21 + 1;
                    } else if (i11 == 2) {
                        i12 = i21 - 1;
                    }
                    aVar.f1926b = i12;
                } else if (i18 == 1) {
                    i10 -= aVar.f1928d;
                } else if (i18 == 2) {
                    i10 += aVar.f1928d;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            a aVar2 = (a) arrayList.get(size2);
            if (aVar2.f1925a == 8) {
                int i22 = aVar2.f1928d;
                if (i22 != aVar2.f1926b && i22 >= 0) {
                }
            } else if (aVar2.f1928d > 0) {
            }
            arrayList.remove(size2);
            k(aVar2);
        }
        return i10;
    }
}

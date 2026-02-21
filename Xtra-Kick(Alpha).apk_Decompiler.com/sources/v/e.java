package v;

import android.os.Looper;
import android.os.Message;
import j1.a;
import j1.d;
import j1.d0;
import j1.e0;
import j1.f0;
import j1.n;
import j1.o;
import j1.p;
import j1.q;
import j1.r;
import j1.s;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import u.f;
import u.g;
import u.j;
import u.l;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f15499a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15500b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f15501c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f15502d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f15503e;

    /* renamed from: f  reason: collision with root package name */
    public final AbstractCollection f15504f;

    /* renamed from: g  reason: collision with root package name */
    public final AbstractCollection f15505g;

    /* renamed from: h  reason: collision with root package name */
    public Object f15506h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f15507i;

    public e(Looper looper, d dVar, r rVar) {
        this(new CopyOnWriteArraySet(), looper, dVar, rVar);
    }

    public final void a(Object obj) {
        obj.getClass();
        synchronized (this.f15507i) {
            if (!this.f15499a) {
                ((CopyOnWriteArraySet) this.f15504f).add(new s(obj));
            }
        }
    }

    public final void b(f fVar, int i10, int i11, ArrayList arrayList, m mVar) {
        q qVar = fVar.f15511d;
        if (qVar.f15543c == null) {
            g gVar = (g) this.f15501c;
            if (qVar != gVar.f15086d && qVar != gVar.f15088e) {
                if (mVar == null) {
                    mVar = new m(qVar);
                    arrayList.add(mVar);
                }
                qVar.f15543c = mVar;
                mVar.f15524b.add(qVar);
                f fVar2 = qVar.f15548h;
                Iterator it = fVar2.f15518k.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar instanceof f) {
                        b((f) dVar, i10, 0, arrayList, mVar);
                    }
                }
                f fVar3 = qVar.f15549i;
                Iterator it2 = fVar3.f15518k.iterator();
                while (it2.hasNext()) {
                    d dVar2 = (d) it2.next();
                    if (dVar2 instanceof f) {
                        b((f) dVar2, i10, 1, arrayList, mVar);
                    }
                }
                if (i10 == 1 && (qVar instanceof n)) {
                    Iterator it3 = ((n) qVar).f15525k.f15518k.iterator();
                    while (it3.hasNext()) {
                        d dVar3 = (d) it3.next();
                        if (dVar3 instanceof f) {
                            b((f) dVar3, i10, 2, arrayList, mVar);
                        }
                    }
                }
                Iterator it4 = fVar2.f15519l.iterator();
                while (it4.hasNext()) {
                    b((f) it4.next(), i10, 0, arrayList, mVar);
                }
                Iterator it5 = fVar3.f15519l.iterator();
                while (it5.hasNext()) {
                    b((f) it5.next(), i10, 1, arrayList, mVar);
                }
                if (i10 == 1 && (qVar instanceof n)) {
                    Iterator it6 = ((n) qVar).f15525k.f15519l.iterator();
                    while (it6.hasNext()) {
                        b((f) it6.next(), i10, 2, arrayList, mVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r2.f15116t == 0) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(u.g r17) {
        /*
            r16 = this;
            r0 = r17
            java.util.ArrayList r1 = r0.f15168r0
            java.util.Iterator r1 = r1.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x021c
            java.lang.Object r2 = r1.next()
            u.f r2 = (u.f) r2
            int[] r3 = r2.f15113q0
            r4 = 0
            r5 = r3[r4]
            r9 = 1
            r3 = r3[r9]
            int r6 = r2.f15095h0
            r7 = 8
            if (r6 != r7) goto L_0x0025
        L_0x0022:
            r2.f15080a = r9
            goto L_0x0008
        L_0x0025:
            float r6 = r2.f15120x
            r10 = 1065353216(0x3f800000, float:1.0)
            r7 = 3
            r8 = 2
            int r11 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r11 >= 0) goto L_0x0033
            if (r5 != r7) goto L_0x0033
            r2.f15115s = r8
        L_0x0033:
            float r11 = r2.A
            int r12 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x003d
            if (r3 != r7) goto L_0x003d
            r2.f15116t = r8
        L_0x003d:
            float r12 = r2.X
            r13 = 0
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L_0x0064
            if (r5 != r7) goto L_0x004d
            if (r3 == r8) goto L_0x004a
            if (r3 != r9) goto L_0x004d
        L_0x004a:
            r2.f15115s = r7
            goto L_0x0064
        L_0x004d:
            if (r3 != r7) goto L_0x0054
            if (r5 == r8) goto L_0x0062
            if (r5 != r9) goto L_0x0054
            goto L_0x0062
        L_0x0054:
            if (r5 != r7) goto L_0x0064
            if (r3 != r7) goto L_0x0064
            int r12 = r2.f15115s
            if (r12 != 0) goto L_0x005e
            r2.f15115s = r7
        L_0x005e:
            int r12 = r2.f15116t
            if (r12 != 0) goto L_0x0064
        L_0x0062:
            r2.f15116t = r7
        L_0x0064:
            u.e r12 = r2.L
            u.e r13 = r2.J
            if (r5 != r7) goto L_0x0077
            int r14 = r2.f15115s
            if (r14 != r9) goto L_0x0077
            u.e r14 = r13.f15076f
            if (r14 == 0) goto L_0x0076
            u.e r14 = r12.f15076f
            if (r14 != 0) goto L_0x0077
        L_0x0076:
            r5 = 2
        L_0x0077:
            u.e r14 = r2.M
            u.e r15 = r2.K
            if (r3 != r7) goto L_0x008b
            int r10 = r2.f15116t
            if (r10 != r9) goto L_0x008b
            u.e r10 = r15.f15076f
            if (r10 == 0) goto L_0x0089
            u.e r10 = r14.f15076f
            if (r10 != 0) goto L_0x008b
        L_0x0089:
            r10 = 2
            goto L_0x008c
        L_0x008b:
            r10 = r3
        L_0x008c:
            v.l r3 = r2.f15086d
            r3.f15544d = r5
            int r4 = r2.f15115s
            r3.f15541a = r4
            v.n r3 = r2.f15088e
            r3.f15544d = r10
            int r7 = r2.f15116t
            r3.f15541a = r7
            r3 = 4
            if (r5 == r3) goto L_0x00a3
            if (r5 == r9) goto L_0x00a3
            if (r5 != r8) goto L_0x00ab
        L_0x00a3:
            if (r10 == r3) goto L_0x01d8
            if (r10 == r9) goto L_0x01d8
            if (r10 != r8) goto L_0x00ab
            goto L_0x01d8
        L_0x00ab:
            r12 = 1056964608(0x3f000000, float:0.5)
            int[] r13 = r0.f15113q0
            u.e[] r14 = r2.R
            r15 = 3
            if (r5 != r15) goto L_0x011b
            if (r10 == r8) goto L_0x00b8
            if (r10 != r9) goto L_0x011b
        L_0x00b8:
            if (r4 != r15) goto L_0x00d8
            if (r10 != r8) goto L_0x00c6
            r6 = 0
            r8 = 0
            r7 = 2
            r3 = r16
            r4 = r2
            r5 = r7
            r3.h(r4, r5, r6, r7, r8)
        L_0x00c6:
            int r8 = r2.l()
            float r3 = (float) r8
            float r4 = r2.X
            float r3 = r3 * r4
            float r3 = r3 + r12
            int r6 = (int) r3
            r7 = 1
            r3 = r16
            r4 = r2
            r5 = r7
            goto L_0x0201
        L_0x00d8:
            if (r4 != r9) goto L_0x00ee
            r6 = 0
            r8 = 0
            r5 = 2
            r3 = r16
            r4 = r2
            r7 = r10
            r3.h(r4, r5, r6, r7, r8)
            v.l r3 = r2.f15086d
            v.g r3 = r3.f15545e
            int r2 = r2.q()
            goto L_0x01d4
        L_0x00ee:
            if (r4 != r8) goto L_0x0108
            r15 = 0
            r8 = r13[r15]
            if (r8 == r9) goto L_0x00f7
            if (r8 != r3) goto L_0x011b
        L_0x00f7:
            int r3 = r17.q()
            float r3 = (float) r3
            float r6 = r6 * r3
            float r6 = r6 + r12
            int r3 = (int) r6
            int r4 = r2.l()
            r6 = r3
            r8 = r4
            r7 = r10
            goto L_0x0148
        L_0x0108:
            r8 = 0
            r15 = r14[r8]
            u.e r8 = r15.f15076f
            if (r8 == 0) goto L_0x0115
            r8 = r14[r9]
            u.e r8 = r8.f15076f
            if (r8 != 0) goto L_0x011b
        L_0x0115:
            r7 = r10
            r5 = 2
            r6 = 0
            r8 = 0
            goto L_0x01fe
        L_0x011b:
            r8 = 3
            if (r10 != r8) goto L_0x018a
            r15 = 2
            if (r5 == r15) goto L_0x0123
            if (r5 != r9) goto L_0x018a
        L_0x0123:
            if (r7 != r8) goto L_0x014b
            if (r5 != r15) goto L_0x0131
            r6 = 0
            r8 = 0
            r7 = 2
            r3 = r16
            r4 = r2
            r5 = r7
            r3.h(r4, r5, r6, r7, r8)
        L_0x0131:
            int r3 = r2.q()
            float r4 = r2.X
            int r5 = r2.Y
            r6 = -1
            if (r5 != r6) goto L_0x0140
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r5 / r4
        L_0x0140:
            float r5 = (float) r3
            float r5 = r5 * r4
            float r5 = r5 + r12
            int r4 = (int) r5
            r6 = r3
            r8 = r4
            r7 = 1
        L_0x0148:
            r5 = 1
            goto L_0x01fe
        L_0x014b:
            if (r7 != r9) goto L_0x0158
            r6 = 0
            r8 = 0
            r7 = 2
            r3 = r16
            r4 = r2
            r3.h(r4, r5, r6, r7, r8)
            goto L_0x01cc
        L_0x0158:
            r8 = 2
            if (r7 != r8) goto L_0x0173
            r8 = r13[r9]
            if (r8 == r9) goto L_0x0161
            if (r8 != r3) goto L_0x018a
        L_0x0161:
            int r3 = r2.q()
            int r4 = r17.l()
            float r4 = (float) r4
            float r11 = r11 * r4
            float r11 = r11 + r12
            int r4 = (int) r11
            r6 = r3
            r8 = r4
        L_0x0170:
            r7 = 1
            goto L_0x01fe
        L_0x0173:
            r3 = 2
            r8 = r14[r3]
            u.e r3 = r8.f15076f
            if (r3 == 0) goto L_0x0181
            r3 = 3
            r8 = r14[r3]
            u.e r3 = r8.f15076f
            if (r3 != 0) goto L_0x018a
        L_0x0181:
            r6 = 0
            r8 = 0
            r5 = 2
            r3 = r16
            r4 = r2
            r7 = r10
            goto L_0x0201
        L_0x018a:
            r3 = 3
            if (r5 != r3) goto L_0x0008
            if (r10 != r3) goto L_0x0008
            if (r4 == r9) goto L_0x01b8
            if (r7 != r9) goto L_0x0194
            goto L_0x01b8
        L_0x0194:
            r3 = 2
            if (r7 != r3) goto L_0x0008
            if (r4 != r3) goto L_0x0008
            r3 = 0
            r3 = r13[r3]
            if (r3 != r9) goto L_0x0008
            r3 = r13[r9]
            if (r3 != r9) goto L_0x0008
            int r3 = r17.q()
            float r3 = (float) r3
            float r6 = r6 * r3
            float r6 = r6 + r12
            int r3 = (int) r6
            int r4 = r17.l()
            float r4 = (float) r4
            float r11 = r11 * r4
            float r11 = r11 + r12
            int r4 = (int) r11
            r6 = r3
            r8 = r4
            r5 = 1
            goto L_0x0170
        L_0x01b8:
            r6 = 0
            r8 = 0
            r7 = 2
            r3 = r16
            r4 = r2
            r5 = r7
            r3.h(r4, r5, r6, r7, r8)
            v.l r3 = r2.f15086d
            v.g r3 = r3.f15545e
            int r4 = r2.q()
            r3.f15520m = r4
        L_0x01cc:
            v.n r3 = r2.f15088e
            v.g r3 = r3.f15545e
            int r2 = r2.l()
        L_0x01d4:
            r3.f15520m = r2
            goto L_0x0008
        L_0x01d8:
            int r4 = r2.q()
            if (r5 != r3) goto L_0x01e9
            int r4 = r17.q()
            int r5 = r13.f15077g
            int r4 = r4 - r5
            int r5 = r12.f15077g
            int r4 = r4 - r5
            r5 = 1
        L_0x01e9:
            int r6 = r2.l()
            if (r10 != r3) goto L_0x01fb
            int r3 = r17.l()
            int r6 = r15.f15077g
            int r3 = r3 - r6
            int r6 = r14.f15077g
            int r6 = r3 - r6
            r10 = 1
        L_0x01fb:
            r8 = r6
            r7 = r10
            r6 = r4
        L_0x01fe:
            r3 = r16
            r4 = r2
        L_0x0201:
            r3.h(r4, r5, r6, r7, r8)
            v.l r3 = r2.f15086d
            v.g r3 = r3.f15545e
            int r4 = r2.q()
            r3.d(r4)
            v.n r3 = r2.f15088e
            v.g r3 = r3.f15545e
            int r4 = r2.l()
            r3.d(r4)
            goto L_0x0022
        L_0x021c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.c(u.g):void");
    }

    public final void d() {
        Object obj;
        ArrayList arrayList = (ArrayList) this.f15503e;
        arrayList.clear();
        g gVar = (g) this.f15502d;
        gVar.f15086d.f();
        gVar.f15088e.f();
        arrayList.add(gVar.f15086d);
        arrayList.add(gVar.f15088e);
        Iterator it = gVar.f15168r0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar instanceof j) {
                obj = new j(fVar);
            } else {
                if (fVar.x()) {
                    if (fVar.f15082b == null) {
                        fVar.f15082b = new c(0, fVar);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(fVar.f15082b);
                } else {
                    arrayList.add(fVar.f15086d);
                }
                if (fVar.y()) {
                    if (fVar.f15084c == null) {
                        fVar.f15084c = new c(1, fVar);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(fVar.f15084c);
                } else {
                    arrayList.add(fVar.f15088e);
                }
                if (fVar instanceof l) {
                    obj = new k(fVar);
                }
            }
            arrayList.add(obj);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((q) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            q qVar = (q) it3.next();
            if (qVar.f15542b != gVar) {
                qVar.d();
            }
        }
        ArrayList arrayList2 = (ArrayList) this.f15505g;
        arrayList2.clear();
        g gVar2 = (g) this.f15501c;
        f(gVar2.f15086d, 0, arrayList2);
        f(gVar2.f15088e, 1, arrayList2);
        this.f15499a = false;
    }

    public final int e(g gVar, int i10) {
        int i11;
        ArrayList arrayList;
        long j10;
        q qVar;
        q qVar2;
        long j11;
        long j12;
        float f10;
        long j13;
        g gVar2 = gVar;
        int i12 = i10;
        ArrayList arrayList2 = (ArrayList) this.f15505g;
        int size = arrayList2.size();
        int i13 = 0;
        long j14 = 0;
        while (i13 < size) {
            q qVar3 = ((m) arrayList2.get(i13)).f15523a;
            if (!(qVar3 instanceof c) ? i12 != 0 ? (qVar3 instanceof n) : (qVar3 instanceof l) : ((c) qVar3).f15546f == i12) {
                if (i12 == 0) {
                    qVar = gVar2.f15086d;
                } else {
                    qVar = gVar2.f15088e;
                }
                f fVar = qVar.f15548h;
                if (i12 == 0) {
                    qVar2 = gVar2.f15086d;
                } else {
                    qVar2 = gVar2.f15088e;
                }
                f fVar2 = qVar2.f15549i;
                boolean contains = qVar3.f15548h.f15519l.contains(fVar);
                f fVar3 = qVar3.f15549i;
                boolean contains2 = fVar3.f15519l.contains(fVar2);
                long j15 = qVar3.j();
                f fVar4 = qVar3.f15548h;
                if (!contains || !contains2) {
                    arrayList = arrayList2;
                    i11 = size;
                    if (contains) {
                        j12 = m.b(fVar4, (long) fVar4.f15513f);
                        j11 = ((long) fVar4.f15513f) + j15;
                    } else if (contains2) {
                        long a10 = m.a(fVar3, (long) fVar3.f15513f);
                        j11 = ((long) (-fVar3.f15513f)) + j15;
                        j12 = -a10;
                    } else {
                        j10 = (qVar3.j() + ((long) fVar4.f15513f)) - ((long) fVar3.f15513f);
                    }
                    j10 = Math.max(j12, j11);
                } else {
                    long b10 = m.b(fVar4, 0);
                    long a11 = m.a(fVar3, 0);
                    long j16 = b10 - j15;
                    int i14 = fVar3.f15513f;
                    arrayList = arrayList2;
                    i11 = size;
                    if (j16 >= ((long) (-i14))) {
                        j16 += (long) i14;
                    }
                    long j17 = j16;
                    long j18 = (long) fVar4.f15513f;
                    long j19 = ((-a11) - j15) - j18;
                    if (j19 >= j18) {
                        j19 -= j18;
                    }
                    f fVar5 = qVar3.f15542b;
                    if (i12 == 0) {
                        f10 = fVar5.f15089e0;
                    } else if (i12 == 1) {
                        f10 = fVar5.f15091f0;
                    } else {
                        fVar5.getClass();
                        f10 = -1.0f;
                    }
                    if (f10 > 0.0f) {
                        j13 = (long) ((((float) j17) / (1.0f - f10)) + (((float) j19) / f10));
                    } else {
                        j13 = 0;
                    }
                    float f11 = (float) j13;
                    j10 = (((long) fVar4.f15513f) + ((((long) ((f11 * f10) + 0.5f)) + j15) + ((long) q0.f.f(1.0f, f10, f11, 0.5f)))) - ((long) fVar3.f15513f);
                }
            } else {
                j10 = 0;
                arrayList = arrayList2;
                i11 = size;
            }
            j14 = Math.max(j14, j10);
            i13++;
            gVar2 = gVar;
            i12 = i10;
            arrayList2 = arrayList;
            size = i11;
        }
        return (int) j14;
    }

    public final void f(q qVar, int i10, ArrayList arrayList) {
        f fVar;
        f fVar2;
        f fVar3;
        Iterator it = qVar.f15548h.f15518k.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            fVar = qVar.f15549i;
            if (!hasNext) {
                break;
            }
            d dVar = (d) it.next();
            if (dVar instanceof f) {
                fVar3 = (f) dVar;
            } else if (dVar instanceof q) {
                fVar3 = ((q) dVar).f15548h;
            }
            b(fVar3, i10, 0, arrayList, (m) null);
        }
        Iterator it2 = fVar.f15518k.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2 instanceof f) {
                fVar2 = (f) dVar2;
            } else if (dVar2 instanceof q) {
                fVar2 = ((q) dVar2).f15549i;
            }
            b(fVar2, i10, 1, arrayList, (m) null);
        }
        if (i10 == 1) {
            Iterator it3 = ((n) qVar).f15525k.f15518k.iterator();
            while (it3.hasNext()) {
                d dVar3 = (d) it3.next();
                if (dVar3 instanceof f) {
                    b((f) dVar3, i10, 2, arrayList, (m) null);
                }
            }
        }
    }

    public final void g() {
        n();
        if (!((ArrayDeque) this.f15506h).isEmpty()) {
            f0 f0Var = (f0) ((n) this.f15502d);
            if (!f0Var.f8429a.hasMessages(0)) {
                f0Var.getClass();
                e0 b10 = f0.b();
                b10.f8423a = f0Var.f8429a.obtainMessage(0);
                f0Var.getClass();
                Message message = b10.f8423a;
                message.getClass();
                f0Var.f8429a.sendMessageAtFrontOfQueue(message);
                b10.f8423a = null;
                ArrayList arrayList = f0.f8428b;
                synchronized (arrayList) {
                    if (arrayList.size() < 50) {
                        arrayList.add(b10);
                    }
                }
            }
            ArrayDeque arrayDeque = (ArrayDeque) this.f15505g;
            boolean z10 = !arrayDeque.isEmpty();
            arrayDeque.addAll((ArrayDeque) this.f15506h);
            ((ArrayDeque) this.f15506h).clear();
            if (!z10) {
                while (!arrayDeque.isEmpty()) {
                    ((Runnable) arrayDeque.peekFirst()).run();
                    arrayDeque.removeFirst();
                }
            }
        }
    }

    public final void h(f fVar, int i10, int i11, int i12, int i13) {
        boolean z10;
        b bVar = (b) this.f15507i;
        bVar.f15487a = i10;
        bVar.f15488b = i12;
        bVar.f15489c = i11;
        bVar.f15490d = i13;
        ((o) this.f15506h).b(fVar, bVar);
        fVar.N(bVar.f15491e);
        fVar.K(bVar.f15492f);
        fVar.F = bVar.f15494h;
        int i14 = bVar.f15493g;
        fVar.f15083b0 = i14;
        if (i14 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        fVar.F = z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r10 == 3) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r8 == 3) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        r2.d(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f15501c
            u.g r0 = (u.g) r0
            java.util.ArrayList r0 = r0.f15168r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r0.next()
            u.f r1 = (u.f) r1
            boolean r2 = r1.f15080a
            if (r2 == 0) goto L_0x001b
            goto L_0x000a
        L_0x001b:
            int[] r2 = r1.f15113q0
            r3 = 0
            r8 = r2[r3]
            r9 = 1
            r10 = r2[r9]
            int r2 = r1.f15115s
            int r4 = r1.f15116t
            r5 = 2
            r11 = 3
            if (r8 == r5) goto L_0x0032
            if (r8 != r11) goto L_0x0030
            if (r2 != r9) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r2 = 0
            goto L_0x0033
        L_0x0032:
            r2 = 1
        L_0x0033:
            if (r10 == r5) goto L_0x0039
            if (r10 != r11) goto L_0x003a
            if (r4 != r9) goto L_0x003a
        L_0x0039:
            r3 = 1
        L_0x003a:
            v.l r4 = r1.f15086d
            v.g r4 = r4.f15545e
            boolean r5 = r4.f15517j
            v.n r6 = r1.f15088e
            v.g r6 = r6.f15545e
            boolean r7 = r6.f15517j
            r12 = 1
            if (r5 == 0) goto L_0x0057
            if (r7 == 0) goto L_0x0057
            int r5 = r4.f15514g
            int r7 = r6.f15514g
            r6 = 1
            r2 = r13
            r3 = r1
            r4 = r6
            r2.h(r3, r4, r5, r6, r7)
            goto L_0x0090
        L_0x0057:
            if (r5 == 0) goto L_0x0071
            if (r3 == 0) goto L_0x0071
            int r5 = r4.f15514g
            int r7 = r6.f15514g
            r4 = 1
            r6 = 2
            r2 = r13
            r3 = r1
            r2.h(r3, r4, r5, r6, r7)
            v.n r2 = r1.f15088e
            v.g r2 = r2.f15545e
            int r3 = r1.l()
            if (r10 != r11) goto L_0x008d
            goto L_0x008a
        L_0x0071:
            if (r7 == 0) goto L_0x0092
            if (r2 == 0) goto L_0x0092
            int r5 = r4.f15514g
            int r7 = r6.f15514g
            r4 = 2
            r2 = r13
            r3 = r1
            r6 = r12
            r2.h(r3, r4, r5, r6, r7)
            v.l r2 = r1.f15086d
            v.g r2 = r2.f15545e
            int r3 = r1.q()
            if (r8 != r11) goto L_0x008d
        L_0x008a:
            r2.f15520m = r3
            goto L_0x0092
        L_0x008d:
            r2.d(r3)
        L_0x0090:
            r1.f15080a = r9
        L_0x0092:
            boolean r2 = r1.f15080a
            if (r2 == 0) goto L_0x000a
            v.n r2 = r1.f15088e
            v.a r2 = r2.f15526l
            if (r2 == 0) goto L_0x000a
            int r1 = r1.f15083b0
            r2.d(r1)
            goto L_0x000a
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.i():void");
    }

    public final void j(int i10, q qVar) {
        n();
        ((ArrayDeque) this.f15506h).add(new p((Object) new CopyOnWriteArraySet((CopyOnWriteArraySet) this.f15504f), i10, (Object) qVar, 0));
    }

    public final void k() {
        n();
        synchronized (this.f15507i) {
            this.f15499a = true;
        }
        Iterator it = ((CopyOnWriteArraySet) this.f15504f).iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            r rVar = (r) this.f15503e;
            sVar.f8475d = true;
            if (sVar.f8474c) {
                sVar.f8474c = false;
                rVar.c(sVar.f8472a, sVar.f8473b.c());
            }
        }
        ((CopyOnWriteArraySet) this.f15504f).clear();
    }

    public final void l(Object obj) {
        n();
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.f15504f;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.f8472a.equals(obj)) {
                r rVar = (r) this.f15503e;
                sVar.f8475d = true;
                if (sVar.f8474c) {
                    sVar.f8474c = false;
                    rVar.c(sVar.f8472a, sVar.f8473b.c());
                }
                copyOnWriteArraySet.remove(sVar);
            }
        }
    }

    public final void m(int i10, q qVar) {
        j(i10, qVar);
        g();
    }

    public final void n() {
        boolean z10;
        if (this.f15500b) {
            if (Thread.currentThread() == ((f0) ((n) this.f15502d)).f8429a.getLooper().getThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            a.e(z10);
        }
    }

    public e(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, d dVar, r rVar) {
        this.f15501c = dVar;
        this.f15504f = copyOnWriteArraySet;
        this.f15503e = rVar;
        this.f15507i = new Object();
        this.f15505g = new ArrayDeque();
        this.f15506h = new ArrayDeque();
        this.f15502d = ((d0) dVar).a(looper, new o(0, this));
        this.f15500b = true;
    }

    public e(g gVar) {
        this.f15499a = true;
        this.f15500b = true;
        this.f15503e = new ArrayList();
        this.f15504f = new ArrayList();
        this.f15506h = null;
        this.f15507i = new b();
        this.f15505g = new ArrayList();
        this.f15501c = gVar;
        this.f15502d = gVar;
    }
}

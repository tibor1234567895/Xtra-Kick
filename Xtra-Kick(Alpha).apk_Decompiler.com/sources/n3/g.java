package n3;

import android.support.v4.media.h;
import androidx.fragment.app.p0;
import androidx.lifecycle.p1;
import hb.d0;
import java.util.concurrent.CopyOnWriteArrayList;
import jb.a;
import kb.s0;
import kb.t0;
import xa.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final h f11164a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f11165b;

    /* renamed from: c  reason: collision with root package name */
    public n3 f11166c = n3.f11354f;

    /* renamed from: d  reason: collision with root package name */
    public v5 f11167d;

    /* renamed from: e  reason: collision with root package name */
    public final g1 f11168e;

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArrayList f11169f;

    /* renamed from: g  reason: collision with root package name */
    public final s5 f11170g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f11171h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f11172i;

    /* renamed from: j  reason: collision with root package name */
    public final b4 f11173j;

    /* renamed from: k  reason: collision with root package name */
    public final p0 f11174k;

    /* renamed from: l  reason: collision with root package name */
    public final s0 f11175l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ i f11176m;

    public g(i iVar, h hVar, d0 d0Var) {
        this.f11176m = iVar;
        this.f11164a = hVar;
        this.f11165b = d0Var;
        n3.f11353e.getClass();
        g1 g1Var = new g1();
        this.f11168e = g1Var;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f11169f = copyOnWriteArrayList;
        this.f11170g = new s5(true);
        this.f11173j = new b4(this);
        this.f11174k = g1Var.f11188i;
        this.f11175l = t0.a(0, 64, a.DROP_OLDEST);
        copyOnWriteArrayList.add(new p1(4, this));
    }

    public final void a(c1 c1Var, c1 c1Var2) {
        j.f("source", c1Var);
        g1 g1Var = this.f11168e;
        if (!j.a(g1Var.f11185f, c1Var) || !j.a(g1Var.f11186g, c1Var2)) {
            g1Var.f11180a = true;
            g1Var.f11185f = c1Var;
            g1Var.f11186g = c1Var2;
            g1Var.b();
        }
    }

    public final Object b(int i10) {
        this.f11171h = true;
        this.f11172i = i10;
        v5 v5Var = this.f11167d;
        if (v5Var != null) {
            v5Var.b(this.f11166c.a(i10));
        }
        n3 n3Var = this.f11166c;
        if (i10 < 0) {
            n3Var.getClass();
        } else if (i10 < n3Var.f()) {
            int i11 = i10 - n3Var.f11357c;
            if (i11 < 0 || i11 >= n3Var.f11356b) {
                return null;
            }
            return n3Var.c(i11);
        }
        StringBuilder r10 = h.r("Index: ", i10, ", Size: ");
        r10.append(n3Var.f());
        throw new IndexOutOfBoundsException(r10.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(n3.n3 r17, n3.n3 r18, int r19, n3.y3 r20, pa.e r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r21
            boolean r4 = r3 instanceof n3.e
            if (r4 == 0) goto L_0x001b
            r4 = r3
            n3.e r4 = (n3.e) r4
            int r5 = r4.f11118o
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.f11118o = r5
            goto L_0x0020
        L_0x001b:
            n3.e r4 = new n3.e
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.f11116m
            qa.a r5 = qa.a.COROUTINE_SUSPENDED
            int r6 = r4.f11118o
            r7 = 0
            r8 = 1
            if (r6 == 0) goto L_0x0046
            if (r6 != r8) goto L_0x003e
            int r1 = r4.f11115l
            wa.a r2 = r4.f11114k
            n3.n3 r5 = r4.f11113j
            n3.n3 r6 = r4.f11112i
            n3.g r4 = r4.f11111h
            hb.h0.O1(r3)
            r9 = r1
            r1 = r6
            r6 = r2
            r2 = r5
            goto L_0x00a9
        L_0x003e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0046:
            hb.h0.O1(r3)
            int r3 = r17.f()
            r6 = 0
            n3.i r9 = r0.f11176m
            if (r3 != 0) goto L_0x006b
            r20.b()
            n3.h r1 = r9.f11238d
            int r2 = r18.f()
            if (r2 <= 0) goto L_0x0066
            n3.i r1 = r1.f11214a
            androidx.recyclerview.widget.x0 r1 = r1.f11236b
            r1.c(r7, r2)
            goto L_0x024a
        L_0x0066:
            r1.getClass()
            goto L_0x024a
        L_0x006b:
            int r3 = r18.f()
            if (r3 != 0) goto L_0x008a
            r20.b()
            n3.h r2 = r9.f11238d
            int r1 = r17.f()
            if (r1 <= 0) goto L_0x0085
            n3.i r2 = r2.f11214a
            androidx.recyclerview.widget.x0 r2 = r2.f11236b
            r2.a(r7, r1)
            goto L_0x024a
        L_0x0085:
            r2.getClass()
            goto L_0x024a
        L_0x008a:
            hb.d0 r3 = r9.f11237c
            n3.f r10 = new n3.f
            r10.<init>(r1, r2, r9, r6)
            r4.f11111h = r0
            r4.f11112i = r1
            r4.f11113j = r2
            r6 = r20
            r4.f11114k = r6
            r9 = r19
            r4.f11115l = r9
            r4.f11118o = r8
            java.lang.Object r3 = hb.h0.c2(r3, r10, r4)
            if (r3 != r5) goto L_0x00a8
            return r5
        L_0x00a8:
            r4 = r0
        L_0x00a9:
            n3.i1 r3 = (n3.i1) r3
            r6.b()
            n3.i r4 = r4.f11176m
            androidx.recyclerview.widget.x0 r4 = r4.f11236b
            java.lang.String r5 = "<this>"
            xa.j.f(r5, r1)
            java.lang.String r5 = "callback"
            xa.j.f(r5, r4)
            java.lang.String r5 = "newList"
            xa.j.f(r5, r2)
            java.lang.String r5 = "diffResult"
            xa.j.f(r5, r3)
            androidx.recyclerview.widget.v r5 = r3.f11248a
            boolean r3 = r3.f11249b
            if (r3 == 0) goto L_0x013d
            n3.n1 r6 = n3.n1.f11349a
            r6.getClass()
            n3.m1 r6 = new n3.m1
            r6.<init>(r1, r2, r4)
            r5.b(r6)
            int r10 = r1.f11357c
            int r11 = r6.f11329c
            int r10 = java.lang.Math.min(r10, r11)
            int r11 = r2.f11357c
            int r12 = r6.f11329c
            int r11 = r11 - r12
            n3.c0 r12 = n3.c0.PLACEHOLDER_POSITION_CHANGE
            if (r11 <= 0) goto L_0x00f3
            if (r10 <= 0) goto L_0x00ef
            r4.d(r7, r10, r12)
        L_0x00ef:
            r4.c(r7, r11)
            goto L_0x00ff
        L_0x00f3:
            if (r11 >= 0) goto L_0x00ff
            int r13 = -r11
            r4.a(r7, r13)
            int r10 = r10 + r11
            if (r10 <= 0) goto L_0x00ff
            r4.d(r7, r10, r12)
        L_0x00ff:
            int r10 = r2.f11357c
            r6.f11329c = r10
            int r10 = r1.f11358d
            int r11 = r6.f11330d
            int r10 = java.lang.Math.min(r10, r11)
            int r11 = r2.f11358d
            int r13 = r6.f11330d
            int r11 = r11 - r13
            int r14 = r6.f11329c
            int r15 = r6.f11331e
            int r14 = r14 + r15
            int r14 = r14 + r13
            int r13 = r14 - r10
            int r15 = r1.f()
            int r15 = r15 - r10
            if (r13 == r15) goto L_0x0121
            r15 = 1
            goto L_0x0122
        L_0x0121:
            r15 = 0
        L_0x0122:
            if (r11 <= 0) goto L_0x0128
            r4.c(r14, r11)
            goto L_0x0130
        L_0x0128:
            if (r11 >= 0) goto L_0x0130
            int r14 = r14 + r11
            int r7 = -r11
            r4.a(r14, r7)
            int r10 = r10 + r11
        L_0x0130:
            if (r10 <= 0) goto L_0x0137
            if (r15 == 0) goto L_0x0137
            r4.d(r13, r10, r12)
        L_0x0137:
            int r4 = r2.f11358d
            r6.f11330d = r4
            goto L_0x01cf
        L_0x013d:
            n3.d0 r6 = n3.d0.f11100a
            r6.getClass()
            int r6 = r1.f11357c
            int r7 = r2.f11357c
            int r6 = java.lang.Math.max(r6, r7)
            int r7 = r1.f11357c
            int r10 = r1.f11356b
            int r7 = r7 + r10
            int r10 = r2.f11357c
            int r11 = r2.f11356b
            int r10 = r10 + r11
            int r7 = java.lang.Math.min(r7, r10)
            int r10 = r7 - r6
            if (r10 <= 0) goto L_0x0162
            r4.a(r6, r10)
            r4.c(r6, r10)
        L_0x0162:
            int r10 = java.lang.Math.min(r6, r7)
            int r6 = java.lang.Math.max(r6, r7)
            int r7 = r1.f11357c
            int r11 = r2.f()
            if (r7 <= r11) goto L_0x0173
            r7 = r11
        L_0x0173:
            int r11 = r1.f11357c
            int r12 = r1.f11356b
            int r11 = r11 + r12
            int r12 = r2.f()
            if (r11 <= r12) goto L_0x017f
            r11 = r12
        L_0x017f:
            n3.c0 r12 = n3.c0.ITEM_TO_PLACEHOLDER
            int r13 = r10 - r7
            if (r13 <= 0) goto L_0x0188
            r4.d(r7, r13, r12)
        L_0x0188:
            int r11 = r11 - r6
            if (r11 <= 0) goto L_0x018e
            r4.d(r6, r11, r12)
        L_0x018e:
            int r7 = r2.f11357c
            int r11 = r1.f()
            if (r7 <= r11) goto L_0x0197
            r7 = r11
        L_0x0197:
            int r11 = r2.f11357c
            int r12 = r2.f11356b
            int r11 = r11 + r12
            int r12 = r1.f()
            if (r11 <= r12) goto L_0x01a3
            r11 = r12
        L_0x01a3:
            n3.c0 r12 = n3.c0.PLACEHOLDER_TO_ITEM
            int r10 = r10 - r7
            if (r10 <= 0) goto L_0x01ab
            r4.d(r7, r10, r12)
        L_0x01ab:
            int r11 = r11 - r6
            if (r11 <= 0) goto L_0x01b1
            r4.d(r6, r11, r12)
        L_0x01b1:
            int r6 = r2.f()
            int r7 = r1.f()
            int r6 = r6 - r7
            if (r6 <= 0) goto L_0x01c4
            int r7 = r1.f()
            r4.c(r7, r6)
            goto L_0x01cf
        L_0x01c4:
            if (r6 >= 0) goto L_0x01cf
            int r7 = r1.f()
            int r7 = r7 + r6
            int r6 = -r6
            r4.a(r7, r6)
        L_0x01cf:
            if (r3 != 0) goto L_0x01d2
            goto L_0x0209
        L_0x01d2:
            int r3 = r1.f11357c
            int r3 = r9 - r3
            int r4 = r1.f11356b
            if (r3 < 0) goto L_0x01de
            if (r3 >= r4) goto L_0x01de
            r4 = 1
            goto L_0x01df
        L_0x01de:
            r4 = 0
        L_0x01df:
            if (r4 == 0) goto L_0x0209
            r4 = 0
        L_0x01e2:
            int r6 = r4 + 1
            int r7 = r4 / 2
            int r4 = r4 % 2
            r10 = -1
            if (r4 != r8) goto L_0x01ed
            r4 = -1
            goto L_0x01ee
        L_0x01ed:
            r4 = 1
        L_0x01ee:
            int r7 = r7 * r4
            int r7 = r7 + r3
            if (r7 < 0) goto L_0x0202
            int r4 = r1.f11356b
            if (r7 < r4) goto L_0x01f8
            goto L_0x0202
        L_0x01f8:
            int r4 = r5.a(r7)
            if (r4 == r10) goto L_0x0202
            int r1 = r2.f11357c
            int r4 = r4 + r1
            goto L_0x0245
        L_0x0202:
            r4 = 29
            if (r6 <= r4) goto L_0x0207
            goto L_0x0209
        L_0x0207:
            r4 = r6
            goto L_0x01e2
        L_0x0209:
            int r1 = r2.f()
            r2 = 0
            cb.e r1 = cb.l.c(r2, r1)
            java.lang.String r2 = "range"
            xa.j.f(r2, r1)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x024b
            java.lang.Comparable r2 = r1.d()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r9 >= r2) goto L_0x022e
            java.lang.Comparable r1 = r1.d()
            goto L_0x023e
        L_0x022e:
            java.lang.Comparable r2 = r1.c()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r9 <= r2) goto L_0x0244
            java.lang.Comparable r1 = r1.c()
        L_0x023e:
            java.lang.Number r1 = (java.lang.Number) r1
            int r9 = r1.intValue()
        L_0x0244:
            r4 = r9
        L_0x0245:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r4)
        L_0x024a:
            return r6
        L_0x024b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Cannot coerce value to an empty range: "
            r3.<init>(r4)
            r3.append(r1)
            r1 = 46
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.g.c(n3.n3, n3.n3, int, n3.y3, pa.e):java.lang.Object");
    }
}

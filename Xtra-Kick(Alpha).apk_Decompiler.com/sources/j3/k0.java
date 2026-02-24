package j3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.util.Log;
import androidx.fragment.app.q0;
import androidx.lifecycle.d0;
import androidx.lifecycle.g2;
import androidx.lifecycle.p1;
import androidx.lifecycle.s;
import eb.m;
import eb.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import jb.a;
import kb.e1;
import kb.f1;
import kb.n0;
import kb.s0;
import kb.t0;
import la.f;
import la.o;
import ma.b0;
import ma.l;
import ma.w;
import ma.z;
import xa.j;
import xa.q;
import xa.y;

public abstract class k0 {
    public static final boolean D = true;
    public final ArrayList A;
    public final o B;
    public final s0 C;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8576a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f8577b;

    /* renamed from: c  reason: collision with root package name */
    public h1 f8578c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f8579d;

    /* renamed from: e  reason: collision with root package name */
    public Parcelable[] f8580e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8581f;

    /* renamed from: g  reason: collision with root package name */
    public final l f8582g;

    /* renamed from: h  reason: collision with root package name */
    public final e1 f8583h;

    /* renamed from: i  reason: collision with root package name */
    public final e1 f8584i;

    /* renamed from: j  reason: collision with root package name */
    public final LinkedHashMap f8585j;

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashMap f8586k;

    /* renamed from: l  reason: collision with root package name */
    public final LinkedHashMap f8587l;

    /* renamed from: m  reason: collision with root package name */
    public final LinkedHashMap f8588m;

    /* renamed from: n  reason: collision with root package name */
    public d0 f8589n;

    /* renamed from: o  reason: collision with root package name */
    public n0 f8590o;

    /* renamed from: p  reason: collision with root package name */
    public final CopyOnWriteArrayList f8591p;

    /* renamed from: q  reason: collision with root package name */
    public s f8592q;

    /* renamed from: r  reason: collision with root package name */
    public final v f8593r;

    /* renamed from: s  reason: collision with root package name */
    public final q0 f8594s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f8595t;

    /* renamed from: u  reason: collision with root package name */
    public final q2 f8596u;

    /* renamed from: v  reason: collision with root package name */
    public final LinkedHashMap f8597v;

    /* renamed from: w  reason: collision with root package name */
    public wa.l f8598w;

    /* renamed from: x  reason: collision with root package name */
    public wa.l f8599x;

    /* renamed from: y  reason: collision with root package name */
    public final LinkedHashMap f8600y;

    /* renamed from: z  reason: collision with root package name */
    public int f8601z;

    static {
        new w(0);
    }

    public k0(Context context) {
        Object obj;
        this.f8576a = context;
        Iterator it = m.b(context, z.f8726h).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.f8577b = (Activity) obj;
        this.f8582g = new l();
        b0 b0Var = b0.f10801h;
        this.f8583h = f1.a(b0Var);
        this.f8584i = f1.a(b0Var);
        this.f8585j = new LinkedHashMap();
        this.f8586k = new LinkedHashMap();
        this.f8587l = new LinkedHashMap();
        this.f8588m = new LinkedHashMap();
        this.f8591p = new CopyOnWriteArrayList();
        this.f8592q = s.INITIALIZED;
        this.f8593r = new v(0, this);
        this.f8594s = new q0(this);
        this.f8595t = true;
        q2 q2Var = new q2();
        this.f8596u = q2Var;
        this.f8597v = new LinkedHashMap();
        this.f8600y = new LinkedHashMap();
        q2Var.a(new i1(q2Var));
        q2Var.a(new e(this.f8576a));
        this.A = new ArrayList();
        this.B = f.b(new p1(1, this));
        this.C = t0.a(1, 0, a.DROP_OLDEST);
    }

    public static c1 d(c1 c1Var, int i10) {
        h1 h1Var;
        if (c1Var.f8513o == i10) {
            return c1Var;
        }
        if (c1Var instanceof h1) {
            h1Var = (h1) c1Var;
        } else {
            h1Var = c1Var.f8507i;
            j.c(h1Var);
        }
        return h1Var.i(i10, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v53, resolved type: j3.h1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0014 A[LOOP:0: B:2:0x0014->B:7:0x0034, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(j3.c1 r24, android.os.Bundle r25, j3.r r26, java.util.List r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            j3.c1 r11 = r9.f8661i
            boolean r2 = r11 instanceof j3.g
            r3 = 0
            r12 = 1
            ma.l r13 = r0.f8582g
            if (r2 != 0) goto L_0x0036
        L_0x0014:
            boolean r2 = r13.isEmpty()
            if (r2 != 0) goto L_0x0036
            java.lang.Object r2 = r13.last()
            j3.r r2 = (j3.r) r2
            j3.c1 r2 = r2.f8661i
            boolean r2 = r2 instanceof j3.g
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r13.last()
            j3.r r2 = (j3.r) r2
            j3.c1 r2 = r2.f8661i
            int r2 = r2.f8513o
            boolean r2 = r0.n(r2, r12, r3)
            if (r2 != 0) goto L_0x0014
        L_0x0036:
            ma.l r14 = new ma.l
            r14.<init>()
            boolean r2 = r1 instanceof j3.h1
            if (r2 == 0) goto L_0x00a8
            r2 = r11
        L_0x0040:
            xa.j.c(r2)
            j3.h1 r7 = r2.f8507i
            if (r7 == 0) goto L_0x00a0
            int r2 = r27.size()
            java.util.ListIterator r2 = r10.listIterator(r2)
        L_0x004f:
            boolean r3 = r2.hasPrevious()
            if (r3 == 0) goto L_0x0065
            java.lang.Object r3 = r2.previous()
            r4 = r3
            j3.r r4 = (j3.r) r4
            j3.c1 r4 = r4.f8661i
            boolean r4 = xa.j.a(r4, r7)
            if (r4 == 0) goto L_0x004f
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            j3.r r3 = (j3.r) r3
            if (r3 != 0) goto L_0x0081
            j3.n r2 = j3.r.f8659t
            android.content.Context r3 = r0.f8576a
            androidx.lifecycle.s r6 = r23.i()
            j3.n0 r5 = r0.f8590o
            r4 = r7
            r16 = r5
            r5 = r25
            r15 = r7
            r7 = r16
            j3.r r3 = j3.n.b(r2, r3, r4, r5, r6, r7)
            goto L_0x0082
        L_0x0081:
            r15 = r7
        L_0x0082:
            r14.c(r3)
            boolean r2 = r13.isEmpty()
            r2 = r2 ^ r12
            if (r2 == 0) goto L_0x00a1
            java.lang.Object r2 = r13.last()
            j3.r r2 = (j3.r) r2
            j3.c1 r2 = r2.f8661i
            if (r2 != r15) goto L_0x00a1
            java.lang.Object r2 = r13.last()
            j3.r r2 = (j3.r) r2
            r0.o(r2, false, new ma.l())
            goto L_0x00a1
        L_0x00a0:
            r15 = r7
        L_0x00a1:
            if (r15 == 0) goto L_0x00a8
            if (r15 != r1) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r2 = r15
            goto L_0x0040
        L_0x00a8:
            boolean r2 = r14.isEmpty()
            if (r2 == 0) goto L_0x00b0
            r2 = r11
            goto L_0x00b8
        L_0x00b0:
            java.lang.Object r2 = r14.first()
            j3.r r2 = (j3.r) r2
            j3.c1 r2 = r2.f8661i
        L_0x00b8:
            if (r2 == 0) goto L_0x0115
            int r3 = r2.f8513o
            j3.c1 r3 = r0.c(r3)
            if (r3 == r2) goto L_0x0115
            j3.h1 r2 = r2.f8507i
            if (r2 == 0) goto L_0x00b8
            if (r8 == 0) goto L_0x00d0
            boolean r3 = r25.isEmpty()
            if (r3 != r12) goto L_0x00d0
            r3 = 1
            goto L_0x00d1
        L_0x00d0:
            r3 = 0
        L_0x00d1:
            if (r3 == 0) goto L_0x00d5
            r3 = 0
            goto L_0x00d6
        L_0x00d5:
            r3 = r8
        L_0x00d6:
            int r4 = r27.size()
            java.util.ListIterator r4 = r10.listIterator(r4)
        L_0x00de:
            boolean r5 = r4.hasPrevious()
            if (r5 == 0) goto L_0x00f4
            java.lang.Object r5 = r4.previous()
            r6 = r5
            j3.r r6 = (j3.r) r6
            j3.c1 r6 = r6.f8661i
            boolean r6 = xa.j.a(r6, r2)
            if (r6 == 0) goto L_0x00de
            goto L_0x00f5
        L_0x00f4:
            r5 = 0
        L_0x00f5:
            j3.r r5 = (j3.r) r5
            if (r5 != 0) goto L_0x0111
            j3.n r17 = j3.r.f8659t
            android.content.Context r4 = r0.f8576a
            android.os.Bundle r20 = r2.b(r3)
            androidx.lifecycle.s r21 = r23.i()
            j3.n0 r3 = r0.f8590o
            r18 = r4
            r19 = r2
            r22 = r3
            j3.r r5 = j3.n.b(r17, r18, r19, r20, r21, r22)
        L_0x0111:
            r14.c(r5)
            goto L_0x00b8
        L_0x0115:
            boolean r2 = r14.isEmpty()
            if (r2 == 0) goto L_0x011c
            goto L_0x0124
        L_0x011c:
            java.lang.Object r2 = r14.first()
            j3.r r2 = (j3.r) r2
            j3.c1 r11 = r2.f8661i
        L_0x0124:
            boolean r2 = r13.isEmpty()
            if (r2 != 0) goto L_0x0158
            java.lang.Object r2 = r13.last()
            j3.r r2 = (j3.r) r2
            j3.c1 r2 = r2.f8661i
            boolean r2 = r2 instanceof j3.h1
            if (r2 == 0) goto L_0x0158
            java.lang.Object r2 = r13.last()
            j3.r r2 = (j3.r) r2
            j3.c1 r2 = r2.f8661i
            java.lang.String r3 = "null cannot be cast to non-null type androidx.navigation.NavGraph"
            xa.j.d(r3, r2)
            j3.h1 r2 = (j3.h1) r2
            int r3 = r11.f8513o
            r4 = 0
            j3.c1 r2 = r2.i(r3, r4)
            if (r2 != 0) goto L_0x0158
            java.lang.Object r2 = r13.last()
            j3.r r2 = (j3.r) r2
            r0.o(r2, false, new ma.l())
            goto L_0x0124
        L_0x0158:
            boolean r2 = r13.isEmpty()
            if (r2 == 0) goto L_0x0160
            r2 = 0
            goto L_0x0166
        L_0x0160:
            java.lang.Object[] r2 = r13.f10818i
            int r3 = r13.f10817h
            r2 = r2[r3]
        L_0x0166:
            j3.r r2 = (j3.r) r2
            if (r2 != 0) goto L_0x017a
            boolean r2 = r14.isEmpty()
            if (r2 == 0) goto L_0x0172
            r2 = 0
            goto L_0x0178
        L_0x0172:
            java.lang.Object[] r2 = r14.f10818i
            int r3 = r14.f10817h
            r2 = r2[r3]
        L_0x0178:
            j3.r r2 = (j3.r) r2
        L_0x017a:
            if (r2 == 0) goto L_0x017f
            j3.c1 r2 = r2.f8661i
            goto L_0x0180
        L_0x017f:
            r2 = 0
        L_0x0180:
            j3.h1 r3 = r0.f8578c
            boolean r2 = xa.j.a(r2, r3)
            if (r2 != 0) goto L_0x01d0
            int r2 = r27.size()
            java.util.ListIterator r2 = r10.listIterator(r2)
        L_0x0190:
            boolean r3 = r2.hasPrevious()
            if (r3 == 0) goto L_0x01ac
            java.lang.Object r3 = r2.previous()
            r4 = r3
            j3.r r4 = (j3.r) r4
            j3.c1 r4 = r4.f8661i
            j3.h1 r5 = r0.f8578c
            xa.j.c(r5)
            boolean r4 = xa.j.a(r4, r5)
            if (r4 == 0) goto L_0x0190
            r15 = r3
            goto L_0x01ad
        L_0x01ac:
            r15 = 0
        L_0x01ad:
            j3.r r15 = (j3.r) r15
            if (r15 != 0) goto L_0x01cd
            j3.n r2 = j3.r.f8659t
            android.content.Context r3 = r0.f8576a
            j3.h1 r4 = r0.f8578c
            xa.j.c(r4)
            j3.h1 r5 = r0.f8578c
            xa.j.c(r5)
            android.os.Bundle r5 = r5.b(r8)
            androidx.lifecycle.s r6 = r23.i()
            j3.n0 r7 = r0.f8590o
            j3.r r15 = j3.n.b(r2, r3, r4, r5, r6, r7)
        L_0x01cd:
            r14.c(r15)
        L_0x01d0:
            java.util.Iterator r2 = r14.iterator()
        L_0x01d4:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0211
            java.lang.Object r3 = r2.next()
            j3.r r3 = (j3.r) r3
            j3.c1 r4 = r3.f8661i
            java.lang.String r4 = r4.f8506h
            j3.q2 r5 = r0.f8596u
            j3.o2 r4 = r5.b(r4)
            java.util.LinkedHashMap r5 = r0.f8597v
            java.lang.Object r4 = r5.get(r4)
            if (r4 == 0) goto L_0x01f8
            j3.y r4 = (j3.y) r4
            r4.j(r3)
            goto L_0x01d4
        L_0x01f8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "NavigatorBackStack for "
            r2.<init>(r3)
            java.lang.String r1 = r1.f8506h
            java.lang.String r3 = " should already be created"
            java.lang.String r1 = android.support.v4.media.h.p(r2, r1, r3)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x0211:
            r13.addAll(r14)
            r13.d(r9)
            java.util.ArrayList r1 = ma.z.D(r9, r14)
            java.util.Iterator r1 = r1.iterator()
        L_0x021f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x023b
            java.lang.Object r2 = r1.next()
            j3.r r2 = (j3.r) r2
            j3.c1 r3 = r2.f8661i
            j3.h1 r3 = r3.f8507i
            if (r3 == 0) goto L_0x021f
            int r3 = r3.f8513o
            j3.r r3 = r0.e(r3)
            r0.j(r2, r3)
            goto L_0x021f
        L_0x023b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.k0.a(j3.c1, android.os.Bundle, j3.r, java.util.List):void");
    }

    public final boolean b() {
        l lVar;
        while (true) {
            lVar = this.f8582g;
            if (lVar.isEmpty() || !(((r) lVar.last()).f8661i instanceof h1)) {
                r rVar = (r) lVar.h();
                ArrayList arrayList = this.A;
            } else {
                o((r) lVar.last(), false, new l());
            }
        }
        r rVar2 = (r) lVar.h();
        ArrayList arrayList2 = this.A;
        if (rVar2 != null) {
            arrayList2.add(rVar2);
        }
        this.f8601z++;
        u();
        int i10 = this.f8601z - 1;
        this.f8601z = i10;
        if (i10 == 0) {
            ArrayList K = z.K(arrayList2);
            arrayList2.clear();
            Iterator it = K.iterator();
            while (it.hasNext()) {
                r rVar3 = (r) it.next();
                Iterator it2 = this.f8591p.iterator();
                while (it2.hasNext()) {
                    c1 c1Var = rVar3.f8661i;
                    rVar3.b();
                    ((m3.a) it2.next()).a(this, c1Var);
                }
                this.C.h(rVar3);
            }
            this.f8583h.k(z.K(lVar));
            this.f8584i.k(q());
        }
        if (rVar2 != null) {
            return true;
        }
        return false;
    }

    public final c1 c(int i10) {
        c1 c1Var;
        h1 h1Var = this.f8578c;
        if (h1Var == null) {
            return null;
        }
        if (h1Var.f8513o == i10) {
            return h1Var;
        }
        r rVar = (r) this.f8582g.h();
        if (rVar == null || (c1Var = rVar.f8661i) == null) {
            c1Var = this.f8578c;
            j.c(c1Var);
        }
        return d(c1Var, i10);
    }

    public final r e(int i10) {
        Object obj;
        boolean z10;
        l lVar = this.f8582g;
        ListIterator listIterator = lVar.listIterator(lVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((r) obj).f8661i.f8513o == i10) {
                z10 = true;
                continue;
            } else {
                z10 = false;
                continue;
            }
            if (z10) {
                break;
            }
        }
        r rVar = (r) obj;
        if (rVar != null) {
            return rVar;
        }
        StringBuilder r10 = h.r("No destination with ID ", i10, " is on the NavController's back stack. The current destination is ");
        r10.append(f());
        throw new IllegalArgumentException(r10.toString().toString());
    }

    public final c1 f() {
        r rVar = (r) this.f8582g.h();
        if (rVar != null) {
            return rVar.f8661i;
        }
        return null;
    }

    public final int g() {
        l<r> lVar = this.f8582g;
        int i10 = 0;
        if (!(lVar instanceof Collection) || !lVar.isEmpty()) {
            for (r rVar : lVar) {
                if ((!(rVar.f8661i instanceof h1)) && (i10 = i10 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i10;
    }

    public final h1 h() {
        h1 h1Var = this.f8578c;
        if (h1Var != null) {
            j.d("null cannot be cast to non-null type androidx.navigation.NavGraph", h1Var);
            return h1Var;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
    }

    public final s i() {
        return this.f8589n == null ? s.CREATED : this.f8592q;
    }

    public final void j(r rVar, r rVar2) {
        this.f8585j.put(rVar, rVar2);
        LinkedHashMap linkedHashMap = this.f8586k;
        if (linkedHashMap.get(rVar2) == null) {
            linkedHashMap.put(rVar2, new AtomicInteger(0));
        }
        Object obj = linkedHashMap.get(rVar2);
        j.c(obj);
        ((AtomicInteger) obj).incrementAndGet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(int r7, android.os.Bundle r8, j3.n1 r9) {
        /*
            r6 = this;
            ma.l r0 = r6.f8582g
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000b
            j3.h1 r0 = r6.f8578c
            goto L_0x0013
        L_0x000b:
            java.lang.Object r0 = r0.last()
            j3.r r0 = (j3.r) r0
            j3.c1 r0 = r0.f8661i
        L_0x0013:
            if (r0 == 0) goto L_0x00be
            j3.h r1 = r0.d(r7)
            if (r1 == 0) goto L_0x002e
            if (r9 != 0) goto L_0x001f
            j3.n1 r9 = r1.f8553b
        L_0x001f:
            android.os.Bundle r2 = r1.f8554c
            int r3 = r1.f8552a
            if (r2 == 0) goto L_0x002f
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r4.putAll(r2)
            goto L_0x0030
        L_0x002e:
            r3 = r7
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r8 == 0) goto L_0x003c
            if (r4 != 0) goto L_0x0039
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
        L_0x0039:
            r4.putAll(r8)
        L_0x003c:
            r8 = 0
            if (r3 != 0) goto L_0x0052
            if (r9 == 0) goto L_0x0052
            r2 = -1
            int r5 = r9.f8634c
            if (r5 == r2) goto L_0x0052
            boolean r7 = r9.f8635d
            boolean r7 = r6.n(r5, r7, r8)
            if (r7 == 0) goto L_0x00b1
            r6.b()
            goto L_0x00b1
        L_0x0052:
            if (r3 == 0) goto L_0x0056
            r2 = 1
            goto L_0x0057
        L_0x0056:
            r2 = 0
        L_0x0057:
            if (r2 == 0) goto L_0x00b2
            j3.c1 r2 = r6.c(r3)
            if (r2 != 0) goto L_0x00ae
            j3.a1 r9 = j3.c1.f8505q
            r9.getClass()
            android.content.Context r9 = r6.f8576a
            java.lang.String r2 = j3.a1.b(r9, r3)
            if (r1 != 0) goto L_0x006d
            r8 = 1
        L_0x006d:
            java.lang.String r1 = " cannot be found from the current destination "
            if (r8 != 0) goto L_0x0094
            java.lang.String r8 = "Navigation destination "
            java.lang.String r3 = " referenced from action "
            java.lang.StringBuilder r8 = android.support.v4.media.h.s(r8, r2, r3)
            java.lang.String r7 = j3.a1.b(r9, r7)
            r8.append(r7)
            r8.append(r1)
            r8.append(r0)
            java.lang.String r7 = r8.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L_0x0094:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Navigation action/destination "
            r8.<init>(r9)
            r8.append(r2)
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00ae:
            r6.l(r2, r4, r9)
        L_0x00b1:
            return
        L_0x00b2:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00be:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "no current navigation node"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.k0.k(int, android.os.Bundle, j3.n1):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(j3.c1 r28, android.os.Bundle r29, j3.n1 r30) {
        /*
            r27 = this;
            r6 = r27
            r7 = r28
            r8 = r30
            java.util.LinkedHashMap r9 = r6.f8597v
            java.util.Collection r0 = r9.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()
            j3.y r1 = (j3.y) r1
            r1.f8677d = r2
            goto L_0x0010
        L_0x0020:
            xa.q r10 = new xa.q
            r10.<init>()
            r0 = -1
            if (r8 == 0) goto L_0x0036
            int r1 = r8.f8634c
            if (r1 == r0) goto L_0x0036
            boolean r3 = r8.f8635d
            boolean r4 = r8.f8636e
            boolean r1 = r6.n(r1, r3, r4)
            r12 = r1
            goto L_0x0037
        L_0x0036:
            r12 = 0
        L_0x0037:
            android.os.Bundle r13 = r28.b(r29)
            if (r8 == 0) goto L_0x0043
            boolean r1 = r8.f8633b
            if (r1 != r2) goto L_0x0043
            r1 = 1
            goto L_0x0044
        L_0x0043:
            r1 = 0
        L_0x0044:
            if (r1 == 0) goto L_0x0064
            java.util.LinkedHashMap r1 = r6.f8587l
            int r3 = r7.f8513o
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r1 = r1.containsKey(r3)
            if (r1 == 0) goto L_0x0064
            int r0 = r7.f8513o
            boolean r0 = r6.r(r0, r13, r8)
            r10.f16814h = r0
            r26 = r9
            r25 = r12
            r23 = 0
            goto L_0x019a
        L_0x0064:
            if (r8 == 0) goto L_0x006c
            boolean r1 = r8.f8632a
            if (r1 != r2) goto L_0x006c
            r1 = 1
            goto L_0x006d
        L_0x006c:
            r1 = 0
        L_0x006d:
            j3.q2 r14 = r6.f8596u
            if (r1 == 0) goto L_0x0162
            ma.l r1 = r6.f8582g
            java.lang.Object r3 = r1.h()
            j3.r r3 = (j3.r) r3
            boolean r4 = r7 instanceof j3.h1
            if (r4 == 0) goto L_0x008c
            j3.f1 r4 = j3.h1.f8556v
            r5 = r7
            j3.h1 r5 = (j3.h1) r5
            r4.getClass()
            j3.c1 r4 = j3.f1.a(r5)
            int r4 = r4.f8513o
            goto L_0x008e
        L_0x008c:
            int r4 = r7.f8513o
        L_0x008e:
            if (r3 == 0) goto L_0x009a
            j3.c1 r3 = r3.f8661i
            if (r3 == 0) goto L_0x009a
            int r3 = r3.f8513o
            if (r4 != r3) goto L_0x009a
            r3 = 1
            goto L_0x009b
        L_0x009a:
            r3 = 0
        L_0x009b:
            if (r3 != 0) goto L_0x00a4
            r26 = r9
            r25 = r12
            r11 = 0
            goto L_0x015d
        L_0x00a4:
            ma.l r3 = new ma.l
            r3.<init>()
            int r4 = r1.a()
            java.util.ListIterator r4 = r1.listIterator(r4)
        L_0x00b1:
            boolean r5 = r4.hasPrevious()
            if (r5 == 0) goto L_0x00ca
            java.lang.Object r5 = r4.previous()
            j3.r r5 = (j3.r) r5
            j3.c1 r5 = r5.f8661i
            if (r5 != r7) goto L_0x00c3
            r5 = 1
            goto L_0x00c4
        L_0x00c3:
            r5 = 0
        L_0x00c4:
            if (r5 == 0) goto L_0x00b1
            int r0 = r4.nextIndex()
        L_0x00ca:
            int r4 = ma.r.d(r1)
            if (r4 < r0) goto L_0x0119
            java.lang.Object r4 = r1.k()
            j3.r r4 = (j3.r) r4
            r6.t(r4)
            j3.r r5 = new j3.r
            j3.c1 r15 = r4.f8661i
            r2 = r29
            android.os.Bundle r18 = r15.b(r2)
            android.content.Context r15 = r4.f8660h
            j3.c1 r11 = r4.f8661i
            r24 = r0
            androidx.lifecycle.s r0 = r4.f8663k
            j3.h2 r2 = r4.f8664l
            r25 = r12
            java.lang.String r12 = r4.f8665m
            r26 = r9
            android.os.Bundle r9 = r4.f8666n
            r16 = r15
            r15 = r5
            r17 = r11
            r19 = r0
            r20 = r2
            r21 = r12
            r22 = r9
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            androidx.lifecycle.s r0 = r4.f8663k
            r5.f8663k = r0
            androidx.lifecycle.s r0 = r4.f8670r
            r5.c(r0)
            r3.c(r5)
            r0 = r24
            r12 = r25
            r9 = r26
            r2 = 1
            goto L_0x00ca
        L_0x0119:
            r26 = r9
            r25 = r12
            java.util.Iterator r0 = r3.iterator()
        L_0x0121:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0140
            java.lang.Object r2 = r0.next()
            j3.r r2 = (j3.r) r2
            j3.c1 r4 = r2.f8661i
            j3.h1 r4 = r4.f8507i
            if (r4 == 0) goto L_0x013c
            int r4 = r4.f8513o
            j3.r r4 = r6.e(r4)
            r6.j(r2, r4)
        L_0x013c:
            r1.d(r2)
            goto L_0x0121
        L_0x0140:
            java.util.Iterator r0 = r3.iterator()
        L_0x0144:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x015c
            java.lang.Object r1 = r0.next()
            j3.r r1 = (j3.r) r1
            j3.c1 r2 = r1.f8661i
            java.lang.String r2 = r2.f8506h
            j3.o2 r2 = r14.b(r2)
            r2.f(r1)
            goto L_0x0144
        L_0x015c:
            r11 = 1
        L_0x015d:
            if (r11 == 0) goto L_0x0166
            r23 = 1
            goto L_0x0168
        L_0x0162:
            r26 = r9
            r25 = r12
        L_0x0166:
            r23 = 0
        L_0x0168:
            if (r23 != 0) goto L_0x019a
            j3.n r0 = j3.r.f8659t
            android.content.Context r1 = r6.f8576a
            androidx.lifecycle.s r4 = r27.i()
            j3.n0 r5 = r6.f8590o
            r2 = r28
            r3 = r13
            j3.r r0 = j3.n.b(r0, r1, r2, r3, r4, r5)
            java.lang.String r1 = r7.f8506h
            j3.o2 r9 = r14.b(r1)
            java.util.List r11 = ma.q.b(r0)
            j3.i0 r12 = new j3.i0
            r5 = 0
            r0 = r12
            r1 = r10
            r2 = r27
            r3 = r28
            r4 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f8598w = r12
            r9.d(r11, r8)
            r0 = 0
            r6.f8598w = r0
        L_0x019a:
            r27.v()
            java.util.Collection r0 = r26.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x01a5:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01b5
            java.lang.Object r1 = r0.next()
            j3.y r1 = (j3.y) r1
            r2 = 0
            r1.f8677d = r2
            goto L_0x01a5
        L_0x01b5:
            if (r25 != 0) goto L_0x01c2
            boolean r0 = r10.f16814h
            if (r0 != 0) goto L_0x01c2
            if (r23 == 0) goto L_0x01be
            goto L_0x01c2
        L_0x01be:
            r27.u()
            goto L_0x01c5
        L_0x01c2:
            r27.b()
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.k0.l(j3.c1, android.os.Bundle, j3.n1):void");
    }

    public final void m(d1 d1Var) {
        k(d1Var.b(), d1Var.a(), (n1) null);
    }

    public final boolean n(int i10, boolean z10, boolean z11) {
        c1 c1Var;
        String str;
        String str2;
        String str3;
        String str4;
        int i11 = i10;
        boolean z12 = z11;
        l lVar = this.f8582g;
        if (lVar.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = z.E(lVar).iterator();
        while (true) {
            if (!it.hasNext()) {
                c1Var = null;
                break;
            }
            c1 c1Var2 = ((r) it.next()).f8661i;
            o2 b10 = this.f8596u.b(c1Var2.f8506h);
            if (z10 || c1Var2.f8513o != i11) {
                arrayList.add(b10);
            }
            if (c1Var2.f8513o == i11) {
                c1Var = c1Var2;
                break;
            }
        }
        if (c1Var == null) {
            c1.f8505q.getClass();
            String b11 = a1.b(this.f8576a, i11);
            Log.i("NavController", "Ignoring popBackStack to destination " + b11 + " as it was not found on the current back stack");
            return false;
        }
        q qVar = new q();
        l lVar2 = new l();
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                str = null;
                break;
            }
            q qVar2 = new q();
            b0 b0Var = r0;
            r rVar = (r) lVar.last();
            l lVar3 = lVar;
            q qVar3 = qVar2;
            b0 b0Var2 = new b0(qVar2, qVar, this, z11, lVar2);
            this.f8599x = b0Var;
            ((o2) it2.next()).i(rVar, z12);
            str = null;
            this.f8599x = null;
            if (!qVar3.f16814h) {
                break;
            }
            lVar = lVar3;
        }
        if (z12) {
            LinkedHashMap linkedHashMap = this.f8587l;
            if (!z10) {
                eb.h b12 = m.b(c1Var, c0.f8504h);
                d0 d0Var = new d0(this, 0);
                j.f("<this>", b12);
                Iterator it3 = new r(b12, d0Var, 0).iterator();
                while (it3.hasNext()) {
                    Integer valueOf = Integer.valueOf(((c1) it3.next()).f8513o);
                    if (lVar2.isEmpty()) {
                        str3 = str;
                    } else {
                        str3 = lVar2.f10818i[lVar2.f10817h];
                    }
                    u uVar = (u) str3;
                    if (uVar != null) {
                        str4 = uVar.f8688h;
                    } else {
                        str4 = str;
                    }
                    linkedHashMap.put(valueOf, str4);
                }
            }
            if (!lVar2.isEmpty()) {
                u uVar2 = (u) lVar2.first();
                eb.h b13 = m.b(c(uVar2.f8689i), e0.f8522h);
                d0 d0Var2 = new d0(this, 1);
                j.f("<this>", b13);
                Iterator it4 = new r(b13, d0Var2, 0).iterator();
                while (true) {
                    boolean hasNext = it4.hasNext();
                    str2 = uVar2.f8688h;
                    if (!hasNext) {
                        break;
                    }
                    linkedHashMap.put(Integer.valueOf(((c1) it4.next()).f8513o), str2);
                }
                this.f8588m.put(str2, lVar2);
            }
        }
        v();
        return qVar.f16814h;
    }

    public final void o(r rVar, boolean z10, l lVar) {
        boolean z11;
        n0 n0Var;
        n0 n0Var2;
        Set set;
        l lVar2 = this.f8582g;
        r rVar2 = (r) lVar2.last();
        if (j.a(rVar2, rVar)) {
            lVar2.k();
            y yVar = (y) this.f8597v.get(this.f8596u.b(rVar2.f8661i.f8506h));
            boolean z12 = false;
            if (yVar == null || (n0Var2 = yVar.f8679f) == null || (set = (Set) n0Var2.getValue()) == null || !set.contains(rVar2)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11 || this.f8586k.containsKey(rVar2)) {
                z12 = true;
            }
            s sVar = rVar2.f8667o.f1688d;
            s sVar2 = s.CREATED;
            if (sVar.a(sVar2)) {
                if (z10) {
                    rVar2.c(sVar2);
                    lVar.c(new u(rVar2));
                }
                if (!z12) {
                    rVar2.c(s.DESTROYED);
                    t(rVar2);
                } else {
                    rVar2.c(sVar2);
                }
            }
            if (!z10 && !z12 && (n0Var = this.f8590o) != null) {
                String str = rVar2.f8665m;
                j.f("backStackEntryId", str);
                g2 g2Var = (g2) n0Var.f8631d.remove(str);
                if (g2Var != null) {
                    g2Var.a();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("Attempted to pop " + rVar.f8661i + ", which is not the top of the back stack (" + rVar2.f8661i + ')').toString());
    }

    public final ArrayList q() {
        s sVar;
        boolean z10;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f8597v.values().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            sVar = s.STARTED;
            if (!hasNext) {
                break;
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object next : (Iterable) ((y) it.next()).f8679f.getValue()) {
                r rVar = (r) next;
                if (arrayList.contains(rVar) || rVar.f8670r.a(sVar)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    arrayList2.add(next);
                }
            }
            w.k(arrayList2, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = this.f8582g.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            r rVar2 = (r) next2;
            if (arrayList.contains(rVar2) || !rVar2.f8670r.a(sVar)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                arrayList3.add(next2);
            }
        }
        w.k(arrayList3, arrayList);
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            Object next3 = it3.next();
            if (!(((r) next3).f8661i instanceof h1)) {
                arrayList4.add(next3);
            }
        }
        return arrayList4;
    }

    public final boolean r(int i10, Bundle bundle, n1 n1Var) {
        c1 c1Var;
        r rVar;
        c1 c1Var2;
        LinkedHashMap linkedHashMap = this.f8587l;
        if (!linkedHashMap.containsKey(Integer.valueOf(i10))) {
            return false;
        }
        String str = (String) linkedHashMap.get(Integer.valueOf(i10));
        Collection values = linkedHashMap.values();
        j0 j0Var = new j0(str, 0);
        j.f("<this>", values);
        w.l(values, j0Var, true);
        LinkedHashMap linkedHashMap2 = this.f8588m;
        y.b(linkedHashMap2);
        l lVar = (l) linkedHashMap2.remove(str);
        ArrayList arrayList = new ArrayList();
        r rVar2 = (r) this.f8582g.h();
        if (rVar2 == null || (c1Var = rVar2.f8661i) == null) {
            c1Var = h();
        }
        if (lVar != null) {
            Iterator it = lVar.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                c1 d10 = d(c1Var, uVar.f8689i);
                Context context = this.f8576a;
                if (d10 != null) {
                    arrayList.add(uVar.u(context, d10, i(), this.f8590o));
                    c1Var = d10;
                } else {
                    c1.f8505q.getClass();
                    String b10 = a1.b(context, uVar.f8689i);
                    throw new IllegalStateException(("Restore State failed: destination " + b10 + " cannot be found from the current destination " + c1Var).toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (!(((r) next).f8661i instanceof h1)) {
                arrayList3.add(next);
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (true) {
            String str2 = null;
            if (!it3.hasNext()) {
                break;
            }
            r rVar3 = (r) it3.next();
            List list = (List) z.A(arrayList2);
            if (!(list == null || (rVar = (r) z.z(list)) == null || (c1Var2 = rVar.f8661i) == null)) {
                str2 = c1Var2.f8506h;
            }
            if (j.a(str2, rVar3.f8661i.f8506h)) {
                list.add(rVar3);
            } else {
                arrayList2.add(new ArrayList(new ma.j(new r[]{rVar3}, true)));
            }
        }
        q qVar = new q();
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            List list2 = (List) it4.next();
            o2 b11 = this.f8596u.b(((r) z.s(list2)).f8661i.f8506h);
            this.f8598w = new f0(qVar, arrayList, new xa.s(), this, bundle);
            b11.d(list2, n1Var);
            this.f8598w = null;
        }
        return qVar.f16814h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03b0, code lost:
        if (r0 == false) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01db, code lost:
        if (r9 != false) goto L_0x01dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0203  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(j3.h1 r17, android.os.Bundle r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            j3.h1 r2 = r1.f8578c
            boolean r2 = xa.j.a(r2, r0)
            ma.l r3 = r1.f8582g
            r4 = 1
            r5 = 0
            if (r2 != 0) goto L_0x03c8
            j3.h1 r2 = r1.f8578c
            java.util.LinkedHashMap r6 = r1.f8597v
            r7 = 0
            if (r2 == 0) goto L_0x007e
            java.util.ArrayList r8 = new java.util.ArrayList
            java.util.LinkedHashMap r9 = r1.f8587l
            java.util.Set r9 = r9.keySet()
            r8.<init>(r9)
            java.util.Iterator r8 = r8.iterator()
        L_0x0026:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0079
            java.lang.Object r9 = r8.next()
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.String r10 = "id"
            xa.j.e(r10, r9)
            int r9 = r9.intValue()
            java.util.Collection r10 = r6.values()
            java.util.Iterator r10 = r10.iterator()
        L_0x0043:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0052
            java.lang.Object r11 = r10.next()
            j3.y r11 = (j3.y) r11
            r11.f8677d = r4
            goto L_0x0043
        L_0x0052:
            j3.a0 r10 = j3.a0.f8489h
            j3.n1 r10 = hb.h0.f1(r10)
            boolean r10 = r1.r(r9, r7, r10)
            java.util.Collection r11 = r6.values()
            java.util.Iterator r11 = r11.iterator()
        L_0x0064:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0073
            java.lang.Object r12 = r11.next()
            j3.y r12 = (j3.y) r12
            r12.f8677d = r5
            goto L_0x0064
        L_0x0073:
            if (r10 == 0) goto L_0x0026
            r1.n(r9, r4, r5)
            goto L_0x0026
        L_0x0079:
            int r2 = r2.f8513o
            r1.n(r2, r4, r5)
        L_0x007e:
            r1.f8578c = r0
            android.os.Bundle r0 = r1.f8579d
            j3.q2 r2 = r1.f8596u
            if (r0 == 0) goto L_0x00b1
            java.lang.String r5 = "android-support-nav:controller:navigatorState:names"
            java.util.ArrayList r5 = r0.getStringArrayList(r5)
            if (r5 == 0) goto L_0x00b1
            java.util.Iterator r5 = r5.iterator()
        L_0x0092:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x00b1
            java.lang.Object r8 = r5.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = "name"
            xa.j.e(r9, r8)
            j3.o2 r9 = r2.b(r8)
            android.os.Bundle r8 = r0.getBundle(r8)
            if (r8 == 0) goto L_0x0092
            r9.g(r8)
            goto L_0x0092
        L_0x00b1:
            android.os.Parcelable[] r0 = r1.f8580e
            java.lang.String r5 = " cannot be found from the current destination "
            android.content.Context r8 = r1.f8576a
            if (r0 == 0) goto L_0x012d
            int r9 = r0.length
            r10 = 0
        L_0x00bb:
            if (r10 >= r9) goto L_0x0128
            r11 = r0[r10]
            java.lang.String r12 = "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState"
            xa.j.d(r12, r11)
            j3.u r11 = (j3.u) r11
            int r12 = r11.f8689i
            j3.c1 r12 = r1.c(r12)
            if (r12 == 0) goto L_0x0106
            androidx.lifecycle.s r13 = r16.i()
            j3.n0 r14 = r1.f8590o
            j3.r r11 = r11.u(r8, r12, r13, r14)
            java.lang.String r12 = r12.f8506h
            j3.o2 r12 = r2.b(r12)
            java.lang.Object r13 = r6.get(r12)
            if (r13 != 0) goto L_0x00ec
            j3.y r13 = new j3.y
            r13.<init>(r1, r12)
            r6.put(r12, r13)
        L_0x00ec:
            j3.y r13 = (j3.y) r13
            r3.d(r11)
            r13.j(r11)
            j3.c1 r12 = r11.f8661i
            j3.h1 r12 = r12.f8507i
            if (r12 == 0) goto L_0x0103
            int r12 = r12.f8513o
            j3.r r12 = r1.e(r12)
            r1.j(r11, r12)
        L_0x0103:
            int r10 = r10 + 1
            goto L_0x00bb
        L_0x0106:
            j3.a1 r0 = j3.c1.f8505q
            r0.getClass()
            int r0 = r11.f8689i
            java.lang.String r0 = j3.a1.b(r8, r0)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Restoring the Navigation back stack failed: destination "
            java.lang.StringBuilder r0 = android.support.v4.media.h.s(r3, r0, r5)
            j3.c1 r3 = r16.f()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0128:
            r16.v()
            r1.f8580e = r7
        L_0x012d:
            java.util.LinkedHashMap r0 = r2.f8658a
            java.util.Map r0 = ma.j0.g(r0)
            java.util.Collection r0 = r0.values()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0140:
            boolean r9 = r0.hasNext()
            if (r9 == 0) goto L_0x0155
            java.lang.Object r9 = r0.next()
            r10 = r9
            j3.o2 r10 = (j3.o2) r10
            boolean r10 = r10.f8649b
            if (r10 != 0) goto L_0x0140
            r2.add(r9)
            goto L_0x0140
        L_0x0155:
            java.util.Iterator r0 = r2.iterator()
        L_0x0159:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0179
            java.lang.Object r2 = r0.next()
            j3.o2 r2 = (j3.o2) r2
            java.lang.Object r9 = r6.get(r2)
            if (r9 != 0) goto L_0x0173
            j3.y r9 = new j3.y
            r9.<init>(r1, r2)
            r6.put(r2, r9)
        L_0x0173:
            j3.y r9 = (j3.y) r9
            r2.e(r9)
            goto L_0x0159
        L_0x0179:
            j3.h1 r0 = r1.f8578c
            if (r0 == 0) goto L_0x03c3
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x03c3
            boolean r0 = r1.f8581f
            if (r0 != 0) goto L_0x03b3
            android.app.Activity r2 = r1.f8577b
            if (r2 == 0) goto L_0x03b3
            android.content.Intent r6 = r2.getIntent()
            if (r6 != 0) goto L_0x0193
            goto L_0x03af
        L_0x0193:
            android.os.Bundle r9 = r6.getExtras()
            java.lang.String r10 = "NavController"
            if (r9 == 0) goto L_0x01b4
            java.lang.String r0 = "android-support-nav:controller:deepLinkIds"
            int[] r0 = r9.getIntArray(r0)     // Catch:{ Exception -> 0x01a2 }
            goto L_0x01b5
        L_0x01a2:
            r0 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "handleDeepLink() could not extract deepLink from "
            r11.<init>(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r10, r11, r0)
        L_0x01b4:
            r0 = r7
        L_0x01b5:
            if (r9 == 0) goto L_0x01be
            java.lang.String r11 = "android-support-nav:controller:deepLinkArgs"
            java.util.ArrayList r11 = r9.getParcelableArrayList(r11)
            goto L_0x01bf
        L_0x01be:
            r11 = r7
        L_0x01bf:
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            if (r9 == 0) goto L_0x01cd
            java.lang.String r13 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r9 = r9.getBundle(r13)
            goto L_0x01ce
        L_0x01cd:
            r9 = r7
        L_0x01ce:
            if (r9 == 0) goto L_0x01d3
            r12.putAll(r9)
        L_0x01d3:
            if (r0 == 0) goto L_0x01dd
            int r9 = r0.length
            if (r9 != 0) goto L_0x01da
            r9 = 1
            goto L_0x01db
        L_0x01da:
            r9 = 0
        L_0x01db:
            if (r9 == 0) goto L_0x0200
        L_0x01dd:
            j3.h1 r9 = r1.f8578c
            xa.j.c(r9)
            android.support.v4.media.session.u r13 = new android.support.v4.media.session.u
            r13.<init>((android.content.Intent) r6)
            j3.b1 r9 = r9.f(r13)
            if (r9 == 0) goto L_0x0200
            j3.c1 r0 = r9.f8495h
            int[] r11 = r0.c(r7)
            android.os.Bundle r9 = r9.f8496i
            android.os.Bundle r0 = r0.b(r9)
            if (r0 == 0) goto L_0x01fe
            r12.putAll(r0)
        L_0x01fe:
            r0 = r11
            goto L_0x0201
        L_0x0200:
            r7 = r11
        L_0x0201:
            if (r0 == 0) goto L_0x03af
            int r9 = r0.length
            if (r9 != 0) goto L_0x0208
            r9 = 1
            goto L_0x0209
        L_0x0208:
            r9 = 0
        L_0x0209:
            if (r9 == 0) goto L_0x020d
            goto L_0x03af
        L_0x020d:
            j3.h1 r9 = r1.f8578c
            int r11 = r0.length
            r13 = 0
        L_0x0211:
            if (r13 >= r11) goto L_0x025a
            r14 = r0[r13]
            if (r13 != 0) goto L_0x0225
            j3.h1 r15 = r1.f8578c
            xa.j.c(r15)
            int r15 = r15.f8513o
            if (r15 != r14) goto L_0x0223
            j3.h1 r15 = r1.f8578c
            goto L_0x022c
        L_0x0223:
            r15 = 0
            goto L_0x022c
        L_0x0225:
            xa.j.c(r9)
            j3.c1 r15 = r9.i(r14, r4)
        L_0x022c:
            if (r15 != 0) goto L_0x0238
            j3.a1 r9 = j3.c1.f8505q
            r9.getClass()
            java.lang.String r9 = j3.a1.b(r8, r14)
            goto L_0x025b
        L_0x0238:
            int r14 = r0.length
            int r14 = r14 - r4
            if (r13 == r14) goto L_0x0257
            boolean r14 = r15 instanceof j3.h1
            if (r14 == 0) goto L_0x0257
        L_0x0240:
            j3.h1 r15 = (j3.h1) r15
            xa.j.c(r15)
            int r9 = r15.f8558s
            j3.c1 r9 = r15.i(r9, r4)
            boolean r9 = r9 instanceof j3.h1
            if (r9 == 0) goto L_0x0256
            int r9 = r15.f8558s
            j3.c1 r15 = r15.i(r9, r4)
            goto L_0x0240
        L_0x0256:
            r9 = r15
        L_0x0257:
            int r13 = r13 + 1
            goto L_0x0211
        L_0x025a:
            r9 = 0
        L_0x025b:
            if (r9 == 0) goto L_0x0278
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Could not find destination "
            r0.<init>(r2)
            r0.append(r9)
            java.lang.String r2 = " in the navigation graph, ignoring the deep link from "
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r10, r0)
            goto L_0x03af
        L_0x0278:
            java.lang.String r9 = "android-support-nav:controller:deepLinkIntent"
            r12.putParcelable(r9, r6)
            int r9 = r0.length
            android.os.Bundle[] r10 = new android.os.Bundle[r9]
            r11 = 0
        L_0x0281:
            if (r11 >= r9) goto L_0x029d
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            r13.putAll(r12)
            if (r7 == 0) goto L_0x0298
            java.lang.Object r14 = r7.get(r11)
            android.os.Bundle r14 = (android.os.Bundle) r14
            if (r14 == 0) goto L_0x0298
            r13.putAll(r14)
        L_0x0298:
            r10[r11] = r13
            int r11 = r11 + 1
            goto L_0x0281
        L_0x029d:
            int r7 = r6.getFlags()
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            r9 = r9 & r7
            if (r9 == 0) goto L_0x02da
            r11 = 32768(0x8000, float:4.5918E-41)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x02da
            r6.addFlags(r11)
            b0.q0 r0 = new b0.q0
            r0.<init>(r8)
            android.content.ComponentName r3 = r6.getComponent()
            if (r3 != 0) goto L_0x02c4
            android.content.Context r3 = r0.f2408i
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            android.content.ComponentName r3 = r6.resolveActivity(r3)
        L_0x02c4:
            if (r3 == 0) goto L_0x02c9
            r0.a(r3)
        L_0x02c9:
            java.util.ArrayList r3 = r0.f2407h
            r3.add(r6)
            r0.b()
            r2.finish()
            r0 = 0
            r2.overridePendingTransition(r0, r0)
            goto L_0x03ad
        L_0x02da:
            java.lang.String r2 = "Deep Linking failed: destination "
            if (r9 == 0) goto L_0x032b
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x02ef
            j3.h1 r3 = r1.f8578c
            xa.j.c(r3)
            int r3 = r3.f8513o
            r6 = 0
            r1.n(r3, r4, r6)
        L_0x02ef:
            r3 = 0
        L_0x02f0:
            int r6 = r0.length
            if (r3 >= r6) goto L_0x03ad
            r6 = r0[r3]
            int r7 = r3 + 1
            r3 = r10[r3]
            j3.c1 r9 = r1.c(r6)
            if (r9 == 0) goto L_0x030d
            androidx.lifecycle.u1 r6 = new androidx.lifecycle.u1
            r6.<init>(r9, r4, r1)
            j3.n1 r6 = hb.h0.f1(r6)
            r1.l(r9, r3, r6)
            r3 = r7
            goto L_0x02f0
        L_0x030d:
            j3.a1 r0 = j3.c1.f8505q
            r0.getClass()
            java.lang.String r0 = j3.a1.b(r8, r6)
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = android.support.v4.media.h.s(r2, r0, r5)
            j3.c1 r2 = r16.f()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        L_0x032b:
            j3.h1 r3 = r1.f8578c
            int r5 = r0.length
            r6 = 0
        L_0x032f:
            if (r6 >= r5) goto L_0x03ab
            r7 = r0[r6]
            r9 = r10[r6]
            if (r6 != 0) goto L_0x033a
            j3.h1 r11 = r1.f8578c
            goto L_0x0341
        L_0x033a:
            xa.j.c(r3)
            j3.c1 r11 = r3.i(r7, r4)
        L_0x0341:
            if (r11 == 0) goto L_0x0388
            int r7 = r0.length
            int r7 = r7 - r4
            if (r6 == r7) goto L_0x0364
            boolean r7 = r11 instanceof j3.h1
            if (r7 == 0) goto L_0x0385
            j3.h1 r11 = (j3.h1) r11
            r3 = r11
        L_0x034e:
            xa.j.c(r3)
            int r7 = r3.f8558s
            j3.c1 r7 = r3.i(r7, r4)
            boolean r7 = r7 instanceof j3.h1
            if (r7 == 0) goto L_0x0385
            int r7 = r3.f8558s
            j3.c1 r3 = r3.i(r7, r4)
            j3.h1 r3 = (j3.h1) r3
            goto L_0x034e
        L_0x0364:
            j3.m1 r7 = new j3.m1
            r7.<init>()
            j3.h1 r12 = r1.f8578c
            xa.j.c(r12)
            int r12 = r12.f8513o
            r7.f8617c = r12
            r12 = 0
            r7.f8618d = r12
            r7.f8619e = r4
            r12 = 0
            r7.f8620f = r12
            r7.f8621g = r12
            r7.f8622h = r12
            j3.n1 r7 = r7.a()
            r1.l(r11, r9, r7)
        L_0x0385:
            int r6 = r6 + 1
            goto L_0x032f
        L_0x0388:
            j3.a1 r0 = j3.c1.f8505q
            r0.getClass()
            java.lang.String r0 = j3.a1.b(r8, r7)
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            r5.append(r0)
            java.lang.String r0 = " cannot be found in graph "
            r5.append(r0)
            r5.append(r3)
            java.lang.String r0 = r5.toString()
            r4.<init>(r0)
            throw r4
        L_0x03ab:
            r1.f8581f = r4
        L_0x03ad:
            r0 = 1
            goto L_0x03b0
        L_0x03af:
            r0 = 0
        L_0x03b0:
            if (r0 == 0) goto L_0x03b3
            goto L_0x03b4
        L_0x03b3:
            r4 = 0
        L_0x03b4:
            if (r4 != 0) goto L_0x0470
            j3.h1 r0 = r1.f8578c
            xa.j.c(r0)
            r2 = 0
            r3 = r18
            r1.l(r0, r3, r2)
            goto L_0x0470
        L_0x03c3:
            r16.b()
            goto L_0x0470
        L_0x03c8:
            r2 = 0
            q.l r5 = r0.f8557r
            int r6 = r5.g()
        L_0x03cf:
            if (r2 >= r6) goto L_0x0403
            java.lang.Object r7 = r5.h(r2)
            j3.c1 r7 = (j3.c1) r7
            j3.h1 r8 = r1.f8578c
            xa.j.c(r8)
            q.l r8 = r8.f8557r
            int r8 = r8.e(r2)
            j3.h1 r9 = r1.f8578c
            xa.j.c(r9)
            q.l r9 = r9.f8557r
            boolean r10 = r9.f13083h
            if (r10 == 0) goto L_0x03f0
            r9.c()
        L_0x03f0:
            int[] r10 = r9.f13084i
            int r11 = r9.f13086k
            int r8 = q.g.a(r11, r8, r10)
            if (r8 < 0) goto L_0x0400
            java.lang.Object[] r9 = r9.f13085j
            r10 = r9[r8]
            r9[r8] = r7
        L_0x0400:
            int r2 = r2 + 1
            goto L_0x03cf
        L_0x0403:
            java.util.Iterator r2 = r3.iterator()
        L_0x0407:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0470
            java.lang.Object r3 = r2.next()
            j3.r r3 = (j3.r) r3
            j3.a1 r5 = j3.c1.f8505q
            j3.c1 r6 = r3.f8661i
            r5.getClass()
            java.lang.String r5 = "<this>"
            xa.j.f(r5, r6)
            j3.z0 r7 = j3.z0.f8727h
            eb.h r6 = eb.m.b(r6, r7)
            java.util.List r6 = eb.q.d(r6)
            xa.j.f(r5, r6)
            ma.k0 r5 = new ma.k0
            r5.<init>((java.util.List) r6)
            j3.h1 r6 = r1.f8578c
            xa.j.c(r6)
            java.util.Iterator r5 = r5.iterator()
        L_0x043a:
            r7 = r5
            q.m r7 = (q.m) r7
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0468
            java.lang.Object r7 = r7.next()
            j3.c1 r7 = (j3.c1) r7
            j3.h1 r8 = r1.f8578c
            boolean r8 = xa.j.a(r7, r8)
            if (r8 == 0) goto L_0x0458
            boolean r8 = xa.j.a(r6, r0)
            if (r8 == 0) goto L_0x0458
            goto L_0x043a
        L_0x0458:
            boolean r8 = r6 instanceof j3.h1
            if (r8 == 0) goto L_0x043a
            j3.h1 r6 = (j3.h1) r6
            int r7 = r7.f8513o
            j3.c1 r6 = r6.i(r7, r4)
            xa.j.c(r6)
            goto L_0x043a
        L_0x0468:
            java.lang.String r5 = "<set-?>"
            xa.j.f(r5, r6)
            r3.f8661i = r6
            goto L_0x0407
        L_0x0470:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.k0.s(j3.h1, android.os.Bundle):void");
    }

    public final void t(r rVar) {
        Integer num;
        j.f("child", rVar);
        r rVar2 = (r) this.f8585j.remove(rVar);
        if (rVar2 != null) {
            LinkedHashMap linkedHashMap = this.f8586k;
            AtomicInteger atomicInteger = (AtomicInteger) linkedHashMap.get(rVar2);
            if (atomicInteger != null) {
                num = Integer.valueOf(atomicInteger.decrementAndGet());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                y yVar = (y) this.f8597v.get(this.f8596u.b(rVar2.f8661i.f8506h));
                if (yVar != null) {
                    yVar.b(rVar2);
                }
                linkedHashMap.remove(rVar2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u() {
        /*
            r13 = this;
            ma.l r0 = r13.f8582g
            java.util.ArrayList r0 = ma.z.K(r0)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Object r1 = ma.z.z(r0)
            j3.r r1 = (j3.r) r1
            j3.c1 r1 = r1.f8661i
            boolean r2 = r1 instanceof j3.g
            r3 = 0
            if (r2 == 0) goto L_0x0039
            java.util.List r2 = ma.z.E(r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x0022:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r2.next()
            j3.r r4 = (j3.r) r4
            j3.c1 r4 = r4.f8661i
            boolean r5 = r4 instanceof j3.h1
            if (r5 != 0) goto L_0x0022
            boolean r5 = r4 instanceof j3.g
            if (r5 != 0) goto L_0x0022
            goto L_0x003a
        L_0x0039:
            r4 = r3
        L_0x003a:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.List r5 = ma.z.E(r0)
            java.util.Iterator r5 = r5.iterator()
        L_0x0047:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00d2
            java.lang.Object r6 = r5.next()
            j3.r r6 = (j3.r) r6
            androidx.lifecycle.s r7 = r6.f8670r
            j3.c1 r8 = r6.f8661i
            androidx.lifecycle.s r9 = androidx.lifecycle.s.RESUMED
            androidx.lifecycle.s r10 = androidx.lifecycle.s.STARTED
            if (r1 == 0) goto L_0x00b4
            int r11 = r8.f8513o
            int r12 = r1.f8513o
            if (r11 != r12) goto L_0x00b4
            if (r7 == r9) goto L_0x00b1
            java.lang.String r7 = r8.f8506h
            j3.q2 r8 = r13.f8596u
            j3.o2 r7 = r8.b(r7)
            java.util.LinkedHashMap r8 = r13.f8597v
            java.lang.Object r7 = r8.get(r7)
            j3.y r7 = (j3.y) r7
            if (r7 == 0) goto L_0x008c
            kb.n0 r7 = r7.f8679f
            if (r7 == 0) goto L_0x008c
            java.lang.Object r7 = r7.getValue()
            java.util.Set r7 = (java.util.Set) r7
            if (r7 == 0) goto L_0x008c
            boolean r7 = r7.contains(r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x008d
        L_0x008c:
            r7 = r3
        L_0x008d:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            boolean r7 = xa.j.a(r7, r8)
            if (r7 != 0) goto L_0x00ae
            java.util.LinkedHashMap r7 = r13.f8586k
            java.lang.Object r7 = r7.get(r6)
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            if (r7 == 0) goto L_0x00a7
            int r7 = r7.get()
            if (r7 != 0) goto L_0x00a7
            r7 = 1
            goto L_0x00a8
        L_0x00a7:
            r7 = 0
        L_0x00a8:
            if (r7 != 0) goto L_0x00ae
            r2.put(r6, r9)
            goto L_0x00b1
        L_0x00ae:
            r2.put(r6, r10)
        L_0x00b1:
            j3.h1 r1 = r1.f8507i
            goto L_0x0047
        L_0x00b4:
            if (r4 == 0) goto L_0x00cb
            int r8 = r8.f8513o
            int r11 = r4.f8513o
            if (r8 != r11) goto L_0x00cb
            if (r7 != r9) goto L_0x00c2
            r6.c(r10)
            goto L_0x00c7
        L_0x00c2:
            if (r7 == r10) goto L_0x00c7
            r2.put(r6, r10)
        L_0x00c7:
            j3.h1 r4 = r4.f8507i
            goto L_0x0047
        L_0x00cb:
            androidx.lifecycle.s r7 = androidx.lifecycle.s.CREATED
            r6.c(r7)
            goto L_0x0047
        L_0x00d2:
            java.util.Iterator r0 = r0.iterator()
        L_0x00d6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f2
            java.lang.Object r1 = r0.next()
            j3.r r1 = (j3.r) r1
            java.lang.Object r3 = r2.get(r1)
            androidx.lifecycle.s r3 = (androidx.lifecycle.s) r3
            if (r3 == 0) goto L_0x00ee
            r1.c(r3)
            goto L_0x00d6
        L_0x00ee:
            r1.d()
            goto L_0x00d6
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.k0.u():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        if (g() > 1) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v() {
        /*
            r2 = this;
            boolean r0 = r2.f8595t
            if (r0 == 0) goto L_0x000c
            int r0 = r2.g()
            r1 = 1
            if (r0 <= r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            androidx.fragment.app.q0 r0 = r2.f8594s
            r0.f489a = r1
            l0.a r0 = r0.f491c
            if (r0 == 0) goto L_0x001c
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.b(r1)
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.k0.v():void");
    }
}

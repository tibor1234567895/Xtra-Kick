package androidx.lifecycle;

import android.support.v4.media.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import n.b;
import o.a;
import xa.j;

public final class g0 extends t {

    /* renamed from: j  reason: collision with root package name */
    public static final e0 f1685j = new e0(0);

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1686b = true;

    /* renamed from: c  reason: collision with root package name */
    public a f1687c = new a();

    /* renamed from: d  reason: collision with root package name */
    public s f1688d = s.INITIALIZED;

    /* renamed from: e  reason: collision with root package name */
    public final WeakReference f1689e;

    /* renamed from: f  reason: collision with root package name */
    public int f1690f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1691g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1692h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f1693i = new ArrayList();

    public g0(d0 d0Var) {
        j.f("provider", d0Var);
        this.f1689e = new WeakReference(d0Var);
    }

    public final void a(c0 c0Var) {
        d0 d0Var;
        boolean z10;
        j.f("observer", c0Var);
        e("addObserver");
        s sVar = this.f1688d;
        s sVar2 = s.DESTROYED;
        if (sVar != sVar2) {
            sVar2 = s.INITIALIZED;
        }
        f0 f0Var = new f0(c0Var, sVar2);
        if (((f0) this.f1687c.b(c0Var, f0Var)) == null && (d0Var = (d0) this.f1689e.get()) != null) {
            if (this.f1690f != 0 || this.f1691g) {
                z10 = true;
            } else {
                z10 = false;
            }
            s d10 = d(c0Var);
            this.f1690f++;
            while (f0Var.f1682a.compareTo(d10) < 0 && this.f1687c.f11838l.containsKey(c0Var)) {
                s sVar3 = f0Var.f1682a;
                ArrayList arrayList = this.f1693i;
                arrayList.add(sVar3);
                p pVar = r.Companion;
                s sVar4 = f0Var.f1682a;
                pVar.getClass();
                r b10 = p.b(sVar4);
                if (b10 != null) {
                    f0Var.a(d0Var, b10);
                    arrayList.remove(arrayList.size() - 1);
                    d10 = d(c0Var);
                } else {
                    throw new IllegalStateException("no event up from " + f0Var.f1682a);
                }
            }
            if (!z10) {
                i();
            }
            this.f1690f--;
        }
    }

    public final s b() {
        return this.f1688d;
    }

    public final void c(c0 c0Var) {
        j.f("observer", c0Var);
        e("removeObserver");
        this.f1687c.c(c0Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.lifecycle.s} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.s d(androidx.lifecycle.c0 r4) {
        /*
            r3 = this;
            o.a r0 = r3.f1687c
            java.util.HashMap r1 = r0.f11838l
            boolean r1 = r1.containsKey(r4)
            r2 = 0
            if (r1 == 0) goto L_0x0016
            java.util.HashMap r0 = r0.f11838l
            java.lang.Object r4 = r0.get(r4)
            o.c r4 = (o.c) r4
            o.c r4 = r4.f11843k
            goto L_0x0017
        L_0x0016:
            r4 = r2
        L_0x0017:
            if (r4 == 0) goto L_0x0022
            java.lang.Object r4 = r4.f11841i
            androidx.lifecycle.f0 r4 = (androidx.lifecycle.f0) r4
            if (r4 == 0) goto L_0x0022
            androidx.lifecycle.s r4 = r4.f1682a
            goto L_0x0023
        L_0x0022:
            r4 = r2
        L_0x0023:
            java.util.ArrayList r0 = r3.f1693i
            boolean r1 = r0.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x003a
            int r1 = r0.size()
            int r1 = r1 + -1
            java.lang.Object r0 = r0.get(r1)
            r2 = r0
            androidx.lifecycle.s r2 = (androidx.lifecycle.s) r2
        L_0x003a:
            androidx.lifecycle.s r0 = r3.f1688d
            androidx.lifecycle.e0 r1 = f1685j
            r1.getClass()
            java.lang.String r1 = "state1"
            xa.j.f(r1, r0)
            if (r4 == 0) goto L_0x004f
            int r1 = r4.compareTo(r0)
            if (r1 >= 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r4 = r0
        L_0x0050:
            if (r2 == 0) goto L_0x0059
            int r0 = r2.compareTo(r4)
            if (r0 >= 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r2 = r4
        L_0x005a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.g0.d(androidx.lifecycle.c0):androidx.lifecycle.s");
    }

    public final void e(String str) {
        if (this.f1686b && !b.a().b()) {
            throw new IllegalStateException(h.n("Method ", str, " must be called on the main thread").toString());
        }
    }

    public final void f(r rVar) {
        j.f("event", rVar);
        e("handleLifecycleEvent");
        g(rVar.a());
    }

    public final void g(s sVar) {
        s sVar2 = this.f1688d;
        if (sVar2 != sVar) {
            s sVar3 = s.INITIALIZED;
            s sVar4 = s.DESTROYED;
            if ((sVar2 == sVar3 && sVar == sVar4) ? false : true) {
                this.f1688d = sVar;
                if (this.f1691g || this.f1690f != 0) {
                    this.f1692h = true;
                    return;
                }
                this.f1691g = true;
                i();
                this.f1691g = false;
                if (this.f1688d == sVar4) {
                    this.f1687c = new a();
                    return;
                }
                return;
            }
            throw new IllegalStateException(("no event down from " + this.f1688d + " in component " + this.f1689e.get()).toString());
        }
    }

    public final void h(s sVar) {
        j.f("state", sVar);
        e("setCurrentState");
        g(sVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0163 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r7 = this;
            java.lang.ref.WeakReference r0 = r7.f1689e
            java.lang.Object r0 = r0.get()
            androidx.lifecycle.d0 r0 = (androidx.lifecycle.d0) r0
            if (r0 == 0) goto L_0x0164
        L_0x000a:
            o.a r1 = r7.f1687c
            int r2 = r1.f11852k
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            o.c r1 = r1.f11849h
            xa.j.c(r1)
            java.lang.Object r1 = r1.f11841i
            androidx.lifecycle.f0 r1 = (androidx.lifecycle.f0) r1
            androidx.lifecycle.s r1 = r1.f1682a
            o.a r2 = r7.f1687c
            o.c r2 = r2.f11850i
            xa.j.c(r2)
            java.lang.Object r2 = r2.f11841i
            androidx.lifecycle.f0 r2 = (androidx.lifecycle.f0) r2
            androidx.lifecycle.s r2 = r2.f1682a
            if (r1 != r2) goto L_0x0033
            androidx.lifecycle.s r1 = r7.f1688d
            if (r1 != r2) goto L_0x0033
        L_0x0031:
            r1 = 1
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            r7.f1692h = r3
            if (r1 != 0) goto L_0x0163
            androidx.lifecycle.s r1 = r7.f1688d
            o.a r2 = r7.f1687c
            o.c r2 = r2.f11849h
            xa.j.c(r2)
            java.lang.Object r2 = r2.f11841i
            androidx.lifecycle.f0 r2 = (androidx.lifecycle.f0) r2
            androidx.lifecycle.s r2 = r2.f1682a
            int r1 = r1.compareTo(r2)
            java.util.ArrayList r2 = r7.f1693i
            if (r1 >= 0) goto L_0x00d1
            o.a r1 = r7.f1687c
            o.b r3 = new o.b
            o.c r5 = r1.f11850i
            o.c r6 = r1.f11849h
            r3.<init>(r5, r6, r4)
            java.util.WeakHashMap r1 = r1.f11851j
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r1.put(r3, r4)
        L_0x0061:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x00d1
            boolean r1 = r7.f1692h
            if (r1 != 0) goto L_0x00d1
            java.lang.Object r1 = r3.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.String r4 = "next()"
            xa.j.e(r4, r1)
            java.lang.Object r4 = r1.getKey()
            androidx.lifecycle.c0 r4 = (androidx.lifecycle.c0) r4
            java.lang.Object r1 = r1.getValue()
            androidx.lifecycle.f0 r1 = (androidx.lifecycle.f0) r1
        L_0x0082:
            androidx.lifecycle.s r5 = r1.f1682a
            androidx.lifecycle.s r6 = r7.f1688d
            int r5 = r5.compareTo(r6)
            if (r5 <= 0) goto L_0x0061
            boolean r5 = r7.f1692h
            if (r5 != 0) goto L_0x0061
            o.a r5 = r7.f1687c
            java.util.HashMap r5 = r5.f11838l
            boolean r5 = r5.containsKey(r4)
            if (r5 == 0) goto L_0x0061
            androidx.lifecycle.p r5 = androidx.lifecycle.r.Companion
            androidx.lifecycle.s r6 = r1.f1682a
            r5.getClass()
            androidx.lifecycle.r r5 = androidx.lifecycle.p.a(r6)
            if (r5 == 0) goto L_0x00bb
            androidx.lifecycle.s r6 = r5.a()
            r2.add(r6)
            r1.a(r0, r5)
            int r5 = r2.size()
            int r5 = r5 + -1
            r2.remove(r5)
            goto L_0x0082
        L_0x00bb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "no event down from "
            r2.<init>(r3)
            androidx.lifecycle.s r1 = r1.f1682a
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00d1:
            o.a r1 = r7.f1687c
            o.c r1 = r1.f11850i
            boolean r3 = r7.f1692h
            if (r3 != 0) goto L_0x000a
            if (r1 == 0) goto L_0x000a
            androidx.lifecycle.s r3 = r7.f1688d
            java.lang.Object r1 = r1.f11841i
            androidx.lifecycle.f0 r1 = (androidx.lifecycle.f0) r1
            androidx.lifecycle.s r1 = r1.f1682a
            int r1 = r3.compareTo(r1)
            if (r1 <= 0) goto L_0x000a
            o.a r1 = r7.f1687c
            r1.getClass()
            o.d r3 = new o.d
            r3.<init>(r1)
            java.util.WeakHashMap r1 = r1.f11851j
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r1.put(r3, r4)
        L_0x00fa:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x000a
            boolean r1 = r7.f1692h
            if (r1 != 0) goto L_0x000a
            java.lang.Object r1 = r3.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r4 = r1.getKey()
            androidx.lifecycle.c0 r4 = (androidx.lifecycle.c0) r4
            java.lang.Object r1 = r1.getValue()
            androidx.lifecycle.f0 r1 = (androidx.lifecycle.f0) r1
        L_0x0116:
            androidx.lifecycle.s r5 = r1.f1682a
            androidx.lifecycle.s r6 = r7.f1688d
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L_0x00fa
            boolean r5 = r7.f1692h
            if (r5 != 0) goto L_0x00fa
            o.a r5 = r7.f1687c
            java.util.HashMap r5 = r5.f11838l
            boolean r5 = r5.containsKey(r4)
            if (r5 == 0) goto L_0x00fa
            androidx.lifecycle.s r5 = r1.f1682a
            r2.add(r5)
            androidx.lifecycle.p r5 = androidx.lifecycle.r.Companion
            androidx.lifecycle.s r6 = r1.f1682a
            r5.getClass()
            androidx.lifecycle.r r5 = androidx.lifecycle.p.b(r6)
            if (r5 == 0) goto L_0x014d
            r1.a(r0, r5)
            int r5 = r2.size()
            int r5 = r5 + -1
            r2.remove(r5)
            goto L_0x0116
        L_0x014d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "no event up from "
            r2.<init>(r3)
            androidx.lifecycle.s r1 = r1.f1682a
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0163:
            return
        L_0x0164:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.g0.i():void");
    }
}

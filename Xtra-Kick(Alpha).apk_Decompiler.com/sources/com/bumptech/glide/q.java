package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.manager.v;
import d5.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import s5.a;
import s5.b;
import s5.c;
import s5.d;
import s5.e;
import s5.f;
import s5.h;
import s5.i;
import t5.g;
import w5.n;
import w5.p;

public class q extends a {
    public final Context H;
    public final s I;
    public final Class J;
    public final h K;
    public t L;
    public Object M;
    public ArrayList N;
    public q O;
    public q P;
    public boolean Q = true;
    public boolean R;
    public boolean S;

    static {
        f fVar = (f) ((f) ((f) new f().f(u.f4492b)).o()).s(true);
    }

    public q(c cVar, s sVar, Class cls, Context context) {
        f fVar;
        this.I = sVar;
        this.J = cls;
        this.H = context;
        Map map = sVar.f3308h.f3166j.f3193f;
        t tVar = (t) map.get(cls);
        if (tVar == null) {
            for (Map.Entry entry : map.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    tVar = (t) entry.getValue();
                }
            }
        }
        this.L = tVar == null ? h.f3187k : tVar;
        this.K = cVar.f3166j;
        Iterator it = sVar.f3316p.iterator();
        while (it.hasNext()) {
            y((c) it.next());
        }
        synchronized (sVar) {
            fVar = sVar.f3317q;
        }
        a(fVar);
    }

    public final d A(int i10, int i11, j jVar, t tVar, a aVar, e eVar, g gVar, Object obj, w5.e eVar2) {
        b bVar;
        b bVar2;
        i iVar;
        int i12;
        t tVar2;
        j jVar2;
        int i13;
        int i14;
        a aVar2 = aVar;
        Object obj2 = obj;
        if (this.P != null) {
            bVar2 = new b(obj2, eVar);
            bVar = bVar2;
        } else {
            bVar = null;
            bVar2 = eVar;
        }
        q qVar = this.O;
        if (qVar == null) {
            iVar = I(i10, i11, jVar, tVar, aVar, bVar2, gVar, obj, eVar2);
        } else if (!this.S) {
            t tVar3 = qVar.L;
            if (qVar.Q) {
                tVar2 = tVar;
            } else {
                tVar2 = tVar3;
            }
            if (a.h(qVar.f14304h, 8)) {
                jVar2 = this.O.f14307k;
            } else {
                int ordinal = jVar.ordinal();
                if (ordinal == 0 || ordinal == 1) {
                    jVar2 = j.IMMEDIATE;
                } else if (ordinal == 2) {
                    jVar2 = j.HIGH;
                } else if (ordinal == 3) {
                    jVar2 = j.NORMAL;
                } else {
                    throw new IllegalArgumentException("unknown priority: " + this.f14307k);
                }
            }
            j jVar3 = jVar2;
            q qVar2 = this.O;
            int i15 = qVar2.f14314r;
            int i16 = qVar2.f14313q;
            if (p.h(i10, i11)) {
                q qVar3 = this.O;
                if (!p.h(qVar3.f14314r, qVar3.f14313q)) {
                    i14 = aVar2.f14314r;
                    i13 = aVar2.f14313q;
                    i iVar2 = new i(obj2, bVar2);
                    g gVar2 = gVar;
                    Object obj3 = obj;
                    i iVar3 = iVar2;
                    h I2 = I(i10, i11, jVar, tVar, aVar, iVar2, gVar2, obj3, eVar2);
                    this.S = true;
                    q qVar4 = this.O;
                    d A = qVar4.A(i14, i13, jVar3, tVar2, qVar4, iVar3, gVar2, obj3, eVar2);
                    this.S = false;
                    i iVar4 = iVar3;
                    iVar4.f14357c = I2;
                    iVar4.f14358d = A;
                    iVar = iVar4;
                }
            }
            i13 = i16;
            i14 = i15;
            i iVar22 = new i(obj2, bVar2);
            g gVar22 = gVar;
            Object obj32 = obj;
            i iVar32 = iVar22;
            h I22 = I(i10, i11, jVar, tVar, aVar, iVar22, gVar22, obj32, eVar2);
            this.S = true;
            q qVar42 = this.O;
            d A2 = qVar42.A(i14, i13, jVar3, tVar2, qVar42, iVar32, gVar22, obj32, eVar2);
            this.S = false;
            i iVar42 = iVar32;
            iVar42.f14357c = I22;
            iVar42.f14358d = A2;
            iVar = iVar42;
        } else {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (bVar == null) {
            return iVar;
        }
        q qVar5 = this.P;
        int i17 = qVar5.f14314r;
        int i18 = qVar5.f14313q;
        if (p.h(i10, i11)) {
            q qVar6 = this.P;
            if (!p.h(qVar6.f14314r, qVar6.f14313q)) {
                int i19 = aVar2.f14314r;
                i12 = aVar2.f14313q;
                i17 = i19;
                q qVar7 = this.P;
                d A3 = qVar7.A(i17, i12, qVar7.f14307k, qVar7.L, qVar7, bVar, gVar, obj, eVar2);
                bVar.f14325c = iVar;
                bVar.f14326d = A3;
                return bVar;
            }
        }
        i12 = i18;
        q qVar72 = this.P;
        d A32 = qVar72.A(i17, i12, qVar72.f14307k, qVar72.L, qVar72, bVar, gVar, obj, eVar2);
        bVar.f14325c = iVar;
        bVar.f14326d = A32;
        return bVar;
    }

    /* renamed from: B */
    public q d() {
        q qVar = (q) super.clone();
        qVar.L = qVar.L.clone();
        if (qVar.N != null) {
            qVar.N = new ArrayList(qVar.N);
        }
        q qVar2 = qVar.O;
        if (qVar2 != null) {
            qVar.O = qVar2.d();
        }
        q qVar3 = qVar.P;
        if (qVar3 != null) {
            qVar.P = qVar3.d();
        }
        return qVar;
    }

    public final void C(ImageView imageView) {
        a aVar;
        t5.b bVar;
        p.a();
        if (!a.h(this.f14304h, 2048) && this.f14317u && imageView.getScaleType() != null) {
            switch (p.f3303a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = d().j();
                    break;
                case 2:
                case 6:
                    aVar = d().k();
                    break;
                case 3:
                case 4:
                case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                    aVar = d().l();
                    break;
            }
        }
        aVar = this;
        this.K.f3190c.getClass();
        Class cls = this.J;
        if (Bitmap.class.equals(cls)) {
            bVar = new t5.b(imageView, 0);
        } else if (Drawable.class.isAssignableFrom(cls)) {
            bVar = new t5.b(imageView, 1);
        } else {
            throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
        }
        E(bVar, aVar, w5.g.f16113a);
    }

    public final void D(t5.c cVar) {
        E(cVar, this, w5.g.f16113a);
    }

    public final void E(g gVar, a aVar, w5.e eVar) {
        boolean z10;
        n.b(gVar);
        if (this.R) {
            Object obj = new Object();
            t tVar = this.L;
            d A = A(aVar.f14314r, aVar.f14313q, aVar.f14307k, tVar, aVar, (e) null, gVar, obj, eVar);
            d h10 = gVar.h();
            if (A.f(h10)) {
                if (aVar.f14312p || !h10.j()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10) {
                    n.b(h10);
                    if (!h10.isRunning()) {
                        h10.e();
                        return;
                    }
                    return;
                }
            }
            this.I.o(gVar);
            gVar.a(A);
            s sVar = this.I;
            synchronized (sVar) {
                sVar.f3313m.f3263h.add(gVar);
                v vVar = sVar.f3311k;
                vVar.f3284a.add(A);
                if (!vVar.f3286c) {
                    A.e();
                } else {
                    A.clear();
                    Log.isLoggable("RequestTracker", 2);
                    vVar.f3285b.add(A);
                }
            }
            return;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public q F(String str) {
        return H(str);
    }

    public q G(y4.a aVar) {
        return H(aVar);
    }

    public final q H(Object obj) {
        if (this.C) {
            return d().H(obj);
        }
        this.M = obj;
        this.R = true;
        p();
        return this;
    }

    public final h I(int i10, int i11, j jVar, t tVar, a aVar, e eVar, g gVar, Object obj, w5.e eVar2) {
        Context context = this.H;
        Object obj2 = this.M;
        Class cls = this.J;
        ArrayList arrayList = this.N;
        h hVar = this.K;
        return new h(context, hVar, obj, obj2, cls, aVar, i10, i11, jVar, gVar, arrayList, eVar, hVar.f3194g, tVar.f3318h, eVar2);
    }

    public q J(m5.d dVar) {
        if (this.C) {
            return d().J(dVar);
        }
        this.L = dVar;
        this.Q = false;
        p();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (super.equals(qVar)) {
                return Objects.equals(this.J, qVar.J) && this.L.equals(qVar.L) && Objects.equals(this.M, qVar.M) && Objects.equals(this.N, qVar.N) && Objects.equals(this.O, qVar.O) && Objects.equals(this.P, qVar.P) && this.Q == qVar.Q && this.R == qVar.R;
            }
        }
    }

    public final int hashCode() {
        return p.g(p.g(p.f(p.f(p.f(p.f(p.f(p.f(p.f(super.hashCode(), this.J), this.L), this.M), this.N), this.O), this.P), (Object) null), this.Q), this.R);
    }

    public q y(c cVar) {
        if (this.C) {
            return d().y(cVar);
        }
        if (cVar != null) {
            if (this.N == null) {
                this.N = new ArrayList();
            }
            this.N.add(cVar);
        }
        p();
        return this;
    }

    /* renamed from: z */
    public q a(a aVar) {
        n.b(aVar);
        return (q) super.a(aVar);
    }
}

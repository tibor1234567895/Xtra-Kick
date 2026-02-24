package com.github.andreyasadchy.xtra.ui.chat;

import androidx.lifecycle.o0;
import androidx.lifecycle.w1;
import c6.b;
import e6.s0;
import e6.x;
import e6.z1;
import hb.h0;
import i6.a0;
import i6.h;
import i6.i;
import i6.m;
import i6.n;
import i6.p;
import i6.q;
import i6.r;
import i6.s;
import i6.t;
import i6.u;
import i6.w;
import i6.y;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import la.f;
import la.o;
import ma.z;
import pa.e;
import pb.f1;
import r7.j;
import s7.l;

public final class ChatViewModel extends w1 implements j {
    public static List A;
    public static List B;

    /* renamed from: d  reason: collision with root package name */
    public final x f3347d;

    /* renamed from: e  reason: collision with root package name */
    public final z1 f3348e;

    /* renamed from: f  reason: collision with root package name */
    public final f1 f3349f;

    /* renamed from: g  reason: collision with root package name */
    public final s0 f3350g;

    /* renamed from: h  reason: collision with root package name */
    public final b f3351h;

    /* renamed from: i  reason: collision with root package name */
    public final o f3352i = f.b(new n(this, 2));

    /* renamed from: j  reason: collision with root package name */
    public final o0 f3353j = new o0();

    /* renamed from: k  reason: collision with root package name */
    public final o0 f3354k = new o0();

    /* renamed from: l  reason: collision with root package name */
    public final o0 f3355l = new o0();

    /* renamed from: m  reason: collision with root package name */
    public final o0 f3356m = new o0();

    /* renamed from: n  reason: collision with root package name */
    public final o0 f3357n = new o0();

    /* renamed from: o  reason: collision with root package name */
    public final o0 f3358o = new o0();

    /* renamed from: p  reason: collision with root package name */
    public final o0 f3359p = new o0();

    /* renamed from: q  reason: collision with root package name */
    public final o0 f3360q;

    /* renamed from: r  reason: collision with root package name */
    public final o0 f3361r;

    /* renamed from: s  reason: collision with root package name */
    public final o f3362s;

    /* renamed from: t  reason: collision with root package name */
    public final o f3363t;

    /* renamed from: u  reason: collision with root package name */
    public final o f3364u;

    /* renamed from: v  reason: collision with root package name */
    public int f3365v;

    /* renamed from: w  reason: collision with root package name */
    public final o f3366w;

    /* renamed from: x  reason: collision with root package name */
    public final o f3367x;

    /* renamed from: y  reason: collision with root package name */
    public h f3368y;

    /* renamed from: z  reason: collision with root package name */
    public final o f3369z;

    static {
        new i(0);
    }

    @Inject
    public ChatViewModel(x xVar, z1 z1Var, f1 f1Var, s0 s0Var, b bVar) {
        xa.j.f("repository", xVar);
        xa.j.f("playerRepository", z1Var);
        xa.j.f("okHttpClient", f1Var);
        xa.j.f("kickApiRepository", s0Var);
        xa.j.f("kickMapper", bVar);
        this.f3347d = xVar;
        this.f3348e = z1Var;
        this.f3349f = f1Var;
        this.f3350g = s0Var;
        this.f3351h = bVar;
        new o0();
        this.f3360q = new o0();
        this.f3361r = new o0();
        this.f3362s = f.b(s.f8340h);
        this.f3363t = f.b(t.f8341h);
        this.f3364u = f.b(p.f8337h);
        this.f3365v = 600;
        this.f3366w = f.b(new n(this, 1));
        this.f3367x = f.b(r.f8339h);
        this.f3369z = f.b(q.f8338h);
    }

    public final void b() {
        h hVar = this.f3368y;
        if (hVar != null) {
            hVar.e();
        }
    }

    public final o0 d() {
        return (o0) this.f3366w.getValue();
    }

    public final l e() {
        return (l) this.f3364u.getValue();
    }

    public final l f() {
        return (l) this.f3362s.getValue();
    }

    public final void g(int i10, String str, String str2, boolean z10) {
        ArrayList arrayList = new ArrayList();
        List list = A;
        boolean z11 = true;
        if (!(list == null || list.isEmpty())) {
            this.f3357n.l(list);
            f().l(Boolean.TRUE);
        } else {
            h0.b1(h0.I0(this), (pa.h) null, 0, new u(this, str2, (e) null), 3);
        }
        if (z10) {
            List list2 = B;
            if (!(list2 == null || list2.isEmpty())) {
                h hVar = this.f3368y;
                m mVar = hVar instanceof m ? (m) hVar : null;
                if (mVar != null) {
                    mVar.g(list2);
                }
                arrayList.addAll(list2);
                this.f3354k.l(z.F(arrayList, new a0()));
                this.f3355l.j(list2);
                f().l(Boolean.TRUE);
            } else {
                h0.b1(h0.I0(this), (pa.h) null, 0, new w(this, arrayList, (e) null), 3);
            }
            if (str != null && (!fb.w.h(str))) {
                h0.b1(h0.I0(this), (pa.h) null, 0, new y(this, str, i10, arrayList, (e) null), 3);
            }
        }
        if (i10 == 0) {
            if (str != null && !fb.w.h(str)) {
                z11 = false;
            }
            if (z11) {
                return;
            }
        }
        h0.b1(h0.I0(this), (pa.h) null, 0, new i6.z(this, i10, str, str2, (e) null), 3);
    }
}

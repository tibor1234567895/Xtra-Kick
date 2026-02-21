package androidx.lifecycle;

import android.support.v4.media.session.u;
import b1.c;
import db.b;
import hb.h0;
import la.e;
import wa.a;

public final class x1 implements e {

    /* renamed from: h  reason: collision with root package name */
    public final b f1785h;

    /* renamed from: i  reason: collision with root package name */
    public final a f1786i;

    /* renamed from: j  reason: collision with root package name */
    public final a f1787j;

    /* renamed from: k  reason: collision with root package name */
    public final a f1788k;

    /* renamed from: l  reason: collision with root package name */
    public w1 f1789l;

    public x1(xa.e eVar, a aVar, a aVar2, a aVar3) {
        this.f1785h = eVar;
        this.f1786i = aVar;
        this.f1787j = aVar2;
        this.f1788k = aVar3;
    }

    public final Object getValue() {
        w1 w1Var = this.f1789l;
        if (w1Var != null) {
            return w1Var;
        }
        w1 q10 = new u((g2) this.f1786i.b(), (b2) this.f1787j.b(), (c) this.f1788k.b()).q(h0.s0(this.f1785h));
        this.f1789l = q10;
        return q10;
    }
}

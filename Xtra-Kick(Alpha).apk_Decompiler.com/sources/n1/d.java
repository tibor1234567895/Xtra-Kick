package n1;

import android.os.Bundle;
import g1.j1;
import g1.m;
import h3.f4;
import h3.y0;
import h3.z;
import h9.a0;
import j1.a;
import j1.h;
import j1.p;
import j1.q;

public final /* synthetic */ class d implements q, h {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10957h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f10958i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ m f10959j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f10960k;

    public /* synthetic */ d(int i10, j1 j1Var, j1 j1Var2, b bVar) {
        this.f10958i = bVar;
        this.f10957h = i10;
        this.f10959j = j1Var;
        this.f10960k = j1Var2;
    }

    public final void b(Object obj) {
        y0 y0Var = (y0) this.f10958i;
        a0 d10 = ((z) obj).d(y0Var.f7453a, (f4) this.f10959j, (Bundle) this.f10960k);
        a.d(d10, "ControllerCallback#onCustomCommand() must not return null");
        d10.a(new p((Object) y0Var, (Object) d10, this.f10957h, 3), h9.q.f7765h);
    }

    public final void invoke(Object obj) {
        c cVar = (c) obj;
        cVar.getClass();
        c0 c0Var = (c0) cVar;
        int i10 = this.f10957h;
        if (i10 == 1) {
            c0Var.f10951u = true;
        }
        c0Var.f10941k = i10;
    }
}

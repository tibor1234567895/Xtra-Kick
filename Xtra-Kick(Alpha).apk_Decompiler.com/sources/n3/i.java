package n3;

import androidx.fragment.app.p0;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.w;
import androidx.recyclerview.widget.x0;
import hb.d0;
import java.util.concurrent.atomic.AtomicInteger;
import kb.m0;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final w f11235a;

    /* renamed from: b  reason: collision with root package name */
    public final x0 f11236b;

    /* renamed from: c  reason: collision with root package name */
    public final d0 f11237c;

    /* renamed from: d  reason: collision with root package name */
    public final h f11238d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11239e;

    /* renamed from: f  reason: collision with root package name */
    public final g f11240f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f11241g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public final p0 f11242h;

    public i(w wVar, c cVar, d0 d0Var, d0 d0Var2) {
        this.f11235a = wVar;
        this.f11236b = cVar;
        this.f11237c = d0Var2;
        h hVar = new h(this);
        this.f11238d = hVar;
        g gVar = new g(this, hVar, d0Var);
        this.f11240f = gVar;
        this.f11242h = gVar.f11174k;
        new m0(gVar.f11175l);
    }
}

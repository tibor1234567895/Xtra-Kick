package n3;

import androidx.fragment.app.p0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kb.e1;
import kb.f1;
import wa.l;

public final class g1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f11180a;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList f11181b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public a1 f11182c;

    /* renamed from: d  reason: collision with root package name */
    public a1 f11183d;

    /* renamed from: e  reason: collision with root package name */
    public a1 f11184e;

    /* renamed from: f  reason: collision with root package name */
    public c1 f11185f;

    /* renamed from: g  reason: collision with root package name */
    public c1 f11186g;

    /* renamed from: h  reason: collision with root package name */
    public final e1 f11187h;

    /* renamed from: i  reason: collision with root package name */
    public final p0 f11188i;

    public g1() {
        z0.f11599b.getClass();
        z0 z0Var = z0.f11601d;
        this.f11182c = z0Var;
        this.f11183d = z0Var;
        this.f11184e = z0Var;
        c1.f11077d.getClass();
        this.f11185f = c1.f11078e;
        e1 a10 = f1.a((Object) null);
        this.f11187h = a10;
        this.f11188i = new p0(2, a10);
    }

    public static a1 a(a1 a1Var, a1 a1Var2, a1 a1Var3, a1 a1Var4) {
        return a1Var4 == null ? a1Var3 : (!(a1Var instanceof x0) || ((a1Var2 instanceof z0) && (a1Var4 instanceof z0)) || (a1Var4 instanceof w0)) ? a1Var4 : a1Var;
    }

    public final void b() {
        a1 a1Var;
        a1 a1Var2;
        a1 a1Var3;
        a1 a1Var4 = this.f11182c;
        a1 a1Var5 = this.f11185f.f11079a;
        c1 c1Var = this.f11186g;
        z zVar = null;
        if (c1Var == null) {
            a1Var = null;
        } else {
            a1Var = c1Var.f11079a;
        }
        this.f11182c = a(a1Var4, a1Var5, a1Var5, a1Var);
        a1 a1Var6 = this.f11183d;
        c1 c1Var2 = this.f11185f;
        a1 a1Var7 = c1Var2.f11079a;
        c1 c1Var3 = this.f11186g;
        if (c1Var3 == null) {
            a1Var2 = null;
        } else {
            a1Var2 = c1Var3.f11080b;
        }
        this.f11183d = a(a1Var6, a1Var7, c1Var2.f11080b, a1Var2);
        a1 a1Var8 = this.f11184e;
        c1 c1Var4 = this.f11185f;
        a1 a1Var9 = c1Var4.f11079a;
        c1 c1Var5 = this.f11186g;
        if (c1Var5 == null) {
            a1Var3 = null;
        } else {
            a1Var3 = c1Var5.f11081c;
        }
        a1 a10 = a(a1Var8, a1Var9, c1Var4.f11081c, a1Var3);
        this.f11184e = a10;
        if (this.f11180a) {
            zVar = new z(this.f11182c, this.f11183d, a10, this.f11185f, this.f11186g);
        }
        if (zVar != null) {
            this.f11187h.k(zVar);
            Iterator it = this.f11181b.iterator();
            while (it.hasNext()) {
                ((l) it.next()).invoke(zVar);
            }
        }
    }
}

package androidx.fragment.app;

import android.support.v4.media.h;
import i0.f;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import ma.z;
import p0.c;

public abstract class h2 {

    /* renamed from: a  reason: collision with root package name */
    public g2 f1453a;

    /* renamed from: b  reason: collision with root package name */
    public e2 f1454b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f1455c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f1456d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet f1457e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    public boolean f1458f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1459g;

    public h2(g2 g2Var, e2 e2Var, c0 c0Var, f fVar) {
        this.f1453a = g2Var;
        this.f1454b = e2Var;
        this.f1455c = c0Var;
        fVar.b(new c(1, this));
    }

    public final void a() {
        if (!this.f1458f) {
            this.f1458f = true;
            LinkedHashSet linkedHashSet = this.f1457e;
            if (linkedHashSet.isEmpty()) {
                b();
                return;
            }
            for (f a10 : z.M(linkedHashSet)) {
                a10.a();
            }
        }
    }

    public abstract void b();

    public final void c(g2 g2Var, e2 e2Var) {
        e2 e2Var2;
        int ordinal = e2Var.ordinal();
        c0 c0Var = this.f1455c;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    if (c1.I(2)) {
                        Objects.toString(c0Var);
                        Objects.toString(this.f1453a);
                        Objects.toString(this.f1454b);
                    }
                    this.f1453a = g2.REMOVED;
                    e2Var2 = e2.REMOVING;
                } else {
                    return;
                }
            } else if (this.f1453a == g2.REMOVED) {
                if (c1.I(2)) {
                    Objects.toString(c0Var);
                    Objects.toString(this.f1454b);
                }
                this.f1453a = g2.VISIBLE;
                e2Var2 = e2.ADDING;
            } else {
                return;
            }
            this.f1454b = e2Var2;
        } else if (this.f1453a != g2.REMOVED) {
            if (c1.I(2)) {
                Objects.toString(c0Var);
                Objects.toString(this.f1453a);
                g2Var.toString();
            }
            this.f1453a = g2Var;
        }
    }

    public abstract void d();

    public final String toString() {
        StringBuilder s10 = h.s("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
        s10.append(this.f1453a);
        s10.append(" lifecycleImpact = ");
        s10.append(this.f1454b);
        s10.append(" fragment = ");
        s10.append(this.f1455c);
        s10.append('}');
        return s10.toString();
    }
}

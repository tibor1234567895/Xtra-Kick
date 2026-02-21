package n3;

import androidx.recyclerview.widget.t;
import androidx.recyclerview.widget.w;

public final class k1 extends t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j1 f11278a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j1 f11279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w f11280c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f11281d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f11282e;

    public k1(j1 j1Var, j1 j1Var2, w wVar, int i10, int i11) {
        this.f11278a = j1Var;
        this.f11279b = j1Var2;
        this.f11280c = wVar;
        this.f11281d = i10;
        this.f11282e = i11;
    }

    public final boolean a(int i10, int i11) {
        Object c10 = ((n3) this.f11278a).c(i10);
        Object c11 = ((n3) this.f11279b).c(i11);
        if (c10 == c11) {
            return true;
        }
        return this.f11280c.a(c10, c11);
    }

    public final boolean b(int i10, int i11) {
        Object c10 = ((n3) this.f11278a).c(i10);
        Object c11 = ((n3) this.f11279b).c(i11);
        if (c10 == c11) {
            return true;
        }
        return this.f11280c.b(c10, c11);
    }

    public final Object c(int i10, int i11) {
        if (((n3) this.f11278a).c(i10) == ((n3) this.f11279b).c(i11)) {
            return Boolean.TRUE;
        }
        this.f11280c.getClass();
        return null;
    }

    public final int d() {
        return this.f11282e;
    }

    public final int e() {
        return this.f11281d;
    }
}

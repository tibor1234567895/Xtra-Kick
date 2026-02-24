package g1;

import android.net.Uri;
import d9.p0;
import d9.r0;
import d9.r1;
import j1.a;
import java.util.Collections;
import java.util.List;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public String f6358a;

    /* renamed from: b  reason: collision with root package name */
    public Uri f6359b;

    /* renamed from: c  reason: collision with root package name */
    public String f6360c;

    /* renamed from: d  reason: collision with root package name */
    public final g0 f6361d;

    /* renamed from: e  reason: collision with root package name */
    public j0 f6362e;

    /* renamed from: f  reason: collision with root package name */
    public final List f6363f;

    /* renamed from: g  reason: collision with root package name */
    public String f6364g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f6365h;

    /* renamed from: i  reason: collision with root package name */
    public Object f6366i;

    /* renamed from: j  reason: collision with root package name */
    public v0 f6367j;

    /* renamed from: k  reason: collision with root package name */
    public l0 f6368k;

    /* renamed from: l  reason: collision with root package name */
    public p0 f6369l;

    public f0() {
        this.f6361d = new g0();
        this.f6362e = new j0(0);
        this.f6363f = Collections.emptyList();
        p0 p0Var = r0.f4657i;
        this.f6365h = r1.f4658l;
        this.f6368k = new l0();
        this.f6369l = p0.f6501k;
    }

    public final s0 a() {
        boolean z10;
        n0 n0Var;
        j0 j0Var = this.f6362e;
        if (j0Var.f6415b == null || j0Var.f6414a != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        Uri uri = this.f6359b;
        k0 k0Var = null;
        if (uri != null) {
            String str = this.f6360c;
            j0 j0Var2 = this.f6362e;
            if (j0Var2.f6414a != null) {
                k0Var = new k0(j0Var2);
            }
            n0Var = new n0(uri, str, k0Var, this.f6363f, this.f6364g, this.f6365h, this.f6366i);
        } else {
            n0Var = null;
        }
        String str2 = this.f6358a;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        g0 g0Var = this.f6361d;
        g0Var.getClass();
        i0 i0Var = new i0(g0Var);
        m0 a10 = this.f6368k.a();
        v0 v0Var = this.f6367j;
        if (v0Var == null) {
            v0Var = v0.P;
        }
        return new s0(str3, i0Var, n0Var, a10, v0Var, this.f6369l);
    }

    public final void b(String str) {
        Uri uri;
        if (str == null) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        this.f6359b = uri;
    }

    public f0(s0 s0Var) {
        this();
        j0 j0Var;
        i0 i0Var = s0Var.f6560l;
        i0Var.getClass();
        this.f6361d = new g0(i0Var);
        this.f6358a = s0Var.f6556h;
        this.f6367j = s0Var.f6559k;
        m0 m0Var = s0Var.f6558j;
        m0Var.getClass();
        this.f6368k = new l0(m0Var);
        this.f6369l = s0Var.f6561m;
        n0 n0Var = s0Var.f6557i;
        if (n0Var != null) {
            this.f6364g = n0Var.f6482e;
            this.f6360c = n0Var.f6479b;
            this.f6359b = n0Var.f6478a;
            this.f6363f = n0Var.f6481d;
            this.f6365h = n0Var.f6483f;
            this.f6366i = n0Var.f6484g;
            k0 k0Var = n0Var.f6480c;
            if (k0Var != null) {
                j0Var = new j0(k0Var);
            } else {
                j0Var = new j0(0);
            }
            this.f6362e = j0Var;
        }
    }
}

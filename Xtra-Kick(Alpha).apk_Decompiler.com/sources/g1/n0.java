package g1;

import android.net.Uri;
import d9.o0;
import d9.p0;
import d9.r0;
import j1.l0;
import java.util.List;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f6478a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6479b;

    /* renamed from: c  reason: collision with root package name */
    public final k0 f6480c;

    /* renamed from: d  reason: collision with root package name */
    public final List f6481d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6482e;

    /* renamed from: f  reason: collision with root package name */
    public final r0 f6483f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f6484g;

    public n0(Uri uri, String str, k0 k0Var, List list, String str2, r0 r0Var, Object obj) {
        this.f6478a = uri;
        this.f6479b = str;
        this.f6480c = k0Var;
        this.f6481d = list;
        this.f6482e = str2;
        this.f6483f = r0Var;
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        for (int i10 = 0; i10 < r0Var.size(); i10++) {
            q0 q0Var = (q0) r0Var.get(i10);
            q0Var.getClass();
            o0Var.c(new q0(new r0(q0Var)));
        }
        o0Var.e();
        this.f6484g = obj;
    }

    /* renamed from: a */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f6478a.equals(n0Var.f6478a) && l0.a(this.f6479b, n0Var.f6479b) && l0.a(this.f6480c, n0Var.f6480c) && l0.a((Object) null, (Object) null) && this.f6481d.equals(n0Var.f6481d) && l0.a(this.f6482e, n0Var.f6482e) && this.f6483f.equals(n0Var.f6483f) && l0.a(this.f6484g, n0Var.f6484g);
    }

    /* renamed from: b */
    public final int hashCode() {
        int hashCode = this.f6478a.hashCode() * 31;
        int i10 = 0;
        String str = this.f6479b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        k0 k0Var = this.f6480c;
        int hashCode3 = (this.f6481d.hashCode() + ((((hashCode2 + (k0Var == null ? 0 : k0Var.hashCode())) * 31) + 0) * 31)) * 31;
        String str2 = this.f6482e;
        int hashCode4 = (this.f6483f.hashCode() + ((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        Object obj = this.f6484g;
        if (obj != null) {
            i10 = obj.hashCode();
        }
        return hashCode4 + i10;
    }
}

package g1;

import android.net.Uri;
import j1.l0;

public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f6522a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6523b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6524c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6525d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6526e;

    /* renamed from: f  reason: collision with root package name */
    public final String f6527f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6528g;

    public q0(r0 r0Var) {
        this.f6522a = r0Var.f6529a;
        this.f6523b = r0Var.f6530b;
        this.f6524c = r0Var.f6531c;
        this.f6525d = r0Var.f6532d;
        this.f6526e = r0Var.f6533e;
        this.f6527f = r0Var.f6534f;
        this.f6528g = r0Var.f6535g;
    }

    /* renamed from: a */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.f6522a.equals(q0Var.f6522a) && l0.a(this.f6523b, q0Var.f6523b) && l0.a(this.f6524c, q0Var.f6524c) && this.f6525d == q0Var.f6525d && this.f6526e == q0Var.f6526e && l0.a(this.f6527f, q0Var.f6527f) && l0.a(this.f6528g, q0Var.f6528g);
    }

    /* renamed from: b */
    public final int hashCode() {
        int hashCode = this.f6522a.hashCode() * 31;
        int i10 = 0;
        String str = this.f6523b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f6524c;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f6525d) * 31) + this.f6526e) * 31;
        String str3 = this.f6527f;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f6528g;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return hashCode4 + i10;
    }
}

package g1;

import android.net.Uri;
import d9.r0;
import d9.t0;
import j1.a;
import j1.l0;
import java.util.Arrays;
import java.util.UUID;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final UUID f6441a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f6442b;

    /* renamed from: c  reason: collision with root package name */
    public final t0 f6443c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6444d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f6445e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6446f;

    /* renamed from: g  reason: collision with root package name */
    public final r0 f6447g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f6448h;

    public k0(j0 j0Var) {
        boolean z10;
        byte[] bArr;
        boolean z11 = j0Var.f6419f;
        Uri uri = j0Var.f6415b;
        if (!z11 || uri != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        UUID uuid = j0Var.f6414a;
        uuid.getClass();
        this.f6441a = uuid;
        this.f6442b = uri;
        this.f6443c = j0Var.f6416c;
        this.f6444d = j0Var.f6417d;
        this.f6446f = z11;
        this.f6445e = j0Var.f6418e;
        this.f6447g = j0Var.f6420g;
        byte[] bArr2 = j0Var.f6421h;
        if (bArr2 != null) {
            bArr = Arrays.copyOf(bArr2, bArr2.length);
        } else {
            bArr = null;
        }
        this.f6448h = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f6441a.equals(k0Var.f6441a) && l0.a(this.f6442b, k0Var.f6442b) && l0.a(this.f6443c, k0Var.f6443c) && this.f6444d == k0Var.f6444d && this.f6446f == k0Var.f6446f && this.f6445e == k0Var.f6445e && this.f6447g.equals(k0Var.f6447g) && Arrays.equals(this.f6448h, k0Var.f6448h);
    }

    public final int hashCode() {
        int hashCode = this.f6441a.hashCode() * 31;
        Uri uri = this.f6442b;
        int hashCode2 = uri != null ? uri.hashCode() : 0;
        int hashCode3 = this.f6443c.hashCode();
        return Arrays.hashCode(this.f6448h) + ((this.f6447g.hashCode() + ((((((((hashCode3 + ((hashCode + hashCode2) * 31)) * 31) + (this.f6444d ? 1 : 0)) * 31) + (this.f6446f ? 1 : 0)) * 31) + (this.f6445e ? 1 : 0)) * 31)) * 31);
    }
}

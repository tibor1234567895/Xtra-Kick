package s4;

import android.graphics.drawable.Drawable;
import q4.d;
import s.i;
import xa.j;

public final class r extends j {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f14294a;

    /* renamed from: b  reason: collision with root package name */
    public final i f14295b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14296c;

    /* renamed from: d  reason: collision with root package name */
    public final d f14297d;

    /* renamed from: e  reason: collision with root package name */
    public final String f14298e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f14299f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f14300g;

    public r(Drawable drawable, i iVar, int i10, d dVar, String str, boolean z10, boolean z11) {
        super(0);
        this.f14294a = drawable;
        this.f14295b = iVar;
        this.f14296c = i10;
        this.f14297d = dVar;
        this.f14298e = str;
        this.f14299f = z10;
        this.f14300g = z11;
    }

    public final i a() {
        return this.f14295b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (j.a(this.f14294a, rVar.f14294a)) {
                if (!j.a(this.f14295b, rVar.f14295b) || this.f14296c != rVar.f14296c || !j.a(this.f14297d, rVar.f14297d) || !j.a(this.f14298e, rVar.f14298e) || this.f14299f != rVar.f14299f || this.f14300g != rVar.f14300g) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int a10 = (i.a(this.f14296c) + ((this.f14295b.hashCode() + (this.f14294a.hashCode() * 31)) * 31)) * 31;
        int i10 = 0;
        d dVar = this.f14297d;
        int hashCode = (a10 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        String str = this.f14298e;
        if (str != null) {
            i10 = str.hashCode();
        }
        int i11 = 1237;
        int i12 = (((hashCode + i10) * 31) + (this.f14299f ? 1231 : 1237)) * 31;
        if (this.f14300g) {
            i11 = 1231;
        }
        return i12 + i11;
    }
}

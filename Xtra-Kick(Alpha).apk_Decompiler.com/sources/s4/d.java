package s4;

import android.graphics.drawable.Drawable;
import xa.j;

public final class d extends j {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f14218a;

    /* renamed from: b  reason: collision with root package name */
    public final i f14219b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f14220c;

    public d(Drawable drawable, i iVar, Throwable th) {
        super(0);
        this.f14218a = drawable;
        this.f14219b = iVar;
        this.f14220c = th;
    }

    public final i a() {
        return this.f14219b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (j.a(this.f14218a, dVar.f14218a)) {
                if (!j.a(this.f14219b, dVar.f14219b) || !j.a(this.f14220c, dVar.f14220c)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Drawable drawable = this.f14218a;
        int hashCode = drawable != null ? drawable.hashCode() : 0;
        return this.f14220c.hashCode() + ((this.f14219b.hashCode() + (hashCode * 31)) * 31);
    }
}

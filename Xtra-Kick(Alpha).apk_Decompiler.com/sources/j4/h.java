package j4;

import android.graphics.drawable.Drawable;
import xa.j;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f8756a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f8757b;

    public h(Drawable drawable, boolean z10) {
        this.f8756a = drawable;
        this.f8757b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return j.a(this.f8756a, hVar.f8756a) && this.f8757b == hVar.f8757b;
        }
    }

    public final int hashCode() {
        return (this.f8756a.hashCode() * 31) + (this.f8757b ? 1231 : 1237);
    }
}

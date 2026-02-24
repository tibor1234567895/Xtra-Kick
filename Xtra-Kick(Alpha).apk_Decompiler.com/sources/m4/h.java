package m4;

import android.graphics.drawable.Drawable;
import s.i;
import xa.j;

public final class h extends i {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f10575a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10576b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10577c;

    public h(Drawable drawable, boolean z10, int i10) {
        super(0);
        this.f10575a = drawable;
        this.f10576b = z10;
        this.f10577c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return j.a(this.f10575a, hVar.f10575a) && this.f10576b == hVar.f10576b && this.f10577c == hVar.f10577c;
        }
    }

    public final int hashCode() {
        return i.a(this.f10577c) + (((this.f10575a.hashCode() * 31) + (this.f10576b ? 1231 : 1237)) * 31);
    }
}

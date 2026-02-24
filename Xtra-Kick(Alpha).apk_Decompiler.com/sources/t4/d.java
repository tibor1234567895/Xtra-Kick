package t4;

import android.content.Context;
import android.util.DisplayMetrics;
import i4.q;
import xa.j;

public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    public final Context f14544a;

    public d(Context context) {
        this.f14544a = context;
    }

    public final Object a(q qVar) {
        DisplayMetrics displayMetrics = this.f14544a.getResources().getDisplayMetrics();
        a aVar = new a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new g(aVar, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            if (j.a(this.f14544a, ((d) obj).f14544a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f14544a.hashCode();
    }
}

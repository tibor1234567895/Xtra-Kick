package b5;

import java.security.MessageDigest;
import w5.b;

public final class n implements j {

    /* renamed from: b  reason: collision with root package name */
    public final b f2635b = new b();

    public final void b(MessageDigest messageDigest) {
        int i10 = 0;
        while (true) {
            b bVar = this.f2635b;
            if (i10 < bVar.f13081j) {
                m mVar = (m) bVar.h(i10);
                Object l10 = this.f2635b.l(i10);
                l lVar = mVar.f2632b;
                if (mVar.f2634d == null) {
                    mVar.f2634d = mVar.f2633c.getBytes(j.f2629a);
                }
                lVar.a(mVar.f2634d, l10, messageDigest);
                i10++;
            } else {
                return;
            }
        }
    }

    public final Object c(m mVar) {
        b bVar = this.f2635b;
        if (bVar.containsKey(mVar)) {
            return bVar.getOrDefault(mVar, (Object) null);
        }
        return mVar.f2631a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f2635b.equals(((n) obj).f2635b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2635b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f2635b + '}';
    }
}

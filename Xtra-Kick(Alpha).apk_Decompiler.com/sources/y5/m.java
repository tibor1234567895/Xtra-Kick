package y5;

import android.content.Context;
import com.bumptech.glide.c;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.u;
import com.bumptech.glide.q;
import com.bumptech.glide.s;
import s5.f;

public final class m extends s {
    public m(c cVar, l lVar, u uVar, Context context) {
        super(cVar, lVar, uVar, context);
    }

    public final q l(Class cls) {
        return new l(this.f3308h, this, cls, this.f3309i);
    }

    public final q m() {
        return (l) super.m();
    }

    public final q n() {
        return (l) super.n();
    }

    public final q p(String str) {
        return (l) super.p(str);
    }

    public final void s(f fVar) {
        if (!(fVar instanceof k)) {
            fVar = new k().a(fVar);
        }
        synchronized (this) {
            this.f3317q = (f) ((f) fVar.clone()).b();
        }
    }
}

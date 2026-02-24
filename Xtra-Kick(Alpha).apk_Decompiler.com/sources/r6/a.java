package r6;

import android.app.Activity;
import androidx.lifecycle.b2;
import g.o;
import ha.d;
import ja.b;

public abstract class a extends androidx.appcompat.app.a implements b {
    public volatile dagger.hilt.android.internal.managers.b E;
    public final Object F = new Object();
    public boolean G = false;

    public a() {
        p(new o(this, 1));
    }

    public final Object c() {
        if (this.E == null) {
            synchronized (this.F) {
                if (this.E == null) {
                    this.E = new dagger.hilt.android.internal.managers.b((Activity) this);
                }
            }
        }
        return this.E.c();
    }

    public final b2 h() {
        return d.a(this, super.h());
    }
}

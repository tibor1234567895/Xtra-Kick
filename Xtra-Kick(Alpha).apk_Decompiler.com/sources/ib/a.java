package ib;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.u1;
import hb.h0;
import hb.l;
import hb.p0;
import hb.x1;
import java.util.concurrent.CancellationException;
import mb.u;
import nb.e;
import pa.k;
import q0.f;
import xa.j;

public final class a extends b {
    private volatile a _immediate;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f8373j;

    /* renamed from: k  reason: collision with root package name */
    public final String f8374k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f8375l;

    /* renamed from: m  reason: collision with root package name */
    public final a f8376m;

    public a(Handler handler) {
        this(handler, (String) null, false);
    }

    public final void M0(k kVar, Runnable runnable) {
        if (!this.f8373j.post(runnable)) {
            R0(kVar, runnable);
        }
    }

    public final boolean O0(k kVar) {
        return !this.f8375l || !j.a(Looper.myLooper(), this.f8373j.getLooper());
    }

    public final x1 Q0() {
        return this.f8376m;
    }

    public final void R0(k kVar, Runnable runnable) {
        h0.w(kVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        p0.f7834b.M0(kVar, runnable);
    }

    public final void W(long j10, l lVar) {
        android.support.v4.media.j jVar = new android.support.v4.media.j((Object) lVar, (Object) this, 12);
        if (j10 > 4611686018427387903L) {
            j10 = 4611686018427387903L;
        }
        if (this.f8373j.postDelayed(jVar, j10)) {
            lVar.j(new u1(this, 23, jVar));
        } else {
            R0(lVar.f7822l, jVar);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f8373j == this.f8373j;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f8373j);
    }

    public final String toString() {
        String str;
        x1 x1Var;
        e eVar = p0.f7833a;
        x1 x1Var2 = u.f10886a;
        if (this == x1Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                x1Var = x1Var2.Q0();
            } catch (UnsupportedOperationException unused) {
                x1Var = null;
            }
            if (this == x1Var) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str != null) {
            return str;
        }
        String str2 = this.f8374k;
        if (str2 == null) {
            str2 = this.f8373j.toString();
        }
        if (this.f8375l) {
            return f.g(str2, ".immediate");
        }
        return str2;
    }

    public a(Handler handler, String str, boolean z10) {
        super(0);
        this.f8373j = handler;
        this.f8374k = str;
        this.f8375l = z10;
        this._immediate = z10 ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
        }
        this.f8376m = aVar;
    }
}

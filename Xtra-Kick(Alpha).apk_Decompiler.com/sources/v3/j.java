package v3;

import android.content.Context;
import androidx.lifecycle.p1;
import la.f;
import la.o;
import la.t;
import u3.c;
import u3.h;
import u3.l;

public final class j implements l {

    /* renamed from: h  reason: collision with root package name */
    public final Context f15916h;

    /* renamed from: i  reason: collision with root package name */
    public final String f15917i;

    /* renamed from: j  reason: collision with root package name */
    public final h f15918j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f15919k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f15920l;

    /* renamed from: m  reason: collision with root package name */
    public final o f15921m = f.b(new p1(6, this));

    /* renamed from: n  reason: collision with root package name */
    public boolean f15922n;

    static {
        new e(0);
    }

    public j(Context context, String str, h hVar, boolean z10, boolean z11) {
        xa.j.f("context", context);
        xa.j.f("callback", hVar);
        this.f15916h = context;
        this.f15917i = str;
        this.f15918j = hVar;
        this.f15919k = z10;
        this.f15920l = z11;
    }

    public final void close() {
        boolean z10;
        if (this.f15921m.f9807i != t.f9813a) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((i) this.f15921m.getValue()).close();
        }
    }

    public final void setWriteAheadLoggingEnabled(boolean z10) {
        boolean z11;
        if (this.f15921m.f9807i != t.f9813a) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i iVar = (i) this.f15921m.getValue();
            int i10 = c.f15348a;
            xa.j.f("sQLiteOpenHelper", iVar);
            iVar.setWriteAheadLoggingEnabled(z10);
        }
        this.f15922n = z10;
    }

    public final u3.f x0() {
        return ((i) this.f15921m.getValue()).c(true);
    }
}

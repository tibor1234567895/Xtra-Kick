package k4;

import androidx.fragment.app.k;
import dc.n0;
import dc.s;
import java.io.IOException;
import wa.l;

public final class j extends s {

    /* renamed from: i  reason: collision with root package name */
    public final l f9116i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f9117j;

    public j(n0 n0Var, k kVar) {
        super(n0Var);
        this.f9116i = kVar;
    }

    public final void close() {
        try {
            super.close();
        } catch (IOException e10) {
            this.f9117j = true;
            this.f9116i.invoke(e10);
        }
    }

    public final void flush() {
        try {
            super.flush();
        } catch (IOException e10) {
            this.f9117j = true;
            this.f9116i.invoke(e10);
        }
    }

    public final void o0(dc.j jVar, long j10) {
        if (this.f9117j) {
            jVar.a(j10);
            return;
        }
        try {
            super.o0(jVar, j10);
        } catch (IOException e10) {
            this.f9117j = true;
            this.f9116i.invoke(e10);
        }
    }
}

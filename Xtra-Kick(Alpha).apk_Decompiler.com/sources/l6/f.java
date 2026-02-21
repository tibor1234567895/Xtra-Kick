package l6;

import android.os.Bundle;
import androidx.fragment.app.c0;
import androidx.fragment.app.k;
import androidx.fragment.app.z1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.ui.main.MainViewModel;
import hb.h0;
import l3.j;
import xa.v;

public abstract class f extends c0 {

    /* renamed from: d0  reason: collision with root package name */
    public final x1 f9594d0 = h0.K(this, v.a(MainViewModel.class), new z1(6, this), new j((Object) null, 3, this), new z1(7, this));

    /* renamed from: e0  reason: collision with root package name */
    public boolean f9595e0 = true;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f9596f0;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f9597g0;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f9598h0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f9599i0;

    static {
        new e(0);
    }

    public void N(Bundle bundle) {
        super.N(bundle);
        if (l0()) {
            this.f9596f0 = bundle != null ? bundle.getBoolean("last") : h0.X0(f0());
            boolean z10 = false;
            this.f9597g0 = bundle != null ? bundle.getBoolean("restore") : false;
            if (bundle != null) {
                z10 = bundle.getBoolean("created");
            }
            this.f9599i0 = z10;
        }
    }

    public void Q() {
        this.K = true;
        if (l0()) {
            this.f9598h0 = false;
        }
    }

    public final void V() {
        this.K = true;
        if (l0()) {
            if (!this.f9598h0) {
                if (this.f9599i0 || this.f9596f0) {
                    m0();
                    this.f9598h0 = true;
                    this.f9599i0 = true;
                }
                ((MainViewModel) this.f9594d0.getValue()).f3432d.f(C(), new v1(6, new k(10, this)));
            } else if (this.f9597g0 && this.f9596f0) {
                o0();
                this.f9597g0 = false;
            }
        } else if (!this.f9598h0) {
            m0();
        }
    }

    public void W(Bundle bundle) {
        if (l0()) {
            bundle.putBoolean("last", this.f9596f0);
            bundle.putBoolean("restore", this.f9597g0);
            bundle.putBoolean("created", this.f9599i0);
        }
    }

    public boolean l0() {
        return this.f9595e0;
    }

    public abstract void m0();

    public void n0() {
    }

    public abstract void o0();
}

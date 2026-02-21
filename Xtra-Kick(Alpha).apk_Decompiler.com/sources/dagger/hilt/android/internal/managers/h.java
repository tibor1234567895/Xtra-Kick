package dagger.hilt.android.internal.managers;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.c0;
import androidx.fragment.app.e0;
import androidx.fragment.app.f0;
import ja.a;
import ja.b;
import ja.c;
import y5.e;

public final class h implements b {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4734h = 1;

    /* renamed from: i  reason: collision with root package name */
    public volatile a f4735i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f4736j = new Object();

    /* renamed from: k  reason: collision with root package name */
    public final Object f4737k;

    public h(c0 c0Var) {
        this.f4737k = c0Var;
    }

    public static final Context b(l lVar) {
        Context context;
        while (true) {
            boolean z10 = context instanceof ContextWrapper;
            context = lVar;
            if (!z10 || (context instanceof Activity)) {
                return context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    private Object d() {
        if (this.f4735i == null) {
            synchronized (this.f4736j) {
                if (this.f4735i == null) {
                    this.f4735i = (a) a();
                }
            }
        }
        return this.f4735i;
    }

    public final Object a() {
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        c0 c0Var = (c0) this.f4737k;
        e0 e0Var = c0Var.A;
        f0 f0Var4 = null;
        if (e0Var == null) {
            f0Var = null;
        } else {
            f0Var = e0Var.f1406l;
        }
        if (f0Var != null) {
            if (e0Var == null) {
                f0Var2 = null;
            } else {
                f0Var2 = e0Var.f1406l;
            }
            boolean z10 = f0Var2 instanceof b;
            Object[] objArr = new Object[1];
            if (e0Var == null) {
                f0Var3 = null;
            } else {
                f0Var3 = e0Var.f1406l;
            }
            objArr[0] = f0Var3.getClass();
            c.a(z10, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", objArr);
            e0 e0Var2 = c0Var.A;
            if (e0Var2 != null) {
                f0Var4 = e0Var2.f1406l;
            }
            y5.a aVar = ((y5.a) ((i) ba.a.a(i.class, f0Var4))).f16966c;
            c0Var.getClass();
            return new e(aVar);
        }
        throw new NullPointerException("Hilt Fragments must be attached before creating the component.");
    }

    public final Object c() {
        switch (this.f4734h) {
            case 0:
                if (this.f4735i == null) {
                    synchronized (this.f4736j) {
                        if (this.f4735i == null) {
                            this.f4735i = (a) ((b4.e0) this.f4737k).i();
                        }
                    }
                }
                return this.f4735i;
            default:
                return d();
        }
    }

    public h(b4.e0 e0Var) {
        this.f4737k = e0Var;
    }
}

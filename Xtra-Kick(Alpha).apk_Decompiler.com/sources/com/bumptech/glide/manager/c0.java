package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.a;
import androidx.fragment.app.c1;
import com.bumptech.glide.c;
import java.util.HashMap;
import java.util.HashSet;

public class c0 extends androidx.fragment.app.c0 {

    /* renamed from: d0  reason: collision with root package name */
    public final a f3259d0;

    /* renamed from: e0  reason: collision with root package name */
    public final HashSet f3260e0 = new HashSet();

    /* renamed from: f0  reason: collision with root package name */
    public c0 f3261f0;

    /* renamed from: g0  reason: collision with root package name */
    public androidx.fragment.app.c0 f3262g0;

    public c0() {
        a aVar = new a();
        this.f3259d0 = aVar;
    }

    public final void M(Context context) {
        super.M(context);
        androidx.fragment.app.c0 c0Var = this;
        while (true) {
            androidx.fragment.app.c0 c0Var2 = c0Var.C;
            if (c0Var2 == null) {
                break;
            }
            c0Var = c0Var2;
        }
        c1 c1Var = c0Var.f1370z;
        if (c1Var != null) {
            try {
                l0(v(), c1Var);
            } catch (IllegalStateException e10) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e10);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    public final void P() {
        this.K = true;
        this.f3259d0.a();
        c0 c0Var = this.f3261f0;
        if (c0Var != null) {
            c0Var.f3260e0.remove(this);
            this.f3261f0 = null;
        }
    }

    public final void R() {
        this.K = true;
        this.f3262g0 = null;
        c0 c0Var = this.f3261f0;
        if (c0Var != null) {
            c0Var.f3260e0.remove(this);
            this.f3261f0 = null;
        }
    }

    public final void X() {
        this.K = true;
        this.f3259d0.b();
    }

    public final void Y() {
        this.K = true;
        this.f3259d0.d();
    }

    public final void l0(Context context, c1 c1Var) {
        c0 c0Var = this.f3261f0;
        if (c0Var != null) {
            c0Var.f3260e0.remove(this);
            this.f3261f0 = null;
        }
        t tVar = c.a(context).f3168l;
        HashMap hashMap = tVar.f3279j;
        c0 c0Var2 = (c0) hashMap.get(c1Var);
        if (c0Var2 == null) {
            c0 c0Var3 = (c0) c1Var.E("com.bumptech.glide.manager");
            if (c0Var3 == null) {
                c0Var3 = new c0();
                c0Var3.f3262g0 = null;
                hashMap.put(c1Var, c0Var3);
                a aVar = new a(c1Var);
                aVar.d(0, c0Var3, "com.bumptech.glide.manager", 1);
                aVar.h(true);
                tVar.f3280k.obtainMessage(2, c1Var).sendToTarget();
            }
            c0Var2 = c0Var3;
        }
        this.f3261f0 = c0Var2;
        if (!equals(c0Var2)) {
            this.f3261f0.f3260e0.add(this);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("{parent=");
        androidx.fragment.app.c0 c0Var = this.C;
        if (c0Var == null) {
            c0Var = this.f3262g0;
        }
        sb2.append(c0Var);
        sb2.append("}");
        return sb2.toString();
    }
}

package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.fragment.app.c1;
import androidx.lifecycle.g0;
import com.bumptech.glide.c;
import com.bumptech.glide.s;
import java.util.HashMap;
import java.util.Map;
import w5.h;
import w5.p;

public final class o implements u, h {

    /* renamed from: h  reason: collision with root package name */
    public final Object f3268h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f3269i;

    public o(s sVar) {
        this.f3268h = new HashMap();
        this.f3269i = sVar;
    }

    public final s a(Context context, c cVar, g0 g0Var, c1 c1Var, boolean z10) {
        p.a();
        p.a();
        Object obj = this.f3268h;
        s sVar = (s) ((Map) obj).get(g0Var);
        if (sVar != null) {
            return sVar;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(g0Var);
        s a10 = ((s) this.f3269i).a(cVar, lifecycleLifecycle, new o(this, c1Var), context);
        ((Map) obj).put(g0Var, a10);
        lifecycleLifecycle.c(new n(this, g0Var));
        if (z10) {
            a10.j();
        }
        return a10;
    }

    public final Object get() {
        return (ConnectivityManager) ((Context) this.f3268h).getSystemService("connectivity");
    }

    public /* synthetic */ o(Object obj, Object obj2) {
        this.f3269i = obj;
        this.f3268h = obj2;
    }
}

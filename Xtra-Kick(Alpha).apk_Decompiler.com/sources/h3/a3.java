package h3;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import e1.c0;
import e1.d0;
import j1.v;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a3 extends t {

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f6915d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f6916e;

    /* renamed from: f  reason: collision with root package name */
    public final d0 f6917f;

    /* renamed from: g  reason: collision with root package name */
    public final Set f6918g = Collections.synchronizedSet(new HashSet());

    public a3(b3 b3Var) {
        this.f6915d = new WeakReference(b3Var);
        Context applicationContext = b3Var.getApplicationContext();
        this.f6916e = new Handler(applicationContext.getMainLooper());
        this.f6917f = d0.a(applicationContext);
    }

    public final void r(o oVar, Bundle bundle) {
        if (oVar != null && bundle != null) {
            try {
                h hVar = (h) h.f7058r.e(bundle);
                if (this.f6915d.get() == null) {
                    try {
                        oVar.g(0);
                    } catch (RemoteException unused) {
                    }
                } else {
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    if (callingPid == 0) {
                        callingPid = hVar.f7062k;
                    }
                    int i10 = callingPid;
                    c0 c0Var = new c0(hVar.f7061j, i10, callingUid);
                    boolean b10 = this.f6917f.b(c0Var);
                    this.f6918g.add(oVar);
                    try {
                        this.f6916e.post(new z2(this, oVar, c0Var, hVar, b10, i10, callingUid));
                    } finally {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            } catch (RuntimeException e10) {
                v.h("MSSImpl", "Ignoring malformed Bundle for ConnectionRequest", e10);
            }
        }
    }
}

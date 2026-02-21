package j3;

import android.app.Application;
import android.content.Context;
import android.support.v4.media.session.u;
import androidx.lifecycle.b2;
import androidx.lifecycle.h2;
import androidx.lifecycle.s;
import androidx.lifecycle.s1;
import wa.a;
import xa.k;

public final class q extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8654h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r f8655i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(r rVar, int i10) {
        super(0);
        this.f8654h = i10;
        this.f8655i = rVar;
    }

    public final Object b() {
        boolean z10;
        Context context;
        int i10 = this.f8654h;
        r rVar = this.f8655i;
        switch (i10) {
            case 0:
                Context context2 = rVar.f8660h;
                Application application = null;
                if (context2 != null) {
                    context = context2.getApplicationContext();
                } else {
                    context = null;
                }
                if (context instanceof Application) {
                    application = (Application) context;
                }
                return new s1(application, rVar, rVar.b());
            default:
                if (rVar.f8669q) {
                    if (rVar.f8667o.f1688d != s.DESTROYED) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        return ((p) new u((h2) rVar, (b2) new o(rVar)).q(p.class)).f8650d;
                    }
                    throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
                }
                throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        }
    }
}

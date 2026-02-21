package e1;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.h;
import android.util.Log;
import java.util.List;
import q.e;

public final class f extends v {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j f4900d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f4901e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Bundle f4902f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Bundle f4903g = null;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ a0 f4904h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(a0 a0Var, String str, j jVar, String str2, Bundle bundle) {
        super(str);
        this.f4904h = a0Var;
        this.f4900d = jVar;
        this.f4901e = str2;
        this.f4902f = bundle;
    }

    public final void b() {
        String str = this.f4901e;
        e eVar = this.f4904h.f4890k;
        j jVar = this.f4900d;
        if (eVar.getOrDefault(jVar.f4920e.a(), (Object) null) != jVar) {
            int i10 = a0.f4886o;
            return;
        }
        int i11 = this.f4944c & 1;
        Bundle bundle = this.f4902f;
        if (i11 != 0) {
            int i12 = a0.f4886o;
        }
        try {
            jVar.f4920e.e(str, (List) null, bundle, this.f4903g);
        } catch (RemoteException unused) {
            StringBuilder s10 = h.s("Calling onLoadChildren() failed for id=", str, " package=");
            s10.append(jVar.f4916a);
            Log.w("MBServiceCompat", s10.toString());
        }
    }
}

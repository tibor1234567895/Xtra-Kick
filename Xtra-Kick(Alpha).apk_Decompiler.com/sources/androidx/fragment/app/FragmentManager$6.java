package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import androidx.lifecycle.t;

class FragmentManager$6 implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1315h = "integrity";

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j1 f1316i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ t f1317j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ c1 f1318k;

    public FragmentManager$6(c1 c1Var, j1 j1Var, t tVar) {
        this.f1318k = c1Var;
        this.f1316i = j1Var;
        this.f1317j = tVar;
    }

    public final void d(d0 d0Var, r rVar) {
        Bundle bundle;
        r rVar2 = r.ON_START;
        c1 c1Var = this.f1318k;
        String str = this.f1315h;
        if (rVar == rVar2 && (bundle = (Bundle) c1Var.f1381k.get(str)) != null) {
            this.f1316i.j(bundle, str);
            c1Var.f1381k.remove(str);
            c1.I(2);
        }
        if (rVar == r.ON_DESTROY) {
            this.f1317j.c(this);
            c1Var.f1382l.remove(str);
        }
    }
}

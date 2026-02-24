package s6;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.b2;
import androidx.lifecycle.g2;
import wa.a;
import xa.j;
import xa.k;

public final class d extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14363h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f14364i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(ComponentActivity componentActivity, int i10) {
        super(0);
        this.f14363h = i10;
        this.f14364i = componentActivity;
    }

    public final Object b() {
        int i10 = this.f14363h;
        ComponentActivity componentActivity = this.f14364i;
        switch (i10) {
            case 0:
                b2 h10 = componentActivity.h();
                j.e("defaultViewModelProviderFactory", h10);
                return h10;
            default:
                g2 m10 = componentActivity.m();
                j.e("viewModelStore", m10);
                return m10;
        }
    }
}

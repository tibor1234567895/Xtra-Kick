package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.o1;

public final class v extends z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c0 f1590a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(c0 c0Var) {
        super(0);
        this.f1590a = c0Var;
    }

    public final void a() {
        c0 c0Var = this.f1590a;
        c0Var.Z.a();
        o1.b(c0Var);
        Bundle bundle = c0Var.f1353i;
        c0Var.Z.b(bundle != null ? bundle.getBundle("registryState") : null);
    }
}

package g7;

import android.os.Bundle;
import android.support.v4.media.h;
import androidx.fragment.app.c0;
import wa.a;
import xa.k;

public final class g extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6859h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c0 f6860i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i10, c0 c0Var) {
        super(0);
        this.f6859h = i10;
        this.f6860i = c0Var;
    }

    public final Object b() {
        int i10 = this.f6859h;
        c0 c0Var = this.f6860i;
        switch (i10) {
            case 2:
                Bundle bundle = c0Var.f1357m;
                if (bundle != null) {
                    return bundle;
                }
                throw new IllegalStateException(h.l("Fragment ", c0Var, " has null arguments"));
            case 3:
            case 4:
            case Constants.MAX_COMPATIBILITY_VERSION:
            case 6:
            case 7:
                return c0Var;
            default:
                return c0Var;
        }
    }
}

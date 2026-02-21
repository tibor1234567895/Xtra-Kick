package androidx.fragment.app;

import android.os.Bundle;
import android.support.v4.media.h;
import androidx.lifecycle.b2;
import androidx.lifecycle.g2;
import wa.a;
import xa.j;
import xa.k;

public final class z1 extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1621h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c0 f1622i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z1(int i10, c0 c0Var) {
        super(0);
        this.f1621h = i10;
        this.f1622i = c0Var;
    }

    public final Bundle a() {
        int i10 = this.f1621h;
        c0 c0Var = this.f1622i;
        switch (i10) {
            case 1:
                Bundle bundle = c0Var.f1357m;
                if (bundle != null) {
                    return bundle;
                }
                throw new IllegalStateException(h.l("Fragment ", c0Var, " has null arguments"));
            case 4:
                Bundle bundle2 = c0Var.f1357m;
                if (bundle2 != null) {
                    return bundle2;
                }
                throw new IllegalStateException(h.l("Fragment ", c0Var, " has null arguments"));
            case 12:
                Bundle bundle3 = c0Var.f1357m;
                if (bundle3 != null) {
                    return bundle3;
                }
                throw new IllegalStateException(h.l("Fragment ", c0Var, " has null arguments"));
            case 14:
                Bundle bundle4 = c0Var.f1357m;
                if (bundle4 != null) {
                    return bundle4;
                }
                throw new IllegalStateException(h.l("Fragment ", c0Var, " has null arguments"));
            case Constants.IV_SIZE /*16*/:
                Bundle bundle5 = c0Var.f1357m;
                if (bundle5 != null) {
                    return bundle5;
                }
                throw new IllegalStateException(h.l("Fragment ", c0Var, " has null arguments"));
            default:
                Bundle bundle6 = c0Var.f1357m;
                if (bundle6 != null) {
                    return bundle6;
                }
                throw new IllegalStateException(h.l("Fragment ", c0Var, " has null arguments"));
        }
    }

    public final Object b() {
        int i10 = this.f1621h;
        c0 c0Var = this.f1622i;
        switch (i10) {
            case 0:
                return c();
            case 1:
                return a();
            case 2:
            case 3:
                return c0Var;
            case 4:
                return a();
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                return c0Var;
            case 6:
                g2 m10 = c0Var.d0().m();
                j.e("requireActivity().viewModelStore", m10);
                return m10;
            case 7:
                return c();
            case 8:
            case 9:
            case 10:
            case 11:
                return c0Var;
            case 12:
                return a();
            case 13:
                return c0Var;
            case 14:
                return a();
            case 15:
                return c0Var;
            case Constants.IV_SIZE /*16*/:
                return a();
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                return c0Var;
            case 28:
                return a();
            default:
                return c0Var;
        }
    }

    public final b2 c() {
        int i10 = this.f1621h;
        c0 c0Var = this.f1622i;
        switch (i10) {
            case 0:
                b2 h10 = c0Var.h();
                j.e("defaultViewModelProviderFactory", h10);
                return h10;
            default:
                b2 h11 = c0Var.d0().h();
                j.e("requireActivity().defaultViewModelProviderFactory", h11);
                return h11;
        }
    }
}

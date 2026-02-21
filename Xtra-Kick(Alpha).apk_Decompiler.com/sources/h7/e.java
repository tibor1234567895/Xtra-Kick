package h7;

import a6.b0;
import a6.c0;
import a6.n;
import a6.y;
import com.github.andreyasadchy.xtra.ui.settings.SettingsViewModel;
import hb.f0;
import hb.h0;
import la.v;
import r3.n0;
import ra.i;
import u3.o;
import wa.p;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SettingsViewModel f7713i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(SettingsViewModel settingsViewModel, pa.e eVar) {
        super(2, eVar);
        this.f7713i = settingsViewModel;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f7713i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        SettingsViewModel settingsViewModel = this.f7713i;
        y yVar = (y) settingsViewModel.f3499d;
        n0 n0Var = yVar.f265a;
        n0Var.b();
        n nVar = yVar.f267c;
        o c10 = nVar.c();
        n0Var.c();
        try {
            c10.x();
            n0Var.r();
            n0Var.g();
            nVar.g(c10);
            c0 c0Var = (c0) settingsViewModel.f3500e;
            n0 n0Var2 = c0Var.f221a;
            n0Var2.b();
            b0 b0Var = c0Var.f226f;
            o c11 = b0Var.c();
            n0Var2.c();
            try {
                c11.x();
                n0Var2.r();
                n0Var2.g();
                b0Var.g(c11);
                return v.f9814a;
            } catch (Throwable th) {
                n0Var2.g();
                b0Var.g(c11);
                throw th;
            }
        } catch (Throwable th2) {
            n0Var.g();
            nVar.g(c10);
            throw th2;
        }
    }
}

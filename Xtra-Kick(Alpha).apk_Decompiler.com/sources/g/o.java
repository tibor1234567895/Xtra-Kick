package g;

import androidx.appcompat.app.a;
import com.github.andreyasadchy.xtra.ui.login.LoginActivity;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity;
import d.b;
import h7.d;
import s6.e;

public final class o implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6184a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f6185b;

    public /* synthetic */ o(a aVar, int i10) {
        this.f6184a = i10;
        this.f6185b = aVar;
    }

    public final void a() {
        int i10 = this.f6184a;
        a aVar = this.f6185b;
        switch (i10) {
            case 0:
                t D = aVar.D();
                D.k();
                aVar.f451l.f14540b.a("androidx:appcompat");
                D.p();
                return;
            case 1:
                r6.a aVar2 = (r6.a) aVar;
                if (!aVar2.G) {
                    aVar2.G = true;
                    LoginActivity loginActivity = (LoginActivity) aVar2;
                    ((r6.b) aVar2.c()).getClass();
                    return;
                }
                return;
            case 2:
                s6.a aVar3 = (s6.a) aVar;
                if (!aVar3.G) {
                    aVar3.G = true;
                    MainActivity mainActivity = (MainActivity) aVar3;
                    ((e) aVar3.c()).getClass();
                    return;
                }
                return;
            default:
                h7.a aVar4 = (h7.a) aVar;
                if (!aVar4.G) {
                    aVar4.G = true;
                    SettingsActivity settingsActivity = (SettingsActivity) aVar4;
                    ((d) aVar4.c()).getClass();
                    return;
                }
                return;
        }
    }
}

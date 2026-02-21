package h7;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.a;
import androidx.fragment.app.e0;
import androidx.preference.Preference;
import c0.g;
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity;
import com.github.andreyasadchy.xtra.ui.settings.SettingsViewModel;
import com.woxthebox.draglistview.R;
import hb.d1;
import hb.h0;
import java.io.Serializable;
import o3.s;
import o3.t;
import pa.e;
import pa.h;
import xa.j;

public final /* synthetic */ class b implements s, t {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7708h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SettingsActivity.d f7709i;

    public /* synthetic */ b(SettingsActivity.d dVar, int i10) {
        this.f7708h = i10;
        this.f7709i = dVar;
    }

    public final void a(Preference preference) {
        int i10 = this.f7708h;
        SettingsActivity.d dVar = this.f7709i;
        switch (i10) {
            case 1:
                int i11 = SettingsActivity.d.f3494s0;
                j.f("this$0", dVar);
                j.f("it", preference);
                a aVar = new a(dVar.x());
                aVar.e(R.id.settings, new SettingsActivity.e(), (String) null);
                aVar.c((String) null);
                aVar.g();
                return;
            case 2:
                int i12 = SettingsActivity.d.f3494s0;
                j.f("this$0", dVar);
                j.f("it", preference);
                a aVar2 = new a(dVar.x());
                aVar2.e(R.id.settings, new SettingsActivity.b(), (String) null);
                aVar2.c((String) null);
                aVar2.g();
                return;
            case 3:
                int i13 = SettingsActivity.d.f3494s0;
                j.f("this$0", dVar);
                j.f("it", preference);
                a aVar3 = new a(dVar.x());
                aVar3.e(R.id.settings, new SettingsActivity.c(), (String) null);
                aVar3.c((String) null);
                aVar3.g();
                return;
            case 4:
                int i14 = SettingsActivity.d.f3494s0;
                j.f("this$0", dVar);
                j.f("it", preference);
                a aVar4 = new a(dVar.x());
                aVar4.e(R.id.settings, new SettingsActivity.a(), (String) null);
                aVar4.c((String) null);
                aVar4.g();
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                int i15 = SettingsActivity.d.f3494s0;
                j.f("this$0", dVar);
                j.f("it", preference);
                h0.b1(d1.f7786h, (h) null, 0, new e((SettingsViewModel) dVar.f3495q0.getValue(), (e) null), 3);
                h0.C1(dVar.f0(), R.string.cleared);
                return;
            default:
                int i16 = SettingsActivity.d.f3494s0;
                j.f("this$0", dVar);
                j.f("it", preference);
                Intent component = new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.DeviceAdminSettings"));
                e0 e0Var = dVar.A;
                if (e0Var != null) {
                    Object obj = g.f2717a;
                    c0.a.b(e0Var.f1403i, component, (Bundle) null);
                    return;
                }
                throw new IllegalStateException("Fragment " + dVar + " not attached to Activity");
        }
    }

    public final void c(Preference preference, Serializable serializable) {
        int i10 = SettingsActivity.d.f3494s0;
        SettingsActivity.d dVar = this.f7709i;
        j.f("this$0", dVar);
        j.f("<anonymous parameter 0>", preference);
        if (!dVar.f3496r0) {
            dVar.f3496r0 = true;
            dVar.d0().setResult(-1);
        }
    }
}

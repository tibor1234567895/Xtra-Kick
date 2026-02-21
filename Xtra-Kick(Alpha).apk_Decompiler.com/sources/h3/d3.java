package h3;

import android.os.Bundle;
import android.os.Handler;
import androidx.emoji2.text.r;
import androidx.fragment.app.f0;
import androidx.preference.Preference;
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity;
import d9.i2;
import g1.v1;
import g1.w1;
import g1.x1;
import g1.y1;
import h9.a0;
import h9.e0;
import h9.k0;
import h9.p;
import j1.a;
import j1.h;
import j1.l0;
import java.io.Serializable;
import java.util.List;
import o3.s;
import xa.j;

public final /* synthetic */ class d3 implements h, r3, p, s {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6982h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f6983i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f6984j;

    public /* synthetic */ d3(Object obj, int i10, Object obj2) {
        this.f6982h = i10;
        this.f6983i = obj;
        this.f6984j = obj2;
    }

    public final e0 apply(Object obj) {
        n2 n2Var = (n2) this.f6983i;
        Handler handler = n2Var.f7239l;
        r rVar = new r(n2Var, (q3) this.f6984j, (f2) obj, 15);
        j4 j4Var = new j4(0);
        k0 n10 = k0.n();
        l0.L(handler, new r(n10, rVar, j4Var, 5));
        return n10;
    }

    public final void b(Object obj) {
        s3 s3Var = (s3) this.f6983i;
        y1 y1Var = (y1) this.f6984j;
        a4 a4Var = (a4) obj;
        s3Var.getClass();
        if (!y1Var.F.isEmpty()) {
            x1 c10 = y1Var.i().c();
            i2 g10 = y1Var.F.values().iterator();
            while (g10.hasNext()) {
                w1 w1Var = (w1) g10.next();
                v1 v1Var = (v1) s3Var.f7321h.f4655o.get(w1Var.f6686h.f6674i);
                if (v1Var == null || w1Var.f6686h.f6673h != v1Var.f6673h) {
                    c10.a(w1Var);
                } else {
                    c10.a(new w1(v1Var, (List) w1Var.f6687i));
                }
            }
            y1Var = c10.b();
        }
        a4Var.r(y1Var);
    }

    public final void c(Preference preference, Serializable serializable) {
        SettingsActivity.d dVar = (SettingsActivity.d) this.f6983i;
        f0 f0Var = (f0) this.f6984j;
        int i10 = SettingsActivity.d.f3494s0;
        j.f("this$0", dVar);
        j.f("$activity", f0Var);
        j.f("<anonymous parameter 0>", preference);
        dVar.f3496r0 = true;
        f0Var.recreate();
    }

    public final Object h(n2 n2Var, e2 e2Var, int i10) {
        int i11 = this.f6982h;
        Object obj = this.f6984j;
        Object obj2 = this.f6983i;
        switch (i11) {
            case 1:
                a0 g10 = n2Var.f7231d.g(n2Var.f7237j, e2Var, (f4) obj2, (Bundle) obj);
                a.d(g10, "onCustomCommandOnHandler must return non-null future");
                return g10;
            case 2:
                r3 r3Var = (r3) obj2;
                p3 p3Var = (p3) obj;
                if (n2Var.f()) {
                    return new a0(new j4(-100));
                }
                return l0.P((e0) r3Var.h(n2Var, e2Var, i10), new f0(n2Var, p3Var, e2Var, 4));
            default:
                r3 r3Var2 = (r3) obj2;
                q3 q3Var = (q3) obj;
                if (n2Var.f()) {
                    return new a0(new j4(-100));
                }
                return l0.P((e0) r3Var2.h(n2Var, e2Var, i10), new d3(n2Var, 4, q3Var));
        }
    }
}

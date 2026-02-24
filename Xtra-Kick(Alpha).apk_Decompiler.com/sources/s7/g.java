package s7;

import android.content.Context;
import androidx.fragment.app.c1;
import androidx.lifecycle.p1;
import com.woxthebox.draglistview.R;
import g.l;
import hb.h0;
import la.i;
import t6.d0;
import t6.u0;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f14374a = new g();

    private g() {
    }

    public static void a(c1 c1Var, String str, boolean z10) {
        d0.f14580w0.getClass();
        d0 d0Var = new d0();
        d0Var.j0(h0.r(new i("speed", str), new i("vod_games", Boolean.valueOf(z10))));
        d0Var.q0(c1Var, "closeOnPip");
    }

    public static void b(Context context, String str, p1 p1Var) {
        l lVar = new l(context);
        lVar.f6176a.f6086f = context.getString(R.string.unfollow, new Object[]{str});
        lVar.setPositiveButton(R.string.yes, new u0(p1Var, 2)).setNegativeButton(R.string.no, new h6.g(10)).c();
    }
}

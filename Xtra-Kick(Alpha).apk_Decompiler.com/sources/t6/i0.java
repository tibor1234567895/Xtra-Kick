package t6;

import android.content.Context;
import androidx.lifecycle.o0;
import androidx.lifecycle.w1;
import e6.x;
import e6.y0;
import hb.d1;
import hb.h0;
import java.util.Timer;
import pa.e;
import pa.h;
import xa.j;

public abstract class i0 extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f14603d;

    /* renamed from: e  reason: collision with root package name */
    public final y0 f14604e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14605f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14606g;

    /* renamed from: h  reason: collision with root package name */
    public a0 f14607h = a0.NORMAL;

    /* renamed from: i  reason: collision with root package name */
    public final o0 f14608i = new o0();

    /* renamed from: j  reason: collision with root package name */
    public final o0 f14609j = new o0();

    /* renamed from: k  reason: collision with root package name */
    public Timer f14610k;

    /* renamed from: l  reason: collision with root package name */
    public final o0 f14611l = new o0();

    /* renamed from: m  reason: collision with root package name */
    public long f14612m;

    public i0(x xVar, y0 y0Var) {
        j.f("repository", xVar);
        j.f("localFollowsChannel", y0Var);
        this.f14603d = xVar;
        this.f14604e = y0Var;
    }

    public final void b() {
        Timer timer = this.f14610k;
        if (timer != null) {
            timer.cancel();
        }
    }

    public final void d(Context context, int i10) {
        h0.b1(d1.f7786h, (h) null, 0, new e0(i10, this, context, (e) null), 3);
    }

    public final void e(int i10, Context context) {
        if (!this.f14609j.e()) {
            h0.b1(h0.I0(this), (h) null, 0, new f0(i10, this, (e) null), 3);
        }
    }

    public final void f(Context context, int i10, String str, String str2, String str3) {
        h0.b1(d1.f7786h, (h) null, 0, new g0(i10, context, str3, this, str, str2, (e) null), 3);
    }
}

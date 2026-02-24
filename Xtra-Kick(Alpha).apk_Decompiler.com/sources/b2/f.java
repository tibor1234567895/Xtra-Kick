package b2;

import android.os.Handler;
import android.os.Message;
import j1.l0;
import m1.p;
import s1.m;

public final class f implements Handler.Callback {

    /* renamed from: h  reason: collision with root package name */
    public final Handler f2431h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g f2432i;

    public f(g gVar, m mVar) {
        this.f2432i = gVar;
        Handler k10 = l0.k(this);
        this.f2431h = k10;
        mVar.e(this, k10);
    }

    public final void a(long j10) {
        g gVar = this.f2432i;
        if (this == gVar.f2453r1 && gVar.N != null) {
            if (j10 == Long.MAX_VALUE) {
                gVar.C0 = true;
                return;
            }
            try {
                gVar.p0(j10);
                gVar.y0();
                gVar.E0.f10235e++;
                gVar.x0();
                gVar.Y(j10);
            } catch (p e10) {
                gVar.D0 = e10;
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        int i10 = message.arg1;
        int i11 = message.arg2;
        int i12 = l0.f8453a;
        a(((((long) i10) & 4294967295L) << 32) | (4294967295L & ((long) i11)));
        return true;
    }
}

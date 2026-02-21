package m1;

import android.os.SystemClock;
import g1.e1;
import j1.d;
import j1.d0;
import j1.l0;

public final class q1 implements x0 {

    /* renamed from: h  reason: collision with root package name */
    public final d f10444h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10445i;

    /* renamed from: j  reason: collision with root package name */
    public long f10446j;

    /* renamed from: k  reason: collision with root package name */
    public long f10447k;

    /* renamed from: l  reason: collision with root package name */
    public e1 f10448l = e1.f6351k;

    public q1(d0 d0Var) {
        this.f10444h = d0Var;
    }

    public final long a() {
        long j10;
        long j11 = this.f10446j;
        if (!this.f10445i) {
            return j11;
        }
        ((d0) this.f10444h).getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f10447k;
        e1 e1Var = this.f10448l;
        if (e1Var.f6355h == 1.0f) {
            j10 = l0.H(elapsedRealtime);
        } else {
            j10 = elapsedRealtime * ((long) e1Var.f6357j);
        }
        return j11 + j10;
    }

    public final void b(long j10) {
        this.f10446j = j10;
        if (this.f10445i) {
            ((d0) this.f10444h).getClass();
            this.f10447k = SystemClock.elapsedRealtime();
        }
    }

    public final void c() {
        if (!this.f10445i) {
            ((d0) this.f10444h).getClass();
            this.f10447k = SystemClock.elapsedRealtime();
            this.f10445i = true;
        }
    }

    public final void d(e1 e1Var) {
        if (this.f10445i) {
            b(a());
        }
        this.f10448l = e1Var;
    }

    public final e1 i() {
        return this.f10448l;
    }
}

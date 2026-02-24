package hb;

import ma.l;

public abstract class s0 extends d0 {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ int f7843m = 0;

    /* renamed from: j  reason: collision with root package name */
    public long f7844j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7845k;

    /* renamed from: l  reason: collision with root package name */
    public l f7846l;

    public final void Q0(boolean z10) {
        long j10 = this.f7844j - (z10 ? 4294967296L : 1);
        this.f7844j = j10;
        if (j10 <= 0 && this.f7845k) {
            shutdown();
        }
    }

    public final void R0(o0 o0Var) {
        l lVar = this.f7846l;
        if (lVar == null) {
            lVar = new l();
            this.f7846l = lVar;
        }
        lVar.d(o0Var);
    }

    public final void S0(boolean z10) {
        this.f7844j = (z10 ? 4294967296L : 1) + this.f7844j;
        if (!z10) {
            this.f7845k = true;
        }
    }

    public final boolean T0() {
        return this.f7844j >= 4294967296L;
    }

    public long U0() {
        return !V0() ? Long.MAX_VALUE : 0;
    }

    public final boolean V0() {
        Object obj;
        l lVar = this.f7846l;
        if (lVar == null) {
            return false;
        }
        if (lVar.isEmpty()) {
            obj = null;
        } else {
            obj = lVar.j();
        }
        o0 o0Var = (o0) obj;
        if (o0Var == null) {
            return false;
        }
        o0Var.run();
        return true;
    }

    public void shutdown() {
    }
}

package m1;

import a2.e;
import j1.a;
import j1.l0;
import j1.v;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final e f10334a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10335b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10336c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10337d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10338e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10339f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f10340g;

    /* renamed from: h  reason: collision with root package name */
    public final long f10341h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10342i;

    /* renamed from: j  reason: collision with root package name */
    public int f10343j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10344k;

    public l() {
        this(new e(), 50000, 50000, 2500, 5000, -1);
    }

    public static void a(int i10, int i11, String str, String str2) {
        boolean z10 = i10 >= i11;
        a.a(str + " cannot be less than " + str2, z10);
    }

    public final void b(boolean z10) {
        int i10 = this.f10339f;
        if (i10 == -1) {
            i10 = 13107200;
        }
        this.f10343j = i10;
        this.f10344k = false;
        if (z10) {
            e eVar = this.f10334a;
            synchronized (eVar) {
                if (eVar.f22a) {
                    eVar.a(0);
                }
            }
        }
    }

    public final boolean c(long j10, float f10) {
        int i10;
        boolean z10;
        e eVar = this.f10334a;
        synchronized (eVar) {
            i10 = eVar.f25d * eVar.f23b;
        }
        boolean z11 = true;
        if (i10 >= this.f10343j) {
            z10 = true;
        } else {
            z10 = false;
        }
        long j11 = this.f10336c;
        long j12 = this.f10335b;
        if (f10 > 1.0f) {
            j12 = Math.min(l0.s(j12, f10), j11);
        }
        if (j10 < Math.max(j12, 500000)) {
            if (!this.f10340g && z10) {
                z11 = false;
            }
            this.f10344k = z11;
            if (!z11 && j10 < 500000) {
                v.g("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j10 >= j11 || z10) {
            this.f10344k = false;
        }
        return this.f10344k;
    }

    public l(e eVar, int i10, int i11, int i12, int i13, int i14) {
        a(i12, 0, "bufferForPlaybackMs", "0");
        a(i13, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i10, i12, "minBufferMs", "bufferForPlaybackMs");
        a(i10, i13, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i11, i10, "maxBufferMs", "minBufferMs");
        a(0, 0, "backBufferDurationMs", "0");
        this.f10334a = eVar;
        this.f10335b = l0.H((long) i10);
        this.f10336c = l0.H((long) i11);
        this.f10337d = l0.H((long) i12);
        this.f10338e = l0.H((long) i13);
        this.f10339f = i14;
        this.f10343j = i14 == -1 ? 13107200 : i14;
        this.f10340g = false;
        this.f10341h = l0.H((long) 0);
        this.f10342i = false;
    }
}

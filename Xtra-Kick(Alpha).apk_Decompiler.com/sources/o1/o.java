package o1;

import android.media.AudioTrack;
import j1.l0;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final n f11991a;

    /* renamed from: b  reason: collision with root package name */
    public int f11992b;

    /* renamed from: c  reason: collision with root package name */
    public long f11993c;

    /* renamed from: d  reason: collision with root package name */
    public long f11994d;

    /* renamed from: e  reason: collision with root package name */
    public long f11995e;

    /* renamed from: f  reason: collision with root package name */
    public long f11996f;

    public o(AudioTrack audioTrack) {
        if (l0.f8453a >= 19) {
            this.f11991a = new n(audioTrack);
            a();
            return;
        }
        this.f11991a = null;
        b(3);
    }

    public final void a() {
        if (this.f11991a != null) {
            b(0);
        }
    }

    public final void b(int i10) {
        this.f11992b = i10;
        long j10 = 10000;
        if (i10 == 0) {
            this.f11995e = 0;
            this.f11996f = -1;
            this.f11993c = System.nanoTime() / 1000;
        } else if (i10 != 1) {
            if (i10 == 2 || i10 == 3) {
                j10 = 10000000;
            } else if (i10 == 4) {
                j10 = 500000;
            } else {
                throw new IllegalStateException();
            }
        }
        this.f11994d = j10;
    }
}

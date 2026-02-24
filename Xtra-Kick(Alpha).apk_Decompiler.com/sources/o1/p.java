package o1;

import android.media.AudioTrack;
import android.os.SystemClock;
import j1.l0;
import java.lang.reflect.Method;

public final class p {
    public long A;
    public long B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public long G;

    /* renamed from: a  reason: collision with root package name */
    public final a0 f12004a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f12005b;

    /* renamed from: c  reason: collision with root package name */
    public AudioTrack f12006c;

    /* renamed from: d  reason: collision with root package name */
    public int f12007d;

    /* renamed from: e  reason: collision with root package name */
    public int f12008e;

    /* renamed from: f  reason: collision with root package name */
    public o f12009f;

    /* renamed from: g  reason: collision with root package name */
    public int f12010g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12011h;

    /* renamed from: i  reason: collision with root package name */
    public long f12012i;

    /* renamed from: j  reason: collision with root package name */
    public float f12013j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12014k;

    /* renamed from: l  reason: collision with root package name */
    public long f12015l;

    /* renamed from: m  reason: collision with root package name */
    public long f12016m;

    /* renamed from: n  reason: collision with root package name */
    public Method f12017n;

    /* renamed from: o  reason: collision with root package name */
    public long f12018o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f12019p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f12020q;

    /* renamed from: r  reason: collision with root package name */
    public long f12021r;

    /* renamed from: s  reason: collision with root package name */
    public long f12022s;

    /* renamed from: t  reason: collision with root package name */
    public long f12023t;

    /* renamed from: u  reason: collision with root package name */
    public long f12024u;

    /* renamed from: v  reason: collision with root package name */
    public long f12025v;

    /* renamed from: w  reason: collision with root package name */
    public int f12026w;

    /* renamed from: x  reason: collision with root package name */
    public int f12027x;

    /* renamed from: y  reason: collision with root package name */
    public long f12028y;

    /* renamed from: z  reason: collision with root package name */
    public long f12029z;

    public p(a0 a0Var) {
        this.f12004a = a0Var;
        if (l0.f8453a >= 18) {
            try {
                this.f12017n = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f12005b = new long[10];
    }

    public final long a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.f12028y;
        if (j10 != -9223372036854775807L) {
            return Math.min(this.B, this.A + ((l0.s((elapsedRealtime * 1000) - j10, this.f12013j) * ((long) this.f12010g)) / 1000000));
        }
        if (elapsedRealtime - this.f12022s >= 5) {
            AudioTrack audioTrack = this.f12006c;
            audioTrack.getClass();
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
                if (this.f12011h) {
                    if (playState == 2 && playbackHeadPosition == 0) {
                        this.f12025v = this.f12023t;
                    }
                    playbackHeadPosition += this.f12025v;
                }
                if (l0.f8453a <= 29) {
                    if (playbackHeadPosition != 0 || this.f12023t <= 0 || playState != 3) {
                        this.f12029z = -9223372036854775807L;
                    } else if (this.f12029z == -9223372036854775807L) {
                        this.f12029z = elapsedRealtime;
                    }
                }
                if (this.f12023t > playbackHeadPosition) {
                    this.f12024u++;
                }
                this.f12023t = playbackHeadPosition;
            }
            this.f12022s = elapsedRealtime;
        }
        return this.f12023t + (this.f12024u << 32);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(long r6) {
        /*
            r5 = this;
            long r0 = r5.a()
            r2 = 1
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x002b
            boolean r6 = r5.f12011h
            r7 = 0
            if (r6 == 0) goto L_0x0026
            android.media.AudioTrack r6 = r5.f12006c
            r6.getClass()
            int r6 = r6.getPlayState()
            r0 = 2
            if (r6 != r0) goto L_0x0026
            long r0 = r5.a()
            r3 = 0
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0026
            r6 = 1
            goto L_0x0027
        L_0x0026:
            r6 = 0
        L_0x0027:
            if (r6 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.p.b(long):boolean");
    }

    public final void c() {
        this.f12015l = 0;
        this.f12027x = 0;
        this.f12026w = 0;
        this.f12016m = 0;
        this.D = 0;
        this.G = 0;
        this.f12014k = false;
    }
}

package n1;

import android.content.Context;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import d0.d;
import g1.a0;
import g1.d1;
import g1.n0;
import g1.r1;
import g1.t1;
import g1.u1;
import j1.l0;
import java.util.HashMap;

public final class c0 implements c, d0 {
    public boolean A;

    /* renamed from: a  reason: collision with root package name */
    public final Context f10931a;

    /* renamed from: b  reason: collision with root package name */
    public final z f10932b;

    /* renamed from: c  reason: collision with root package name */
    public final PlaybackSession f10933c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10934d = SystemClock.elapsedRealtime();

    /* renamed from: e  reason: collision with root package name */
    public final t1 f10935e = new t1();

    /* renamed from: f  reason: collision with root package name */
    public final r1 f10936f = new r1();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap f10937g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final HashMap f10938h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public String f10939i;

    /* renamed from: j  reason: collision with root package name */
    public PlaybackMetrics.Builder f10940j;

    /* renamed from: k  reason: collision with root package name */
    public int f10941k;

    /* renamed from: l  reason: collision with root package name */
    public int f10942l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f10943m = 0;

    /* renamed from: n  reason: collision with root package name */
    public d1 f10944n;

    /* renamed from: o  reason: collision with root package name */
    public d f10945o;

    /* renamed from: p  reason: collision with root package name */
    public d f10946p;

    /* renamed from: q  reason: collision with root package name */
    public d f10947q;

    /* renamed from: r  reason: collision with root package name */
    public a0 f10948r;

    /* renamed from: s  reason: collision with root package name */
    public a0 f10949s;

    /* renamed from: t  reason: collision with root package name */
    public a0 f10950t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f10951u;

    /* renamed from: v  reason: collision with root package name */
    public int f10952v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f10953w;

    /* renamed from: x  reason: collision with root package name */
    public int f10954x;

    /* renamed from: y  reason: collision with root package name */
    public int f10955y;

    /* renamed from: z  reason: collision with root package name */
    public int f10956z;

    public c0(Context context, PlaybackSession playbackSession) {
        this.f10931a = context.getApplicationContext();
        this.f10933c = playbackSession;
        z zVar = new z();
        this.f10932b = zVar;
        zVar.f11019e = this;
    }

    public static int c(int i10) {
        switch (l0.q(i10)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    public final boolean a(d dVar) {
        String str;
        if (dVar != null) {
            String str2 = (String) dVar.f4092j;
            z zVar = this.f10932b;
            synchronized (zVar) {
                str = zVar.f11021g;
            }
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        PlaybackMetrics.Builder builder = this.f10940j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.f10956z);
            this.f10940j.setVideoFramesDropped(this.f10954x);
            this.f10940j.setVideoFramesPlayed(this.f10955y);
            Long l10 = (Long) this.f10937g.get(this.f10939i);
            this.f10940j.setNetworkTransferDurationMillis(l10 == null ? 0 : l10.longValue());
            Long l11 = (Long) this.f10938h.get(this.f10939i);
            this.f10940j.setNetworkBytesRead(l11 == null ? 0 : l11.longValue());
            this.f10940j.setStreamSource((l11 == null || l11.longValue() <= 0) ? 0 : 1);
            this.f10933c.reportPlaybackMetrics(this.f10940j.build());
        }
        this.f10940j = null;
        this.f10939i = null;
        this.f10956z = 0;
        this.f10954x = 0;
        this.f10955y = 0;
        this.f10948r = null;
        this.f10949s = null;
        this.f10950t = null;
        this.A = false;
    }

    public final void d(int i10, long j10, a0 a0Var) {
        if (!l0.a(this.f10949s, a0Var)) {
            int i11 = (this.f10949s == null && i10 == 0) ? 1 : i10;
            this.f10949s = a0Var;
            j(0, j10, a0Var, i11);
        }
    }

    public final void e(int i10, long j10, a0 a0Var) {
        if (!l0.a(this.f10950t, a0Var)) {
            int i11 = (this.f10950t == null && i10 == 0) ? 1 : i10;
            this.f10950t = a0Var;
            j(2, j10, a0Var, i11);
        }
    }

    public final void f(u1 u1Var, v1.a0 a0Var) {
        int k10;
        PlaybackMetrics.Builder builder = this.f10940j;
        if (a0Var != null && (k10 = u1Var.k(a0Var.f6678a)) != -1) {
            r1 r1Var = this.f10936f;
            int i10 = 0;
            u1Var.o(k10, r1Var, false);
            int i11 = r1Var.f6544j;
            t1 t1Var = this.f10935e;
            u1Var.v(i11, t1Var);
            n0 n0Var = t1Var.f6577j.f6557i;
            int i12 = 2;
            if (n0Var != null) {
                int A2 = l0.A(n0Var.f6478a, n0Var.f6479b);
                if (A2 == 0) {
                    i10 = 3;
                } else if (A2 == 1) {
                    i10 = 5;
                } else if (A2 != 2) {
                    i10 = 1;
                } else {
                    i10 = 4;
                }
            }
            builder.setStreamType(i10);
            if (t1Var.f6588u != -9223372036854775807L && !t1Var.f6586s && !t1Var.f6583p && !t1Var.k()) {
                builder.setMediaDurationMillis(t1Var.j());
            }
            if (!t1Var.k()) {
                i12 = 1;
            }
            builder.setPlaybackType(i12);
            this.A = true;
        }
    }

    public final void g(int i10, long j10, a0 a0Var) {
        if (!l0.a(this.f10948r, a0Var)) {
            int i11 = (this.f10948r == null && i10 == 0) ? 1 : i10;
            this.f10948r = a0Var;
            j(1, j10, a0Var, i11);
        }
    }

    public final void h(b bVar, String str) {
        v1.a0 a0Var = bVar.f10924d;
        if (a0Var == null || !a0Var.a()) {
            b();
            this.f10939i = str;
            b0.s();
            this.f10940j = b0.n().setPlayerName("AndroidXMedia3").setPlayerVersion("1.0.2");
            f(bVar.f10922b, a0Var);
        }
    }

    public final void i(b bVar, String str) {
        v1.a0 a0Var = bVar.f10924d;
        if ((a0Var == null || !a0Var.a()) && str.equals(this.f10939i)) {
            b();
        }
        this.f10937g.remove(str);
        this.f10938h.remove(str);
    }

    public final void j(int i10, long j10, a0 a0Var, int i11) {
        int i12;
        String str;
        a0.r();
        TrackChangeEvent.Builder k10 = a0.f(i10).setTimeSinceCreatedMillis(j10 - this.f10934d);
        if (a0Var != null) {
            k10.setTrackState(1);
            if (i11 != 1) {
                i12 = 3;
                if (i11 != 2) {
                    if (i11 != 3) {
                        i12 = 1;
                    } else {
                        i12 = 4;
                    }
                }
            } else {
                i12 = 2;
            }
            k10.setTrackChangeReason(i12);
            String str2 = a0Var.f6275r;
            if (str2 != null) {
                k10.setContainerMimeType(str2);
            }
            String str3 = a0Var.f6276s;
            if (str3 != null) {
                k10.setSampleMimeType(str3);
            }
            String str4 = a0Var.f6273p;
            if (str4 != null) {
                k10.setCodecName(str4);
            }
            int i13 = a0Var.f6272o;
            if (i13 != -1) {
                k10.setBitrate(i13);
            }
            int i14 = a0Var.f6281x;
            if (i14 != -1) {
                k10.setWidth(i14);
            }
            int i15 = a0Var.f6282y;
            if (i15 != -1) {
                k10.setHeight(i15);
            }
            int i16 = a0Var.F;
            if (i16 != -1) {
                k10.setChannelCount(i16);
            }
            int i17 = a0Var.G;
            if (i17 != -1) {
                k10.setAudioSampleRate(i17);
            }
            String str5 = a0Var.f6267j;
            if (str5 != null) {
                int i18 = l0.f8453a;
                String[] split = str5.split("-", -1);
                String str6 = split[0];
                if (split.length >= 2) {
                    str = split[1];
                } else {
                    str = null;
                }
                Pair create = Pair.create(str6, str);
                k10.setLanguage((String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    k10.setLanguageRegion((String) obj);
                }
            }
            float f10 = a0Var.f6283z;
            if (f10 != -1.0f) {
                k10.setVideoFrameRate(f10);
            }
        } else {
            k10.setTrackState(0);
        }
        this.A = true;
        this.f10933c.reportTrackChangeEvent(k10.build());
    }
}

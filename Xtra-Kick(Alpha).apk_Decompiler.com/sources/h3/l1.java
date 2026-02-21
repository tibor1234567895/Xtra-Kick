package h3;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.s;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.k;
import android.support.v4.media.session.m;
import android.support.v4.media.session.o;
import android.support.v4.media.session.q;
import android.support.v4.media.session.u;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.fragment.app.g;
import androidx.media.AudioAttributesCompat;
import d9.o0;
import d9.r0;
import e1.h;
import g1.a2;
import g1.b2;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.i1;
import g1.j1;
import g1.p0;
import g1.s0;
import g1.t1;
import g1.u1;
import g1.v0;
import g1.y1;
import h9.a0;
import h9.e0;
import h9.k0;
import j1.a;
import j1.d;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import o1.b0;
import v.e;

public final class l1 implements a0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f7171a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f7172b;

    /* renamed from: c  reason: collision with root package name */
    public final l4 f7173c;

    /* renamed from: d  reason: collision with root package name */
    public final e f7174d;

    /* renamed from: e  reason: collision with root package name */
    public final i1 f7175e;

    /* renamed from: f  reason: collision with root package name */
    public final a f7176f;

    /* renamed from: g  reason: collision with root package name */
    public u f7177g;

    /* renamed from: h  reason: collision with root package name */
    public s f7178h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7179i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7180j;

    /* renamed from: k  reason: collision with root package name */
    public k1 f7181k = new k1();

    /* renamed from: l  reason: collision with root package name */
    public k1 f7182l = new k1();

    /* renamed from: m  reason: collision with root package name */
    public j1 f7183m = new j1();

    public l1(Context context, b0 b0Var, l4 l4Var, Looper looper, a aVar) {
        this.f7174d = new e(looper, d.f8420a, new a1(this));
        this.f7171a = context;
        this.f7172b = b0Var;
        this.f7175e = new i1(this, looper);
        this.f7173c = l4Var;
        this.f7176f = aVar;
    }

    public static List N0(List list) {
        if (list == null) {
            return Collections.emptyList();
        }
        h hVar = t3.f7332a;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static PlaybackStateCompat O0(PlaybackStateCompat playbackStateCompat) {
        PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
        if (playbackStateCompat2 == null) {
            return null;
        }
        if (playbackStateCompat2.f362k > 0.0f) {
            return playbackStateCompat2;
        }
        v.g("MCImplLegacy", "Adjusting playback speed to 1.0f because negative playback speed isn't supported.");
        ArrayList arrayList = new ArrayList();
        long j10 = playbackStateCompat2.f361j;
        long j11 = playbackStateCompat2.f363l;
        int i10 = playbackStateCompat2.f364m;
        CharSequence charSequence = playbackStateCompat2.f365n;
        ArrayList arrayList2 = playbackStateCompat2.f367p;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return new PlaybackStateCompat(playbackStateCompat2.f359h, playbackStateCompat2.f360i, j10, 1.0f, j11, i10, charSequence, playbackStateCompat2.f366o, arrayList, playbackStateCompat2.f368q, playbackStateCompat2.f369r);
    }

    public static j1 P0(int i10, s0 s0Var, long j10, boolean z10) {
        return new j1((Object) null, i10, s0Var, (Object) null, i10, j10, j10, z10 ? 0 : -1, z10 ? 0 : -1);
    }

    public static i4 Q0(j1 j1Var, long j10, long j11, int i10, long j12) {
        long j13 = j11;
        int i11 = i10;
        long j14 = j12;
        return new i4(j1Var, false, SystemClock.elapsedRealtime(), j10, j13, i11, j14, -9223372036854775807L, j10, j11);
    }

    public final void A(boolean z10) {
        if (z10 != o0()) {
            w3 w3Var = this.f7183m.f7131a;
            u3 g10 = android.support.v4.media.h.g(w3Var, w3Var);
            g10.f7348i = z10;
            w3 a10 = g10.a();
            j1 j1Var = this.f7183m;
            Y0(new j1(a10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        q B = this.f7177g.B();
        h hVar = t3.f7332a;
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", z10 ? 1 : 0);
        B.f(bundle, "android.support.v4.media.session.action.SET_SHUFFLE_MODE");
    }

    public final void A0() {
        this.f7177g.B().f413a.rewind();
    }

    public final void B() {
        this.f7177g.B().f413a.skipToNext();
    }

    public final void B0(float f10) {
        v.g("MCImplLegacy", "Session doesn't support setting player volume");
    }

    public final void C(r0 r0Var) {
        L0(0, -9223372036854775807L, r0Var);
    }

    public final v0 C0() {
        s0 o10 = this.f7183m.f7131a.o();
        return o10 == null ? v0.P : o10.f6559k;
    }

    public final a2 D() {
        return a2.f6286i;
    }

    public final void D0() {
        this.f7177g.B().f413a.skipToPrevious();
    }

    public final int E() {
        return this.f7183m.f7131a.f7414j.f7122m;
    }

    public final void E0(float f10) {
        if (f10 != i().f6355h) {
            w3 k10 = this.f7183m.f7131a.k(new e1(f10));
            j1 j1Var = this.f7183m;
            Y0(new j1(k10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        this.f7177g.B().g(f10);
    }

    public final long F() {
        return 0;
    }

    public final void F0(List list, int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        if (!list.isEmpty()) {
            c4 c4Var = (c4) this.f7183m.f7131a.f7421q;
            if (c4Var.y()) {
                L0(0, -9223372036854775807L, list);
                return;
            }
            int min = Math.min(i10, j0().x());
            c4 z11 = c4Var.z(list, min);
            int U = U();
            int size = list.size();
            if (U >= min) {
                U += size;
            }
            w3 n10 = this.f7183m.f7131a.n(z11, U);
            j1 j1Var = this.f7183m;
            Y0(new j1(n10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
            if (U0()) {
                M0(list, min);
            }
        }
    }

    public final boolean G() {
        return this.f7180j;
    }

    public final long G0() {
        return this.f7183m.f7131a.G;
    }

    public final v0 H() {
        return this.f7183m.f7131a.f7423s;
    }

    public final boolean H0() {
        return this.f7180j;
    }

    public final boolean I() {
        return this.f7183m.f7131a.B;
    }

    public final h4 I0() {
        return this.f7183m.f7132b;
    }

    public final long J() {
        return i0();
    }

    public final e0 J0(f4 f4Var, Bundle bundle) {
        h4 h4Var = this.f7183m.f7132b;
        h4Var.getClass();
        boolean contains = h4Var.f7078h.contains(f4Var);
        String str = f4Var.f7035i;
        if (contains) {
            this.f7177g.B().f(bundle, str);
            return new a0(new j4(0));
        }
        k0 n10 = k0.n();
        f1 f1Var = new f1(this.f7172b.f6926e, n10);
        u uVar = this.f7177g;
        uVar.getClass();
        if (!TextUtils.isEmpty(str)) {
            ((m) ((k) uVar.f428i)).f403a.sendCommand(str, bundle, f1Var);
            return n10;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public final int K() {
        return U();
    }

    public final void K0() {
        l4 l4Var = this.f7173c;
        int type = l4Var.f7191h.getType();
        b0 b0Var = this.f7172b;
        if (type == 0) {
            Object d10 = l4Var.f7191h.d();
            a.f(d10);
            b0Var.S0(new g.r0(this, 21, (MediaSessionCompat$Token) d10));
            b0Var.f6926e.post(new e1(this, 0));
            return;
        }
        b0Var.S0(new e1(this, 1));
    }

    public final i1.d L() {
        v.g("MCImplLegacy", "Session doesn't support getting Cue");
        return i1.d.f7990j;
    }

    public final void L0(int i10, long j10, List list) {
        if (list.isEmpty()) {
            z();
            return;
        }
        c4 z10 = c4.f6960o.z(list, 0);
        if (j10 == -9223372036854775807L) {
            j10 = 0;
        }
        w3 w3Var = this.f7183m.f7131a;
        i4 Q0 = Q0(P0(i10, (s0) list.get(i10), j10, false), -9223372036854775807L, 0, 0, 0);
        u3 g10 = android.support.v4.media.h.g(w3Var, w3Var);
        g10.f7349j = z10;
        g10.f7342c = Q0;
        w3 a10 = g10.a();
        j1 j1Var = this.f7183m;
        Y0(new j1(a10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        if (U0()) {
            T0();
        }
    }

    public final void M(TextureView textureView) {
        v.g("MCImplLegacy", "Session doesn't support clearing TextureView");
    }

    public final void M0(List list, int i10) {
        ArrayList arrayList = new ArrayList();
        z0 z0Var = new z0(this, new AtomicInteger(0), list, arrayList, i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            byte[] bArr = ((s0) list.get(i11)).f6559k.f6660q;
            if (bArr == null) {
                arrayList.add((Object) null);
                z0Var.run();
            } else {
                e0 b10 = this.f7176f.b(bArr);
                arrayList.add(b10);
                Handler handler = this.f7172b.f6926e;
                Objects.requireNonNull(handler);
                b10.a(z0Var, new b0(3, handler));
            }
        }
    }

    public final b2 N() {
        v.g("MCImplLegacy", "Session doesn't support getting VideoSize");
        return b2.f6311l;
    }

    public final void O() {
        this.f7177g.B().f413a.skipToPrevious();
    }

    public final void P() {
        w3 w3Var = this.f7183m.f7131a;
        if (!w3Var.f7430z) {
            w3 j10 = w3Var.j(1, 0, true);
            j1 j1Var = this.f7183m;
            Y0(new j1(j10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
            if (U0() && S0()) {
                this.f7177g.B().f413a.play();
            }
        }
    }

    public final float Q() {
        return 1.0f;
    }

    public final void R() {
        W0(U(), 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:164:0x034b, code lost:
        if (h3.t3.x(r11, 1024) == false) goto L_0x0350;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x035f, code lost:
        if (h3.t3.x(r11, 2048) != false) goto L_0x0372;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0370, code lost:
        if (h3.t3.x(r11, 8192) != false) goto L_0x0372;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0372, code lost:
        r13.b(31, 2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x047b  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x048c  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0503  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0518  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0539  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x05ab A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x05b3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x05cd  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x05f2  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x012e A[EDGE_INSN: B:317:0x012e->B:56:0x012e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R0(boolean r73, h3.k1 r74) {
        /*
            r72 = this;
            r7 = r72
            r3 = r74
            boolean r0 = r7.f7179i
            if (r0 != 0) goto L_0x0664
            boolean r0 = r7.f7180j
            if (r0 != 0) goto L_0x000e
            goto L_0x0664
        L_0x000e:
            h3.k1 r1 = r7.f7181k
            h3.j1 r2 = r7.f7183m
            android.support.v4.media.session.u r0 = r7.f7177g
            java.lang.Object r0 = r0.f428i
            android.support.v4.media.session.k r0 = (android.support.v4.media.session.k) r0
            android.support.v4.media.session.m r0 = (android.support.v4.media.session.m) r0
            android.media.session.MediaController r0 = r0.f403a
            long r4 = r0.getFlags()
            android.support.v4.media.session.u r0 = r7.f7177g
            java.lang.Object r0 = r0.f428i
            android.support.v4.media.session.k r0 = (android.support.v4.media.session.k) r0
            android.support.v4.media.session.m r0 = (android.support.v4.media.session.m) r0
            boolean r6 = r0.a()
            android.support.v4.media.session.u r0 = r7.f7177g
            java.lang.Object r0 = r0.f428i
            android.support.v4.media.session.k r0 = (android.support.v4.media.session.k) r0
            r8 = r0
            android.support.v4.media.session.m r8 = (android.support.v4.media.session.m) r8
            int r0 = android.os.Build.VERSION.SDK_INT
            r9 = 22
            if (r0 >= r9) goto L_0x0054
            android.support.v4.media.session.MediaSessionCompat$Token r0 = r8.f407e
            android.support.v4.media.session.f r9 = r0.u()
            if (r9 == 0) goto L_0x0054
            android.support.v4.media.session.f r0 = r0.u()     // Catch:{ RemoteException -> 0x004c }
            int r0 = r0.E()     // Catch:{ RemoteException -> 0x004c }
            goto L_0x005a
        L_0x004c:
            r0 = move-exception
            java.lang.String r9 = "MediaControllerCompat"
            java.lang.String r10 = "Dead object in getRatingType."
            android.util.Log.e(r9, r10, r0)
        L_0x0054:
            android.media.session.MediaController r0 = r8.f403a
            int r0 = r0.getRatingType()
        L_0x005a:
            h3.b0 r8 = r7.f7172b
            long r9 = r8.f6927f
            java.util.List r11 = r1.f7155d
            java.util.List r12 = r3.f7155d
            if (r11 == r12) goto L_0x0066
            r11 = 1
            goto L_0x0067
        L_0x0066:
            r11 = 0
        L_0x0067:
            if (r11 == 0) goto L_0x00ad
            h3.c4 r13 = h3.c4.f6960o
            d9.o0 r13 = new d9.o0
            r13.<init>()
            r14 = 0
        L_0x0071:
            int r15 = r12.size()
            if (r14 >= r15) goto L_0x009e
            java.lang.Object r15 = r12.get(r14)
            android.support.v4.media.session.MediaSessionCompat$QueueItem r15 = (android.support.v4.media.session.MediaSessionCompat$QueueItem) r15
            e1.h r16 = h3.t3.f7332a
            r16 = r12
            android.support.v4.media.MediaDescriptionCompat r12 = r15.f346h
            g1.s0 r12 = h3.t3.j(r12)
            r17 = r8
            h3.b4 r8 = new h3.b4
            r18 = r9
            long r9 = r15.f347i
            r8.<init>(r12, r9)
            r13.c(r8)
            int r14 = r14 + 1
            r12 = r16
            r8 = r17
            r9 = r18
            goto L_0x0071
        L_0x009e:
            r17 = r8
            r18 = r9
            h3.c4 r8 = new h3.c4
            d9.r1 r9 = r13.e()
            r10 = 0
            r8.<init>(r9, r10)
            goto L_0x00c1
        L_0x00ad:
            r17 = r8
            r18 = r9
            h3.w3 r8 = r2.f7131a
            g1.u1 r8 = r8.f7421q
            h3.c4 r8 = (h3.c4) r8
            h3.c4 r9 = new h3.c4
            d9.r0 r10 = r8.f6962m
            g1.s0 r8 = r8.f6963n
            r9.<init>(r10, r8)
            r8 = r9
        L_0x00c1:
            android.support.v4.media.MediaMetadataCompat r9 = r1.f7154c
            android.support.v4.media.MediaMetadataCompat r10 = r3.f7154c
            if (r9 != r10) goto L_0x00cc
            if (r73 == 0) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r9 = 0
            goto L_0x00cd
        L_0x00cc:
            r9 = 1
        L_0x00cd:
            android.support.v4.media.session.PlaybackStateCompat r12 = r1.f7153b
            if (r12 != 0) goto L_0x00d4
            r13 = -1
            goto L_0x00d6
        L_0x00d4:
            long r13 = r12.f368q
        L_0x00d6:
            android.support.v4.media.session.PlaybackStateCompat r15 = r3.f7153b
            if (r15 != 0) goto L_0x00e3
            r20 = -1
            r70 = r4
            r4 = r20
            r20 = r70
            goto L_0x00e7
        L_0x00e3:
            r20 = r4
            long r4 = r15.f368q
        L_0x00e7:
            int r16 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r16 != 0) goto L_0x00f0
            if (r73 == 0) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r13 = 0
            goto L_0x00f1
        L_0x00f0:
            r13 = 1
        L_0x00f1:
            if (r9 != 0) goto L_0x0108
            if (r13 != 0) goto L_0x0108
            if (r11 == 0) goto L_0x00f8
            goto L_0x0108
        L_0x00f8:
            h3.w3 r0 = r2.f7131a
            h3.i4 r4 = r0.f7414j
            g1.j1 r4 = r4.f7117h
            int r4 = r4.f6431i
            g1.v0 r0 = r0.F
            r47 = r0
            r16 = r6
            goto L_0x021f
        L_0x0108:
            java.util.List r11 = r3.f7155d
            if (r11 == 0) goto L_0x012e
            r22 = -1
            int r14 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r14 != 0) goto L_0x0113
            goto L_0x012e
        L_0x0113:
            r14 = 0
        L_0x0114:
            int r7 = r11.size()
            if (r14 >= r7) goto L_0x012e
            java.lang.Object r7 = r11.get(r14)
            android.support.v4.media.session.MediaSessionCompat$QueueItem r7 = (android.support.v4.media.session.MediaSessionCompat$QueueItem) r7
            r16 = r6
            long r6 = r7.f347i
            int r22 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r22 != 0) goto L_0x0129
            goto L_0x0131
        L_0x0129:
            int r14 = r14 + 1
            r6 = r16
            goto L_0x0114
        L_0x012e:
            r16 = r6
            r14 = -1
        L_0x0131:
            if (r10 == 0) goto L_0x0135
            r4 = 1
            goto L_0x0136
        L_0x0135:
            r4 = 0
        L_0x0136:
            if (r4 == 0) goto L_0x013f
            if (r9 == 0) goto L_0x013f
            g1.v0 r5 = h3.t3.m(r10, r0)
            goto L_0x015a
        L_0x013f:
            if (r4 != 0) goto L_0x0156
            if (r13 == 0) goto L_0x0156
            r5 = -1
            if (r14 != r5) goto L_0x0149
            g1.v0 r5 = g1.v0.P
            goto L_0x015a
        L_0x0149:
            java.lang.Object r5 = r11.get(r14)
            android.support.v4.media.session.MediaSessionCompat$QueueItem r5 = (android.support.v4.media.session.MediaSessionCompat$QueueItem) r5
            android.support.v4.media.MediaDescriptionCompat r5 = r5.f346h
            g1.v0 r5 = h3.t3.l(r5, r0)
            goto L_0x015a
        L_0x0156:
            h3.w3 r5 = r2.f7131a
            g1.v0 r5 = r5.F
        L_0x015a:
            d9.r0 r6 = r8.f6962m
            r7 = -1
            if (r14 != r7) goto L_0x01a9
            if (r9 == 0) goto L_0x01a9
            if (r4 == 0) goto L_0x019d
            java.lang.String r4 = "MCImplLegacy"
            java.lang.String r7 = "Adding a fake MediaItem at the end of the list because there's no QueueItem with the active queue id and current Timeline should have currently playing MediaItem."
            j1.v.g(r4, r7)
            e1.h r4 = h3.t3.f7332a
            android.os.Bundle r4 = r10.f309h
            java.lang.String r7 = "android.media.metadata.MEDIA_ID"
            java.lang.CharSequence r4 = r4.getCharSequence(r7)
            if (r4 == 0) goto L_0x017b
            java.lang.String r4 = r4.toString()
            goto L_0x017c
        L_0x017b:
            r4 = 0
        L_0x017c:
            g1.s0 r0 = h3.t3.k(r4, r10, r0)
            g1.f0 r4 = new g1.f0
            r4.<init>(r0)
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r4.f6366i = r0
            g1.s0 r0 = r4.a()
            h3.c4 r4 = new h3.c4
            r4.<init>(r6, r0)
            int r0 = r4.x()
            int r0 = r0 + -1
            r8 = r4
            goto L_0x01a6
        L_0x019d:
            h3.c4 r0 = new h3.c4
            r4 = 0
            r0.<init>(r6, r4)
            r4 = 0
            r8 = r0
            r0 = 0
        L_0x01a6:
            r4 = r0
            goto L_0x021d
        L_0x01a9:
            r7 = 0
            r9 = -1
            if (r14 == r9) goto L_0x021b
            h3.c4 r8 = new h3.c4
            r8.<init>(r6, r7)
            if (r4 == 0) goto L_0x0219
            g1.s0 r4 = r8.A(r14)
            r4.getClass()
            java.lang.String r4 = r4.f6556h
            g1.s0 r0 = h3.t3.k(r4, r10, r0)
            d9.r0 r4 = r8.f6962m
            int r6 = r4.size()
            g1.s0 r7 = r8.f6963n
            if (r14 < r6) goto L_0x01d6
            int r6 = r4.size()
            if (r14 != r6) goto L_0x01d4
            if (r7 == 0) goto L_0x01d4
            goto L_0x01d6
        L_0x01d4:
            r6 = 0
            goto L_0x01d7
        L_0x01d6:
            r6 = 1
        L_0x01d7:
            j1.a.b(r6)
            int r6 = r4.size()
            if (r14 != r6) goto L_0x01e6
            h3.c4 r8 = new h3.c4
            r8.<init>(r4, r0)
            goto L_0x0219
        L_0x01e6:
            java.lang.Object r6 = r4.get(r14)
            h3.b4 r6 = (h3.b4) r6
            long r8 = r6.f6942b
            d9.o0 r6 = new d9.o0
            r6.<init>()
            r11 = 0
            d9.r0 r11 = r4.subList(r11, r14)
            r6.d(r11)
            h3.b4 r11 = new h3.b4
            r11.<init>(r0, r8)
            r6.c(r11)
            int r0 = r14 + 1
            int r8 = r4.size()
            d9.r0 r0 = r4.subList(r0, r8)
            r6.d(r0)
            h3.c4 r8 = new h3.c4
            d9.r1 r0 = r6.e()
            r8.<init>(r0, r7)
        L_0x0219:
            r4 = r14
            goto L_0x021d
        L_0x021b:
            r0 = 0
            r4 = 0
        L_0x021d:
            r47 = r5
        L_0x021f:
            java.lang.CharSequence r0 = r1.f7156e
            java.lang.CharSequence r1 = r3.f7156e
            if (r0 != r1) goto L_0x022a
            h3.w3 r0 = r2.f7131a
            g1.v0 r0 = r0.f7423s
            goto L_0x0230
        L_0x022a:
            e1.h r0 = h3.t3.f7332a
            if (r1 != 0) goto L_0x0233
            g1.v0 r0 = g1.v0.P
        L_0x0230:
            r34 = r0
            goto L_0x0241
        L_0x0233:
            g1.u0 r0 = new g1.u0
            r0.<init>()
            r0.f6596a = r1
            g1.v0 r1 = new g1.v0
            r1.<init>(r0)
            r34 = r1
        L_0x0241:
            int r0 = r3.f7157f
            int r30 = h3.t3.s(r0)
            int r0 = r3.f7158g
            boolean r31 = h3.t3.t(r0)
            if (r12 == r15) goto L_0x02f8
            h3.g4 r0 = new h3.g4
            r0.<init>()
            r0.a()
            java.util.HashSet r0 = r0.f7052a
            if (r16 != 0) goto L_0x0275
            java.util.Iterator r1 = r0.iterator()
        L_0x025f:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0275
            java.lang.Object r5 = r1.next()
            h3.f4 r5 = (h3.f4) r5
            int r6 = r5.f7034h
            r7 = 40010(0x9c4a, float:5.6066E-41)
            if (r6 != r7) goto L_0x025f
            r0.remove(r5)
        L_0x0275:
            if (r15 == 0) goto L_0x029c
            java.util.ArrayList r1 = r15.f367p
            if (r1 == 0) goto L_0x029c
            java.util.Iterator r1 = r1.iterator()
        L_0x027f:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x029c
            java.lang.Object r5 = r1.next()
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r5 = (android.support.v4.media.session.PlaybackStateCompat.CustomAction) r5
            java.lang.String r6 = r5.f371h
            h3.f4 r7 = new h3.f4
            android.os.Bundle r5 = r5.f374k
            if (r5 != 0) goto L_0x0295
            android.os.Bundle r5 = android.os.Bundle.EMPTY
        L_0x0295:
            r7.<init>(r5, r6)
            r0.add(r7)
            goto L_0x027f
        L_0x029c:
            h3.h4 r1 = new h3.h4
            r1.<init>(r0)
            if (r15 != 0) goto L_0x02a8
            d9.p0 r0 = d9.r0.f4657i
            d9.r1 r0 = d9.r1.f4658l
            goto L_0x02fc
        L_0x02a8:
            d9.o0 r0 = new d9.o0
            r0.<init>()
            java.util.ArrayList r5 = r15.f367p
            java.util.Iterator r5 = r5.iterator()
        L_0x02b3:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x02f3
            java.lang.Object r6 = r5.next()
            android.support.v4.media.session.PlaybackStateCompat$CustomAction r6 = (android.support.v4.media.session.PlaybackStateCompat.CustomAction) r6
            java.lang.String r7 = r6.f371h
            h3.c r9 = new h3.c
            r9.<init>()
            h3.f4 r11 = new h3.f4
            android.os.Bundle r12 = r6.f374k
            if (r12 != 0) goto L_0x02ce
            android.os.Bundle r12 = android.os.Bundle.EMPTY
        L_0x02ce:
            r11.<init>(r12, r7)
            int r7 = r9.f6944b
            r12 = -1
            if (r7 != r12) goto L_0x02d8
            r7 = 1
            goto L_0x02d9
        L_0x02d8:
            r7 = 0
        L_0x02d9:
            java.lang.String r12 = "playerCommands is already set. Only one of sessionCommand and playerCommand should be set."
            j1.a.a(r12, r7)
            r9.f6943a = r11
            java.lang.CharSequence r7 = r6.f372i
            r9.f6946d = r7
            r7 = 1
            r9.f6948f = r7
            int r6 = r6.f373j
            r9.f6945c = r6
            h3.d r6 = r9.a()
            r0.c(r6)
            goto L_0x02b3
        L_0x02f3:
            d9.r1 r0 = r0.e()
            goto L_0x02fc
        L_0x02f8:
            h3.h4 r1 = r2.f7132b
            d9.r0 r0 = r2.f7134d
        L_0x02fc:
            android.support.v4.media.session.o r5 = r3.f7152a
            if (r5 == 0) goto L_0x0303
            int r6 = r5.f410c
            goto L_0x0304
        L_0x0303:
            r6 = 0
        L_0x0304:
            g1.f1 r7 = new g1.f1
            r7.<init>()
            if (r15 != 0) goto L_0x030e
            r11 = 0
            goto L_0x0310
        L_0x030e:
            long r11 = r15.f363l
        L_0x0310:
            r13 = 4
            boolean r9 = h3.t3.x(r11, r13)
            if (r9 == 0) goto L_0x0320
            r13 = 2
            boolean r9 = h3.t3.x(r11, r13)
            if (r9 != 0) goto L_0x0328
        L_0x0320:
            r13 = 512(0x200, double:2.53E-321)
            boolean r9 = h3.t3.x(r11, r13)
            if (r9 == 0) goto L_0x032c
        L_0x0328:
            r9 = 1
            r7.a(r9)
        L_0x032c:
            r13 = 16384(0x4000, double:8.0948E-320)
            boolean r9 = h3.t3.x(r11, r13)
            r13 = 2
            if (r9 == 0) goto L_0x0338
            r7.a(r13)
        L_0x0338:
            r13 = 32768(0x8000, double:1.61895E-319)
            boolean r9 = h3.t3.x(r11, r13)
            g1.x r13 = r7.f6371a
            if (r9 == 0) goto L_0x034e
            r9 = r0
            r14 = r1
            r0 = 1024(0x400, double:5.06E-321)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 != 0) goto L_0x0372
            goto L_0x0350
        L_0x034e:
            r9 = r0
            r14 = r1
        L_0x0350:
            r0 = 65536(0x10000, double:3.2379E-319)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x0361
            r0 = 2048(0x800, double:1.0118E-320)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 != 0) goto L_0x0372
        L_0x0361:
            r0 = 131072(0x20000, double:6.47582E-319)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x037b
            r0 = 8192(0x2000, double:4.0474E-320)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x037b
        L_0x0372:
            r0 = 2
            int[] r0 = new int[r0]
            r0 = {31, 2} // fill-array
            r13.b(r0)
        L_0x037b:
            r0 = 8
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x0388
            r0 = 11
            r7.a(r0)
        L_0x0388:
            r0 = 64
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x0395
            r0 = 12
            r7.a(r0)
        L_0x0395:
            r0 = 256(0x100, double:1.265E-321)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x03a6
            r0 = 2
            int[] r0 = new int[r0]
            r0 = {5, 4} // fill-array
            r13.b(r0)
        L_0x03a6:
            r0 = 32
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x03b7
            r0 = 2
            int[] r0 = new int[r0]
            r0 = {9, 8} // fill-array
            r13.b(r0)
        L_0x03b7:
            r0 = 16
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x03c8
            r0 = 2
            int[] r0 = new int[r0]
            r0 = {7, 6} // fill-array
            r13.b(r0)
        L_0x03c8:
            r0 = 4194304(0x400000, double:2.0722615E-317)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x03d6
            r0 = 13
            r7.a(r0)
        L_0x03d6:
            r0 = 1
            boolean r0 = h3.t3.x(r11, r0)
            r1 = 3
            if (r0 == 0) goto L_0x03e2
            r7.a(r1)
        L_0x03e2:
            r0 = 1
            if (r6 != r0) goto L_0x03eb
            r0 = 26
            r7.a(r0)
            goto L_0x03f6
        L_0x03eb:
            r0 = 2
            if (r6 != r0) goto L_0x03f6
            int[] r0 = new int[r0]
            r0 = {26, 25} // fill-array
            r13.b(r0)
        L_0x03f6:
            r0 = 5
            int[] r0 = new int[r0]
            r0 = {23, 17, 18, 16, 21} // fill-array
            r13.b(r0)
            r0 = 4
            long r0 = r20 & r0
            r20 = 0
            int r6 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r6 == 0) goto L_0x041b
            r0 = 20
            r7.a(r0)
            r0 = 4096(0x1000, double:2.0237E-320)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x041b
            r0 = 10
            r7.a(r0)
        L_0x041b:
            if (r16 == 0) goto L_0x0439
            r0 = 262144(0x40000, double:1.295163E-318)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x042b
            r0 = 15
            r7.a(r0)
        L_0x042b:
            r0 = 2097152(0x200000, double:1.0361308E-317)
            boolean r0 = h3.t3.x(r11, r0)
            if (r0 == 0) goto L_0x0439
            r0 = 14
            r7.a(r0)
        L_0x0439:
            g1.g1 r0 = r7.c()
            g1.d1 r23 = h3.t3.o(r15)
            long r66 = h3.t3.f(r10)
            r6 = r18
            long r11 = h3.t3.e(r15, r10, r6)
            long r68 = h3.t3.c(r15, r10, r6)
            r1 = r14
            long r13 = h3.t3.c(r15, r10, r6)
            r16 = r0
            r18 = r1
            long r0 = h3.t3.f(r10)
            int r61 = h3.t3.b(r13, r0)
            long r0 = h3.t3.c(r15, r10, r6)
            long r13 = h3.t3.e(r15, r10, r6)
            long r62 = r0 - r13
            if (r10 != 0) goto L_0x046d
            goto L_0x047b
        L_0x046d:
            java.lang.String r0 = "android.media.metadata.ADVERTISEMENT"
            long r0 = r10.w(r0)
            r13 = 0
            int r19 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r19 == 0) goto L_0x047b
            r0 = 1
            goto L_0x047c
        L_0x047b:
            r0 = 0
        L_0x047c:
            if (r15 != 0) goto L_0x0481
            g1.e1 r1 = g1.e1.f6351k
            goto L_0x0488
        L_0x0481:
            g1.e1 r1 = new g1.e1
            float r13 = r15.f362k
            r1.<init>(r13)
        L_0x0488:
            r29 = r1
            if (r5 != 0) goto L_0x0491
            g1.h r1 = g1.h.f6386n
        L_0x048e:
            r36 = r1
            goto L_0x04ba
        L_0x0491:
            androidx.media.AudioAttributesCompat r1 = r5.f409b
            if (r1 != 0) goto L_0x0498
            g1.h r1 = g1.h.f6386n
            goto L_0x048e
        L_0x0498:
            g1.g r13 = new g1.g
            r13.<init>()
            androidx.media.AudioAttributesImpl r14 = r1.f1807a
            int r14 = r14.e()
            r13.f6372a = r14
            androidx.media.AudioAttributesImpl r14 = r1.f1807a
            int r14 = r14.b()
            r13.f6373b = r14
            androidx.media.AudioAttributesImpl r1 = r1.f1807a
            int r1 = r1.d()
            r13.f6374c = r1
            g1.h r1 = r13.a()
            goto L_0x048e
        L_0x04ba:
            if (r15 != 0) goto L_0x04bd
            goto L_0x04c7
        L_0x04bd:
            int r1 = r15.f359h
            switch(r1) {
                case 3: goto L_0x04c3;
                case 4: goto L_0x04c3;
                case 5: goto L_0x04c3;
                case 6: goto L_0x04c3;
                case 7: goto L_0x04c2;
                case 8: goto L_0x04c2;
                case 9: goto L_0x04c3;
                case 10: goto L_0x04c3;
                case 11: goto L_0x04c3;
                default: goto L_0x04c2;
            }
        L_0x04c2:
            goto L_0x04c7
        L_0x04c3:
            r1 = 1
            r41 = 1
            goto L_0x04ca
        L_0x04c7:
            r1 = 0
            r41 = 0
        L_0x04ca:
            r1 = 4
            if (r15 != 0) goto L_0x04ce
            goto L_0x04fe
        L_0x04ce:
            int r13 = r15.f359h
            switch(r13) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04fe;
                case 2: goto L_0x04df;
                case 3: goto L_0x04ec;
                case 4: goto L_0x04db;
                case 5: goto L_0x04db;
                case 6: goto L_0x04db;
                case 7: goto L_0x04fe;
                case 8: goto L_0x04fe;
                case 9: goto L_0x04db;
                case 10: goto L_0x04db;
                case 11: goto L_0x04db;
                default: goto L_0x04d3;
            }
        L_0x04d3:
            r7 = r72
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unrecognized PlaybackStateCompat: "
            goto L_0x065c
        L_0x04db:
            r6 = 2
            r44 = 2
            goto L_0x0501
        L_0x04df:
            long r13 = h3.t3.f(r10)
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r21 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r21 != 0) goto L_0x04f0
        L_0x04ec:
            r6 = 3
            r44 = 3
            goto L_0x0501
        L_0x04f0:
            long r6 = h3.t3.e(r15, r10, r6)
            int r19 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r19 >= 0) goto L_0x04fa
            r6 = 3
            goto L_0x04fb
        L_0x04fa:
            r6 = 4
        L_0x04fb:
            r44 = r6
            goto L_0x0501
        L_0x04fe:
            r6 = 1
            r44 = 1
        L_0x0501:
            if (r15 != 0) goto L_0x0507
            r6 = 0
            r45 = 0
            goto L_0x0511
        L_0x0507:
            int r6 = r15.f359h
            r7 = 3
            if (r6 != r7) goto L_0x050e
            r6 = 1
            goto L_0x050f
        L_0x050e:
            r6 = 0
        L_0x050f:
            r45 = r6
        L_0x0511:
            if (r5 != 0) goto L_0x0518
            g1.q r6 = g1.q.f6514k
        L_0x0515:
            r38 = r6
            goto L_0x0529
        L_0x0518:
            g1.q r6 = new g1.q
            int r7 = r5.f408a
            r13 = 2
            if (r7 != r13) goto L_0x0521
            r7 = 1
            goto L_0x0522
        L_0x0521:
            r7 = 0
        L_0x0522:
            int r13 = r5.f411d
            r14 = 0
            r6.<init>(r7, r14, r13)
            goto L_0x0515
        L_0x0529:
            if (r5 != 0) goto L_0x052f
            r6 = 0
            r39 = 0
            goto L_0x0533
        L_0x052f:
            int r6 = r5.f412e
            r39 = r6
        L_0x0533:
            if (r5 != 0) goto L_0x0539
            r5 = 0
            r40 = 0
            goto L_0x0542
        L_0x0539:
            int r5 = r5.f412e
            if (r5 != 0) goto L_0x053f
            r5 = 1
            goto L_0x0540
        L_0x053f:
            r5 = 0
        L_0x0540:
            r40 = r5
        L_0x0542:
            h3.w3 r2 = r2.f7131a
            long r5 = r2.G
            r48 = r5
            long r5 = r2.H
            r50 = r5
            g1.s0 r2 = r8.A(r4)
            g1.j1 r53 = P0(r4, r2, r11, r0)
            h3.i4 r52 = new h3.i4
            r25 = r52
            r55 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r64 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r54 = r0
            r57 = r66
            r59 = r68
            r52.<init>(r53, r54, r55, r57, r59, r61, r62, r64, r66, r68)
            h3.w3 r0 = new h3.w3
            r22 = r0
            r24 = 0
            g1.j1 r27 = h3.i4.f7108r
            r26 = r27
            r28 = 0
            g1.b2 r32 = g1.b2.f6311l
            r35 = 1065353216(0x3f800000, float:1.0)
            i1.d r37 = i1.d.f7990j
            r42 = 1
            r43 = 0
            r46 = 0
            r52 = 0
            g1.a2 r54 = g1.a2.f6286i
            g1.y1 r55 = g1.y1.H
            r33 = r8
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r50, r52, r54, r55)
            h3.j1 r4 = new h3.j1
            r2 = r16
            r5 = r18
            r4.<init>(r0, r5, r2, r9)
            r7 = r72
            h3.k1 r2 = r7.f7181k
            h3.j1 r5 = r7.f7183m
            h3.w3 r6 = r5.f7131a
            g1.u1 r6 = r6.f7421q
            boolean r6 = r6.y()
            boolean r9 = r8.y()
            if (r6 == 0) goto L_0x05b1
            if (r9 == 0) goto L_0x05b1
            r0 = 0
            r1 = 0
            goto L_0x0644
        L_0x05b1:
            if (r6 == 0) goto L_0x05bb
            if (r9 != 0) goto L_0x05bb
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x05f0
        L_0x05bb:
            h3.w3 r5 = r5.f7131a
            g1.s0 r5 = r5.o()
            j1.a.f(r5)
            g1.s0 r6 = r8.f6963n
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x05cd
            goto L_0x05e4
        L_0x05cd:
            r6 = 0
        L_0x05ce:
            d9.r0 r9 = r8.f6962m
            int r11 = r9.size()
            if (r6 >= r11) goto L_0x05e9
            java.lang.Object r9 = r9.get(r6)
            h3.b4 r9 = (h3.b4) r9
            g1.s0 r9 = r9.f6941a
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x05e6
        L_0x05e4:
            r6 = 1
            goto L_0x05ea
        L_0x05e6:
            int r6 = r6 + 1
            goto L_0x05ce
        L_0x05e9:
            r6 = 0
        L_0x05ea:
            if (r6 != 0) goto L_0x05f2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
        L_0x05f0:
            r1 = 3
            goto L_0x063b
        L_0x05f2:
            g1.s0 r1 = r0.o()
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0635
            android.support.v4.media.session.PlaybackStateCompat r1 = r2.f7153b
            android.support.v4.media.MediaMetadataCompat r2 = r2.f7154c
            r5 = r17
            long r5 = r5.f6927f
            long r1 = h3.t3.e(r1, r2, r5)
            long r5 = h3.t3.e(r15, r10, r5)
            r8 = 0
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x0621
            int r0 = r0.f7419o
            r8 = 1
            if (r0 != r8) goto L_0x0621
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0644
        L_0x0621:
            long r1 = r1 - r5
            long r0 = java.lang.Math.abs(r1)
            r5 = 100
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0632
            r0 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0633
        L_0x0632:
            r0 = 0
        L_0x0633:
            r1 = 0
            goto L_0x063f
        L_0x0635:
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 1
        L_0x063b:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x063f:
            r70 = r1
            r1 = r0
            r0 = r70
        L_0x0644:
            android.util.Pair r0 = android.util.Pair.create(r1, r0)
            java.lang.Object r1 = r0.first
            r5 = r1
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r0 = r0.second
            r6 = r0
            java.lang.Integer r6 = (java.lang.Integer) r6
            r1 = r72
            r2 = r73
            r3 = r74
            r1.X0(r2, r3, r4, r5, r6)
            return
        L_0x065c:
            java.lang.String r1 = android.support.v4.media.h.i(r1, r13)
            r0.<init>(r1)
            throw r0
        L_0x0664:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.l1.R0(boolean, h3.k1):void");
    }

    public final g1.h S() {
        return this.f7183m.f7131a.f7425u;
    }

    public final boolean S0() {
        return !this.f7183m.f7131a.f7421q.y();
    }

    public final int T() {
        return -1;
    }

    public final void T0() {
        boolean z10;
        t1 t1Var = new t1();
        if (!U0() || !S0()) {
            z10 = false;
        } else {
            z10 = true;
        }
        a.e(z10);
        w3 w3Var = this.f7183m.f7131a;
        c4 c4Var = (c4) w3Var.f7421q;
        int i10 = w3Var.f7414j.f7117h.f6431i;
        s0 s0Var = c4Var.v(i10, t1Var).f6577j;
        if (c4Var.B(i10) == -1) {
            p0 p0Var = s0Var.f6561m;
            if (p0Var.f6506h != null) {
                if (this.f7183m.f7131a.f7430z) {
                    q B = this.f7177g.B();
                    Uri uri = p0Var.f6506h;
                    Bundle bundle = p0Var.f6508j;
                    if (bundle == null) {
                        bundle = Bundle.EMPTY;
                    }
                    B.a(uri, bundle);
                } else {
                    q B2 = this.f7177g.B();
                    Uri uri2 = p0Var.f6506h;
                    Bundle bundle2 = p0Var.f6508j;
                    if (bundle2 == null) {
                        bundle2 = Bundle.EMPTY;
                    }
                    B2.e(uri2, bundle2);
                }
            } else if (p0Var.f6507i == null) {
                boolean z11 = this.f7183m.f7131a.f7430z;
                String str = s0Var.f6556h;
                if (z11) {
                    q B3 = this.f7177g.B();
                    Bundle bundle3 = p0Var.f6508j;
                    if (bundle3 == null) {
                        bundle3 = Bundle.EMPTY;
                    }
                    B3.f413a.playFromMediaId(str, bundle3);
                } else {
                    q B4 = this.f7177g.B();
                    Bundle bundle4 = p0Var.f6508j;
                    if (bundle4 == null) {
                        bundle4 = Bundle.EMPTY;
                    }
                    B4.c(bundle4, str);
                }
            } else if (this.f7183m.f7131a.f7430z) {
                q B5 = this.f7177g.B();
                String str2 = p0Var.f6507i;
                Bundle bundle5 = p0Var.f6508j;
                if (bundle5 == null) {
                    bundle5 = Bundle.EMPTY;
                }
                B5.f413a.playFromSearch(str2, bundle5);
            } else {
                q B6 = this.f7177g.B();
                String str3 = p0Var.f6507i;
                Bundle bundle6 = p0Var.f6508j;
                if (bundle6 == null) {
                    bundle6 = Bundle.EMPTY;
                }
                B6.d(bundle6, str3);
            }
        } else if (this.f7183m.f7131a.f7430z) {
            this.f7177g.B().f413a.play();
        } else {
            this.f7177g.B().b();
        }
        if (this.f7183m.f7131a.f7414j.f7117h.f6435m != 0) {
            q B7 = this.f7177g.B();
            B7.f413a.seekTo(this.f7183m.f7131a.f7414j.f7117h.f6435m);
        }
        if (this.f7183m.f7133c.i(20)) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < c4Var.x(); i11++) {
                if (i11 != i10 && c4Var.B(i11) == -1) {
                    arrayList.add(c4Var.v(i11, t1Var).f6577j);
                }
            }
            M0(arrayList, 0);
        }
    }

    public final int U() {
        return this.f7183m.f7131a.f7414j.f7117h.f6431i;
    }

    public final boolean U0() {
        return this.f7183m.f7131a.E != 1;
    }

    public final g1.q V() {
        return this.f7183m.f7131a.f7427w;
    }

    public final void V0() {
        o oVar;
        MediaMetadataCompat mediaMetadataCompat;
        if (!this.f7179i && !this.f7180j) {
            this.f7180j = true;
            MediaController.PlaybackInfo playbackInfo = ((m) ((k) this.f7177g.f428i)).f403a.getPlaybackInfo();
            ArrayList arrayList = null;
            if (playbackInfo != null) {
                oVar = new o(playbackInfo.getPlaybackType(), AudioAttributesCompat.f(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
            } else {
                oVar = null;
            }
            PlaybackStateCompat O0 = O0(this.f7177g.w());
            MediaMetadata metadata = ((m) ((k) this.f7177g.f428i)).f403a.getMetadata();
            if (metadata != null) {
                mediaMetadataCompat = MediaMetadataCompat.v(metadata);
            } else {
                mediaMetadataCompat = null;
            }
            List<MediaSession.QueueItem> queue = ((m) ((k) this.f7177g.f428i)).f403a.getQueue();
            if (queue != null) {
                arrayList = MediaSessionCompat$QueueItem.u(queue);
            }
            R0(true, new k1(oVar, O0, mediaMetadataCompat, N0(arrayList), ((m) ((k) this.f7177g.f428i)).f403a.getQueueTitle(), this.f7177g.x(), this.f7177g.z()));
        }
    }

    public final void W() {
        int l10 = l() - 1;
        if (l10 >= V().f6520i) {
            w3 i10 = this.f7183m.f7131a.i(l10, k0());
            j1 j1Var = this.f7183m;
            Y0(new j1(i10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        ((m) ((k) this.f7177g.f428i)).f403a.adjustVolume(-1, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void W0(int r24, long r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r4 = 1
            r5 = 0
            if (r1 < 0) goto L_0x000c
            r6 = 1
            goto L_0x000d
        L_0x000c:
            r6 = 0
        L_0x000d:
            j1.a.b(r6)
            int r6 = r23.U()
            h3.j1 r7 = r0.f7183m
            h3.w3 r7 = r7.f7131a
            g1.u1 r7 = r7.f7421q
            boolean r8 = r7.y()
            if (r8 != 0) goto L_0x0026
            int r8 = r7.x()
            if (r1 >= r8) goto L_0x002c
        L_0x0026:
            boolean r8 = r23.o()
            if (r8 == 0) goto L_0x002d
        L_0x002c:
            return
        L_0x002d:
            r8 = 2
            if (r1 == r6) goto L_0x0059
            h3.j1 r9 = r0.f7183m
            h3.w3 r9 = r9.f7131a
            g1.u1 r9 = r9.f7421q
            h3.c4 r9 = (h3.c4) r9
            long r9 = r9.B(r1)
            r11 = -1
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0052
            android.support.v4.media.session.u r6 = r0.f7177g
            android.support.v4.media.session.q r6 = r6.B()
            android.media.session.MediaController$TransportControls r6 = r6.f413a
            r6.skipToQueueItem(r9)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            goto L_0x005f
        L_0x0052:
            java.lang.String r8 = "Cannot seek to new media item due to the missing queue Id at media item, mediaItemIndex="
            java.lang.String r9 = "MCImplLegacy"
            android.support.v4.media.h.z(r8, r1, r9)
        L_0x0059:
            r1 = 0
            r22 = r6
            r6 = r1
            r1 = r22
        L_0x005f:
            long r8 = r23.j()
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0070
            r2 = 0
            r12 = r2
            r2 = r8
            goto L_0x007f
        L_0x0070:
            android.support.v4.media.session.u r12 = r0.f7177g
            android.support.v4.media.session.q r12 = r12.B()
            android.media.session.MediaController$TransportControls r12 = r12.f413a
            r12.seekTo(r2)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
        L_0x007f:
            if (r6 != 0) goto L_0x00a8
            long r13 = r23.x()
            long r15 = r23.i0()
            int r17 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r17 >= 0) goto L_0x008f
            r8 = r2
            goto L_0x0093
        L_0x008f:
            long r8 = java.lang.Math.max(r2, r13)
        L_0x0093:
            int r13 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r13 != 0) goto L_0x0099
            r10 = 0
            goto L_0x009f
        L_0x0099:
            r10 = 100
            long r10 = r10 * r8
            long r10 = r10 / r15
            int r10 = (int) r10
        L_0x009f:
            long r13 = r8 - r2
            r17 = r8
            r19 = r10
            r20 = r13
            goto L_0x00b2
        L_0x00a8:
            r8 = 0
            r13 = 0
            r17 = r8
            r20 = r17
            r15 = r10
            r19 = 0
        L_0x00b2:
            boolean r8 = r7.y()
            if (r8 != 0) goto L_0x00c4
            g1.t1 r8 = new g1.t1
            r8.<init>()
            g1.t1 r7 = r7.v(r1, r8)
            g1.s0 r7 = r7.f6577j
            goto L_0x00c5
        L_0x00c4:
            r7 = 0
        L_0x00c5:
            g1.j1 r14 = P0(r1, r7, r2, r5)
            h3.j1 r1 = r0.f7183m
            h3.w3 r1 = r1.f7131a
            h3.i4 r2 = Q0(r14, r15, r17, r19, r20)
            h3.w3 r1 = r1.m(r2)
            int r2 = r1.E
            if (r2 == r4) goto L_0x00df
            r2 = 2
            r3 = 0
            h3.w3 r1 = r1.l(r2, r3)
        L_0x00df:
            h3.j1 r2 = new h3.j1
            h3.j1 r3 = r0.f7183m
            h3.h4 r4 = r3.f7132b
            g1.g1 r5 = r3.f7133c
            d9.r0 r3 = r3.f7134d
            r2.<init>(r1, r4, r5, r3)
            r0.Y0(r2, r12, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.l1.W0(int, long):void");
    }

    public final void X(boolean z10) {
        int i10;
        if (l0.f8453a < 23) {
            v.g("MCImplLegacy", "Session doesn't support setting mute state at API level less than 23");
            return;
        }
        if (z10 != k0()) {
            w3 i11 = this.f7183m.f7131a.i(l(), z10);
            j1 j1Var = this.f7183m;
            Y0(new j1(i11, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        if (z10) {
            i10 = -100;
        } else {
            i10 = 100;
        }
        ((m) ((k) this.f7177g.f428i)).f403a.adjustVolume(i10, 1);
    }

    public final void X0(boolean z10, k1 k1Var, j1 j1Var, Integer num, Integer num2) {
        boolean z11;
        boolean z12;
        boolean z13;
        k1 k1Var2 = k1Var;
        j1 j1Var2 = j1Var;
        Integer num3 = num;
        Integer num4 = num2;
        k1 k1Var3 = this.f7181k;
        j1 j1Var3 = this.f7183m;
        if (k1Var3 != k1Var2) {
            this.f7181k = new k1(k1Var2);
        }
        this.f7182l = this.f7181k;
        this.f7183m = j1Var2;
        r0 r0Var = j1Var2.f7134d;
        b0 b0Var = this.f7172b;
        if (z10) {
            b0Var.Q0();
            if (!j1Var3.f7134d.equals(r0Var)) {
                b0Var.R0(new b1(this, j1Var2, 0));
                return;
            }
            return;
        }
        u1 u1Var = j1Var3.f7131a.f7421q;
        w3 w3Var = j1Var2.f7131a;
        boolean equals = u1Var.equals(w3Var.f7421q);
        e eVar = this.f7174d;
        if (!equals) {
            eVar.j(0, new c1(j1Var2, 8));
        }
        if (!l0.a(k1Var3.f7156e, k1Var2.f7156e)) {
            eVar.j(15, new c1(j1Var2, 9));
        }
        if (num3 != null) {
            eVar.j(11, new f0(j1Var3, j1Var2, num3, 1));
        }
        if (num4 != null) {
            eVar.j(1, new g(j1Var2, 22, num4));
        }
        h hVar = t3.f7332a;
        PlaybackStateCompat playbackStateCompat = k1Var3.f7153b;
        if (playbackStateCompat == null || playbackStateCompat.f359h != 7) {
            z11 = false;
        } else {
            z11 = true;
        }
        PlaybackStateCompat playbackStateCompat2 = k1Var2.f7153b;
        if (playbackStateCompat2 == null || playbackStateCompat2.f359h != 7) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z11 || !z12 ? z11 != z12 : playbackStateCompat.f364m != playbackStateCompat2.f364m || !TextUtils.equals(playbackStateCompat.f365n, playbackStateCompat2.f365n)) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z13) {
            d1 o10 = t3.o(playbackStateCompat2);
            eVar.j(10, new d1(0, o10));
            if (o10 != null) {
                eVar.j(10, new d1(1, o10));
            }
        }
        if (k1Var3.f7154c != k1Var2.f7154c) {
            eVar.j(14, new a1(this));
        }
        w3 w3Var2 = j1Var3.f7131a;
        if (w3Var2.E != w3Var.E) {
            eVar.j(4, new c1(j1Var2, 10));
        }
        if (w3Var2.f7430z != w3Var.f7430z) {
            eVar.j(5, new c1(j1Var2, 11));
        }
        if (w3Var2.B != w3Var.B) {
            eVar.j(7, new c1(j1Var2, 0));
        }
        if (!w3Var2.f7418n.equals(w3Var.f7418n)) {
            eVar.j(12, new c1(j1Var2, 1));
        }
        if (w3Var2.f7419o != w3Var.f7419o) {
            eVar.j(8, new c1(j1Var2, 2));
        }
        if (w3Var2.f7420p != w3Var.f7420p) {
            eVar.j(9, new c1(j1Var2, 3));
        }
        if (!w3Var2.f7425u.equals(w3Var.f7425u)) {
            eVar.j(20, new c1(j1Var2, 4));
        }
        if (!w3Var2.f7427w.equals(w3Var.f7427w)) {
            eVar.j(29, new c1(j1Var2, 5));
        }
        if (!(w3Var2.f7428x == w3Var.f7428x && w3Var2.f7429y == w3Var.f7429y)) {
            eVar.j(30, new c1(j1Var2, 6));
        }
        if (!j1Var3.f7133c.equals(j1Var2.f7133c)) {
            eVar.j(13, new c1(j1Var2, 7));
        }
        if (!j1Var3.f7132b.equals(j1Var2.f7132b)) {
            b0Var.R0(new b1(this, j1Var2, 1));
        }
        if (!j1Var3.f7134d.equals(r0Var)) {
            b0Var.R0(new b1(this, j1Var2, 2));
        }
        eVar.g();
    }

    public final boolean Y() {
        return this.f7180j;
    }

    public final void Y0(j1 j1Var, Integer num, Integer num2) {
        X0(false, this.f7181k, j1Var, num, num2);
    }

    public final int Z() {
        return -1;
    }

    public final void a() {
        if (!this.f7179i) {
            this.f7179i = true;
            s sVar = this.f7178h;
            if (sVar != null) {
                sVar.a();
                this.f7178h = null;
            }
            u uVar = this.f7177g;
            if (uVar != null) {
                i1 i1Var = this.f7175e;
                if (i1Var != null) {
                    if (((ConcurrentHashMap) uVar.f430k).remove(i1Var) == null) {
                        Log.w("MediaControllerCompat", "the callback has never been registered");
                    } else {
                        try {
                            ((m) ((k) uVar.f428i)).c(i1Var);
                        } finally {
                            i1Var.n((Handler) null);
                        }
                    }
                    i1Var.f7100d.removeCallbacksAndMessages((Object) null);
                    this.f7177g = null;
                } else {
                    uVar.getClass();
                    throw new IllegalArgumentException("callback must not be null");
                }
            }
            this.f7180j = false;
            this.f7174d.k();
        }
    }

    public final void a0(SurfaceView surfaceView) {
        v.g("MCImplLegacy", "Session doesn't support setting SurfaceView");
    }

    public final int b() {
        return this.f7183m.f7131a.E;
    }

    public final void b0(s0 s0Var) {
        h0(s0Var);
    }

    public final boolean c() {
        return false;
    }

    public final void c0(SurfaceView surfaceView) {
        v.g("MCImplLegacy", "Session doesn't support clearing SurfaceView");
    }

    public final void d(e1 e1Var) {
        if (!e1Var.equals(i())) {
            w3 k10 = this.f7183m.f7131a.k(e1Var);
            j1 j1Var = this.f7183m;
            Y0(new j1(k10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        this.f7177g.B().g(e1Var.f6355h);
    }

    public final void d0(int i10, int i11) {
        e0(i10, i10 + 1, i11);
    }

    public final void e() {
        w3 w3Var = this.f7183m.f7131a;
        if (w3Var.E == 1) {
            w3 l10 = w3Var.l(w3Var.f7421q.y() ? 4 : 2, (d1) null);
            j1 j1Var = this.f7183m;
            Y0(new j1(l10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
            if (S0()) {
                T0();
            }
        }
    }

    public final void e0(int i10, int i11, int i12) {
        boolean z10;
        if (i10 < 0 || i10 > i11 || i12 < 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        a.b(z10);
        c4 c4Var = (c4) this.f7183m.f7131a.f7421q;
        int x10 = c4Var.x();
        int min = Math.min(i11, x10);
        int i13 = min - i10;
        int i14 = (x10 - i13) - 1;
        int min2 = Math.min(i12, i14 + 1);
        if (i10 < x10 && i10 != min && i10 != min2) {
            int U = U();
            if (U >= i10) {
                if (U < min) {
                    U = -1;
                } else {
                    U -= i13;
                }
            }
            if (U == -1) {
                U = l0.h(i10, 0, i14);
                v.g("MCImplLegacy", "Currently playing item will be removed and added back to mimic move. Assumes item at " + U + " would be the new current item");
            }
            if (U >= min2) {
                U += i13;
            }
            ArrayList arrayList = new ArrayList(c4Var.f6962m);
            l0.G(arrayList, i10, min, min2);
            w3 n10 = this.f7183m.f7131a.n(new c4(r0.j(arrayList), c4Var.f6963n), U);
            j1 j1Var = this.f7183m;
            Y0(new j1(n10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
            if (U0()) {
                ArrayList arrayList2 = new ArrayList();
                for (int i15 = 0; i15 < i13; i15++) {
                    arrayList2.add((MediaSessionCompat$QueueItem) this.f7181k.f7155d.get(i10));
                    this.f7177g.J(((MediaSessionCompat$QueueItem) this.f7181k.f7155d.get(i10)).f346h);
                }
                for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                    this.f7177g.k(((MediaSessionCompat$QueueItem) arrayList2.get(i16)).f346h, i16 + min2);
                }
            }
        }
    }

    public final void f(int i10) {
        if (i10 != h()) {
            w3 w3Var = this.f7183m.f7131a;
            u3 g10 = android.support.v4.media.h.g(w3Var, w3Var);
            g10.f7347h = i10;
            w3 a10 = g10.a();
            j1 j1Var = this.f7183m;
            Y0(new j1(a10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        q B = this.f7177g.B();
        int p10 = t3.p(i10);
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", p10);
        B.f(bundle, "android.support.v4.media.session.action.SET_REPEAT_MODE");
    }

    public final int f0() {
        return 0;
    }

    public final void g() {
        w3 w3Var = this.f7183m.f7131a;
        if (w3Var.f7430z) {
            w3 j10 = w3Var.j(1, 0, false);
            j1 j1Var = this.f7183m;
            Y0(new j1(j10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
            if (U0() && S0()) {
                this.f7177g.B().f413a.pause();
            }
        }
    }

    public final void g0(List list) {
        F0(list, Integer.MAX_VALUE);
    }

    public final int h() {
        return this.f7183m.f7131a.f7419o;
    }

    public final void h0(s0 s0Var) {
        y0(s0Var, -9223372036854775807L);
    }

    public final e1 i() {
        return this.f7183m.f7131a.f7418n;
    }

    public final long i0() {
        return this.f7183m.f7131a.f7414j.f7120k;
    }

    public final long j() {
        return this.f7183m.f7131a.f7414j.f7117h.f6435m;
    }

    public final u1 j0() {
        return this.f7183m.f7131a.f7421q;
    }

    public final d1 k() {
        return this.f7183m.f7131a.f7412h;
    }

    public final boolean k0() {
        return this.f7183m.f7131a.f7429y;
    }

    public final int l() {
        return this.f7183m.f7131a.f7428x;
    }

    public final void l0(v0 v0Var) {
        v.g("MCImplLegacy", "Session doesn't support setting playlist metadata");
    }

    public final void m(boolean z10) {
        if (z10) {
            P();
        } else {
            g();
        }
    }

    public final void m0(int i10) {
        s0(i10, i10 + 1);
    }

    public final void n(Surface surface) {
        v.g("MCImplLegacy", "Session doesn't support setting Surface");
    }

    public final void n0() {
        int l10 = l() + 1;
        if (l10 <= V().f6521j) {
            w3 i10 = this.f7183m.f7131a.i(l10, k0());
            j1 j1Var = this.f7183m;
            Y0(new j1(i10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        ((m) ((k) this.f7177g.f428i)).f403a.adjustVolume(1, 1);
    }

    public final boolean o() {
        return this.f7183m.f7131a.f7414j.f7118i;
    }

    public final boolean o0() {
        return this.f7183m.f7131a.f7420p;
    }

    public final void p(int i10) {
        W0(i10, 0);
    }

    public final y1 p0() {
        return y1.H;
    }

    public final long q() {
        return this.f7183m.f7131a.H;
    }

    public final void q0(long j10) {
        W0(U(), j10);
    }

    public final void r(y1 y1Var) {
    }

    public final long r0() {
        return x();
    }

    public final long s() {
        return -9223372036854775807L;
    }

    public final void s0(int i10, int i11) {
        boolean z10;
        if (i10 < 0 || i11 < i10) {
            z10 = false;
        } else {
            z10 = true;
        }
        a.b(z10);
        int x10 = j0().x();
        int min = Math.min(i11, x10);
        if (i10 < x10 && i10 != min) {
            c4 c4Var = (c4) this.f7183m.f7131a.f7421q;
            c4Var.getClass();
            o0 o0Var = new o0();
            r0 r0Var = c4Var.f6962m;
            o0Var.d(r0Var.subList(0, i10));
            o0Var.d(r0Var.subList(min, r0Var.size()));
            c4 c4Var2 = new c4(o0Var.e(), c4Var.f6963n);
            int U = U();
            int i12 = min - i10;
            if (U >= i10) {
                if (U < min) {
                    U = -1;
                } else {
                    U -= i12;
                }
            }
            if (U == -1) {
                U = l0.h(i10, 0, c4Var2.x() - 1);
                v.g("MCImplLegacy", "Currently playing item is removed. Assumes item at " + U + " is the new current item");
            }
            w3 n10 = this.f7183m.f7131a.n(c4Var2, U);
            j1 j1Var = this.f7183m;
            Y0(new j1(n10, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
            if (U0()) {
                while (i10 < min && i10 < this.f7181k.f7155d.size()) {
                    this.f7177g.J(((MediaSessionCompat$QueueItem) this.f7181k.f7155d.get(i10)).f346h);
                    i10++;
                }
            }
        }
    }

    public final void stop() {
        w3 w3Var = this.f7183m.f7131a;
        if (w3Var.E != 1) {
            i4 i4Var = w3Var.f7414j;
            j1 j1Var = i4Var.f7117h;
            long j10 = i4Var.f7120k;
            long j11 = j1Var.f6435m;
            w3 m10 = w3Var.m(Q0(j1Var, j10, j11, t3.b(j11, j10), 0));
            w3 w3Var2 = this.f7183m.f7131a;
            if (w3Var2.E != 1) {
                m10 = m10.l(1, w3Var2.f7412h);
            }
            j1 j1Var2 = this.f7183m;
            Y0(new j1(m10, j1Var2.f7132b, j1Var2.f7133c, j1Var2.f7134d), (Integer) null, (Integer) null);
            this.f7177g.B().f413a.stop();
        }
    }

    public final long t() {
        return j();
    }

    public final void t0(int i10) {
        g1.q V = V();
        if (V.f6520i <= i10 && i10 <= V.f6521j) {
            w3 i11 = this.f7183m.f7131a.i(i10, k0());
            j1 j1Var = this.f7183m;
            Y0(new j1(i11, j1Var.f7132b, j1Var.f7133c, j1Var.f7134d), (Integer) null, (Integer) null);
        }
        ((m) ((k) this.f7177g.f428i)).f403a.setVolumeTo(i10, 1);
    }

    public final long u() {
        return this.f7183m.f7131a.f7414j.f7123n;
    }

    public final void u0() {
        this.f7177g.B().f413a.skipToNext();
    }

    public final void v(int i10, long j10) {
        W0(i10, j10);
    }

    public final void v0() {
        this.f7177g.B().f413a.fastForward();
    }

    public final g1 w() {
        return this.f7183m.f7133c;
    }

    public final void w0(TextureView textureView) {
        v.g("MCImplLegacy", "Session doesn't support setting TextureView");
    }

    public final long x() {
        return this.f7183m.f7131a.f7414j.f7121l;
    }

    public final void x0(i1 i1Var) {
        this.f7174d.a(i1Var);
    }

    public final boolean y() {
        return this.f7183m.f7131a.f7430z;
    }

    public final void y0(s0 s0Var, long j10) {
        L0(0, j10, r0.n(s0Var));
    }

    public final void z() {
        s0(0, Integer.MAX_VALUE);
    }

    public final void z0(i1 i1Var) {
        this.f7174d.l(i1Var);
    }
}

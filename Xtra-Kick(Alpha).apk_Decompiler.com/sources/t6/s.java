package t6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.media.h;
import com.github.andreyasadchy.xtra.ui.player.PlaybackService;
import g1.l1;
import h3.a2;
import h3.b2;
import h3.c2;
import h3.e2;
import h3.f4;
import h3.g2;
import h3.h4;
import h3.j4;
import h9.a0;
import h9.k0;
import h9.z;
import j1.l0;
import java.util.HashSet;
import java.util.List;
import m1.n0;
import m1.u;
import xa.j;

public final class s implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackService f14658a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f14659b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f14660c;

    public s(PlaybackService playbackService, SharedPreferences sharedPreferences, n0 n0Var) {
        this.f14658a = playbackService;
        this.f14659b = sharedPreferences;
        this.f14660c = n0Var;
    }

    public final /* synthetic */ void a() {
    }

    public final /* synthetic */ void b() {
    }

    public final c2 c(g2 g2Var, e2 e2Var) {
        j.f("session", g2Var);
        j.f("controller", e2Var);
        c2 a10 = h.a();
        h4 h4Var = a10.f6955a;
        h4Var.getClass();
        HashSet hashSet = new HashSet(h4Var.f7078h);
        Bundle bundle = Bundle.EMPTY;
        hashSet.add(new f4(bundle, "startStream"));
        hashSet.add(new f4(bundle, "startVideo"));
        hashSet.add(new f4(bundle, "startClip"));
        hashSet.add(new f4(bundle, "startOfflineVideo"));
        hashSet.add(new f4(bundle, "changeQuality"));
        hashSet.add(new f4(bundle, "startAudioOnly"));
        hashSet.add(new f4(bundle, "switchAudioMode"));
        hashSet.add(new f4(bundle, "toggleDynamicsProcessing"));
        hashSet.add(new f4(bundle, "moveBackground"));
        hashSet.add(new f4(bundle, "moveForeground"));
        hashSet.add(new f4(bundle, "clear"));
        hashSet.add(new f4(bundle, "getUrls"));
        hashSet.add(new f4(bundle, "getLastTag"));
        hashSet.add(new f4(bundle, "getQualities"));
        hashSet.add(new f4(bundle, "getQualityText"));
        hashSet.add(new f4(bundle, "getMediaPlaylist"));
        hashSet.add(new f4(bundle, "getMultivariantPlaylist"));
        hashSet.add(new f4(bundle, "getVideoDownloadInfo"));
        hashSet.add(new f4(bundle, "getErrorCode"));
        return new c2(new h4(hashSet), a10.f6956b);
    }

    public final k0 d(g2 g2Var, e2 e2Var, List list, int i10, long j10) {
        return l0.P(i(g2Var, e2Var, list), new a2(i10, j10));
    }

    public final /* synthetic */ void e() {
    }

    public final a0 f(g2 g2Var, e2 e2Var, l1 l1Var) {
        return new a0(new j4(-6));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v25, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r14v3 */
    /* JADX WARNING: type inference failed for: r14v7 */
    /* JADX WARNING: type inference failed for: r14v27 */
    /* JADX WARNING: type inference failed for: r14v28 */
    /* JADX WARNING: type inference failed for: r14v29 */
    /* JADX WARNING: type inference failed for: r14v30 */
    /* JADX WARNING: type inference failed for: r16v3, types: [com.github.andreyasadchy.xtra.model.VideoDownloadInfo] */
    /* JADX WARNING: type inference failed for: r14v31 */
    /* JADX WARNING: type inference failed for: r14v32 */
    /* JADX WARNING: type inference failed for: r14v33 */
    /* JADX WARNING: type inference failed for: r14v34 */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x03d4, code lost:
        r2 = new h9.a0(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0606, code lost:
        if (r6 != null) goto L_0x0679;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0786, code lost:
        if ((r0 instanceof java.util.HashMap) != false) goto L_0x0793;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0791, code lost:
        if ((r0 instanceof java.util.HashMap) != false) goto L_0x0793;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0796, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x099f, code lost:
        r2 = new h9.a0(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x09a5, code lost:
        r2 = new h9.a0(new h3.j4(-6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:?, code lost:
        return r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0684  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final h9.a0 g(h3.g2 r38, h3.e2 r39, h3.f4 r40, android.os.Bundle r41) {
        /*
            r37 = this;
            r1 = r37
            r0 = r40
            java.lang.String r2 = "session"
            r3 = r38
            xa.j.f(r2, r3)
            java.lang.String r2 = "controller"
            r4 = r39
            xa.j.f(r2, r4)
            java.lang.String r2 = "customCommand"
            xa.j.f(r2, r0)
            java.lang.String r2 = "args"
            r4 = r41
            xa.j.f(r2, r4)
            java.lang.String r2 = r0.f7035i
            int r4 = r2.hashCode()
            java.lang.String r5 = "player_speed"
            t6.a0 r6 = t6.a0.NORMAL
            java.lang.String r7 = "player_volume"
            java.lang.String r8 = ""
            android.content.SharedPreferences r9 = r1.f14659b
            java.lang.String r10 = "parse(this)"
            java.lang.String r11 = "item"
            java.lang.String r12 = "result"
            com.github.andreyasadchy.xtra.ui.player.PlaybackService r13 = r1.f14658a
            android.os.Bundle r0 = r0.f7036j
            r15 = 1
            r14 = 0
            switch(r4) {
                case -2129798446: goto L_0x08b8;
                case -1866158462: goto L_0x0748;
                case -1581789895: goto L_0x05db;
                case -1352249452: goto L_0x0597;
                case -1257128153: goto L_0x0560;
                case -1200084586: goto L_0x0539;
                case -1018175014: goto L_0x0446;
                case -847925260: goto L_0x0405;
                case -327827665: goto L_0x03db;
                case -214160197: goto L_0x0316;
                case -166298016: goto L_0x02f2;
                case -75083430: goto L_0x02af;
                case 13873605: goto L_0x027c;
                case 94746189: goto L_0x0224;
                case 130391007: goto L_0x01b5;
                case 319431007: goto L_0x0174;
                case 629175483: goto L_0x00f9;
                case 989782254: goto L_0x00b9;
                case 1367600672: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x09a5
        L_0x003f:
            java.lang.String r0 = "getMediaPlaylist"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0049
            goto L_0x09a5
        L_0x0049:
            la.i[] r0 = new la.i[r15]
            g1.k1 r2 = r38.b()
            java.lang.Object r2 = r2.H0()
            boolean r3 = r2 instanceof q1.m
            if (r3 == 0) goto L_0x005a
            q1.m r2 = (q1.m) r2
            goto L_0x005b
        L_0x005a:
            r2 = r14
        L_0x005b:
            if (r2 == 0) goto L_0x00a1
            r1.l r2 = r2.f13188b
            if (r2 == 0) goto L_0x00a1
            java.util.List r2 = r2.f13622b
            if (r2 == 0) goto L_0x00a1
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0091
            int r3 = r2.size()
            java.util.ListIterator r3 = r2.listIterator(r3)
        L_0x0073:
            boolean r4 = r3.hasPrevious()
            if (r4 == 0) goto L_0x0091
            java.lang.Object r4 = r3.previous()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "ads=true"
            boolean r4 = xa.j.a(r4, r5)
            if (r4 != 0) goto L_0x0073
            int r3 = r3.nextIndex()
            int r3 = r3 + r15
            java.util.List r2 = ma.z.G(r2, r3)
            goto L_0x0093
        L_0x0091:
            ma.b0 r2 = ma.b0.f10801h
        L_0x0093:
            r3 = r2
            if (r3 == 0) goto L_0x00a1
            java.lang.String r4 = "\n"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 62
            java.lang.String r14 = ma.z.y(r3, r4, r5, r6, r7, r8)
        L_0x00a1:
            la.i r2 = new la.i
            r2.<init>(r12, r14)
            r3 = 0
            r0[r3] = r2
            android.os.Bundle r0 = hb.h0.r(r0)
            h3.j4 r2 = new h3.j4
            r2.<init>(r3, r0)
            h9.a0 r0 = new h9.a0
            r0.<init>(r2)
            goto L_0x09b1
        L_0x00b9:
            java.lang.String r0 = "getLastTag"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00c3
            goto L_0x09a5
        L_0x00c3:
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            g1.k1 r3 = r38.b()
            java.lang.Object r3 = r3.H0()
            boolean r4 = r3 instanceof q1.m
            if (r4 == 0) goto L_0x00d6
            q1.m r3 = (q1.m) r3
            goto L_0x00d7
        L_0x00d6:
            r3 = r14
        L_0x00d7:
            if (r3 == 0) goto L_0x00e8
            r1.l r3 = r3.f13188b
            if (r3 == 0) goto L_0x00e8
            java.util.List r3 = r3.f13622b
            if (r3 == 0) goto L_0x00e8
            java.lang.Object r3 = ma.z.A(r3)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
        L_0x00e8:
            la.i r3 = new la.i
            r3.<init>(r12, r14)
            r4 = 0
            r2[r4] = r3
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r4, r2)
            goto L_0x099f
        L_0x00f9:
            java.lang.String r0 = "toggleDynamicsProcessing"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0103
            goto L_0x09a5
        L_0x0103:
            h3.g2 r0 = r13.f3438u
            if (r0 == 0) goto L_0x010c
            g1.k1 r0 = r0.b()
            goto L_0x010d
        L_0x010c:
            r0 = r14
        L_0x010d:
            boolean r2 = r0 instanceof m1.u
            if (r2 == 0) goto L_0x0114
            m1.u r0 = (m1.u) r0
            goto L_0x0115
        L_0x0114:
            r0 = r14
        L_0x0115:
            if (r0 == 0) goto L_0x0153
            android.content.SharedPreferences r2 = hb.h0.l1(r13)
            java.lang.String r3 = "player_audio_compressor"
            r4 = 0
            boolean r2 = r2.getBoolean(r3, r4)
            r2 = r2 ^ r15
            android.content.SharedPreferences r4 = hb.h0.l1(r13)
            android.content.SharedPreferences$Editor r4 = r4.edit()
            java.lang.String r5 = "editor"
            xa.j.e(r5, r4)
            r4.putBoolean(r3, r2)
            r4.apply()
            if (r2 == 0) goto L_0x014b
            android.media.audiofx.DynamicsProcessing r2 = r13.f3441x
            if (r2 != 0) goto L_0x0147
            m1.n0 r0 = (m1.n0) r0
            r0.w1()
            int r0 = r0.Y
            r13.l(r0)
            goto L_0x0153
        L_0x0147:
            r2.setEnabled(true)
            goto L_0x0153
        L_0x014b:
            android.media.audiofx.DynamicsProcessing r0 = r13.f3441x
            if (r0 != 0) goto L_0x0150
            goto L_0x0153
        L_0x0150:
            r0.setEnabled(false)
        L_0x0153:
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            android.media.audiofx.DynamicsProcessing r3 = r13.f3441x
            if (r3 == 0) goto L_0x0163
            boolean r3 = r3.getEnabled()
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r3)
        L_0x0163:
            la.i r3 = new la.i
            r3.<init>(r12, r14)
            r4 = 0
            r2[r4] = r3
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r4, r2)
            goto L_0x03d4
        L_0x0174:
            java.lang.String r0 = "getErrorCode"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x017e
            goto L_0x09a5
        L_0x017e:
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            g1.k1 r3 = r38.b()
            g1.d1 r3 = r3.k()
            if (r3 == 0) goto L_0x0191
            java.lang.Throwable r3 = r3.getCause()
            goto L_0x0192
        L_0x0191:
            r3 = r14
        L_0x0192:
            boolean r4 = r3 instanceof k1.z
            if (r4 == 0) goto L_0x0199
            k1.z r3 = (k1.z) r3
            goto L_0x019a
        L_0x0199:
            r3 = r14
        L_0x019a:
            if (r3 == 0) goto L_0x01a2
            int r3 = r3.f9070k
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
        L_0x01a2:
            la.i r3 = new la.i
            java.lang.String r4 = "result"
            r3.<init>(r4, r14)
            r4 = 0
            r2[r4] = r3
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r4, r2)
            goto L_0x099f
        L_0x01b5:
            java.lang.String r0 = "moveBackground"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x01bf
            goto L_0x09a5
        L_0x01bf:
            java.lang.String r0 = "player_background_playback"
            java.lang.String r2 = "0"
            java.lang.String r0 = r9.getString(r0, r2)
            java.lang.String r2 = "2"
            boolean r0 = xa.j.a(r0, r2)
            if (r0 == 0) goto L_0x01dd
            t6.r r0 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3434y
            r13.m()
        L_0x01d4:
            g1.k1 r0 = r38.b()
            long r4 = r0.j()
            goto L_0x0202
        L_0x01dd:
            t6.a0 r0 = r13.f3439v
            if (r0 != r6) goto L_0x020b
            m1.u r0 = r1.f14660c
            m1.n0 r0 = (m1.n0) r0
            int r2 = r0.b()
            r4 = 4
            if (r2 == r4) goto L_0x01fc
            int r2 = r0.b()
            if (r2 == r15) goto L_0x01fc
            boolean r0 = r0.y()
            if (r0 == 0) goto L_0x01fc
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.k(r13)
            goto L_0x020b
        L_0x01fc:
            r13.m()
            t6.r r0 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3434y
            goto L_0x01d4
        L_0x0202:
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.C = r4
            g1.k1 r0 = r38.b()
            r0.stop()
        L_0x020b:
            r13.f3440w = r15
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            t6.a0 r3 = r13.f3439v
            la.i r4 = new la.i
            r4.<init>(r12, r3)
            r3 = 0
            r2[r3] = r4
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r3, r2)
            goto L_0x03d4
        L_0x0224:
            java.lang.String r0 = "clear"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x022e
            goto L_0x09a5
        L_0x022e:
            t6.r r0 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3434y
            r13.m()
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3435z = r14
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.A = r14
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.B = r14
            r16 = 0
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.C = r16
            r13.f3439v = r6
            r0 = 0
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.D = r0
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.E = r0
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.F = r0
            ma.c0 r2 = ma.j0.d()
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.G = r2
            ma.b0 r2 = ma.b0.f10801h
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.H = r2
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.I = r0
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.J = r0
            h3.g2 r2 = r13.f3438u
            if (r2 == 0) goto L_0x0274
            g1.k1 r2 = r2.b()
            if (r2 == 0) goto L_0x0274
            g1.y1 r3 = r2.p0()
            g1.x1 r3 = r3.i()
            r4 = 2
            r3.i(r4, r0)
            g1.y1 r3 = r3.b()
            r2.r(r3)
            r2.m0(r0)
        L_0x0274:
            h3.j4 r2 = new h3.j4
            r2.<init>(r0)
            r0 = r2
            goto L_0x03d4
        L_0x027c:
            java.lang.String r0 = "switchAudioMode"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0286
            goto L_0x09a5
        L_0x0286:
            t6.a0 r0 = r13.f3439v
            t6.a0 r2 = t6.a0.AUDIO_ONLY
            if (r0 == r2) goto L_0x0293
            t6.r r0 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3434y
            int r0 = t6.r.a(r0)
            goto L_0x0295
        L_0x0293:
            int r0 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.J
        L_0x0295:
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.i(r13, r0)
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            t6.a0 r3 = r13.f3439v
            la.i r4 = new la.i
            r4.<init>(r12, r3)
            r3 = 0
            r2[r3] = r4
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r3, r2)
            goto L_0x099f
        L_0x02af:
            r3 = 0
            java.lang.String r0 = "getUrls"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x02ba
            goto L_0x09a5
        L_0x02ba:
            h3.j4 r0 = new h3.j4
            r2 = 2
            la.i[] r2 = new la.i[r2]
            java.util.Map r4 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.G
            java.util.Set r4 = r4.keySet()
            java.lang.String[] r5 = new java.lang.String[r3]
            java.lang.Object[] r4 = r4.toArray(r5)
            la.i r5 = new la.i
            java.lang.String r6 = "urlsKeys"
            r5.<init>(r6, r4)
            r2[r3] = r5
            java.util.Map r4 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.G
            java.util.Collection r4 = r4.values()
            java.lang.String[] r5 = new java.lang.String[r3]
            java.lang.Object[] r4 = r4.toArray(r5)
            la.i r5 = new la.i
            java.lang.String r6 = "urlsValues"
            r5.<init>(r6, r4)
            r2[r15] = r5
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r3, r2)
            goto L_0x099f
        L_0x02f2:
            java.lang.String r0 = "startAudioOnly"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x02fc
            goto L_0x09a5
        L_0x02fc:
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.k(r13)
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            t6.a0 r3 = r13.f3439v
            la.i r4 = new la.i
            r4.<init>(r12, r3)
            r3 = 0
            r2[r3] = r4
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r3, r2)
            goto L_0x099f
        L_0x0316:
            java.lang.String r0 = "getVideoDownloadInfo"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0320
            goto L_0x09a5
        L_0x0320:
            g1.k1 r0 = r38.b()
            java.lang.Object r0 = r0.H0()
            boolean r2 = r0 instanceof q1.m
            if (r2 == 0) goto L_0x032f
            q1.m r0 = (q1.m) r0
            goto L_0x0330
        L_0x032f:
            r0 = r14
        L_0x0330:
            if (r0 == 0) goto L_0x03c1
            r1.l r0 = r0.f13188b
            if (r0 == 0) goto L_0x03c1
            d9.r0 r2 = r0.f13596r
            java.lang.String r4 = "playlist.segments"
            xa.j.e(r4, r2)
            int r4 = r2.size()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r4)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r4)
            r7 = 0
        L_0x034c:
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r7 >= r4) goto L_0x0372
            java.lang.Object r10 = r2.get(r7)
            java.lang.String r11 = "segments[i]"
            xa.j.e(r11, r10)
            r1.i r10 = (r1.i) r10
            long r13 = r10.f13570l
            long r13 = r13 / r8
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r5.add(r11)
            long r10 = r10.f13568j
            long r10 = r10 / r8
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
            r6.add(r8)
            int r7 = r7 + 1
            goto L_0x034c
        L_0x0372:
            com.github.andreyasadchy.xtra.model.VideoDownloadInfo r14 = new com.github.andreyasadchy.xtra.model.VideoDownloadInfo
            com.github.andreyasadchy.xtra.model.ui.Video r2 = new com.github.andreyasadchy.xtra.model.ui.Video
            r16 = r2
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 262143(0x3ffff, float:3.6734E-40)
            r36 = 0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            java.util.Map r18 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.G
            long r10 = r0.f13599u
            long r21 = r10 / r8
            long r10 = r0.f13591m
            long r23 = r10 / r8
            g1.k1 r0 = r38.b()
            long r25 = r0.j()
            r16 = r14
            r17 = r2
            r19 = r5
            r20 = r6
            r16.<init>(r17, r18, r19, r20, r21, r23, r25)
        L_0x03c1:
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            la.i r3 = new la.i
            r3.<init>(r12, r14)
            r4 = 0
            r2[r4] = r3
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r4, r2)
        L_0x03d4:
            h9.a0 r2 = new h9.a0
            r2.<init>(r0)
            goto L_0x09b0
        L_0x03db:
            java.lang.String r3 = "changeQuality"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x03e5
            goto L_0x09a5
        L_0x03e5:
            java.lang.String r2 = "index"
            int r0 = r0.getInt(r2)
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.i(r13, r0)
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            t6.a0 r3 = r13.f3439v
            la.i r4 = new la.i
            r4.<init>(r12, r3)
            r5 = 0
            r2[r5] = r4
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r5, r2)
            goto L_0x099f
        L_0x0405:
            r5 = 0
            java.lang.String r0 = "moveForeground"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0410
            goto L_0x09a5
        L_0x0410:
            r13.f3440w = r5
            t6.a0 r0 = r13.f3439v
            if (r0 != r6) goto L_0x041e
            g1.k1 r0 = r38.b()
            r0.e()
            goto L_0x042f
        L_0x041e:
            t6.a0 r2 = t6.a0.AUDIO_ONLY
            if (r0 != r2) goto L_0x042f
            int r0 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.I
            t6.r r2 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3434y
            int r2 = t6.r.a(r2)
            if (r0 == r2) goto L_0x042f
            r13.n()
        L_0x042f:
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            t6.a0 r3 = r13.f3439v
            la.i r4 = new la.i
            r4.<init>(r12, r3)
            r3 = 0
            r2[r3] = r4
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r3, r2)
            goto L_0x099f
        L_0x0446:
            r16 = 0
            java.lang.String r4 = "startOfflineVideo"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0452
            goto L_0x09a5
        L_0x0452:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 33
            if (r2 < r4) goto L_0x045d
            java.lang.Object r0 = r0.getParcelable("item", com.github.andreyasadchy.xtra.model.offline.OfflineVideo.class)
            goto L_0x0461
        L_0x045d:
            android.os.Parcelable r0 = r0.getParcelable(r11)
        L_0x0461:
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r0 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r0
            if (r0 == 0) goto L_0x0531
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3435z = r0
            r2 = 2
            la.i[] r4 = new la.i[r2]
            r2 = 2131952346(0x7f1302da, float:1.9541132E38)
            java.lang.String r2 = r13.getString(r2)
            java.lang.String r6 = r0.getUrl()
            la.i r10 = new la.i
            r10.<init>(r2, r6)
            r2 = 0
            r4[r2] = r10
            r2 = 2131951674(0x7f13003a, float:1.953977E38)
            java.lang.String r2 = r13.getString(r2)
            la.i r6 = new la.i
            r6.<init>(r2, r8)
            r4[r15] = r6
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r6 = 2
            int r8 = ma.i0.a(r6)
            r2.<init>(r8)
            r8 = 0
        L_0x0496:
            if (r8 >= r6) goto L_0x04a5
            r6 = r4[r8]
            java.lang.Object r10 = r6.f9799h
            java.lang.Object r6 = r6.f9800i
            r2.put(r10, r6)
            int r8 = r8 + 1
            r6 = 2
            goto L_0x0496
        L_0x04a5:
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.G = r2
            java.util.LinkedList r2 = new java.util.LinkedList
            java.util.Map r4 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.G
            java.util.Set r4 = r4.keySet()
            r2.<init>(r4)
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.H = r2
            g1.k1 r2 = r38.b()
            g1.f0 r4 = new g1.f0
            r4.<init>()
            java.lang.String r6 = r0.getUrl()
            r4.b(r6)
            g1.u0 r6 = new g1.u0
            r6.<init>()
            java.lang.String r8 = r0.getName()
            r6.f6596a = r8
            java.lang.String r8 = r0.getChannelName()
            r6.f6597b = r8
            g1.v0 r8 = new g1.v0
            r8.<init>(r6)
            r4.f6367j = r8
            g1.s0 r4 = r4.a()
            r2.h0(r4)
            g1.k1 r2 = r38.b()
            r4 = 100
            int r4 = r9.getInt(r7, r4)
            float r4 = (float) r4
            r6 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 / r6
            r2.B0(r4)
            g1.k1 r2 = r38.b()
            android.content.SharedPreferences r4 = hb.h0.l1(r13)
            r6 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4.getFloat(r5, r6)
            r2.E0(r4)
            g1.k1 r2 = r38.b()
            r2.e()
            g1.k1 r2 = r38.b()
            r2.m(r15)
            g1.k1 r2 = r38.b()
            java.lang.String r3 = "player_use_videopositions"
            boolean r3 = r9.getBoolean(r3, r15)
            if (r3 == 0) goto L_0x052a
            java.lang.Long r0 = r0.getLastWatchPosition()
            if (r0 == 0) goto L_0x052a
            long r14 = r0.longValue()
            goto L_0x052c
        L_0x052a:
            r14 = r16
        L_0x052c:
            r2.q0(r14)
            la.v r0 = la.v.f9814a
        L_0x0531:
            h3.j4 r0 = new h3.j4
            r2 = 0
            r0.<init>(r2)
            goto L_0x099f
        L_0x0539:
            java.lang.String r0 = "getQualityText"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0543
            goto L_0x09a5
        L_0x0543:
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            java.util.List r3 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.H
            int r4 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.I
            java.lang.Object r3 = ma.z.v(r3, r4)
            la.i r4 = new la.i
            r4.<init>(r12, r3)
            r3 = 0
            r2[r3] = r4
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r3, r2)
            goto L_0x099f
        L_0x0560:
            r3 = 0
            java.lang.String r0 = "getQualities"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x056b
            goto L_0x09a5
        L_0x056b:
            h3.j4 r0 = new h3.j4
            r2 = 2
            la.i[] r2 = new la.i[r2]
            java.util.List r4 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.H
            java.lang.String[] r5 = new java.lang.String[r3]
            java.lang.Object[] r4 = r4.toArray(r5)
            la.i r5 = new la.i
            r5.<init>(r12, r4)
            r2[r3] = r5
            int r4 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.I
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            la.i r5 = new la.i
            java.lang.String r6 = "index"
            r5.<init>(r6, r4)
            r2[r15] = r5
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r3, r2)
            goto L_0x099f
        L_0x0597:
            java.lang.String r0 = "getMultivariantPlaylist"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x05a1
            goto L_0x09a5
        L_0x05a1:
            h3.j4 r0 = new h3.j4
            la.i[] r2 = new la.i[r15]
            g1.k1 r3 = r38.b()
            java.lang.Object r3 = r3.H0()
            boolean r4 = r3 instanceof q1.m
            if (r4 == 0) goto L_0x05b4
            q1.m r3 = (q1.m) r3
            goto L_0x05b5
        L_0x05b4:
            r3 = r14
        L_0x05b5:
            if (r3 == 0) goto L_0x05ca
            r1.o r3 = r3.f13187a
            if (r3 == 0) goto L_0x05ca
            java.util.List r4 = r3.f13622b
            if (r4 == 0) goto L_0x05ca
            java.lang.String r5 = "\n"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 62
            java.lang.String r14 = ma.z.y(r4, r5, r6, r7, r8, r9)
        L_0x05ca:
            la.i r3 = new la.i
            r3.<init>(r12, r14)
            r4 = 0
            r2[r4] = r3
            android.os.Bundle r2 = hb.h0.r(r2)
            r0.<init>(r4, r2)
            goto L_0x099f
        L_0x05db:
            java.lang.String r4 = "startVideo"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x05e5
            goto L_0x09a5
        L_0x05e5:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 33
            if (r2 < r4) goto L_0x05f0
            java.lang.Object r2 = r0.getParcelable("item", com.github.andreyasadchy.xtra.model.ui.Video.class)
            goto L_0x05f4
        L_0x05f0:
            android.os.Parcelable r2 = r0.getParcelable(r11)
        L_0x05f4:
            com.github.andreyasadchy.xtra.model.ui.Video r2 = (com.github.andreyasadchy.xtra.model.ui.Video) r2
            if (r2 == 0) goto L_0x0740
            java.lang.String r4 = "usingPlaylist"
            boolean r4 = r0.getBoolean(r4)
            if (r4 == 0) goto L_0x0609
            java.lang.String r6 = "uri"
            java.lang.String r6 = r0.getString(r6)
            if (r6 == 0) goto L_0x0681
            goto L_0x0679
        L_0x0609:
            java.lang.String r6 = r2.getAnimatedPreviewURL()
            if (r6 == 0) goto L_0x0681
            s7.h r11 = s7.h.f14375a
            java.lang.String r12 = r2.getType()
            r11.getClass()
            java.util.LinkedHashMap r6 = s7.h.k(r6, r12)
            t6.r r11 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3434y
            java.lang.String r11 = "audio_only"
            boolean r11 = r6.containsKey(r11)
            if (r11 == 0) goto L_0x0643
            java.lang.String r8 = "audio_only"
            java.lang.Object r8 = r6.remove(r8)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x0652
            r11 = 2131951674(0x7f13003a, float:1.953977E38)
            java.lang.String r11 = r13.getString(r11)
            java.lang.String r12 = "getString(R.string.audio_only)"
            xa.j.e(r12, r11)
            java.lang.Object r8 = r6.put(r11, r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0652
        L_0x0643:
            r11 = 2131951674(0x7f13003a, float:1.953977E38)
            java.lang.String r11 = r13.getString(r11)
            java.lang.String r12 = "getString(R.string.audio_only)"
            xa.j.e(r12, r11)
            r6.put(r11, r8)
        L_0x0652:
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.G = r6
            java.util.LinkedList r6 = new java.util.LinkedList
            java.util.Map r8 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.G
            java.util.Set r8 = r8.keySet()
            r6.<init>(r8)
            r8 = 2131951676(0x7f13003c, float:1.9539773E38)
            java.lang.String r8 = r13.getString(r8)
            r6.addFirst(r8)
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.H = r6
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.I = r15
            java.util.Map r6 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.G
            java.util.Collection r6 = r6.values()
            java.lang.Object r6 = ma.z.r(r6)
            java.lang.String r6 = (java.lang.String) r6
        L_0x0679:
            android.net.Uri r6 = android.net.Uri.parse(r6)
            xa.j.e(r10, r6)
            goto L_0x0682
        L_0x0681:
            r6 = r14
        L_0x0682:
            if (r6 == 0) goto L_0x0740
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.E = r15
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.D = r4
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3435z = r2
            androidx.media3.exoplayer.hls.HlsMediaSource$Factory r8 = new androidx.media3.exoplayer.hls.HlsMediaSource$Factory
            k1.n r11 = new k1.n
            k1.p r12 = new k1.p
            r12.<init>()
            r11.<init>(r13, r12)
            r8.<init>(r11)
            d6.a r11 = new d6.a
            r11.<init>()
            r8.f1816c = r11
            if (r4 == 0) goto L_0x06b5
            java.lang.String r4 = "player_subtitles"
            r11 = 0
            boolean r4 = r9.getBoolean(r4, r11)
            if (r4 != 0) goto L_0x06b3
            java.lang.String r4 = "player_menu_subtitles"
            boolean r4 = r9.getBoolean(r4, r11)
            if (r4 == 0) goto L_0x06b5
        L_0x06b3:
            r8.f1821h = r11
        L_0x06b5:
            g1.f0 r4 = new g1.f0
            r4.<init>()
            r4.f6359b = r6
            g1.u0 r6 = new g1.u0
            r6.<init>()
            java.lang.String r11 = r2.getTitle()
            r6.f6596a = r11
            java.lang.String r11 = r2.getChannelName()
            r6.f6597b = r11
            java.lang.String r2 = r2.getChannelLogo()
            if (r2 == 0) goto L_0x06db
            android.net.Uri r2 = android.net.Uri.parse(r2)
            xa.j.e(r10, r2)
            goto L_0x06dc
        L_0x06db:
            r2 = r14
        L_0x06dc:
            r6.f6607l = r2
            g1.v0 r2 = new g1.v0
            r2.<init>(r6)
            r4.f6367j = r2
            g1.s0 r2 = r4.a()
            q1.q r2 = r8.a(r2)
            g1.k1 r4 = r38.b()
            boolean r6 = r4 instanceof m1.u
            if (r6 == 0) goto L_0x06f8
            r14 = r4
            m1.u r14 = (m1.u) r14
        L_0x06f8:
            if (r14 == 0) goto L_0x0701
            m1.n0 r14 = (m1.n0) r14
            r14.n1(r2)
            la.v r2 = la.v.f9814a
        L_0x0701:
            g1.k1 r2 = r38.b()
            r4 = 100
            int r4 = r9.getInt(r7, r4)
            float r4 = (float) r4
            r6 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 / r6
            r2.B0(r4)
            g1.k1 r2 = r38.b()
            android.content.SharedPreferences r4 = hb.h0.l1(r13)
            r6 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4.getFloat(r5, r6)
            r2.E0(r4)
            g1.k1 r2 = r38.b()
            r2.e()
            g1.k1 r2 = r38.b()
            r2.m(r15)
            g1.k1 r2 = r38.b()
            java.lang.String r3 = "playbackPosition"
            long r3 = r0.getLong(r3)
            r2.q0(r3)
            la.v r0 = la.v.f9814a
        L_0x0740:
            h3.j4 r0 = new h3.j4
            r2 = 0
            r0.<init>(r2)
            goto L_0x099f
        L_0x0748:
            java.lang.String r4 = "startStream"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0752
            goto L_0x09a5
        L_0x0752:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 33
            if (r2 < r4) goto L_0x075d
            java.lang.Object r4 = r0.getParcelable("item", com.github.andreyasadchy.xtra.model.ui.Stream.class)
            goto L_0x0761
        L_0x075d:
            android.os.Parcelable r4 = r0.getParcelable(r11)
        L_0x0761:
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = (com.github.andreyasadchy.xtra.model.ui.Stream) r4
            if (r4 == 0) goto L_0x08b0
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.D = r15
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.E = r15
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.F = r15
            java.lang.String r5 = "uri"
            java.lang.String r5 = r0.getString(r5)
            if (r5 == 0) goto L_0x077b
            android.net.Uri r5 = android.net.Uri.parse(r5)
            xa.j.e(r10, r5)
            goto L_0x077c
        L_0x077b:
            r5 = r14
        L_0x077c:
            r6 = 33
            if (r2 < r6) goto L_0x0789
            java.io.Serializable r0 = r0.getSerializable("headers", java.util.HashMap.class)
            boolean r2 = r0 instanceof java.util.HashMap
            if (r2 == 0) goto L_0x0796
            goto L_0x0793
        L_0x0789:
            java.lang.String r2 = "headers"
            java.io.Serializable r0 = r0.getSerializable(r2)
            boolean r2 = r0 instanceof java.util.HashMap
            if (r2 == 0) goto L_0x0796
        L_0x0793:
            java.util.HashMap r0 = (java.util.HashMap) r0
            goto L_0x0797
        L_0x0796:
            r0 = r14
        L_0x0797:
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3435z = r4
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.B = r0
            k1.p r2 = new k1.p
            r2.<init>()
            if (r0 == 0) goto L_0x07b6
            k1.a0 r6 = r2.f9045a
            monitor-enter(r6)
            r6.f8965b = r14     // Catch:{ all -> 0x07b3 }
            java.util.HashMap r11 = r6.f8964a     // Catch:{ all -> 0x07b3 }
            r11.clear()     // Catch:{ all -> 0x07b3 }
            java.util.HashMap r11 = r6.f8964a     // Catch:{ all -> 0x07b3 }
            r11.putAll(r0)     // Catch:{ all -> 0x07b3 }
            monitor-exit(r6)
            goto L_0x07b6
        L_0x07b3:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x07b6:
            k1.n r0 = new k1.n
            r0.<init>(r13, r2)
            androidx.media3.exoplayer.hls.HlsMediaSource$Factory r2 = new androidx.media3.exoplayer.hls.HlsMediaSource$Factory
            r2.<init>(r0)
            d6.a r0 = new d6.a
            r0.<init>()
            r2.f1816c = r0
            f3.a r0 = d6.c.f4521v
            r2.f1817d = r0
            a2.i r0 = new a2.i
            r6 = 6
            r0.<init>(r6)
            r2.f1820g = r0
            java.lang.String r0 = "player_subtitles"
            r6 = 0
            boolean r0 = r9.getBoolean(r0, r6)
            if (r0 != 0) goto L_0x07e4
            java.lang.String r0 = "player_menu_subtitles"
            boolean r0 = r9.getBoolean(r0, r6)
            if (r0 == 0) goto L_0x07e6
        L_0x07e4:
            r2.f1821h = r6
        L_0x07e6:
            g1.f0 r0 = new g1.f0
            r0.<init>()
            r0.f6359b = r5
            java.lang.String r5 = "application/x-mpegURL"
            r0.f6360c = r5
            g1.l0 r5 = new g1.l0
            r5.<init>()
            java.lang.String r6 = "player_live_min_speed"
            java.lang.String r6 = r9.getString(r6, r8)
            if (r6 == 0) goto L_0x080a
            java.lang.Float r6 = fb.u.c(r6)
            if (r6 == 0) goto L_0x080a
            float r6 = r6.floatValue()
            r5.f6452d = r6
        L_0x080a:
            java.lang.String r6 = "player_live_max_speed"
            java.lang.String r6 = r9.getString(r6, r8)
            if (r6 == 0) goto L_0x081e
            java.lang.Float r6 = fb.u.c(r6)
            if (r6 == 0) goto L_0x081e
            float r6 = r6.floatValue()
            r5.f6453e = r6
        L_0x081e:
            java.lang.String r6 = "player_live_target_offset"
            java.lang.String r8 = "5000"
            java.lang.String r6 = r9.getString(r6, r8)
            if (r6 == 0) goto L_0x0836
            java.lang.Long r6 = fb.v.e(r6)
            if (r6 == 0) goto L_0x0836
            long r11 = r6.longValue()
            r5.f6449a = r11
            la.v r6 = la.v.f9814a
        L_0x0836:
            g1.m0 r5 = r5.a()
            g1.l0 r6 = new g1.l0
            r6.<init>(r5)
            r0.f6368k = r6
            g1.u0 r5 = new g1.u0
            r5.<init>()
            java.lang.String r6 = r4.getTitle()
            r5.f6596a = r6
            java.lang.String r6 = r4.getChannelName()
            r5.f6597b = r6
            java.lang.String r4 = r4.getChannelLogo()
            if (r4 == 0) goto L_0x0860
            android.net.Uri r4 = android.net.Uri.parse(r4)
            xa.j.e(r10, r4)
            goto L_0x0861
        L_0x0860:
            r4 = r14
        L_0x0861:
            r5.f6607l = r4
            g1.v0 r4 = new g1.v0
            r4.<init>(r5)
            r0.f6367j = r4
            g1.s0 r0 = r0.a()
            q1.q r0 = r2.a(r0)
            g1.k1 r2 = r38.b()
            boolean r4 = r2 instanceof m1.u
            if (r4 == 0) goto L_0x087d
            r14 = r2
            m1.u r14 = (m1.u) r14
        L_0x087d:
            if (r14 == 0) goto L_0x0886
            m1.n0 r14 = (m1.n0) r14
            r14.n1(r0)
            la.v r0 = la.v.f9814a
        L_0x0886:
            g1.k1 r0 = r38.b()
            r2 = 100
            int r2 = r9.getInt(r7, r2)
            float r2 = (float) r2
            r4 = 1120403456(0x42c80000, float:100.0)
            float r2 = r2 / r4
            r0.B0(r2)
            g1.k1 r0 = r38.b()
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.E0(r2)
            g1.k1 r0 = r38.b()
            r0.e()
            g1.k1 r0 = r38.b()
            r0.m(r15)
            la.v r0 = la.v.f9814a
        L_0x08b0:
            h3.j4 r0 = new h3.j4
            r2 = 0
            r0.<init>(r2)
            goto L_0x099f
        L_0x08b8:
            java.lang.String r4 = "startClip"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x08c2
            goto L_0x09a5
        L_0x08c2:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 33
            if (r2 < r4) goto L_0x08cd
            java.lang.Object r2 = r0.getParcelable("item", com.github.andreyasadchy.xtra.model.ui.Clip.class)
            goto L_0x08d1
        L_0x08cd:
            android.os.Parcelable r2 = r0.getParcelable(r11)
        L_0x08d1:
            com.github.andreyasadchy.xtra.model.ui.Clip r2 = (com.github.andreyasadchy.xtra.model.ui.Clip) r2
            if (r2 == 0) goto L_0x0999
            java.lang.String r4 = "urlsKeys"
            java.lang.String[] r4 = r0.getStringArray(r4)
            if (r4 == 0) goto L_0x0999
            java.lang.String r6 = "urlsValues"
            java.lang.String[] r0 = r0.getStringArray(r6)
            if (r0 == 0) goto L_0x0999
            java.util.ArrayList r0 = ma.p.k(r4, r0)
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            ma.j0.h(r0, r4)
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3435z = r2
            r0 = 2131951674(0x7f13003a, float:1.953977E38)
            java.lang.String r0 = r13.getString(r0)
            r4.put(r0, r8)
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.G = r4
            java.util.LinkedList r0 = new java.util.LinkedList
            java.util.Map r6 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.G
            java.util.Set r6 = r6.keySet()
            r0.<init>(r6)
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.H = r0
            com.github.andreyasadchy.xtra.ui.player.PlaybackService.j(r13)
            java.util.Collection r0 = r4.values()
            t6.r r6 = com.github.andreyasadchy.xtra.ui.player.PlaybackService.f3434y
            int r6 = t6.r.c(r6)
            java.lang.Object r0 = ma.z.p(r0, r6)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x092b
            java.util.Collection r0 = r4.values()
            java.lang.Object r0 = ma.z.t(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x092b:
            if (r0 == 0) goto L_0x0999
            g1.k1 r4 = r38.b()
            g1.f0 r6 = new g1.f0
            r6.<init>()
            r6.b(r0)
            g1.u0 r0 = new g1.u0
            r0.<init>()
            java.lang.String r8 = r2.getTitle()
            r0.f6596a = r8
            java.lang.String r8 = r2.getChannelName()
            r0.f6597b = r8
            java.lang.String r2 = r2.getChannelLogo()
            if (r2 == 0) goto L_0x0957
            android.net.Uri r14 = android.net.Uri.parse(r2)
            xa.j.e(r10, r14)
        L_0x0957:
            r0.f6607l = r14
            g1.v0 r2 = new g1.v0
            r2.<init>(r0)
            r6.f6367j = r2
            g1.s0 r0 = r6.a()
            r4.h0(r0)
            g1.k1 r0 = r38.b()
            r2 = 100
            int r2 = r9.getInt(r7, r2)
            float r2 = (float) r2
            r4 = 1120403456(0x42c80000, float:100.0)
            float r2 = r2 / r4
            r0.B0(r2)
            g1.k1 r0 = r38.b()
            android.content.SharedPreferences r2 = hb.h0.l1(r13)
            r4 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2.getFloat(r5, r4)
            r0.E0(r2)
            g1.k1 r0 = r38.b()
            r0.e()
            g1.k1 r0 = r38.b()
            r0.m(r15)
            la.v r0 = la.v.f9814a
        L_0x0999:
            h3.j4 r0 = new h3.j4
            r2 = 0
            r0.<init>(r2)
        L_0x099f:
            h9.a0 r2 = new h9.a0
            r2.<init>(r0)
            goto L_0x09b0
        L_0x09a5:
            h3.j4 r0 = new h3.j4
            r2 = -6
            r0.<init>(r2)
            h9.a0 r2 = new h9.a0
            r2.<init>(r0)
        L_0x09b0:
            r0 = r2
        L_0x09b1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.s.g(h3.g2, h3.e2, h3.f4, android.os.Bundle):h9.a0");
    }

    public final a0 h(g2 g2Var, e2 e2Var, String str, l1 l1Var) {
        return new a0(new j4(-6));
    }

    public final z i(g2 g2Var, e2 e2Var, List list) {
        return new z(new UnsupportedOperationException());
    }
}

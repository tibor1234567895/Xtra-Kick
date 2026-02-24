package com.github.andreyasadchy.xtra.ui.player;

import a2.e;
import a2.i;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.DynamicsProcessing;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.media3.exoplayer.hls.HlsMediaSource$Factory;
import com.github.andreyasadchy.xtra.model.VideoPosition;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import d6.c;
import d9.r0;
import e6.o1;
import e6.z1;
import fb.u;
import g1.f0;
import g1.k1;
import g1.l0;
import g1.s0;
import g1.u0;
import g1.v0;
import g1.w1;
import g1.x1;
import h3.b;
import h3.e2;
import h3.g2;
import h3.l2;
import h3.p4;
import hb.h0;
import j1.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import k1.n;
import la.v;
import m1.k;
import m1.l;
import m1.n0;
import m1.q;
import m1.t;
import ma.b0;
import ma.j0;
import ma.z;
import q0.x;
import t6.a0;
import t6.p;
import t6.r;
import t6.s;
import xa.j;

public final class PlaybackService extends p {
    public static s0 A;
    public static HashMap B;
    public static long C;
    public static boolean D;
    public static boolean E;
    public static boolean F;
    public static Map G = j0.d();
    public static List H = b0.f10801h;
    public static int I;
    public static int J;

    /* renamed from: y  reason: collision with root package name */
    public static final r f3434y = new r(0);

    /* renamed from: z  reason: collision with root package name */
    public static Parcelable f3435z;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public z1 f3436s;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public o1 f3437t;

    /* renamed from: u  reason: collision with root package name */
    public g2 f3438u;

    /* renamed from: v  reason: collision with root package name */
    public a0 f3439v = a0.NORMAL;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3440w;

    /* renamed from: x  reason: collision with root package name */
    public DynamicsProcessing f3441x;

    public static final void i(PlaybackService playbackService, int i10) {
        playbackService.getClass();
        J = I;
        I = i10;
        playbackService.n();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        if (r0 != -1) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016d, code lost:
        if (r0 == -1) goto L_0x0174;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0165 A[LOOP:2: B:35:0x00d5->B:63:0x0165, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0168 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0169 A[EDGE_INSN: B:81:0x0169->B:65:0x0169 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void j(com.github.andreyasadchy.xtra.ui.player.PlaybackService r17) {
        /*
            android.content.SharedPreferences r0 = hb.h0.l1(r17)
            java.lang.String r1 = "player_defaultquality"
            java.lang.String r2 = "saved"
            java.lang.String r0 = r0.getString(r1, r2)
            android.content.SharedPreferences r1 = hb.h0.l1(r17)
            java.lang.String r3 = "player_quality"
            java.lang.String r4 = "720p60"
            java.lang.String r1 = r1.getString(r3, r4)
            java.lang.String r3 = "Source"
            boolean r3 = xa.j.a(r0, r3)
            r5 = 1
            r6 = 0
            r7 = 2
            if (r3 == 0) goto L_0x0035
            boolean r0 = E
            if (r0 == 0) goto L_0x0174
            java.util.List r0 = H
            int r0 = r0.size()
            if (r0 < r7) goto L_0x0174
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            goto L_0x0175
        L_0x0035:
            boolean r2 = xa.j.a(r0, r2)
            r3 = -1
            if (r2 == 0) goto L_0x0053
            java.lang.String r0 = "Auto"
            boolean r0 = xa.j.a(r1, r0)
            if (r0 != 0) goto L_0x0174
            java.util.List r0 = H
            java.lang.String r2 = "<this>"
            xa.j.f(r2, r0)
            int r0 = r0.indexOf(r1)
            if (r0 == r3) goto L_0x0174
            goto L_0x016f
        L_0x0053:
            if (r0 == 0) goto L_0x0174
            java.lang.String r1 = "p"
            java.lang.String[] r2 = new java.lang.String[]{r1}
            java.util.List r0 = fb.y.F(r0, r2)
            java.lang.Object r2 = r0.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = r2.length()
            r10 = 0
        L_0x006f:
            if (r10 >= r9) goto L_0x0081
            char r11 = r2.charAt(r10)
            boolean r12 = java.lang.Character.isDigit(r11)
            if (r12 == 0) goto L_0x007e
            r8.append(r11)
        L_0x007e:
            int r10 = r10 + 1
            goto L_0x006f
        L_0x0081:
            java.lang.String r2 = r8.toString()
            java.lang.String r8 = "filterTo(StringBuilder(), predicate).toString()"
            xa.j.e(r8, r2)
            java.lang.Integer r2 = fb.v.d(r2)
            if (r2 == 0) goto L_0x0174
            int r2 = r2.intValue()
            int r9 = r0.size()
            if (r9 < r7) goto L_0x00ce
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = r0.length()
            r11 = 0
        L_0x00aa:
            if (r11 >= r10) goto L_0x00bc
            char r12 = r0.charAt(r11)
            boolean r13 = java.lang.Character.isDigit(r12)
            if (r13 == 0) goto L_0x00b9
            r9.append(r12)
        L_0x00b9:
            int r11 = r11 + 1
            goto L_0x00aa
        L_0x00bc:
            java.lang.String r0 = r9.toString()
            xa.j.e(r8, r0)
            java.lang.Integer r0 = fb.v.d(r0)
            if (r0 == 0) goto L_0x00ce
            int r0 = r0.intValue()
            goto L_0x00cf
        L_0x00ce:
            r0 = 0
        L_0x00cf:
            java.util.List r9 = H
            java.util.Iterator r10 = r9.iterator()
        L_0x00d5:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0168
            java.lang.Object r11 = r10.next()
            r12 = r11
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String[] r13 = new java.lang.String[]{r1}
            java.util.List r12 = fb.y.F(r12, r13)
            java.lang.Object r13 = r12.get(r6)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            int r15 = r13.length()
            r4 = 0
        L_0x00fa:
            if (r4 >= r15) goto L_0x010d
            char r6 = r13.charAt(r4)
            boolean r16 = java.lang.Character.isDigit(r6)
            if (r16 == 0) goto L_0x0109
            r14.append(r6)
        L_0x0109:
            int r4 = r4 + 1
            r6 = 0
            goto L_0x00fa
        L_0x010d:
            java.lang.String r4 = r14.toString()
            xa.j.e(r8, r4)
            java.lang.Integer r4 = fb.v.d(r4)
            if (r4 == 0) goto L_0x0161
            int r4 = r4.intValue()
            int r6 = r12.size()
            if (r6 < r7) goto L_0x0158
            java.lang.Object r6 = r12.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r13 = r6.length()
            r14 = 0
        L_0x0134:
            if (r14 >= r13) goto L_0x0146
            char r15 = r6.charAt(r14)
            boolean r16 = java.lang.Character.isDigit(r15)
            if (r16 == 0) goto L_0x0143
            r12.append(r15)
        L_0x0143:
            int r14 = r14 + 1
            goto L_0x0134
        L_0x0146:
            java.lang.String r6 = r12.toString()
            xa.j.e(r8, r6)
            java.lang.Integer r6 = fb.v.d(r6)
            if (r6 == 0) goto L_0x0158
            int r6 = r6.intValue()
            goto L_0x0159
        L_0x0158:
            r6 = 0
        L_0x0159:
            if (r2 != r4) goto L_0x015d
            if (r0 >= r6) goto L_0x015f
        L_0x015d:
            if (r2 <= r4) goto L_0x0161
        L_0x015f:
            r4 = 1
            goto L_0x0162
        L_0x0161:
            r4 = 0
        L_0x0162:
            if (r4 == 0) goto L_0x0165
            goto L_0x0169
        L_0x0165:
            r6 = 0
            goto L_0x00d5
        L_0x0168:
            r11 = 0
        L_0x0169:
            int r0 = r9.indexOf(r11)
            if (r0 == r3) goto L_0x0174
        L_0x016f:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0175
        L_0x0174:
            r4 = 0
        L_0x0175:
            if (r4 == 0) goto L_0x017c
            int r6 = r4.intValue()
            goto L_0x017d
        L_0x017c:
            r6 = 0
        L_0x017d:
            I = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.player.PlaybackService.j(com.github.andreyasadchy.xtra.ui.player.PlaybackService):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void k(com.github.andreyasadchy.xtra.ui.player.PlaybackService r7) {
        /*
            h3.g2 r0 = r7.f3438u
            if (r0 == 0) goto L_0x0099
            g1.k1 r0 = r0.b()
            if (r0 == 0) goto L_0x0099
            android.content.SharedPreferences r1 = hb.h0.l1(r7)
            java.lang.String r2 = "player_use_background_audio_track"
            r3 = 0
            boolean r1 = r1.getBoolean(r2, r3)
            r2 = 1
            r4 = 0
            t6.r r5 = f3434y
            if (r1 == 0) goto L_0x0048
            java.util.Map r1 = G
            java.util.Set r1 = r1.entrySet()
            int r6 = t6.r.b(r5)
            java.lang.Object r1 = ma.z.p(r1, r6)
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0035
        L_0x0034:
            r1 = r4
        L_0x0035:
            if (r1 == 0) goto L_0x0040
            boolean r1 = fb.w.h(r1)
            if (r1 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r1 = 0
            goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            if (r1 != 0) goto L_0x0048
            int r3 = t6.r.b(r5)
            goto L_0x0073
        L_0x0048:
            java.util.Map r1 = G
            java.util.Set r1 = r1.entrySet()
            int r6 = t6.r.c(r5)
            java.lang.Object r1 = ma.z.p(r1, r6)
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 == 0) goto L_0x0061
            java.lang.Object r1 = r1.getValue()
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
        L_0x0061:
            if (r4 == 0) goto L_0x006c
            boolean r1 = fb.w.h(r4)
            if (r1 == 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r1 = 0
            goto L_0x006d
        L_0x006c:
            r1 = 1
        L_0x006d:
            if (r1 != 0) goto L_0x0073
            int r3 = t6.r.c(r5)
        L_0x0073:
            android.content.SharedPreferences r1 = hb.h0.l1(r7)
            java.lang.String r4 = "player_disable_background_video"
            boolean r1 = r1.getBoolean(r4, r2)
            if (r1 == 0) goto L_0x0092
            g1.y1 r1 = r0.p0()
            g1.x1 r1 = r1.i()
            r4 = 2
            r1.i(r4, r2)
            g1.y1 r1 = r1.b()
            r0.r(r1)
        L_0x0092:
            t6.a0 r0 = t6.a0.AUDIO_ONLY
            r7.f3439v = r0
            r7.o(r3)
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.player.PlaybackService.k(com.github.andreyasadchy.xtra.ui.player.PlaybackService):void");
    }

    public final g2 e(e2 e2Var) {
        return this.f3438u;
    }

    public final void l(int i10) {
        DynamicsProcessing dynamicsProcessing = this.f3441x;
        if (dynamicsProcessing != null) {
            dynamicsProcessing.release();
        }
        if (Build.VERSION.SDK_INT >= 28 && h0.l1(this).getBoolean("player_audio_compressor", false)) {
            x.h();
            DynamicsProcessing f10 = x.f(i10);
            int c10 = f10.getChannelCount();
            for (int i11 = 0; i11 < c10; i11++) {
                int b10 = f10.getMbcByChannelIndex(i11).getBandCount();
                for (int i12 = 0; i12 < b10; i12++) {
                    DynamicsProcessing.MbcBand e10 = f10.getMbcBandByChannelIndex(i11, i12);
                    e10.setAttackTime(0.0f);
                    e10.setReleaseTime(0.25f);
                    e10.setRatio(1.6f);
                    e10.setThreshold(-50.0f);
                    e10.setKneeWidth(40.0f);
                    e10.setPreGain(0.0f);
                    e10.setPostGain(10.0f);
                    v vVar = v.f9814a;
                    f10.setMbcBandByChannelIndex(i11, i12, e10);
                }
            }
            f10.setEnabled(true);
            this.f3441x = f10;
        }
    }

    public final void m() {
        g2 g2Var;
        k1 b10;
        Long e10;
        Parcelable parcelable = f3435z;
        if (parcelable != null && (g2Var = this.f3438u) != null && (b10 = g2Var.b()) != null) {
            long j10 = b10.j();
            if (!h0.l1(this).getBoolean("player_use_videopositions", true)) {
                return;
            }
            if (parcelable instanceof Video) {
                String uuid = ((Video) parcelable).getUuid();
                if (uuid != null && (e10 = fb.v.e(uuid)) != null) {
                    long longValue = e10.longValue();
                    z1 z1Var = this.f3436s;
                    if (z1Var != null) {
                        z1Var.d(new VideoPosition(longValue, j10));
                    } else {
                        j.l("playerRepository");
                        throw null;
                    }
                }
            } else if (parcelable instanceof OfflineVideo) {
                o1 o1Var = this.f3437t;
                if (o1Var != null) {
                    o1Var.c(((OfflineVideo) parcelable).getId(), j10);
                } else {
                    j.l("offlineRepository");
                    throw null;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r10 = this;
            h3.g2 r0 = r10.f3438u
            if (r0 == 0) goto L_0x014f
            g1.k1 r0 = r0.b()
            if (r0 == 0) goto L_0x014f
            t6.a0 r1 = r10.f3439v
            t6.a0 r2 = t6.a0.NORMAL
            t6.a0 r3 = t6.a0.DISABLED
            t6.a0 r4 = t6.a0.AUDIO_ONLY
            r5 = 0
            r6 = 1
            r7 = 2
            r8 = 0
            if (r1 == r2) goto L_0x0070
            r10.f3439v = r2
            if (r1 != r4) goto L_0x006b
            g1.y1 r1 = r0.p0()
            g1.x1 r1 = r1.i()
            r1.i(r7, r5)
            g1.y1 r1 = r1.b()
            r0.r(r1)
            g1.a2 r1 = r0.D()
            d9.r0 r1 = r1.f6289h
            java.lang.String r2 = "player.currentTracks.groups"
            xa.j.e(r2, r1)
            java.util.Iterator r1 = r1.iterator()
        L_0x003d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0056
            java.lang.Object r2 = r1.next()
            r9 = r2
            g1.z1 r9 = (g1.z1) r9
            g1.v1 r9 = r9.f6778i
            int r9 = r9.f6675j
            if (r9 != r7) goto L_0x0052
            r9 = 1
            goto L_0x0053
        L_0x0052:
            r9 = 0
        L_0x0053:
            if (r9 == 0) goto L_0x003d
            goto L_0x0057
        L_0x0056:
            r2 = r8
        L_0x0057:
            if (r2 != 0) goto L_0x0070
            long r1 = r0.j()
            g1.s0 r9 = A
            if (r9 == 0) goto L_0x0064
            r0.h0(r9)
        L_0x0064:
            r0.e()
            r0.q0(r1)
            goto L_0x0070
        L_0x006b:
            if (r1 != r3) goto L_0x0070
            r0.e()
        L_0x0070:
            int r1 = I
            t6.r r2 = f3434y
            int r9 = t6.r.a(r2)
            if (r1 <= r9) goto L_0x0081
            r0.stop()
            r10.f3439v = r3
            goto L_0x014f
        L_0x0081:
            int r1 = I
            int r3 = t6.r.a(r2)
            r9 = -1
            if (r1 != r3) goto L_0x0107
            java.util.Map r1 = G
            java.util.Set r1 = r1.entrySet()
            int r3 = t6.r.b(r2)
            java.lang.Object r1 = ma.z.p(r1, r3)
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x00a4
        L_0x00a3:
            r1 = r8
        L_0x00a4:
            if (r1 == 0) goto L_0x00af
            boolean r1 = fb.w.h(r1)
            if (r1 == 0) goto L_0x00ad
            goto L_0x00af
        L_0x00ad:
            r1 = 0
            goto L_0x00b0
        L_0x00af:
            r1 = 1
        L_0x00b0:
            if (r1 != 0) goto L_0x00b7
            int r5 = t6.r.b(r2)
            goto L_0x00ef
        L_0x00b7:
            java.util.Map r1 = G
            java.util.Set r1 = r1.entrySet()
            boolean r2 = E
            if (r2 == 0) goto L_0x00c5
            int r2 = J
            int r2 = r2 + r9
            goto L_0x00c7
        L_0x00c5:
            int r2 = J
        L_0x00c7:
            java.lang.Object r1 = ma.z.p(r1, r2)
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 == 0) goto L_0x00d6
            java.lang.Object r1 = r1.getValue()
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8
        L_0x00d6:
            if (r8 == 0) goto L_0x00e1
            boolean r1 = fb.w.h(r8)
            if (r1 == 0) goto L_0x00df
            goto L_0x00e1
        L_0x00df:
            r1 = 0
            goto L_0x00e2
        L_0x00e1:
            r1 = 1
        L_0x00e2:
            if (r1 != 0) goto L_0x00ef
            boolean r1 = E
            if (r1 == 0) goto L_0x00ec
            int r1 = J
            int r1 = r1 + r9
            goto L_0x00ee
        L_0x00ec:
            int r1 = J
        L_0x00ee:
            r5 = r1
        L_0x00ef:
            g1.y1 r1 = r0.p0()
            g1.x1 r1 = r1.i()
            r1.i(r7, r6)
            g1.y1 r1 = r1.b()
            r0.r(r1)
            r10.f3439v = r4
            r10.o(r5)
            goto L_0x014f
        L_0x0107:
            int r0 = t6.r.c(r2)
            r10.o(r0)
            android.content.SharedPreferences r0 = hb.h0.l1(r10)
            java.lang.String r1 = "player_defaultquality"
            java.lang.String r3 = "saved"
            java.lang.String r0 = r0.getString(r1, r3)
            boolean r0 = xa.j.a(r0, r3)
            if (r0 == 0) goto L_0x014f
            int r0 = I
            if (r0 != r9) goto L_0x0127
            java.lang.String r8 = "Auto"
            goto L_0x0138
        L_0x0127:
            int r1 = t6.r.a(r2)
            if (r0 >= r1) goto L_0x0138
            java.util.List r0 = H
            int r1 = I
            java.lang.Object r0 = ma.z.v(r0, r1)
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
        L_0x0138:
            if (r8 == 0) goto L_0x014f
            android.content.SharedPreferences r0 = hb.h0.l1(r10)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = "editor"
            xa.j.e(r1, r0)
            java.lang.String r1 = "player_quality"
            r0.putString(r1, r8)
            r0.apply()
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.player.PlaybackService.n():void");
    }

    public final void o(int i10) {
        k1 b10;
        Object obj;
        boolean z10;
        g2 g2Var = this.f3438u;
        if (g2Var != null && (b10 = g2Var.b()) != null) {
            if (!D || i10 == r.b(f3434y)) {
                String str = (String) z.p(G.values(), i10);
                if (str != null) {
                    long j10 = b10.j();
                    s0 J0 = b10.J0();
                    if (J0 != null) {
                        A = J0;
                        f0 f0Var = new f0(J0);
                        f0Var.b(str);
                        b10.h0(f0Var.a());
                    }
                    b10.e();
                    b10.q0(j10);
                    return;
                }
                return;
            }
            x1 i11 = b10.p0().i();
            if (i10 == -1) {
                i11.d(2);
            } else if (!b10.D().f6289h.isEmpty()) {
                r0 r0Var = b10.D().f6289h;
                j.e("player.currentTracks.groups", r0Var);
                Iterator it = r0Var.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((g1.z1) obj).f6778i.f6675j == 2) {
                        z10 = true;
                        continue;
                    } else {
                        z10 = false;
                        continue;
                    }
                    if (z10) {
                        break;
                    }
                }
                g1.z1 z1Var = (g1.z1) obj;
                if (z1Var != null && z1Var.f6777h - 1 >= i10) {
                    i11.h(new w1(z1Var.f6778i, i10));
                }
            }
            b10.r(i11.b());
        }
    }

    public final void onCreate() {
        int i10;
        int i11;
        int i12;
        int i13;
        long j10;
        boolean z10;
        boolean z11;
        f0 f0Var;
        v0 v0Var;
        Uri uri;
        Uri uri2;
        Uri uri3;
        Long e10;
        Float c10;
        Float c11;
        int i14;
        Long e11;
        Long e12;
        Integer d10;
        Integer d11;
        Integer d12;
        Integer d13;
        super.onCreate();
        SharedPreferences l12 = h0.l1(this);
        t tVar = new t(this);
        k kVar = new k();
        String string = l12.getString("player_buffer_min", "15000");
        if (string == null || (d13 = fb.v.d(string)) == null) {
            i10 = 15000;
        } else {
            i10 = d13.intValue();
        }
        String string2 = l12.getString("player_buffer_max", "50000");
        if (string2 == null || (d12 = fb.v.d(string2)) == null) {
            i11 = 50000;
        } else {
            i11 = d12.intValue();
        }
        String string3 = l12.getString("player_buffer_playback", "2000");
        if (string3 == null || (d11 = fb.v.d(string3)) == null) {
            i12 = 2000;
        } else {
            i12 = d11.intValue();
        }
        String string4 = l12.getString("player_buffer_rebuffer", "5000");
        if (string4 == null || (d10 = fb.v.d(string4)) == null) {
            i13 = 5000;
        } else {
            i13 = d10.intValue();
        }
        a.e(!kVar.f10313g);
        l.a(i12, 0, "bufferForPlaybackMs", "0");
        l.a(i13, 0, "bufferForPlaybackAfterRebufferMs", "0");
        l.a(i10, i12, "minBufferMs", "bufferForPlaybackMs");
        l.a(i10, i13, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        l.a(i11, i10, "maxBufferMs", "minBufferMs");
        kVar.f10308b = i10;
        kVar.f10309c = i11;
        kVar.f10310d = i12;
        kVar.f10311e = i13;
        a.e(!kVar.f10313g);
        kVar.f10313g = true;
        if (kVar.f10307a == null) {
            kVar.f10307a = new e();
        }
        l lVar = new l(kVar.f10307a, kVar.f10308b, kVar.f10309c, kVar.f10310d, kVar.f10311e, kVar.f10312f);
        a.e(!tVar.f10492t);
        tVar.f10478f = new q(0, lVar);
        String string5 = l12.getString("playerRewind", "10000");
        long j11 = 10000;
        if (string5 == null || (e12 = fb.v.e(string5)) == null) {
            j10 = 10000;
        } else {
            j10 = e12.longValue();
        }
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        a.e(!tVar.f10492t);
        tVar.f10486n = j10;
        String string6 = l12.getString("playerForward", "10000");
        if (!(string6 == null || (e11 = fb.v.e(string6)) == null)) {
            j11 = e11.longValue();
        }
        if (j11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        a.b(z11);
        a.e(!tVar.f10492t);
        tVar.f10487o = j11;
        a.e(!tVar.f10492t);
        tVar.f10492t = true;
        n0 n0Var = new n0(tVar);
        if (f3435z != null) {
            String str = (String) z.p(G.values(), r.c(f3434y));
            if (str == null) {
                Collection values = G.values();
                if (E) {
                    i14 = J - 1;
                } else {
                    i14 = J;
                }
                str = (String) z.p(values, i14);
                if (str == null) {
                    str = (String) z.t(G.values());
                }
            }
            if (str != null) {
                Parcelable parcelable = f3435z;
                if (parcelable instanceof Stream) {
                    j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.Stream", parcelable);
                    Stream stream = (Stream) parcelable;
                    k1.p pVar = new k1.p();
                    HashMap hashMap = B;
                    if (hashMap != null) {
                        k1.a0 a0Var = pVar.f9045a;
                        synchronized (a0Var) {
                            a0Var.f8965b = null;
                            a0Var.f8964a.clear();
                            a0Var.f8964a.putAll(hashMap);
                        }
                    }
                    HlsMediaSource$Factory hlsMediaSource$Factory = new HlsMediaSource$Factory(new n(this, pVar));
                    hlsMediaSource$Factory.f1816c = new d6.a();
                    hlsMediaSource$Factory.f1817d = c.f4521v;
                    hlsMediaSource$Factory.f1820g = new i(6);
                    if (l12.getBoolean("player_subtitles", false) || l12.getBoolean("player_menu_subtitles", false)) {
                        hlsMediaSource$Factory.f1821h = false;
                    }
                    f0 f0Var2 = new f0();
                    f0Var2.b(str);
                    f0Var2.f6360c = "application/x-mpegURL";
                    l0 l0Var = new l0();
                    String string7 = l12.getString("player_live_min_speed", "");
                    if (!(string7 == null || (c11 = u.c(string7)) == null)) {
                        l0Var.f6452d = c11.floatValue();
                    }
                    String string8 = l12.getString("player_live_max_speed", "");
                    if (!(string8 == null || (c10 = u.c(string8)) == null)) {
                        l0Var.f6453e = c10.floatValue();
                    }
                    String string9 = l12.getString("player_live_target_offset", "5000");
                    if (!(string9 == null || (e10 = fb.v.e(string9)) == null)) {
                        l0Var.f6449a = e10.longValue();
                    }
                    f0Var2.f6368k = new l0(l0Var.a());
                    u0 u0Var = new u0();
                    u0Var.f6596a = stream.getTitle();
                    u0Var.f6597b = stream.getChannelName();
                    String channelLogo = stream.getChannelLogo();
                    if (channelLogo != null) {
                        uri3 = Uri.parse(channelLogo);
                        j.e("parse(this)", uri3);
                    } else {
                        uri3 = null;
                    }
                    u0Var.f6607l = uri3;
                    f0Var2.f6367j = new v0(u0Var);
                    n0Var.n1(hlsMediaSource$Factory.a(f0Var2.a()));
                    n0Var.B0(((float) l12.getInt("player_volume", 100)) / 100.0f);
                    n0Var.E0(1.0f);
                    n0Var.e();
                    n0Var.m(true);
                } else {
                    if (parcelable instanceof Video) {
                        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.Video", parcelable);
                        Video video = (Video) parcelable;
                        HlsMediaSource$Factory hlsMediaSource$Factory2 = new HlsMediaSource$Factory(new n(this, new k1.p()));
                        hlsMediaSource$Factory2.f1816c = new d6.a();
                        if (D && (l12.getBoolean("player_subtitles", false) || l12.getBoolean("player_menu_subtitles", false))) {
                            hlsMediaSource$Factory2.f1821h = false;
                        }
                        f0 f0Var3 = new f0();
                        f0Var3.b(str);
                        u0 u0Var2 = new u0();
                        u0Var2.f6596a = video.getTitle();
                        u0Var2.f6597b = video.getChannelName();
                        String channelLogo2 = video.getChannelLogo();
                        if (channelLogo2 != null) {
                            uri2 = Uri.parse(channelLogo2);
                            j.e("parse(this)", uri2);
                        } else {
                            uri2 = null;
                        }
                        u0Var2.f6607l = uri2;
                        f0Var3.f6367j = new v0(u0Var2);
                        n0Var.n1(hlsMediaSource$Factory2.a(f0Var3.a()));
                    } else {
                        if (parcelable instanceof Clip) {
                            j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.Clip", parcelable);
                            Clip clip = (Clip) parcelable;
                            f0Var = new f0();
                            f0Var.b(str);
                            u0 u0Var3 = new u0();
                            u0Var3.f6596a = clip.getTitle();
                            u0Var3.f6597b = clip.getChannelName();
                            String channelLogo3 = clip.getChannelLogo();
                            if (channelLogo3 != null) {
                                uri = Uri.parse(channelLogo3);
                                j.e("parse(this)", uri);
                            } else {
                                uri = null;
                            }
                            u0Var3.f6607l = uri;
                            v0Var = new v0(u0Var3);
                        } else if (parcelable instanceof OfflineVideo) {
                            j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.offline.OfflineVideo", parcelable);
                            OfflineVideo offlineVideo = (OfflineVideo) parcelable;
                            f0Var = new f0();
                            f0Var.b(str);
                            u0 u0Var4 = new u0();
                            u0Var4.f6596a = offlineVideo.getName();
                            u0Var4.f6597b = offlineVideo.getChannelName();
                            v0Var = new v0(u0Var4);
                        }
                        f0Var.f6367j = v0Var;
                        n0Var.h0(f0Var.a());
                    }
                    n0Var.B0(((float) l12.getInt("player_volume", 100)) / 100.0f);
                    n0Var.E0(h0.l1(this).getFloat("player_speed", 1.0f));
                    n0Var.e();
                    n0Var.m(true);
                    n0Var.S0(5, C);
                }
                n();
            }
        }
        n0Var.w1();
        l(n0Var.Y);
        n0Var.f10388l.a(new l2(this, n0Var));
        new h3.z1();
        Bundle bundle = Bundle.EMPTY;
        Intent intent = new Intent(this, MainActivity.class);
        int i15 = 67108864;
        intent.setFlags(67108864);
        intent.putExtra("code", 2);
        v vVar = v.f9814a;
        if (Build.VERSION.SDK_INT < 31) {
            i15 = 134217728;
        }
        PendingIntent activity = PendingIntent.getActivity(this, 2, intent, i15);
        activity.getClass();
        this.f3438u = new g2(this, "", n0Var, activity, new s(this, l12, n0Var), bundle, new b(new p4()));
    }

    public final void onDestroy() {
        g2 g2Var = this.f3438u;
        if (g2Var != null) {
            g2Var.b().a();
            try {
                synchronized (g2.f7045b) {
                    g2.f7046c.remove(g2Var.f7047a.f7235h);
                }
                g2Var.f7047a.j();
            } catch (Exception unused) {
            }
            this.f3438u = null;
        }
        super.onDestroy();
    }

    public final void onTaskRemoved(Intent intent) {
        k1 b10;
        k1 b11;
        m();
        g2 g2Var = this.f3438u;
        if (!(g2Var == null || (b11 = g2Var.b()) == null)) {
            b11.g();
        }
        g2 g2Var2 = this.f3438u;
        if (!(g2Var2 == null || (b10 = g2Var2.b()) == null)) {
            b10.stop();
        }
        stopSelf();
    }
}

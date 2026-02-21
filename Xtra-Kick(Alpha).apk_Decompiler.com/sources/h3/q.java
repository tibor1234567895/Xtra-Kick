package h3;

import android.os.Binder;
import android.os.IBinder;

public abstract class q extends Binder implements r {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f7289c = 0;

    public q() {
        attachInterface(this, "androidx.media3.session.IMediaSession");
    }

    public final IBinder asBinder() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v44, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v50, resolved type: h3.p1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v56, resolved type: h3.p1} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v32, types: [android.view.Surface] */
    /* JADX WARNING: type inference failed for: r11v47 */
    /* JADX WARNING: type inference failed for: r11v53 */
    /* JADX WARNING: type inference failed for: r11v59 */
    /* JADX WARNING: type inference failed for: r11v60 */
    /* JADX WARNING: type inference failed for: r11v61 */
    /* JADX WARNING: type inference failed for: r11v62 */
    /* JADX WARNING: type inference failed for: r11v63 */
    /* JADX WARNING: type inference failed for: r11v64 */
    /* JADX WARNING: type inference failed for: r11v65 */
    /* JADX WARNING: type inference failed for: r11v66 */
    /* JADX WARNING: type inference failed for: r11v67 */
    /* JADX WARNING: type inference failed for: r11v68 */
    /* JADX WARNING: type inference failed for: r11v69 */
    /* JADX WARNING: type inference failed for: r11v70 */
    /* JADX WARNING: type inference failed for: r11v71 */
    /* JADX WARNING: type inference failed for: r11v72 */
    /* JADX WARNING: type inference failed for: r11v73 */
    /* JADX WARNING: type inference failed for: r11v74 */
    /* JADX WARNING: type inference failed for: r11v75 */
    /* JADX WARNING: type inference failed for: r11v76 */
    /* JADX WARNING: type inference failed for: r11v77 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTransact(int r19, android.os.Parcel r20, android.os.Parcel r21, int r22) {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
            r3 = 1
            java.lang.String r4 = "androidx.media3.session.IMediaSession"
            if (r0 == r2) goto L_0x0724
            r2 = 2
            r5 = 40010(0x9c4a, float:5.6066E-41)
            java.lang.String r6 = "Ignoring malformed Bundle for Rating"
            java.lang.String r7 = "Ignoring malformed Bundle for MediaItem"
            r8 = 20
            r9 = 0
            java.lang.String r10 = "MediaSessionStub"
            r11 = 0
            switch(r0) {
                case 3002: goto L_0x0521;
                case 3003: goto L_0x050d;
                case 3004: goto L_0x04fd;
                case 3005: goto L_0x04ed;
                case 3006: goto L_0x04d6;
                case 3007: goto L_0x04b7;
                case 3008: goto L_0x0493;
                case 3009: goto L_0x046d;
                case 3010: goto L_0x0459;
                case 3011: goto L_0x043e;
                case 3012: goto L_0x0422;
                case 3013: goto L_0x040b;
                case 3014: goto L_0x03ec;
                case 3015: goto L_0x03cd;
                case 3016: goto L_0x039e;
                case 3017: goto L_0x038a;
                case 3018: goto L_0x0373;
                case 3019: goto L_0x035f;
                case 3020: goto L_0x0347;
                case 3021: goto L_0x0337;
                case 3022: goto L_0x031f;
                case 3023: goto L_0x0303;
                case 3024: goto L_0x02f3;
                case 3025: goto L_0x02e3;
                case 3026: goto L_0x02d3;
                case 3027: goto L_0x02b4;
                case 3028: goto L_0x02a0;
                case 3029: goto L_0x025b;
                case 3030: goto L_0x0212;
                case 3031: goto L_0x01fe;
                case 3032: goto L_0x01e6;
                case 3033: goto L_0x01c7;
                case 3034: goto L_0x01b7;
                case 3035: goto L_0x01a7;
                case 3036: goto L_0x0197;
                case 3037: goto L_0x0183;
                case 3038: goto L_0x016f;
                case 3039: goto L_0x0157;
                case 3040: goto L_0x0147;
                case 3041: goto L_0x0137;
                case 3042: goto L_0x0127;
                case 3043: goto L_0x0117;
                case 3044: goto L_0x00f8;
                case 3045: goto L_0x00ec;
                case 3046: goto L_0x00dc;
                case 3047: goto L_0x00cc;
                case 3048: goto L_0x00ad;
                case 3049: goto L_0x0061;
                case 3050: goto L_0x0025;
                default: goto L_0x001d;
            }
        L_0x001d:
            switch(r0) {
                case 4001: goto L_0x06e9;
                case 4002: goto L_0x06ba;
                case 4003: goto L_0x065a;
                case 4004: goto L_0x060f;
                case 4005: goto L_0x05af;
                case 4006: goto L_0x0564;
                case 4007: goto L_0x0535;
                default: goto L_0x0020;
            }
        L_0x0020:
            boolean r0 = super.onTransact(r19, r20, r21, r22)
            return r0
        L_0x0025:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x003c
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x003c:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            if (r0 == 0) goto L_0x0060
            if (r11 != 0) goto L_0x0045
            goto L_0x0060
        L_0x0045:
            g1.a r4 = g1.l1.f6455i     // Catch:{ RuntimeException -> 0x005c }
            g1.m r4 = r4.e(r11)     // Catch:{ RuntimeException -> 0x005c }
            g1.l1 r4 = (g1.l1) r4     // Catch:{ RuntimeException -> 0x005c }
            p0.c r6 = new p0.c
            r7 = 17
            r6.<init>(r7, r4)
            h3.l3 r4 = h3.s3.K0(r6)
            r1.B0(r0, r2, r5, r4)
            goto L_0x0060
        L_0x005c:
            r0 = move-exception
            j1.v.h(r10, r6, r0)
        L_0x0060:
            return r3
        L_0x0061:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            java.lang.String r4 = r20.readString()
            int r7 = r20.readInt()
            if (r7 == 0) goto L_0x007c
            android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r7.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x007c:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            if (r0 == 0) goto L_0x00ac
            if (r11 != 0) goto L_0x0085
            goto L_0x00ac
        L_0x0085:
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 == 0) goto L_0x0091
            java.lang.String r0 = "setRatingWithMediaId(): Ignoring empty mediaId"
            j1.v.g(r10, r0)
            goto L_0x00ac
        L_0x0091:
            g1.a r7 = g1.l1.f6455i     // Catch:{ RuntimeException -> 0x00a8 }
            g1.m r7 = r7.e(r11)     // Catch:{ RuntimeException -> 0x00a8 }
            g1.l1 r7 = (g1.l1) r7     // Catch:{ RuntimeException -> 0x00a8 }
            androidx.fragment.app.g r6 = new androidx.fragment.app.g
            r8 = 29
            r6.<init>(r4, r8, r7)
            h3.l3 r4 = h3.s3.K0(r6)
            r1.B0(r0, r2, r5, r4)
            goto L_0x00ac
        L_0x00a8:
            r0 = move-exception
            j1.v.h(r10, r6, r0)
        L_0x00ac:
            return r3
        L_0x00ad:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x00c4
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x00c4:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.t0(r0, r2, r11)
            return r3
        L_0x00cc:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.w0(r0, r1)
            return r3
        L_0x00dc:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.i(r0, r1)
            return r3
        L_0x00ec:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.W(r0)
            return r3
        L_0x00f8:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x010f
            android.os.Parcelable$Creator r4 = android.view.Surface.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.view.Surface r11 = (android.view.Surface) r11
        L_0x010f:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.y0(r0, r2, r11)
            return r3
        L_0x0117:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.j(r0, r1)
            return r3
        L_0x0127:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.B(r0, r1)
            return r3
        L_0x0137:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.Y(r0, r1)
            return r3
        L_0x0147:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.j0(r0, r1)
            return r3
        L_0x0157:
            h3.o r5 = android.support.v4.media.h.f(r1, r4)
            int r6 = r20.readInt()
            int r7 = r20.readInt()
            long r8 = r20.readLong()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.s(r5, r6, r7, r8)
            return r3
        L_0x016f:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            long r4 = r20.readLong()
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.P(r0, r2, r4)
            return r3
        L_0x0183:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r1 = r20.readInt()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.R(r0, r2, r1)
            return r3
        L_0x0197:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.D(r0, r1)
            return r3
        L_0x01a7:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.q0(r0, r1)
            return r3
        L_0x01b7:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.y(r0, r1)
            return r3
        L_0x01c7:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x01de
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x01de:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.s0(r0, r2, r11)
            return r3
        L_0x01e6:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            android.os.IBinder r1 = r20.readStrongBinder()
            r5 = r18
            h3.s3 r5 = (h3.s3) r5
            r5.u(r0, r2, r4, r1)
            return r3
        L_0x01fe:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            android.os.IBinder r1 = r20.readStrongBinder()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.i0(r0, r2, r1)
            return r3
        L_0x0212:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r4 = r20.readInt()
            int r5 = r20.readInt()
            int r6 = r20.readInt()
            if (r6 == 0) goto L_0x022d
            android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r6.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x022d:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            if (r0 == 0) goto L_0x025a
            if (r11 != 0) goto L_0x0236
            goto L_0x025a
        L_0x0236:
            g1.a r6 = g1.s0.f6555t     // Catch:{ RuntimeException -> 0x0256 }
            g1.m r6 = r6.e(r11)     // Catch:{ RuntimeException -> 0x0256 }
            g1.s0 r6 = (g1.s0) r6     // Catch:{ RuntimeException -> 0x0256 }
            h3.k3 r7 = new h3.k3
            r7.<init>(r3, r6)
            h3.h3 r6 = new h3.h3
            r9 = 3
            r6.<init>(r1, r5, r9)
            h3.d3 r5 = new h3.d3
            r5.<init>(r7, r2, r6)
            h3.l3 r2 = h3.s3.K0(r5)
            r1.G0(r0, r4, r8, r2)
            goto L_0x025a
        L_0x0256:
            r0 = move-exception
            j1.v.h(r10, r7, r0)
        L_0x025a:
            return r3
        L_0x025b:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r4 = r20.readInt()
            int r5 = r20.readInt()
            if (r5 == 0) goto L_0x0272
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r5.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x0272:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            if (r0 == 0) goto L_0x029f
            if (r11 != 0) goto L_0x027b
            goto L_0x029f
        L_0x027b:
            g1.a r5 = g1.s0.f6555t     // Catch:{ RuntimeException -> 0x029b }
            g1.m r5 = r5.e(r11)     // Catch:{ RuntimeException -> 0x029b }
            g1.s0 r5 = (g1.s0) r5     // Catch:{ RuntimeException -> 0x029b }
            h3.k3 r6 = new h3.k3
            r6.<init>(r9, r5)
            h3.j3 r5 = new h3.j3
            r7 = 7
            r5.<init>(r7)
            h3.d3 r7 = new h3.d3
            r7.<init>(r6, r2, r5)
            h3.l3 r2 = h3.s3.K0(r7)
            r1.G0(r0, r4, r8, r2)
            goto L_0x029f
        L_0x029b:
            r0 = move-exception
            j1.v.h(r10, r7, r0)
        L_0x029f:
            return r3
        L_0x02a0:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            float r1 = r20.readFloat()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.p(r0, r2, r1)
            return r3
        L_0x02b4:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x02cb
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x02cb:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.K(r0, r2, r11)
            return r3
        L_0x02d3:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.X(r0, r1)
            return r3
        L_0x02e3:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.L(r0, r1)
            return r3
        L_0x02f3:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.C(r0, r1)
            return r3
        L_0x0303:
            h3.o r5 = android.support.v4.media.h.f(r1, r4)
            int r6 = r20.readInt()
            int r7 = r20.readInt()
            int r8 = r20.readInt()
            int r9 = r20.readInt()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.l(r5, r6, r7, r8, r9)
            return r3
        L_0x031f:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            int r1 = r20.readInt()
            r5 = r18
            h3.s3 r5 = (h3.s3) r5
            r5.k0(r0, r2, r4, r1)
            return r3
        L_0x0337:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.f(r0, r1)
            return r3
        L_0x0347:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            int r1 = r20.readInt()
            r5 = r18
            h3.s3 r5 = (h3.s3) r5
            r5.h0(r0, r2, r4, r1)
            return r3
        L_0x035f:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r1 = r20.readInt()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.c(r0, r2, r1)
            return r3
        L_0x0373:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r1 = r20.readInt()
            if (r1 == 0) goto L_0x0382
            r9 = 1
        L_0x0382:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.v(r0, r2, r9)
            return r3
        L_0x038a:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r1 = r20.readInt()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.Z(r0, r2, r1)
            return r3
        L_0x039e:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x03b5
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r1)
            android.os.Bundle r4 = (android.os.Bundle) r4
            goto L_0x03b6
        L_0x03b5:
            r4 = r11
        L_0x03b6:
            int r5 = r20.readInt()
            if (r5 == 0) goto L_0x03c5
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r5.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x03c5:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.t(r0, r2, r4, r11)
            return r3
        L_0x03cd:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x03e4
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x03e4:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.x(r0, r2, r11)
            return r3
        L_0x03ec:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x0403
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x0403:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.V(r0, r2, r11)
            return r3
        L_0x040b:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r1 = r20.readInt()
            if (r1 == 0) goto L_0x041a
            r9 = 1
        L_0x041a:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.z(r0, r2, r9)
            return r3
        L_0x0422:
            h3.o r11 = android.support.v4.media.h.f(r1, r4)
            int r12 = r20.readInt()
            android.os.IBinder r13 = r20.readStrongBinder()
            int r14 = r20.readInt()
            long r15 = r20.readLong()
            r10 = r18
            h3.s3 r10 = (h3.s3) r10
            r10.r0(r11, r12, r13, r14, r15)
            return r3
        L_0x043e:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            android.os.IBinder r4 = r20.readStrongBinder()
            int r1 = r20.readInt()
            if (r1 == 0) goto L_0x0451
            r9 = 1
        L_0x0451:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.o(r0, r2, r4, r9)
            return r3
        L_0x0459:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            android.os.IBinder r1 = r20.readStrongBinder()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.o(r0, r2, r1, r3)
            return r3
        L_0x046d:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x0484
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r1)
            r11 = r4
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x0484:
            int r1 = r20.readInt()
            if (r1 == 0) goto L_0x048b
            r9 = 1
        L_0x048b:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.O(r0, r2, r11, r9)
            return r3
        L_0x0493:
            h3.o r13 = android.support.v4.media.h.f(r1, r4)
            int r14 = r20.readInt()
            int r0 = r20.readInt()
            if (r0 == 0) goto L_0x04aa
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r1)
            r11 = r0
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x04aa:
            r15 = r11
            long r16 = r20.readLong()
            r12 = r18
            h3.s3 r12 = (h3.s3) r12
            r12.H(r13, r14, r15, r16)
            return r3
        L_0x04b7:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x04ce
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            r11 = r1
            android.os.Bundle r11 = (android.os.Bundle) r11
        L_0x04ce:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.O(r0, r2, r11, r3)
            return r3
        L_0x04d6:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r1 = r20.readInt()
            if (r1 == 0) goto L_0x04e5
            r9 = 1
        L_0x04e5:
            r1 = r18
            h3.s3 r1 = (h3.s3) r1
            r1.c0(r0, r2, r9)
            return r3
        L_0x04ed:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.S(r0, r1)
            return r3
        L_0x04fd:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r1 = r20.readInt()
            r2 = r18
            h3.s3 r2 = (h3.s3) r2
            r2.l0(r0, r1)
            return r3
        L_0x050d:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r1 = r20.readInt()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.u0(r0, r2, r1)
            return r3
        L_0x0521:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            float r1 = r20.readFloat()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            r4.p0(r0, r2, r1)
            return r3
        L_0x0535:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            java.lang.String r1 = r20.readString()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            if (r0 != 0) goto L_0x0548
            goto L_0x0563
        L_0x0548:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L_0x0554
            java.lang.String r0 = "unsubscribe(): Ignoring empty parentId"
            j1.v.g(r10, r0)
            goto L_0x0563
        L_0x0554:
            h3.j3 r5 = new h3.j3
            r5.<init>(r1, r3)
            h3.l3 r1 = h3.s3.H0(r5)
            r5 = 50002(0xc352, float:7.0068E-41)
            r4.B0(r0, r2, r5, r1)
        L_0x0563:
            return r3
        L_0x0564:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            java.lang.String r4 = r20.readString()
            int r5 = r20.readInt()
            if (r5 == 0) goto L_0x057f
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r5.createFromParcel(r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            goto L_0x0580
        L_0x057f:
            r1 = r11
        L_0x0580:
            r5 = r18
            h3.s3 r5 = (h3.s3) r5
            if (r0 != 0) goto L_0x0587
            goto L_0x05ae
        L_0x0587:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x0593
            java.lang.String r0 = "subscribe(): Ignoring empty parentId"
            j1.v.g(r10, r0)
            goto L_0x05ae
        L_0x0593:
            if (r1 != 0) goto L_0x0596
            goto L_0x059f
        L_0x0596:
            f3.a r6 = h3.p1.f7279p
            g1.m r1 = r6.e(r1)
            r11 = r1
            h3.p1 r11 = (h3.p1) r11
        L_0x059f:
            g1.a r1 = new g1.a
            r1.<init>((int) r3, (h3.p1) r11, (java.lang.String) r4)
            h3.l3 r1 = h3.s3.H0(r1)
            r4 = 50001(0xc351, float:7.0066E-41)
            r5.B0(r0, r2, r4, r1)
        L_0x05ae:
            return r3
        L_0x05af:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            java.lang.String r5 = r20.readString()
            int r6 = r20.readInt()
            int r7 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x05d2
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            goto L_0x05d3
        L_0x05d2:
            r1 = r11
        L_0x05d3:
            r12 = r18
            h3.s3 r12 = (h3.s3) r12
            if (r0 != 0) goto L_0x05da
            goto L_0x060e
        L_0x05da:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L_0x05e3
            java.lang.String r0 = "getSearchResult(): Ignoring empty query"
            goto L_0x05ec
        L_0x05e3:
            if (r6 >= 0) goto L_0x05e8
            java.lang.String r0 = "getSearchResult(): Ignoring negative page"
            goto L_0x05ec
        L_0x05e8:
            if (r7 >= r3) goto L_0x05f0
            java.lang.String r0 = "getSearchResult(): Ignoring pageSize less than 1"
        L_0x05ec:
            j1.v.g(r10, r0)
            goto L_0x060e
        L_0x05f0:
            if (r1 != 0) goto L_0x05f3
            goto L_0x05fc
        L_0x05f3:
            f3.a r4 = h3.p1.f7279p
            g1.m r1 = r4.e(r1)
            r11 = r1
            h3.p1 r11 = (h3.p1) r11
        L_0x05fc:
            r8 = r11
            f3.a r1 = new f3.a
            r9 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9)
            h3.l3 r1 = h3.s3.H0(r1)
            r4 = 50006(0xc356, float:7.0073E-41)
            r12.B0(r0, r2, r4, r1)
        L_0x060e:
            return r3
        L_0x060f:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            java.lang.String r4 = r20.readString()
            int r5 = r20.readInt()
            if (r5 == 0) goto L_0x062a
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r5.createFromParcel(r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            goto L_0x062b
        L_0x062a:
            r1 = r11
        L_0x062b:
            r5 = r18
            h3.s3 r5 = (h3.s3) r5
            if (r0 != 0) goto L_0x0632
            goto L_0x0659
        L_0x0632:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x063e
            java.lang.String r0 = "search(): Ignoring empty query"
            j1.v.g(r10, r0)
            goto L_0x0659
        L_0x063e:
            if (r1 != 0) goto L_0x0641
            goto L_0x064a
        L_0x0641:
            f3.a r6 = h3.p1.f7279p
            g1.m r1 = r6.e(r1)
            r11 = r1
            h3.p1 r11 = (h3.p1) r11
        L_0x064a:
            g1.a r1 = new g1.a
            r1.<init>((int) r9, (h3.p1) r11, (java.lang.String) r4)
            h3.l3 r1 = h3.s3.H0(r1)
            r4 = 50005(0xc355, float:7.0072E-41)
            r5.B0(r0, r2, r4, r1)
        L_0x0659:
            return r3
        L_0x065a:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            java.lang.String r5 = r20.readString()
            int r6 = r20.readInt()
            int r7 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x067d
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            goto L_0x067e
        L_0x067d:
            r1 = r11
        L_0x067e:
            r12 = r18
            h3.s3 r12 = (h3.s3) r12
            if (r0 != 0) goto L_0x0685
            goto L_0x06b9
        L_0x0685:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L_0x068e
            java.lang.String r0 = "getChildren(): Ignoring empty parentId"
            goto L_0x0697
        L_0x068e:
            if (r6 >= 0) goto L_0x0693
            java.lang.String r0 = "getChildren(): Ignoring negative page"
            goto L_0x0697
        L_0x0693:
            if (r7 >= r3) goto L_0x069b
            java.lang.String r0 = "getChildren(): Ignoring pageSize less than 1"
        L_0x0697:
            j1.v.g(r10, r0)
            goto L_0x06b9
        L_0x069b:
            if (r1 != 0) goto L_0x069e
            goto L_0x06a7
        L_0x069e:
            f3.a r4 = h3.p1.f7279p
            g1.m r1 = r4.e(r1)
            r11 = r1
            h3.p1 r11 = (h3.p1) r11
        L_0x06a7:
            r8 = r11
            f3.a r1 = new f3.a
            r9 = 1
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9)
            h3.l3 r1 = h3.s3.H0(r1)
            r4 = 50003(0xc353, float:7.0069E-41)
            r12.B0(r0, r2, r4, r1)
        L_0x06b9:
            return r3
        L_0x06ba:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            java.lang.String r1 = r20.readString()
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            if (r0 != 0) goto L_0x06cd
            goto L_0x06e8
        L_0x06cd:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L_0x06d9
            java.lang.String r0 = "getItem(): Ignoring empty mediaId"
            j1.v.g(r10, r0)
            goto L_0x06e8
        L_0x06d9:
            h3.j3 r5 = new h3.j3
            r5.<init>(r1, r9)
            h3.l3 r1 = h3.s3.H0(r5)
            r5 = 50004(0xc354, float:7.007E-41)
            r4.B0(r0, r2, r5, r1)
        L_0x06e8:
            return r3
        L_0x06e9:
            h3.o r0 = android.support.v4.media.h.f(r1, r4)
            int r2 = r20.readInt()
            int r4 = r20.readInt()
            if (r4 == 0) goto L_0x0700
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            goto L_0x0701
        L_0x0700:
            r1 = r11
        L_0x0701:
            r4 = r18
            h3.s3 r4 = (h3.s3) r4
            if (r0 != 0) goto L_0x0708
            goto L_0x0723
        L_0x0708:
            if (r1 != 0) goto L_0x070b
            goto L_0x0714
        L_0x070b:
            f3.a r5 = h3.p1.f7279p
            g1.m r1 = r5.e(r1)
            r11 = r1
            h3.p1 r11 = (h3.p1) r11
        L_0x0714:
            p0.c r1 = new p0.c
            r1.<init>(r8, r11)
            h3.l3 r1 = h3.s3.H0(r1)
            r5 = 50000(0xc350, float:7.0065E-41)
            r4.B0(r0, r2, r5, r1)
        L_0x0723:
            return r3
        L_0x0724:
            r0 = r21
            r0.writeString(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.q.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}

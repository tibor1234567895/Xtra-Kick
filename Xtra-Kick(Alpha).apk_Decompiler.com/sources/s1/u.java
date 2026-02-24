package s1;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import d2.p0;
import g1.a0;
import j1.a;
import j1.g0;
import j1.l0;
import j1.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import l1.b;
import l1.d;
import l1.h;
import m1.f;
import m1.g;
import m1.p;
import m1.w0;
import p1.d0;
import p1.e0;
import p1.m;
import p1.n;
import p1.q;
import v1.b1;

public abstract class u extends f {
    public static final byte[] I0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final g A;
    public boolean A0;
    public final ArrayList B;
    public boolean B0;
    public final MediaCodec.BufferInfo C;
    public boolean C0;
    public final ArrayDeque D;
    public p D0;
    public a0 E;
    public g E0;
    public a0 F;
    public t F0;
    public n G;
    public long G0;
    public n H;
    public boolean H0;
    public MediaCrypto I;
    public boolean J;
    public final long K;
    public float L;
    public float M;
    public m N;
    public a0 O;
    public MediaFormat P;
    public boolean Q;
    public float R;
    public ArrayDeque S;
    public s T;
    public q U;
    public int V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f14049a0;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f14050b0;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f14051c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f14052d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f14053e0;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f14054f0;

    /* renamed from: g0  reason: collision with root package name */
    public h f14055g0;

    /* renamed from: h0  reason: collision with root package name */
    public long f14056h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f14057i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f14058j0;

    /* renamed from: k0  reason: collision with root package name */
    public ByteBuffer f14059k0;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f14060l0;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f14061m0;

    /* renamed from: n0  reason: collision with root package name */
    public boolean f14062n0;

    /* renamed from: o0  reason: collision with root package name */
    public boolean f14063o0;

    /* renamed from: p0  reason: collision with root package name */
    public boolean f14064p0;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f14065q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f14066r0;

    /* renamed from: s0  reason: collision with root package name */
    public int f14067s0;

    /* renamed from: t  reason: collision with root package name */
    public final l f14068t;

    /* renamed from: t0  reason: collision with root package name */
    public int f14069t0;

    /* renamed from: u  reason: collision with root package name */
    public final v f14070u;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f14071u0;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f14072v = false;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f14073v0;

    /* renamed from: w  reason: collision with root package name */
    public final float f14074w;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f14075w0;

    /* renamed from: x  reason: collision with root package name */
    public final h f14076x;

    /* renamed from: x0  reason: collision with root package name */
    public long f14077x0;

    /* renamed from: y  reason: collision with root package name */
    public final h f14078y;

    /* renamed from: y0  reason: collision with root package name */
    public long f14079y0;

    /* renamed from: z  reason: collision with root package name */
    public final h f14080z;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f14081z0;

    public u(int i10, i iVar, e0 e0Var, float f10) {
        super(i10);
        this.f14068t = iVar;
        e0Var.getClass();
        this.f14070u = e0Var;
        this.f14074w = f10;
        this.f14076x = new h(0);
        this.f14078y = new h(0);
        this.f14080z = new h(2);
        g gVar = new g();
        this.A = gVar;
        this.B = new ArrayList();
        this.C = new MediaCodec.BufferInfo();
        this.L = 1.0f;
        this.M = 1.0f;
        this.K = -9223372036854775807L;
        this.D = new ArrayDeque();
        j0(t.f14045d);
        gVar.j(0);
        gVar.f9515j.order(ByteOrder.nativeOrder());
        this.R = -1.0f;
        this.V = 0;
        this.f14066r0 = 0;
        this.f14057i0 = -1;
        this.f14058j0 = -1;
        this.f14056h0 = -9223372036854775807L;
        this.f14077x0 = -9223372036854775807L;
        this.f14079y0 = -9223372036854775807L;
        this.G0 = -9223372036854775807L;
        this.f14067s0 = 0;
        this.f14069t0 = 0;
    }

    public abstract m1.h A(q qVar, a0 a0Var, a0 a0Var2);

    public n B(IllegalStateException illegalStateException, q qVar) {
        return new n(illegalStateException, qVar);
    }

    public final void C() {
        this.f14064p0 = false;
        this.A.h();
        this.f14080z.h();
        this.f14063o0 = false;
        this.f14062n0 = false;
    }

    public final boolean D() {
        if (this.f14071u0) {
            this.f14067s0 = 1;
            if (this.X || this.Z) {
                this.f14069t0 = 3;
                return false;
            }
            this.f14069t0 = 2;
        } else {
            o0();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean E(long r21, long r23) {
        /*
            r20 = this;
            r15 = r20
            int r0 = r15.f14058j0
            r14 = 1
            r13 = 0
            if (r0 < 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            android.media.MediaCodec$BufferInfo r12 = r15.C
            if (r0 != 0) goto L_0x00fd
            boolean r0 = r15.f14049a0
            if (r0 == 0) goto L_0x002a
            boolean r0 = r15.f14073v0
            if (r0 == 0) goto L_0x002a
            s1.m r0 = r15.N     // Catch:{ IllegalStateException -> 0x001e }
            int r0 = r0.b(r12)     // Catch:{ IllegalStateException -> 0x001e }
            goto L_0x0030
        L_0x001e:
            r20.b0()
            boolean r0 = r15.A0
            if (r0 == 0) goto L_0x0029
            r20.e0()
        L_0x0029:
            return r13
        L_0x002a:
            s1.m r0 = r15.N
            int r0 = r0.b(r12)
        L_0x0030:
            if (r0 >= 0) goto L_0x0075
            r1 = -2
            if (r0 != r1) goto L_0x0064
            r15.f14075w0 = r14
            s1.m r0 = r15.N
            android.media.MediaFormat r0 = r0.h()
            int r1 = r15.V
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)
            r2 = 32
            if (r1 != r2) goto L_0x0056
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)
            if (r1 != r2) goto L_0x0056
            r15.f14053e0 = r14
            goto L_0x0063
        L_0x0056:
            boolean r1 = r15.f14051c0
            if (r1 == 0) goto L_0x005f
            java.lang.String r1 = "channel-count"
            r0.setInteger(r1, r14)
        L_0x005f:
            r15.P = r0
            r15.Q = r14
        L_0x0063:
            return r14
        L_0x0064:
            boolean r0 = r15.f14054f0
            if (r0 == 0) goto L_0x0074
            boolean r0 = r15.f14081z0
            if (r0 != 0) goto L_0x0071
            int r0 = r15.f14067s0
            r1 = 2
            if (r0 != r1) goto L_0x0074
        L_0x0071:
            r20.b0()
        L_0x0074:
            return r13
        L_0x0075:
            boolean r1 = r15.f14053e0
            if (r1 == 0) goto L_0x0081
            r15.f14053e0 = r13
            s1.m r1 = r15.N
            r1.d(r0, r13)
            return r14
        L_0x0081:
            int r1 = r12.size
            if (r1 != 0) goto L_0x008f
            int r1 = r12.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x008f
            r20.b0()
            return r13
        L_0x008f:
            r15.f14058j0 = r0
            s1.m r1 = r15.N
            java.nio.ByteBuffer r0 = r1.l(r0)
            r15.f14059k0 = r0
            if (r0 == 0) goto L_0x00aa
            int r1 = r12.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r15.f14059k0
            int r1 = r12.offset
            int r2 = r12.size
            int r1 = r1 + r2
            r0.limit(r1)
        L_0x00aa:
            boolean r0 = r15.f14050b0
            if (r0 == 0) goto L_0x00c9
            long r0 = r12.presentationTimeUs
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00c9
            int r0 = r12.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x00c9
            long r0 = r15.f14077x0
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00c9
            r12.presentationTimeUs = r0
        L_0x00c9:
            long r0 = r12.presentationTimeUs
            java.util.ArrayList r2 = r15.B
            int r3 = r2.size()
            r4 = 0
        L_0x00d2:
            if (r4 >= r3) goto L_0x00ea
            java.lang.Object r5 = r2.get(r4)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x00e7
            r2.remove(r4)
            r0 = 1
            goto L_0x00eb
        L_0x00e7:
            int r4 = r4 + 1
            goto L_0x00d2
        L_0x00ea:
            r0 = 0
        L_0x00eb:
            r15.f14060l0 = r0
            long r0 = r15.f14079y0
            long r2 = r12.presentationTimeUs
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            r15.f14061m0 = r0
            r15.p0(r2)
        L_0x00fd:
            boolean r0 = r15.f14049a0
            if (r0 == 0) goto L_0x0145
            boolean r0 = r15.f14073v0
            if (r0 == 0) goto L_0x0145
            s1.m r5 = r15.N     // Catch:{ IllegalStateException -> 0x0137 }
            java.nio.ByteBuffer r6 = r15.f14059k0     // Catch:{ IllegalStateException -> 0x0137 }
            int r7 = r15.f14058j0     // Catch:{ IllegalStateException -> 0x0137 }
            int r8 = r12.flags     // Catch:{ IllegalStateException -> 0x0137 }
            r9 = 1
            long r10 = r12.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0137 }
            boolean r3 = r15.f14060l0     // Catch:{ IllegalStateException -> 0x0137 }
            boolean r4 = r15.f14061m0     // Catch:{ IllegalStateException -> 0x0137 }
            g1.a0 r1 = r15.F     // Catch:{ IllegalStateException -> 0x0137 }
            r0 = r20
            r16 = r1
            r1 = r21
            r17 = r3
            r18 = r4
            r3 = r23
            r19 = r12
            r12 = r17
            r17 = 0
            r13 = r18
            r18 = 1
            r14 = r16
            boolean r0 = r0.c0(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)     // Catch:{ IllegalStateException -> 0x0135 }
            r15 = r19
            goto L_0x016d
        L_0x0135:
            goto L_0x013a
        L_0x0137:
            r17 = 0
            goto L_0x0135
        L_0x013a:
            r20.b0()
            boolean r0 = r15.A0
            if (r0 == 0) goto L_0x0144
            r20.e0()
        L_0x0144:
            return r17
        L_0x0145:
            r19 = r12
            r17 = 0
            r18 = 1
            s1.m r5 = r15.N
            java.nio.ByteBuffer r6 = r15.f14059k0
            int r7 = r15.f14058j0
            r14 = r19
            int r8 = r14.flags
            r9 = 1
            long r10 = r14.presentationTimeUs
            boolean r12 = r15.f14060l0
            boolean r13 = r15.f14061m0
            g1.a0 r3 = r15.F
            r0 = r20
            r1 = r21
            r16 = r3
            r3 = r23
            r15 = r14
            r14 = r16
            boolean r0 = r0.c0(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)
        L_0x016d:
            if (r0 == 0) goto L_0x018d
            long r0 = r15.presentationTimeUs
            r2 = r20
            r3 = r15
            r2.Y(r0)
            int r0 = r3.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x017f
            r14 = 1
            goto L_0x0180
        L_0x017f:
            r14 = 0
        L_0x0180:
            r0 = -1
            r2.f14058j0 = r0
            r0 = 0
            r2.f14059k0 = r0
            if (r14 != 0) goto L_0x0189
            return r18
        L_0x0189:
            r20.b0()
            goto L_0x018f
        L_0x018d:
            r2 = r20
        L_0x018f:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.u.E(long, long):boolean");
    }

    public final boolean F() {
        boolean z10;
        d dVar;
        t tVar;
        m mVar = this.N;
        if (mVar == null || this.f14067s0 == 2 || this.f14081z0) {
            return false;
        }
        int i10 = this.f14057i0;
        h hVar = this.f14078y;
        if (i10 < 0) {
            int n10 = mVar.n();
            this.f14057i0 = n10;
            if (n10 < 0) {
                return false;
            }
            hVar.f9515j = this.N.i(n10);
            hVar.h();
        }
        if (this.f14067s0 == 1) {
            if (!this.f14054f0) {
                this.f14073v0 = true;
                this.N.o(this.f14057i0, 0, 0, 4);
                this.f14057i0 = -1;
                hVar.f9515j = null;
            }
            this.f14067s0 = 2;
            return false;
        } else if (this.f14052d0) {
            this.f14052d0 = false;
            hVar.f9515j.put(I0);
            this.N.o(this.f14057i0, 38, 0, 0);
            this.f14057i0 = -1;
            hVar.f9515j = null;
            this.f14071u0 = true;
            return true;
        } else {
            if (this.f14066r0 == 1) {
                for (int i11 = 0; i11 < this.O.f6278u.size(); i11++) {
                    hVar.f9515j.put((byte[]) this.O.f6278u.get(i11));
                }
                this.f14066r0 = 2;
            }
            int position = hVar.f9515j.position();
            w0 w0Var = this.f10217i;
            w0Var.a();
            try {
                int s10 = s(w0Var, hVar, 0);
                if (h() || hVar.f(536870912)) {
                    this.f14079y0 = this.f14077x0;
                }
                if (s10 == -3) {
                    return false;
                }
                if (s10 == -5) {
                    if (this.f14066r0 == 2) {
                        hVar.h();
                        this.f14066r0 = 1;
                    }
                    V(w0Var);
                    return true;
                }
                if (hVar.f(4)) {
                    if (this.f14066r0 == 2) {
                        hVar.h();
                        this.f14066r0 = 1;
                    }
                    this.f14081z0 = true;
                    if (!this.f14071u0) {
                        b0();
                        return false;
                    }
                    try {
                        if (!this.f14054f0) {
                            this.f14073v0 = true;
                            this.N.o(this.f14057i0, 0, 0, 4);
                            this.f14057i0 = -1;
                            hVar.f9515j = null;
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e10) {
                        throw c(l0.q(e10.getErrorCode()), this.E, e10, false);
                    }
                } else if (this.f14071u0 || hVar.f(1)) {
                    boolean f10 = hVar.f(1073741824);
                    d dVar2 = hVar.f9514i;
                    if (f10) {
                        if (position == 0) {
                            dVar2.getClass();
                        } else {
                            if (dVar2.f9507d == null) {
                                int[] iArr = new int[1];
                                dVar2.f9507d = iArr;
                                dVar2.f9512i.numBytesOfClearData = iArr;
                            }
                            int[] iArr2 = dVar2.f9507d;
                            iArr2[0] = iArr2[0] + position;
                        }
                    }
                    if (this.W && !f10) {
                        ByteBuffer byteBuffer = hVar.f9515j;
                        byte[] bArr = p0.f4278a;
                        int position2 = byteBuffer.position();
                        int i12 = 0;
                        int i13 = 0;
                        while (true) {
                            int i14 = i12 + 1;
                            if (i14 >= position2) {
                                byteBuffer.clear();
                                break;
                            }
                            byte b10 = byteBuffer.get(i12) & 255;
                            if (i13 == 3) {
                                if (b10 == 1 && (byteBuffer.get(i14) & 31) == 7) {
                                    ByteBuffer duplicate = byteBuffer.duplicate();
                                    duplicate.position(i12 - 3);
                                    duplicate.limit(position2);
                                    byteBuffer.position(0);
                                    byteBuffer.put(duplicate);
                                    break;
                                }
                            } else if (b10 == 0) {
                                i13++;
                            }
                            if (b10 != 0) {
                                i13 = 0;
                            }
                            i12 = i14;
                        }
                        if (hVar.f9515j.position() == 0) {
                            return true;
                        }
                        this.W = false;
                    }
                    long j10 = hVar.f9517l;
                    h hVar2 = this.f14055g0;
                    if (hVar2 != null) {
                        a0 a0Var = this.E;
                        if (hVar2.f14020b == 0) {
                            hVar2.f14019a = j10;
                        }
                        if (!hVar2.f14021c) {
                            ByteBuffer byteBuffer2 = hVar.f9515j;
                            byteBuffer2.getClass();
                            int i15 = 0;
                            byte b11 = 0;
                            for (int i16 = 4; i15 < i16; i16 = 4) {
                                b11 = (b11 << 8) | (byteBuffer2.get(i15) & 255);
                                i15++;
                            }
                            int b12 = d2.l0.b(b11);
                            if (b12 == -1) {
                                hVar2.f14021c = true;
                                hVar2.f14020b = 0;
                                hVar2.f14019a = hVar.f9517l;
                                v.g("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
                                j10 = hVar.f9517l;
                            } else {
                                z10 = f10;
                                long max = Math.max(0, ((hVar2.f14020b - 529) * 1000000) / ((long) a0Var.G)) + hVar2.f14019a;
                                hVar2.f14020b += (long) b12;
                                j10 = max;
                                long j11 = this.f14077x0;
                                h hVar3 = this.f14055g0;
                                a0 a0Var2 = this.E;
                                hVar3.getClass();
                                dVar = dVar2;
                                this.f14077x0 = Math.max(j11, Math.max(0, ((hVar3.f14020b - 529) * 1000000) / ((long) a0Var2.G)) + hVar3.f14019a);
                            }
                        }
                        z10 = f10;
                        long j112 = this.f14077x0;
                        h hVar32 = this.f14055g0;
                        a0 a0Var22 = this.E;
                        hVar32.getClass();
                        dVar = dVar2;
                        this.f14077x0 = Math.max(j112, Math.max(0, ((hVar32.f14020b - 529) * 1000000) / ((long) a0Var22.G)) + hVar32.f14019a);
                    } else {
                        z10 = f10;
                        dVar = dVar2;
                    }
                    if (hVar.g()) {
                        this.B.add(Long.valueOf(j10));
                    }
                    if (this.B0) {
                        ArrayDeque arrayDeque = this.D;
                        if (!arrayDeque.isEmpty()) {
                            tVar = (t) arrayDeque.peekLast();
                        } else {
                            tVar = this.F0;
                        }
                        tVar.f14048c.a(j10, this.E);
                        this.B0 = false;
                    }
                    this.f14077x0 = Math.max(this.f14077x0, j10);
                    hVar.k();
                    if (hVar.f(268435456)) {
                        O(hVar);
                    }
                    a0(hVar);
                    if (z10) {
                        try {
                            this.N.g(this.f14057i0, dVar, j10);
                        } catch (MediaCodec.CryptoException e11) {
                            throw c(l0.q(e11.getErrorCode()), this.E, e11, false);
                        }
                    } else {
                        this.N.o(this.f14057i0, hVar.f9515j.limit(), j10, 0);
                    }
                    this.f14057i0 = -1;
                    hVar.f9515j = null;
                    this.f14071u0 = true;
                    this.f14066r0 = 0;
                    this.E0.f10233c++;
                    return true;
                } else {
                    hVar.h();
                    if (this.f14066r0 == 2) {
                        this.f14066r0 = 1;
                    }
                    return true;
                }
            } catch (l1.g e12) {
                S(e12);
                d0(0);
                G();
                return true;
            }
        }
    }

    public final void G() {
        try {
            this.N.flush();
        } finally {
            g0();
        }
    }

    public final boolean H() {
        if (this.N == null) {
            return false;
        }
        int i10 = this.f14069t0;
        if (i10 == 3 || this.X || ((this.Y && !this.f14075w0) || (this.Z && this.f14073v0))) {
            e0();
            return true;
        }
        if (i10 == 2) {
            int i11 = l0.f8453a;
            a.e(i11 >= 23);
            if (i11 >= 23) {
                try {
                    o0();
                } catch (p e10) {
                    v.h("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e10);
                    e0();
                    return true;
                }
            }
        }
        G();
        return false;
    }

    public final List I(boolean z10) {
        a0 a0Var = this.E;
        v vVar = this.f14070u;
        ArrayList L2 = L(vVar, a0Var, z10);
        if (L2.isEmpty() && z10) {
            L2 = L(vVar, this.E, false);
            if (!L2.isEmpty()) {
                v.g("MediaCodecRenderer", "Drm session requires secure decoder for " + this.E.f6276s + ", but no secure decoder available. Trying to proceed with " + L2 + ".");
            }
        }
        return L2;
    }

    public boolean J() {
        return false;
    }

    public abstract float K(float f10, a0[] a0VarArr);

    public abstract ArrayList L(v vVar, a0 a0Var, boolean z10);

    public final d0 M(n nVar) {
        b g10 = nVar.g();
        if (g10 == null || (g10 instanceof d0)) {
            return (d0) g10;
        }
        throw c(6001, this.E, new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + g10), false);
    }

    public abstract k N(q qVar, a0 a0Var, MediaCrypto mediaCrypto, float f10);

    public void O(h hVar) {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x03e9, code lost:
        if ("stvm8".equals(r10) == false) goto L_0x03fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x03f9, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r2) == false) goto L_0x03fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0388 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x04de  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x04fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P(s1.q r17, android.media.MediaCrypto r18) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            java.lang.String r1 = "createCodec:"
            java.lang.String r2 = r0.f14033a
            int r3 = j1.l0.f8453a
            r4 = 23
            if (r3 >= r4) goto L_0x0011
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x001c
        L_0x0011:
            float r4 = r7.M
            g1.a0[] r5 = r7.f10223o
            r5.getClass()
            float r4 = r7.K(r4, r5)
        L_0x001c:
            float r5 = r7.f14074w
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0024
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0024:
            long r5 = android.os.SystemClock.elapsedRealtime()
            g1.a0 r8 = r7.E
            r9 = r18
            s1.k r8 = r7.N(r0, r8, r9, r4)
            r9 = 31
            if (r3 < r9) goto L_0x003c
            n1.f0 r3 = r7.f10220l
            r3.getClass()
            s1.r.a(r8, r3)
        L_0x003c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0516 }
            r3.<init>(r1)     // Catch:{ all -> 0x0516 }
            r3.append(r2)     // Catch:{ all -> 0x0516 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0516 }
            j1.i0.a(r1)     // Catch:{ all -> 0x0516 }
            s1.l r1 = r7.f14068t     // Catch:{ all -> 0x0516 }
            s1.m r1 = r1.a(r8)     // Catch:{ all -> 0x0516 }
            r7.N = r1     // Catch:{ all -> 0x0516 }
            j1.i0.b()
            long r8 = android.os.SystemClock.elapsedRealtime()
            g1.a0 r1 = r7.E
            boolean r1 = r0.d(r1)
            r3 = 2
            if (r1 != 0) goto L_0x02f2
            java.lang.Object[] r1 = new java.lang.Object[r3]
            g1.a0 r3 = r7.E
            if (r3 != 0) goto L_0x006d
            java.lang.String r3 = "null"
            goto L_0x02e1
        L_0x006d:
            java.lang.String r10 = "id="
            java.lang.StringBuilder r10 = android.support.v4.media.h.q(r10)
            java.lang.String r11 = r3.f6265h
            r10.append(r11)
            java.lang.String r11 = ", mimeType="
            r10.append(r11)
            java.lang.String r11 = r3.f6276s
            r10.append(r11)
            r11 = -1
            int r12 = r3.f6272o
            if (r12 == r11) goto L_0x008f
            java.lang.String r11 = ", bitrate="
            r10.append(r11)
            r10.append(r12)
        L_0x008f:
            java.lang.String r11 = r3.f6273p
            if (r11 == 0) goto L_0x009b
            java.lang.String r12 = ", codecs="
            r10.append(r12)
            r10.append(r11)
        L_0x009b:
            g1.u r11 = r3.f6279v
            if (r11 == 0) goto L_0x0149
            java.util.LinkedHashSet r12 = new java.util.LinkedHashSet
            r12.<init>()
            r13 = 0
        L_0x00a5:
            int r14 = r11.f6595k
            if (r13 >= r14) goto L_0x0105
            g1.t[] r14 = r11.f6592h
            r14 = r14[r13]
            java.util.UUID r14 = r14.f6567i
            java.util.UUID r15 = g1.n.f6474b
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x00ba
            java.lang.String r14 = "cenc"
            goto L_0x00e5
        L_0x00ba:
            java.util.UUID r15 = g1.n.f6475c
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x00c5
            java.lang.String r14 = "clearkey"
            goto L_0x00e5
        L_0x00c5:
            java.util.UUID r15 = g1.n.f6477e
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x00d0
            java.lang.String r14 = "playready"
            goto L_0x00e5
        L_0x00d0:
            java.util.UUID r15 = g1.n.f6476d
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x00db
            java.lang.String r14 = "widevine"
            goto L_0x00e5
        L_0x00db:
            java.util.UUID r15 = g1.n.f6473a
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x00e8
            java.lang.String r14 = "universal"
        L_0x00e5:
            r18 = r11
            goto L_0x00fd
        L_0x00e8:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r18 = r11
            java.lang.String r11 = "unknown ("
            r15.<init>(r11)
            r15.append(r14)
            java.lang.String r11 = ")"
            r15.append(r11)
            java.lang.String r14 = r15.toString()
        L_0x00fd:
            r12.add(r14)
            int r13 = r13 + 1
            r11 = r18
            goto L_0x00a5
        L_0x0105:
            java.lang.String r11 = ", drm=["
            r10.append(r11)
            r11 = 44
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r11.getClass()
            java.util.Iterator r12 = r12.iterator()
            boolean r13 = r12.hasNext()     // Catch:{ IOException -> 0x0142 }
            if (r13 == 0) goto L_0x013c
        L_0x011d:
            java.lang.Object r13 = r12.next()     // Catch:{ IOException -> 0x0142 }
            java.util.Objects.requireNonNull(r13)     // Catch:{ IOException -> 0x0142 }
            boolean r14 = r13 instanceof java.lang.CharSequence     // Catch:{ IOException -> 0x0142 }
            if (r14 == 0) goto L_0x012b
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ IOException -> 0x0142 }
            goto L_0x012f
        L_0x012b:
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x0142 }
        L_0x012f:
            r10.append(r13)     // Catch:{ IOException -> 0x0142 }
            boolean r13 = r12.hasNext()     // Catch:{ IOException -> 0x0142 }
            if (r13 == 0) goto L_0x013c
            r10.append(r11)     // Catch:{ IOException -> 0x0142 }
            goto L_0x011d
        L_0x013c:
            r11 = 93
            r10.append(r11)
            goto L_0x0149
        L_0x0142:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x0149:
            int r11 = r3.f6281x
            r12 = -1
            if (r11 == r12) goto L_0x0162
            int r13 = r3.f6282y
            if (r13 == r12) goto L_0x0162
            java.lang.String r12 = ", res="
            r10.append(r12)
            r10.append(r11)
            java.lang.String r11 = "x"
            r10.append(r11)
            r10.append(r13)
        L_0x0162:
            float r11 = r3.f6283z
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r12 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r12 == 0) goto L_0x0172
            java.lang.String r12 = ", fps="
            r10.append(r12)
            r10.append(r11)
        L_0x0172:
            int r11 = r3.F
            r12 = -1
            if (r11 == r12) goto L_0x017f
            java.lang.String r13 = ", channels="
            r10.append(r13)
            r10.append(r11)
        L_0x017f:
            int r11 = r3.G
            if (r11 == r12) goto L_0x018b
            java.lang.String r12 = ", sample_rate="
            r10.append(r12)
            r10.append(r11)
        L_0x018b:
            java.lang.String r11 = r3.f6267j
            if (r11 == 0) goto L_0x0197
            java.lang.String r12 = ", language="
            r10.append(r12)
            r10.append(r11)
        L_0x0197:
            java.lang.String r11 = r3.f6266i
            if (r11 == 0) goto L_0x01a3
            java.lang.String r12 = ", label="
            r10.append(r12)
            r10.append(r11)
        L_0x01a3:
            java.lang.String r11 = "]"
            int r12 = r3.f6268k
            if (r12 == 0) goto L_0x020b
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r14 = r12 & 4
            if (r14 == 0) goto L_0x01b7
            java.lang.String r14 = "auto"
            r13.add(r14)
        L_0x01b7:
            r14 = r12 & 1
            if (r14 == 0) goto L_0x01c0
            java.lang.String r14 = "default"
            r13.add(r14)
        L_0x01c0:
            r12 = r12 & 2
            if (r12 == 0) goto L_0x01c9
            java.lang.String r12 = "forced"
            r13.add(r12)
        L_0x01c9:
            java.lang.String r12 = ", selectionFlags=["
            r10.append(r12)
            r12 = 44
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r12.getClass()
            java.util.Iterator r13 = r13.iterator()
            boolean r14 = r13.hasNext()     // Catch:{ IOException -> 0x0204 }
            if (r14 == 0) goto L_0x0200
        L_0x01e1:
            java.lang.Object r14 = r13.next()     // Catch:{ IOException -> 0x0204 }
            java.util.Objects.requireNonNull(r14)     // Catch:{ IOException -> 0x0204 }
            boolean r15 = r14 instanceof java.lang.CharSequence     // Catch:{ IOException -> 0x0204 }
            if (r15 == 0) goto L_0x01ef
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ IOException -> 0x0204 }
            goto L_0x01f3
        L_0x01ef:
            java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x0204 }
        L_0x01f3:
            r10.append(r14)     // Catch:{ IOException -> 0x0204 }
            boolean r14 = r13.hasNext()     // Catch:{ IOException -> 0x0204 }
            if (r14 == 0) goto L_0x0200
            r10.append(r12)     // Catch:{ IOException -> 0x0204 }
            goto L_0x01e1
        L_0x0200:
            r10.append(r11)
            goto L_0x020b
        L_0x0204:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x020b:
            int r3 = r3.f6269l
            if (r3 == 0) goto L_0x02dd
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r13 = r3 & 1
            if (r13 == 0) goto L_0x021d
            java.lang.String r13 = "main"
            r12.add(r13)
        L_0x021d:
            r13 = r3 & 2
            if (r13 == 0) goto L_0x0226
            java.lang.String r13 = "alt"
            r12.add(r13)
        L_0x0226:
            r13 = r3 & 4
            if (r13 == 0) goto L_0x022f
            java.lang.String r13 = "supplementary"
            r12.add(r13)
        L_0x022f:
            r13 = r3 & 8
            if (r13 == 0) goto L_0x0238
            java.lang.String r13 = "commentary"
            r12.add(r13)
        L_0x0238:
            r13 = r3 & 16
            if (r13 == 0) goto L_0x0241
            java.lang.String r13 = "dub"
            r12.add(r13)
        L_0x0241:
            r13 = r3 & 32
            if (r13 == 0) goto L_0x024a
            java.lang.String r13 = "emergency"
            r12.add(r13)
        L_0x024a:
            r13 = r3 & 64
            if (r13 == 0) goto L_0x0253
            java.lang.String r13 = "caption"
            r12.add(r13)
        L_0x0253:
            r13 = r3 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x025c
            java.lang.String r13 = "subtitle"
            r12.add(r13)
        L_0x025c:
            r13 = r3 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0265
            java.lang.String r13 = "sign"
            r12.add(r13)
        L_0x0265:
            r13 = r3 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x026e
            java.lang.String r13 = "describes-video"
            r12.add(r13)
        L_0x026e:
            r13 = r3 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0277
            java.lang.String r13 = "describes-music"
            r12.add(r13)
        L_0x0277:
            r13 = r3 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0280
            java.lang.String r13 = "enhanced-intelligibility"
            r12.add(r13)
        L_0x0280:
            r13 = r3 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0289
            java.lang.String r13 = "transcribes-dialog"
            r12.add(r13)
        L_0x0289:
            r13 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x0292
            java.lang.String r13 = "easy-read"
            r12.add(r13)
        L_0x0292:
            r3 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x029b
            java.lang.String r3 = "trick-play"
            r12.add(r3)
        L_0x029b:
            java.lang.String r3 = ", roleFlags=["
            r10.append(r3)
            r3 = 44
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r3.getClass()
            java.util.Iterator r12 = r12.iterator()
            boolean r13 = r12.hasNext()     // Catch:{ IOException -> 0x02d6 }
            if (r13 == 0) goto L_0x02d2
        L_0x02b3:
            java.lang.Object r13 = r12.next()     // Catch:{ IOException -> 0x02d6 }
            java.util.Objects.requireNonNull(r13)     // Catch:{ IOException -> 0x02d6 }
            boolean r14 = r13 instanceof java.lang.CharSequence     // Catch:{ IOException -> 0x02d6 }
            if (r14 == 0) goto L_0x02c1
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ IOException -> 0x02d6 }
            goto L_0x02c5
        L_0x02c1:
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x02d6 }
        L_0x02c5:
            r10.append(r13)     // Catch:{ IOException -> 0x02d6 }
            boolean r13 = r12.hasNext()     // Catch:{ IOException -> 0x02d6 }
            if (r13 == 0) goto L_0x02d2
            r10.append(r3)     // Catch:{ IOException -> 0x02d6 }
            goto L_0x02b3
        L_0x02d2:
            r10.append(r11)
            goto L_0x02dd
        L_0x02d6:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x02dd:
            java.lang.String r3 = r10.toString()
        L_0x02e1:
            r10 = 0
            r1[r10] = r3
            r3 = 1
            r1[r3] = r2
            java.lang.String r3 = "Format exceeds selected codec's capabilities [%s, %s]"
            java.lang.String r1 = j1.l0.l(r3, r1)
            java.lang.String r3 = "MediaCodecRenderer"
            j1.v.g(r3, r1)
        L_0x02f2:
            r7.U = r0
            r7.R = r4
            g1.a0 r1 = r7.E
            r7.O = r1
            int r1 = j1.l0.f8453a
            java.lang.String r3 = "OMX.Exynos.avc.dec.secure"
            r4 = 25
            if (r1 > r4) goto L_0x032c
            boolean r10 = r3.equals(r2)
            if (r10 == 0) goto L_0x032c
            java.lang.String r10 = j1.l0.f8456d
            java.lang.String r11 = "SM-T585"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x032a
            java.lang.String r11 = "SM-A510"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x032a
            java.lang.String r11 = "SM-A520"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x032a
            java.lang.String r11 = "SM-J700"
            boolean r10 = r10.startsWith(r11)
            if (r10 == 0) goto L_0x032c
        L_0x032a:
            r10 = 2
            goto L_0x0365
        L_0x032c:
            r10 = 24
            if (r1 >= r10) goto L_0x0364
            java.lang.String r10 = "OMX.Nvidia.h264.decode"
            boolean r10 = r10.equals(r2)
            if (r10 != 0) goto L_0x0340
            java.lang.String r10 = "OMX.Nvidia.h264.decode.secure"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0364
        L_0x0340:
            java.lang.String r10 = j1.l0.f8454b
            java.lang.String r11 = "flounder"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x0362
            java.lang.String r11 = "flounder_lte"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x0362
            java.lang.String r11 = "grouper"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x0362
            java.lang.String r11 = "tilapia"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x0364
        L_0x0362:
            r10 = 1
            goto L_0x0365
        L_0x0364:
            r10 = 0
        L_0x0365:
            r7.V = r10
            g1.a0 r10 = r7.O
            r11 = 21
            if (r1 >= r11) goto L_0x037f
            java.util.List r10 = r10.f6278u
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x037f
            java.lang.String r10 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x037f
            r10 = 1
            goto L_0x0380
        L_0x037f:
            r10 = 0
        L_0x0380:
            r7.W = r10
            r10 = 19
            r12 = 18
            if (r1 < r12) goto L_0x03b7
            if (r1 != r12) goto L_0x039a
            java.lang.String r13 = "OMX.SEC.avc.dec"
            boolean r13 = r13.equals(r2)
            if (r13 != 0) goto L_0x03b7
            java.lang.String r13 = "OMX.SEC.avc.dec.secure"
            boolean r13 = r13.equals(r2)
            if (r13 != 0) goto L_0x03b7
        L_0x039a:
            if (r1 != r10) goto L_0x03b5
            java.lang.String r13 = j1.l0.f8456d
            java.lang.String r14 = "SM-G800"
            boolean r13 = r13.startsWith(r14)
            if (r13 == 0) goto L_0x03b5
            java.lang.String r13 = "OMX.Exynos.avc.dec"
            boolean r13 = r13.equals(r2)
            if (r13 != 0) goto L_0x03b7
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x03b5
            goto L_0x03b7
        L_0x03b5:
            r3 = 0
            goto L_0x03b8
        L_0x03b7:
            r3 = 1
        L_0x03b8:
            r7.X = r3
            r3 = 29
            if (r1 != r3) goto L_0x03c8
            java.lang.String r13 = "c2.android.aac.decoder"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x03c8
            r13 = 1
            goto L_0x03c9
        L_0x03c8:
            r13 = 0
        L_0x03c9:
            r7.Y = r13
            r13 = 23
            if (r1 > r13) goto L_0x03d7
            java.lang.String r13 = "OMX.google.vorbis.decoder"
            boolean r13 = r13.equals(r2)
            if (r13 != 0) goto L_0x03fb
        L_0x03d7:
            if (r1 > r10) goto L_0x03fd
            java.lang.String r10 = j1.l0.f8454b
            java.lang.String r13 = "hb2000"
            boolean r13 = r13.equals(r10)
            if (r13 != 0) goto L_0x03eb
            java.lang.String r13 = "stvm8"
            boolean r10 = r13.equals(r10)
            if (r10 == 0) goto L_0x03fd
        L_0x03eb:
            java.lang.String r10 = "OMX.amlogic.avc.decoder.awesome"
            boolean r10 = r10.equals(r2)
            if (r10 != 0) goto L_0x03fb
            java.lang.String r10 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x03fd
        L_0x03fb:
            r10 = 1
            goto L_0x03fe
        L_0x03fd:
            r10 = 0
        L_0x03fe:
            r7.Z = r10
            if (r1 != r11) goto L_0x040c
            java.lang.String r10 = "OMX.google.aac.decoder"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x040c
            r10 = 1
            goto L_0x040d
        L_0x040c:
            r10 = 0
        L_0x040d:
            r7.f14049a0 = r10
            if (r1 >= r11) goto L_0x0457
            java.lang.String r10 = "OMX.SEC.mp3.dec"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0457
            java.lang.String r10 = "samsung"
            java.lang.String r11 = j1.l0.f8455c
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x0457
            java.lang.String r10 = j1.l0.f8454b
            java.lang.String r11 = "baffin"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x0455
            java.lang.String r11 = "grand"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x0455
            java.lang.String r11 = "fortuna"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x0455
            java.lang.String r11 = "gprimelte"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x0455
            java.lang.String r11 = "j2y18lte"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x0455
            java.lang.String r11 = "ms01"
            boolean r10 = r10.startsWith(r11)
            if (r10 == 0) goto L_0x0457
        L_0x0455:
            r10 = 1
            goto L_0x0458
        L_0x0457:
            r10 = 0
        L_0x0458:
            r7.f14050b0 = r10
            g1.a0 r10 = r7.O
            if (r1 > r12) goto L_0x046d
            int r10 = r10.F
            r11 = 1
            if (r10 != r11) goto L_0x046d
            java.lang.String r10 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x046d
            r10 = 1
            goto L_0x046e
        L_0x046d:
            r10 = 0
        L_0x046e:
            r7.f14051c0 = r10
            java.lang.String r10 = r0.f14033a
            if (r1 > r4) goto L_0x047c
            java.lang.String r4 = "OMX.rk.video_decoder.avc"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x04d2
        L_0x047c:
            r4 = 17
            if (r1 > r4) goto L_0x0488
            java.lang.String r4 = "OMX.allwinner.video.decoder.avc"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x04d2
        L_0x0488:
            if (r1 > r3) goto L_0x04ba
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel"
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x04d2
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel.secure"
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x04d2
            java.lang.String r1 = "OMX.bcm.vdec.avc.tunnel"
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x04d2
            java.lang.String r1 = "OMX.bcm.vdec.avc.tunnel.secure"
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x04d2
            java.lang.String r1 = "OMX.bcm.vdec.hevc.tunnel"
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x04d2
            java.lang.String r1 = "OMX.bcm.vdec.hevc.tunnel.secure"
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x04d2
        L_0x04ba:
            java.lang.String r1 = "Amazon"
            java.lang.String r3 = j1.l0.f8455c
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x04d4
            java.lang.String r1 = "AFTS"
            java.lang.String r3 = j1.l0.f8456d
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x04d4
            boolean r0 = r0.f14038f
            if (r0 == 0) goto L_0x04d4
        L_0x04d2:
            r0 = 1
            goto L_0x04d5
        L_0x04d4:
            r0 = 0
        L_0x04d5:
            if (r0 != 0) goto L_0x04e0
            boolean r0 = r16.J()
            if (r0 == 0) goto L_0x04de
            goto L_0x04e0
        L_0x04de:
            r0 = 0
            goto L_0x04e1
        L_0x04e0:
            r0 = 1
        L_0x04e1:
            r7.f14054f0 = r0
            s1.m r0 = r7.N
            r0.c()
            java.lang.String r0 = "c2.android.mp3.decoder"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x04f7
            s1.h r0 = new s1.h
            r0.<init>()
            r7.f14055g0 = r0
        L_0x04f7:
            int r0 = r7.f10221m
            r1 = 2
            if (r0 != r1) goto L_0x0505
            long r0 = android.os.SystemClock.elapsedRealtime()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r3
            r7.f14056h0 = r0
        L_0x0505:
            m1.g r0 = r7.E0
            int r1 = r0.f10231a
            int r1 = r1 + 1
            r0.f10231a = r1
            long r5 = r8 - r5
            r1 = r16
            r3 = r8
            r1.T(r2, r3, r5)
            return
        L_0x0516:
            r0 = move-exception
            j1.i0.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.u.P(s1.q, android.media.MediaCrypto):void");
    }

    public final void Q() {
        a0 a0Var;
        boolean z10;
        if (this.N == null && !this.f14062n0 && (a0Var = this.E) != null) {
            if (this.H != null || !l0(a0Var)) {
                i0(this.H);
                String str = this.E.f6276s;
                n nVar = this.G;
                if (nVar != null) {
                    if (this.I == null) {
                        d0 M2 = M(nVar);
                        if (M2 != null) {
                            try {
                                MediaCrypto mediaCrypto = new MediaCrypto(M2.f12420a, M2.f12421b);
                                this.I = mediaCrypto;
                                if (M2.f12422c || !mediaCrypto.requiresSecureDecoderComponent(str)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                this.J = z10;
                            } catch (MediaCryptoException e10) {
                                throw c(6006, this.E, e10, false);
                            }
                        } else if (this.G.f() == null) {
                            return;
                        }
                    }
                    if (d0.f12419d) {
                        int state = this.G.getState();
                        if (state == 1) {
                            m f10 = this.G.f();
                            f10.getClass();
                            throw c(f10.f12499h, this.E, f10, false);
                        } else if (state != 4) {
                            return;
                        }
                    }
                }
                try {
                    R(this.I, this.J);
                } catch (s e11) {
                    throw c(4001, this.E, e11, false);
                }
            } else {
                a0 a0Var2 = this.E;
                C();
                String str2 = a0Var2.f6276s;
                boolean equals = "audio/mp4a-latm".equals(str2);
                g gVar = this.A;
                if (equals || "audio/mpeg".equals(str2) || "audio/opus".equals(str2)) {
                    gVar.getClass();
                    gVar.f14018r = 32;
                } else {
                    gVar.getClass();
                    gVar.f14018r = 1;
                }
                this.f14062n0 = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: s1.q} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R(android.media.MediaCrypto r12, boolean r13) {
        /*
            r11 = this;
            java.util.ArrayDeque r0 = r11.S
            r1 = 0
            if (r0 != 0) goto L_0x0039
            java.util.List r0 = r11.I(r13)     // Catch:{ y -> 0x002d }
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch:{ y -> 0x002d }
            r2.<init>()     // Catch:{ y -> 0x002d }
            r11.S = r2     // Catch:{ y -> 0x002d }
            boolean r3 = r11.f14072v     // Catch:{ y -> 0x002d }
            if (r3 == 0) goto L_0x0018
            r2.addAll(r0)     // Catch:{ y -> 0x002d }
            goto L_0x002a
        L_0x0018:
            boolean r2 = r0.isEmpty()     // Catch:{ y -> 0x002d }
            if (r2 != 0) goto L_0x002a
            java.util.ArrayDeque r2 = r11.S     // Catch:{ y -> 0x002d }
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch:{ y -> 0x002d }
            s1.q r0 = (s1.q) r0     // Catch:{ y -> 0x002d }
            r2.add(r0)     // Catch:{ y -> 0x002d }
        L_0x002a:
            r11.T = r1     // Catch:{ y -> 0x002d }
            goto L_0x0039
        L_0x002d:
            r12 = move-exception
            s1.s r0 = new s1.s
            g1.a0 r1 = r11.E
            r2 = -49998(0xffffffffffff3cb2, float:NaN)
            r0.<init>(r2, r1, r12, r13)
            throw r0
        L_0x0039:
            java.util.ArrayDeque r0 = r11.S
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00f4
            java.util.ArrayDeque r0 = r11.S
            java.lang.Object r0 = r0.peekFirst()
            s1.q r0 = (s1.q) r0
        L_0x0049:
            s1.m r2 = r11.N
            if (r2 != 0) goto L_0x00f1
            java.util.ArrayDeque r2 = r11.S
            java.lang.Object r2 = r2.peekFirst()
            r8 = r2
            s1.q r8 = (s1.q) r8
            boolean r2 = r11.k0(r8)
            if (r2 != 0) goto L_0x005d
            return
        L_0x005d:
            r11.P(r8, r12)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0049
        L_0x0061:
            r2 = move-exception
            java.lang.String r3 = "MediaCodecRenderer"
            if (r8 != r0) goto L_0x0074
            java.lang.String r2 = "Preferred decoder instantiation failed. Sleeping for 50ms then retrying."
            j1.v.g(r3, r2)     // Catch:{ Exception -> 0x0075 }
            r4 = 50
            java.lang.Thread.sleep(r4)     // Catch:{ Exception -> 0x0075 }
            r11.P(r8, r12)     // Catch:{ Exception -> 0x0075 }
            goto L_0x0049
        L_0x0074:
            throw r2     // Catch:{ Exception -> 0x0075 }
        L_0x0075:
            r2 = move-exception
            r5 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to initialize decoder: "
            r2.<init>(r4)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            j1.v.h(r3, r2, r5)
            java.util.ArrayDeque r2 = r11.S
            r2.removeFirst()
            s1.s r2 = new s1.s
            g1.a0 r3 = r11.E
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Decoder init failed: "
            r4.<init>(r6)
            java.lang.String r6 = r8.f14033a
            r4.append(r6)
            java.lang.String r6 = ", "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = r3.f6276s
            int r3 = j1.l0.f8453a
            r7 = 21
            if (r3 < r7) goto L_0x00be
            boolean r3 = r5 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x00be
            r3 = r5
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            java.lang.String r3 = r3.getDiagnosticInfo()
            r9 = r3
            goto L_0x00bf
        L_0x00be:
            r9 = r1
        L_0x00bf:
            r3 = r2
            r7 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r11.S(r2)
            s1.s r3 = r11.T
            if (r3 != 0) goto L_0x00cc
            goto L_0x00e2
        L_0x00cc:
            s1.s r2 = new s1.s
            java.lang.String r5 = r3.getMessage()
            java.lang.Throwable r6 = r3.getCause()
            java.lang.String r7 = r3.f14041h
            boolean r8 = r3.f14042i
            s1.q r9 = r3.f14043j
            java.lang.String r10 = r3.f14044k
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10)
        L_0x00e2:
            r11.T = r2
            java.util.ArrayDeque r2 = r11.S
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x00ee
            goto L_0x0049
        L_0x00ee:
            s1.s r12 = r11.T
            throw r12
        L_0x00f1:
            r11.S = r1
            return
        L_0x00f4:
            s1.s r12 = new s1.s
            g1.a0 r0 = r11.E
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r12.<init>(r2, r0, r1, r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.u.R(android.media.MediaCrypto, boolean):void");
    }

    public abstract void S(Exception exc);

    public abstract void T(String str, long j10, long j11);

    public abstract void U(String str);

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x013e, code lost:
        r12 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0084, code lost:
        if (r12 != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00de, code lost:
        if (D() == false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0110, code lost:
        if (D() == false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0124, code lost:
        if (D() == false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x013c, code lost:
        if (r0 == false) goto L_0x013e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0168 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m1.h V(m1.w0 r12) {
        /*
            r11 = this;
            r0 = 1
            r11.B0 = r0
            g1.a0 r4 = r12.f10523b
            r4.getClass()
            r1 = 0
            java.lang.String r2 = r4.f6276s
            if (r2 == 0) goto L_0x0169
            p1.n r12 = r12.f10522a
            p1.n r3 = r11.H
            r5 = 0
            if (r3 != r12) goto L_0x0015
            goto L_0x001f
        L_0x0015:
            if (r12 == 0) goto L_0x001a
            r12.c(r5)
        L_0x001a:
            if (r3 == 0) goto L_0x001f
            r3.d(r5)
        L_0x001f:
            r11.H = r12
            r11.E = r4
            boolean r3 = r11.f14062n0
            if (r3 == 0) goto L_0x002a
            r11.f14064p0 = r0
            return r5
        L_0x002a:
            s1.m r3 = r11.N
            if (r3 != 0) goto L_0x0034
            r11.S = r5
            r11.Q()
            return r5
        L_0x0034:
            s1.q r5 = r11.U
            g1.a0 r6 = r11.O
            p1.n r7 = r11.G
            r8 = 23
            if (r7 != r12) goto L_0x003f
            goto L_0x0087
        L_0x003f:
            if (r12 == 0) goto L_0x0089
            if (r7 != 0) goto L_0x0044
            goto L_0x0089
        L_0x0044:
            java.util.UUID r9 = r12.b()
            java.util.UUID r10 = r7.b()
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0053
            goto L_0x0089
        L_0x0053:
            int r9 = j1.l0.f8453a
            if (r9 >= r8) goto L_0x0058
            goto L_0x0089
        L_0x0058:
            java.util.UUID r9 = g1.n.f6477e
            java.util.UUID r7 = r7.b()
            boolean r7 = r9.equals(r7)
            if (r7 != 0) goto L_0x0089
            java.util.UUID r7 = r12.b()
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x006f
            goto L_0x0089
        L_0x006f:
            p1.d0 r7 = r11.M(r12)
            if (r7 != 0) goto L_0x0076
            goto L_0x0089
        L_0x0076:
            boolean r7 = r7.f12422c
            if (r7 == 0) goto L_0x007c
            r12 = 0
            goto L_0x0080
        L_0x007c:
            boolean r12 = r12.e(r2)
        L_0x0080:
            boolean r2 = r5.f14038f
            if (r2 != 0) goto L_0x0087
            if (r12 == 0) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r12 = 0
            goto L_0x008a
        L_0x0089:
            r12 = 1
        L_0x008a:
            r2 = 3
            if (r12 == 0) goto L_0x00aa
            boolean r12 = r11.f14071u0
            if (r12 == 0) goto L_0x0096
            r11.f14067s0 = r0
            r11.f14069t0 = r2
            goto L_0x009c
        L_0x0096:
            r11.e0()
            r11.Q()
        L_0x009c:
            m1.h r12 = new m1.h
            java.lang.String r2 = r5.f14033a
            r5 = 0
            r0 = 128(0x80, float:1.794E-43)
            r1 = r12
            r3 = r6
            r6 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r12
        L_0x00aa:
            p1.n r12 = r11.H
            p1.n r7 = r11.G
            if (r12 == r7) goto L_0x00b2
            r12 = 1
            goto L_0x00b3
        L_0x00b2:
            r12 = 0
        L_0x00b3:
            if (r12 == 0) goto L_0x00bc
            int r7 = j1.l0.f8453a
            if (r7 < r8) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            r7 = 0
            goto L_0x00bd
        L_0x00bc:
            r7 = 1
        L_0x00bd:
            j1.a.e(r7)
            m1.h r7 = r11.A(r5, r6, r4)
            int r8 = r7.f10255d
            if (r8 == 0) goto L_0x0140
            r9 = 2
            if (r8 == r0) goto L_0x0113
            if (r8 == r9) goto L_0x00e7
            if (r8 != r2) goto L_0x00e1
            boolean r0 = r11.n0(r4)
            if (r0 != 0) goto L_0x00d6
            goto L_0x0119
        L_0x00d6:
            r11.O = r4
            if (r12 == 0) goto L_0x014f
            boolean r12 = r11.D()
            if (r12 != 0) goto L_0x014f
            goto L_0x013e
        L_0x00e1:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>()
            throw r12
        L_0x00e7:
            boolean r8 = r11.n0(r4)
            if (r8 != 0) goto L_0x00ee
            goto L_0x0119
        L_0x00ee:
            r11.f14065q0 = r0
            r11.f14066r0 = r0
            int r8 = r11.V
            if (r8 == r9) goto L_0x0106
            if (r8 != r0) goto L_0x0105
            int r8 = r6.f6281x
            int r10 = r4.f6281x
            if (r10 != r8) goto L_0x0105
            int r8 = r4.f6282y
            int r10 = r6.f6282y
            if (r8 != r10) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r0 = 0
        L_0x0106:
            r11.f14052d0 = r0
            r11.O = r4
            if (r12 == 0) goto L_0x014f
            boolean r12 = r11.D()
            if (r12 != 0) goto L_0x014f
            goto L_0x013e
        L_0x0113:
            boolean r8 = r11.n0(r4)
            if (r8 != 0) goto L_0x011c
        L_0x0119:
            r12 = 16
            goto L_0x0150
        L_0x011c:
            r11.O = r4
            if (r12 == 0) goto L_0x0127
            boolean r12 = r11.D()
            if (r12 != 0) goto L_0x014f
            goto L_0x013e
        L_0x0127:
            boolean r12 = r11.f14071u0
            if (r12 == 0) goto L_0x013c
            r11.f14067s0 = r0
            boolean r12 = r11.X
            if (r12 != 0) goto L_0x0139
            boolean r12 = r11.Z
            if (r12 == 0) goto L_0x0136
            goto L_0x0139
        L_0x0136:
            r11.f14069t0 = r0
            goto L_0x013c
        L_0x0139:
            r11.f14069t0 = r2
            r0 = 0
        L_0x013c:
            if (r0 != 0) goto L_0x014f
        L_0x013e:
            r12 = 2
            goto L_0x0150
        L_0x0140:
            boolean r12 = r11.f14071u0
            if (r12 == 0) goto L_0x0149
            r11.f14067s0 = r0
            r11.f14069t0 = r2
            goto L_0x014f
        L_0x0149:
            r11.e0()
            r11.Q()
        L_0x014f:
            r12 = 0
        L_0x0150:
            int r0 = r7.f10255d
            if (r0 == 0) goto L_0x0168
            s1.m r0 = r11.N
            if (r0 != r3) goto L_0x015c
            int r0 = r11.f14069t0
            if (r0 != r2) goto L_0x0168
        L_0x015c:
            m1.h r0 = new m1.h
            java.lang.String r2 = r5.f14033a
            r5 = 0
            r1 = r0
            r3 = r6
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            return r0
        L_0x0168:
            return r7
        L_0x0169:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r12.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            m1.p r12 = r11.c(r0, r4, r12, r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.u.V(m1.w0):m1.h");
    }

    public abstract void W(a0 a0Var, MediaFormat mediaFormat);

    public void X() {
    }

    public void Y(long j10) {
        this.G0 = j10;
        while (true) {
            ArrayDeque arrayDeque = this.D;
            if (!arrayDeque.isEmpty() && j10 >= ((t) arrayDeque.peek()).f14046a) {
                j0((t) arrayDeque.poll());
                Z();
            } else {
                return;
            }
        }
    }

    public abstract void Z();

    public abstract void a0(h hVar);

    public final void b0() {
        int i10 = this.f14069t0;
        if (i10 == 1) {
            G();
        } else if (i10 == 2) {
            G();
            o0();
        } else if (i10 != 3) {
            this.A0 = true;
            f0();
        } else {
            e0();
            Q();
        }
    }

    public abstract boolean c0(long j10, long j11, m mVar, ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, a0 a0Var);

    public final boolean d0(int i10) {
        w0 w0Var = this.f10217i;
        w0Var.a();
        h hVar = this.f14076x;
        hVar.h();
        int s10 = s(w0Var, hVar, i10 | 4);
        if (s10 == -5) {
            V(w0Var);
            return true;
        } else if (s10 != -4 || !hVar.f(4)) {
            return false;
        } else {
            this.f14081z0 = true;
            b0();
            return false;
        }
    }

    public final void e0() {
        try {
            m mVar = this.N;
            if (mVar != null) {
                mVar.a();
                this.E0.f10232b++;
                U(this.U.f14033a);
            }
            this.N = null;
            try {
                MediaCrypto mediaCrypto = this.I;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.I = null;
                i0((n) null);
                h0();
            }
        } catch (Throwable th) {
            this.N = null;
            MediaCrypto mediaCrypto2 = this.I;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        } finally {
            this.I = null;
            i0((n) null);
            h0();
        }
    }

    public void f0() {
    }

    public void g0() {
        this.f14057i0 = -1;
        this.f14078y.f9515j = null;
        this.f14058j0 = -1;
        this.f14059k0 = null;
        this.f14056h0 = -9223372036854775807L;
        this.f14073v0 = false;
        this.f14071u0 = false;
        this.f14052d0 = false;
        this.f14053e0 = false;
        this.f14060l0 = false;
        this.f14061m0 = false;
        this.B.clear();
        this.f14077x0 = -9223372036854775807L;
        this.f14079y0 = -9223372036854775807L;
        this.G0 = -9223372036854775807L;
        h hVar = this.f14055g0;
        if (hVar != null) {
            hVar.f14019a = 0;
            hVar.f14020b = 0;
            hVar.f14021c = false;
        }
        this.f14067s0 = 0;
        this.f14069t0 = 0;
        this.f14066r0 = this.f14065q0 ? 1 : 0;
    }

    public final void h0() {
        g0();
        this.D0 = null;
        this.f14055g0 = null;
        this.S = null;
        this.U = null;
        this.O = null;
        this.P = null;
        this.Q = false;
        this.f14075w0 = false;
        this.R = -1.0f;
        this.V = 0;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f14049a0 = false;
        this.f14050b0 = false;
        this.f14051c0 = false;
        this.f14054f0 = false;
        this.f14065q0 = false;
        this.f14066r0 = 0;
        this.J = false;
    }

    public final void i0(n nVar) {
        n nVar2 = this.G;
        if (nVar2 != nVar) {
            if (nVar != null) {
                nVar.c((q) null);
            }
            if (nVar2 != null) {
                nVar2.d((q) null);
            }
        }
        this.G = nVar;
    }

    public boolean j() {
        return this.A0;
    }

    public final void j0(t tVar) {
        this.F0 = tVar;
        if (tVar.f14047b != -9223372036854775807L) {
            this.H0 = true;
            X();
        }
    }

    public boolean k() {
        boolean z10;
        boolean z11;
        if (this.E == null) {
            return false;
        }
        if (h()) {
            z10 = this.f10226r;
        } else {
            b1 b1Var = this.f10222n;
            b1Var.getClass();
            z10 = b1Var.b();
        }
        if (!z10) {
            if (this.f14058j0 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 || (this.f14056h0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f14056h0)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean k0(q qVar) {
        return true;
    }

    public void l() {
        this.E = null;
        j0(t.f14045d);
        this.D.clear();
        H();
    }

    public boolean l0(a0 a0Var) {
        return false;
    }

    public abstract int m0(v vVar, a0 a0Var);

    public void n(long j10, boolean z10) {
        int i10;
        this.f14081z0 = false;
        this.A0 = false;
        this.C0 = false;
        if (this.f14062n0) {
            this.A.h();
            this.f14080z.h();
            this.f14063o0 = false;
        } else if (H()) {
            Q();
        }
        g0 g0Var = this.F0.f14048c;
        synchronized (g0Var) {
            i10 = g0Var.f8434d;
        }
        if (i10 > 0) {
            this.B0 = true;
        }
        this.F0.f14048c.b();
        this.D.clear();
    }

    public final boolean n0(a0 a0Var) {
        if (!(l0.f8453a < 23 || this.N == null || this.f14069t0 == 3 || this.f10221m == 0)) {
            float f10 = this.M;
            a0[] a0VarArr = this.f10223o;
            a0VarArr.getClass();
            float K2 = K(f10, a0VarArr);
            float f11 = this.R;
            if (f11 == K2) {
                return true;
            }
            if (K2 == -1.0f) {
                if (this.f14071u0) {
                    this.f14067s0 = 1;
                    this.f14069t0 = 3;
                    return false;
                }
                e0();
                Q();
                return false;
            } else if (f11 == -1.0f && K2 <= this.f14074w) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", K2);
                this.N.k(bundle);
                this.R = K2;
            }
        }
        return true;
    }

    public final void o0() {
        try {
            this.I.setMediaDrmSession(M(this.H).f12421b);
            i0(this.H);
            this.f14067s0 = 0;
            this.f14069t0 = 0;
        } catch (MediaCryptoException e10) {
            throw c(6006, this.E, e10, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: g1.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: g1.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: g1.a0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p0(long r2) {
        /*
            r1 = this;
            s1.t r0 = r1.F0
            j1.g0 r0 = r0.f14048c
            java.lang.Object r2 = r0.e(r2)
            g1.a0 r2 = (g1.a0) r2
            if (r2 != 0) goto L_0x002b
            boolean r3 = r1.H0
            if (r3 == 0) goto L_0x002b
            android.media.MediaFormat r3 = r1.P
            if (r3 == 0) goto L_0x002b
            s1.t r2 = r1.F0
            j1.g0 r2 = r2.f14048c
            monitor-enter(r2)
            int r3 = r2.f8434d     // Catch:{ all -> 0x0028 }
            if (r3 != 0) goto L_0x001f
            r3 = 0
            goto L_0x0023
        L_0x001f:
            java.lang.Object r3 = r2.f()     // Catch:{ all -> 0x0028 }
        L_0x0023:
            monitor-exit(r2)
            r2 = r3
            g1.a0 r2 = (g1.a0) r2
            goto L_0x002b
        L_0x0028:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002b:
            r3 = 0
            if (r2 == 0) goto L_0x0032
            r1.F = r2
            r2 = 1
            goto L_0x0033
        L_0x0032:
            r2 = 0
        L_0x0033:
            if (r2 != 0) goto L_0x003d
            boolean r2 = r1.Q
            if (r2 == 0) goto L_0x0048
            g1.a0 r2 = r1.F
            if (r2 == 0) goto L_0x0048
        L_0x003d:
            g1.a0 r2 = r1.F
            android.media.MediaFormat r0 = r1.P
            r1.W(r2, r0)
            r1.Q = r3
            r1.H0 = r3
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.u.p0(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r2 >= r7) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(g1.a0[] r6, long r7, long r9) {
        /*
            r5 = this;
            s1.t r6 = r5.F0
            long r6 = r6.f14047b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x0016
            s1.t r6 = new s1.t
            r6.<init>(r0, r9)
            r5.j0(r6)
            goto L_0x004c
        L_0x0016:
            java.util.ArrayDeque r6 = r5.D
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0042
            long r7 = r5.f14077x0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x002e
            long r2 = r5.G0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x0042
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 < 0) goto L_0x0042
        L_0x002e:
            s1.t r6 = new s1.t
            r6.<init>(r0, r9)
            r5.j0(r6)
            s1.t r6 = r5.F0
            long r6 = r6.f14047b
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 == 0) goto L_0x004c
            r5.Z()
            goto L_0x004c
        L_0x0042:
            s1.t r7 = new s1.t
            long r0 = r5.f14077x0
            r7.<init>(r0, r9)
            r6.add(r7)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.u.r(g1.a0[], long, long):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063 A[Catch:{ IllegalStateException -> 0x009f }, LOOP:1: B:25:0x0043->B:35:0x0063, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f A[Catch:{ IllegalStateException -> 0x009f }, LOOP:2: B:36:0x0064->B:46:0x007f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0064 A[EDGE_INSN: B:81:0x0064->B:85:0x0064 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0080 A[EDGE_INSN: B:84:0x0080->B:47:0x0080 ?: BREAK  , SYNTHETIC] */
    public final void t(long r12, long r14) {
        /*
            r11 = this;
            boolean r0 = r11.C0
            r1 = 0
            if (r0 == 0) goto L_0x000a
            r11.C0 = r1
            r11.b0()
        L_0x000a:
            m1.p r0 = r11.D0
            if (r0 != 0) goto L_0x00ef
            r0 = 1
            boolean r2 = r11.A0     // Catch:{ IllegalStateException -> 0x009f }
            if (r2 == 0) goto L_0x0017
            r11.f0()     // Catch:{ IllegalStateException -> 0x009f }
            return
        L_0x0017:
            g1.a0 r2 = r11.E     // Catch:{ IllegalStateException -> 0x009f }
            if (r2 != 0) goto L_0x0023
            r2 = 2
            boolean r2 = r11.d0(r2)     // Catch:{ IllegalStateException -> 0x009f }
            if (r2 != 0) goto L_0x0023
            return
        L_0x0023:
            r11.Q()     // Catch:{ IllegalStateException -> 0x009f }
            boolean r2 = r11.f14062n0     // Catch:{ IllegalStateException -> 0x009f }
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = "bypassRender"
            j1.i0.a(r2)     // Catch:{ IllegalStateException -> 0x009f }
        L_0x002f:
            boolean r2 = r11.z(r12, r14)     // Catch:{ IllegalStateException -> 0x009f }
            if (r2 == 0) goto L_0x0080
            goto L_0x002f
        L_0x0036:
            s1.m r2 = r11.N     // Catch:{ IllegalStateException -> 0x009f }
            if (r2 == 0) goto L_0x0084
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x009f }
            java.lang.String r4 = "drainAndFeed"
            j1.i0.a(r4)     // Catch:{ IllegalStateException -> 0x009f }
        L_0x0043:
            boolean r4 = r11.E(r12, r14)     // Catch:{ IllegalStateException -> 0x009f }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x0064
            long r7 = r11.K     // Catch:{ IllegalStateException -> 0x009f }
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0060
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x009f }
            long r9 = r9 - r2
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r4 = 0
            goto L_0x0061
        L_0x0060:
            r4 = 1
        L_0x0061:
            if (r4 == 0) goto L_0x0064
            goto L_0x0043
        L_0x0064:
            boolean r12 = r11.F()     // Catch:{ IllegalStateException -> 0x009f }
            if (r12 == 0) goto L_0x0080
            long r12 = r11.K     // Catch:{ IllegalStateException -> 0x009f }
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 == 0) goto L_0x007c
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x009f }
            long r14 = r14 - r2
            int r4 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r4 >= 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r12 = 0
            goto L_0x007d
        L_0x007c:
            r12 = 1
        L_0x007d:
            if (r12 == 0) goto L_0x0080
            goto L_0x0064
        L_0x0080:
            j1.i0.b()     // Catch:{ IllegalStateException -> 0x009f }
            goto L_0x009a
        L_0x0084:
            m1.g r14 = r11.E0     // Catch:{ IllegalStateException -> 0x009f }
            int r15 = r14.f10234d     // Catch:{ IllegalStateException -> 0x009f }
            v1.b1 r2 = r11.f10222n     // Catch:{ IllegalStateException -> 0x009f }
            r2.getClass()     // Catch:{ IllegalStateException -> 0x009f }
            long r3 = r11.f10224p     // Catch:{ IllegalStateException -> 0x009f }
            long r12 = r12 - r3
            int r12 = r2.d(r12)     // Catch:{ IllegalStateException -> 0x009f }
            int r15 = r15 + r12
            r14.f10234d = r15     // Catch:{ IllegalStateException -> 0x009f }
            r11.d0(r0)     // Catch:{ IllegalStateException -> 0x009f }
        L_0x009a:
            m1.g r12 = r11.E0     // Catch:{ IllegalStateException -> 0x009f }
            monitor-enter(r12)     // Catch:{ IllegalStateException -> 0x009f }
            monitor-exit(r12)     // Catch:{ IllegalStateException -> 0x009f }
            return
        L_0x009f:
            r12 = move-exception
            int r13 = j1.l0.f8453a
            r14 = 21
            if (r13 < r14) goto L_0x00ab
            boolean r15 = r12 instanceof android.media.MediaCodec.CodecException
            if (r15 == 0) goto L_0x00ab
            goto L_0x00c0
        L_0x00ab:
            java.lang.StackTraceElement[] r15 = r12.getStackTrace()
            int r2 = r15.length
            if (r2 <= 0) goto L_0x00c2
            r15 = r15[r1]
            java.lang.String r15 = r15.getClassName()
            java.lang.String r2 = "android.media.MediaCodec"
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto L_0x00c2
        L_0x00c0:
            r15 = 1
            goto L_0x00c3
        L_0x00c2:
            r15 = 0
        L_0x00c3:
            if (r15 == 0) goto L_0x00ee
            r11.S(r12)
            if (r13 < r14) goto L_0x00da
            boolean r13 = r12 instanceof android.media.MediaCodec.CodecException
            if (r13 == 0) goto L_0x00d6
            r13 = r12
            android.media.MediaCodec$CodecException r13 = (android.media.MediaCodec.CodecException) r13
            boolean r13 = r13.isRecoverable()
            goto L_0x00d7
        L_0x00d6:
            r13 = 0
        L_0x00d7:
            if (r13 == 0) goto L_0x00da
            r1 = 1
        L_0x00da:
            if (r1 == 0) goto L_0x00df
            r11.e0()
        L_0x00df:
            s1.q r13 = r11.U
            s1.n r12 = r11.B(r12, r13)
            g1.a0 r13 = r11.E
            r14 = 4003(0xfa3, float:5.61E-42)
            m1.p r12 = r11.c(r14, r13, r12, r1)
            throw r12
        L_0x00ee:
            throw r12
        L_0x00ef:
            r12 = 0
            r11.D0 = r12
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.u.t(long, long):void");
    }

    public void w(float f10, float f11) {
        this.L = f10;
        this.M = f11;
        n0(this.O);
    }

    public final int x(a0 a0Var) {
        try {
            return m0(this.f14070u, a0Var);
        } catch (y e10) {
            throw e(e10, a0Var);
        }
    }

    public final int y() {
        return 8;
    }

    public final boolean z(long j10, long j11) {
        boolean z10;
        g gVar;
        boolean z11;
        boolean z12;
        boolean z13;
        a.e(!this.A0);
        g gVar2 = this.A;
        int i10 = gVar2.f14017q;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ByteBuffer byteBuffer = gVar2.f9515j;
            int i11 = this.f14058j0;
            long j12 = gVar2.f9517l;
            g gVar3 = gVar2;
            if (!c0(j10, j11, (m) null, byteBuffer, i11, 0, i10, j12, gVar2.g(), gVar2.f(4), this.F)) {
                return false;
            }
            gVar = gVar3;
            Y(gVar.f14016p);
            gVar.h();
        } else {
            gVar = gVar2;
        }
        if (this.f14081z0) {
            this.A0 = true;
            return false;
        }
        boolean z14 = this.f14063o0;
        h hVar = this.f14080z;
        if (z14) {
            a.e(gVar.l(hVar));
            this.f14063o0 = false;
        }
        if (this.f14064p0) {
            if (gVar.f14017q > 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                return true;
            }
            C();
            this.f14064p0 = false;
            Q();
            if (!this.f14062n0) {
                return false;
            }
        }
        a.e(!this.f14081z0);
        w0 w0Var = this.f10217i;
        w0Var.a();
        hVar.h();
        while (true) {
            hVar.h();
            int s10 = s(w0Var, hVar, 0);
            if (s10 != -5) {
                if (s10 == -4) {
                    if (!hVar.f(4)) {
                        if (this.B0) {
                            a0 a0Var = this.E;
                            a0Var.getClass();
                            this.F = a0Var;
                            W(a0Var, (MediaFormat) null);
                            this.B0 = false;
                        }
                        hVar.k();
                        if (!gVar.l(hVar)) {
                            this.f14063o0 = true;
                            break;
                        }
                    } else {
                        this.f14081z0 = true;
                        break;
                    }
                } else if (s10 != -3) {
                    throw new IllegalStateException();
                }
            } else {
                V(w0Var);
                break;
            }
        }
        if (gVar.f14017q > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            gVar.k();
        }
        if (gVar.f14017q > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 || this.f14081z0 || this.f14064p0) {
            return true;
        }
        return false;
    }
}

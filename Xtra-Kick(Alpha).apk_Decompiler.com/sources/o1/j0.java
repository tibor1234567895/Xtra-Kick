package o1;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.support.v4.media.n;
import androidx.emoji2.text.r;
import d9.p0;
import d9.r0;
import d9.r1;
import e.a;
import g1.a0;
import g1.e1;
import g1.z;
import j1.l0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import m1.g;
import m1.h;
import m1.k0;
import m1.o0;
import m1.o1;
import m1.w0;
import m1.x0;
import n1.f0;
import p1.e0;
import s1.c0;
import s1.i;
import s1.m;
import s1.q;
import s1.u;
import s1.v;
import s1.w;

public final class j0 extends u implements x0 {
    public final Context J0;
    public final n K0;
    public final m L0;
    public int M0;
    public boolean N0;
    public a0 O0;
    public a0 P0;
    public long Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0;
    public o0 U0;

    public j0(Context context, i iVar, e0 e0Var, Handler handler, k0 k0Var, e0 e0Var2) {
        super(1, iVar, e0Var, 44100.0f);
        this.J0 = context.getApplicationContext();
        this.L0 = e0Var2;
        this.K0 = new n(handler, k0Var);
        e0Var2.f11897r = new a(this);
    }

    public static r0 r0(v vVar, a0 a0Var, boolean z10, m mVar) {
        boolean z11;
        q qVar;
        String str = a0Var.f6276s;
        if (str == null) {
            p0 p0Var = r0.f4657i;
            return r1.f4658l;
        }
        if (((e0) mVar).f(a0Var) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            List e10 = c0.e("audio/raw", false, false);
            if (e10.isEmpty()) {
                qVar = null;
            } else {
                qVar = (q) e10.get(0);
            }
            if (qVar != null) {
                return r0.n(qVar);
            }
        }
        ((e0) vVar).getClass();
        List e11 = c0.e(str, z10, false);
        String b10 = c0.b(a0Var);
        if (b10 == null) {
            return r0.j(e11);
        }
        List e12 = c0.e(b10, z10, false);
        p0 p0Var2 = r0.f4657i;
        d9.o0 o0Var = new d9.o0();
        o0Var.d(e11);
        o0Var.d(e12);
        return o0Var.e();
    }

    public final h A(q qVar, a0 a0Var, a0 a0Var2) {
        h b10 = qVar.b(a0Var, a0Var2);
        int q02 = q0(a0Var2, qVar);
        int i10 = this.M0;
        int i11 = b10.f10256e;
        if (q02 > i10) {
            i11 |= 64;
        }
        int i12 = i11;
        return new h(qVar.f14033a, a0Var, a0Var2, i12 != 0 ? 0 : b10.f10255d, i12);
    }

    public final float K(float f10, a0[] a0VarArr) {
        int i10 = -1;
        for (a0 a0Var : a0VarArr) {
            int i11 = a0Var.G;
            if (i11 != -1) {
                i10 = Math.max(i10, i11);
            }
        }
        if (i10 == -1) {
            return -1.0f;
        }
        return f10 * ((float) i10);
    }

    public final ArrayList L(v vVar, a0 a0Var, boolean z10) {
        r0 r02 = r0(vVar, a0Var, z10, this.L0);
        Pattern pattern = c0.f13983a;
        ArrayList arrayList = new ArrayList(r02);
        Collections.sort(arrayList, new oa.a(2, new w(a0Var)));
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final s1.k N(s1.q r12, g1.a0 r13, android.media.MediaCrypto r14, float r15) {
        /*
            r11 = this;
            g1.a0[] r0 = r11.f10223o
            r0.getClass()
            int r1 = r11.q0(r13, r12)
            int r2 = r0.length
            r3 = 0
            r4 = 1
            if (r2 != r4) goto L_0x000f
            goto L_0x0028
        L_0x000f:
            int r2 = r0.length
            r5 = 0
        L_0x0011:
            if (r5 >= r2) goto L_0x0028
            r6 = r0[r5]
            m1.h r7 = r12.b(r13, r6)
            int r7 = r7.f10255d
            if (r7 == 0) goto L_0x0025
            int r6 = r11.q0(r6, r12)
            int r1 = java.lang.Math.max(r1, r6)
        L_0x0025:
            int r5 = r5 + 1
            goto L_0x0011
        L_0x0028:
            r11.M0 = r1
            int r0 = j1.l0.f8453a
            r1 = 24
            if (r0 >= r1) goto L_0x0060
            java.lang.String r2 = "OMX.SEC.aac.dec"
            java.lang.String r5 = r12.f14033a
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0060
            java.lang.String r2 = "samsung"
            java.lang.String r5 = j1.l0.f8455c
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0060
            java.lang.String r2 = j1.l0.f8454b
            java.lang.String r5 = "zeroflte"
            boolean r5 = r2.startsWith(r5)
            if (r5 != 0) goto L_0x005e
            java.lang.String r5 = "herolte"
            boolean r5 = r2.startsWith(r5)
            if (r5 != 0) goto L_0x005e
            java.lang.String r5 = "heroqlte"
            boolean r2 = r2.startsWith(r5)
            if (r2 == 0) goto L_0x0060
        L_0x005e:
            r2 = 1
            goto L_0x0061
        L_0x0060:
            r2 = 0
        L_0x0061:
            r11.N0 = r2
            int r2 = r11.M0
            android.media.MediaFormat r7 = new android.media.MediaFormat
            r7.<init>()
            java.lang.String r5 = "mime"
            java.lang.String r6 = r12.f14035c
            r7.setString(r5, r6)
            int r5 = r13.F
            java.lang.String r6 = "channel-count"
            r7.setInteger(r6, r5)
            java.lang.String r5 = "sample-rate"
            int r6 = r13.G
            r7.setInteger(r5, r6)
            java.util.List r5 = r13.f6278u
            j1.x.b(r7, r5)
            java.lang.String r5 = "max-input-size"
            j1.x.a(r7, r5, r2)
            r2 = 23
            if (r0 < r2) goto L_0x00b6
            java.lang.String r5 = "priority"
            r7.setInteger(r5, r3)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x00b6
            if (r0 != r2) goto L_0x00ae
            java.lang.String r2 = j1.l0.f8456d
            java.lang.String r5 = "ZTE B2017G"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x00ac
            java.lang.String r5 = "AXON 7 mini"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00ae
        L_0x00ac:
            r2 = 1
            goto L_0x00af
        L_0x00ae:
            r2 = 0
        L_0x00af:
            if (r2 != 0) goto L_0x00b6
            java.lang.String r2 = "operating-rate"
            r7.setFloat(r2, r15)
        L_0x00b6:
            r15 = 28
            java.lang.String r2 = r13.f6276s
            if (r0 > r15) goto L_0x00c9
            java.lang.String r15 = "audio/ac4"
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto L_0x00c9
            java.lang.String r15 = "ac4-is-sync"
            r7.setInteger(r15, r4)
        L_0x00c9:
            java.lang.String r15 = "audio/raw"
            if (r0 < r1) goto L_0x00f1
            g1.z r1 = new g1.z
            r1.<init>()
            r1.f6754k = r15
            int r5 = r13.F
            r1.f6767x = r5
            r1.f6768y = r6
            r5 = 4
            r1.f6769z = r5
            g1.a0 r1 = r1.a()
            o1.m r6 = r11.L0
            o1.e0 r6 = (o1.e0) r6
            int r1 = r6.f(r1)
            r6 = 2
            if (r1 != r6) goto L_0x00f1
            java.lang.String r1 = "pcm-encoding"
            r7.setInteger(r1, r5)
        L_0x00f1:
            r1 = 32
            if (r0 < r1) goto L_0x00fc
            java.lang.String r0 = "max-output-channel-count"
            r1 = 99
            r7.setInteger(r0, r1)
        L_0x00fc:
            java.lang.String r0 = r12.f14034b
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x010b
            boolean r15 = r15.equals(r2)
            if (r15 != 0) goto L_0x010b
            r3 = 1
        L_0x010b:
            if (r3 == 0) goto L_0x010f
            r15 = r13
            goto L_0x0110
        L_0x010f:
            r15 = 0
        L_0x0110:
            r11.P0 = r15
            s1.k r15 = new s1.k
            r9 = 0
            r5 = r15
            r6 = r12
            r8 = r13
            r10 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.j0.N(s1.q, g1.a0, android.media.MediaCrypto, float):s1.k");
    }

    public final void S(Exception exc) {
        j1.v.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        n nVar = this.K0;
        Handler handler = (Handler) nVar.f337i;
        if (handler != null) {
            handler.post(new c(nVar, exc, 0));
        }
    }

    public final void T(String str, long j10, long j11) {
        n nVar = this.K0;
        Handler handler = (Handler) nVar.f337i;
        if (handler != null) {
            handler.post(new f(nVar, str, j10, j11, 0));
        }
    }

    public final void U(String str) {
        n nVar = this.K0;
        Handler handler = (Handler) nVar.f337i;
        if (handler != null) {
            handler.post(new g.r0(nVar, 10, str));
        }
    }

    public final h V(w0 w0Var) {
        a0 a0Var = w0Var.f10523b;
        a0Var.getClass();
        this.O0 = a0Var;
        h V = super.V(w0Var);
        a0 a0Var2 = this.O0;
        n nVar = this.K0;
        Handler handler = (Handler) nVar.f337i;
        if (handler != null) {
            handler.post(new r(nVar, a0Var2, V, 8));
        }
        return V;
    }

    public final void W(a0 a0Var, MediaFormat mediaFormat) {
        int i10;
        int i11;
        a0 a0Var2 = this.P0;
        int[] iArr = null;
        if (a0Var2 != null) {
            a0Var = a0Var2;
        } else if (this.N != null) {
            if ("audio/raw".equals(a0Var.f6276s)) {
                i10 = a0Var.H;
            } else if (l0.f8453a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i10 = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i10 = l0.t(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i10 = 2;
            }
            z zVar = new z();
            zVar.f6754k = "audio/raw";
            zVar.f6769z = i10;
            zVar.A = a0Var.I;
            zVar.B = a0Var.J;
            zVar.f6767x = mediaFormat.getInteger("channel-count");
            zVar.f6768y = mediaFormat.getInteger("sample-rate");
            a0 a0Var3 = new a0(zVar);
            if (this.N0 && a0Var3.F == 6 && (i11 = a0Var.F) < 6) {
                int[] iArr2 = new int[i11];
                for (int i12 = 0; i12 < i11; i12++) {
                    iArr2[i12] = i12;
                }
                iArr = iArr2;
            }
            a0Var = a0Var3;
        }
        try {
            ((e0) this.L0).b(a0Var, iArr);
        } catch (i e10) {
            throw c(5001, e10.f11931h, e10, false);
        }
    }

    public final void X() {
        this.L0.getClass();
    }

    public final void Z() {
        ((e0) this.L0).G = true;
    }

    public final long a() {
        if (this.f10221m == 2) {
            s0();
        }
        return this.Q0;
    }

    public final void a0(l1.h hVar) {
        if (this.R0 && !hVar.g()) {
            if (Math.abs(hVar.f9517l - this.Q0) > 500000) {
                this.Q0 = hVar.f9517l;
            }
            this.R0 = false;
        }
    }

    public final void b(int i10, Object obj) {
        boolean z10;
        m mVar = this.L0;
        if (i10 == 2) {
            float floatValue = ((Float) obj).floatValue();
            e0 e0Var = (e0) mVar;
            if (e0Var.J != floatValue) {
                e0Var.J = floatValue;
                e0Var.t();
            }
        } else if (i10 == 3) {
            g1.h hVar = (g1.h) obj;
            e0 e0Var2 = (e0) mVar;
            if (!e0Var2.f11901v.equals(hVar)) {
                e0Var2.f11901v = hVar;
                if (!e0Var2.Z) {
                    e0Var2.d();
                }
            }
        } else if (i10 != 6) {
            switch (i10) {
                case 9:
                    e0 e0Var3 = (e0) mVar;
                    e0Var3.r(e0Var3.g().f12056a, ((Boolean) obj).booleanValue());
                    return;
                case 10:
                    int intValue = ((Integer) obj).intValue();
                    e0 e0Var4 = (e0) mVar;
                    if (e0Var4.W != intValue) {
                        e0Var4.W = intValue;
                        if (intValue != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        e0Var4.V = z10;
                        e0Var4.d();
                        return;
                    }
                    return;
                case 11:
                    this.U0 = (o0) obj;
                    return;
                case 12:
                    if (l0.f8453a >= 23) {
                        i0.a(mVar, obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            g1.i iVar = (g1.i) obj;
            e0 e0Var5 = (e0) mVar;
            if (!e0Var5.X.equals(iVar)) {
                iVar.getClass();
                if (e0Var5.f11900u != null) {
                    e0Var5.X.getClass();
                }
                e0Var5.X = iVar;
            }
        }
    }

    public final boolean c0(long j10, long j11, m mVar, ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, a0 a0Var) {
        byteBuffer.getClass();
        if (this.P0 == null || (i11 & 2) == 0) {
            m mVar2 = this.L0;
            if (z10) {
                if (mVar != null) {
                    mVar.d(i10, false);
                }
                this.E0.f10236f += i12;
                ((e0) mVar2).G = true;
                return true;
            }
            try {
                if (!((e0) mVar2).j(byteBuffer, j12, i12)) {
                    return false;
                }
                if (mVar != null) {
                    mVar.d(i10, false);
                }
                this.E0.f10235e += i12;
                return true;
            } catch (j e10) {
                throw c(5001, this.O0, e10, e10.f11933i);
            } catch (l e11) {
                throw c(5002, a0Var, e11, e11.f11935i);
            }
        } else {
            mVar.getClass();
            mVar.d(i10, false);
            return true;
        }
    }

    public final void d(e1 e1Var) {
        e0 e0Var = (e0) this.L0;
        e0Var.getClass();
        e1 e1Var2 = new e1(l0.g(e1Var.f6355h, 0.1f, 8.0f), l0.g(e1Var.f6356i, 0.1f, 8.0f));
        if (!e0Var.f11890k || l0.f8453a < 23) {
            e0Var.r(e1Var2, e0Var.g().f12057b);
        } else {
            e0Var.s(e1Var2);
        }
    }

    public final x0 f() {
        return this;
    }

    public final void f0() {
        try {
            e0 e0Var = (e0) this.L0;
            if (!e0Var.S && e0Var.m() && e0Var.c()) {
                e0Var.o();
                e0Var.S = true;
            }
        } catch (l e10) {
            throw c(5002, e10.f11936j, e10, e10.f11935i);
        }
    }

    public final String g() {
        return "MediaCodecAudioRenderer";
    }

    public final e1 i() {
        e0 e0Var = (e0) this.L0;
        if (e0Var.f11890k) {
            return e0Var.f11904y;
        }
        return e0Var.g().f12056a;
    }

    public final boolean j() {
        boolean z10;
        if (!this.A0) {
            return false;
        }
        e0 e0Var = (e0) this.L0;
        if (!e0Var.m() || (e0Var.S && !e0Var.k())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        return ((e0) this.L0).k() || super.k();
    }

    public final void l() {
        n nVar = this.K0;
        this.T0 = true;
        this.O0 = null;
        try {
            ((e0) this.L0).d();
            try {
                super.l();
            } finally {
                nVar.n(this.E0);
            }
        } catch (Throwable th) {
            super.l();
            throw th;
        } finally {
            nVar.n(this.E0);
        }
    }

    public final boolean l0(a0 a0Var) {
        if (((e0) this.L0).f(a0Var) != 0) {
            return true;
        }
        return false;
    }

    public final void m(boolean z10, boolean z11) {
        g gVar = new g();
        this.E0 = gVar;
        n nVar = this.K0;
        Handler handler = (Handler) nVar.f337i;
        if (handler != null) {
            handler.post(new d(nVar, gVar, 1));
        }
        o1 o1Var = this.f10218j;
        o1Var.getClass();
        boolean z12 = o1Var.f10419a;
        boolean z13 = false;
        m mVar = this.L0;
        if (z12) {
            e0 e0Var = (e0) mVar;
            e0Var.getClass();
            if (l0.f8453a >= 21) {
                z13 = true;
            }
            j1.a.e(z13);
            j1.a.e(e0Var.V);
            if (!e0Var.Z) {
                e0Var.Z = true;
                e0Var.d();
            }
        } else {
            e0 e0Var2 = (e0) mVar;
            if (e0Var2.Z) {
                e0Var2.Z = false;
                e0Var2.d();
            }
        }
        f0 f0Var = this.f10220l;
        f0Var.getClass();
        ((e0) mVar).f11896q = f0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        if (r4 != null) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m0(s1.v r12, g1.a0 r13) {
        /*
            r11 = this;
            java.lang.String r0 = r13.f6276s
            boolean r0 = g1.a1.i(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r12 = android.support.v4.media.h.c(r1, r1, r1)
            return r12
        L_0x000e:
            int r0 = j1.l0.f8453a
            r2 = 21
            if (r0 < r2) goto L_0x0017
            r0 = 32
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            r2 = 1
            int r3 = r13.N
            if (r3 == 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            r5 = 2
            if (r3 == 0) goto L_0x0028
            if (r3 != r5) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r3 = 0
            goto L_0x0029
        L_0x0028:
            r3 = 1
        L_0x0029:
            java.lang.String r6 = "audio/raw"
            r7 = 8
            r8 = 4
            o1.m r9 = r11.L0
            if (r3 == 0) goto L_0x005b
            r10 = r9
            o1.e0 r10 = (o1.e0) r10
            int r10 = r10.f(r13)
            if (r10 == 0) goto L_0x003d
            r10 = 1
            goto L_0x003e
        L_0x003d:
            r10 = 0
        L_0x003e:
            if (r10 == 0) goto L_0x005b
            if (r4 == 0) goto L_0x0056
            java.util.List r4 = s1.c0.e(r6, r1, r1)
            boolean r10 = r4.isEmpty()
            if (r10 == 0) goto L_0x004e
            r4 = 0
            goto L_0x0054
        L_0x004e:
            java.lang.Object r4 = r4.get(r1)
            s1.q r4 = (s1.q) r4
        L_0x0054:
            if (r4 == 0) goto L_0x005b
        L_0x0056:
            int r12 = android.support.v4.media.h.c(r8, r7, r0)
            return r12
        L_0x005b:
            java.lang.String r4 = r13.f6276s
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0076
            r4 = r9
            o1.e0 r4 = (o1.e0) r4
            int r4 = r4.f(r13)
            if (r4 == 0) goto L_0x006e
            r4 = 1
            goto L_0x006f
        L_0x006e:
            r4 = 0
        L_0x006f:
            if (r4 != 0) goto L_0x0076
            int r12 = android.support.v4.media.h.c(r2, r1, r1)
            return r12
        L_0x0076:
            g1.z r4 = new g1.z
            r4.<init>()
            r4.f6754k = r6
            int r6 = r13.F
            r4.f6767x = r6
            int r6 = r13.G
            r4.f6768y = r6
            r4.f6769z = r5
            g1.a0 r4 = r4.a()
            r6 = r9
            o1.e0 r6 = (o1.e0) r6
            int r4 = r6.f(r4)
            if (r4 == 0) goto L_0x0096
            r4 = 1
            goto L_0x0097
        L_0x0096:
            r4 = 0
        L_0x0097:
            if (r4 != 0) goto L_0x009e
            int r12 = android.support.v4.media.h.c(r2, r1, r1)
            return r12
        L_0x009e:
            d9.r0 r12 = r0(r12, r13, r1, r9)
            boolean r4 = r12.isEmpty()
            if (r4 == 0) goto L_0x00ad
            int r12 = android.support.v4.media.h.c(r2, r1, r1)
            return r12
        L_0x00ad:
            if (r3 != 0) goto L_0x00b4
            int r12 = android.support.v4.media.h.c(r5, r1, r1)
            return r12
        L_0x00b4:
            java.lang.Object r3 = r12.get(r1)
            s1.q r3 = (s1.q) r3
            boolean r4 = r3.d(r13)
            if (r4 != 0) goto L_0x00d9
            r5 = 1
        L_0x00c1:
            int r6 = r12.size()
            if (r5 >= r6) goto L_0x00d9
            java.lang.Object r6 = r12.get(r5)
            s1.q r6 = (s1.q) r6
            boolean r9 = r6.d(r13)
            if (r9 == 0) goto L_0x00d6
            r3 = r6
            r12 = 0
            goto L_0x00db
        L_0x00d6:
            int r5 = r5 + 1
            goto L_0x00c1
        L_0x00d9:
            r2 = r4
            r12 = 1
        L_0x00db:
            if (r2 == 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r8 = 3
        L_0x00df:
            if (r2 == 0) goto L_0x00e9
            boolean r13 = r3.e(r13)
            if (r13 == 0) goto L_0x00e9
            r7 = 16
        L_0x00e9:
            boolean r13 = r3.f14039g
            if (r13 == 0) goto L_0x00f0
            r13 = 64
            goto L_0x00f1
        L_0x00f0:
            r13 = 0
        L_0x00f1:
            if (r12 == 0) goto L_0x00f5
            r1 = 128(0x80, float:1.794E-43)
        L_0x00f5:
            r12 = r8 | r7
            r12 = r12 | r0
            r12 = r12 | r13
            r12 = r12 | r1
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.j0.m0(s1.v, g1.a0):int");
    }

    public final void n(long j10, boolean z10) {
        super.n(j10, z10);
        ((e0) this.L0).d();
        this.Q0 = j10;
        this.R0 = true;
        this.S0 = true;
    }

    public final void o() {
        m mVar = this.L0;
        try {
            C();
            e0();
            p1.n nVar = this.H;
            if (nVar != null) {
                nVar.d((p1.q) null);
            }
            this.H = null;
            if (this.T0) {
                this.T0 = false;
                ((e0) mVar).q();
            }
        } catch (Throwable th) {
            if (this.T0) {
                this.T0 = false;
                ((e0) mVar).q();
            }
            throw th;
        }
    }

    public final void p() {
        e0 e0Var = (e0) this.L0;
        e0Var.U = true;
        if (e0Var.m()) {
            o oVar = e0Var.f11888i.f12009f;
            oVar.getClass();
            oVar.a();
            e0Var.f11900u.play();
        }
    }

    public final void q() {
        s0();
        e0 e0Var = (e0) this.L0;
        boolean z10 = false;
        e0Var.U = false;
        if (e0Var.m()) {
            p pVar = e0Var.f11888i;
            pVar.c();
            if (pVar.f12028y == -9223372036854775807L) {
                o oVar = pVar.f12009f;
                oVar.getClass();
                oVar.a();
                z10 = true;
            }
            if (z10) {
                e0Var.f11900u.pause();
            }
        }
    }

    public final int q0(a0 a0Var, q qVar) {
        int i10;
        if (!"OMX.google.raw.decoder".equals(qVar.f14033a) || (i10 = l0.f8453a) >= 24 || (i10 == 23 && l0.F(this.J0))) {
            return a0Var.f6277t;
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e0, code lost:
        if (r7 != false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e3, code lost:
        if (r7 == false) goto L_0x00f2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0357 A[LOOP:1: B:129:0x0343->B:133:0x0357, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0360 A[EDGE_INSN: B:158:0x0360->B:134:0x0360 ?: BREAK  
    EDGE_INSN: B:159:0x0360->B:134:0x0360 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x023e A[Catch:{ Exception -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0277  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s0() {
        /*
            r35 = this;
            r0 = r35
            boolean r1 = r35.j()
            o1.m r2 = r0.L0
            o1.e0 r2 = (o1.e0) r2
            boolean r3 = r2.m()
            if (r3 == 0) goto L_0x03ef
            boolean r3 = r2.H
            if (r3 == 0) goto L_0x0016
            goto L_0x03ef
        L_0x0016:
            o1.p r3 = r2.f11888i
            android.media.AudioTrack r7 = r3.f12006c
            r7.getClass()
            int r7 = r7.getPlayState()
            r12 = 3
            r14 = 1
            r8 = 0
            r17 = 1000(0x3e8, double:4.94E-321)
            r19 = 1000000(0xf4240, double:4.940656E-318)
            o1.a0 r10 = r3.f12004a
            if (r7 != r12) goto L_0x025d
            long r23 = java.lang.System.nanoTime()
            long r4 = r23 / r17
            long r6 = r3.f12016m
            long r6 = r4 - r6
            r23 = 30000(0x7530, double:1.4822E-319)
            int r25 = (r6 > r23 ? 1 : (r6 == r23 ? 0 : -1))
            if (r25 < 0) goto L_0x0083
            long r6 = r3.a()
            long r6 = r6 * r19
            int r11 = r3.f12010g
            long r12 = (long) r11
            long r6 = r6 / r12
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 != 0) goto L_0x004e
            goto L_0x025d
        L_0x004e:
            int r11 = r3.f12026w
            float r12 = r3.f12013j
            long r6 = j1.l0.v(r6, r12)
            long r6 = r6 - r4
            long[] r12 = r3.f12005b
            r12[r11] = r6
            int r6 = r3.f12026w
            int r6 = r6 + r14
            r7 = 10
            int r6 = r6 % r7
            r3.f12026w = r6
            int r6 = r3.f12027x
            if (r6 >= r7) goto L_0x006a
            int r6 = r6 + r14
            r3.f12027x = r6
        L_0x006a:
            r3.f12016m = r4
            r3.f12015l = r8
            r11 = 0
        L_0x006f:
            int r6 = r3.f12027x
            if (r11 >= r6) goto L_0x0083
            long r8 = r3.f12015l
            r26 = r12[r11]
            long r6 = (long) r6
            long r26 = r26 / r6
            long r6 = r26 + r8
            r3.f12015l = r6
            int r11 = r11 + 1
            r8 = 0
            goto L_0x006f
        L_0x0083:
            boolean r6 = r3.f12011h
            if (r6 == 0) goto L_0x0089
            goto L_0x025d
        L_0x0089:
            o1.o r6 = r3.f12009f
            r6.getClass()
            o1.n r11 = r6.f11991a
            if (r11 == 0) goto L_0x011b
            long r12 = r6.f11995e
            long r12 = r4 - r12
            long r7 = r6.f11994d
            int r28 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r28 >= 0) goto L_0x009e
            goto L_0x011b
        L_0x009e:
            r6.f11995e = r4
            android.media.AudioTrack r7 = r11.f11971a
            android.media.AudioTimestamp r8 = r11.f11972b
            boolean r7 = r7.getTimestamp(r8)
            if (r7 == 0) goto L_0x00c8
            long r12 = r8.framePosition
            r28 = r10
            long r9 = r11.f11974d
            int r29 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r29 <= 0) goto L_0x00bc
            long r9 = r11.f11973c
            r29 = 1
            long r9 = r9 + r29
            r11.f11973c = r9
        L_0x00bc:
            r11.f11974d = r12
            long r9 = r11.f11973c
            r29 = 32
            long r9 = r9 << r29
            long r12 = r12 + r9
            r11.f11975e = r12
            goto L_0x00ca
        L_0x00c8:
            r28 = r10
        L_0x00ca:
            int r9 = r6.f11992b
            if (r9 == 0) goto L_0x00f6
            if (r9 == r14) goto L_0x00e6
            r8 = 2
            if (r9 == r8) goto L_0x00e3
            r10 = 3
            if (r9 == r10) goto L_0x00e0
            r8 = 4
            if (r9 != r8) goto L_0x00da
            goto L_0x011e
        L_0x00da:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00e0:
            if (r7 == 0) goto L_0x011e
            goto L_0x00f2
        L_0x00e3:
            if (r7 != 0) goto L_0x011e
            goto L_0x00f2
        L_0x00e6:
            if (r7 == 0) goto L_0x00f2
            long r8 = r11.f11975e
            long r12 = r6.f11996f
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x011e
            r12 = 2
            goto L_0x0117
        L_0x00f2:
            r6.a()
            goto L_0x011e
        L_0x00f6:
            r10 = 3
            if (r7 == 0) goto L_0x010b
            long r8 = r8.nanoTime
            long r8 = r8 / r17
            long r12 = r6.f11993c
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x011d
            long r8 = r11.f11975e
            r6.f11996f = r8
            r6.b(r14)
            goto L_0x011e
        L_0x010b:
            long r8 = r6.f11993c
            long r8 = r4 - r8
            r12 = 500000(0x7a120, double:2.47033E-318)
            int r24 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r24 <= 0) goto L_0x011e
            r12 = 3
        L_0x0117:
            r6.b(r12)
            goto L_0x011e
        L_0x011b:
            r28 = r10
        L_0x011d:
            r7 = 0
        L_0x011e:
            java.lang.String r10 = "DefaultAudioSink"
            if (r7 != 0) goto L_0x012a
            r24 = r1
            r0 = r28
            r28 = r2
            goto L_0x0200
        L_0x012a:
            if (r11 == 0) goto L_0x0133
            android.media.AudioTimestamp r7 = r11.f11972b
            long r12 = r7.nanoTime
            long r12 = r12 / r17
            goto L_0x0138
        L_0x0133:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0138:
            if (r11 == 0) goto L_0x013d
            long r14 = r11.f11975e
            goto L_0x013f
        L_0x013d:
            r14 = -1
        L_0x013f:
            long r31 = r3.a()
            long r31 = r31 * r19
            int r11 = r3.f12010g
            long r7 = (long) r11
            long r7 = r31 / r7
            long r31 = r12 - r4
            long r31 = java.lang.Math.abs(r31)
            java.lang.String r11 = ", "
            r33 = 5000000(0x4c4b40, double:2.470328E-317)
            int r16 = (r31 > r33 ? 1 : (r31 == r33 ? 0 : -1))
            if (r16 <= 0) goto L_0x019d
            r28.getClass()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Spurious audio timestamp (system clock mismatch): "
            r9.<init>(r0)
            r9.append(r14)
            r9.append(r11)
            r9.append(r12)
            r9.append(r11)
            r9.append(r4)
            r9.append(r11)
            r9.append(r7)
            r9.append(r11)
            r0 = r28
            o1.e0 r7 = r0.f11854a
            long r12 = r7.h()
            r9.append(r12)
            r9.append(r11)
            long r7 = r7.i()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            j1.v.g(r10, r7)
            r24 = r1
            r28 = r2
        L_0x019b:
            r1 = 4
            goto L_0x01f4
        L_0x019d:
            r0 = r28
            long r31 = r14 * r19
            int r9 = r3.f12010g
            r24 = r1
            r28 = r2
            long r1 = (long) r9
            long r31 = r31 / r1
            long r31 = r31 - r7
            long r1 = java.lang.Math.abs(r31)
            r31 = 5000000(0x4c4b40, double:2.470328E-317)
            int r9 = (r1 > r31 ? 1 : (r1 == r31 ? 0 : -1))
            if (r9 <= 0) goto L_0x01f8
            r0.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Spurious audio timestamp (frame position mismatch): "
            r1.<init>(r2)
            r1.append(r14)
            r1.append(r11)
            r1.append(r12)
            r1.append(r11)
            r1.append(r4)
            r1.append(r11)
            r1.append(r7)
            r1.append(r11)
            o1.e0 r2 = r0.f11854a
            long r7 = r2.h()
            r1.append(r7)
            r1.append(r11)
            long r7 = r2.i()
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            j1.v.g(r10, r1)
            goto L_0x019b
        L_0x01f4:
            r6.b(r1)
            goto L_0x0200
        L_0x01f8:
            r1 = 4
            int r2 = r6.f11992b
            if (r2 != r1) goto L_0x0200
            r6.a()
        L_0x0200:
            boolean r1 = r3.f12020q
            if (r1 == 0) goto L_0x0262
            java.lang.reflect.Method r1 = r3.f12017n
            if (r1 == 0) goto L_0x0262
            long r6 = r3.f12021r
            long r6 = r4 - r6
            r8 = 500000(0x7a120, double:2.47033E-318)
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x0262
            android.media.AudioTrack r2 = r3.f12006c     // Catch:{ Exception -> 0x0257 }
            r2.getClass()     // Catch:{ Exception -> 0x0257 }
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0257 }
            java.lang.Object r1 = r1.invoke(r2, r7)     // Catch:{ Exception -> 0x0257 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0257 }
            int r2 = j1.l0.f8453a     // Catch:{ Exception -> 0x0257 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0257 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x0257 }
            long r1 = r1 * r17
            long r6 = r3.f12012i     // Catch:{ Exception -> 0x0257 }
            long r1 = r1 - r6
            r3.f12018o = r1     // Catch:{ Exception -> 0x0257 }
            r6 = 0
            long r1 = java.lang.Math.max(r1, r6)     // Catch:{ Exception -> 0x0257 }
            r3.f12018o = r1     // Catch:{ Exception -> 0x0257 }
            r6 = 5000000(0x4c4b40, double:2.470328E-317)
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x025a
            r0.getClass()     // Catch:{ Exception -> 0x0257 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0257 }
            java.lang.String r7 = "Ignoring impossibly large audio latency: "
            r6.<init>(r7)     // Catch:{ Exception -> 0x0257 }
            r6.append(r1)     // Catch:{ Exception -> 0x0257 }
            java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x0257 }
            j1.v.g(r10, r1)     // Catch:{ Exception -> 0x0257 }
            r1 = 0
            r3.f12018o = r1     // Catch:{ Exception -> 0x0257 }
            goto L_0x025a
        L_0x0257:
            r1 = 0
            r3.f12017n = r1
        L_0x025a:
            r3.f12021r = r4
            goto L_0x0262
        L_0x025d:
            r24 = r1
            r28 = r2
            r0 = r10
        L_0x0262:
            long r1 = java.lang.System.nanoTime()
            long r1 = r1 / r17
            o1.o r4 = r3.f12009f
            r4.getClass()
            int r5 = r4.f11992b
            r6 = 2
            if (r5 != r6) goto L_0x0274
            r5 = 1
            goto L_0x0275
        L_0x0274:
            r5 = 0
        L_0x0275:
            if (r5 == 0) goto L_0x02a2
            o1.n r4 = r4.f11991a
            if (r4 == 0) goto L_0x0280
            long r6 = r4.f11975e
            r21 = r6
            goto L_0x0282
        L_0x0280:
            r21 = -1
        L_0x0282:
            long r21 = r21 * r19
            int r6 = r3.f12010g
            long r6 = (long) r6
            long r21 = r21 / r6
            if (r4 == 0) goto L_0x0292
            android.media.AudioTimestamp r4 = r4.f11972b
            long r6 = r4.nanoTime
            long r8 = r6 / r17
            goto L_0x0297
        L_0x0292:
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0297:
            long r6 = r1 - r8
            float r4 = r3.f12013j
            long r6 = j1.l0.s(r6, r4)
            long r6 = r6 + r21
            goto L_0x02c5
        L_0x02a2:
            int r4 = r3.f12027x
            if (r4 != 0) goto L_0x02b1
            long r6 = r3.a()
            long r6 = r6 * r19
            int r4 = r3.f12010g
            long r8 = (long) r4
            long r6 = r6 / r8
            goto L_0x02ba
        L_0x02b1:
            long r6 = r3.f12015l
            long r6 = r6 + r1
            float r4 = r3.f12013j
            long r6 = j1.l0.s(r6, r4)
        L_0x02ba:
            if (r24 != 0) goto L_0x02c5
            long r8 = r3.f12018o
            long r6 = r6 - r8
            r8 = 0
            long r6 = java.lang.Math.max(r8, r6)
        L_0x02c5:
            boolean r4 = r3.E
            if (r4 == r5) goto L_0x02d1
            long r8 = r3.D
            r3.G = r8
            long r8 = r3.C
            r3.F = r8
        L_0x02d1:
            long r8 = r3.G
            long r8 = r1 - r8
            int r4 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r4 >= 0) goto L_0x02ef
            long r12 = r3.F
            float r4 = r3.f12013j
            long r14 = j1.l0.s(r8, r4)
            long r14 = r14 + r12
            long r8 = r8 * r17
            long r8 = r8 / r19
            long r6 = r6 * r8
            long r8 = r17 - r8
            long r8 = r8 * r14
            long r8 = r8 + r6
            long r6 = r8 / r17
        L_0x02ef:
            boolean r4 = r3.f12014k
            if (r4 != 0) goto L_0x032b
            long r8 = r3.C
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x032b
            r4 = 1
            r3.f12014k = r4
            long r8 = r6 - r8
            long r8 = j1.l0.Q(r8)
            float r4 = r3.f12013j
            long r8 = j1.l0.v(r8, r4)
            long r12 = java.lang.System.currentTimeMillis()
            long r8 = j1.l0.Q(r8)
            long r12 = r12 - r8
            o1.e0 r0 = r0.f11854a
            e.a r0 = r0.f11897r
            if (r0 == 0) goto L_0x032b
            java.lang.Object r0 = r0.f4852i
            o1.j0 r0 = (o1.j0) r0
            android.support.v4.media.n r0 = r0.K0
            java.lang.Object r4 = r0.f337i
            android.os.Handler r4 = (android.os.Handler) r4
            if (r4 == 0) goto L_0x032b
            o1.e r8 = new o1.e
            r8.<init>(r0, r12)
            r4.post(r8)
        L_0x032b:
            r3.D = r1
            r3.C = r6
            r3.E = r5
            r2 = r28
            o1.x r0 = r2.f11899t
            long r3 = r2.i()
            long r3 = r3 * r19
            int r0 = r0.f12051e
            long r0 = (long) r0
            long r3 = r3 / r0
            long r0 = java.lang.Math.min(r6, r3)
        L_0x0343:
            java.util.ArrayDeque r3 = r2.f11889j
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0360
            java.lang.Object r4 = r3.getFirst()
            o1.y r4 = (o1.y) r4
            long r4 = r4.f12059d
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0360
            java.lang.Object r3 = r3.remove()
            o1.y r3 = (o1.y) r3
            r2.f11903x = r3
            goto L_0x0343
        L_0x0360:
            o1.y r4 = r2.f11903x
            long r5 = r4.f12059d
            long r12 = r0 - r5
            g1.e1 r4 = r4.f12056a
            g1.e1 r5 = g1.e1.f6351k
            boolean r4 = r4.equals(r5)
            android.support.v4.media.session.u r5 = r2.f11879b
            if (r4 == 0) goto L_0x0378
            o1.y r0 = r2.f11903x
            long r0 = r0.f12058c
            long r0 = r0 + r12
            goto L_0x03dd
        L_0x0378:
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x03c6
            java.lang.Object r0 = r5.f430k
            o1.n0 r0 = (o1.n0) r0
            long r3 = r0.f11989o
            r6 = 1024(0x400, double:5.06E-321)
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x03b9
            long r3 = r0.f11988n
            o1.m0 r1 = r0.f11984j
            r1.getClass()
            int r6 = r1.f11959k
            int r1 = r1.f11950b
            int r6 = r6 * r1
            r1 = 2
            int r6 = r6 * 2
            long r6 = (long) r6
            long r3 = r3 - r6
            h1.a r1 = r0.f11982h
            int r1 = r1.f6878a
            h1.a r6 = r0.f11981g
            int r6 = r6.f6878a
            if (r1 != r6) goto L_0x03a9
            long r0 = r0.f11989o
            goto L_0x03b1
        L_0x03a9:
            long r7 = (long) r1
            long r3 = r3 * r7
            long r0 = r0.f11989o
            long r6 = (long) r6
            long r0 = r0 * r6
        L_0x03b1:
            r16 = r0
            r14 = r3
            long r0 = j1.l0.M(r12, r14, r16)
            goto L_0x03c0
        L_0x03b9:
            float r0 = r0.f11977c
            double r0 = (double) r0
            double r3 = (double) r12
            double r0 = r0 * r3
            long r0 = (long) r0
        L_0x03c0:
            o1.y r3 = r2.f11903x
            long r3 = r3.f12058c
            long r0 = r0 + r3
            goto L_0x03dd
        L_0x03c6:
            java.lang.Object r3 = r3.getFirst()
            o1.y r3 = (o1.y) r3
            long r6 = r3.f12059d
            long r6 = r6 - r0
            o1.y r0 = r2.f11903x
            g1.e1 r0 = r0.f12056a
            float r0 = r0.f6355h
            long r0 = j1.l0.s(r6, r0)
            long r3 = r3.f12058c
            long r0 = r3 - r0
        L_0x03dd:
            o1.x r2 = r2.f11899t
            java.lang.Object r3 = r5.f429j
            o1.l0 r3 = (o1.l0) r3
            long r3 = r3.f11948t
            long r3 = r3 * r19
            int r2 = r2.f12051e
            long r5 = (long) r2
            long r3 = r3 / r5
            long r3 = r3 + r0
            r0 = -9223372036854775808
            goto L_0x03f3
        L_0x03ef:
            r0 = -9223372036854775808
            r3 = -9223372036854775808
        L_0x03f3:
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            r0 = r35
            if (r2 == 0) goto L_0x0409
            boolean r1 = r0.S0
            if (r1 == 0) goto L_0x03fe
            goto L_0x0404
        L_0x03fe:
            long r1 = r0.Q0
            long r3 = java.lang.Math.max(r1, r3)
        L_0x0404:
            r0.Q0 = r3
            r1 = 0
            r0.S0 = r1
        L_0x0409:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.j0.s0():void");
    }
}

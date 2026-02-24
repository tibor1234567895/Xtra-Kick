package c2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import androidx.activity.result.j;
import b2.m;
import j1.g0;
import j1.l;
import j1.l0;
import j1.v;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class k implements m, a {

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f2755h = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f2756i = new AtomicBoolean(true);

    /* renamed from: j  reason: collision with root package name */
    public final i f2757j = new i();

    /* renamed from: k  reason: collision with root package name */
    public final c f2758k = new c();

    /* renamed from: l  reason: collision with root package name */
    public final g0 f2759l = new g0();

    /* renamed from: m  reason: collision with root package name */
    public final g0 f2760m = new g0();

    /* renamed from: n  reason: collision with root package name */
    public final float[] f2761n = new float[16];

    /* renamed from: o  reason: collision with root package name */
    public final float[] f2762o = new float[16];

    /* renamed from: p  reason: collision with root package name */
    public int f2763p;

    /* renamed from: q  reason: collision with root package name */
    public SurfaceTexture f2764q;

    /* renamed from: r  reason: collision with root package name */
    public volatile int f2765r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f2766s = -1;

    /* renamed from: t  reason: collision with root package name */
    public byte[] f2767t;

    public final void a(long j10, float[] fArr) {
        this.f2758k.f2729c.a(j10, fArr);
    }

    /* JADX INFO: finally extract failed */
    public final void b(float[] fArr) {
        float[] fArr2;
        Object d10;
        GLES20.glClear(16384);
        try {
            j1.m.b();
        } catch (l e10) {
            v.d("SceneRenderer", "Failed to draw a frame", e10);
        }
        if (this.f2755h.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = this.f2764q;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            try {
                j1.m.b();
            } catch (l e11) {
                v.d("SceneRenderer", "Failed to draw a frame", e11);
            }
            if (this.f2756i.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f2761n, 0);
            }
            long timestamp = this.f2764q.getTimestamp();
            g0 g0Var = this.f2759l;
            synchronized (g0Var) {
                try {
                    d10 = g0Var.d(timestamp, false);
                } catch (Throwable th) {
                    throw th;
                }
            }
            Long l10 = (Long) d10;
            if (l10 != null) {
                c cVar = this.f2758k;
                float[] fArr3 = this.f2761n;
                float[] fArr4 = (float[]) cVar.f2729c.e(l10.longValue());
                if (fArr4 != null) {
                    float[] fArr5 = cVar.f2728b;
                    float f10 = fArr4[0];
                    float f11 = -fArr4[1];
                    float f12 = -fArr4[2];
                    float length = Matrix.length(f10, f11, f12);
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr5, 0, (float) Math.toDegrees((double) length), f10 / length, f11 / length, f12 / length);
                    } else {
                        Matrix.setIdentityM(fArr5, 0);
                    }
                    if (!cVar.f2730d) {
                        c.a(cVar.f2727a, cVar.f2728b);
                        cVar.f2730d = true;
                    }
                    Matrix.multiplyMM(fArr3, 0, cVar.f2727a, 0, cVar.f2728b, 0);
                }
            }
            g gVar = (g) this.f2760m.e(timestamp);
            if (gVar != null) {
                i iVar = this.f2757j;
                iVar.getClass();
                if (i.b(gVar)) {
                    iVar.f2746a = gVar.f2741c;
                    iVar.f2747b = new j(gVar.f2739a.f2738a[0]);
                    if (!gVar.f2742d) {
                        new j(gVar.f2740b.f2738a[0]);
                    }
                    iVar.getClass();
                }
            }
        }
        Matrix.multiplyMM(this.f2762o, 0, fArr, 0, this.f2761n, 0);
        i iVar2 = this.f2757j;
        int i10 = this.f2763p;
        float[] fArr6 = this.f2762o;
        j jVar = iVar2.f2747b;
        if (jVar != null) {
            int i11 = iVar2.f2746a;
            if (i11 == 1) {
                fArr2 = i.f2744j;
            } else if (i11 == 2) {
                fArr2 = i.f2745k;
            } else {
                fArr2 = i.f2743i;
            }
            GLES20.glUniformMatrix3fv(iVar2.f2750e, 1, false, fArr2, 0);
            GLES20.glUniformMatrix4fv(iVar2.f2749d, 1, false, fArr6, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i10);
            GLES20.glUniform1i(iVar2.f2753h, 0);
            try {
                j1.m.b();
            } catch (l e12) {
                Log.e("ProjectionRenderer", "Failed to bind uniforms", e12);
            }
            GLES20.glVertexAttribPointer(iVar2.f2751f, 3, 5126, false, 12, (FloatBuffer) jVar.f519j);
            try {
                j1.m.b();
            } catch (l e13) {
                Log.e("ProjectionRenderer", "Failed to load position data", e13);
            }
            GLES20.glVertexAttribPointer(iVar2.f2752g, 2, 5126, false, 8, (FloatBuffer) jVar.f520k);
            try {
                j1.m.b();
            } catch (l e14) {
                Log.e("ProjectionRenderer", "Failed to load texture data", e14);
            }
            GLES20.glDrawArrays(jVar.f518i, 0, jVar.f517h);
            try {
                j1.m.b();
            } catch (l e15) {
                Log.e("ProjectionRenderer", "Failed to render", e15);
            }
        }
    }

    public final void c() {
        this.f2759l.b();
        c cVar = this.f2758k;
        cVar.f2729c.b();
        cVar.f2730d = false;
        this.f2756i.set(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(long r33, long r35, g1.a0 r37, android.media.MediaFormat r38) {
        /*
            r32 = this;
            r0 = r32
            r1 = r35
            r3 = r37
            j1.g0 r4 = r0.f2759l
            java.lang.Long r5 = java.lang.Long.valueOf(r33)
            r4.a(r1, r5)
            byte[] r4 = r3.C
            int r3 = r3.D
            byte[] r5 = r0.f2767t
            int r6 = r0.f2766s
            r0.f2767t = r4
            r4 = -1
            if (r3 != r4) goto L_0x001e
            int r3 = r0.f2765r
        L_0x001e:
            r0.f2766s = r3
            if (r6 != r3) goto L_0x002c
            byte[] r3 = r0.f2767t
            boolean r3 = java.util.Arrays.equals(r5, r3)
            if (r3 == 0) goto L_0x002c
            goto L_0x01ef
        L_0x002c:
            byte[] r3 = r0.f2767t
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x00b1
            int r8 = r0.f2766s
            j1.b0 r9 = new j1.b0
            r9.<init>((byte[]) r3)
            r3 = 4
            r9.H(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            int r3 = r9.f()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            r9.G(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            r10 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r3 != r10) goto L_0x004d
            r3 = 1
            goto L_0x004e
        L_0x004d:
            r3 = 0
        L_0x004e:
            if (r3 == 0) goto L_0x0081
            r3 = 8
            r9.H(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            int r3 = r9.f8415b     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            int r10 = r9.f8416c     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
        L_0x0059:
            if (r3 >= r10) goto L_0x0087
            int r11 = r9.f()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            int r11 = r11 + r3
            if (r11 <= r3) goto L_0x0087
            if (r11 <= r10) goto L_0x0065
            goto L_0x0087
        L_0x0065:
            int r3 = r9.f()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            r12 = 2037673328(0x79746d70, float:7.9321256E34)
            if (r3 == r12) goto L_0x0079
            r12 = 1836279920(0x6d736870, float:4.7081947E27)
            if (r3 != r12) goto L_0x0074
            goto L_0x0079
        L_0x0074:
            r9.G(r11)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            r3 = r11
            goto L_0x0059
        L_0x0079:
            r9.F(r11)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            java.util.ArrayList r3 = c2.h.a(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            goto L_0x0088
        L_0x0081:
            java.util.ArrayList r3 = c2.h.a(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0086 }
            goto L_0x0088
        L_0x0086:
        L_0x0087:
            r3 = r7
        L_0x0088:
            if (r3 != 0) goto L_0x008b
            goto L_0x00b1
        L_0x008b:
            int r9 = r3.size()
            if (r9 == r6) goto L_0x00a6
            if (r9 == r4) goto L_0x0094
            goto L_0x00b1
        L_0x0094:
            c2.g r7 = new c2.g
            java.lang.Object r9 = r3.get(r5)
            c2.f r9 = (c2.f) r9
            java.lang.Object r3 = r3.get(r6)
            c2.f r3 = (c2.f) r3
            r7.<init>(r9, r3, r8)
            goto L_0x00b1
        L_0x00a6:
            c2.g r7 = new c2.g
            java.lang.Object r3 = r3.get(r5)
            c2.f r3 = (c2.f) r3
            r7.<init>(r3, r3, r8)
        L_0x00b1:
            if (r7 == 0) goto L_0x00bb
            boolean r3 = c2.i.b(r7)
            if (r3 == 0) goto L_0x00bb
            goto L_0x01e8
        L_0x00bb:
            int r3 = r0.f2766s
            r7 = 1127481344(0x43340000, float:180.0)
            double r7 = (double) r7
            double r7 = java.lang.Math.toRadians(r7)
            float r7 = (float) r7
            r8 = 1135869952(0x43b40000, float:360.0)
            double r8 = (double) r8
            double r8 = java.lang.Math.toRadians(r8)
            float r8 = (float) r8
            r9 = 36
            float r10 = (float) r9
            float r10 = r7 / r10
            r11 = 72
            float r12 = (float) r11
            float r12 = r8 / r12
            r13 = 15984(0x3e70, float:2.2398E-41)
            float[] r13 = new float[r13]
            r14 = 10656(0x29a0, float:1.4932E-41)
            float[] r14 = new float[r14]
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x00e4:
            if (r15 >= r9) goto L_0x01cf
            float r9 = (float) r15
            float r9 = r9 * r10
            r18 = 1073741824(0x40000000, float:2.0)
            float r19 = r7 / r18
            float r9 = r9 - r19
            int r5 = r15 + 1
            float r6 = (float) r5
            float r6 = r6 * r10
            float r6 = r6 - r19
            r11 = 0
        L_0x00f7:
            r4 = 73
            if (r11 >= r4) goto L_0x01be
            r20 = r5
            r4 = 0
            r5 = 2
        L_0x00ff:
            if (r4 >= r5) goto L_0x01a4
            if (r4 != 0) goto L_0x0107
            r21 = r6
            r5 = r9
            goto L_0x010a
        L_0x0107:
            r5 = r6
            r21 = r5
        L_0x010a:
            float r6 = (float) r11
            float r6 = r6 * r12
            r22 = 1078530011(0x40490fdb, float:3.1415927)
            float r22 = r6 + r22
            float r23 = r8 / r18
            r24 = r9
            float r9 = r22 - r23
            int r22 = r16 + 1
            r23 = r12
            r12 = 1112014848(0x42480000, float:50.0)
            double r1 = (double) r12
            r25 = r11
            double r11 = (double) r9
            double r26 = java.lang.Math.sin(r11)
            double r26 = r26 * r1
            r28 = r10
            double r9 = (double) r5
            double r29 = java.lang.Math.cos(r9)
            r5 = r3
            r31 = r4
            double r3 = r29 * r26
            float r3 = (float) r3
            float r3 = -r3
            r13[r16] = r3
            int r3 = r22 + 1
            double r26 = java.lang.Math.sin(r9)
            r29 = r5
            double r4 = r26 * r1
            float r4 = (float) r4
            r13[r22] = r4
            int r4 = r3 + 1
            double r11 = java.lang.Math.cos(r11)
            double r11 = r11 * r1
            double r1 = java.lang.Math.cos(r9)
            double r1 = r1 * r11
            float r1 = (float) r1
            r13[r3] = r1
            int r1 = r17 + 1
            float r6 = r6 / r8
            r14[r17] = r6
            int r2 = r1 + 1
            int r3 = r15 + r31
            float r3 = (float) r3
            float r3 = r3 * r28
            float r3 = r3 / r7
            r14[r1] = r3
            if (r25 != 0) goto L_0x0171
            if (r31 == 0) goto L_0x016a
            goto L_0x0171
        L_0x016a:
            r1 = r25
            r5 = r31
            r3 = 72
            goto L_0x017c
        L_0x0171:
            r1 = r25
            r3 = 72
            r5 = r31
            if (r1 != r3) goto L_0x018d
            r6 = 1
            if (r5 != r6) goto L_0x018d
        L_0x017c:
            int r6 = r4 + -3
            r9 = 3
            java.lang.System.arraycopy(r13, r6, r13, r4, r9)
            int r4 = r4 + 3
            int r6 = r2 + -2
            r9 = 2
            java.lang.System.arraycopy(r14, r6, r14, r2, r9)
            int r2 = r2 + 2
            goto L_0x018e
        L_0x018d:
            r9 = 2
        L_0x018e:
            r17 = r2
            r16 = r4
            int r4 = r5 + 1
            r11 = r1
            r6 = r21
            r12 = r23
            r9 = r24
            r10 = r28
            r3 = r29
            r5 = 2
            r1 = r35
            goto L_0x00ff
        L_0x01a4:
            r29 = r3
            r21 = r6
            r24 = r9
            r28 = r10
            r1 = r11
            r23 = r12
            r3 = 72
            r9 = 2
            int r11 = r1 + 1
            r1 = r35
            r5 = r20
            r9 = r24
            r3 = r29
            goto L_0x00f7
        L_0x01be:
            r29 = r3
            r20 = r5
            r1 = r35
            r15 = r20
            r4 = 2
            r5 = 0
            r6 = 1
            r9 = 36
            r11 = 72
            goto L_0x00e4
        L_0x01cf:
            r29 = r3
            androidx.activity.result.j r1 = new androidx.activity.result.j
            r2 = 0
            r3 = 1
            r1.<init>((int) r2, (float[]) r13, (float[]) r14, (int) r3)
            c2.g r7 = new c2.g
            c2.f r4 = new c2.f
            androidx.activity.result.j[] r3 = new androidx.activity.result.j[r3]
            r3[r2] = r1
            r4.<init>(r3)
            r1 = r29
            r7.<init>(r4, r4, r1)
        L_0x01e8:
            j1.g0 r1 = r0.f2760m
            r2 = r35
            r1.a(r2, r7)
        L_0x01ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.k.d(long, long, g1.a0, android.media.MediaFormat):void");
    }

    public final SurfaceTexture e() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            j1.m.b();
            this.f2757j.a();
            j1.m.b();
            j1.m.c("No current context", !l0.a(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT));
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            j1.m.b();
            int i10 = iArr[0];
            j1.m.a(36197, i10);
            this.f2763p = i10;
        } catch (l e10) {
            v.d("SceneRenderer", "Failed to initialize the renderer", e10);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f2763p);
        this.f2764q = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new j(this));
        return this.f2764q;
    }
}

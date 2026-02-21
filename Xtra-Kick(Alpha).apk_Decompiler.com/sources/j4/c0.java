package j4;

import android.graphics.ImageDecoder;
import android.os.Build;
import dc.f0;
import java.nio.ByteBuffer;
import s4.m;
import xa.j;

public final class c0 implements k {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f8736a;

    /* renamed from: b  reason: collision with root package name */
    public final m f8737b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f8738c;

    public c0(e0 e0Var, m mVar, boolean z10) {
        this.f8736a = e0Var;
        this.f8737b = mVar;
        this.f8738c = z10;
    }

    public static final ImageDecoder.Source b(c0 c0Var, e0 e0Var) {
        c0Var.getClass();
        f0 e10 = e0Var.e();
        if (e10 != null) {
            return ImageDecoder.createSource(e10.d());
        }
        d0 k10 = e0Var.k();
        boolean z10 = k10 instanceof a;
        m mVar = c0Var.f8737b;
        if (z10) {
            return ImageDecoder.createSource(mVar.f14276a.getAssets(), ((a) k10).f8728a);
        }
        if (k10 instanceof g) {
            return ImageDecoder.createSource(mVar.f14276a.getContentResolver(), ((g) k10).f8752a);
        }
        if (k10 instanceof g0) {
            g0 g0Var = (g0) k10;
            if (j.a(g0Var.f8753a, mVar.f14276a.getPackageName())) {
                return ImageDecoder.createSource(mVar.f14276a.getResources(), g0Var.f8754b);
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            return ImageDecoder.createSource(e0Var.v().M());
        }
        if (i10 == 30) {
            return ImageDecoder.createSource(ByteBuffer.wrap(e0Var.v().M()));
        }
        return ImageDecoder.createSource(e0Var.c().d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(pa.e r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof j4.y
            if (r0 == 0) goto L_0x0013
            r0 = r8
            j4.y r0 = (j4.y) r0
            int r1 = r0.f8800l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8800l = r1
            goto L_0x0018
        L_0x0013:
            j4.y r0 = new j4.y
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f8798j
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f8800l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.f8796h
            xa.q r0 = (xa.q) r0
            hb.h0.O1(r8)
            goto L_0x006f
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0036:
            xa.q r2 = r0.f8797i
            java.lang.Object r4 = r0.f8796h
            j4.c0 r4 = (j4.c0) r4
            hb.h0.O1(r8)
            goto L_0x005e
        L_0x0040:
            hb.h0.O1(r8)
            xa.q r8 = new xa.q
            r8.<init>()
            l3.j r2 = new l3.j
            r2.<init>(r7, r4, r8)
            r0.f8796h = r7
            r0.f8797i = r8
            r0.f8800l = r4
            java.lang.Object r2 = hb.h0.x1(r2, r0)
            if (r2 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r4 = r7
            r6 = r2
            r2 = r8
            r8 = r6
        L_0x005e:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            r0.f8796h = r2
            r5 = 0
            r0.f8797i = r5
            r0.f8800l = r3
            android.graphics.drawable.Drawable r8 = r4.c(r8, r0)
            if (r8 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r0 = r2
        L_0x006f:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            boolean r0 = r0.f16814h
            j4.h r1 = new j4.h
            r1.<init>(r8, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.c0.a(pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable c(android.graphics.drawable.Drawable r5, pa.e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof j4.b0
            if (r0 == 0) goto L_0x0013
            r0 = r6
            j4.b0 r0 = (j4.b0) r0
            int r1 = r0.f8734j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8734j = r1
            goto L_0x0018
        L_0x0013:
            j4.b0 r0 = new j4.b0
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f8732h
            int r0 = r0.f8734j
            if (r0 == 0) goto L_0x002f
            r5 = 1
            if (r0 != r5) goto L_0x0027
            hb.h0.O1(r6)
            r5 = 0
            r6 = r5
            goto L_0x0069
        L_0x0027:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002f:
            hb.h0.O1(r6)
            boolean r6 = android.support.v4.media.session.d0.A(r5)
            if (r6 != 0) goto L_0x0039
            return r5
        L_0x0039:
            android.graphics.drawable.AnimatedImageDrawable r6 = android.support.v4.media.session.d0.l(r5)
            s4.m r0 = r4.f8737b
            s4.p r1 = r0.f14287l
            java.util.Map r1 = r1.f14293h
            java.lang.String r2 = "coil#repeat_count"
            java.lang.Object r1 = r1.get(r2)
            android.support.v4.media.h.y(r1)
            r6.setRepeatCount(-1)
            s4.p r6 = r0.f14287l
            java.util.Map r0 = r6.f14293h
            java.lang.String r1 = "coil#animation_start_callback"
            java.lang.Object r0 = r0.get(r1)
            android.support.v4.media.h.y(r0)
            java.util.Map r6 = r6.f14293h
            java.lang.String r0 = "coil#animation_end_callback"
            java.lang.Object r6 = r6.get(r0)
            android.support.v4.media.h.y(r6)
            r6 = r5
            r5 = r4
        L_0x0069:
            l4.c r0 = new l4.c
            s4.m r5 = r5.f8737b
            int r5 = r5.f14280e
            r0.<init>(r6, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.c0.c(android.graphics.drawable.Drawable, pa.e):android.graphics.drawable.Drawable");
    }
}

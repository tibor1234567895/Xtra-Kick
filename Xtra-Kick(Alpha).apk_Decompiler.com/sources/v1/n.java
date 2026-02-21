package v1;

import a2.i;
import android.content.Context;
import androidx.appcompat.widget.i5;
import c9.w;
import d2.r;
import d9.r0;
import g1.f0;
import g1.i0;
import g1.m0;
import g1.n0;
import g1.q0;
import g1.s0;
import j1.a;
import j1.l0;
import java.util.Map;
import k1.g;
import k1.p;
import p1.l;

public final class n implements z {

    /* renamed from: a  reason: collision with root package name */
    public final i5 f15723a;

    /* renamed from: b  reason: collision with root package name */
    public final g f15724b;

    /* renamed from: c  reason: collision with root package name */
    public i f15725c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15726d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15727e;

    /* renamed from: f  reason: collision with root package name */
    public final long f15728f;

    /* renamed from: g  reason: collision with root package name */
    public final float f15729g;

    /* renamed from: h  reason: collision with root package name */
    public final float f15730h;

    public n(Context context, r rVar) {
        k1.n nVar = new k1.n(context, new p());
        this.f15724b = nVar;
        i5 i5Var = new i5(rVar);
        this.f15723a = i5Var;
        if (nVar != ((g) i5Var.f878f)) {
            i5Var.f878f = nVar;
            ((Map) i5Var.f875c).clear();
            ((Map) i5Var.f877e).clear();
        }
        this.f15726d = -9223372036854775807L;
        this.f15727e = -9223372036854775807L;
        this.f15728f = -9223372036854775807L;
        this.f15729g = -3.4028235E38f;
        this.f15730h = -3.4028235E38f;
    }

    public static z d(Class cls, g gVar) {
        try {
            return (z) cls.getConstructor(new Class[]{g.class}).newInstance(new Object[]{gVar});
        } catch (Exception e10) {
            throw new IllegalStateException(e10);
        }
    }

    public final a a(s0 s0Var) {
        long j10;
        float f10;
        float f11;
        long j11;
        long j12;
        i iVar;
        s0 s0Var2 = s0Var;
        s0Var2.f6557i.getClass();
        n0 n0Var = s0Var2.f6557i;
        String scheme = n0Var.f6478a.getScheme();
        z zVar = null;
        if (scheme == null || !scheme.equals("ssai")) {
            int A = l0.A(n0Var.f6478a, n0Var.f6479b);
            i5 i5Var = this.f15723a;
            Map map = (Map) i5Var.f877e;
            z zVar2 = (z) map.get(Integer.valueOf(A));
            if (zVar2 != null) {
                zVar = zVar2;
            } else {
                w d10 = i5Var.d(A);
                if (d10 != null) {
                    zVar = (z) d10.get();
                    l lVar = (l) i5Var.f879g;
                    if (lVar != null) {
                        zVar.c(lVar);
                    }
                    i iVar2 = (i) i5Var.f880h;
                    if (iVar2 != null) {
                        zVar.b(iVar2);
                    }
                    map.put(Integer.valueOf(A), zVar);
                }
            }
            a.g(zVar, "No suitable media source factory found for content type: " + A);
            m0 m0Var = s0Var2.f6558j;
            m0Var.getClass();
            if (m0Var.f6463h == -9223372036854775807L) {
                j10 = this.f15726d;
            } else {
                j10 = m0Var.f6463h;
            }
            long j13 = j10;
            if (m0Var.f6466k == -3.4028235E38f) {
                f10 = this.f15729g;
            } else {
                f10 = m0Var.f6466k;
            }
            float f12 = f10;
            if (m0Var.f6467l == -3.4028235E38f) {
                f11 = this.f15730h;
            } else {
                f11 = m0Var.f6467l;
            }
            float f13 = f11;
            if (m0Var.f6464i == -9223372036854775807L) {
                j11 = this.f15727e;
            } else {
                j11 = m0Var.f6464i;
            }
            long j14 = j11;
            if (m0Var.f6465j == -9223372036854775807L) {
                j12 = this.f15728f;
            } else {
                j12 = m0Var.f6465j;
            }
            m0 m0Var2 = new m0(j13, j14, j12, f12, f13);
            if (!m0Var2.equals(m0Var)) {
                f0 f0Var = new f0(s0Var2);
                f0Var.f6368k = new g1.l0(m0Var2);
                s0Var2 = f0Var.a();
            }
            a a10 = zVar.a(s0Var2);
            r0 r0Var = s0Var2.f6557i.f6483f;
            if (!r0Var.isEmpty()) {
                a[] aVarArr = new a[(r0Var.size() + 1)];
                int i10 = 0;
                aVarArr[0] = a10;
                while (i10 < r0Var.size()) {
                    g gVar = this.f15724b;
                    gVar.getClass();
                    i iVar3 = new i();
                    i iVar4 = this.f15725c;
                    if (iVar4 != null) {
                        iVar = iVar4;
                    } else {
                        iVar = iVar3;
                    }
                    int i11 = i10 + 1;
                    aVarArr[i11] = new j1((String) null, (q0) r0Var.get(i10), gVar, iVar, true, (Object) null);
                    i10 = i11;
                }
                a10 = new l0(aVarArr);
            }
            g gVar2 = a10;
            i0 i0Var = s0Var2.f6560l;
            long j15 = i0Var.f6406h;
            long j16 = i0Var.f6407i;
            if (!(j15 == 0 && j16 == Long.MIN_VALUE && !i0Var.f6409k)) {
                gVar2 = new g(gVar2, l0.H(j15), l0.H(j16), !i0Var.f6410l, i0Var.f6408j, i0Var.f6409k);
            }
            s0Var2.f6557i.getClass();
            return gVar2;
        }
        throw null;
    }

    public final z b(i iVar) {
        if (iVar != null) {
            this.f15725c = iVar;
            i5 i5Var = this.f15723a;
            i5Var.f880h = iVar;
            for (z b10 : ((Map) i5Var.f877e).values()) {
                b10.b(iVar);
            }
            return this;
        }
        throw new NullPointerException("MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
    }

    public final z c(l lVar) {
        if (lVar != null) {
            i5 i5Var = this.f15723a;
            i5Var.f879g = lVar;
            for (z c10 : ((Map) i5Var.f877e).values()) {
                c10.c(lVar);
            }
            return this;
        }
        throw new NullPointerException("MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
    }
}

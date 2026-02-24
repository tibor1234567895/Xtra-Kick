package h3;

import android.net.Uri;
import c9.w;
import g1.v0;
import h9.e0;
import h9.f0;
import h9.o;
import j1.a;

public final class p4 implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final w f7287b;

    /* renamed from: a  reason: collision with root package name */
    public final f0 f7288a;

    /* JADX WARNING: type inference failed for: r1v5, types: [c9.y] */
    /* JADX WARNING: type inference failed for: r1v6, types: [c9.x] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            m1.s r0 = new m1.s
            r1 = 2
            r0.<init>(r1)
            boolean r1 = r0 instanceof c9.y
            if (r1 != 0) goto L_0x001f
            boolean r1 = r0 instanceof c9.x
            if (r1 == 0) goto L_0x000f
            goto L_0x001f
        L_0x000f:
            boolean r1 = r0 instanceof java.io.Serializable
            if (r1 == 0) goto L_0x0019
            c9.x r1 = new c9.x
            r1.<init>(r0)
            goto L_0x001e
        L_0x0019:
            c9.y r1 = new c9.y
            r1.<init>(r0)
        L_0x001e:
            r0 = r1
        L_0x001f:
            f7287b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.p4.<clinit>():void");
    }

    public p4() {
        f0 f0Var = (f0) f7287b.get();
        a.f(f0Var);
        this.f7288a = f0Var;
    }

    public final e0 a(v0 v0Var) {
        byte[] bArr = v0Var.f6660q;
        if (bArr != null) {
            return b(bArr);
        }
        Uri uri = v0Var.f6662s;
        if (uri != null) {
            return c(uri);
        }
        return null;
    }

    public final e0 b(byte[] bArr) {
        return ((o) this.f7288a).submit(new o4(0, bArr));
    }

    public final e0 c(Uri uri) {
        return ((o) this.f7288a).submit(new o4(1, uri));
    }
}

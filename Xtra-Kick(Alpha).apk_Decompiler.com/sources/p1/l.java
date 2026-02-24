package p1;

import android.net.Uri;
import d9.i2;
import d9.t0;
import d9.u0;
import g1.k0;
import g1.s0;
import g9.b;
import j1.a;
import j1.l0;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import k1.p;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final Object f12496a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public k0 f12497b;

    /* renamed from: c  reason: collision with root package name */
    public k f12498c;

    public static k a(k0 k0Var) {
        String str;
        p pVar = new p();
        byte[] bArr = null;
        pVar.f9046b = null;
        Uri uri = k0Var.f6442b;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        i0 i0Var = new i0(str, k0Var.f6446f, pVar);
        t0 t0Var = k0Var.f6443c;
        u0 u0Var = t0Var.f4670h;
        if (u0Var == null) {
            u0Var = t0Var.b();
            t0Var.f4670h = u0Var;
        }
        i2 g10 = u0Var.iterator();
        while (g10.hasNext()) {
            Map.Entry entry = (Map.Entry) g10.next();
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            str2.getClass();
            str3.getClass();
            synchronized (((Map) i0Var.f12467l)) {
                ((Map) i0Var.f12467l).put(str2, str3);
            }
        }
        f fVar = new f();
        UUID uuid = k0Var.f6441a;
        e0 e0Var = h0.f12459d;
        uuid.getClass();
        fVar.f12449b = uuid;
        fVar.f12450c = e0Var;
        fVar.f12451d = k0Var.f6444d;
        fVar.f12452e = k0Var.f6445e;
        int[] d10 = b.d(k0Var.f6447g);
        for (int i10 : d10) {
            boolean z10 = true;
            if (!(i10 == 2 || i10 == 1)) {
                z10 = false;
            }
            a.b(z10);
        }
        k kVar = new k(fVar.f12449b, fVar.f12450c, i0Var, fVar.f12448a, fVar.f12451d, (int[]) d10.clone(), fVar.f12452e, fVar.f12453f, fVar.f12454g);
        byte[] bArr2 = k0Var.f6448h;
        if (bArr2 != null) {
            bArr = Arrays.copyOf(bArr2, bArr2.length);
        }
        a.e(kVar.f12483m.isEmpty());
        kVar.f12492v = 0;
        kVar.f12493w = bArr;
        return kVar;
    }

    public final u b(s0 s0Var) {
        k kVar;
        s0Var.f6557i.getClass();
        k0 k0Var = s0Var.f6557i.f6480c;
        if (k0Var == null || l0.f8453a < 18) {
            return u.f12509a;
        }
        synchronized (this.f12496a) {
            if (!l0.a(k0Var, this.f12497b)) {
                this.f12497b = k0Var;
                this.f12498c = a(k0Var);
            }
            kVar = this.f12498c;
            kVar.getClass();
        }
        return kVar;
    }
}

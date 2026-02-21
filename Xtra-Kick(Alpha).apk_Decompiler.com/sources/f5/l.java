package f5;

import android.support.v4.media.session.u;
import b4.e0;
import b5.j;
import w5.k;
import w5.n;
import w5.p;
import x5.g;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final k f5831a = new k(1000);

    /* renamed from: b  reason: collision with root package name */
    public final u f5832b = g.a(10, new e0(7, this));

    public final String a(j jVar) {
        String str;
        Object j10 = this.f5832b.j();
        n.b(j10);
        k kVar = (k) j10;
        try {
            jVar.b(kVar.f5829h);
            byte[] digest = kVar.f5829h.digest();
            char[] cArr = p.f16127b;
            synchronized (cArr) {
                for (int i10 = 0; i10 < digest.length; i10++) {
                    byte b10 = digest[i10] & 255;
                    int i11 = i10 * 2;
                    char[] cArr2 = p.f16126a;
                    cArr[i11] = cArr2[b10 >>> 4];
                    cArr[i11 + 1] = cArr2[b10 & 15];
                }
                str = new String(cArr);
            }
            this.f5832b.e(kVar);
            return str;
        } catch (Throwable th) {
            this.f5832b.e(kVar);
            throw th;
        }
    }

    public final String b(j jVar) {
        String str;
        synchronized (this.f5831a) {
            str = (String) this.f5831a.a(jVar);
        }
        if (str == null) {
            str = a(jVar);
        }
        synchronized (this.f5831a) {
            this.f5831a.d(jVar, str);
        }
        return str;
    }
}

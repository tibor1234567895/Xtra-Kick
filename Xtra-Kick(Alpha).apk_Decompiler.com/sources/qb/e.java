package qb;

import dc.i0;
import dc.l;
import pb.u1;
import pb.x0;

public final class e extends u1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13483h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final long f13484i;

    /* renamed from: j  reason: collision with root package name */
    public final l f13485j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f13486k;

    public e(String str, long j10, i0 i0Var) {
        this.f13486k = str;
        this.f13484i = j10;
        this.f13485j = i0Var;
    }

    public final long contentLength() {
        return this.f13484i;
    }

    public final x0 contentType() {
        int i10 = this.f13483h;
        Object obj = this.f13486k;
        switch (i10) {
            case 0:
                return (x0) obj;
            default:
                String str = (String) obj;
                if (str == null) {
                    return null;
                }
                x0.f13023d.getClass();
                try {
                    return c.a(str);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
        }
    }

    public final l source() {
        return this.f13485j;
    }

    public e(x0 x0Var, long j10, l lVar) {
        this.f13486k = x0Var;
        this.f13484i = j10;
        this.f13485j = lVar;
    }
}

package qb;

import dc.k;
import pb.o1;
import pb.x0;
import xa.j;

public final class d extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x0 f13479a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13480b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ byte[] f13481c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f13482d;

    public d(x0 x0Var, byte[] bArr, int i10, int i11) {
        this.f13479a = x0Var;
        this.f13480b = i10;
        this.f13481c = bArr;
        this.f13482d = i11;
    }

    public final long contentLength() {
        return (long) this.f13480b;
    }

    public final x0 contentType() {
        return this.f13479a;
    }

    public final void writeTo(k kVar) {
        j.f("sink", kVar);
        kVar.f(this.f13481c, this.f13482d, this.f13480b);
    }
}

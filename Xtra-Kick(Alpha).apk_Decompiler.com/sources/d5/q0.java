package d5;

import b5.j;
import b5.n;
import b5.r;
import e5.i;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import w5.k;

public final class q0 implements j {

    /* renamed from: j  reason: collision with root package name */
    public static final k f4473j = new k(50);

    /* renamed from: b  reason: collision with root package name */
    public final e5.k f4474b;

    /* renamed from: c  reason: collision with root package name */
    public final j f4475c;

    /* renamed from: d  reason: collision with root package name */
    public final j f4476d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4477e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4478f;

    /* renamed from: g  reason: collision with root package name */
    public final Class f4479g;

    /* renamed from: h  reason: collision with root package name */
    public final n f4480h;

    /* renamed from: i  reason: collision with root package name */
    public final r f4481i;

    public q0(e5.k kVar, j jVar, j jVar2, int i10, int i11, r rVar, Class cls, n nVar) {
        this.f4474b = kVar;
        this.f4475c = jVar;
        this.f4476d = jVar2;
        this.f4477e = i10;
        this.f4478f = i11;
        this.f4481i = rVar;
        this.f4479g = cls;
        this.f4480h = nVar;
    }

    public final void b(MessageDigest messageDigest) {
        Object f10;
        e5.k kVar = this.f4474b;
        Class<byte[]> cls = byte[].class;
        synchronized (kVar) {
            i iVar = (i) kVar.f5052b.b();
            iVar.f5049b = 8;
            iVar.f5050c = cls;
            f10 = kVar.f(iVar, cls);
        }
        byte[] bArr = (byte[]) f10;
        ByteBuffer.wrap(bArr).putInt(this.f4477e).putInt(this.f4478f).array();
        this.f4476d.b(messageDigest);
        this.f4475c.b(messageDigest);
        messageDigest.update(bArr);
        r rVar = this.f4481i;
        if (rVar != null) {
            rVar.b(messageDigest);
        }
        this.f4480h.b(messageDigest);
        k kVar2 = f4473j;
        Class cls2 = this.f4479g;
        byte[] bArr2 = (byte[]) kVar2.a(cls2);
        if (bArr2 == null) {
            bArr2 = cls2.getName().getBytes(j.f2629a);
            kVar2.d(cls2, bArr2);
        }
        messageDigest.update(bArr2);
        this.f4474b.h(bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r4 = (d5.q0) r4;
        r0 = r4.f4478f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof d5.q0
            r1 = 0
            if (r0 == 0) goto L_0x0046
            d5.q0 r4 = (d5.q0) r4
            int r0 = r4.f4478f
            int r2 = r3.f4478f
            if (r2 != r0) goto L_0x0046
            int r0 = r3.f4477e
            int r2 = r4.f4477e
            if (r0 != r2) goto L_0x0046
            b5.r r0 = r3.f4481i
            b5.r r2 = r4.f4481i
            boolean r0 = w5.p.b(r0, r2)
            if (r0 == 0) goto L_0x0046
            java.lang.Class r0 = r3.f4479g
            java.lang.Class r2 = r4.f4479g
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0046
            b5.j r0 = r3.f4475c
            b5.j r2 = r4.f4475c
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0046
            b5.j r0 = r3.f4476d
            b5.j r2 = r4.f4476d
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0046
            b5.n r0 = r3.f4480h
            b5.n r4 = r4.f4480h
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0046
            r1 = 1
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.q0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = ((((this.f4476d.hashCode() + (this.f4475c.hashCode() * 31)) * 31) + this.f4477e) * 31) + this.f4478f;
        r rVar = this.f4481i;
        if (rVar != null) {
            hashCode = (hashCode * 31) + rVar.hashCode();
        }
        int hashCode2 = this.f4479g.hashCode();
        return this.f4480h.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f4475c + ", signature=" + this.f4476d + ", width=" + this.f4477e + ", height=" + this.f4478f + ", decodedResourceClass=" + this.f4479g + ", transformation='" + this.f4481i + "', options=" + this.f4480h + '}';
    }
}

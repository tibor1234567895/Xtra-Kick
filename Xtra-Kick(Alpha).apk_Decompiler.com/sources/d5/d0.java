package d5;

import b5.j;
import b5.n;
import java.security.MessageDigest;
import java.util.Map;
import w5.b;

public final class d0 implements j {

    /* renamed from: b  reason: collision with root package name */
    public final Object f4363b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4364c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4365d;

    /* renamed from: e  reason: collision with root package name */
    public final Class f4366e;

    /* renamed from: f  reason: collision with root package name */
    public final Class f4367f;

    /* renamed from: g  reason: collision with root package name */
    public final j f4368g;

    /* renamed from: h  reason: collision with root package name */
    public final Map f4369h;

    /* renamed from: i  reason: collision with root package name */
    public final n f4370i;

    /* renamed from: j  reason: collision with root package name */
    public int f4371j;

    public d0(Object obj, j jVar, int i10, int i11, b bVar, Class cls, Class cls2, n nVar) {
        w5.n.b(obj);
        this.f4363b = obj;
        if (jVar != null) {
            this.f4368g = jVar;
            this.f4364c = i10;
            this.f4365d = i11;
            w5.n.b(bVar);
            this.f4369h = bVar;
            if (cls != null) {
                this.f4366e = cls;
                if (cls2 != null) {
                    this.f4367f = cls2;
                    w5.n.b(nVar);
                    this.f4370i = nVar;
                    return;
                }
                throw new NullPointerException("Transcode class must not be null");
            }
            throw new NullPointerException("Resource class must not be null");
        }
        throw new NullPointerException("Signature must not be null");
    }

    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f4363b.equals(d0Var.f4363b) && this.f4368g.equals(d0Var.f4368g) && this.f4365d == d0Var.f4365d && this.f4364c == d0Var.f4364c && this.f4369h.equals(d0Var.f4369h) && this.f4366e.equals(d0Var.f4366e) && this.f4367f.equals(d0Var.f4367f) && this.f4370i.equals(d0Var.f4370i);
    }

    public final int hashCode() {
        if (this.f4371j == 0) {
            int hashCode = this.f4363b.hashCode();
            this.f4371j = hashCode;
            int hashCode2 = ((((this.f4368g.hashCode() + (hashCode * 31)) * 31) + this.f4364c) * 31) + this.f4365d;
            this.f4371j = hashCode2;
            int hashCode3 = this.f4369h.hashCode() + (hashCode2 * 31);
            this.f4371j = hashCode3;
            int hashCode4 = this.f4366e.hashCode() + (hashCode3 * 31);
            this.f4371j = hashCode4;
            int hashCode5 = this.f4367f.hashCode() + (hashCode4 * 31);
            this.f4371j = hashCode5;
            this.f4371j = this.f4370i.hashCode() + (hashCode5 * 31);
        }
        return this.f4371j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f4363b + ", width=" + this.f4364c + ", height=" + this.f4365d + ", resourceClass=" + this.f4366e + ", transcodeClass=" + this.f4367f + ", signature=" + this.f4368g + ", hashCode=" + this.f4371j + ", transformations=" + this.f4369h + ", options=" + this.f4370i + '}';
    }
}

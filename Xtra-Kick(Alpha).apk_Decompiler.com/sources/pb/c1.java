package pb;

import dc.k;
import dc.n;
import java.util.List;
import xa.j;

public final class c1 extends o1 {

    /* renamed from: e  reason: collision with root package name */
    public static final x0 f12777e = w0.a("multipart/mixed");

    /* renamed from: f  reason: collision with root package name */
    public static final x0 f12778f = w0.a("multipart/form-data");

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f12779g = {(byte) 58, (byte) 32};

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f12780h = {(byte) 13, (byte) 10};

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f12781i;

    /* renamed from: a  reason: collision with root package name */
    public final n f12782a;

    /* renamed from: b  reason: collision with root package name */
    public final List f12783b;

    /* renamed from: c  reason: collision with root package name */
    public final x0 f12784c;

    /* renamed from: d  reason: collision with root package name */
    public long f12785d = -1;

    static {
        new z0(0);
        x0.f13023d.getClass();
        w0.a("multipart/alternative");
        w0.a("multipart/digest");
        w0.a("multipart/parallel");
        byte b10 = (byte) 45;
        f12781i = new byte[]{b10, b10};
    }

    public c1(n nVar, x0 x0Var, List list) {
        j.f("boundaryByteString", nVar);
        j.f("type", x0Var);
        this.f12782a = nVar;
        this.f12783b = list;
        x0.f13023d.getClass();
        this.f12784c = w0.a(x0Var + "; boundary=" + nVar.q());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: dc.j} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: dc.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: dc.j} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: dc.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: dc.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: dc.j} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(dc.k r17, boolean r18) {
        /*
            r16 = this;
            r0 = r16
            if (r18 == 0) goto L_0x000b
            dc.j r1 = new dc.j
            r1.<init>()
            r2 = r1
            goto L_0x000f
        L_0x000b:
            r1 = 0
            r2 = r1
            r1 = r17
        L_0x000f:
            java.util.List r3 = r0.f12783b
            int r4 = r3.size()
            r5 = 0
            r6 = 0
            r8 = 0
        L_0x0019:
            dc.n r9 = r0.f12782a
            byte[] r10 = f12781i
            byte[] r11 = f12780h
            if (r8 >= r4) goto L_0x0095
            java.lang.Object r12 = r3.get(r8)
            pb.b1 r12 = (pb.b1) r12
            pb.p0 r13 = r12.f12773a
            xa.j.c(r1)
            r1.X(r10)
            r1.i0(r9)
            r1.X(r11)
            if (r13 == 0) goto L_0x005b
            java.lang.String[] r9 = r13.f12931h
            int r9 = r9.length
            int r9 = r9 / 2
            r10 = 0
        L_0x003d:
            if (r10 >= r9) goto L_0x005b
            java.lang.String r14 = r13.c(r10)
            dc.k r14 = r1.v0(r14)
            byte[] r15 = f12779g
            dc.k r14 = r14.X(r15)
            java.lang.String r15 = r13.f(r10)
            dc.k r14 = r14.v0(r15)
            r14.X(r11)
            int r10 = r10 + 1
            goto L_0x003d
        L_0x005b:
            pb.o1 r9 = r12.f12774b
            pb.x0 r10 = r9.contentType()
            if (r10 == 0) goto L_0x0072
            java.lang.String r12 = "Content-Type: "
            dc.k r12 = r1.v0(r12)
            java.lang.String r10 = r10.f13024a
            dc.k r10 = r12.v0(r10)
            r10.X(r11)
        L_0x0072:
            long r12 = r9.contentLength()
            r14 = -1
            int r10 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r10 != 0) goto L_0x0085
            if (r18 == 0) goto L_0x0085
            xa.j.c(r2)
            r2.c()
            return r14
        L_0x0085:
            r1.X(r11)
            if (r18 == 0) goto L_0x008c
            long r6 = r6 + r12
            goto L_0x008f
        L_0x008c:
            r9.writeTo(r1)
        L_0x008f:
            r1.X(r11)
            int r8 = r8 + 1
            goto L_0x0019
        L_0x0095:
            xa.j.c(r1)
            r1.X(r10)
            r1.i0(r9)
            r1.X(r10)
            r1.X(r11)
            if (r18 == 0) goto L_0x00af
            xa.j.c(r2)
            long r3 = r2.f4787i
            long r6 = r6 + r3
            r2.c()
        L_0x00af:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.c1.a(dc.k, boolean):long");
    }

    public final long contentLength() {
        long j10 = this.f12785d;
        if (j10 != -1) {
            return j10;
        }
        long a10 = a((k) null, true);
        this.f12785d = a10;
        return a10;
    }

    public final x0 contentType() {
        return this.f12784c;
    }

    public final void writeTo(k kVar) {
        j.f("sink", kVar);
        a(kVar, false);
    }
}

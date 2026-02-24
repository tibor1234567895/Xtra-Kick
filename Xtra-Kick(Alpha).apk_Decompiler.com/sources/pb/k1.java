package pb;

import dc.n;
import java.io.File;

public final class k1 extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f12891a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x0 f12892b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f12893c;

    public /* synthetic */ k1(x0 x0Var, Object obj, int i10) {
        this.f12891a = i10;
        this.f12892b = x0Var;
        this.f12893c = obj;
    }

    public final long contentLength() {
        int i10 = this.f12891a;
        Object obj = this.f12893c;
        switch (i10) {
            case 0:
                return ((File) obj).length();
            case 2:
                return (long) ((n) obj).d();
            default:
                return -1;
        }
    }

    public final x0 contentType() {
        return this.f12892b;
    }

    public final boolean isOneShot() {
        switch (this.f12891a) {
            case 1:
                return true;
            default:
                return super.isOneShot();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        hb.h0.A(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        hb.h0.A(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeTo(dc.k r5) {
        /*
            r4 = this;
            int r0 = r4.f12891a
            r1 = 0
            java.lang.Object r2 = r4.f12893c
            java.lang.String r3 = "sink"
            switch(r0) {
                case 0: goto L_0x002b;
                case 1: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0051
        L_0x000b:
            xa.j.f(r3, r5)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.io.FileDescriptor r2 = (java.io.FileDescriptor) r2
            r0.<init>(r2)
            dc.j r5 = r5.b()     // Catch:{ all -> 0x0024 }
            dc.d r2 = hb.h0.I1(r0)     // Catch:{ all -> 0x0024 }
            r5.F0(r2)     // Catch:{ all -> 0x0024 }
            hb.h0.A(r0, r1)
            return
        L_0x0024:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r1 = move-exception
            hb.h0.A(r0, r5)
            throw r1
        L_0x002b:
            xa.j.f(r3, r5)
            java.io.File r2 = (java.io.File) r2
            java.util.logging.Logger r0 = dc.b0.f4742a
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r2)
            dc.d r0 = new dc.d
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r2)
            dc.q0 r2 = dc.s0.f4821d
            r0.<init>((java.io.InputStream) r3, (dc.s0) r2)
            r5.F0(r0)     // Catch:{ all -> 0x004a }
            hb.h0.A(r0, r1)
            return
        L_0x004a:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x004c }
        L_0x004c:
            r1 = move-exception
            hb.h0.A(r0, r5)
            throw r1
        L_0x0051:
            xa.j.f(r3, r5)
            dc.n r2 = (dc.n) r2
            r5.i0(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.k1.writeTo(dc.k):void");
    }
}

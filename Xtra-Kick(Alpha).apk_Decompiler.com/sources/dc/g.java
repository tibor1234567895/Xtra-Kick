package dc;

import android.support.v4.media.h;
import java.io.Closeable;
import xa.j;

public final class g implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public j f4764h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4765i;

    /* renamed from: j  reason: collision with root package name */
    public k0 f4766j;

    /* renamed from: k  reason: collision with root package name */
    public long f4767k = -1;

    /* renamed from: l  reason: collision with root package name */
    public byte[] f4768l;

    /* renamed from: m  reason: collision with root package name */
    public int f4769m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f4770n = -1;

    public final void c(long j10) {
        boolean z10;
        j jVar = this.f4764h;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (this.f4765i) {
            long j11 = jVar.f4787i;
            int i10 = 1;
            int i11 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
            if (i11 <= 0) {
                if (j10 >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    long j12 = j11 - j10;
                    while (true) {
                        if (j12 <= 0) {
                            break;
                        }
                        k0 k0Var = jVar.f4786h;
                        j.c(k0Var);
                        k0 k0Var2 = k0Var.f4794g;
                        j.c(k0Var2);
                        int i12 = k0Var2.f4790c;
                        long j13 = (long) (i12 - k0Var2.f4789b);
                        if (j13 > j12) {
                            k0Var2.f4790c = i12 - ((int) j12);
                            break;
                        }
                        jVar.f4786h = k0Var2.a();
                        l0.a(k0Var2);
                        j12 -= j13;
                    }
                    this.f4766j = null;
                    this.f4767k = j10;
                    this.f4768l = null;
                    this.f4769m = -1;
                    this.f4770n = -1;
                } else {
                    throw new IllegalArgumentException(h.k("newSize < 0: ", j10).toString());
                }
            } else if (i11 > 0) {
                long j14 = j10 - j11;
                boolean z11 = true;
                while (j14 > 0) {
                    k0 M0 = jVar.M0(i10);
                    int min = (int) Math.min(j14, (long) (8192 - M0.f4790c));
                    int i13 = M0.f4790c + min;
                    M0.f4790c = i13;
                    j14 -= (long) min;
                    if (z11) {
                        this.f4766j = M0;
                        this.f4767k = j11;
                        this.f4768l = M0.f4788a;
                        this.f4769m = i13 - min;
                        this.f4770n = i13;
                        i10 = 1;
                        z11 = false;
                    } else {
                        i10 = 1;
                    }
                }
            }
            jVar.f4787i = j10;
        } else {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
    }

    public final void close() {
        boolean z10;
        if (this.f4764h != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f4764h = null;
            this.f4766j = null;
            this.f4767k = -1;
            this.f4768l = null;
            this.f4769m = -1;
            this.f4770n = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r3.f4787i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e(long r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            dc.j r3 = r0.f4764h
            if (r3 == 0) goto L_0x00e1
            r4 = -1
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x00c3
            long r4 = r3.f4787i
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x00c3
            if (r6 == 0) goto L_0x00b6
            if (r7 != 0) goto L_0x001a
            goto L_0x00b6
        L_0x001a:
            dc.k0 r6 = r3.f4786h
            dc.k0 r7 = r0.f4766j
            r8 = 0
            if (r7 == 0) goto L_0x0038
            long r10 = r0.f4767k
            int r12 = r0.f4769m
            int r13 = r7.f4789b
            int r12 = r12 - r13
            long r12 = (long) r12
            long r10 = r10 - r12
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 <= 0) goto L_0x0031
            r4 = r10
            goto L_0x0039
        L_0x0031:
            r8 = r10
            r16 = r7
            r7 = r6
            r6 = r16
            goto L_0x0039
        L_0x0038:
            r7 = r6
        L_0x0039:
            long r10 = r4 - r1
            long r12 = r1 - r8
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0053
        L_0x0041:
            xa.j.c(r6)
            int r4 = r6.f4790c
            int r5 = r6.f4789b
            int r4 = r4 - r5
            long r4 = (long) r4
            long r4 = r4 + r8
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0069
            dc.k0 r6 = r6.f4793f
            r8 = r4
            goto L_0x0041
        L_0x0053:
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0067
            xa.j.c(r7)
            dc.k0 r7 = r7.f4794g
            xa.j.c(r7)
            int r6 = r7.f4790c
            int r8 = r7.f4789b
            int r6 = r6 - r8
            long r8 = (long) r6
            long r4 = r4 - r8
            goto L_0x0053
        L_0x0067:
            r8 = r4
            r6 = r7
        L_0x0069:
            boolean r4 = r0.f4765i
            if (r4 == 0) goto L_0x009e
            xa.j.c(r6)
            boolean r4 = r6.f4791d
            if (r4 == 0) goto L_0x009e
            dc.k0 r4 = new dc.k0
            byte[] r5 = r6.f4788a
            int r7 = r5.length
            byte[] r11 = java.util.Arrays.copyOf(r5, r7)
            java.lang.String r5 = "copyOf(this, size)"
            xa.j.e(r5, r11)
            int r12 = r6.f4789b
            int r13 = r6.f4790c
            r14 = 0
            r15 = 1
            r10 = r4
            r10.<init>(r11, r12, r13, r14, r15)
            dc.k0 r5 = r3.f4786h
            if (r5 != r6) goto L_0x0092
            r3.f4786h = r4
        L_0x0092:
            r6.b(r4)
            dc.k0 r3 = r4.f4794g
            xa.j.c(r3)
            r3.a()
            r6 = r4
        L_0x009e:
            r0.f4766j = r6
            r0.f4767k = r1
            xa.j.c(r6)
            byte[] r3 = r6.f4788a
            r0.f4768l = r3
            int r3 = r6.f4789b
            long r1 = r1 - r8
            int r2 = (int) r1
            int r3 = r3 + r2
            r0.f4769m = r3
            int r1 = r6.f4790c
            r0.f4770n = r1
            int r1 = r1 - r3
            goto L_0x00c2
        L_0x00b6:
            r3 = 0
            r0.f4766j = r3
            r0.f4767k = r1
            r0.f4768l = r3
            r1 = -1
            r0.f4769m = r1
            r0.f4770n = r1
        L_0x00c2:
            return r1
        L_0x00c3:
            java.lang.ArrayIndexOutOfBoundsException r4 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "offset="
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = " > size="
            r5.append(r1)
            long r1 = r3.f4787i
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r4.<init>(r1)
            throw r4
        L_0x00e1:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "not attached to a buffer"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.g.e(long):int");
    }
}

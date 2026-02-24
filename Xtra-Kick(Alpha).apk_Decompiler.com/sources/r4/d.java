package r4;

import android.graphics.Bitmap;
import fb.v;
import fb.w;
import java.util.Date;
import pb.j1;
import pb.p0;
import w4.e;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final j1 f13801a;

    /* renamed from: b  reason: collision with root package name */
    public final b f13802b;

    /* renamed from: c  reason: collision with root package name */
    public final Date f13803c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13804d;

    /* renamed from: e  reason: collision with root package name */
    public final Date f13805e;

    /* renamed from: f  reason: collision with root package name */
    public final String f13806f;

    /* renamed from: g  reason: collision with root package name */
    public final Date f13807g;

    /* renamed from: h  reason: collision with root package name */
    public final long f13808h;

    /* renamed from: i  reason: collision with root package name */
    public final long f13809i;

    /* renamed from: j  reason: collision with root package name */
    public final String f13810j;

    /* renamed from: k  reason: collision with root package name */
    public final int f13811k = -1;

    public d(j1 j1Var, b bVar) {
        int i10;
        this.f13801a = j1Var;
        this.f13802b = bVar;
        if (bVar != null) {
            this.f13808h = bVar.f13797c;
            this.f13809i = bVar.f13798d;
            p0 p0Var = bVar.f13800f;
            int length = p0Var.f12931h.length / 2;
            for (int i11 = 0; i11 < length; i11++) {
                String c10 = p0Var.c(i11);
                if (w.g(c10, "Date")) {
                    this.f13803c = p0Var.b("Date");
                    this.f13804d = p0Var.f(i11);
                } else if (w.g(c10, "Expires")) {
                    this.f13807g = p0Var.b("Expires");
                } else if (w.g(c10, "Last-Modified")) {
                    this.f13805e = p0Var.b("Last-Modified");
                    this.f13806f = p0Var.f(i11);
                } else if (w.g(c10, "ETag")) {
                    this.f13810j = p0Var.f(i11);
                } else if (w.g(c10, "Age")) {
                    String f10 = p0Var.f(i11);
                    Bitmap.Config[] configArr = e.f16080a;
                    Long e10 = v.e(f10);
                    if (e10 != null) {
                        long longValue = e10.longValue();
                        if (longValue > 2147483647L) {
                            i10 = Integer.MAX_VALUE;
                        } else if (longValue < 0) {
                            i10 = 0;
                        } else {
                            i10 = (int) longValue;
                        }
                    } else {
                        i10 = -1;
                    }
                    this.f13811k = i10;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e3, code lost:
        if (r2 > 0) goto L_0x011b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final r4.e a() {
        /*
            r22 = this;
            r0 = r22
            pb.j1 r1 = r0.f13801a
            r2 = 0
            r4.b r3 = r0.f13802b
            if (r3 != 0) goto L_0x000f
            r4.e r3 = new r4.e
            r3.<init>(r1, r2)
            return r3
        L_0x000f:
            pb.t0 r4 = r1.f12884a
            boolean r4 = r4.f12998j
            if (r4 == 0) goto L_0x001f
            boolean r4 = r3.f13799e
            if (r4 != 0) goto L_0x001f
            r4.e r3 = new r4.e
            r3.<init>(r1, r2)
            return r3
        L_0x001f:
            la.e r4 = r3.f13795a
            java.lang.Object r5 = r4.getValue()
            pb.g r5 = (pb.g) r5
            r4.c r6 = r4.e.f13812c
            r6.getClass()
            pb.g r6 = r1.a()
            boolean r6 = r6.f12850b
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x0052
            java.lang.Object r6 = r4.getValue()
            pb.g r6 = (pb.g) r6
            boolean r6 = r6.f12850b
            if (r6 != 0) goto L_0x0052
            java.lang.String r6 = "Vary"
            pb.p0 r9 = r3.f13800f
            java.lang.String r6 = r9.a(r6)
            java.lang.String r9 = "*"
            boolean r6 = xa.j.a(r6, r9)
            if (r6 != 0) goto L_0x0052
            r6 = 1
            goto L_0x0053
        L_0x0052:
            r6 = 0
        L_0x0053:
            if (r6 != 0) goto L_0x005b
            r4.e r3 = new r4.e
            r3.<init>(r1, r2)
            return r3
        L_0x005b:
            pb.g r6 = r1.a()
            boolean r9 = r6.f12849a
            if (r9 != 0) goto L_0x0199
            java.lang.String r9 = "If-Modified-Since"
            java.lang.String r10 = r1.b(r9)
            java.lang.String r11 = "If-None-Match"
            if (r10 != 0) goto L_0x0073
            java.lang.String r10 = r1.b(r11)
            if (r10 == 0) goto L_0x0074
        L_0x0073:
            r7 = 1
        L_0x0074:
            if (r7 == 0) goto L_0x0078
            goto L_0x0199
        L_0x0078:
            r7 = 0
            long r12 = r0.f13809i
            java.util.Date r10 = r0.f13803c
            if (r10 == 0) goto L_0x008b
            long r14 = r10.getTime()
            long r14 = r12 - r14
            long r14 = java.lang.Math.max(r7, r14)
            goto L_0x008c
        L_0x008b:
            r14 = r7
        L_0x008c:
            r2 = -1
            int r7 = r0.f13811k
            if (r7 == r2) goto L_0x009f
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
            r18 = r3
            long r2 = (long) r7
            long r2 = r8.toMillis(r2)
            long r14 = java.lang.Math.max(r14, r2)
            goto L_0x00a1
        L_0x009f:
            r18 = r3
        L_0x00a1:
            long r2 = r0.f13808h
            long r7 = r12 - r2
            w4.q r20 = w4.q.f16104a
            r20.getClass()
            w4.p r20 = w4.q.f16105b
            java.lang.Object r20 = r20.b()
            java.lang.Number r20 = (java.lang.Number) r20
            long r20 = r20.longValue()
            long r20 = r20 - r12
            long r14 = r14 + r7
            long r14 = r14 + r20
            java.lang.Object r4 = r4.getValue()
            pb.g r4 = (pb.g) r4
            int r4 = r4.f12851c
            java.util.Date r7 = r0.f13805e
            r8 = -1
            if (r4 == r8) goto L_0x00d0
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
            long r3 = (long) r4
            long r2 = r2.toMillis(r3)
            goto L_0x011b
        L_0x00d0:
            java.util.Date r4 = r0.f13807g
            if (r4 == 0) goto L_0x00e6
            if (r10 == 0) goto L_0x00da
            long r12 = r10.getTime()
        L_0x00da:
            long r2 = r4.getTime()
            long r2 = r2 - r12
            r12 = 0
            int r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x0119
            goto L_0x011b
        L_0x00e6:
            if (r7 == 0) goto L_0x0119
            pb.t0 r4 = r1.f12884a
            java.util.List r4 = r4.f12995g
            if (r4 != 0) goto L_0x00f0
            r4 = 0
            goto L_0x0101
        L_0x00f0:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            pb.s0 r12 = pb.t0.f12987k
            r12.getClass()
            pb.s0.f(r4, r8)
            java.lang.String r4 = r8.toString()
        L_0x0101:
            if (r4 != 0) goto L_0x0119
            if (r10 == 0) goto L_0x0109
            long r2 = r10.getTime()
        L_0x0109:
            long r12 = r7.getTime()
            long r2 = r2 - r12
            r12 = 0
            int r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x0119
            r4 = 10
            long r12 = (long) r4
            long r2 = r2 / r12
            goto L_0x011b
        L_0x0119:
            r2 = 0
        L_0x011b:
            int r4 = r6.f12851c
            r8 = -1
            if (r4 == r8) goto L_0x012d
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS
            r13 = r9
            long r8 = (long) r4
            long r8 = r12.toMillis(r8)
            long r2 = java.lang.Math.min(r2, r8)
            goto L_0x012e
        L_0x012d:
            r13 = r9
        L_0x012e:
            int r4 = r6.f12857i
            r8 = -1
            if (r4 == r8) goto L_0x013d
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            r19 = r11
            long r11 = (long) r4
            long r11 = r9.toMillis(r11)
            goto L_0x0141
        L_0x013d:
            r19 = r11
            r11 = 0
        L_0x0141:
            boolean r4 = r5.f12855g
            if (r4 != 0) goto L_0x0153
            int r4 = r6.f12856h
            if (r4 == r8) goto L_0x0153
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
            long r8 = (long) r4
            long r8 = r6.toMillis(r8)
            r16 = r8
            goto L_0x0155
        L_0x0153:
            r16 = 0
        L_0x0155:
            boolean r4 = r5.f12849a
            if (r4 != 0) goto L_0x0169
            long r14 = r14 + r11
            long r2 = r2 + r16
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0169
            r4.e r1 = new r4.e
            r3 = r18
            r2 = 0
            r1.<init>(r2, r3)
            return r1
        L_0x0169:
            r3 = r18
            java.lang.String r2 = r0.f13810j
            if (r2 == 0) goto L_0x0172
            r9 = r19
            goto L_0x017f
        L_0x0172:
            if (r7 == 0) goto L_0x0177
            java.lang.String r2 = r0.f13806f
            goto L_0x017b
        L_0x0177:
            if (r10 == 0) goto L_0x0192
            java.lang.String r2 = r0.f13804d
        L_0x017b:
            xa.j.c(r2)
            r9 = r13
        L_0x017f:
            pb.i1 r4 = new pb.i1
            r4.<init>(r1)
            r4.a(r9, r2)
            pb.j1 r1 = new pb.j1
            r1.<init>(r4)
            r4.e r2 = new r4.e
            r2.<init>(r1, r3)
            return r2
        L_0x0192:
            r4.e r2 = new r4.e
            r3 = 0
            r2.<init>(r1, r3)
            return r2
        L_0x0199:
            r3 = r2
            r4.e r2 = new r4.e
            r2.<init>(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.d.a():r4.e");
    }
}

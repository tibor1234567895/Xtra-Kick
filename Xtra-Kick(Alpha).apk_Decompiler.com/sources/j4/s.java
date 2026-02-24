package j4;

import dc.j;
import dc.l;
import dc.m;
import dc.n;
import dc.t;

public final class s extends t {

    /* renamed from: i  reason: collision with root package name */
    public static final n f8780i = m.a("0021F904");

    /* renamed from: h  reason: collision with root package name */
    public final j f8781h = new j();

    static {
        new r(0);
        n.f4802k.getClass();
    }

    public s(l lVar) {
        super(lVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3 A[EDGE_INSN: B:37:0x00a3->B:26:0x00a3 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long read(dc.j r21, long r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r0.t(r2)
            dc.j r4 = r0.f8781h
            long r5 = r4.f4787i
            r7 = -1
            r9 = 0
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x001b
            int r1 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x001a
            r7 = r9
        L_0x001a:
            return r7
        L_0x001b:
            r5 = r9
        L_0x001c:
            dc.n r11 = f8780i
            r12 = r7
        L_0x001f:
            dc.j r14 = r0.f8781h
            byte[] r15 = r11.f4804h
            r9 = 0
            byte r15 = r15[r9]
            r9 = 1
            long r16 = r12 + r9
            r18 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r12 = r14.w(r15, r16, r18)
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 == 0) goto L_0x004d
            byte[] r15 = r11.f4804h
            int r15 = r15.length
            long r7 = (long) r15
            boolean r7 = r0.t(r7)
            if (r7 == 0) goto L_0x0048
            boolean r7 = r4.E(r12, r11)
            if (r7 == 0) goto L_0x0048
            goto L_0x004d
        L_0x0048:
            r7 = -1
            r9 = 0
            goto L_0x001f
        L_0x004d:
            if (r14 == 0) goto L_0x00a3
            r7 = 4
            long r7 = (long) r7
            long r12 = r12 + r7
            long r7 = r4.read(r1, r12)
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x005e
            r7 = 0
        L_0x005e:
            long r5 = r5 + r7
            r7 = 5
            boolean r7 = r0.t(r7)
            if (r7 == 0) goto L_0x009d
            r7 = 4
            byte r7 = r4.v(r7)
            if (r7 == 0) goto L_0x0070
            goto L_0x009d
        L_0x0070:
            r7 = 2
            byte r7 = r4.v(r7)
            int r8 = la.s.f9812h
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            byte r8 = r4.v(r9)
            r8 = r8 & 255(0xff, float:3.57E-43)
            r7 = r7 | r8
            r8 = 2
            if (r7 >= r8) goto L_0x009d
            r7 = 0
            byte r9 = r4.v(r7)
            r1.Q0(r9)
            r7 = 10
            r1.Q0(r7)
            r7 = 0
            r1.Q0(r7)
            r7 = 3
            r4.a(r7)
        L_0x009d:
            r7 = -1
            r9 = 0
            goto L_0x001c
        L_0x00a3:
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x00b5
            long r2 = r2 - r5
            long r11 = r4.read(r1, r2)
            r1 = 0
            int r3 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b3
            r11 = r1
        L_0x00b3:
            long r5 = r5 + r11
            goto L_0x00b7
        L_0x00b5:
            r1 = 0
        L_0x00b7:
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x00be
            r7 = -1
            goto L_0x00bf
        L_0x00be:
            r7 = r5
        L_0x00bf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.s.read(dc.j, long):long");
    }

    public final boolean t(long j10) {
        j jVar = this.f8781h;
        long j11 = jVar.f4787i;
        if (j11 >= j10) {
            return true;
        }
        long j12 = j10 - j11;
        if (super.read(jVar, j12) == j12) {
            return true;
        }
        return false;
    }
}

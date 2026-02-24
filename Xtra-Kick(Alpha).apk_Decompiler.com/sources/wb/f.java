package wb;

import dc.i0;
import dc.n;
import hb.h0;
import java.util.ArrayList;
import ma.o;
import xa.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f16220a = 4096;

    /* renamed from: b  reason: collision with root package name */
    public int f16221b = 4096;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f16222c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final i0 f16223d;

    /* renamed from: e  reason: collision with root package name */
    public e[] f16224e;

    /* renamed from: f  reason: collision with root package name */
    public int f16225f;

    /* renamed from: g  reason: collision with root package name */
    public int f16226g;

    /* renamed from: h  reason: collision with root package name */
    public int f16227h;

    public f(a0 a0Var) {
        this.f16223d = h0.o(a0Var);
        this.f16224e = new e[8];
        this.f16225f = 7;
    }

    public final int a(int i10) {
        int i11;
        int i12 = 0;
        if (i10 > 0) {
            int length = this.f16224e.length;
            while (true) {
                length--;
                i11 = this.f16225f;
                if (length < i11 || i10 <= 0) {
                    e[] eVarArr = this.f16224e;
                    System.arraycopy(eVarArr, i11 + 1, eVarArr, i11 + 1 + i12, this.f16226g);
                    this.f16225f += i12;
                } else {
                    e eVar = this.f16224e[length];
                    j.c(eVar);
                    int i13 = eVar.f16212c;
                    i10 -= i13;
                    this.f16227h -= i13;
                    this.f16226g--;
                    i12++;
                }
            }
            e[] eVarArr2 = this.f16224e;
            System.arraycopy(eVarArr2, i11 + 1, eVarArr2, i11 + 1 + i12, this.f16226g);
            this.f16225f += i12;
        }
        return i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final dc.n b(int r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 < 0) goto L_0x0010
            wb.h r1 = wb.h.f16252a
            r1.getClass()
            wb.e[] r1 = wb.h.f16253b
            int r1 = r1.length
            int r1 = r1 - r0
            if (r5 > r1) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            if (r1 == 0) goto L_0x001d
            wb.h r0 = wb.h.f16252a
            r0.getClass()
            wb.e[] r0 = wb.h.f16253b
            r5 = r0[r5]
            goto L_0x0037
        L_0x001d:
            wb.h r1 = wb.h.f16252a
            r1.getClass()
            wb.e[] r1 = wb.h.f16253b
            int r1 = r1.length
            int r1 = r5 - r1
            int r2 = r4.f16225f
            int r2 = r2 + r0
            int r2 = r2 + r1
            if (r2 < 0) goto L_0x003a
            wb.e[] r1 = r4.f16224e
            int r3 = r1.length
            if (r2 >= r3) goto L_0x003a
            r5 = r1[r2]
            xa.j.c(r5)
        L_0x0037:
            dc.n r5 = r5.f16210a
            return r5
        L_0x003a:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Header index too large "
            r2.<init>(r3)
            int r5 = r5 + r0
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.f.b(int):dc.n");
    }

    public final void c(e eVar) {
        this.f16222c.add(eVar);
        int i10 = this.f16221b;
        int i11 = eVar.f16212c;
        if (i11 > i10) {
            e[] eVarArr = this.f16224e;
            o.f(eVarArr, (j0) null, 0, eVarArr.length);
            this.f16225f = this.f16224e.length - 1;
            this.f16226g = 0;
            this.f16227h = 0;
            return;
        }
        a((this.f16227h + i11) - i10);
        int i12 = this.f16226g + 1;
        e[] eVarArr2 = this.f16224e;
        if (i12 > eVarArr2.length) {
            e[] eVarArr3 = new e[(eVarArr2.length * 2)];
            System.arraycopy(eVarArr2, 0, eVarArr3, eVarArr2.length, eVarArr2.length);
            this.f16225f = this.f16224e.length - 1;
            this.f16224e = eVarArr3;
        }
        int i13 = this.f16225f;
        this.f16225f = i13 - 1;
        this.f16224e[i13] = eVar;
        this.f16226g++;
        this.f16227h += i11;
    }

    public final n d() {
        boolean z10;
        int i10;
        i0 i0Var = this.f16223d;
        byte readByte = i0Var.readByte();
        byte[] bArr = qb.f.f13487a;
        byte b10 = readByte & 255;
        byte b11 = 0;
        if ((b10 & 128) == 128) {
            z10 = true;
        } else {
            z10 = false;
        }
        long e10 = (long) e(b10, 127);
        if (!z10) {
            return i0Var.n(e10);
        }
        dc.j jVar = new dc.j();
        k0.f16282a.getClass();
        j.f("source", i0Var);
        j0 j0Var = k0.f16285d;
        j0 j0Var2 = j0Var;
        int i11 = 0;
        for (long j10 = 0; j10 < e10; j10++) {
            byte readByte2 = i0Var.readByte();
            byte[] bArr2 = qb.f.f13487a;
            b11 = (b11 << 8) | (readByte2 & 255);
            i11 += 8;
            while (i11 >= 8) {
                int i12 = i11 - 8;
                j0[] j0VarArr = j0Var2.f16270a;
                j.c(j0VarArr);
                j0Var2 = j0VarArr[(b11 >>> i12) & 255];
                j.c(j0Var2);
                if (j0Var2.f16270a == null) {
                    jVar.Q0(j0Var2.f16271b);
                    i11 -= j0Var2.f16272c;
                    j0Var2 = j0Var;
                } else {
                    i11 = i12;
                }
            }
        }
        while (i11 > 0) {
            j0[] j0VarArr2 = j0Var2.f16270a;
            j.c(j0VarArr2);
            j0 j0Var3 = j0VarArr2[(b11 << (8 - i11)) & 255];
            j.c(j0Var3);
            if (j0Var3.f16270a != null || (i10 = j0Var3.f16272c) > i11) {
                break;
            }
            jVar.Q0(j0Var3.f16271b);
            i11 -= i10;
            j0Var2 = j0Var;
        }
        return jVar.m();
    }

    public final int e(int i10, int i11) {
        int i12 = i10 & i11;
        if (i12 < i11) {
            return i12;
        }
        int i13 = 0;
        while (true) {
            byte readByte = this.f16223d.readByte();
            byte[] bArr = qb.f.f13487a;
            byte b10 = readByte & 255;
            if ((b10 & 128) == 0) {
                return i11 + (b10 << i13);
            }
            i11 += (b10 & Byte.MAX_VALUE) << i13;
            i13 += 7;
        }
    }
}

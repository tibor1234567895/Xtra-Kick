package u2;

import d2.x0;
import j1.b0;
import j1.l0;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f15229a;

    /* renamed from: b  reason: collision with root package name */
    public final w f15230b = new w();

    /* renamed from: c  reason: collision with root package name */
    public final b0 f15231c = new b0();

    /* renamed from: d  reason: collision with root package name */
    public x f15232d;

    /* renamed from: e  reason: collision with root package name */
    public i f15233e;

    /* renamed from: f  reason: collision with root package name */
    public int f15234f;

    /* renamed from: g  reason: collision with root package name */
    public int f15235g;

    /* renamed from: h  reason: collision with root package name */
    public int f15236h;

    /* renamed from: i  reason: collision with root package name */
    public int f15237i;

    /* renamed from: j  reason: collision with root package name */
    public final b0 f15238j = new b0(1);

    /* renamed from: k  reason: collision with root package name */
    public final b0 f15239k = new b0();

    /* renamed from: l  reason: collision with root package name */
    public boolean f15240l;

    public l(x0 x0Var, x xVar, i iVar) {
        this.f15229a = x0Var;
        this.f15232d = xVar;
        this.f15233e = iVar;
        this.f15232d = xVar;
        this.f15233e = iVar;
        x0Var.a(xVar.f15338a.f15310f);
        d();
    }

    public final v a() {
        if (!this.f15240l) {
            return null;
        }
        w wVar = this.f15230b;
        i iVar = wVar.f15321a;
        int i10 = l0.f8453a;
        int i11 = iVar.f15221a;
        v vVar = wVar.f15333m;
        if (vVar == null) {
            v[] vVarArr = this.f15232d.f15338a.f15315k;
            if (vVarArr == null) {
                vVar = null;
            } else {
                vVar = vVarArr[i11];
            }
        }
        if (vVar == null || !vVar.f15316a) {
            return null;
        }
        return vVar;
    }

    public final boolean b() {
        this.f15234f++;
        if (!this.f15240l) {
            return false;
        }
        int i10 = this.f15235g + 1;
        this.f15235g = i10;
        int[] iArr = this.f15230b.f15327g;
        int i11 = this.f15236h;
        if (i10 != iArr[i11]) {
            return true;
        }
        this.f15236h = i11 + 1;
        this.f15235g = 0;
        return false;
    }

    public final int c(int i10, int i11) {
        b0 b0Var;
        boolean z10;
        boolean z11;
        int i12;
        v a10 = a();
        if (a10 == null) {
            return 0;
        }
        w wVar = this.f15230b;
        int i13 = a10.f15319d;
        if (i13 != 0) {
            b0Var = wVar.f15334n;
        } else {
            int i14 = l0.f8453a;
            byte[] bArr = a10.f15320e;
            int length = bArr.length;
            b0 b0Var2 = this.f15239k;
            b0Var2.E(length, bArr);
            i13 = bArr.length;
            b0Var = b0Var2;
        }
        int i15 = this.f15234f;
        if (!wVar.f15331k || !wVar.f15332l[i15]) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 || i11 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        b0 b0Var3 = this.f15238j;
        byte[] bArr2 = b0Var3.f8414a;
        if (z11) {
            i12 = 128;
        } else {
            i12 = 0;
        }
        bArr2[0] = (byte) (i12 | i13);
        b0Var3.G(0);
        x0 x0Var = this.f15229a;
        x0Var.b(1, b0Var3);
        x0Var.b(i13, b0Var);
        if (!z11) {
            return i13 + 1;
        }
        b0 b0Var4 = this.f15231c;
        if (!z10) {
            b0Var4.D(8);
            byte[] bArr3 = b0Var4.f8414a;
            bArr3[0] = 0;
            bArr3[1] = 1;
            bArr3[2] = (byte) ((i11 >> 8) & 255);
            bArr3[3] = (byte) (i11 & 255);
            bArr3[4] = (byte) ((i10 >> 24) & 255);
            bArr3[5] = (byte) ((i10 >> 16) & 255);
            bArr3[6] = (byte) ((i10 >> 8) & 255);
            bArr3[7] = (byte) (i10 & 255);
            x0Var.b(8, b0Var4);
            return i13 + 1 + 8;
        }
        b0 b0Var5 = wVar.f15334n;
        int A = b0Var5.A();
        b0Var5.H(-2);
        int i16 = (A * 6) + 2;
        if (i11 != 0) {
            b0Var4.D(i16);
            byte[] bArr4 = b0Var4.f8414a;
            b0Var5.d(bArr4, 0, i16);
            int i17 = (((bArr4[2] & 255) << 8) | (bArr4[3] & 255)) + i11;
            bArr4[2] = (byte) ((i17 >> 8) & 255);
            bArr4[3] = (byte) (i17 & 255);
        } else {
            b0Var4 = b0Var5;
        }
        x0Var.b(i16, b0Var4);
        return i13 + 1 + i16;
    }

    public final void d() {
        w wVar = this.f15230b;
        wVar.f15324d = 0;
        wVar.f15336p = 0;
        wVar.f15337q = false;
        wVar.f15331k = false;
        wVar.f15335o = false;
        wVar.f15333m = null;
        this.f15234f = 0;
        this.f15236h = 0;
        this.f15235g = 0;
        this.f15237i = 0;
        this.f15240l = false;
    }
}

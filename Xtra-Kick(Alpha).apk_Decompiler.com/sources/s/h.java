package s;

import android.support.v4.media.session.u;
import java.util.Arrays;

public final class h extends c {

    /* renamed from: f  reason: collision with root package name */
    public j[] f13954f = new j[128];

    /* renamed from: g  reason: collision with root package name */
    public j[] f13955g = new j[128];

    /* renamed from: h  reason: collision with root package name */
    public int f13956h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final u f13957i = new u(this, this);

    public h(d dVar) {
        super(dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r9 < r8) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final s.j d(boolean[] r12) {
        /*
            r11 = this;
            r0 = -1
            r1 = 0
            r2 = 0
            r3 = -1
        L_0x0004:
            int r4 = r11.f13956h
            if (r2 >= r4) goto L_0x005b
            s.j[] r4 = r11.f13954f
            r5 = r4[r2]
            int r6 = r5.f13960i
            boolean r6 = r12[r6]
            if (r6 == 0) goto L_0x0013
            goto L_0x0058
        L_0x0013:
            android.support.v4.media.session.u r6 = r11.f13957i
            r6.f428i = r5
            r5 = 1
            r7 = 8
            if (r3 != r0) goto L_0x0038
        L_0x001c:
            if (r7 < 0) goto L_0x0034
            java.lang.Object r4 = r6.f428i
            s.j r4 = (s.j) r4
            float[] r4 = r4.f13966o
            r4 = r4[r7]
            r8 = 0
            int r9 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r9 <= 0) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0031
            goto L_0x0035
        L_0x0031:
            int r7 = r7 + -1
            goto L_0x001c
        L_0x0034:
            r5 = 0
        L_0x0035:
            if (r5 == 0) goto L_0x0058
            goto L_0x0057
        L_0x0038:
            r4 = r4[r3]
        L_0x003a:
            if (r7 < 0) goto L_0x0054
            float[] r8 = r4.f13966o
            r8 = r8[r7]
            java.lang.Object r9 = r6.f428i
            s.j r9 = (s.j) r9
            float[] r9 = r9.f13966o
            r9 = r9[r7]
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x004f
            int r7 = r7 + -1
            goto L_0x003a
        L_0x004f:
            int r4 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r5 = 0
        L_0x0055:
            if (r5 == 0) goto L_0x0058
        L_0x0057:
            r3 = r2
        L_0x0058:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x005b:
            if (r3 != r0) goto L_0x005f
            r12 = 0
            return r12
        L_0x005f:
            s.j[] r12 = r11.f13954f
            r12 = r12[r3]
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: s.h.d(boolean[]):s.j");
    }

    public final boolean e() {
        return this.f13956h == 0;
    }

    public final void i(e eVar, c cVar, boolean z10) {
        boolean z11;
        c cVar2 = cVar;
        j jVar = cVar2.f13924a;
        if (jVar != null) {
            b bVar = cVar2.f13927d;
            int c10 = bVar.c();
            for (int i10 = 0; i10 < c10; i10++) {
                j f10 = bVar.f(i10);
                float a10 = bVar.a(i10);
                u uVar = this.f13957i;
                uVar.f428i = f10;
                boolean z12 = f10.f13959h;
                float[] fArr = jVar.f13966o;
                if (z12) {
                    boolean z13 = true;
                    for (int i11 = 0; i11 < 9; i11++) {
                        float[] fArr2 = ((j) uVar.f428i).f13966o;
                        float f11 = (fArr[i11] * a10) + fArr2[i11];
                        fArr2[i11] = f11;
                        if (Math.abs(f11) < 1.0E-4f) {
                            ((j) uVar.f428i).f13966o[i11] = 0.0f;
                        } else {
                            z13 = false;
                        }
                    }
                    if (z13) {
                        ((h) uVar.f430k).k((j) uVar.f428i);
                    }
                    z11 = false;
                } else {
                    for (int i12 = 0; i12 < 9; i12++) {
                        float f12 = fArr[i12];
                        if (f12 != 0.0f) {
                            float f13 = f12 * a10;
                            if (Math.abs(f13) < 1.0E-4f) {
                                f13 = 0.0f;
                            }
                            ((j) uVar.f428i).f13966o[i12] = f13;
                        } else {
                            ((j) uVar.f428i).f13966o[i12] = 0.0f;
                        }
                    }
                    z11 = true;
                }
                if (z11) {
                    j(f10);
                }
                this.f13925b = (cVar2.f13925b * a10) + this.f13925b;
            }
            k(jVar);
        }
    }

    public final void j(j jVar) {
        int i10;
        int i11 = this.f13956h + 1;
        j[] jVarArr = this.f13954f;
        if (i11 > jVarArr.length) {
            j[] jVarArr2 = (j[]) Arrays.copyOf(jVarArr, jVarArr.length * 2);
            this.f13954f = jVarArr2;
            this.f13955g = (j[]) Arrays.copyOf(jVarArr2, jVarArr2.length * 2);
        }
        j[] jVarArr3 = this.f13954f;
        int i12 = this.f13956h;
        jVarArr3[i12] = jVar;
        int i13 = i12 + 1;
        this.f13956h = i13;
        if (i13 > 1 && jVarArr3[i13 - 1].f13960i > jVar.f13960i) {
            int i14 = 0;
            while (true) {
                i10 = this.f13956h;
                if (i14 >= i10) {
                    break;
                }
                this.f13955g[i14] = this.f13954f[i14];
                i14++;
            }
            Arrays.sort(this.f13955g, 0, i10, new g(0, this));
            for (int i15 = 0; i15 < this.f13956h; i15++) {
                this.f13954f[i15] = this.f13955g[i15];
            }
        }
        jVar.f13959h = true;
        jVar.a(this);
    }

    public final void k(j jVar) {
        int i10 = 0;
        while (i10 < this.f13956h) {
            if (this.f13954f[i10] == jVar) {
                while (true) {
                    int i11 = this.f13956h;
                    if (i10 < i11 - 1) {
                        j[] jVarArr = this.f13954f;
                        int i12 = i10 + 1;
                        jVarArr[i10] = jVarArr[i12];
                        i10 = i12;
                    } else {
                        this.f13956h = i11 - 1;
                        jVar.f13959h = false;
                        return;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    public final String toString() {
        String str = " goal -> (" + this.f13925b + ") : ";
        for (int i10 = 0; i10 < this.f13956h; i10++) {
            j jVar = this.f13954f[i10];
            u uVar = this.f13957i;
            uVar.f428i = jVar;
            str = str + uVar + " ";
        }
        return str;
    }
}

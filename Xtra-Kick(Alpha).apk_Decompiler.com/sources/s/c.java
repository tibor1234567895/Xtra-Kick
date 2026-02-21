package s;

import java.util.ArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public j f13924a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f13925b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f13926c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public b f13927d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13928e = false;

    public c() {
    }

    public final void a(e eVar, int i10) {
        this.f13927d.b(eVar.k(i10), 1.0f);
        this.f13927d.b(eVar.k(i10), -1.0f);
    }

    public final void b(j jVar, j jVar2, j jVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f13925b = (float) i10;
        }
        if (!z10) {
            this.f13927d.b(jVar, -1.0f);
            this.f13927d.b(jVar2, 1.0f);
            this.f13927d.b(jVar3, 1.0f);
            return;
        }
        this.f13927d.b(jVar, 1.0f);
        this.f13927d.b(jVar2, -1.0f);
        this.f13927d.b(jVar3, -1.0f);
    }

    public final void c(j jVar, j jVar2, j jVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f13925b = (float) i10;
        }
        if (!z10) {
            this.f13927d.b(jVar, -1.0f);
            this.f13927d.b(jVar2, 1.0f);
            this.f13927d.b(jVar3, -1.0f);
            return;
        }
        this.f13927d.b(jVar, 1.0f);
        this.f13927d.b(jVar2, -1.0f);
        this.f13927d.b(jVar3, 1.0f);
    }

    public j d(boolean[] zArr) {
        return f(zArr, (j) null);
    }

    public boolean e() {
        return this.f13924a == null && this.f13925b == 0.0f && this.f13927d.c() == 0;
    }

    public final j f(boolean[] zArr, j jVar) {
        int i10;
        int c10 = this.f13927d.c();
        j jVar2 = null;
        float f10 = 0.0f;
        for (int i11 = 0; i11 < c10; i11++) {
            float a10 = this.f13927d.a(i11);
            if (a10 < 0.0f) {
                j f11 = this.f13927d.f(i11);
                if ((zArr == null || !zArr[f11.f13960i]) && f11 != jVar && (((i10 = f11.f13970s) == 3 || i10 == 4) && a10 < f10)) {
                    f10 = a10;
                    jVar2 = f11;
                }
            }
        }
        return jVar2;
    }

    public final void g(j jVar) {
        j jVar2 = this.f13924a;
        if (jVar2 != null) {
            this.f13927d.b(jVar2, -1.0f);
            this.f13924a.f13961j = -1;
            this.f13924a = null;
        }
        float e10 = this.f13927d.e(jVar, true) * -1.0f;
        this.f13924a = jVar;
        if (e10 != 1.0f) {
            this.f13925b /= e10;
            this.f13927d.i(e10);
        }
    }

    public final void h(e eVar, j jVar, boolean z10) {
        if (jVar != null && jVar.f13964m) {
            float g10 = this.f13927d.g(jVar);
            this.f13925b = (jVar.f13963l * g10) + this.f13925b;
            this.f13927d.e(jVar, z10);
            if (z10) {
                jVar.b(this);
            }
            if (this.f13927d.c() == 0) {
                this.f13928e = true;
                eVar.f13934a = true;
            }
        }
    }

    public void i(e eVar, c cVar, boolean z10) {
        float d10 = this.f13927d.d(cVar, z10);
        this.f13925b = (cVar.f13925b * d10) + this.f13925b;
        if (z10) {
            cVar.f13924a.b(this);
        }
        if (this.f13924a != null && this.f13927d.c() == 0) {
            this.f13928e = true;
            eVar.f13934a = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r8 = this;
            s.j r0 = r8.f13924a
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "0"
            goto L_0x0017
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            s.j r1 = r8.f13924a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0017:
            java.lang.String r1 = " = "
            java.lang.String r0 = q0.f.g(r0, r1)
            float r1 = r8.f13925b
            r2 = 0
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0034
            java.lang.StringBuilder r0 = android.support.v4.media.h.q(r0)
            float r1 = r8.f13925b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            goto L_0x0035
        L_0x0034:
            r1 = 0
        L_0x0035:
            s.b r4 = r8.f13927d
            int r4 = r4.c()
        L_0x003b:
            if (r2 >= r4) goto L_0x00a0
            s.b r5 = r8.f13927d
            s.j r5 = r5.f(r2)
            if (r5 != 0) goto L_0x0046
            goto L_0x009d
        L_0x0046:
            s.b r6 = r8.f13927d
            float r6 = r6.a(r2)
            int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0051
            goto L_0x009d
        L_0x0051:
            java.lang.String r5 = r5.toString()
            if (r1 != 0) goto L_0x0062
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x007f
            java.lang.StringBuilder r0 = android.support.v4.media.h.q(r0)
            java.lang.String r1 = "- "
            goto L_0x0074
        L_0x0062:
            java.lang.StringBuilder r0 = android.support.v4.media.h.q(r0)
            if (r7 <= 0) goto L_0x0072
            java.lang.String r1 = " + "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x007f
        L_0x0072:
            java.lang.String r1 = " - "
        L_0x0074:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r6 = r6 * r1
        L_0x007f:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x008b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x0098
        L_0x008b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = " "
        L_0x0098:
            java.lang.String r0 = android.support.v4.media.h.p(r1, r0, r5)
            r1 = 1
        L_0x009d:
            int r2 = r2 + 1
            goto L_0x003b
        L_0x00a0:
            if (r1 != 0) goto L_0x00a8
            java.lang.String r1 = "0.0"
            java.lang.String r0 = q0.f.g(r0, r1)
        L_0x00a8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s.c.toString():java.lang.String");
    }

    public c(d dVar) {
        this.f13927d = new a(this, dVar);
    }
}

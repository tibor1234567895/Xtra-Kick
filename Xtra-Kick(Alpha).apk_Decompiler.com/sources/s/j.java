package s;

import java.util.Arrays;

public final class j implements Comparable {

    /* renamed from: h  reason: collision with root package name */
    public boolean f13959h;

    /* renamed from: i  reason: collision with root package name */
    public int f13960i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f13961j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f13962k = 0;

    /* renamed from: l  reason: collision with root package name */
    public float f13963l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f13964m = false;

    /* renamed from: n  reason: collision with root package name */
    public final float[] f13965n = new float[9];

    /* renamed from: o  reason: collision with root package name */
    public final float[] f13966o = new float[9];

    /* renamed from: p  reason: collision with root package name */
    public c[] f13967p = new c[16];

    /* renamed from: q  reason: collision with root package name */
    public int f13968q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f13969r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f13970s;

    public j(int i10) {
        this.f13970s = i10;
    }

    public final void a(c cVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f13968q;
            if (i10 >= i11) {
                c[] cVarArr = this.f13967p;
                if (i11 >= cVarArr.length) {
                    this.f13967p = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
                }
                c[] cVarArr2 = this.f13967p;
                int i12 = this.f13968q;
                cVarArr2[i12] = cVar;
                this.f13968q = i12 + 1;
                return;
            } else if (this.f13967p[i10] != cVar) {
                i10++;
            } else {
                return;
            }
        }
    }

    public final void b(c cVar) {
        int i10 = this.f13968q;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f13967p[i11] == cVar) {
                while (i11 < i10 - 1) {
                    c[] cVarArr = this.f13967p;
                    int i12 = i11 + 1;
                    cVarArr[i11] = cVarArr[i12];
                    i11 = i12;
                }
                this.f13968q--;
                return;
            }
            i11++;
        }
    }

    public final void c() {
        this.f13970s = 5;
        this.f13962k = 0;
        this.f13960i = -1;
        this.f13961j = -1;
        this.f13963l = 0.0f;
        this.f13964m = false;
        int i10 = this.f13968q;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f13967p[i11] = null;
        }
        this.f13968q = 0;
        this.f13969r = 0;
        this.f13959h = false;
        Arrays.fill(this.f13966o, 0.0f);
    }

    public final int compareTo(Object obj) {
        return this.f13960i - ((j) obj).f13960i;
    }

    public final void d(e eVar, float f10) {
        this.f13963l = f10;
        this.f13964m = true;
        int i10 = this.f13968q;
        this.f13961j = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f13967p[i11].h(eVar, this, false);
        }
        this.f13968q = 0;
    }

    public final void e(e eVar, c cVar) {
        int i10 = this.f13968q;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f13967p[i11].i(eVar, cVar, false);
        }
        this.f13968q = 0;
    }

    public final String toString() {
        return "" + this.f13960i;
    }
}

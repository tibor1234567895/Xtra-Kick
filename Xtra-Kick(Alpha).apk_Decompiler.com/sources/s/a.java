package s;

import android.support.v4.media.h;
import java.util.Arrays;
import q0.f;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public int f13914a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final c f13915b;

    /* renamed from: c  reason: collision with root package name */
    public final d f13916c;

    /* renamed from: d  reason: collision with root package name */
    public int f13917d = 8;

    /* renamed from: e  reason: collision with root package name */
    public int[] f13918e = new int[8];

    /* renamed from: f  reason: collision with root package name */
    public int[] f13919f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public float[] f13920g = new float[8];

    /* renamed from: h  reason: collision with root package name */
    public int f13921h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f13922i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13923j = false;

    public a(c cVar, d dVar) {
        this.f13915b = cVar;
        this.f13916c = dVar;
    }

    public final float a(int i10) {
        int i11 = this.f13921h;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f13914a) {
            if (i12 == i10) {
                return this.f13920g[i11];
            }
            i11 = this.f13919f[i11];
            i12++;
        }
        return 0.0f;
    }

    public final void b(j jVar, float f10) {
        if (f10 == 0.0f) {
            e(jVar, true);
            return;
        }
        int i10 = this.f13921h;
        c cVar = this.f13915b;
        if (i10 == -1) {
            this.f13921h = 0;
            this.f13920g[0] = f10;
            this.f13918e[0] = jVar.f13960i;
            this.f13919f[0] = -1;
            jVar.f13969r++;
            jVar.a(cVar);
            this.f13914a++;
            if (!this.f13923j) {
                int i11 = this.f13922i + 1;
                this.f13922i = i11;
                int[] iArr = this.f13918e;
                if (i11 >= iArr.length) {
                    this.f13923j = true;
                    this.f13922i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = 0;
        int i13 = -1;
        while (i10 != -1 && i12 < this.f13914a) {
            int i14 = this.f13918e[i10];
            int i15 = jVar.f13960i;
            if (i14 == i15) {
                this.f13920g[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i13 = i10;
            }
            i10 = this.f13919f[i10];
            i12++;
        }
        int i16 = this.f13922i;
        int i17 = i16 + 1;
        if (this.f13923j) {
            int[] iArr2 = this.f13918e;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.f13918e;
        if (i16 >= iArr3.length && this.f13914a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f13918e;
                if (i18 >= iArr4.length) {
                    break;
                } else if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                } else {
                    i18++;
                }
            }
        }
        int[] iArr5 = this.f13918e;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.f13917d * 2;
            this.f13917d = i19;
            this.f13923j = false;
            this.f13922i = i16 - 1;
            this.f13920g = Arrays.copyOf(this.f13920g, i19);
            this.f13918e = Arrays.copyOf(this.f13918e, this.f13917d);
            this.f13919f = Arrays.copyOf(this.f13919f, this.f13917d);
        }
        this.f13918e[i16] = jVar.f13960i;
        this.f13920g[i16] = f10;
        int[] iArr6 = this.f13919f;
        if (i13 != -1) {
            iArr6[i16] = iArr6[i13];
            iArr6[i13] = i16;
        } else {
            iArr6[i16] = this.f13921h;
            this.f13921h = i16;
        }
        jVar.f13969r++;
        jVar.a(cVar);
        int i20 = this.f13914a + 1;
        this.f13914a = i20;
        if (!this.f13923j) {
            this.f13922i++;
        }
        int[] iArr7 = this.f13918e;
        if (i20 >= iArr7.length) {
            this.f13923j = true;
        }
        if (this.f13922i >= iArr7.length) {
            this.f13923j = true;
            this.f13922i = iArr7.length - 1;
        }
    }

    public final int c() {
        return this.f13914a;
    }

    public final void clear() {
        int i10 = this.f13921h;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f13914a) {
            j jVar = this.f13916c.f13931c[this.f13918e[i10]];
            if (jVar != null) {
                jVar.b(this.f13915b);
            }
            i10 = this.f13919f[i10];
            i11++;
        }
        this.f13921h = -1;
        this.f13922i = -1;
        this.f13923j = false;
        this.f13914a = 0;
    }

    public final float d(c cVar, boolean z10) {
        float g10 = g(cVar.f13924a);
        e(cVar.f13924a, z10);
        b bVar = cVar.f13927d;
        int c10 = bVar.c();
        for (int i10 = 0; i10 < c10; i10++) {
            j f10 = bVar.f(i10);
            j(f10, bVar.g(f10) * g10, z10);
        }
        return g10;
    }

    public final float e(j jVar, boolean z10) {
        int i10 = this.f13921h;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f13914a) {
            if (this.f13918e[i10] == jVar.f13960i) {
                if (i10 == this.f13921h) {
                    this.f13921h = this.f13919f[i10];
                } else {
                    int[] iArr = this.f13919f;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    jVar.b(this.f13915b);
                }
                jVar.f13969r--;
                this.f13914a--;
                this.f13918e[i10] = -1;
                if (this.f13923j) {
                    this.f13922i = i10;
                }
                return this.f13920g[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f13919f[i10];
        }
        return 0.0f;
    }

    public final j f(int i10) {
        int i11 = this.f13921h;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f13914a) {
            if (i12 == i10) {
                return this.f13916c.f13931c[this.f13918e[i11]];
            }
            i11 = this.f13919f[i11];
            i12++;
        }
        return null;
    }

    public final float g(j jVar) {
        int i10 = this.f13921h;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f13914a) {
            if (this.f13918e[i10] == jVar.f13960i) {
                return this.f13920g[i10];
            }
            i10 = this.f13919f[i10];
            i11++;
        }
        return 0.0f;
    }

    public final boolean h(j jVar) {
        int i10 = this.f13921h;
        if (i10 == -1) {
            return false;
        }
        int i11 = 0;
        while (i10 != -1 && i11 < this.f13914a) {
            if (this.f13918e[i10] == jVar.f13960i) {
                return true;
            }
            i10 = this.f13919f[i10];
            i11++;
        }
        return false;
    }

    public final void i(float f10) {
        int i10 = this.f13921h;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f13914a) {
            float[] fArr = this.f13920g;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f13919f[i10];
            i11++;
        }
    }

    public final void j(j jVar, float f10, boolean z10) {
        if (f10 <= -0.001f || f10 >= 0.001f) {
            int i10 = this.f13921h;
            c cVar = this.f13915b;
            if (i10 == -1) {
                this.f13921h = 0;
                this.f13920g[0] = f10;
                this.f13918e[0] = jVar.f13960i;
                this.f13919f[0] = -1;
                jVar.f13969r++;
                jVar.a(cVar);
                this.f13914a++;
                if (!this.f13923j) {
                    int i11 = this.f13922i + 1;
                    this.f13922i = i11;
                    int[] iArr = this.f13918e;
                    if (i11 >= iArr.length) {
                        this.f13923j = true;
                        this.f13922i = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            int i13 = -1;
            while (i10 != -1 && i12 < this.f13914a) {
                int i14 = this.f13918e[i10];
                int i15 = jVar.f13960i;
                if (i14 == i15) {
                    float[] fArr = this.f13920g;
                    float f11 = fArr[i10] + f10;
                    if (f11 > -0.001f && f11 < 0.001f) {
                        f11 = 0.0f;
                    }
                    fArr[i10] = f11;
                    if (f11 == 0.0f) {
                        if (i10 == this.f13921h) {
                            this.f13921h = this.f13919f[i10];
                        } else {
                            int[] iArr2 = this.f13919f;
                            iArr2[i13] = iArr2[i10];
                        }
                        if (z10) {
                            jVar.b(cVar);
                        }
                        if (this.f13923j) {
                            this.f13922i = i10;
                        }
                        jVar.f13969r--;
                        this.f13914a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i13 = i10;
                }
                i10 = this.f13919f[i10];
                i12++;
            }
            int i16 = this.f13922i;
            int i17 = i16 + 1;
            if (this.f13923j) {
                int[] iArr3 = this.f13918e;
                if (iArr3[i16] != -1) {
                    i16 = iArr3.length;
                }
            } else {
                i16 = i17;
            }
            int[] iArr4 = this.f13918e;
            if (i16 >= iArr4.length && this.f13914a < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.f13918e;
                    if (i18 >= iArr5.length) {
                        break;
                    } else if (iArr5[i18] == -1) {
                        i16 = i18;
                        break;
                    } else {
                        i18++;
                    }
                }
            }
            int[] iArr6 = this.f13918e;
            if (i16 >= iArr6.length) {
                i16 = iArr6.length;
                int i19 = this.f13917d * 2;
                this.f13917d = i19;
                this.f13923j = false;
                this.f13922i = i16 - 1;
                this.f13920g = Arrays.copyOf(this.f13920g, i19);
                this.f13918e = Arrays.copyOf(this.f13918e, this.f13917d);
                this.f13919f = Arrays.copyOf(this.f13919f, this.f13917d);
            }
            this.f13918e[i16] = jVar.f13960i;
            this.f13920g[i16] = f10;
            int[] iArr7 = this.f13919f;
            if (i13 != -1) {
                iArr7[i16] = iArr7[i13];
                iArr7[i13] = i16;
            } else {
                iArr7[i16] = this.f13921h;
                this.f13921h = i16;
            }
            jVar.f13969r++;
            jVar.a(cVar);
            this.f13914a++;
            if (!this.f13923j) {
                this.f13922i++;
            }
            int i20 = this.f13922i;
            int[] iArr8 = this.f13918e;
            if (i20 >= iArr8.length) {
                this.f13923j = true;
                this.f13922i = iArr8.length - 1;
            }
        }
    }

    public final void k() {
        int i10 = this.f13921h;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f13914a) {
            float[] fArr = this.f13920g;
            fArr[i10] = fArr[i10] * -1.0f;
            i10 = this.f13919f[i10];
            i11++;
        }
    }

    public final String toString() {
        int i10 = this.f13921h;
        String str = "";
        int i11 = 0;
        while (i10 != -1 && i11 < this.f13914a) {
            StringBuilder q10 = h.q(f.g(str, " -> "));
            q10.append(this.f13920g[i10]);
            q10.append(" : ");
            StringBuilder q11 = h.q(q10.toString());
            q11.append(this.f13916c.f13931c[this.f13918e[i10]]);
            str = q11.toString();
            i10 = this.f13919f[i10];
            i11++;
        }
        return str;
    }
}

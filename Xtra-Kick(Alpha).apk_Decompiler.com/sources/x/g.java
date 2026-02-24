package x;

import java.util.Arrays;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int[] f16404a = new int[10];

    /* renamed from: b  reason: collision with root package name */
    public int[] f16405b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    public int f16406c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int[] f16407d = new int[10];

    /* renamed from: e  reason: collision with root package name */
    public float[] f16408e = new float[10];

    /* renamed from: f  reason: collision with root package name */
    public int f16409f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int[] f16410g = new int[5];

    /* renamed from: h  reason: collision with root package name */
    public String[] f16411h = new String[5];

    /* renamed from: i  reason: collision with root package name */
    public int f16412i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int[] f16413j = new int[4];

    /* renamed from: k  reason: collision with root package name */
    public boolean[] f16414k = new boolean[4];

    /* renamed from: l  reason: collision with root package name */
    public int f16415l = 0;

    public final void a(int i10, float f10) {
        int i11 = this.f16409f;
        int[] iArr = this.f16407d;
        if (i11 >= iArr.length) {
            this.f16407d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f16408e;
            this.f16408e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f16407d;
        int i12 = this.f16409f;
        iArr2[i12] = i10;
        float[] fArr2 = this.f16408e;
        this.f16409f = i12 + 1;
        fArr2[i12] = f10;
    }

    public final void b(int i10, int i11) {
        int i12 = this.f16406c;
        int[] iArr = this.f16404a;
        if (i12 >= iArr.length) {
            this.f16404a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f16405b;
            this.f16405b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f16404a;
        int i13 = this.f16406c;
        iArr3[i13] = i10;
        int[] iArr4 = this.f16405b;
        this.f16406c = i13 + 1;
        iArr4[i13] = i11;
    }

    public final void c(int i10, String str) {
        int i11 = this.f16412i;
        int[] iArr = this.f16410g;
        if (i11 >= iArr.length) {
            this.f16410g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f16411h;
            this.f16411h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f16410g;
        int i12 = this.f16412i;
        iArr2[i12] = i10;
        String[] strArr2 = this.f16411h;
        this.f16412i = i12 + 1;
        strArr2[i12] = str;
    }

    public final void d(int i10, boolean z10) {
        int i11 = this.f16415l;
        int[] iArr = this.f16413j;
        if (i11 >= iArr.length) {
            this.f16413j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f16414k;
            this.f16414k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f16413j;
        int i12 = this.f16415l;
        iArr2[i12] = i10;
        boolean[] zArr2 = this.f16414k;
        this.f16415l = i12 + 1;
        zArr2[i12] = z10;
    }
}

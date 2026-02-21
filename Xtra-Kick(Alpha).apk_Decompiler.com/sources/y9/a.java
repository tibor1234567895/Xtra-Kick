package y9;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public double[] f17235a;

    /* renamed from: b  reason: collision with root package name */
    public int f17236b;

    /* renamed from: c  reason: collision with root package name */
    public int f17237c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17238d;

    public a() {
        this(0);
    }

    public static double b(a aVar) {
        int i10 = aVar.f17237c;
        int i11 = aVar.f17236b;
        int i12 = 1;
        int i13 = (i10 - i11) + 1;
        if (i13 < 1) {
            aVar.getClass();
            throw new IllegalArgumentException("inclusionCount cannot be less than 1.");
        } else if (i13 <= (i10 - i11) + 1) {
            double d10 = 0.0d;
            double d11 = 0.0d;
            if (1 <= i13) {
                while (true) {
                    d11 += (double) i12;
                    if (i12 == i13) {
                        break;
                    }
                    i12++;
                }
            }
            int i14 = aVar.f17237c;
            int i15 = i14 - (i13 - 1);
            if (i14 >= i15) {
                while (true) {
                    d10 += (((double) i13) / d11) * aVar.f17235a[i14];
                    i13--;
                    if (i14 == i15) {
                        break;
                    }
                    i14--;
                }
            }
            return d10;
        } else {
            throw new IllegalArgumentException("inclusionCount cannot be greater than the inserted value count.");
        }
    }

    public final void a(double d10) {
        int i10 = this.f17238d;
        if (i10 > 0) {
            int i11 = this.f17237c;
            int i12 = this.f17236b;
            if ((i11 - i12) + 1 == i10) {
                this.f17236b = i12 + 1;
            }
        }
        int i13 = this.f17237c;
        double[] dArr = this.f17235a;
        if (i13 == dArr.length - 1) {
            double[] dArr2 = new double[(dArr.length * 2)];
            int i14 = this.f17236b;
            int i15 = (i13 - i14) + 1;
            System.arraycopy(dArr, i14, dArr2, 0, i15);
            this.f17235a = dArr2;
            this.f17236b = 0;
            this.f17237c = i15 - 1;
        }
        int i16 = this.f17237c + 1;
        this.f17237c = i16;
        if (i16 == 0) {
            this.f17236b = i16;
        }
        this.f17235a[i16] = d10;
    }

    public a(int i10) {
        this.f17238d = i10;
        this.f17235a = new double[16];
        this.f17236b = -1;
        this.f17237c = -1;
    }
}

package j1;

import java.util.Arrays;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public long[] f8431a = new long[10];

    /* renamed from: b  reason: collision with root package name */
    public Object[] f8432b = new Object[10];

    /* renamed from: c  reason: collision with root package name */
    public int f8433c;

    /* renamed from: d  reason: collision with root package name */
    public int f8434d;

    public final synchronized void a(long j10, Object obj) {
        int i10 = this.f8434d;
        if (i10 > 0) {
            if (j10 <= this.f8431a[((this.f8433c + i10) - 1) % this.f8432b.length]) {
                b();
            }
        }
        c();
        int i11 = this.f8433c;
        int i12 = this.f8434d;
        Object[] objArr = this.f8432b;
        int length = (i11 + i12) % objArr.length;
        this.f8431a[length] = j10;
        objArr[length] = obj;
        this.f8434d = i12 + 1;
    }

    public final synchronized void b() {
        this.f8433c = 0;
        this.f8434d = 0;
        Arrays.fill(this.f8432b, (Object) null);
    }

    public final void c() {
        int length = this.f8432b.length;
        if (this.f8434d >= length) {
            int i10 = length * 2;
            long[] jArr = new long[i10];
            Object[] objArr = new Object[i10];
            int i11 = this.f8433c;
            int i12 = length - i11;
            System.arraycopy(this.f8431a, i11, jArr, 0, i12);
            System.arraycopy(this.f8432b, this.f8433c, objArr, 0, i12);
            int i13 = this.f8433c;
            if (i13 > 0) {
                System.arraycopy(this.f8431a, 0, jArr, i12, i13);
                System.arraycopy(this.f8432b, 0, objArr, i12, this.f8433c);
            }
            this.f8431a = jArr;
            this.f8432b = objArr;
            this.f8433c = 0;
        }
    }

    public final Object d(long j10, boolean z10) {
        Object obj = null;
        long j11 = Long.MAX_VALUE;
        while (this.f8434d > 0) {
            long j12 = j10 - this.f8431a[this.f8433c];
            if (j12 < 0 && (z10 || (-j12) >= j11)) {
                break;
            }
            obj = f();
            j11 = j12;
        }
        return obj;
    }

    public final synchronized Object e(long j10) {
        return d(j10, true);
    }

    public final Object f() {
        a.e(this.f8434d > 0);
        Object[] objArr = this.f8432b;
        int i10 = this.f8433c;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f8433c = (i10 + 1) % objArr.length;
        this.f8434d--;
        return obj;
    }
}

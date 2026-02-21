package ma;

import android.support.v4.media.h;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import wb.j0;
import xa.j;

public final class m0 extends f implements RandomAccess {

    /* renamed from: i  reason: collision with root package name */
    public final Object[] f10823i;

    /* renamed from: j  reason: collision with root package name */
    public final int f10824j;

    /* renamed from: k  reason: collision with root package name */
    public int f10825k;

    /* renamed from: l  reason: collision with root package name */
    public int f10826l;

    public m0(int i10, Object[] objArr) {
        boolean z10;
        this.f10823i = objArr;
        boolean z11 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i10 <= objArr.length ? true : z11) {
                this.f10824j = objArr.length;
                this.f10826l = i10;
                return;
            }
            StringBuilder r10 = h.r("ring buffer filled size: ", i10, " cannot be larger than the buffer size: ");
            r10.append(objArr.length);
            throw new IllegalArgumentException(r10.toString().toString());
        }
        throw new IllegalArgumentException(h.i("ring buffer filled size should not be negative but it is ", i10).toString());
    }

    public final int a() {
        return this.f10826l;
    }

    public final void b(int i10) {
        boolean z10;
        boolean z11 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i10 > this.f10826l) {
                z11 = false;
            }
            if (!z11) {
                StringBuilder r10 = h.r("n shouldn't be greater than the buffer size: n = ", i10, ", size = ");
                r10.append(this.f10826l);
                throw new IllegalArgumentException(r10.toString().toString());
            } else if (i10 > 0) {
                int i11 = this.f10825k;
                int i12 = this.f10824j;
                int i13 = (i11 + i10) % i12;
                Object[] objArr = this.f10823i;
                if (i11 > i13) {
                    o.f(objArr, (j0) null, i11, i12);
                    o.f(objArr, (j0) null, 0, i13);
                } else {
                    o.f(objArr, (j0) null, i11, i13);
                }
                this.f10825k = i13;
                this.f10826l -= i10;
            }
        } else {
            throw new IllegalArgumentException(h.i("n shouldn't be negative but it is ", i10).toString());
        }
    }

    public final Object get(int i10) {
        int i11 = this.f10826l;
        f.f10810h.getClass();
        c.a(i10, i11);
        return this.f10823i[(this.f10825k + i10) % this.f10824j];
    }

    public final Iterator iterator() {
        return new l0(this);
    }

    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    public final Object[] toArray(Object[] objArr) {
        Object[] objArr2;
        j.f("array", objArr);
        if (objArr.length < a()) {
            objArr = Arrays.copyOf(objArr, a());
            j.e("copyOf(this, newSize)", objArr);
        }
        int a10 = a();
        int i10 = this.f10825k;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            objArr2 = this.f10823i;
            if (i12 < a10 && i10 < this.f10824j) {
                objArr[i12] = objArr2[i10];
                i12++;
                i10++;
            }
        }
        while (i12 < a10) {
            objArr[i12] = objArr2[i11];
            i12++;
            i11++;
        }
        if (objArr.length > a()) {
            objArr[a()] = null;
        }
        return objArr;
    }
}

package g1;

import android.net.Uri;
import android.os.Bundle;
import j1.a;
import j1.l0;
import java.util.ArrayList;
import java.util.Arrays;

public final class b implements m {

    /* renamed from: p  reason: collision with root package name */
    public static final String f6290p = l0.C(0);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6291q = l0.C(1);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6292r = l0.C(2);

    /* renamed from: s  reason: collision with root package name */
    public static final String f6293s = l0.C(3);

    /* renamed from: t  reason: collision with root package name */
    public static final String f6294t = l0.C(4);

    /* renamed from: u  reason: collision with root package name */
    public static final String f6295u = l0.C(5);

    /* renamed from: v  reason: collision with root package name */
    public static final String f6296v = l0.C(6);

    /* renamed from: w  reason: collision with root package name */
    public static final String f6297w = l0.C(7);

    /* renamed from: x  reason: collision with root package name */
    public static final a f6298x = new a(1);

    /* renamed from: h  reason: collision with root package name */
    public final long f6299h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6300i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6301j;

    /* renamed from: k  reason: collision with root package name */
    public final Uri[] f6302k;

    /* renamed from: l  reason: collision with root package name */
    public final int[] f6303l;

    /* renamed from: m  reason: collision with root package name */
    public final long[] f6304m;

    /* renamed from: n  reason: collision with root package name */
    public final long f6305n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f6306o;

    public b(long j10, int i10, int i11, int[] iArr, Uri[] uriArr, long[] jArr, long j11, boolean z10) {
        a.b(iArr.length == uriArr.length);
        this.f6299h = j10;
        this.f6300i = i10;
        this.f6301j = i11;
        this.f6303l = iArr;
        this.f6302k = uriArr;
        this.f6304m = jArr;
        this.f6305n = j11;
        this.f6306o = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6299h == bVar.f6299h && this.f6300i == bVar.f6300i && this.f6301j == bVar.f6301j && Arrays.equals(this.f6302k, bVar.f6302k) && Arrays.equals(this.f6303l, bVar.f6303l) && Arrays.equals(this.f6304m, bVar.f6304m) && this.f6305n == bVar.f6305n && this.f6306o == bVar.f6306o;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putLong(f6290p, this.f6299h);
        bundle.putInt(f6291q, this.f6300i);
        bundle.putInt(f6297w, this.f6301j);
        bundle.putParcelableArrayList(f6292r, new ArrayList(Arrays.asList(this.f6302k)));
        bundle.putIntArray(f6293s, this.f6303l);
        bundle.putLongArray(f6294t, this.f6304m);
        bundle.putLong(f6295u, this.f6305n);
        bundle.putBoolean(f6296v, this.f6306o);
        return bundle;
    }

    public final int hashCode() {
        long j10 = this.f6299h;
        int hashCode = Arrays.hashCode(this.f6303l);
        int hashCode2 = Arrays.hashCode(this.f6304m);
        long j11 = this.f6305n;
        return ((((hashCode2 + ((hashCode + (((((((this.f6300i * 31) + this.f6301j) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Arrays.hashCode(this.f6302k)) * 31)) * 31)) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f6306o ? 1 : 0);
    }

    public final int i(int i10) {
        int i11;
        int i12 = i10 + 1;
        while (true) {
            int[] iArr = this.f6303l;
            if (i12 >= iArr.length || this.f6306o || (i11 = iArr[i12]) == 0 || i11 == 1) {
                return i12;
            }
            i12++;
        }
        return i12;
    }
}

package z1;

import android.os.Bundle;
import g1.m;
import i1.c;
import j1.l0;
import java.util.Arrays;

public final class k implements m {

    /* renamed from: k  reason: collision with root package name */
    public static final String f17433k = l0.C(0);

    /* renamed from: l  reason: collision with root package name */
    public static final String f17434l = l0.C(1);

    /* renamed from: m  reason: collision with root package name */
    public static final String f17435m = l0.C(2);

    /* renamed from: h  reason: collision with root package name */
    public final int f17436h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f17437i;

    /* renamed from: j  reason: collision with root package name */
    public final int f17438j;

    static {
        new c(16);
    }

    public k(int i10, int i11, int[] iArr) {
        this.f17436h = i10;
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.f17437i = copyOf;
        this.f17438j = i11;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f17436h == kVar.f17436h && Arrays.equals(this.f17437i, kVar.f17437i) && this.f17438j == kVar.f17438j;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f17433k, this.f17436h);
        bundle.putIntArray(f17434l, this.f17437i);
        bundle.putInt(f17435m, this.f17438j);
        return bundle;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f17437i) + (this.f17436h * 31)) * 31) + this.f17438j;
    }
}

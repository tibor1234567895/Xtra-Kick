package g1;

import android.os.Bundle;
import j1.a;
import j1.l0;
import java.util.Arrays;

public final class c1 extends l1 {

    /* renamed from: k  reason: collision with root package name */
    public static final String f6335k = l0.C(1);

    /* renamed from: l  reason: collision with root package name */
    public static final a f6336l = new a(12);

    /* renamed from: j  reason: collision with root package name */
    public final float f6337j;

    public c1() {
        this.f6337j = -1.0f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c1)) {
            return false;
        }
        return this.f6337j == ((c1) obj).f6337j;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(l1.f6454h, 1);
        bundle.putFloat(f6335k, this.f6337j);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f6337j)});
    }

    public final boolean i() {
        return this.f6337j != -1.0f;
    }

    public c1(float f10) {
        a.a("percent must be in the range of [0, 100]", f10 >= 0.0f && f10 <= 100.0f);
        this.f6337j = f10;
    }
}

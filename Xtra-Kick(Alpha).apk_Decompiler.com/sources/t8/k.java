package t8;

import android.graphics.RectF;
import java.util.Arrays;

public final class k implements c {

    /* renamed from: a  reason: collision with root package name */
    public final float f14763a;

    public k(float f10) {
        this.f14763a = f10;
    }

    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f14763a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f14763a == ((k) obj).f14763a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f14763a)});
    }
}

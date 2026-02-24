package t8;

import android.graphics.RectF;
import java.util.Arrays;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final float f14718a;

    public a(float f10) {
        this.f14718a = f10;
    }

    public final float a(RectF rectF) {
        return this.f14718a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f14718a == ((a) obj).f14718a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f14718a)});
    }
}

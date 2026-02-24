package t8;

import android.graphics.RectF;
import java.util.Arrays;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c f14719a;

    /* renamed from: b  reason: collision with root package name */
    public final float f14720b;

    public b(float f10, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f14719a;
            f10 += ((b) cVar).f14720b;
        }
        this.f14719a = cVar;
        this.f14720b = f10;
    }

    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f14719a.a(rectF) + this.f14720b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14719a.equals(bVar.f14719a) && this.f14720b == bVar.f14720b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f14719a, Float.valueOf(this.f14720b)});
    }
}

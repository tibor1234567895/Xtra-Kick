package m0;

import android.view.DisplayCutout;
import l0.b;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final DisplayCutout f10114a;

    public l(DisplayCutout displayCutout) {
        this.f10114a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return b.a(this.f10114a, ((l) obj).f10114a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f10114a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f10114a + "}";
    }
}

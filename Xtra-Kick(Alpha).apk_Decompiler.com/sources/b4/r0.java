package b4;

import android.view.View;
import android.view.WindowId;

public final class r0 implements s0 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f2587a;

    public r0(View view) {
        this.f2587a = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof r0) && ((r0) obj).f2587a.equals(this.f2587a);
    }

    public final int hashCode() {
        return this.f2587a.hashCode();
    }
}

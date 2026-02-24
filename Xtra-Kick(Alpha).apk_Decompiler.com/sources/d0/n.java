package d0;

import android.content.res.Resources;
import l0.b;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f4107a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources.Theme f4108b;

    public n(Resources resources, Resources.Theme theme) {
        this.f4107a = resources;
        this.f4108b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.f4107a.equals(nVar.f4107a) || !b.a(this.f4108b, nVar.f4108b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return b.b(this.f4107a, this.f4108b);
    }
}

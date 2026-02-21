package m0;

import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

public class j2 extends i2 {
    public j2(q2 q2Var, WindowInsets windowInsets) {
        super(q2Var, windowInsets);
    }

    public q2 a() {
        return q2.h((View) null, this.f10094c.consumeDisplayCutout());
    }

    public l e() {
        DisplayCutout h10 = this.f10094c.getDisplayCutout();
        if (h10 == null) {
            return null;
        }
        return new l(h10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j2)) {
            return false;
        }
        j2 j2Var = (j2) obj;
        return Objects.equals(this.f10094c, j2Var.f10094c) && Objects.equals(this.f10098g, j2Var.f10098g);
    }

    public int hashCode() {
        return this.f10094c.hashCode();
    }
}

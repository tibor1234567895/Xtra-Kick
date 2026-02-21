package g;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.t;

public class n0 extends t {
    public Dialog n0(Bundle bundle) {
        return new m0(v(), this.f1568i0);
    }

    public final void p0(Dialog dialog, int i10) {
        if (dialog instanceof m0) {
            m0 m0Var = (m0) dialog;
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            m0Var.e().v(1);
            return;
        }
        super.p0(dialog, i10);
    }
}

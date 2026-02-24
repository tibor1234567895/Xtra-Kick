package e1;

import android.content.Context;

public class e0 extends i0 {
    public e0(Context context) {
        super(context);
        this.f4914a = context;
    }

    public boolean a(h0 h0Var) {
        boolean z10;
        if (this.f4914a.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", h0Var.f4910b, h0Var.f4911c) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || super.a(h0Var)) {
            return true;
        }
        return false;
    }
}

package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import g.r0;
import java.util.Collections;
import java.util.List;
import p3.k;
import p3.m;
import x3.b;

public class ProfileInstallerInitializer implements b {
    public final Object a(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new m();
        }
        k.a(new r0(this, 29, context.getApplicationContext()));
        return new m();
    }

    public final List dependencies() {
        return Collections.emptyList();
    }
}

package android.support.v4.media;

import android.os.Binder;
import android.os.Build;

public abstract class r {
    public r() {
        new Binder();
        if (Build.VERSION.SDK_INT >= 26) {
            new q(this);
        } else {
            new p(this);
        }
    }
}

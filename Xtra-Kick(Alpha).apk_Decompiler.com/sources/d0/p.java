package d0;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import g.r0;

public abstract class p {
    public final void a(int i10) {
        new Handler(Looper.getMainLooper()).post(new o(this, i10, 0));
    }

    public final void b(Typeface typeface) {
        new Handler(Looper.getMainLooper()).post(new r0(this, 1, typeface));
    }

    public abstract void c(int i10);

    public abstract void d(Typeface typeface);
}

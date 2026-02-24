package e5;

import android.graphics.Bitmap;

public class d implements c {
    public final void a(int i10) {
    }

    public final Bitmap b(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    public final Bitmap d(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    public final void e() {
    }
}

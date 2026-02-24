package f0;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import androidx.activity.b;

public final class h {
    private h() {
    }

    public static Drawable a(Drawable drawable, Drawable drawable2) {
        b.D();
        return b.r(drawable, drawable2);
    }

    public static Icon b(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }
}

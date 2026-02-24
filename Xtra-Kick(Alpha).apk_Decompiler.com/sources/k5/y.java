package k5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import e5.c;
import java.util.concurrent.locks.Lock;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final x f9196a = new x();

    private y() {
    }

    /* JADX INFO: finally extract failed */
    public static d a(c cVar, Drawable drawable, int i10, int i11) {
        Bitmap bitmap;
        StringBuilder sb2;
        String str;
        Drawable current = drawable.getCurrent();
        boolean z10 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i10 == Integer.MIN_VALUE && current.getIntrinsicWidth() <= 0) {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    sb2 = new StringBuilder("Unable to draw ");
                    sb2.append(current);
                    str = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
                }
                bitmap = null;
                z10 = true;
            } else if (i11 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                if (current.getIntrinsicWidth() > 0) {
                    i10 = current.getIntrinsicWidth();
                }
                if (current.getIntrinsicHeight() > 0) {
                    i11 = current.getIntrinsicHeight();
                }
                Lock lock = g0.f9158d;
                lock.lock();
                Bitmap b10 = cVar.b(i10, i11, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(b10);
                    current.setBounds(0, 0, i10, i11);
                    current.draw(canvas);
                    canvas.setBitmap((Bitmap) null);
                    lock.unlock();
                    bitmap = b10;
                    z10 = true;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            } else {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    sb2 = new StringBuilder("Unable to draw ");
                    sb2.append(current);
                    str = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
                }
                bitmap = null;
                z10 = true;
            }
            sb2.append(str);
            Log.w("DrawableToBitmap", sb2.toString());
            bitmap = null;
            z10 = true;
        } else {
            bitmap = null;
        }
        if (!z10) {
            cVar = f9196a;
        }
        return d.c(bitmap, cVar);
    }
}

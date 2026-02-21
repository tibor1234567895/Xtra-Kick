package w4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import hb.h0;
import j4.i;
import xa.j;
import za.b;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f16085a = new g();

    private g() {
    }

    public static Bitmap a(Drawable drawable, Bitmap.Config config, t4.g gVar, int i10, boolean z10) {
        BitmapDrawable bitmapDrawable;
        int i11;
        int i12;
        int i13;
        int i14;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap.Config config2;
        boolean z11;
        int i15;
        int i16;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap3 = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config config3 = bitmap3.getConfig();
            if (config == null || h0.V0(config)) {
                config2 = Bitmap.Config.ARGB_8888;
            } else {
                config2 = config;
            }
            boolean z12 = true;
            if (config3 == config2) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (!z10) {
                    int width = bitmap3.getWidth();
                    int height = bitmap3.getHeight();
                    if (h0.Z0(gVar)) {
                        i15 = bitmap3.getWidth();
                    } else {
                        i15 = e.e(gVar.f14548a, i10);
                    }
                    if (h0.Z0(gVar)) {
                        i16 = bitmap3.getHeight();
                    } else {
                        i16 = e.e(gVar.f14549b, i10);
                    }
                    if (i.a(width, height, i15, i16, i10) != 1.0d) {
                        z12 = false;
                    }
                }
                if (z12) {
                    return bitmap3;
                }
            }
        }
        Drawable mutate = drawable.mutate();
        Bitmap.Config[] configArr = e.f16080a;
        boolean z13 = mutate instanceof BitmapDrawable;
        BitmapDrawable bitmapDrawable2 = null;
        if (z13) {
            bitmapDrawable = (BitmapDrawable) mutate;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable == null || (bitmap2 = bitmapDrawable.getBitmap()) == null) {
            i11 = mutate.getIntrinsicWidth();
        } else {
            i11 = bitmap2.getWidth();
        }
        int i17 = 512;
        if (i11 <= 0) {
            i11 = 512;
        }
        if (z13) {
            bitmapDrawable2 = (BitmapDrawable) mutate;
        }
        if (bitmapDrawable2 == null || (bitmap = bitmapDrawable2.getBitmap()) == null) {
            i12 = mutate.getIntrinsicHeight();
        } else {
            i12 = bitmap.getHeight();
        }
        if (i12 > 0) {
            i17 = i12;
        }
        if (h0.Z0(gVar)) {
            i13 = i11;
        } else {
            i13 = e.e(gVar.f14548a, i10);
        }
        if (h0.Z0(gVar)) {
            i14 = i17;
        } else {
            i14 = e.e(gVar.f14549b, i10);
        }
        double a10 = i.a(i11, i17, i13, i14, i10);
        int a11 = b.a(((double) i11) * a10);
        int a12 = b.a(a10 * ((double) i17));
        if (config == null || h0.V0(config)) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(a11, a12, config);
        j.e("createBitmap(width, height, config)", createBitmap);
        Rect bounds = mutate.getBounds();
        int i18 = bounds.left;
        int i19 = bounds.top;
        int i20 = bounds.right;
        int i21 = bounds.bottom;
        mutate.setBounds(0, 0, a11, a12);
        mutate.draw(new Canvas(createBitmap));
        mutate.setBounds(i18, i19, i20, i21);
        return createBitmap;
    }
}

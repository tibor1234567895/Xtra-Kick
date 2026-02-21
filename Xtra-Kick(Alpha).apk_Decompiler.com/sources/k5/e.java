package k5;

import android.graphics.Bitmap;
import b5.r;
import com.bumptech.glide.h;
import d5.o0;
import e5.c;
import w5.p;

public abstract class e implements r {
    public final o0 a(h hVar, o0 o0Var, int i10, int i11) {
        if (p.h(i10, i11)) {
            c cVar = com.bumptech.glide.c.a(hVar).f3164h;
            Bitmap bitmap = (Bitmap) o0Var.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap c10 = c(cVar, bitmap, i10, i11);
            if (bitmap.equals(c10)) {
                return o0Var;
            }
            return d.c(c10, cVar);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract Bitmap c(c cVar, Bitmap bitmap, int i10, int i11);
}

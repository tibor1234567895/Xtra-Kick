package k5;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import d5.o0;
import java.io.File;
import w5.n;
import w5.o;
import w5.p;

public final class h0 implements o0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9160h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f9161i;

    public /* synthetic */ h0(int i10, Object obj) {
        this.f9160h = i10;
        this.f9161i = obj;
    }

    public final int b() {
        int i10 = 1;
        int i11 = this.f9160h;
        Object obj = this.f9161i;
        switch (i11) {
            case 0:
                return p.c((Bitmap) obj);
            case 1:
                return ((byte[]) obj).length;
            case 2:
                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) obj;
                int y10 = animatedImageDrawable.getIntrinsicHeight() * animatedImageDrawable.getIntrinsicWidth();
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                char[] cArr = p.f16126a;
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                int i12 = o.f16125a[config.ordinal()];
                if (i12 != 1) {
                    if (i12 == 2 || i12 == 3) {
                        i10 = 2;
                    } else {
                        i10 = 4;
                        if (i12 == 4) {
                            i10 = 8;
                        }
                    }
                }
                return i10 * y10 * 2;
            default:
                return 1;
        }
    }

    public final Class d() {
        switch (this.f9160h) {
            case 0:
                return Bitmap.class;
            case 1:
                return byte[].class;
            case 2:
                return Drawable.class;
            default:
                return this.f9161i.getClass();
        }
    }

    public final void e() {
        switch (this.f9160h) {
            case 2:
                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) this.f9161i;
                animatedImageDrawable.stop();
                animatedImageDrawable.clearAnimationCallbacks();
                return;
            default:
                return;
        }
    }

    public final Object get() {
        int i10 = this.f9160h;
        Object obj = this.f9161i;
        switch (i10) {
            case 0:
                return (Bitmap) obj;
            case 1:
                return (byte[]) obj;
            case 2:
                return (AnimatedImageDrawable) obj;
            default:
                return obj;
        }
    }

    public h0(File file) {
        this.f9160h = 3;
        n.b(file);
        this.f9161i = file;
    }

    public h0(byte[] bArr) {
        this.f9160h = 1;
        n.b(bArr);
        this.f9161i = bArr;
    }
}

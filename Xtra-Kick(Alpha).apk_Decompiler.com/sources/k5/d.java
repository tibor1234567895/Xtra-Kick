package k5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import d5.j0;
import d5.o0;
import e5.c;
import w5.n;
import w5.p;

public final class d implements o0, j0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9142h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final Object f9143i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f9144j;

    public d(Resources resources, o0 o0Var) {
        n.b(resources);
        this.f9143i = resources;
        n.b(o0Var);
        this.f9144j = o0Var;
    }

    public static d c(Bitmap bitmap, c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, cVar);
    }

    public final void a() {
        switch (this.f9142h) {
            case 0:
                ((Bitmap) this.f9143i).prepareToDraw();
                return;
            default:
                o0 o0Var = (o0) this.f9144j;
                if (o0Var instanceof j0) {
                    ((j0) o0Var).a();
                    return;
                }
                return;
        }
    }

    public final int b() {
        switch (this.f9142h) {
            case 0:
                return p.c((Bitmap) this.f9143i);
            default:
                return ((o0) this.f9144j).b();
        }
    }

    public final Class d() {
        switch (this.f9142h) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    public final void e() {
        int i10 = this.f9142h;
        Object obj = this.f9144j;
        switch (i10) {
            case 0:
                ((c) obj).c((Bitmap) this.f9143i);
                return;
            default:
                ((o0) obj).e();
                return;
        }
    }

    public final Object get() {
        int i10 = this.f9142h;
        Object obj = this.f9143i;
        switch (i10) {
            case 0:
                return (Bitmap) obj;
            default:
                return new BitmapDrawable((Resources) obj, (Bitmap) ((o0) this.f9144j).get());
        }
    }

    public d(Bitmap bitmap, c cVar) {
        if (bitmap != null) {
            this.f9143i = bitmap;
            if (cVar != null) {
                this.f9144j = cVar;
                return;
            }
            throw new NullPointerException("BitmapPool must not be null");
        }
        throw new NullPointerException("Bitmap must not be null");
    }
}

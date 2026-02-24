package coil.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.h;
import u4.a;
import xa.j;

public abstract class GenericViewTarget<T extends View> implements h, a {

    /* renamed from: h  reason: collision with root package name */
    public boolean f3159h;

    public final void a(d0 d0Var) {
        j.f("owner", d0Var);
    }

    public final /* synthetic */ void b(d0 d0Var) {
        android.support.v4.media.h.b(d0Var);
    }

    public final void c(Drawable drawable) {
        n(drawable);
    }

    public final /* synthetic */ void f(d0 d0Var) {
    }

    public final void h(Drawable drawable) {
        n(drawable);
    }

    public final void i(Drawable drawable) {
        n(drawable);
    }

    public abstract Drawable j();

    public abstract void k();

    public abstract void l();

    public final void m() {
        Drawable j10 = j();
        Animatable animatable = j10 instanceof Animatable ? (Animatable) j10 : null;
        if (animatable != null) {
            if (this.f3159h) {
                animatable.start();
            } else {
                animatable.stop();
            }
        }
    }

    public final void n(Drawable drawable) {
        Drawable j10 = j();
        Animatable animatable = j10 instanceof Animatable ? (Animatable) j10 : null;
        if (animatable != null) {
            animatable.stop();
        }
        l();
        m();
    }

    public final /* synthetic */ void onDestroy(d0 d0Var) {
    }

    public final void onStart(d0 d0Var) {
        this.f3159h = true;
        m();
    }

    public final void onStop(d0 d0Var) {
        this.f3159h = false;
        m();
    }
}

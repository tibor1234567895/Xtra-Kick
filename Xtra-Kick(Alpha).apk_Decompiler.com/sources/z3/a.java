package z3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.o0;

public final class a extends ImageView {

    /* renamed from: h  reason: collision with root package name */
    public Animation.AnimationListener f17505h;

    /* renamed from: i  reason: collision with root package name */
    public int f17506i;

    public a(Context context) {
        super(context);
        float f10 = getContext().getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(y3.a.f16917a);
        this.f17506i = obtainStyledAttributes.getColor(0, -328966);
        obtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = c1.f10054a;
        o0.s(this, f10 * 4.0f);
        shapeDrawable.getPaint().setColor(this.f17506i);
        i0.q(this, shapeDrawable);
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f17505h;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f17505h;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public final void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
            this.f17506i = i10;
        }
    }
}

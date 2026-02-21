package l8;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import b4.e0;
import c0.g;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import r8.d;
import t8.i;

public final class n extends l {
    public StateListAnimator K;

    public n(FloatingActionButton floatingActionButton, e0 e0Var) {
        super(floatingActionButton, e0Var);
    }

    public final float e() {
        return this.f9748s.getElevation();
    }

    public final void f(Rect rect) {
        boolean z10;
        if (((FloatingActionButton) this.f9749t.f2538i).f3820r) {
            super.f(rect);
            return;
        }
        boolean z11 = this.f9735f;
        int i10 = 0;
        FloatingActionButton floatingActionButton = this.f9748s;
        if (!z11 || floatingActionButton.getSizeDimension() >= this.f9740k) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            i10 = (this.f9740k - floatingActionButton.getSizeDimension()) / 2;
        }
        rect.set(i10, i10, i10, i10);
    }

    public final void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable drawable;
        i s10 = s();
        this.f9731b = s10;
        s10.setTintList(colorStateList);
        if (mode != null) {
            this.f9731b.setTintMode(mode);
        }
        i iVar = this.f9731b;
        FloatingActionButton floatingActionButton = this.f9748s;
        iVar.i(floatingActionButton.getContext());
        if (i10 > 0) {
            Context context = floatingActionButton.getContext();
            t8.n nVar = this.f9730a;
            nVar.getClass();
            a aVar = new a(nVar);
            int b10 = g.b(context, R.color.design_fab_stroke_top_outer_color);
            int b11 = g.b(context, R.color.design_fab_stroke_top_inner_color);
            int b12 = g.b(context, R.color.design_fab_stroke_end_inner_color);
            int b13 = g.b(context, R.color.design_fab_stroke_end_outer_color);
            aVar.f9694i = b10;
            aVar.f9695j = b11;
            aVar.f9696k = b12;
            aVar.f9697l = b13;
            float f10 = (float) i10;
            if (aVar.f9693h != f10) {
                aVar.f9693h = f10;
                aVar.f9687b.setStrokeWidth(f10 * 1.3333f);
                aVar.f9699n = true;
                aVar.invalidateSelf();
            }
            if (colorStateList != null) {
                aVar.f9698m = colorStateList.getColorForState(aVar.getState(), aVar.f9698m);
            }
            aVar.f9701p = colorStateList;
            aVar.f9699n = true;
            aVar.invalidateSelf();
            this.f9733d = aVar;
            a aVar2 = this.f9733d;
            aVar2.getClass();
            i iVar2 = this.f9731b;
            iVar2.getClass();
            drawable = new LayerDrawable(new Drawable[]{aVar2, iVar2});
        } else {
            this.f9733d = null;
            drawable = this.f9731b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(d.c(colorStateList2), drawable, (Drawable) null);
        this.f9732c = rippleDrawable;
        this.f9734e = rippleDrawable;
    }

    public final void h() {
    }

    public final void i() {
        q();
    }

    public final void j(int[] iArr) {
        float f10;
        if (Build.VERSION.SDK_INT == 21) {
            FloatingActionButton floatingActionButton = this.f9748s;
            if (floatingActionButton.isEnabled()) {
                floatingActionButton.setElevation(this.f9737h);
                if (floatingActionButton.isPressed()) {
                    f10 = this.f9739j;
                } else if (floatingActionButton.isFocused() || floatingActionButton.isHovered()) {
                    f10 = this.f9738i;
                }
                floatingActionButton.setTranslationZ(f10);
                return;
            }
            floatingActionButton.setElevation(0.0f);
            floatingActionButton.setTranslationZ(0.0f);
        }
    }

    public final void k(float f10, float f11, float f12) {
        int i10 = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.f9748s;
        if (i10 == 21) {
            floatingActionButton.refreshDrawableState();
        } else if (floatingActionButton.getStateListAnimator() == this.K) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(l.E, r(f10, f12));
            stateListAnimator.addState(l.F, r(f10, f11));
            stateListAnimator.addState(l.G, r(f10, f11));
            stateListAnimator.addState(l.H, r(f10, f11));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", new float[]{f10}).setDuration(0));
            if (i10 >= 22 && i10 <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(l.f9729z);
            stateListAnimator.addState(l.I, animatorSet);
            stateListAnimator.addState(l.J, r(0.0f, 0.0f));
            this.K = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (o()) {
            q();
        }
    }

    public final void m(ColorStateList colorStateList) {
        Drawable drawable = this.f9732c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(d.c(colorStateList));
        } else {
            super.m(colorStateList);
        }
    }

    public final boolean o() {
        boolean z10;
        if (((FloatingActionButton) this.f9749t.f2538i).f3820r) {
            return true;
        }
        if (!this.f9735f || this.f9748s.getSizeDimension() >= this.f9740k) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return true;
        }
        return false;
    }

    public final void p() {
    }

    public final AnimatorSet r(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        FloatingActionButton floatingActionButton = this.f9748s;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", new float[]{f10}).setDuration(0)).with(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{f11}).setDuration(100));
        animatorSet.setInterpolator(l.f9729z);
        return animatorSet;
    }

    public final i s() {
        t8.n nVar = this.f9730a;
        nVar.getClass();
        return new m(nVar);
    }
}

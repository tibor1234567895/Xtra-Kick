package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.woxthebox.draglistview.R;
import h.a;
import q0.c0;
import q0.d0;

public class s0 extends RadioButton implements c0, d0 {

    /* renamed from: h  reason: collision with root package name */
    public final f0 f1042h;

    /* renamed from: i  reason: collision with root package name */
    public final b0 f1043i;

    /* renamed from: j  reason: collision with root package name */
    public final q1 f1044j;

    /* renamed from: k  reason: collision with root package name */
    public k0 f1045k;

    public s0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private k0 getEmojiTextViewHelper() {
        if (this.f1045k == null) {
            this.f1045k = new k0(this);
        }
        return this.f1045k;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f1043i;
        if (b0Var != null) {
            b0Var.a();
        }
        q1 q1Var = this.f1044j;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        f0 f0Var = this.f1042h;
        if (f0Var != null) {
            f0Var.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f1043i;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f1043i;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        f0 f0Var = this.f1042h;
        if (f0Var != null) {
            return f0Var.f813b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        f0 f0Var = this.f1042h;
        if (f0Var != null) {
            return f0Var.f814c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1044j.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1044j.e();
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f1043i;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f1043i;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public void setButtonDrawable(int i10) {
        setButtonDrawable(a.a(getContext(), i10));
    }

    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f1044j;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f1044j;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1043i;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1043i;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        f0 f0Var = this.f1042h;
        if (f0Var != null) {
            f0Var.f813b = colorStateList;
            f0Var.f815d = true;
            f0Var.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        f0 f0Var = this.f1042h;
        if (f0Var != null) {
            f0Var.f814c = mode;
            f0Var.f816e = true;
            f0Var.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        q1 q1Var = this.f1044j;
        q1Var.l(colorStateList);
        q1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        q1 q1Var = this.f1044j;
        q1Var.m(mode);
        q1Var.b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        r4.a(context);
        q4.a(getContext(), this);
        f0 f0Var = new f0(this, 1);
        this.f1042h = f0Var;
        f0Var.c(attributeSet, R.attr.radioButtonStyle);
        b0 b0Var = new b0(this);
        this.f1043i = b0Var;
        b0Var.e(attributeSet, R.attr.radioButtonStyle);
        q1 q1Var = new q1(this);
        this.f1044j = q1Var;
        q1Var.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.radioButtonStyle);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        f0 f0Var = this.f1042h;
        if (f0Var == null) {
            return;
        }
        if (f0Var.f817f) {
            f0Var.f817f = false;
            return;
        }
        f0Var.f817f = true;
        f0Var.a();
    }
}

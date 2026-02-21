package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.woxthebox.draglistview.R;
import h.a;
import q0.a0;
import q0.d0;

public final class e0 extends CheckedTextView implements d0 {

    /* renamed from: h  reason: collision with root package name */
    public final f0 f808h;

    /* renamed from: i  reason: collision with root package name */
    public final b0 f809i;

    /* renamed from: j  reason: collision with root package name */
    public final q1 f810j;

    /* renamed from: k  reason: collision with root package name */
    public k0 f811k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        r4.a(context);
        q4.a(getContext(), this);
        q1 q1Var = new q1(this);
        this.f810j = q1Var;
        q1Var.f(attributeSet, R.attr.checkedTextViewStyle);
        q1Var.b();
        b0 b0Var = new b0(this);
        this.f809i = b0Var;
        b0Var.e(attributeSet, R.attr.checkedTextViewStyle);
        f0 f0Var = new f0(this, 0);
        this.f808h = f0Var;
        f0Var.c(attributeSet, R.attr.checkedTextViewStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
    }

    private k0 getEmojiTextViewHelper() {
        if (this.f811k == null) {
            this.f811k = new k0(this);
        }
        return this.f811k;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        q1 q1Var = this.f810j;
        if (q1Var != null) {
            q1Var.b();
        }
        b0 b0Var = this.f809i;
        if (b0Var != null) {
            b0Var.a();
        }
        f0 f0Var = this.f808h;
        if (f0Var != null) {
            f0Var.b();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return a0.e(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f809i;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f809i;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        f0 f0Var = this.f808h;
        if (f0Var != null) {
            return f0Var.f813b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        f0 f0Var = this.f808h;
        if (f0Var != null) {
            return f0Var.f814c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f810j.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f810j.e();
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        l0.a(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f809i;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f809i;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(a.a(getContext(), i10));
    }

    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f810j;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f810j;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a0.f(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f809i;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f809i;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        f0 f0Var = this.f808h;
        if (f0Var != null) {
            f0Var.f813b = colorStateList;
            f0Var.f815d = true;
            f0Var.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        f0 f0Var = this.f808h;
        if (f0Var != null) {
            f0Var.f814c = mode;
            f0Var.f816e = true;
            f0Var.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        q1 q1Var = this.f810j;
        q1Var.l(colorStateList);
        q1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        q1 q1Var = this.f810j;
        q1Var.m(mode);
        q1Var.b();
    }

    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        q1 q1Var = this.f810j;
        if (q1Var != null) {
            q1Var.g(context, i10);
        }
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        f0 f0Var = this.f808h;
        if (f0Var == null) {
            return;
        }
        if (f0Var.f817f) {
            f0Var.f817f = false;
            return;
        }
        f0Var.f817f = true;
        f0Var.b();
    }
}

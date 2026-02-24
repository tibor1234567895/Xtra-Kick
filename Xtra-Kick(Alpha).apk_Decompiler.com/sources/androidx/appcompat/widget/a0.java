package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.media.n;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.woxthebox.draglistview.R;
import h.a;
import q0.d0;
import w0.b;
import w0.c;

public class a0 extends AutoCompleteTextView implements d0 {

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f717k = {16843126};

    /* renamed from: h  reason: collision with root package name */
    public final b0 f718h;

    /* renamed from: i  reason: collision with root package name */
    public final q1 f719i;

    /* renamed from: j  reason: collision with root package name */
    public final n f720j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        r4.a(context);
        q4.a(getContext(), this);
        u4 m10 = u4.m(getContext(), attributeSet, f717k, R.attr.autoCompleteTextViewStyle);
        if (m10.l(0)) {
            setDropDownBackgroundDrawable(m10.e(0));
        }
        m10.n();
        b0 b0Var = new b0(this);
        this.f718h = b0Var;
        b0Var.e(attributeSet, R.attr.autoCompleteTextViewStyle);
        q1 q1Var = new q1(this);
        this.f719i = q1Var;
        q1Var.f(attributeSet, R.attr.autoCompleteTextViewStyle);
        q1Var.b();
        n nVar = new n((EditText) this);
        this.f720j = nVar;
        nVar.v(attributeSet, R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener t10 = nVar.t(keyListener);
            if (t10 != keyListener) {
                super.setKeyListener(t10);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f718h;
        if (b0Var != null) {
            b0Var.a();
        }
        q1 q1Var = this.f719i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return q0.a0.e(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f718h;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f718h;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f719i.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f719i.e();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        l0.a(this, editorInfo, onCreateInputConnection);
        return this.f720j.x(onCreateInputConnection, editorInfo);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f718h;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f718h;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f719i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f719i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(q0.a0.f(callback, this));
    }

    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(a.a(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        ((b) ((c) this.f720j.f338j).f16019c).c(z10);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f720j.t(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f718h;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f718h;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        q1 q1Var = this.f719i;
        q1Var.l(colorStateList);
        q1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        q1 q1Var = this.f719i;
        q1Var.m(mode);
        q1Var.b();
    }

    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        q1 q1Var = this.f719i;
        if (q1Var != null) {
            q1Var.g(context, i10);
        }
    }
}

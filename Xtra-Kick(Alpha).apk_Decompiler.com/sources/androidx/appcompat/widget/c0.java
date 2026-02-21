package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import q0.a0;
import q0.d0;

public class c0 extends Button implements d0 {

    /* renamed from: h  reason: collision with root package name */
    public final b0 f775h;

    /* renamed from: i  reason: collision with root package name */
    public final q1 f776i;

    /* renamed from: j  reason: collision with root package name */
    public k0 f777j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        r4.a(context);
        q4.a(getContext(), this);
        b0 b0Var = new b0(this);
        this.f775h = b0Var;
        b0Var.e(attributeSet, i10);
        q1 q1Var = new q1(this);
        this.f776i = q1Var;
        q1Var.f(attributeSet, i10);
        q1Var.b();
        getEmojiTextViewHelper().b(attributeSet, i10);
    }

    private k0 getEmojiTextViewHelper() {
        if (this.f777j == null) {
            this.f777j = new k0(this);
        }
        return this.f777j;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f775h;
        if (b0Var != null) {
            b0Var.a();
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (l5.f925b) {
            return super.getAutoSizeMaxTextSize();
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            return Math.round(q1Var.f1005i.f744e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (l5.f925b) {
            return super.getAutoSizeMinTextSize();
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            return Math.round(q1Var.f1005i.f743d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (l5.f925b) {
            return super.getAutoSizeStepGranularity();
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            return Math.round(q1Var.f1005i.f742c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (l5.f925b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            return q1Var.f1005i.f745f;
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!l5.f925b) {
            q1 q1Var = this.f776i;
            if (q1Var != null) {
                return q1Var.f1005i.f740a;
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return a0.e(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f775h;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f775h;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f776i.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f776i.e();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        q1 q1Var = this.f776i;
        if (q1Var != null && !l5.f925b) {
            q1Var.f1005i.a();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        boolean z10;
        super.onTextChanged(charSequence, i10, i11, i12);
        boolean z11 = false;
        q1 q1Var = this.f776i;
        if (q1Var != null && !l5.f925b) {
            b2 b2Var = q1Var.f1005i;
            if (!b2Var.i() || b2Var.f740a == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                z11 = true;
            }
        }
        if (z11) {
            q1Var.f1005i.a();
        }
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    public final void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
        if (l5.f925b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            q1Var.i(i10, i11, i12, i13);
        }
    }

    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (l5.f925b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            q1Var.j(iArr, i10);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (l5.f925b) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            q1Var.k(i10);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f775h;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f775h;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a0.f(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            q1Var.f997a.setAllCaps(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f775h;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f775h;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        q1 q1Var = this.f776i;
        q1Var.l(colorStateList);
        q1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        q1 q1Var = this.f776i;
        q1Var.m(mode);
        q1Var.b();
    }

    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        q1 q1Var = this.f776i;
        if (q1Var != null) {
            q1Var.g(context, i10);
        }
    }

    public final void setTextSize(int i10, float f10) {
        boolean z10;
        boolean z11 = l5.f925b;
        if (z11) {
            super.setTextSize(i10, f10);
            return;
        }
        q1 q1Var = this.f776i;
        if (q1Var != null && !z11) {
            b2 b2Var = q1Var.f1005i;
            if (!b2Var.i() || b2Var.f740a == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                b2Var.f(i10, f10);
            }
        }
    }
}

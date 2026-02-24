package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.h;
import android.support.v4.media.n;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import e.a;
import e0.k;
import e0.r;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import k0.g;
import l0.f;
import q0.a0;
import q0.d0;

public class t1 extends TextView implements d0 {

    /* renamed from: h  reason: collision with root package name */
    public final b0 f1063h;

    /* renamed from: i  reason: collision with root package name */
    public final q1 f1064i;

    /* renamed from: j  reason: collision with root package name */
    public final n f1065j;

    /* renamed from: k  reason: collision with root package name */
    public k0 f1066k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1067l;

    /* renamed from: m  reason: collision with root package name */
    public a f1068m;

    /* renamed from: n  reason: collision with root package name */
    public Future f1069n;

    public t1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    private k0 getEmojiTextViewHelper() {
        if (this.f1066k == null) {
            this.f1066k = new k0(this);
        }
        return this.f1066k;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f1063h;
        if (b0Var != null) {
            b0Var.a();
        }
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (l5.f925b) {
            return super.getAutoSizeMaxTextSize();
        }
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            return Math.round(q1Var.f1005i.f744e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (l5.f925b) {
            return super.getAutoSizeMinTextSize();
        }
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            return Math.round(q1Var.f1005i.f743d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (l5.f925b) {
            return super.getAutoSizeStepGranularity();
        }
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            return Math.round(q1Var.f1005i.f742c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (l5.f925b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            return q1Var.f1005i.f745f;
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!l5.f925b) {
            q1 q1Var = this.f1064i;
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

    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public r1 getSuperCaller() {
        a aVar;
        if (this.f1068m == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                aVar = new s1(this);
            } else if (i10 >= 26) {
                aVar = new a(6, (Object) this);
            }
            this.f1068m = aVar;
        }
        return this.f1068m;
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f1063h;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f1063h;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1064i.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1064i.e();
    }

    public CharSequence getText() {
        Future future = this.f1069n;
        if (future != null) {
            try {
                this.f1069n = null;
                h.y(future.get());
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                a0.a(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        n nVar;
        if (Build.VERSION.SDK_INT >= 28 || (nVar = this.f1065j) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) nVar.f338j;
        if (textClassifier == null) {
            return i1.a((TextView) nVar.f337i);
        }
        return textClassifier;
    }

    public g getTextMetricsParamsCompat() {
        return a0.a(this);
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1064i.getClass();
        q1.h(this, onCreateInputConnection, editorInfo);
        l0.a(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        q1 q1Var = this.f1064i;
        if (q1Var != null && !l5.f925b) {
            q1Var.f1005i.a();
        }
    }

    public void onMeasure(int i10, int i11) {
        Future future = this.f1069n;
        if (future != null) {
            try {
                this.f1069n = null;
                h.y(future.get());
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                a0.a(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i10, i11);
    }

    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        boolean z10;
        super.onTextChanged(charSequence, i10, i11, i12);
        boolean z11 = false;
        q1 q1Var = this.f1064i;
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
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.i(i10, i11, i12, i13);
        }
    }

    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (l5.f925b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.j(iArr, i10);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (l5.f925b) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.k(i10);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f1063h;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f1063h;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable a10 = i10 != 0 ? h.a.a(context, i10) : null;
        Drawable a11 = i11 != 0 ? h.a.a(context, i11) : null;
        Drawable a12 = i12 != 0 ? h.a.a(context, i12) : null;
        if (i13 != 0) {
            drawable = h.a.a(context, i13);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(a10, a11, a12, drawable);
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable a10 = i10 != 0 ? h.a.a(context, i10) : null;
        Drawable a11 = i11 != 0 ? h.a.a(context, i11) : null;
        Drawable a12 = i12 != 0 ? h.a.a(context, i12) : null;
        if (i13 != 0) {
            drawable = h.a.a(context, i13);
        }
        setCompoundDrawablesWithIntrinsicBounds(a10, a11, a12, drawable);
        q1 q1Var = this.f1064i;
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

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().x(i10);
        } else {
            a0.b(this, i10);
        }
    }

    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().i(i10);
        } else {
            a0.c(this, i10);
        }
    }

    public void setLineHeight(int i10) {
        f.b(i10);
        int fontMetricsInt = getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i10 != fontMetricsInt) {
            setLineSpacing((float) (i10 - fontMetricsInt), 1.0f);
        }
    }

    public void setPrecomputedText(k0.h hVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        a0.a(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1063h;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1063h;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        q1 q1Var = this.f1064i;
        q1Var.l(colorStateList);
        q1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        q1 q1Var = this.f1064i;
        q1Var.m(mode);
        q1Var.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.g(context, i10);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        n nVar;
        if (Build.VERSION.SDK_INT >= 28 || (nVar = this.f1065j) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            nVar.f338j = textClassifier;
        }
    }

    public void setTextFuture(Future<k0.h> future) {
        this.f1069n = future;
        if (future != null) {
            requestLayout();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTextMetricsParamsCompat(k0.g r4) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            android.text.TextDirectionHeuristic r1 = r4.f8952b
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL
            if (r1 != r2) goto L_0x0009
            goto L_0x0032
        L_0x0009:
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            if (r1 != r2) goto L_0x000e
            goto L_0x0032
        L_0x000e:
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.ANYRTL_LTR
            if (r1 != r2) goto L_0x0014
            r1 = 2
            goto L_0x0033
        L_0x0014:
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.LTR
            if (r1 != r2) goto L_0x001a
            r1 = 3
            goto L_0x0033
        L_0x001a:
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.RTL
            if (r1 != r2) goto L_0x0020
            r1 = 4
            goto L_0x0033
        L_0x0020:
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.LOCALE
            if (r1 != r2) goto L_0x0026
            r1 = 5
            goto L_0x0033
        L_0x0026:
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            if (r1 != r2) goto L_0x002c
            r1 = 6
            goto L_0x0033
        L_0x002c:
            android.text.TextDirectionHeuristic r2 = android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL
            if (r1 != r2) goto L_0x0032
            r1 = 7
            goto L_0x0033
        L_0x0032:
            r1 = 1
        L_0x0033:
            q0.u.h(r3, r1)
            r1 = 23
            android.text.TextPaint r2 = r4.f8951a
            if (r0 >= r1) goto L_0x005d
            float r4 = r2.getTextScaleX()
            android.text.TextPaint r0 = r3.getPaint()
            r0.set(r2)
            float r0 = r3.getTextScaleX()
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0059
            r0 = 1073741824(0x40000000, float:2.0)
            float r0 = r4 / r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 + r1
            r3.setTextScaleX(r0)
        L_0x0059:
            r3.setTextScaleX(r4)
            goto L_0x006e
        L_0x005d:
            android.text.TextPaint r0 = r3.getPaint()
            r0.set(r2)
            int r0 = r4.f8953c
            q0.v.e(r3, r0)
            int r4 = r4.f8954d
            q0.v.h(r3, r4)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t1.setTextMetricsParamsCompat(k0.g):void");
    }

    public final void setTextSize(int i10, float f10) {
        boolean z10;
        boolean z11 = l5.f925b;
        if (z11) {
            super.setTextSize(i10, f10);
            return;
        }
        q1 q1Var = this.f1064i;
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

    public final void setTypeface(Typeface typeface, int i10) {
        Typeface typeface2;
        if (!this.f1067l) {
            if (typeface == null || i10 <= 0) {
                typeface2 = null;
            } else {
                Context context = getContext();
                r rVar = k.f4865a;
                if (context != null) {
                    typeface2 = Typeface.create(typeface, i10);
                } else {
                    throw new IllegalArgumentException("Context cannot be null");
                }
            }
            this.f1067l = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i10);
            } finally {
                this.f1067l = false;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t1(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        r4.a(context);
        this.f1067l = false;
        this.f1068m = null;
        q4.a(getContext(), this);
        b0 b0Var = new b0(this);
        this.f1063h = b0Var;
        b0Var.e(attributeSet, i10);
        q1 q1Var = new q1(this);
        this.f1064i = q1Var;
        q1Var.f(attributeSet, i10);
        q1Var.b();
        this.f1065j = new n((TextView) this);
        getEmojiTextViewHelper().b(attributeSet, i10);
    }

    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f1064i;
        if (q1Var != null) {
            q1Var.b();
        }
    }
}

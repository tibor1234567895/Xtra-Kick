package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.c0;
import b4.e0;
import c0.g;
import c8.a;
import c8.c;
import c8.d;
import com.woxthebox.draglistview.R;
import f0.b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;
import m8.r;
import m8.w;
import q0.u;
import t8.j;
import t8.n;
import t8.y;

public class MaterialButton extends c0 implements Checkable, y {

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f3691y = {16842911};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f3692z = {16842912};

    /* renamed from: k  reason: collision with root package name */
    public final d f3693k;

    /* renamed from: l  reason: collision with root package name */
    public final LinkedHashSet f3694l = new LinkedHashSet();

    /* renamed from: m  reason: collision with root package name */
    public a f3695m;

    /* renamed from: n  reason: collision with root package name */
    public PorterDuff.Mode f3696n;

    /* renamed from: o  reason: collision with root package name */
    public ColorStateList f3697o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f3698p;

    /* renamed from: q  reason: collision with root package name */
    public String f3699q;

    /* renamed from: r  reason: collision with root package name */
    public int f3700r;

    /* renamed from: s  reason: collision with root package name */
    public int f3701s;

    /* renamed from: t  reason: collision with root package name */
    public int f3702t;

    /* renamed from: u  reason: collision with root package name */
    public int f3703u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f3704v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3705w;

    /* renamed from: x  reason: collision with root package name */
    public int f3706x;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(a9.a.a(context, attributeSet, R.attr.materialButtonStyle, 2132018288), attributeSet, R.attr.materialButtonStyle);
        boolean z10 = false;
        this.f3704v = false;
        this.f3705w = false;
        Context context2 = getContext();
        TypedArray d10 = r.d(context2, attributeSet, v7.a.f15947p, R.attr.materialButtonStyle, 2132018288, new int[0]);
        this.f3703u = d10.getDimensionPixelSize(12, 0);
        this.f3696n = w.d(d10.getInt(15, -1), PorterDuff.Mode.SRC_IN);
        this.f3697o = q8.d.a(getContext(), d10, 14);
        this.f3698p = q8.d.c(getContext(), d10, 10);
        this.f3706x = d10.getInteger(11, 1);
        this.f3700r = d10.getDimensionPixelSize(13, 0);
        d dVar = new d(this, new n(n.b(context2, attributeSet, R.attr.materialButtonStyle, 2132018288)));
        this.f3693k = dVar;
        dVar.f3005c = d10.getDimensionPixelOffset(1, 0);
        dVar.f3006d = d10.getDimensionPixelOffset(2, 0);
        dVar.f3007e = d10.getDimensionPixelOffset(3, 0);
        dVar.f3008f = d10.getDimensionPixelOffset(4, 0);
        if (d10.hasValue(8)) {
            int dimensionPixelSize = d10.getDimensionPixelSize(8, -1);
            dVar.f3009g = dimensionPixelSize;
            dVar.c(dVar.f3004b.e((float) dimensionPixelSize));
            dVar.f3018p = true;
        }
        dVar.f3010h = d10.getDimensionPixelSize(20, 0);
        dVar.f3011i = w.d(d10.getInt(7, -1), PorterDuff.Mode.SRC_IN);
        dVar.f3012j = q8.d.a(getContext(), d10, 6);
        dVar.f3013k = q8.d.a(getContext(), d10, 19);
        dVar.f3014l = q8.d.a(getContext(), d10, 16);
        dVar.f3019q = d10.getBoolean(5, false);
        dVar.f3022t = d10.getDimensionPixelSize(9, 0);
        dVar.f3020r = d10.getBoolean(21, true);
        WeakHashMap weakHashMap = c1.f10054a;
        int f10 = j0.f(this);
        int paddingTop = getPaddingTop();
        int e10 = j0.e(this);
        int paddingBottom = getPaddingBottom();
        if (d10.hasValue(0)) {
            dVar.f3017o = true;
            setSupportBackgroundTintList(dVar.f3012j);
            setSupportBackgroundTintMode(dVar.f3011i);
        } else {
            dVar.e();
        }
        j0.k(this, f10 + dVar.f3005c, paddingTop + dVar.f3007e, e10 + dVar.f3006d, paddingBottom + dVar.f3008f);
        d10.recycle();
        setCompoundDrawablePadding(this.f3703u);
        c(this.f3698p != null ? true : z10);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < lineCount; i10++) {
            f10 = Math.max(f10, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil((double) f10);
    }

    public final boolean a() {
        d dVar = this.f3693k;
        if (dVar == null || dVar.f3017o) {
            return false;
        }
        return true;
    }

    public final void b() {
        boolean z10;
        boolean z11;
        int i10 = this.f3706x;
        boolean z12 = false;
        if (i10 == 1 || i10 == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            u.e(this, this.f3698p, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        if (i10 == 3 || i10 == 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            u.e(this, (Drawable) null, (Drawable) null, this.f3698p, (Drawable) null);
            return;
        }
        if (i10 == 16 || i10 == 32) {
            z12 = true;
        }
        if (z12) {
            u.e(this, (Drawable) null, this.f3698p, (Drawable) null, (Drawable) null);
        }
    }

    public final void c(boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        Drawable drawable = this.f3698p;
        boolean z14 = true;
        if (drawable != null) {
            Drawable mutate = f0.d.g(drawable).mutate();
            this.f3698p = mutate;
            b.h(mutate, this.f3697o);
            PorterDuff.Mode mode = this.f3696n;
            if (mode != null) {
                b.i(this.f3698p, mode);
            }
            int i10 = this.f3700r;
            if (i10 == 0) {
                i10 = this.f3698p.getIntrinsicWidth();
            }
            int i11 = this.f3700r;
            if (i11 == 0) {
                i11 = this.f3698p.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f3698p;
            int i12 = this.f3701s;
            int i13 = this.f3702t;
            drawable2.setBounds(i12, i13, i10 + i12, i11 + i13);
            this.f3698p.setVisible(true, z10);
        }
        if (z10) {
            b();
            return;
        }
        Drawable[] a10 = u.a(this);
        Drawable drawable3 = a10[0];
        Drawable drawable4 = a10[1];
        Drawable drawable5 = a10[2];
        int i14 = this.f3706x;
        if (i14 == 1 || i14 == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || drawable3 == this.f3698p) {
            if (i14 == 3 || i14 == 4) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12 || drawable5 == this.f3698p) {
                if (i14 == 16 || i14 == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13 || drawable4 == this.f3698p) {
                    z14 = false;
                }
            }
        }
        if (z14) {
            b();
        }
    }

    public final void d(int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.f3698p != null && getLayout() != null) {
            int i12 = this.f3706x;
            boolean z13 = true;
            if (i12 == 1 || i12 == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (i12 == 3 || i12 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    if (!(i12 == 16 || i12 == 32)) {
                        z13 = false;
                    }
                    if (z13) {
                        this.f3701s = 0;
                        if (i12 == 16) {
                            this.f3702t = 0;
                            c(false);
                            return;
                        }
                        int i13 = this.f3700r;
                        if (i13 == 0) {
                            i13 = this.f3698p.getIntrinsicHeight();
                        }
                        int max = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - i13) - this.f3703u) - getPaddingBottom()) / 2);
                        if (this.f3702t != max) {
                            this.f3702t = max;
                            c(false);
                        }
                        return;
                    }
                    return;
                }
            }
            this.f3702t = 0;
            Layout.Alignment actualTextAlignment = getActualTextAlignment();
            int i14 = this.f3706x;
            if (i14 == 1 || i14 == 3 || ((i14 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i14 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
                this.f3701s = 0;
                c(false);
                return;
            }
            int i15 = this.f3700r;
            if (i15 == 0) {
                i15 = this.f3698p.getIntrinsicWidth();
            }
            int textLayoutWidth = i10 - getTextLayoutWidth();
            WeakHashMap weakHashMap = c1.f10054a;
            int e10 = (((textLayoutWidth - j0.e(this)) - i15) - this.f3703u) - j0.f(this);
            if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                e10 /= 2;
            }
            if (j0.d(this) == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.f3706x != 4) {
                z13 = false;
            }
            if (z11 != z13) {
                e10 = -e10;
            }
            if (this.f3701s != e10) {
                this.f3701s = e10;
                c(false);
            }
        }
    }

    public String getA11yClassName() {
        boolean z10;
        Class cls;
        if (!TextUtils.isEmpty(this.f3699q)) {
            return this.f3699q;
        }
        d dVar = this.f3693k;
        if (dVar == null || !dVar.f3019q) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f3693k.f3009g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f3698p;
    }

    public int getIconGravity() {
        return this.f3706x;
    }

    public int getIconPadding() {
        return this.f3703u;
    }

    public int getIconSize() {
        return this.f3700r;
    }

    public ColorStateList getIconTint() {
        return this.f3697o;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f3696n;
    }

    public int getInsetBottom() {
        return this.f3693k.f3008f;
    }

    public int getInsetTop() {
        return this.f3693k.f3007e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f3693k.f3014l;
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        if (a()) {
            return this.f3693k.f3004b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f3693k.f3013k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f3693k.f3010h;
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (a()) {
            return this.f3693k.f3012j;
        }
        return super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (a()) {
            return this.f3693k.f3011i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public final boolean isChecked() {
        return this.f3704v;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            j.d(this, this.f3693k.b(false));
        }
    }

    public final int[] onCreateDrawableState(int i10) {
        boolean z10;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        d dVar = this.f3693k;
        if (dVar == null || !dVar.f3019q) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            View.mergeDrawableStates(onCreateDrawableState, f3691y);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f3692z);
        }
        return onCreateDrawableState;
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        d dVar = this.f3693k;
        if (dVar == null || !dVar.f3019q) {
            z10 = false;
        } else {
            z10 = true;
        }
        accessibilityNodeInfo.setCheckable(z10);
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        d dVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (Build.VERSION.SDK_INT == 21 && (dVar = this.f3693k) != null) {
            int i14 = i13 - i11;
            int i15 = i12 - i10;
            Drawable drawable = dVar.f3015m;
            if (drawable != null) {
                drawable.setBounds(dVar.f3005c, dVar.f3007e, i15 - dVar.f3006d, i14 - dVar.f3008f);
            }
        }
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.f14484h);
        setChecked(cVar.f3000j);
    }

    public final Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f3000j = this.f3704v;
        return cVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public final boolean performClick() {
        if (this.f3693k.f3020r) {
            toggle();
        }
        return super.performClick();
    }

    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f3698p != null) {
            if (this.f3698p.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f3699q = str;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i10) {
        if (a()) {
            d dVar = this.f3693k;
            if (dVar.b(false) != null) {
                dVar.b(false).setTint(i10);
                return;
            }
            return;
        }
        super.setBackgroundColor(i10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (a()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                d dVar = this.f3693k;
                dVar.f3017o = true;
                ColorStateList colorStateList = dVar.f3012j;
                MaterialButton materialButton = dVar.f3003a;
                materialButton.setSupportBackgroundTintList(colorStateList);
                materialButton.setSupportBackgroundTintMode(dVar.f3011i);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? h.a.a(getContext(), i10) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (a()) {
            this.f3693k.f3019q = z10;
        }
    }

    public void setChecked(boolean z10) {
        boolean z11;
        d dVar = this.f3693k;
        if (dVar == null || !dVar.f3019q) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && isEnabled() && this.f3704v != z10) {
            this.f3704v = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z12 = this.f3704v;
                if (!materialButtonToggleGroup.f3713m) {
                    materialButtonToggleGroup.b(getId(), z12);
                }
            }
            if (!this.f3705w) {
                this.f3705w = true;
                Iterator it = this.f3694l.iterator();
                if (!it.hasNext()) {
                    this.f3705w = false;
                } else {
                    h.y(it.next());
                    throw null;
                }
            }
        }
    }

    public void setCornerRadius(int i10) {
        if (a()) {
            d dVar = this.f3693k;
            if (!dVar.f3018p || dVar.f3009g != i10) {
                dVar.f3009g = i10;
                dVar.f3018p = true;
                dVar.c(dVar.f3004b.e((float) i10));
            }
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        if (a()) {
            this.f3693k.b(false).j(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f3698p != drawable) {
            this.f3698p = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f3706x != i10) {
            this.f3706x = i10;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f3703u != i10) {
            this.f3703u = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? h.a.a(getContext(), i10) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f3700r != i10) {
            this.f3700r = i10;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f3697o != colorStateList) {
            this.f3697o = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f3696n != mode) {
            this.f3696n = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(g.c(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        d dVar = this.f3693k;
        dVar.d(dVar.f3007e, i10);
    }

    public void setInsetTop(int i10) {
        d dVar = this.f3693k;
        dVar.d(i10, dVar.f3008f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(a aVar) {
        this.f3695m = aVar;
    }

    public void setPressed(boolean z10) {
        a aVar = this.f3695m;
        if (aVar != null) {
            ((MaterialButtonToggleGroup) ((e0) aVar).f2538i).invalidate();
        }
        super.setPressed(z10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            d dVar = this.f3693k;
            if (dVar.f3014l != colorStateList) {
                dVar.f3014l = colorStateList;
                boolean z10 = d.f3001u;
                MaterialButton materialButton = dVar.f3003a;
                if (z10 && (materialButton.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(r8.d.c(colorStateList));
                } else if (!z10 && (materialButton.getBackground() instanceof r8.b)) {
                    ((r8.b) materialButton.getBackground()).setTintList(r8.d.c(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i10) {
        if (a()) {
            setRippleColor(g.c(getContext(), i10));
        }
    }

    public void setShapeAppearanceModel(n nVar) {
        if (a()) {
            this.f3693k.c(nVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (a()) {
            d dVar = this.f3693k;
            dVar.f3016n = z10;
            dVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            d dVar = this.f3693k;
            if (dVar.f3013k != colorStateList) {
                dVar.f3013k = colorStateList;
                dVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i10) {
        if (a()) {
            setStrokeColor(g.c(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (a()) {
            d dVar = this.f3693k;
            if (dVar.f3010h != i10) {
                dVar.f3010h = i10;
                dVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (a()) {
            d dVar = this.f3693k;
            if (dVar.f3012j != colorStateList) {
                dVar.f3012j = colorStateList;
                if (dVar.b(false) != null) {
                    b.h(dVar.b(false), dVar.f3012j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (a()) {
            d dVar = this.f3693k;
            if (dVar.f3011i != mode) {
                dVar.f3011i = mode;
                if (dVar.b(false) != null && dVar.f3011i != null) {
                    b.i(dVar.b(false), dVar.f3011i);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f3693k.f3020r = z10;
    }

    public final void toggle() {
        setChecked(!this.f3704v);
    }
}

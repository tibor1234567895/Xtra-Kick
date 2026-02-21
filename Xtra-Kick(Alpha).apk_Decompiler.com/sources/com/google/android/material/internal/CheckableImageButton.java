package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.m0;
import com.woxthebox.draglistview.R;
import m0.c1;
import m8.b;
import o3.j0;

public class CheckableImageButton extends m0 implements Checkable {

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f3829n = {16842912};

    /* renamed from: k  reason: collision with root package name */
    public boolean f3830k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3831l = true;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3832m = true;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.imageButtonStyle);
        c1.p(this, new j0(3, this));
    }

    public final boolean isChecked() {
        return this.f3830k;
    }

    public final int[] onCreateDrawableState(int i10) {
        return this.f3830k ? View.mergeDrawableStates(super.onCreateDrawableState(i10 + 1), f3829n) : super.onCreateDrawableState(i10);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f14484h);
        setChecked(bVar.f10716j);
    }

    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f10716j = this.f3830k;
        return bVar;
    }

    public void setCheckable(boolean z10) {
        if (this.f3831l != z10) {
            this.f3831l = z10;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z10) {
        if (this.f3831l && this.f3830k != z10) {
            this.f3830k = z10;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z10) {
        this.f3832m = z10;
    }

    public void setPressed(boolean z10) {
        if (this.f3832m) {
            super.setPressed(z10);
        }
    }

    public final void toggle() {
        setChecked(!this.f3830k);
    }
}

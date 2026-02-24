package com.google.android.material.appbar;

import a9.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.woxthebox.draglistview.R;
import f0.b;
import f0.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import m.o;
import m0.c1;
import m0.i0;
import m0.o0;
import m8.r;
import m8.s;
import m8.t;
import t8.i;
import t8.j;

public class MaterialToolbar extends Toolbar {

    /* renamed from: g0  reason: collision with root package name */
    public static final ImageView.ScaleType[] f3623g0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: b0  reason: collision with root package name */
    public Integer f3624b0;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f3625c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f3626d0;

    /* renamed from: e0  reason: collision with root package name */
    public ImageView.ScaleType f3627e0;

    /* renamed from: f0  reason: collision with root package name */
    public Boolean f3628f0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.toolbarStyle, 2132018388), attributeSet, 0);
        int i10 = 0;
        Context context2 = getContext();
        TypedArray d10 = r.d(context2, attributeSet, v7.a.f15956y, R.attr.toolbarStyle, 2132018388, new int[0]);
        if (d10.hasValue(2)) {
            setNavigationIconTint(d10.getColor(2, -1));
        }
        this.f3625c0 = d10.getBoolean(4, false);
        this.f3626d0 = d10.getBoolean(3, false);
        int i11 = d10.getInt(1, -1);
        if (i11 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f3623g0;
            if (i11 < scaleTypeArr.length) {
                this.f3627e0 = scaleTypeArr[i11];
            }
        }
        if (d10.hasValue(0)) {
            this.f3628f0 = Boolean.valueOf(d10.getBoolean(0, false));
        }
        d10.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            i iVar = new i();
            iVar.k(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : i10));
            iVar.i(context2);
            WeakHashMap weakHashMap = c1.f10054a;
            iVar.j(o0.i(this));
            i0.q(this, iVar);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f3627e0;
    }

    public Integer getNavigationIconTint() {
        return this.f3624b0;
    }

    public final void k(int i10) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof o;
        if (z10) {
            ((o) menu).x();
        }
        super.k(i10);
        if (z10) {
            ((o) menu).w();
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.c(this);
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        ImageView imageView;
        Drawable drawable;
        TextView textView;
        TextView textView2;
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = 0;
        ImageView imageView2 = null;
        if (this.f3625c0 || this.f3626d0) {
            s sVar = t.f10795a;
            ArrayList a10 = t.a(this, getTitle());
            if (a10.isEmpty()) {
                textView = null;
            } else {
                textView = (TextView) Collections.min(a10, t.f10795a);
            }
            ArrayList a11 = t.a(this, getSubtitle());
            if (a11.isEmpty()) {
                textView2 = null;
            } else {
                textView2 = (TextView) Collections.max(a11, t.f10795a);
            }
            if (!(textView == null && textView2 == null)) {
                int measuredWidth = getMeasuredWidth();
                int i15 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i16 = 0; i16 < getChildCount(); i16++) {
                    View childAt = getChildAt(i16);
                    if (!(childAt.getVisibility() == 8 || childAt == textView || childAt == textView2)) {
                        if (childAt.getRight() < i15 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i15 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f3625c0 && textView != null) {
                    t(textView, pair);
                }
                if (this.f3626d0 && textView2 != null) {
                    t(textView2, pair);
                }
            }
        }
        s sVar2 = t.f10795a;
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i14 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i14);
                if ((childAt2 instanceof ImageView) && (drawable = imageView.getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = (ImageView) childAt2;
                    break;
                }
                i14++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f3628f0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f3627e0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        j.b(this, f10);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f3628f0;
        if (bool == null || bool.booleanValue() != z10) {
            this.f3628f0 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f3627e0 != scaleType) {
            this.f3627e0 = scaleType;
            requestLayout();
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (!(drawable == null || this.f3624b0 == null)) {
            drawable = d.g(drawable.mutate());
            b.g(drawable, this.f3624b0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i10) {
        this.f3624b0 = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f3626d0 != z10) {
            this.f3626d0 = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f3625c0 != z10) {
            this.f3625c0 = z10;
            requestLayout();
        }
    }

    public final void t(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i10 += max;
            i11 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i10, textView.getTop(), i11, textView.getBottom());
    }
}

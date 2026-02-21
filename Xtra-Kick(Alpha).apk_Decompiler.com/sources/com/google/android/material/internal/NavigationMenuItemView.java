package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.f5;
import androidx.appcompat.widget.s2;
import com.woxthebox.draglistview.R;
import d0.k;
import d0.s;
import f0.b;
import f0.d;
import java.util.WeakHashMap;
import m.d0;
import m.q;
import m0.c1;
import m0.i0;
import m8.g;
import o3.j0;
import q0.a0;
import q0.u;

public class NavigationMenuItemView extends g implements d0 {
    public static final int[] M = {16842912};
    public int C;
    public boolean D;
    public boolean E;
    public final CheckedTextView F;
    public FrameLayout G;
    public q H;
    public ColorStateList I;
    public boolean J;
    public Drawable K;
    public final j0 L;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j0 j0Var = new j0(4, this);
        this.L = j0Var;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.F = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        c1.p(checkedTextView, j0Var);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.G == null) {
                this.G = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.G.removeAllViews();
            this.G.addView(view);
        }
    }

    public final void b(q qVar) {
        int i10;
        s2 s2Var;
        int i11;
        StateListDrawable stateListDrawable;
        this.H = qVar;
        int i12 = qVar.f9999a;
        if (i12 > 0) {
            setId(i12);
        }
        if (qVar.isVisible()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        setVisibility(i10);
        boolean z10 = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(M, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = c1.f10054a;
            i0.q(this, stateListDrawable);
        }
        setCheckable(qVar.isCheckable());
        setChecked(qVar.isChecked());
        setEnabled(qVar.isEnabled());
        setTitle(qVar.f10003e);
        setIcon(qVar.getIcon());
        setActionView(qVar.getActionView());
        setContentDescription(qVar.f10015q);
        f5.a(this, qVar.f10016r);
        q qVar2 = this.H;
        if (!(qVar2.f10003e == null && qVar2.getIcon() == null && this.H.getActionView() != null)) {
            z10 = false;
        }
        CheckedTextView checkedTextView = this.F;
        if (z10) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.G;
            if (frameLayout != null) {
                s2Var = (s2) frameLayout.getLayoutParams();
                i11 = -1;
            } else {
                return;
            }
        } else {
            checkedTextView.setVisibility(0);
            FrameLayout frameLayout2 = this.G;
            if (frameLayout2 != null) {
                s2Var = (s2) frameLayout2.getLayoutParams();
                i11 = -2;
            } else {
                return;
            }
        }
        s2Var.width = i11;
        this.G.setLayoutParams(s2Var);
    }

    public q getItemData() {
        return this.H;
    }

    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        q qVar = this.H;
        if (qVar != null && qVar.isCheckable() && this.H.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, M);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.E != z10) {
            this.E = z10;
            this.L.h(this.F, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.F;
        checkedTextView.setChecked(z10);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), z10 ? 1 : 0);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.J) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = d.g(drawable).mutate();
                b.h(drawable, this.I);
            }
            int i10 = this.C;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.D) {
            if (this.K == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = s.f4115a;
                Drawable a10 = k.a(resources, R.drawable.navigation_empty_icon, theme);
                this.K = a10;
                if (a10 != null) {
                    int i11 = this.C;
                    a10.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.K;
        }
        u.e(this.F, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconPadding(int i10) {
        this.F.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.C = i10;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.I = colorStateList;
        this.J = colorStateList != null;
        q qVar = this.H;
        if (qVar != null) {
            setIcon(qVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.F.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.D = z10;
    }

    public void setTextAppearance(int i10) {
        a0.d(this.F, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.F.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.F.setText(charSequence);
    }
}

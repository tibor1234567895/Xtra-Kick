package y8;

import a9.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.b3;
import androidx.appcompat.widget.b4;
import androidx.appcompat.widget.q0;
import com.google.android.material.textfield.TextInputLayout;
import com.woxthebox.draglistview.R;
import java.util.Locale;
import m8.r;
import q8.d;

public final class t extends a0 {

    /* renamed from: l  reason: collision with root package name */
    public final b3 f17212l;

    /* renamed from: m  reason: collision with root package name */
    public final AccessibilityManager f17213m;

    /* renamed from: n  reason: collision with root package name */
    public final Rect f17214n = new Rect();

    /* renamed from: o  reason: collision with root package name */
    public final int f17215o;

    /* renamed from: p  reason: collision with root package name */
    public final float f17216p;

    /* renamed from: q  reason: collision with root package name */
    public int f17217q;

    /* renamed from: r  reason: collision with root package name */
    public ColorStateList f17218r;

    public t(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet);
        Context context2 = getContext();
        TypedArray d10 = r.d(context2, attributeSet, v7.a.f15946o, R.attr.autoCompleteTextViewStyle, 2132018030, new int[0]);
        if (d10.hasValue(0) && d10.getInt(0, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.f17215o = d10.getResourceId(2, R.layout.mtrl_auto_complete_simple_item);
        this.f17216p = (float) d10.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        this.f17217q = d10.getColor(3, 0);
        this.f17218r = d.a(context2, d10, 4);
        this.f17213m = (AccessibilityManager) context2.getSystemService("accessibility");
        b3 b3Var = new b3(context2);
        this.f17212l = b3Var;
        b3Var.F = true;
        q0 q0Var = b3Var.G;
        q0Var.setFocusable(true);
        b3Var.f765v = this;
        q0Var.setInputMethodMode(2);
        b3Var.p(getAdapter());
        b3Var.f766w = new b4(this, 1);
        if (d10.hasValue(5)) {
            setSimpleItems(d10.getResourceId(5, 0));
        }
        d10.recycle();
    }

    public static void a(t tVar, Object obj) {
        tVar.setText(tVar.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final void dismissDropDown() {
        boolean z10;
        AccessibilityManager accessibilityManager = this.f17213m;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.f17212l.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public CharSequence getHint() {
        TextInputLayout b10 = b();
        if (b10 == null || !b10.J) {
            return super.getHint();
        }
        return b10.getHint();
    }

    public float getPopupElevation() {
        return this.f17216p;
    }

    public int getSimpleItemSelectedColor() {
        return this.f17217q;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f17218r;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b10 = b();
        if (b10 != null && b10.J && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17212l.dismiss();
    }

    public final void onMeasure(int i10, int i11) {
        int i12;
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b10 = b();
            int i13 = 0;
            if (!(adapter == null || b10 == null)) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                b3 b3Var = this.f17212l;
                if (!b3Var.b()) {
                    i12 = -1;
                } else {
                    i12 = b3Var.f753j.getSelectedItemPosition();
                }
                int min = Math.min(adapter.getCount(), Math.max(0, i12) + 15);
                View view = null;
                int i14 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i13) {
                        view = null;
                        i13 = itemViewType;
                    }
                    view = adapter.getView(max, view, b10);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i14 = Math.max(i14, view.getMeasuredWidth());
                }
                Drawable e10 = b3Var.e();
                if (e10 != null) {
                    Rect rect = this.f17214n;
                    e10.getPadding(rect);
                    i14 += rect.left + rect.right;
                }
                i13 = b10.getEndIconView().getMeasuredWidth() + i14;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i13), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public final void onWindowFocusChanged(boolean z10) {
        boolean z11;
        AccessibilityManager accessibilityManager = this.f17213m;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            super.onWindowFocusChanged(z10);
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f17212l.p(getAdapter());
    }

    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        b3 b3Var = this.f17212l;
        if (b3Var != null) {
            b3Var.i(drawable);
        }
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f17212l.f767x = getOnItemSelectedListener();
    }

    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        TextInputLayout b10 = b();
        if (b10 != null) {
            b10.q();
        }
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f17217q = i10;
        if (getAdapter() instanceof s) {
            ((s) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f17218r = colorStateList;
        if (getAdapter() instanceof s) {
            ((s) getAdapter()).a();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    public final void showDropDown() {
        boolean z10;
        AccessibilityManager accessibilityManager = this.f17213m;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.f17212l.d();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new s(this, getContext(), this.f17215o, strArr));
    }
}

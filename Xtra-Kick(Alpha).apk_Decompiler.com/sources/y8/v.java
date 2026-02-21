package y8;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.t1;
import androidx.appcompat.widget.u4;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.woxthebox.draglistview.R;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;
import m0.l0;
import m0.p;
import m8.w;
import q0.a0;
import q8.d;

public final class v extends LinearLayout {

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f17222h;

    /* renamed from: i  reason: collision with root package name */
    public final t1 f17223i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f17224j;

    /* renamed from: k  reason: collision with root package name */
    public final CheckableImageButton f17225k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f17226l;

    /* renamed from: m  reason: collision with root package name */
    public PorterDuff.Mode f17227m;

    /* renamed from: n  reason: collision with root package name */
    public int f17228n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView.ScaleType f17229o;

    /* renamed from: p  reason: collision with root package name */
    public View.OnLongClickListener f17230p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f17231q;

    public v(TextInputLayout textInputLayout, u4 u4Var) {
        super(textInputLayout.getContext());
        CharSequence k10;
        this.f17222h = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this, false);
        this.f17225k = checkableImageButton;
        p.d(checkableImageButton);
        CharSequence charSequence = null;
        t1 t1Var = new t1(getContext(), (AttributeSet) null);
        this.f17223i = t1Var;
        if (d.d(getContext())) {
            p.g((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.f17230p;
        checkableImageButton.setOnClickListener((View.OnClickListener) null);
        p.e(checkableImageButton, onLongClickListener);
        this.f17230p = null;
        checkableImageButton.setOnLongClickListener((View.OnLongClickListener) null);
        p.e(checkableImageButton, (View.OnLongClickListener) null);
        if (u4Var.l(67)) {
            this.f17226l = d.b(getContext(), u4Var, 67);
        }
        if (u4Var.l(68)) {
            this.f17227m = w.d(u4Var.h(68, -1), (PorterDuff.Mode) null);
        }
        if (u4Var.l(64)) {
            a(u4Var.e(64));
            if (u4Var.l(63) && checkableImageButton.getContentDescription() != (k10 = u4Var.k(63))) {
                checkableImageButton.setContentDescription(k10);
            }
            checkableImageButton.setCheckable(u4Var.a(62, true));
        }
        int d10 = u4Var.d(65, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (d10 >= 0) {
            if (d10 != this.f17228n) {
                this.f17228n = d10;
                checkableImageButton.setMinimumWidth(d10);
                checkableImageButton.setMinimumHeight(d10);
            }
            if (u4Var.l(66)) {
                ImageView.ScaleType b10 = p.b(u4Var.h(66, -1));
                this.f17229o = b10;
                checkableImageButton.setScaleType(b10);
            }
            t1Var.setVisibility(8);
            t1Var.setId(R.id.textinput_prefix_text);
            t1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            WeakHashMap weakHashMap = c1.f10054a;
            l0.f(t1Var, 1);
            a0.d(t1Var, u4Var.i(58, 0));
            if (u4Var.l(59)) {
                t1Var.setTextColor(u4Var.b(59));
            }
            CharSequence k11 = u4Var.k(57);
            this.f17224j = !TextUtils.isEmpty(k11) ? k11 : charSequence;
            t1Var.setText(k11);
            d();
            addView(checkableImageButton);
            addView(t1Var);
            return;
        }
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public final void a(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f17225k;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f17226l;
            PorterDuff.Mode mode = this.f17227m;
            TextInputLayout textInputLayout = this.f17222h;
            p.a(textInputLayout, checkableImageButton, colorStateList, mode);
            b(true);
            p.c(textInputLayout, checkableImageButton, this.f17226l);
            return;
        }
        b(false);
        View.OnLongClickListener onLongClickListener = this.f17230p;
        checkableImageButton.setOnClickListener((View.OnClickListener) null);
        p.e(checkableImageButton, onLongClickListener);
        this.f17230p = null;
        checkableImageButton.setOnLongClickListener((View.OnLongClickListener) null);
        p.e(checkableImageButton, (View.OnLongClickListener) null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription((CharSequence) null);
        }
    }

    public final void b(boolean z10) {
        boolean z11;
        CheckableImageButton checkableImageButton = this.f17225k;
        int i10 = 0;
        if (checkableImageButton.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 != z10) {
            if (!z10) {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            c();
            d();
        }
    }

    public final void c() {
        boolean z10;
        EditText editText = this.f17222h.f3896k;
        if (editText != null) {
            int i10 = 0;
            if (this.f17225k.getVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                WeakHashMap weakHashMap = c1.f10054a;
                i10 = j0.f(editText);
            }
            int compoundPaddingTop = editText.getCompoundPaddingTop();
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
            int compoundPaddingBottom = editText.getCompoundPaddingBottom();
            WeakHashMap weakHashMap2 = c1.f10054a;
            j0.k(this.f17223i, i10, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
        }
    }

    public final void d() {
        int i10 = 0;
        int i11 = (this.f17224j == null || this.f17231q) ? 8 : 0;
        if (!(this.f17225k.getVisibility() == 0 || i11 == 0)) {
            i10 = 8;
        }
        setVisibility(i10);
        this.f17223i.setVisibility(i11);
        this.f17222h.o();
    }

    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        c();
    }
}

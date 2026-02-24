package y8;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.t1;
import com.google.android.material.textfield.TextInputLayout;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;
import m0.l0;
import n8.a;
import q8.d;
import w7.b;

public final class r {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a  reason: collision with root package name */
    public final int f17183a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17184b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17185c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeInterpolator f17186d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeInterpolator f17187e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeInterpolator f17188f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f17189g;

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f17190h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f17191i;

    /* renamed from: j  reason: collision with root package name */
    public int f17192j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f17193k;

    /* renamed from: l  reason: collision with root package name */
    public Animator f17194l;

    /* renamed from: m  reason: collision with root package name */
    public final float f17195m;

    /* renamed from: n  reason: collision with root package name */
    public int f17196n;

    /* renamed from: o  reason: collision with root package name */
    public int f17197o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f17198p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f17199q;

    /* renamed from: r  reason: collision with root package name */
    public t1 f17200r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f17201s;

    /* renamed from: t  reason: collision with root package name */
    public int f17202t;

    /* renamed from: u  reason: collision with root package name */
    public int f17203u;

    /* renamed from: v  reason: collision with root package name */
    public ColorStateList f17204v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f17205w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f17206x;

    /* renamed from: y  reason: collision with root package name */
    public t1 f17207y;

    /* renamed from: z  reason: collision with root package name */
    public int f17208z;

    public r(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f17189g = context;
        this.f17190h = textInputLayout;
        this.f17195m = (float) context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f17183a = a.c(context, R.attr.motionDurationShort4, 217);
        this.f17184b = a.c(context, R.attr.motionDurationMedium4, 167);
        this.f17185c = a.c(context, R.attr.motionDurationShort4, 167);
        this.f17186d = a.d(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, w7.a.f16156d);
        LinearInterpolator linearInterpolator = w7.a.f16153a;
        this.f17187e = a.d(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f17188f = a.d(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(TextView textView, int i10) {
        if (this.f17191i == null && this.f17193k == null) {
            Context context = this.f17189g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f17191i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f17191i;
            TextInputLayout textInputLayout = this.f17190h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f17193k = new FrameLayout(context);
            this.f17191i.addView(this.f17193k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i10 == 0 || i10 == 1) {
            this.f17193k.setVisibility(0);
            this.f17193k.addView(textView);
        } else {
            this.f17191i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f17191i.setVisibility(0);
        this.f17192j++;
    }

    public final void b() {
        boolean z10;
        LinearLayout linearLayout = this.f17191i;
        TextInputLayout textInputLayout = this.f17190h;
        if (linearLayout == null || textInputLayout.getEditText() == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            EditText editText = textInputLayout.getEditText();
            Context context = this.f17189g;
            boolean d10 = d.d(context);
            LinearLayout linearLayout2 = this.f17191i;
            WeakHashMap weakHashMap = c1.f10054a;
            int f10 = j0.f(editText);
            if (d10) {
                f10 = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
            if (d10) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
            }
            int e10 = j0.e(editText);
            if (d10) {
                e10 = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
            }
            j0.k(linearLayout2, f10, dimensionPixelSize, e10, 0);
        }
    }

    public final void c() {
        Animator animator = this.f17194l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z10, TextView textView, int i10, int i11, int i12) {
        boolean z11;
        boolean z12;
        float f10;
        int i13;
        TimeInterpolator timeInterpolator;
        boolean z13;
        if (textView != null && z10) {
            if (i10 == i12 || i10 == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i12 == i10) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    f10 = 1.0f;
                } else {
                    f10 = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{f10});
                int i14 = this.f17185c;
                if (z12) {
                    i13 = this.f17184b;
                } else {
                    i13 = i14;
                }
                ofFloat.setDuration((long) i13);
                if (z12) {
                    timeInterpolator = this.f17187e;
                } else {
                    timeInterpolator = this.f17188f;
                }
                ofFloat.setInterpolator(timeInterpolator);
                if (i10 != i12 || i11 == 0) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13) {
                    ofFloat.setStartDelay((long) i14);
                }
                arrayList.add(ofFloat);
                if (i12 == i10 && i11 != 0) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f17195m, 0.0f});
                    ofFloat2.setDuration((long) this.f17183a);
                    ofFloat2.setInterpolator(this.f17186d);
                    ofFloat2.setStartDelay((long) i14);
                    arrayList.add(ofFloat2);
                }
            }
        }
    }

    public final TextView e(int i10) {
        if (i10 == 1) {
            return this.f17200r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f17207y;
    }

    public final void f() {
        this.f17198p = null;
        c();
        if (this.f17196n == 1) {
            this.f17197o = (!this.f17206x || TextUtils.isEmpty(this.f17205w)) ? 0 : 2;
        }
        i(this.f17196n, this.f17197o, h(this.f17200r, ""));
    }

    public final void g(TextView textView, int i10) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = this.f17191i;
        if (viewGroup2 != null) {
            boolean z10 = true;
            if (!(i10 == 0 || i10 == 1)) {
                z10 = false;
            }
            if (z10 && (viewGroup = this.f17193k) != null) {
                viewGroup2 = viewGroup;
            }
            viewGroup2.removeView(textView);
            int i11 = this.f17192j - 1;
            this.f17192j = i11;
            LinearLayout linearLayout = this.f17191i;
            if (i11 == 0) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public final boolean h(TextView textView, CharSequence charSequence) {
        WeakHashMap weakHashMap = c1.f10054a;
        TextInputLayout textInputLayout = this.f17190h;
        if (!l0.c(textInputLayout) || !textInputLayout.isEnabled() || (this.f17197o == this.f17196n && textView != null && TextUtils.equals(textView.getText(), charSequence))) {
            return false;
        }
        return true;
    }

    public final void i(int i10, int i11, boolean z10) {
        TextView e10;
        TextView e11;
        int i12 = i10;
        int i13 = i11;
        boolean z11 = z10;
        if (i12 != i13) {
            if (z11) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f17194l = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i14 = i10;
                int i15 = i11;
                d(arrayList2, this.f17206x, this.f17207y, 2, i14, i15);
                d(arrayList2, this.f17199q, this.f17200r, 1, i14, i15);
                b.a(animatorSet, arrayList);
                animatorSet.addListener(new q(this, i11, e(i10), i10, e(i13)));
                animatorSet.start();
            } else if (i12 != i13) {
                if (!(i13 == 0 || (e11 = e(i13)) == null)) {
                    e11.setVisibility(0);
                    e11.setAlpha(1.0f);
                }
                if (!(i12 == 0 || (e10 = e(i10)) == null)) {
                    e10.setVisibility(4);
                    if (i12 == 1) {
                        e10.setText((CharSequence) null);
                    }
                }
                this.f17196n = i13;
            }
            TextInputLayout textInputLayout = this.f17190h;
            textInputLayout.p();
            textInputLayout.s(z11, false);
            textInputLayout.v();
        }
    }
}

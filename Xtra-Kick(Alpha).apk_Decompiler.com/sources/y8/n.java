package y8;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.result.j;
import androidx.appcompat.widget.t1;
import androidx.appcompat.widget.u4;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.woxthebox.draglistview.R;
import h.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m.f;
import m0.c1;
import m0.i0;
import m0.j0;
import m0.l0;
import m0.p;
import m8.w;
import n0.c;
import n0.d;
import q0.a0;

public final class n extends LinearLayout {
    public static final /* synthetic */ int D = 0;
    public final AccessibilityManager A;
    public d B;
    public final l C = new l(this);

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f17155h;

    /* renamed from: i  reason: collision with root package name */
    public final FrameLayout f17156i;

    /* renamed from: j  reason: collision with root package name */
    public final CheckableImageButton f17157j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f17158k;

    /* renamed from: l  reason: collision with root package name */
    public PorterDuff.Mode f17159l;

    /* renamed from: m  reason: collision with root package name */
    public View.OnLongClickListener f17160m;

    /* renamed from: n  reason: collision with root package name */
    public final CheckableImageButton f17161n;

    /* renamed from: o  reason: collision with root package name */
    public final j f17162o;

    /* renamed from: p  reason: collision with root package name */
    public int f17163p = 0;

    /* renamed from: q  reason: collision with root package name */
    public final LinkedHashSet f17164q = new LinkedHashSet();

    /* renamed from: r  reason: collision with root package name */
    public ColorStateList f17165r;

    /* renamed from: s  reason: collision with root package name */
    public PorterDuff.Mode f17166s;

    /* renamed from: t  reason: collision with root package name */
    public int f17167t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView.ScaleType f17168u;

    /* renamed from: v  reason: collision with root package name */
    public View.OnLongClickListener f17169v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f17170w;

    /* renamed from: x  reason: collision with root package name */
    public final t1 f17171x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f17172y;

    /* renamed from: z  reason: collision with root package name */
    public EditText f17173z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(TextInputLayout textInputLayout, u4 u4Var) {
        super(textInputLayout.getContext());
        CharSequence k10;
        TextInputLayout textInputLayout2 = textInputLayout;
        u4 u4Var2 = u4Var;
        m mVar = new m(this);
        this.A = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f17155h = textInputLayout2;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f17156i = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton a10 = a(this, from, R.id.text_input_error_icon);
        this.f17157j = a10;
        CheckableImageButton a11 = a(frameLayout, from, R.id.text_input_end_icon);
        this.f17161n = a11;
        this.f17162o = new j(this, u4Var2);
        CharSequence charSequence = null;
        t1 t1Var = new t1(getContext(), (AttributeSet) null);
        this.f17171x = t1Var;
        if (u4Var2.l(36)) {
            this.f17158k = q8.d.b(getContext(), u4Var2, 36);
        }
        if (u4Var2.l(37)) {
            this.f17159l = w.d(u4Var2.h(37, -1), (PorterDuff.Mode) null);
        }
        if (u4Var2.l(35)) {
            h(u4Var2.e(35));
        }
        a10.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = c1.f10054a;
        i0.s(a10, 2);
        a10.setClickable(false);
        a10.setPressable(false);
        a10.setFocusable(false);
        if (!u4Var2.l(51)) {
            if (u4Var2.l(30)) {
                this.f17165r = q8.d.b(getContext(), u4Var2, 30);
            }
            if (u4Var2.l(31)) {
                this.f17166s = w.d(u4Var2.h(31, -1), (PorterDuff.Mode) null);
            }
        }
        if (u4Var2.l(28)) {
            f(u4Var2.h(28, 0));
            if (u4Var2.l(25) && a11.getContentDescription() != (k10 = u4Var2.k(25))) {
                a11.setContentDescription(k10);
            }
            a11.setCheckable(u4Var2.a(24, true));
        } else if (u4Var2.l(51)) {
            if (u4Var2.l(52)) {
                this.f17165r = q8.d.b(getContext(), u4Var2, 52);
            }
            if (u4Var2.l(53)) {
                this.f17166s = w.d(u4Var2.h(53, -1), (PorterDuff.Mode) null);
            }
            f(u4Var2.a(51, false) ? 1 : 0);
            CharSequence k11 = u4Var2.k(49);
            if (a11.getContentDescription() != k11) {
                a11.setContentDescription(k11);
            }
        }
        int d10 = u4Var2.d(27, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (d10 >= 0) {
            if (d10 != this.f17167t) {
                this.f17167t = d10;
                a11.setMinimumWidth(d10);
                a11.setMinimumHeight(d10);
                a10.setMinimumWidth(d10);
                a10.setMinimumHeight(d10);
            }
            if (u4Var2.l(29)) {
                ImageView.ScaleType b10 = p.b(u4Var2.h(29, -1));
                this.f17168u = b10;
                a11.setScaleType(b10);
                a10.setScaleType(b10);
            }
            t1Var.setVisibility(8);
            t1Var.setId(R.id.textinput_suffix_text);
            t1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
            l0.f(t1Var, 1);
            a0.d(t1Var, u4Var2.i(70, 0));
            if (u4Var2.l(71)) {
                t1Var.setTextColor(u4Var2.b(71));
            }
            CharSequence k12 = u4Var2.k(69);
            this.f17170w = !TextUtils.isEmpty(k12) ? k12 : charSequence;
            t1Var.setText(k12);
            m();
            frameLayout.addView(a11);
            addView(t1Var);
            addView(frameLayout);
            addView(a10);
            textInputLayout2.f3895j0.add(mVar);
            if (textInputLayout2.f3896k != null) {
                mVar.a(textInputLayout2);
            }
            addOnAttachStateChangeListener(new f(2, this));
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        p.d(checkableImageButton);
        if (q8.d.d(getContext())) {
            p.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public final o b() {
        int i10 = this.f17163p;
        j jVar = this.f17162o;
        SparseArray sparseArray = (SparseArray) jVar.f519j;
        o oVar = (o) sparseArray.get(i10);
        if (oVar == null) {
            if (i10 == -1) {
                oVar = new e((n) jVar.f520k, 0);
            } else if (i10 == 0) {
                oVar = new e((n) jVar.f520k, 1);
            } else if (i10 == 1) {
                oVar = new u((n) jVar.f520k, jVar.f518i);
            } else if (i10 == 2) {
                oVar = new d((n) jVar.f520k);
            } else if (i10 == 3) {
                oVar = new k((n) jVar.f520k);
            } else {
                throw new IllegalArgumentException(h.i("Invalid end icon mode: ", i10));
            }
            sparseArray.append(i10, oVar);
        }
        return oVar;
    }

    public final boolean c() {
        return this.f17156i.getVisibility() == 0 && this.f17161n.getVisibility() == 0;
    }

    public final boolean d() {
        return this.f17157j.getVisibility() == 0;
    }

    public final void e(boolean z10) {
        boolean z11;
        boolean isActivated;
        boolean isChecked;
        o b10 = b();
        boolean k10 = b10.k();
        CheckableImageButton checkableImageButton = this.f17161n;
        boolean z12 = true;
        if (!k10 || (isChecked = checkableImageButton.isChecked()) == b10.l()) {
            z11 = false;
        } else {
            checkableImageButton.setChecked(!isChecked);
            z11 = true;
        }
        if (!(b10 instanceof k) || (isActivated = checkableImageButton.isActivated()) == b10.j()) {
            z12 = z11;
        } else {
            checkableImageButton.setActivated(!isActivated);
        }
        if (z10 || z12) {
            p.c(this.f17155h, checkableImageButton, this.f17165r);
        }
    }

    public final void f(int i10) {
        boolean z10;
        Drawable drawable;
        if (this.f17163p != i10) {
            o b10 = b();
            d dVar = this.B;
            AccessibilityManager accessibilityManager = this.A;
            if (!(dVar == null || accessibilityManager == null)) {
                c.b(accessibilityManager, dVar);
            }
            CharSequence charSequence = null;
            this.B = null;
            b10.s();
            this.f17163p = i10;
            Iterator it = this.f17164q.iterator();
            if (!it.hasNext()) {
                if (i10 != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                g(z10);
                o b11 = b();
                int i11 = this.f17162o.f517h;
                if (i11 == 0) {
                    i11 = b11.d();
                }
                if (i11 != 0) {
                    drawable = a.a(getContext(), i11);
                } else {
                    drawable = null;
                }
                CheckableImageButton checkableImageButton = this.f17161n;
                checkableImageButton.setImageDrawable(drawable);
                TextInputLayout textInputLayout = this.f17155h;
                if (drawable != null) {
                    p.a(textInputLayout, checkableImageButton, this.f17165r, this.f17166s);
                    p.c(textInputLayout, checkableImageButton, this.f17165r);
                }
                int c10 = b11.c();
                if (c10 != 0) {
                    charSequence = getResources().getText(c10);
                }
                if (checkableImageButton.getContentDescription() != charSequence) {
                    checkableImageButton.setContentDescription(charSequence);
                }
                checkableImageButton.setCheckable(b11.k());
                if (b11.i(textInputLayout.getBoxBackgroundMode())) {
                    b11.r();
                    d h10 = b11.h();
                    this.B = h10;
                    if (!(h10 == null || accessibilityManager == null)) {
                        WeakHashMap weakHashMap = c1.f10054a;
                        if (l0.b(this)) {
                            c.a(accessibilityManager, this.B);
                        }
                    }
                    View.OnClickListener f10 = b11.f();
                    View.OnLongClickListener onLongClickListener = this.f17169v;
                    checkableImageButton.setOnClickListener(f10);
                    p.e(checkableImageButton, onLongClickListener);
                    EditText editText = this.f17173z;
                    if (editText != null) {
                        b11.m(editText);
                        i(b11);
                    }
                    p.a(textInputLayout, checkableImageButton, this.f17165r, this.f17166s);
                    e(true);
                    return;
                }
                throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
            }
            h.y(it.next());
            throw null;
        }
    }

    public final void g(boolean z10) {
        if (c() != z10) {
            this.f17161n.setVisibility(z10 ? 0 : 8);
            j();
            l();
            this.f17155h.o();
        }
    }

    public final void h(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f17157j;
        checkableImageButton.setImageDrawable(drawable);
        k();
        p.a(this.f17155h, checkableImageButton, this.f17158k, this.f17159l);
    }

    public final void i(o oVar) {
        if (this.f17173z != null) {
            if (oVar.e() != null) {
                this.f17173z.setOnFocusChangeListener(oVar.e());
            }
            if (oVar.g() != null) {
                this.f17161n.setOnFocusChangeListener(oVar.g());
            }
        }
    }

    public final void j() {
        int i10 = 8;
        this.f17156i.setVisibility((this.f17161n.getVisibility() != 0 || d()) ? 8 : 0);
        if (c() || d() || ((this.f17170w == null || this.f17172y) ? (char) 8 : 0) == 0) {
            i10 = 0;
        }
        setVisibility(i10);
    }

    public final void k() {
        boolean z10;
        int i10;
        CheckableImageButton checkableImageButton = this.f17157j;
        Drawable drawable = checkableImageButton.getDrawable();
        boolean z11 = true;
        TextInputLayout textInputLayout = this.f17155h;
        if (drawable == null || !textInputLayout.f3908q.f17199q || !textInputLayout.l()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        checkableImageButton.setVisibility(i10);
        j();
        l();
        if (this.f17163p == 0) {
            z11 = false;
        }
        if (!z11) {
            textInputLayout.o();
        }
    }

    public final void l() {
        int i10;
        TextInputLayout textInputLayout = this.f17155h;
        if (textInputLayout.f3896k != null) {
            if (c() || d()) {
                i10 = 0;
            } else {
                EditText editText = textInputLayout.f3896k;
                WeakHashMap weakHashMap = c1.f10054a;
                i10 = j0.e(editText);
            }
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
            int paddingTop = textInputLayout.f3896k.getPaddingTop();
            int paddingBottom = textInputLayout.f3896k.getPaddingBottom();
            WeakHashMap weakHashMap2 = c1.f10054a;
            j0.k(this.f17171x, dimensionPixelSize, paddingTop, i10, paddingBottom);
        }
    }

    public final void m() {
        t1 t1Var = this.f17171x;
        int visibility = t1Var.getVisibility();
        boolean z10 = false;
        int i10 = (this.f17170w == null || this.f17172y) ? 8 : 0;
        if (visibility != i10) {
            o b10 = b();
            if (i10 == 0) {
                z10 = true;
            }
            b10.p(z10);
        }
        j();
        t1Var.setVisibility(i10);
        this.f17155h.o();
    }
}

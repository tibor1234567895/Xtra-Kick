package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.woxthebox.draglistview.R;
import f.a;
import m0.c1;

public final class d5 implements f2 {

    /* renamed from: a  reason: collision with root package name */
    public final Toolbar f791a;

    /* renamed from: b  reason: collision with root package name */
    public int f792b;

    /* renamed from: c  reason: collision with root package name */
    public View f793c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f794d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f795e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f796f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f797g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f798h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f799i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f800j;

    /* renamed from: k  reason: collision with root package name */
    public Window.Callback f801k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f802l;

    /* renamed from: m  reason: collision with root package name */
    public n f803m;

    /* renamed from: n  reason: collision with root package name */
    public int f804n = 0;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f805o;

    public d5(Toolbar toolbar) {
        boolean z10;
        Drawable drawable;
        this.f791a = toolbar;
        this.f798h = toolbar.getTitle();
        this.f799i = toolbar.getSubtitle();
        if (this.f798h != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f797g = z10;
        this.f796f = toolbar.getNavigationIcon();
        String str = null;
        u4 m10 = u4.m(toolbar.getContext(), (AttributeSet) null, a.f5391a, R.attr.actionBarStyle);
        this.f805o = m10.e(15);
        CharSequence k10 = m10.k(27);
        if (!TextUtils.isEmpty(k10)) {
            this.f797g = true;
            this.f798h = k10;
            if ((this.f792b & 8) != 0) {
                toolbar.setTitle(k10);
                if (this.f797g) {
                    c1.q(toolbar.getRootView(), k10);
                }
            }
        }
        CharSequence k11 = m10.k(25);
        if (!TextUtils.isEmpty(k11)) {
            this.f799i = k11;
            if ((this.f792b & 8) != 0) {
                toolbar.setSubtitle(k11);
            }
        }
        Drawable e10 = m10.e(20);
        if (e10 != null) {
            this.f795e = e10;
            b();
        }
        Drawable e11 = m10.e(17);
        if (e11 != null) {
            this.f794d = e11;
            b();
        }
        if (this.f796f == null && (drawable = this.f805o) != null) {
            this.f796f = drawable;
            toolbar.setNavigationIcon((this.f792b & 4) == 0 ? null : drawable);
        }
        a(m10.h(10, 0));
        int i10 = m10.i(9, 0);
        if (i10 != 0) {
            View inflate = LayoutInflater.from(toolbar.getContext()).inflate(i10, toolbar, false);
            View view = this.f793c;
            if (!(view == null || (this.f792b & 16) == 0)) {
                toolbar.removeView(view);
            }
            this.f793c = inflate;
            if (!(inflate == null || (this.f792b & 16) == 0)) {
                toolbar.addView(inflate);
            }
            a(this.f792b | 16);
        }
        int layoutDimension = m10.f1100b.getLayoutDimension(13, 0);
        if (layoutDimension > 0) {
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            layoutParams.height = layoutDimension;
            toolbar.setLayoutParams(layoutParams);
        }
        int c10 = m10.c(7, -1);
        int c11 = m10.c(3, -1);
        if (c10 >= 0 || c11 >= 0) {
            int max = Math.max(c10, 0);
            int max2 = Math.max(c11, 0);
            if (toolbar.A == null) {
                toolbar.A = new s3();
            }
            toolbar.A.a(max, max2);
        }
        int i11 = m10.i(28, 0);
        if (i11 != 0) {
            Context context = toolbar.getContext();
            toolbar.f702s = i11;
            t1 t1Var = toolbar.f692i;
            if (t1Var != null) {
                t1Var.setTextAppearance(context, i11);
            }
        }
        int i12 = m10.i(26, 0);
        if (i12 != 0) {
            Context context2 = toolbar.getContext();
            toolbar.f703t = i12;
            t1 t1Var2 = toolbar.f693j;
            if (t1Var2 != null) {
                t1Var2.setTextAppearance(context2, i12);
            }
        }
        int i13 = m10.i(22, 0);
        if (i13 != 0) {
            toolbar.setPopupTheme(i13);
        }
        m10.n();
        if (R.string.abc_action_bar_up_description != this.f804n) {
            this.f804n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i14 = this.f804n;
                str = i14 != 0 ? toolbar.getContext().getString(i14) : str;
                this.f800j = str;
                if ((this.f792b & 4) != 0) {
                    if (TextUtils.isEmpty(str)) {
                        toolbar.setNavigationContentDescription(this.f804n);
                    } else {
                        toolbar.setNavigationContentDescription(this.f800j);
                    }
                }
            }
        }
        this.f800j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new c(this));
    }

    public final void a(int i10) {
        View view;
        Drawable drawable;
        int i11 = this.f792b ^ i10;
        this.f792b = i10;
        if (i11 != 0) {
            int i12 = i11 & 4;
            CharSequence charSequence = null;
            Toolbar toolbar = this.f791a;
            if (i12 != 0) {
                if (!((i10 & 4) == 0 || (i10 & 4) == 0)) {
                    if (TextUtils.isEmpty(this.f800j)) {
                        toolbar.setNavigationContentDescription(this.f804n);
                    } else {
                        toolbar.setNavigationContentDescription(this.f800j);
                    }
                }
                if ((this.f792b & 4) != 0) {
                    drawable = this.f796f;
                    if (drawable == null) {
                        drawable = this.f805o;
                    }
                } else {
                    drawable = null;
                }
                toolbar.setNavigationIcon(drawable);
            }
            if ((i11 & 3) != 0) {
                b();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    toolbar.setTitle(this.f798h);
                    charSequence = this.f799i;
                } else {
                    toolbar.setTitle((CharSequence) null);
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i11 & 16) != 0 && (view = this.f793c) != null) {
                if ((i10 & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
        }
    }

    public final void b() {
        Drawable drawable;
        int i10 = this.f792b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f795e) == null) {
            drawable = this.f794d;
        }
        this.f791a.setLogo(drawable);
    }
}

package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.j;
import androidx.fragment.app.t;
import com.google.android.material.internal.CheckableImageButton;
import com.woxthebox.draglistview.R;
import h.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m0.c1;
import m0.l0;
import m0.o0;
import m0.s1;
import m0.v2;
import m8.f;
import q8.c;
import t8.i;

public final class r<S> extends t {
    public int A0;
    public CharSequence B0;
    public boolean C0;
    public int D0;
    public int E0;
    public CharSequence F0;
    public int G0;
    public CharSequence H0;
    public TextView I0;
    public CheckableImageButton J0;
    public i K0;
    public Button L0;
    public boolean M0;
    public CharSequence N0;
    public CharSequence O0;

    /* renamed from: t0  reason: collision with root package name */
    public final LinkedHashSet f3782t0 = new LinkedHashSet();

    /* renamed from: u0  reason: collision with root package name */
    public final LinkedHashSet f3783u0 = new LinkedHashSet();

    /* renamed from: v0  reason: collision with root package name */
    public int f3784v0;

    /* renamed from: w0  reason: collision with root package name */
    public a0 f3785w0;

    /* renamed from: x0  reason: collision with root package name */
    public d f3786x0;

    /* renamed from: y0  reason: collision with root package name */
    public g f3787y0;

    /* renamed from: z0  reason: collision with root package name */
    public n f3788z0;

    public r() {
        new LinkedHashSet();
        new LinkedHashSet();
    }

    public static int s0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        u uVar = new u(c0.c());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int i10 = uVar.f3794k;
        int i11 = dimensionPixelSize * i10;
        return ((i10 - 1) * dimensionPixelOffset2) + i11 + (dimensionPixelOffset * 2);
    }

    public static boolean t0(Context context) {
        return u0(context, 16843277);
    }

    public static boolean u0(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.c(R.attr.materialCalendarStyle, context, n.class.getCanonicalName()).data, new int[]{i10});
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            bundle = this.f1357m;
        }
        this.f3784v0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        h.w(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f3786x0 = (d) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f3787y0 = (g) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.A0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.B0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.D0 = bundle.getInt("INPUT_MODE_KEY");
        this.E0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.F0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.G0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.H0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence charSequence = this.B0;
        if (charSequence == null) {
            charSequence = f0().getResources().getText(this.A0);
        }
        this.N0 = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), Constants.WRITE_NEW_LINE);
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.O0 = charSequence;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i10;
        LinearLayout.LayoutParams layoutParams;
        View view;
        int i11;
        if (this.C0) {
            i10 = R.layout.mtrl_picker_fullscreen;
        } else {
            i10 = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i10, viewGroup);
        Context context = inflate.getContext();
        if (this.C0) {
            view = inflate.findViewById(R.id.mtrl_calendar_frame);
            layoutParams = new LinearLayout.LayoutParams(s0(context), -2);
        } else {
            view = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            layoutParams = new LinearLayout.LayoutParams(s0(context), -1);
        }
        view.setLayoutParams(layoutParams);
        WeakHashMap weakHashMap = c1.f10054a;
        boolean z10 = true;
        l0.f((TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text), 1);
        this.J0 = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.I0 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        this.J0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.J0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, a.a(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], a.a(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        CheckableImageButton checkableImageButton2 = this.J0;
        if (this.D0 == 0) {
            z10 = false;
        }
        checkableImageButton2.setChecked(z10);
        c1.p(this.J0, (m0.c) null);
        CheckableImageButton checkableImageButton3 = this.J0;
        boolean isChecked = checkableImageButton3.isChecked();
        Context context2 = checkableImageButton3.getContext();
        if (isChecked) {
            i11 = R.string.mtrl_picker_toggle_to_calendar_input_mode;
        } else {
            i11 = R.string.mtrl_picker_toggle_to_text_input_mode;
        }
        this.J0.setContentDescription(context2.getString(i11));
        this.J0.setOnClickListener(new p(this));
        this.L0 = (Button) inflate.findViewById(R.id.confirm_button);
        r0();
        throw null;
    }

    public final void W(Bundle bundle) {
        u uVar;
        super.W(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f3784v0);
        u uVar2 = null;
        bundle.putParcelable("DATE_SELECTOR_KEY", (Parcelable) null);
        b bVar = new b(this.f3786x0);
        n nVar = this.f3788z0;
        if (nVar == null) {
            uVar = null;
        } else {
            uVar = nVar.f3771h0;
        }
        if (uVar != null) {
            bVar.f3740c = Long.valueOf(uVar.f3796m);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", bVar.f3742e);
        u v10 = u.v(bVar.f3738a);
        u v11 = u.v(bVar.f3739b);
        c cVar = (c) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l10 = bVar.f3740c;
        if (l10 != null) {
            uVar2 = u.v(l10.longValue());
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new d(v10, v11, cVar, uVar2, bVar.f3741d));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f3787y0);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.A0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.B0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.E0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.F0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.G0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.H0);
    }

    public final void X() {
        a0 a0Var;
        CharSequence charSequence;
        Integer num;
        boolean z10;
        int i10;
        int i11;
        boolean z11;
        boolean z12;
        super.X();
        Window window = o0().getWindow();
        boolean z13 = true;
        if (this.C0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.K0);
            if (!this.M0) {
                View findViewById = h0().findViewById(R.id.fullscreen_header);
                if (findViewById.getBackground() instanceof ColorDrawable) {
                    num = Integer.valueOf(((ColorDrawable) findViewById.getBackground()).getColor());
                } else {
                    num = null;
                }
                int i12 = Build.VERSION.SDK_INT;
                if (num == null || num.intValue() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int a10 = g8.a.a(window.getContext(), 16842801, -16777216);
                if (z10) {
                    num = Integer.valueOf(a10);
                }
                Integer valueOf = Integer.valueOf(a10);
                s1.a(window, false);
                Context context = window.getContext();
                if (i12 < 23) {
                    i10 = e0.a.d(g8.a.a(context, 16843857, -16777216), 128);
                } else {
                    i10 = 0;
                }
                Context context2 = window.getContext();
                if (i12 < 27) {
                    i11 = e0.a.d(g8.a.a(context2, 16843858, -16777216), 128);
                } else {
                    i11 = 0;
                }
                window.setStatusBarColor(i10);
                window.setNavigationBarColor(i11);
                boolean c10 = g8.a.c(num.intValue());
                if (g8.a.c(i10) || (i10 == 0 && c10)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                f.a(window, z11);
                boolean c11 = g8.a.c(valueOf.intValue());
                if (g8.a.c(i11) || (i11 == 0 && c11)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                ((v2) new e.a(window, window.getDecorView()).f4852i).c(z12);
                j jVar = new j(this, findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop());
                WeakHashMap weakHashMap = c1.f10054a;
                o0.u(findViewById, jVar);
                this.M0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = y().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable(this.K0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new h8.a(o0(), rect));
        }
        f0();
        int i13 = this.f3784v0;
        if (i13 != 0) {
            r0();
            d dVar = this.f3786x0;
            g gVar = this.f3787y0;
            n nVar = new n();
            Bundle bundle = new Bundle();
            bundle.putInt("THEME_RES_ID_KEY", i13);
            bundle.putParcelable("GRID_SELECTOR_KEY", (Parcelable) null);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", dVar);
            bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", gVar);
            bundle.putParcelable("CURRENT_MONTH_KEY", dVar.f3747k);
            nVar.j0(bundle);
            this.f3788z0 = nVar;
            boolean isChecked = this.J0.isChecked();
            if (isChecked) {
                r0();
                d dVar2 = this.f3786x0;
                a0Var = new s();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("THEME_RES_ID_KEY", i13);
                bundle2.putParcelable("DATE_SELECTOR_KEY", (Parcelable) null);
                bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", dVar2);
                a0Var.j0(bundle2);
            } else {
                a0Var = this.f3788z0;
            }
            this.f3785w0 = a0Var;
            TextView textView = this.I0;
            if (isChecked) {
                if (y().getConfiguration().orientation != 2) {
                    z13 = false;
                }
                if (z13) {
                    charSequence = this.O0;
                    textView.setText(charSequence);
                    r0();
                    v();
                    throw null;
                }
            }
            charSequence = this.N0;
            textView.setText(charSequence);
            r0();
            v();
            throw null;
        }
        r0();
        throw null;
    }

    public final void Y() {
        this.f3785w0.f3735d0.clear();
        super.Y();
    }

    public final Dialog n0(Bundle bundle) {
        Context f02 = f0();
        f0();
        int i10 = this.f3784v0;
        if (i10 != 0) {
            Dialog dialog = new Dialog(f02, i10);
            Context context = dialog.getContext();
            this.C0 = t0(context);
            int i11 = c.c(R.attr.colorSurface, context, r.class.getCanonicalName()).data;
            i iVar = new i(context, (AttributeSet) null, R.attr.materialCalendarStyle, 2132018321);
            this.K0 = iVar;
            iVar.i(context);
            this.K0.k(ColorStateList.valueOf(i11));
            i iVar2 = this.K0;
            View decorView = dialog.getWindow().getDecorView();
            WeakHashMap weakHashMap = c1.f10054a;
            iVar2.j(o0.i(decorView));
            return dialog;
        }
        r0();
        throw null;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f3782t0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f3783u0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.M;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final void r0() {
        h.w(this.f1357m.getParcelable("DATE_SELECTOR_KEY"));
    }
}

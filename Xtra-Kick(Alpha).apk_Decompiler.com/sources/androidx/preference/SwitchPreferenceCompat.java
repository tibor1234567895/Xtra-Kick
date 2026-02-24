package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.woxthebox.draglistview.R;
import d0.t;
import o3.a;
import o3.l0;
import o3.m0;

public class SwitchPreferenceCompat extends TwoStatePreference {
    public final a Z = new a(this, 2);

    /* renamed from: a0  reason: collision with root package name */
    public CharSequence f1915a0;

    /* renamed from: b0  reason: collision with root package name */
    public CharSequence f1916b0;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.switchPreferenceCompatStyle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.f12161m, R.attr.switchPreferenceCompatStyle, 0);
        this.V = t.f(obtainStyledAttributes, 7, 0);
        if (this.U) {
            h();
        }
        this.W = t.f(obtainStyledAttributes, 6, 1);
        if (!this.U) {
            h();
        }
        this.f1915a0 = t.f(obtainStyledAttributes, 9, 3);
        h();
        this.f1916b0 = t.f(obtainStyledAttributes, 8, 4);
        h();
        this.Y = obtainStyledAttributes.getBoolean(5, obtainStyledAttributes.getBoolean(2, false));
        obtainStyledAttributes.recycle();
    }

    public final void A(View view) {
        boolean z10 = view instanceof SwitchCompat;
        if (z10) {
            ((SwitchCompat) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.U);
        }
        if (z10) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f1915a0);
            switchCompat.setTextOff(this.f1916b0);
            switchCompat.setOnCheckedChangeListener(this.Z);
        }
    }

    public final void l(l0 l0Var) {
        super.l(l0Var);
        A(l0Var.a(R.id.switchWidget));
        z(l0Var.a(16908304));
    }

    public final void s(View view) {
        super.s(view);
        if (((AccessibilityManager) this.f1887h.getSystemService("accessibility")).isEnabled()) {
            A(view.findViewById(R.id.switchWidget));
            z(view.findViewById(16908304));
        }
    }
}

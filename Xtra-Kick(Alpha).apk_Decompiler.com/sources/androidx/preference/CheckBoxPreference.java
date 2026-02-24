package androidx.preference;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import o3.a;
import o3.l0;

public class CheckBoxPreference extends TwoStatePreference {
    public final a Z = new a(this, 0);

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CheckBoxPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130968765(0x7f0400bd, float:1.7546193E38)
            r1 = 16842895(0x101008f, float:2.369396E-38)
            int r0 = d0.t.a(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            o3.a r1 = new o3.a
            r2 = 0
            r1.<init>(r3, r2)
            r3.Z = r1
            int[] r1 = o3.m0.f12150b
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 5
            java.lang.String r5 = d0.t.f(r4, r5, r2)
            r3.V = r5
            boolean r5 = r3.U
            if (r5 == 0) goto L_0x0029
            r3.h()
        L_0x0029:
            r5 = 4
            r0 = 1
            java.lang.String r5 = d0.t.f(r4, r5, r0)
            r3.W = r5
            boolean r5 = r3.U
            if (r5 != 0) goto L_0x0038
            r3.h()
        L_0x0038:
            r5 = 2
            boolean r5 = r4.getBoolean(r5, r2)
            r0 = 3
            boolean r5 = r4.getBoolean(r0, r5)
            r3.Y = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.CheckBoxPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void A(View view) {
        boolean z10 = view instanceof CompoundButton;
        if (z10) {
            ((CompoundButton) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.U);
        }
        if (z10) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.Z);
        }
    }

    public final void l(l0 l0Var) {
        super.l(l0Var);
        A(l0Var.a(16908289));
        z(l0Var.a(16908304));
    }

    public final void s(View view) {
        super.s(view);
        if (((AccessibilityManager) this.f1887h.getSystemService("accessibility")).isEnabled()) {
            A(view.findViewById(16908289));
            z(view.findViewById(16908304));
        }
    }
}

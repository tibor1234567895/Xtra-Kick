package androidx.preference;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import o3.a;
import o3.l0;

public class SwitchPreference extends TwoStatePreference {
    public final a Z = new a(this, 1);

    /* renamed from: a0  reason: collision with root package name */
    public CharSequence f1913a0;

    /* renamed from: b0  reason: collision with root package name */
    public CharSequence f1914b0;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SwitchPreference(android.content.Context r5, android.util.AttributeSet r6) {
        /*
            r4 = this;
            r0 = 2130969742(0x7f04048e, float:1.7548174E38)
            r1 = 16843629(0x101036d, float:2.3696016E-38)
            int r0 = d0.t.a(r5, r0, r1)
            r4.<init>(r5, r6, r0)
            o3.a r1 = new o3.a
            r2 = 1
            r1.<init>(r4, r2)
            r4.Z = r1
            int[] r1 = o3.m0.f12160l
            r3 = 0
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r1, r0, r3)
            r6 = 7
            java.lang.String r6 = d0.t.f(r5, r6, r3)
            r4.V = r6
            boolean r6 = r4.U
            if (r6 == 0) goto L_0x002a
            r4.h()
        L_0x002a:
            r6 = 6
            java.lang.String r6 = d0.t.f(r5, r6, r2)
            r4.W = r6
            boolean r6 = r4.U
            if (r6 != 0) goto L_0x0038
            r4.h()
        L_0x0038:
            r6 = 9
            r0 = 3
            java.lang.String r6 = d0.t.f(r5, r6, r0)
            r4.f1913a0 = r6
            r4.h()
            r6 = 8
            r0 = 4
            java.lang.String r6 = d0.t.f(r5, r6, r0)
            r4.f1914b0 = r6
            r4.h()
            r6 = 2
            boolean r6 = r5.getBoolean(r6, r3)
            r0 = 5
            boolean r6 = r5.getBoolean(r0, r6)
            r4.Y = r6
            r5.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.SwitchPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void A(View view) {
        boolean z10 = view instanceof Switch;
        if (z10) {
            ((Switch) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.U);
        }
        if (z10) {
            Switch switchR = (Switch) view;
            switchR.setTextOn(this.f1913a0);
            switchR.setTextOff(this.f1914b0);
            switchR.setOnCheckedChangeListener(this.Z);
        }
    }

    public final void l(l0 l0Var) {
        super.l(l0Var);
        A(l0Var.a(16908352));
        z(l0Var.a(16908304));
    }

    public final void s(View view) {
        super.s(view);
        if (((AccessibilityManager) this.f1887h.getSystemService("accessibility")).isEnabled()) {
            A(view.findViewById(16908352));
            z(view.findViewById(16908304));
        }
    }
}

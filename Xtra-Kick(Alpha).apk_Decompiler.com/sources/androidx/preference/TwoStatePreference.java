package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import o3.s0;

public abstract class TwoStatePreference extends Preference {
    public boolean U;
    public CharSequence V;
    public CharSequence W;
    public boolean X;
    public boolean Y;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public final void m() {
        boolean z10 = !this.U;
        a(Boolean.valueOf(z10));
        y(z10);
    }

    public final Object o(TypedArray typedArray, int i10) {
        return Boolean.valueOf(typedArray.getBoolean(i10, false));
    }

    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(s0.class)) {
            super.p(parcelable);
            return;
        }
        s0 s0Var = (s0) parcelable;
        super.p(s0Var.getSuperState());
        y(s0Var.f12170h);
    }

    public final Parcelable q() {
        this.Q = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1904y) {
            return absSavedState;
        }
        s0 s0Var = new s0(absSavedState);
        s0Var.f12170h = this.U;
        return s0Var;
    }

    public final void r(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (x()) {
            booleanValue = this.f1888i.d().getBoolean(this.f1898s, booleanValue);
        }
        y(booleanValue);
    }

    public final boolean w() {
        return (this.Y ? this.U : !this.U) || super.w();
    }

    public final void y(boolean z10) {
        boolean z11;
        if (this.U != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || !this.X) {
            this.U = z10;
            this.X = true;
            if (x()) {
                boolean z12 = !z10;
                boolean x10 = x();
                String str = this.f1898s;
                if (x10) {
                    z12 = this.f1888i.d().getBoolean(str, z12);
                }
                if (z10 != z12) {
                    SharedPreferences.Editor b10 = this.f1888i.b();
                    b10.putBoolean(str, z10);
                    if (!this.f1888i.f12130e) {
                        b10.apply();
                    }
                }
            }
            if (z11) {
                i(w());
                h();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.U
            r1 = 0
            if (r0 == 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.V
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.V
        L_0x0016:
            r5.setText(r0)
            r0 = 0
            goto L_0x002b
        L_0x001b:
            boolean r0 = r4.U
            if (r0 != 0) goto L_0x002a
            java.lang.CharSequence r0 = r4.W
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002a
            java.lang.CharSequence r0 = r4.W
            goto L_0x0016
        L_0x002a:
            r0 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x003b
            java.lang.CharSequence r2 = r4.f()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x003b
            r5.setText(r2)
            r0 = 0
        L_0x003b:
            if (r0 != 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r1 = 8
        L_0x0040:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L_0x0049
            r5.setVisibility(r1)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.z(android.view.View):void");
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

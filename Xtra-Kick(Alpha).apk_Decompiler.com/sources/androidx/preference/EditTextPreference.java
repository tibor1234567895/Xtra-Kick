package androidx.preference;

import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.AbsSavedState;
import o3.d;

public class EditTextPreference extends DialogPreference {

    /* renamed from: a0  reason: collision with root package name */
    public String f1878a0;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EditTextPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130969019(0x7f0401bb, float:1.7546708E38)
            r1 = 16842898(0x1010092, float:2.3693967E-38)
            int r0 = d0.t.a(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            int[] r1 = o3.m0.f12152d
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            boolean r5 = r4.getBoolean(r2, r2)
            boolean r5 = r4.getBoolean(r2, r5)
            if (r5 == 0) goto L_0x0027
            o3.e r5 = o3.e.b()
            r3.S = r5
            r3.h()
        L_0x0027:
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.EditTextPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final Object o(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(d.class)) {
            super.p(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.p(dVar.getSuperState());
        y(dVar.f12111h);
    }

    public final Parcelable q() {
        this.Q = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1904y) {
            return absSavedState;
        }
        d dVar = new d(absSavedState);
        dVar.f12111h = this.f1878a0;
        return dVar;
    }

    public final void r(Object obj) {
        y(e((String) obj));
    }

    public final boolean w() {
        return TextUtils.isEmpty(this.f1878a0) || super.w();
    }

    public final void y(String str) {
        boolean w10 = w();
        this.f1878a0 = str;
        t(str);
        boolean w11 = w();
        if (w11 != w10) {
            i(w11);
        }
        h();
    }
}

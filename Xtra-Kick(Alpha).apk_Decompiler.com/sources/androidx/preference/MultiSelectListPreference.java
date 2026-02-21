package androidx.preference;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.HashSet;
import java.util.Set;
import o3.n;

public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: a0  reason: collision with root package name */
    public final CharSequence[] f1884a0;

    /* renamed from: b0  reason: collision with root package name */
    public final CharSequence[] f1885b0;

    /* renamed from: c0  reason: collision with root package name */
    public final HashSet f1886c0 = new HashSet();

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultiSelectListPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130968979(0x7f040193, float:1.7546627E38)
            r1 = 16842897(0x1010091, float:2.3693964E-38)
            int r0 = d0.t.a(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r3.f1886c0 = r1
            int[] r1 = o3.m0.f12154f
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 2
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
            if (r5 != 0) goto L_0x0026
            java.lang.CharSequence[] r5 = r4.getTextArray(r2)
        L_0x0026:
            r3.f1884a0 = r5
            r5 = 3
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
            if (r5 != 0) goto L_0x0034
            r5 = 1
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
        L_0x0034:
            r3.f1885b0 = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.MultiSelectListPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final Object o(TypedArray typedArray, int i10) {
        CharSequence[] textArray = typedArray.getTextArray(i10);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(n.class)) {
            super.p(parcelable);
            return;
        }
        n nVar = (n) parcelable;
        super.p(nVar.getSuperState());
        y(nVar.f12162h);
    }

    public final Parcelable q() {
        this.Q = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1904y) {
            return absSavedState;
        }
        n nVar = new n(absSavedState);
        nVar.f12162h = this.f1886c0;
        return nVar;
    }

    public final void r(Object obj) {
        Set<String> set = (Set) obj;
        if (x()) {
            set = this.f1888i.d().getStringSet(this.f1898s, set);
        }
        y(set);
    }

    public final void y(Set set) {
        HashSet hashSet = this.f1886c0;
        hashSet.clear();
        hashSet.addAll(set);
        if (x()) {
            boolean x10 = x();
            String str = this.f1898s;
            Set<String> set2 = null;
            if (x10) {
                set2 = this.f1888i.d().getStringSet(str, (Set) null);
            }
            if (!set.equals(set2)) {
                SharedPreferences.Editor b10 = this.f1888i.b();
                b10.putStringSet(str, set);
                if (!this.f1888i.f12130e) {
                    b10.apply();
                }
            }
        }
        h();
    }
}

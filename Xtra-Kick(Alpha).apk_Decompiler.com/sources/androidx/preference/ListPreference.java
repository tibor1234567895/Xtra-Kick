package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import com.woxthebox.draglistview.R;
import d0.t;
import o3.i;
import o3.j;
import o3.m0;
import o3.v;

public class ListPreference extends DialogPreference {

    /* renamed from: a0  reason: collision with root package name */
    public CharSequence[] f1879a0;

    /* renamed from: b0  reason: collision with root package name */
    public CharSequence[] f1880b0;

    /* renamed from: c0  reason: collision with root package name */
    public String f1881c0;

    /* renamed from: d0  reason: collision with root package name */
    public final String f1882d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f1883e0;

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.a(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public void A(CharSequence[] charSequenceArr) {
        this.f1879a0 = charSequenceArr;
    }

    public final void B(String str) {
        boolean z10 = !TextUtils.equals(this.f1881c0, str);
        if (z10 || !this.f1883e0) {
            this.f1881c0 = str;
            this.f1883e0 = true;
            t(str);
            if (z10) {
                h();
            }
        }
    }

    public void C(int i10) {
        CharSequence[] charSequenceArr = this.f1880b0;
        if (charSequenceArr != null) {
            B(charSequenceArr[i10].toString());
        }
    }

    public final CharSequence f() {
        v vVar = this.S;
        if (vVar != null) {
            return vVar.a(this);
        }
        Object z10 = z();
        CharSequence f10 = super.f();
        String str = this.f1882d0;
        if (str == null) {
            return f10;
        }
        Object[] objArr = new Object[1];
        if (z10 == null) {
            z10 = "";
        }
        objArr[0] = z10;
        String format = String.format(str, objArr);
        if (TextUtils.equals(format, f10)) {
            return f10;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public final Object o(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(i.class)) {
            super.p(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.p(iVar.getSuperState());
        B(iVar.f12125h);
    }

    public final Parcelable q() {
        this.Q = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1904y) {
            return absSavedState;
        }
        i iVar = new i(absSavedState);
        iVar.f12125h = this.f1881c0;
        return iVar;
    }

    public final void r(Object obj) {
        B(e((String) obj));
    }

    public final int y(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f1880b0) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.f1880b0[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final CharSequence z() {
        CharSequence[] charSequenceArr;
        int y10 = y(this.f1881c0);
        if (y10 < 0 || (charSequenceArr = this.f1879a0) == null) {
            return null;
        }
        return charSequenceArr[y10];
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.f12153e, i10, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.f1879a0 = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = obtainStyledAttributes.getTextArray(3);
        this.f1880b0 = textArray2 == null ? obtainStyledAttributes.getTextArray(1) : textArray2;
        if (obtainStyledAttributes.getBoolean(4, obtainStyledAttributes.getBoolean(4, false))) {
            this.S = j.b();
            h();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, m0.f12155g, i10, 0);
        this.f1882d0 = t.f(obtainStyledAttributes2, 33, 7);
        obtainStyledAttributes2.recycle();
    }
}

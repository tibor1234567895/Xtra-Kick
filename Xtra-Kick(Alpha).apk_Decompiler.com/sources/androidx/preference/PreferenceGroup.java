package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import java.util.ArrayList;
import o3.b0;
import o3.m0;
import q.k;

public abstract class PreferenceGroup extends Preference {
    public final k U;
    public final ArrayList V;
    public boolean W;
    public int X;
    public boolean Y;
    public int Z;

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int A() {
        return this.V.size();
    }

    public final void B(int i10) {
        if (i10 != Integer.MAX_VALUE && !(!TextUtils.isEmpty(this.f1898s))) {
            Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
        }
        this.Z = i10;
    }

    public final void b(Bundle bundle) {
        super.b(bundle);
        int A = A();
        for (int i10 = 0; i10 < A; i10++) {
            z(i10).b(bundle);
        }
    }

    public final void c(Bundle bundle) {
        super.c(bundle);
        int A = A();
        for (int i10 = 0; i10 < A; i10++) {
            z(i10).c(bundle);
        }
    }

    public final void i(boolean z10) {
        super.i(z10);
        int A = A();
        for (int i10 = 0; i10 < A; i10++) {
            Preference z11 = z(i10);
            if (z11.C == z10) {
                z11.C = !z10;
                z11.i(z11.w());
                z11.h();
            }
        }
    }

    public final void j() {
        super.j();
        this.Y = true;
        int A = A();
        for (int i10 = 0; i10 < A; i10++) {
            z(i10).j();
        }
    }

    public final void n() {
        super.n();
        this.Y = false;
        int A = A();
        for (int i10 = 0; i10 < A; i10++) {
            z(i10).n();
        }
    }

    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(b0.class)) {
            super.p(parcelable);
            return;
        }
        b0 b0Var = (b0) parcelable;
        this.Z = b0Var.f12107h;
        super.p(b0Var.getSuperState());
    }

    public final Parcelable q() {
        this.Q = true;
        return new b0(AbsSavedState.EMPTY_STATE, this.Z);
    }

    public final Preference y(CharSequence charSequence) {
        Preference y10;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (TextUtils.equals(this.f1898s, charSequence)) {
            return this;
        } else {
            int A = A();
            for (int i10 = 0; i10 < A; i10++) {
                Preference z10 = z(i10);
                if (TextUtils.equals(z10.f1898s, charSequence)) {
                    return z10;
                }
                if ((z10 instanceof PreferenceGroup) && (y10 = ((PreferenceGroup) z10).y(charSequence)) != null) {
                    return y10;
                }
            }
            return null;
        }
    }

    public final Preference z(int i10) {
        return (Preference) this.V.get(i10);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.U = new k();
        new Handler(Looper.getMainLooper());
        this.W = true;
        this.X = 0;
        this.Y = false;
        this.Z = Integer.MAX_VALUE;
        this.V = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.f12157i, i10, 0);
        this.W = obtainStyledAttributes.getBoolean(2, obtainStyledAttributes.getBoolean(2, true));
        if (obtainStyledAttributes.hasValue(1)) {
            B(obtainStyledAttributes.getInt(1, obtainStyledAttributes.getInt(1, Integer.MAX_VALUE)));
        }
        obtainStyledAttributes.recycle();
    }
}

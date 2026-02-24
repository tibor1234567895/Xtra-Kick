package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.fragment.app.c0;
import com.woxthebox.draglistview.R;
import d0.t;
import o3.f;
import o3.f0;
import o3.l;
import o3.m0;
import o3.p;
import o3.z;

public abstract class DialogPreference extends Preference {
    public final CharSequence U;
    public final String V;
    public final Drawable W;
    public final String X;
    public final String Y;
    public final int Z;

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.a(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public void m() {
        androidx.fragment.app.t tVar;
        f0 f0Var = this.f1888i.f12135j;
        if (f0Var != null) {
            z zVar = (z) f0Var;
            for (c0 c0Var = zVar; c0Var != null; c0Var = c0Var.C) {
            }
            zVar.v();
            zVar.t();
            if (zVar.x().E("androidx.preference.PreferenceFragment.DIALOG") == null) {
                boolean z10 = this instanceof EditTextPreference;
                String str = this.f1898s;
                if (z10) {
                    tVar = new f();
                    Bundle bundle = new Bundle(1);
                    bundle.putString("key", str);
                    tVar.j0(bundle);
                } else if (this instanceof ListPreference) {
                    tVar = new l();
                    Bundle bundle2 = new Bundle(1);
                    bundle2.putString("key", str);
                    tVar.j0(bundle2);
                } else if (this instanceof MultiSelectListPreference) {
                    tVar = new p();
                    Bundle bundle3 = new Bundle(1);
                    bundle3.putString("key", str);
                    tVar.j0(bundle3);
                } else {
                    throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                }
                tVar.k0(zVar);
                tVar.q0(zVar.x(), "androidx.preference.PreferenceFragment.DIALOG");
            }
        }
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.f12151c, i10, 0);
        String f10 = t.f(obtainStyledAttributes, 9, 0);
        this.U = f10;
        if (f10 == null) {
            this.U = this.f1894o;
        }
        this.V = t.f(obtainStyledAttributes, 8, 1);
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        this.W = drawable == null ? obtainStyledAttributes.getDrawable(2) : drawable;
        this.X = t.f(obtainStyledAttributes, 11, 3);
        this.Y = t.f(obtainStyledAttributes, 10, 4);
        this.Z = obtainStyledAttributes.getResourceId(7, obtainStyledAttributes.getResourceId(5, 0));
        obtainStyledAttributes.recycle();
    }
}

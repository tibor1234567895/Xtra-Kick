package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import android.widget.TextView;
import com.woxthebox.draglistview.R;
import o3.l0;
import o3.m0;
import o3.n0;
import o3.o0;
import o3.q0;

public class SeekBarPreference extends Preference {
    public int U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public SeekBar Z;

    /* renamed from: a0  reason: collision with root package name */
    public TextView f1907a0;

    /* renamed from: b0  reason: collision with root package name */
    public final boolean f1908b0;

    /* renamed from: c0  reason: collision with root package name */
    public final boolean f1909c0;

    /* renamed from: d0  reason: collision with root package name */
    public final boolean f1910d0;

    /* renamed from: e0  reason: collision with root package name */
    public final n0 f1911e0 = new n0(0, this);

    /* renamed from: f0  reason: collision with root package name */
    public final o0 f1912f0 = new o0(this);

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0.f12159k, R.attr.seekBarPreferenceStyle, 0);
        this.V = obtainStyledAttributes.getInt(3, 0);
        int i10 = obtainStyledAttributes.getInt(1, 100);
        int i11 = this.V;
        i10 = i10 < i11 ? i11 : i10;
        if (i10 != this.W) {
            this.W = i10;
            h();
        }
        int i12 = obtainStyledAttributes.getInt(4, 0);
        if (i12 != this.X) {
            this.X = Math.min(this.W - this.V, Math.abs(i12));
            h();
        }
        this.f1908b0 = obtainStyledAttributes.getBoolean(2, true);
        this.f1909c0 = obtainStyledAttributes.getBoolean(5, false);
        this.f1910d0 = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    public final void l(l0 l0Var) {
        super.l(l0Var);
        l0Var.itemView.setOnKeyListener(this.f1912f0);
        this.Z = (SeekBar) l0Var.a(R.id.seekbar);
        TextView textView = (TextView) l0Var.a(R.id.seekbar_value);
        this.f1907a0 = textView;
        if (this.f1909c0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f1907a0 = null;
        }
        SeekBar seekBar = this.Z;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f1911e0);
        this.Z.setMax(this.W - this.V);
        int i10 = this.X;
        if (i10 != 0) {
            this.Z.setKeyProgressIncrement(i10);
        } else {
            this.X = this.Z.getKeyProgressIncrement();
        }
        this.Z.setProgress(this.U - this.V);
        int i11 = this.U;
        TextView textView2 = this.f1907a0;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i11));
        }
        this.Z.setEnabled(g());
    }

    public final Object o(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(q0.class)) {
            super.p(parcelable);
            return;
        }
        q0 q0Var = (q0) parcelable;
        super.p(q0Var.getSuperState());
        this.U = q0Var.f12167h;
        this.V = q0Var.f12168i;
        this.W = q0Var.f12169j;
        h();
    }

    public final Parcelable q() {
        this.Q = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1904y) {
            return absSavedState;
        }
        q0 q0Var = new q0(absSavedState);
        q0Var.f12167h = this.U;
        q0Var.f12168i = this.V;
        q0Var.f12169j = this.W;
        return q0Var;
    }

    public final void r(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int intValue = ((Integer) obj).intValue();
        if (x()) {
            intValue = this.f1888i.d().getInt(this.f1898s, intValue);
        }
        y(intValue, true);
    }

    public final void y(int i10, boolean z10) {
        int i11 = this.V;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.W;
        if (i10 > i12) {
            i10 = i12;
        }
        if (i10 != this.U) {
            this.U = i10;
            TextView textView = this.f1907a0;
            if (textView != null) {
                textView.setText(String.valueOf(i10));
            }
            if (x()) {
                int i13 = ~i10;
                boolean x10 = x();
                String str = this.f1898s;
                if (x10) {
                    i13 = this.f1888i.d().getInt(str, i13);
                }
                if (i10 != i13) {
                    SharedPreferences.Editor b10 = this.f1888i.b();
                    b10.putInt(str, i10);
                    if (!this.f1888i.f12130e) {
                        b10.apply();
                    }
                }
            }
            if (z10) {
                h();
            }
        }
    }

    public final void z(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.V;
        if (progress != this.U) {
            a(Integer.valueOf(progress));
            y(progress, false);
        }
    }
}

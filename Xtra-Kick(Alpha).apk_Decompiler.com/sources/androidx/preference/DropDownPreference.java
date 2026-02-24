package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.widget.v2;
import com.woxthebox.draglistview.R;
import o3.l0;

public class DropDownPreference extends ListPreference {

    /* renamed from: f0  reason: collision with root package name */
    public final ArrayAdapter f1875f0;

    /* renamed from: g0  reason: collision with root package name */
    public Spinner f1876g0;

    /* renamed from: h0  reason: collision with root package name */
    public final v2 f1877h0 = new v2(2, this);

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367049);
        this.f1875f0 = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.f1879a0;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    public final void A(CharSequence[] charSequenceArr) {
        this.f1879a0 = charSequenceArr;
        ArrayAdapter arrayAdapter = this.f1875f0;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr2 = this.f1879a0;
        if (charSequenceArr2 != null) {
            for (CharSequence charSequence : charSequenceArr2) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    public final void C(int i10) {
        B(this.f1880b0[i10].toString());
    }

    public final void h() {
        super.h();
        ArrayAdapter arrayAdapter = this.f1875f0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public final void l(l0 l0Var) {
        Spinner spinner = (Spinner) l0Var.itemView.findViewById(R.id.spinner);
        this.f1876g0 = spinner;
        spinner.setAdapter(this.f1875f0);
        this.f1876g0.setOnItemSelectedListener(this.f1877h0);
        Spinner spinner2 = this.f1876g0;
        String str = this.f1881c0;
        CharSequence[] charSequenceArr = this.f1880b0;
        int i10 = -1;
        if (str != null && charSequenceArr != null) {
            int length = charSequenceArr.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                } else if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    i10 = length;
                    break;
                } else {
                    length--;
                }
            }
        }
        spinner2.setSelection(i10);
        super.l(l0Var);
    }

    public final void m() {
        this.f1876g0.performClick();
    }
}

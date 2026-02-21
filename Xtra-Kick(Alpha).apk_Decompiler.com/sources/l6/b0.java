package l6;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.appcompat.widget.s0;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import java.util.ArrayList;
import ma.r;
import xa.j;

public final class b0 extends n {

    /* renamed from: w0  reason: collision with root package name */
    public static final z f9590w0 = new z(0);

    /* renamed from: v0  reason: collision with root package name */
    public a0 f9591v0;

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.common.RadioButtonDialogFragment.OnSortOptionChanged", c0Var);
        this.f9591v0 = (a0) c0Var;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Integer num;
        j.f("inflater", layoutInflater);
        Context f02 = f0();
        Bundle e02 = e0();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        RadioGroup radioGroup = new RadioGroup(f02);
        radioGroup.setLayoutParams(layoutParams);
        int i10 = e02.getInt("checked");
        y yVar = new y(i10, this, e02);
        int[] intArray = e02.getIntArray("tags");
        ArrayList<CharSequence> charSequenceArrayList = e02.getCharSequenceArrayList("labels");
        if (charSequenceArrayList != null) {
            int i11 = 0;
            for (T next : charSequenceArrayList) {
                int i12 = i11 + 1;
                if (i11 >= 0) {
                    s0 s0Var = new s0(f02, (AttributeSet) null, 0);
                    s0Var.setId(i11);
                    s0Var.setText((CharSequence) next);
                    if (intArray == null || i11 < 0 || i11 > intArray.length - 1) {
                        num = null;
                    } else {
                        num = Integer.valueOf(intArray[i11]);
                    }
                    s0Var.setTag(num);
                    s0Var.setOnClickListener(yVar);
                    radioGroup.addView(s0Var, layoutParams);
                    i11 = i12;
                } else {
                    r.h();
                    throw null;
                }
            }
        }
        radioGroup.check(i10);
        NestedScrollView nestedScrollView = new NestedScrollView(f02, (AttributeSet) null);
        nestedScrollView.addView(radioGroup);
        return nestedScrollView;
    }
}

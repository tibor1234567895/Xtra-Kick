package o3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.activity.h;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.woxthebox.draglistview.R;
import h.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class g extends Preference {
    public final long U;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, ArrayList arrayList, long j10) {
        super(context, (AttributeSet) null);
        CharSequence charSequence = null;
        this.L = R.layout.expand_button;
        Context context2 = this.f1887h;
        Drawable a10 = a.a(context2, R.drawable.ic_arrow_down_24dp);
        if (this.f1897r != a10) {
            this.f1897r = a10;
            this.f1896q = 0;
            h();
        }
        this.f1896q = R.drawable.ic_arrow_down_24dp;
        String string = context2.getString(R.string.expand_button_title);
        if (!TextUtils.equals(string, this.f1894o)) {
            this.f1894o = string;
            h();
        }
        if (999 != this.f1893n) {
            this.f1893n = 999;
            d0 d0Var = this.N;
            if (d0Var != null) {
                Handler handler = d0Var.f12116e;
                h hVar = d0Var.f12117f;
                handler.removeCallbacks(hVar);
                handler.post(hVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Preference preference = (Preference) it.next();
            CharSequence charSequence2 = preference.f1894o;
            boolean z10 = preference instanceof PreferenceGroup;
            if (z10 && !TextUtils.isEmpty(charSequence2)) {
                arrayList2.add((PreferenceGroup) preference);
            }
            if (arrayList2.contains(preference.P)) {
                if (z10) {
                    arrayList2.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequence2)) {
                if (charSequence == null) {
                    charSequence = charSequence2;
                } else {
                    charSequence = this.f1887h.getString(R.string.summary_collapsed_preference_list, new Object[]{charSequence, charSequence2});
                }
            }
        }
        v(charSequence);
        this.U = j10 + 1000000;
    }

    public final long d() {
        return this.U;
    }

    public final void l(l0 l0Var) {
        super.l(l0Var);
        l0Var.f12147k = false;
    }
}

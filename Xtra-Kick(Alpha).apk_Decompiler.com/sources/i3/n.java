package i3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;

public final class n extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f8144a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f8145b;

    /* renamed from: c  reason: collision with root package name */
    public int f8146c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w f8147d;

    public n(w wVar, String[] strArr, float[] fArr) {
        this.f8147d = wVar;
        this.f8144a = strArr;
        this.f8145b = fArr;
    }

    public final int getItemCount() {
        return this.f8144a.length;
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        View view;
        r rVar = (r) k2Var;
        String[] strArr = this.f8144a;
        if (i10 < strArr.length) {
            rVar.f8159h.setText(strArr[i10]);
        }
        int i11 = 0;
        if (i10 == this.f8146c) {
            rVar.itemView.setSelected(true);
            view = rVar.f8160i;
        } else {
            rVar.itemView.setSelected(false);
            view = rVar.f8160i;
            i11 = 4;
        }
        view.setVisibility(i11);
        rVar.itemView.setOnClickListener(new m(this, i10));
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new r(LayoutInflater.from(this.f8147d.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}

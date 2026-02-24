package t6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import java.util.List;
import xa.j;

public final class k0 extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public final List f14618a;

    /* renamed from: b  reason: collision with root package name */
    public final LayoutInflater f14619b;

    public k0(Context context, List list) {
        j.f("data", list);
        this.f14618a = list;
        LayoutInflater from = LayoutInflater.from(context);
        j.e("from(context)", from);
        this.f14619b = from;
    }

    public final int getItemCount() {
        return this.f14618a.size();
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        j0 j0Var = (j0) k2Var;
        j.f("holder", j0Var);
        j0Var.f14615h.setText((String) this.f14618a.get(i10));
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        View inflate = this.f14619b.inflate(R.layout.fragment_viewer_list_item, viewGroup, false);
        j.e("view", inflate);
        return new j0(inflate);
    }
}

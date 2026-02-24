package t6;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.List;
import l6.n;
import ma.z;
import xa.j;

public final class w extends n {

    /* renamed from: w0  reason: collision with root package name */
    public static final u f14668w0 = new u(0);

    /* renamed from: v0  reason: collision with root package name */
    public v f14669v0;

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.player.PlayerGamesDialog.PlayerSeekListener", c0Var);
        this.f14669v0 = (v) c0Var;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        List list;
        ArrayList parcelableArrayList;
        j.f("inflater", layoutInflater);
        Context f02 = f0();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        GridRecyclerView gridRecyclerView = new GridRecyclerView(f02);
        gridRecyclerView.setId(R.id.recyclerView);
        gridRecyclerView.setLayoutParams(layoutParams);
        z zVar = new z(this);
        Bundle bundle = this.f1357m;
        if (bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("games_list")) == null) {
            list = null;
        } else {
            list = z.J(parcelableArrayList);
        }
        zVar.a(list);
        gridRecyclerView.setAdapter(zVar);
        NestedScrollView nestedScrollView = new NestedScrollView(f02, (AttributeSet) null);
        nestedScrollView.addView(gridRecyclerView);
        return nestedScrollView;
    }
}

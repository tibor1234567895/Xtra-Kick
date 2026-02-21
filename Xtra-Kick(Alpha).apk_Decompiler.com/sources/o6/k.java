package o6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum;
import com.github.andreyasadchy.xtra.model.ui.FollowSortEnum;
import com.woxthebox.draglistview.R;
import e4.a;
import java.io.Serializable;
import l6.n;
import la.g;
import xa.j;
import z5.b;

public final class k extends n {

    /* renamed from: x0  reason: collision with root package name */
    public static final h f12260x0 = new h(0);

    /* renamed from: v0  reason: collision with root package name */
    public b f12261v0;

    /* renamed from: w0  reason: collision with root package name */
    public i f12262w0;

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsSortDialog.OnFilter", c0Var);
        this.f12262w0 = (i) c0Var;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.dialog_followed_channels_sort, viewGroup, false);
        int i10 = R.id.alphabetically;
        if (((RadioButton) a.a(inflate, R.id.alphabetically)) != null) {
            i10 = R.id.apply;
            Button button = (Button) a.a(inflate, R.id.apply);
            if (button != null) {
                i10 = R.id.last_broadcast;
                if (((RadioButton) a.a(inflate, R.id.last_broadcast)) != null) {
                    i10 = R.id.newest_first;
                    if (((RadioButton) a.a(inflate, R.id.newest_first)) != null) {
                        i10 = R.id.oldest_first;
                        if (((RadioButton) a.a(inflate, R.id.oldest_first)) != null) {
                            i10 = R.id.order;
                            RadioGroup radioGroup = (RadioGroup) a.a(inflate, R.id.order);
                            if (radioGroup != null) {
                                i10 = R.id.saveDefault;
                                CheckBox checkBox = (CheckBox) a.a(inflate, R.id.saveDefault);
                                if (checkBox != null) {
                                    i10 = R.id.sort;
                                    RadioGroup radioGroup2 = (RadioGroup) a.a(inflate, R.id.sort);
                                    if (radioGroup2 != null) {
                                        i10 = R.id.time_followed;
                                        if (((RadioButton) a.a(inflate, R.id.time_followed)) != null) {
                                            NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                                            this.f12261v0 = new b(nestedScrollView, button, radioGroup, checkBox, radioGroup2);
                                            j.e("binding.root", nestedScrollView);
                                            return nestedScrollView;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f12261v0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        int i10;
        int i11;
        j.f("view", view);
        b bVar = this.f12261v0;
        j.c(bVar);
        Bundle e02 = e0();
        Serializable serializable = e02.getSerializable("sort");
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.FollowSortEnum", serializable);
        int i12 = j.f12259a[((FollowSortEnum) serializable).ordinal()];
        if (i12 == 1) {
            i10 = R.id.time_followed;
        } else if (i12 == 2) {
            i10 = R.id.alphabetically;
        } else if (i12 == 3) {
            i10 = R.id.last_broadcast;
        } else {
            throw new g();
        }
        Serializable serializable2 = e02.getSerializable("order");
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum", serializable2);
        if (((FollowOrderEnum) serializable2) == FollowOrderEnum.DESC) {
            i11 = R.id.newest_first;
        } else {
            i11 = R.id.oldest_first;
        }
        boolean z10 = e02.getBoolean("save_default");
        bVar.f17594d.check(i10);
        bVar.f17592b.check(i11);
        bVar.f17593c.setChecked(z10);
        bVar.f17591a.setOnClickListener(new g(bVar, i10, i11, z10, view, this));
    }
}

package j7;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.j3;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import com.woxthebox.draglistview.R;
import e4.a;
import i3.i;
import java.io.Serializable;
import l6.n;
import l6.y;
import xa.j;

public final class h extends n {

    /* renamed from: x0  reason: collision with root package name */
    public static final f f8838x0 = new f(0);

    /* renamed from: v0  reason: collision with root package name */
    public j3 f8839v0;

    /* renamed from: w0  reason: collision with root package name */
    public g f8840w0;

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.streams.common.StreamsSortDialog.OnFilter", c0Var);
        this.f8840w0 = (g) c0Var;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.dialog_streams_sort, viewGroup, false);
        int i10 = R.id.apply;
        Button button = (Button) a.a(inflate, R.id.apply);
        if (button != null) {
            i10 = R.id.selectTags;
            Button button2 = (Button) a.a(inflate, R.id.selectTags);
            if (button2 != null) {
                i10 = R.id.sort;
                RadioGroup radioGroup = (RadioGroup) a.a(inflate, R.id.sort);
                if (radioGroup != null) {
                    i10 = R.id.viewers_high;
                    RadioButton radioButton = (RadioButton) a.a(inflate, R.id.viewers_high);
                    if (radioButton != null) {
                        i10 = R.id.viewers_low;
                        RadioButton radioButton2 = (RadioButton) a.a(inflate, R.id.viewers_low);
                        if (radioButton2 != null) {
                            NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                            this.f8839v0 = new j3(nestedScrollView, button, button2, radioGroup, radioButton, radioButton2);
                            j.e("binding.root", nestedScrollView);
                            return nestedScrollView;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f8839v0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        int i10;
        j.f("view", view);
        j3 j3Var = this.f8839v0;
        j.c(j3Var);
        Serializable serializable = e0().getSerializable("sort");
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.ui.StreamSortEnum", serializable);
        if (((StreamSortEnum) serializable) == StreamSortEnum.VIEWERS_HIGH) {
            i10 = R.id.viewers_high;
        } else {
            i10 = R.id.viewers_low;
        }
        ((RadioGroup) j3Var.f897d).check(i10);
        ((Button) j3Var.f895b).setOnClickListener(new y(j3Var, i10, this));
        ((Button) j3Var.f896c).setOnClickListener(new i(17, this));
    }
}

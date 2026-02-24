package o6;

import android.view.View;
import android.widget.RadioButton;
import com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum;
import com.github.andreyasadchy.xtra.model.ui.FollowSortEnum;
import com.woxthebox.draglistview.R;
import hb.h0;
import pa.e;
import pa.h;
import xa.j;
import z5.b;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ b f12253h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f12254i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12255j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f12256k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ View f12257l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ k f12258m;

    public /* synthetic */ g(b bVar, int i10, int i11, boolean z10, View view, k kVar) {
        this.f12253h = bVar;
        this.f12254i = i10;
        this.f12255j = i11;
        this.f12256k = z10;
        this.f12257l = view;
        this.f12258m = kVar;
    }

    public final void onClick(View view) {
        FollowSortEnum followSortEnum;
        FollowOrderEnum followOrderEnum;
        h hVar = k.f12260x0;
        b bVar = this.f12253h;
        j.f("$this_with", bVar);
        View view2 = this.f12257l;
        j.f("$view", view2);
        k kVar = this.f12258m;
        j.f("this$0", kVar);
        int checkedRadioButtonId = bVar.f17594d.getCheckedRadioButtonId();
        int checkedRadioButtonId2 = bVar.f17592b.getCheckedRadioButtonId();
        boolean isChecked = bVar.f17593c.isChecked();
        if (!(checkedRadioButtonId == this.f12254i && checkedRadioButtonId2 == this.f12255j && isChecked == this.f12256k)) {
            RadioButton radioButton = (RadioButton) view2.findViewById(checkedRadioButtonId);
            RadioButton radioButton2 = (RadioButton) view2.findViewById(checkedRadioButtonId2);
            i iVar = kVar.f12262w0;
            if (iVar != null) {
                if (checkedRadioButtonId == R.id.time_followed) {
                    followSortEnum = FollowSortEnum.FOLLOWED_AT;
                } else if (checkedRadioButtonId == R.id.alphabetically) {
                    followSortEnum = FollowSortEnum.ALPHABETICALLY;
                } else {
                    followSortEnum = FollowSortEnum.LAST_BROADCAST;
                }
                FollowSortEnum followSortEnum2 = followSortEnum;
                CharSequence text = radioButton.getText();
                j.e("sortBtn.text", text);
                if (checkedRadioButtonId2 == R.id.newest_first) {
                    followOrderEnum = FollowOrderEnum.DESC;
                } else {
                    followOrderEnum = FollowOrderEnum.ASC;
                }
                FollowOrderEnum followOrderEnum2 = followOrderEnum;
                CharSequence text2 = radioButton2.getText();
                j.e("orderBtn.text", text2);
                e eVar = (e) iVar;
                j.f("sort", followSortEnum2);
                j.f("order", followOrderEnum2);
                h0.b1(h0.v0(eVar.C()), (h) null, 0, new d(eVar, followSortEnum2, followOrderEnum2, text, text2, isChecked, (e) null), 3);
            } else {
                j.l("listener");
                throw null;
            }
        }
        kVar.l0();
    }
}

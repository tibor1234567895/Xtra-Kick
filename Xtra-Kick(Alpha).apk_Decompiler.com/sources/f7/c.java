package f7;

import android.os.Bundle;
import android.view.View;
import com.github.andreyasadchy.xtra.model.ui.Tag;
import com.woxthebox.draglistview.R;
import hb.h0;
import j3.k0;
import j3.n1;
import l7.a;
import l7.b;
import q6.u;
import q6.v;
import xa.j;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5911h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f5912i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Tag f5913j;

    public /* synthetic */ c(d dVar, Tag tag, int i10) {
        this.f5911h = i10;
        this.f5912i = dVar;
        this.f5913j = tag;
    }

    public final void onClick(View view) {
        int i10 = this.f5911h;
        Tag tag = this.f5913j;
        d dVar = this.f5912i;
        switch (i10) {
            case 0:
                j.f("this$0", dVar);
                k0 V = h0.V(dVar.f5916i);
                u uVar = v.f13392a;
                String[] strArr = {tag.getId()};
                uVar.getClass();
                y5.u.f17067a.getClass();
                V.getClass();
                Bundle bundle = new Bundle();
                bundle.putStringArray("tags", strArr);
                V.k(R.id.action_global_gamesFragment, bundle, (n1) null);
                return;
            default:
                j.f("this$0", dVar);
                k0 V2 = h0.V(dVar.f5916i);
                a aVar = b.f9685a;
                String[] strArr2 = {tag.getName()};
                aVar.getClass();
                y5.u.f17067a.getClass();
                V2.getClass();
                Bundle bundle2 = new Bundle();
                bundle2.putStringArray("tags", strArr2);
                V2.k(R.id.action_global_topFragment, bundle2, (n1) null);
                return;
        }
    }
}

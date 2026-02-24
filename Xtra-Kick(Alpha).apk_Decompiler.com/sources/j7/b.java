package j7;

import android.view.View;
import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel;
import f7.l;
import f7.m;
import hb.h0;
import la.i;
import xa.j;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8828h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f8829i;

    public /* synthetic */ b(d dVar, int i10) {
        this.f8828h = i10;
        this.f8829i = dVar;
    }

    public final void onClick(View view) {
        int i10 = this.f8828h;
        d dVar = this.f8829i;
        switch (i10) {
            case 0:
                int i11 = d.f8833t0;
                j.f("this$0", dVar);
                f fVar = h.f8838x0;
                StreamSortEnum streamSortEnum = ((i) ((StreamsViewModel) dVar.f8836r0.getValue()).f3508f.getValue()).f8841a;
                fVar.getClass();
                h hVar = new h();
                hVar.j0(h0.r(new i("sort", streamSortEnum)));
                hVar.q0(dVar.u(), (String) null);
                return;
            default:
                int i12 = d.f8833t0;
                j.f("this$0", dVar);
                h0.V(dVar).m(l.a(m.f5938a, 0, (String) null, false, 31));
                return;
        }
    }
}

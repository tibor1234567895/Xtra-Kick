package z6;

import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import hb.d1;
import hb.h0;
import java.util.List;
import java.util.Map;
import la.v;
import m6.w;
import m6.z;
import pa.h;
import wa.l;
import xa.j;
import xa.k;

public final class e extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f17749h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g f17750i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(g gVar, int i10) {
        super(1);
        this.f17749h = i10;
        this.f17750i = gVar;
    }

    public final Object invoke(Object obj) {
        boolean z10 = true;
        int i10 = this.f17749h;
        g gVar = this.f17750i;
        switch (i10) {
            case 0:
                Map map = (Map) obj;
                d dVar = gVar.f17756q0;
                if (dVar != null) {
                    j.e("it", map);
                    dVar.f17747g = map;
                    List list = dVar.f2224a.f2038f;
                    if (list != null && !list.isEmpty()) {
                        z10 = false;
                    }
                    if (!z10) {
                        dVar.notifyDataSetChanged();
                    }
                    return v.f9814a;
                }
                j.l("adapter");
                throw null;
            case 1:
                List list2 = (List) obj;
                d dVar2 = gVar.f17756q0;
                if (dVar2 != null) {
                    j.e("it", list2);
                    dVar2.f17748h = list2;
                    List list3 = dVar2.f2224a.f2038f;
                    if (list3 != null && !list3.isEmpty()) {
                        z10 = false;
                    }
                    if (!z10) {
                        dVar2.notifyDataSetChanged();
                    }
                    return v.f9814a;
                }
                j.l("adapter");
                throw null;
            case 2:
                int i11 = g.f17753r0;
                BookmarksViewModel q02 = gVar.q0();
                h0.b1(h0.I0(q02), (h) null, 0, new j((String) obj, gVar.f0(), q02, (pa.e) null), 3);
                return v.f9814a;
            case 3:
                Video video = (Video) obj;
                j.f("it", video);
                z.D0.getClass();
                w.a(video).q0(gVar.u(), (String) null);
                return v.f9814a;
            default:
                int intValue = ((Number) obj).intValue();
                int i12 = g.f17753r0;
                h0.b1(d1.f7786h, (h) null, 0, new l(gVar.q0(), intValue, (pa.e) null), 3);
                return v.f9814a;
        }
    }
}

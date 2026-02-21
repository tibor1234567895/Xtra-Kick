package m7;

import java.util.List;
import java.util.Map;
import la.v;
import wa.l;
import xa.j;
import xa.k;

public final class b extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10681h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ a f10682i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(a aVar, int i10) {
        super(1);
        this.f10681h = i10;
        this.f10682i = aVar;
    }

    public final Object invoke(Object obj) {
        int i10 = this.f10681h;
        a aVar = this.f10682i;
        switch (i10) {
            case 0:
                Map map = (Map) obj;
                j.e("it", map);
                aVar.getClass();
                aVar.f10679d = map;
                if (aVar.getItemCount() != 0) {
                    aVar.notifyDataSetChanged();
                }
                return v.f9814a;
            default:
                List list = (List) obj;
                j.e("it", list);
                aVar.getClass();
                aVar.f10680e = list;
                return v.f9814a;
        }
    }
}

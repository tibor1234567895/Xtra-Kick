package m;

import android.support.v4.media.h;
import android.view.MenuItem;
import e.a;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import la.v;
import t9.w;

public final class g implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9912h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9913i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9914j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9915k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9916l;

    public g(a aVar, h hVar, q qVar, o oVar) {
        this.f9912h = 0;
        this.f9916l = aVar;
        this.f9913i = hVar;
        this.f9914j = qVar;
        this.f9915k = oVar;
    }

    private final void a() {
        synchronized (((v9.a) this.f9913i).f15970a) {
            Iterator it = ((v9.a) this.f9913i).f15970a.iterator();
            if (!it.hasNext()) {
                v vVar = v.f9814a;
            } else {
                h.y(it.next());
                throw null;
            }
        }
    }

    public final void run() {
        switch (this.f9912h) {
            case 0:
                h hVar = (h) this.f9913i;
                if (hVar != null) {
                    a aVar = (a) this.f9916l;
                    ((i) aVar.f4852i).H = true;
                    hVar.f9918b.c(false);
                    ((i) aVar.f4852i).H = false;
                }
                MenuItem menuItem = (MenuItem) this.f9914j;
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    ((o) this.f9915k).q(menuItem, (c0) null, 4);
                    return;
                }
                return;
            case 1:
                synchronized (((w) this.f9913i).f14914a.f17664b) {
                    Iterator it = ((List) ((w) this.f9913i).f14914a.f17670h).iterator();
                    if (!it.hasNext()) {
                        v vVar = v.f9814a;
                    } else {
                        h.y(it.next());
                        throw null;
                    }
                }
                return;
            default:
                a();
                return;
        }
    }

    public /* synthetic */ g(Object obj, Object obj2, Enum enumR, Serializable serializable, int i10) {
        this.f9912h = i10;
        this.f9913i = obj;
        this.f9914j = obj2;
        this.f9915k = enumR;
        this.f9916l = serializable;
    }
}

package androidx.recyclerview.widget;

import android.support.v4.media.j;
import java.util.List;
import p9.b;
import p9.l;
import t9.w;

public final class f implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1973h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f1974i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1975j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f1976k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1977l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f1978m;

    public f(h hVar, List list, List list2, int i10) {
        this.f1978m = hVar;
        this.f1975j = list;
        this.f1976k = list2;
        this.f1974i = i10;
        this.f1977l = null;
    }

    public final void run() {
        int i10 = this.f1973h;
        Object obj = this.f1978m;
        switch (i10) {
            case 0:
                ((h) obj).f2035c.execute(new j((Object) this, 5, (Object) a0.a(new e(this))));
                return;
            default:
                ((l) this.f1976k).g((b) obj, (List) this.f1975j, this.f1974i);
                return;
        }
    }

    public /* synthetic */ f(l lVar, w wVar, b bVar, List list, int i10) {
        this.f1976k = lVar;
        this.f1977l = wVar;
        this.f1978m = bVar;
        this.f1975j = list;
        this.f1974i = i10;
    }
}

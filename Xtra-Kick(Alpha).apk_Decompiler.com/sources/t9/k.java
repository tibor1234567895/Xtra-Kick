package t9;

import android.util.Log;
import androidx.fragment.app.y;
import hb.h0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import la.i;
import la.v;
import p9.b;
import p9.f;
import p9.u;
import p9.x;
import q9.e;
import wa.a;
import xa.j;
import y9.l;

public final class k extends xa.k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14863h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f14864i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ i f14865j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i f14866k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f14867l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(m mVar, Object obj, i iVar, i iVar2, int i10) {
        super(0);
        this.f14863h = i10;
        this.f14864i = mVar;
        this.f14867l = obj;
        this.f14865j = iVar;
        this.f14866k = iVar2;
    }

    public final void a() {
        String str;
        int i10 = this.f14863h;
        i iVar = this.f14866k;
        m mVar = this.f14864i;
        Object obj = this.f14867l;
        switch (i10) {
            case 0:
                try {
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList = new ArrayList();
                    for (Object next : (List) obj) {
                        if (hashSet.add(((u) next).f12721t)) {
                            arrayList.add(next);
                        }
                    }
                    if (arrayList.size() == ((List) obj).size()) {
                        ArrayList k10 = mVar.f14883j.k((List) obj);
                        Iterator it = k10.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) ((i) it.next()).f9799h;
                            int ordinal = ((e) bVar).f13442q.ordinal();
                            l lVar = mVar.f14884k;
                            z5.i iVar2 = mVar.f14885l;
                            if (ordinal == 1) {
                                e P = mVar.f14886m.P();
                                h0.T1(bVar, P);
                                P.K(x.ADDED);
                                ((p9.l) iVar2.f17667e).f(P);
                                lVar.a("Added " + bVar);
                                ((p9.l) iVar2.f17667e).c(bVar, false);
                                str = "Queued " + bVar + " for download";
                            } else if (ordinal == 4) {
                                ((p9.l) iVar2.f17667e).a(bVar);
                                str = "Completed download " + bVar;
                            } else if (ordinal == 9) {
                                ((p9.l) iVar2.f17667e).f(bVar);
                                str = "Added " + bVar;
                            }
                            lVar.a(str);
                        }
                        mVar.f14882i.post(new j(this, 0, k10));
                        return;
                    }
                    throw new y("request_list_not_distinct");
                } catch (Exception e10) {
                    l lVar2 = mVar.f14884k;
                    String str2 = "Failed to enqueue list " + ((List) obj);
                    lVar2.getClass();
                    j.g("message", str2);
                    if (lVar2.f17265a) {
                        Log.e(lVar2.c(), str2);
                    }
                    f h02 = h0.h0(e10.getMessage());
                    if (iVar != null) {
                        mVar.f14882i.post(new j(this, 1, h02));
                        return;
                    }
                    return;
                }
            default:
                try {
                    List<b> list = (List) ((a) obj).b();
                    for (b bVar2 : list) {
                        mVar.f14884k.a("Deleted download " + bVar2);
                        ((p9.l) mVar.f14885l.f17667e).j(bVar2);
                    }
                    mVar.f14882i.post(new j(this, 2, list));
                    return;
                } catch (Exception e11) {
                    mVar.f14884k.b("Fetch with namespace " + mVar.f14879f + " error", e11);
                    f h03 = h0.h0(e11.getMessage());
                    if (iVar != null) {
                        mVar.f14882i.post(new j(this, 3, h03));
                        return;
                    }
                    return;
                }
        }
    }

    public final /* bridge */ /* synthetic */ Object b() {
        switch (this.f14863h) {
            case 0:
                a();
                return v.f9814a;
            default:
                a();
                return v.f9814a;
        }
    }
}

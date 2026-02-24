package r1;

import a2.i;
import a2.j;
import a2.k;
import android.net.Uri;
import android.os.SystemClock;
import d6.c;
import j1.l0;
import j1.z;
import java.util.HashMap;
import java.util.List;

public final class b implements v {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13529h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f13530i;

    public /* synthetic */ b(int i10, Object obj) {
        this.f13529h = i10;
        this.f13530i = obj;
    }

    public final void a() {
        int i10 = this.f13529h;
        Object obj = this.f13530i;
        switch (i10) {
            case 0:
                ((d) obj).f13547l.remove(this);
                return;
            default:
                ((c) obj).f4526l.remove(this);
                return;
        }
    }

    public final boolean b(Uri uri, z zVar, boolean z10) {
        d6.b bVar;
        c cVar;
        int i10 = this.f13529h;
        Object obj = this.f13530i;
        switch (i10) {
            case 0:
                d dVar = (d) obj;
                if (dVar.f13554s == null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    o oVar = dVar.f13552q;
                    int i11 = l0.f8453a;
                    List list = oVar.f13612e;
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        int size = list.size();
                        HashMap hashMap = dVar.f13546k;
                        if (i12 < size) {
                            c cVar2 = (c) hashMap.get(((n) list.get(i12)).f13604a);
                            if (cVar2 != null && elapsedRealtime < cVar2.f13538o) {
                                i13++;
                            }
                            i12++;
                        } else {
                            j jVar = new j(1, 0, dVar.f13552q.f13612e.size(), i13);
                            dVar.f13545j.getClass();
                            k a10 = i.a(jVar, zVar);
                            if (!(a10 == null || a10.f59a != 2 || (cVar = (c) hashMap.get(uri)) == null)) {
                                c.a(cVar, a10.f60b);
                            }
                        }
                    }
                }
                return false;
            default:
                c cVar3 = (c) obj;
                if (cVar3.f4533s == null) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    o oVar2 = cVar3.f4531q;
                    int i14 = l0.f8453a;
                    List list2 = oVar2.f13612e;
                    int i15 = 0;
                    int i16 = 0;
                    while (true) {
                        int size2 = list2.size();
                        HashMap hashMap2 = cVar3.f4525k;
                        if (i15 < size2) {
                            d6.b bVar2 = (d6.b) hashMap2.get(((n) list2.get(i15)).f13604a);
                            if (bVar2 != null && elapsedRealtime2 < bVar2.f4517o) {
                                i16++;
                            }
                            i15++;
                        } else {
                            j jVar2 = new j(1, 0, cVar3.f4531q.f13612e.size(), i16);
                            cVar3.f4524j.getClass();
                            k a11 = i.a(jVar2, zVar);
                            if (!(a11 == null || a11.f59a != 2 || (bVar = (d6.b) hashMap2.get(uri)) == null)) {
                                d6.b.a(bVar, a11.f60b);
                            }
                        }
                    }
                }
                return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar) {
        this(1, cVar);
        this.f13529h = 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar) {
        this(0, dVar);
        this.f13529h = 0;
    }
}

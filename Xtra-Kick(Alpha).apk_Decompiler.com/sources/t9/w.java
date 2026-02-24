package t9;

import android.os.Handler;
import androidx.appcompat.widget.k1;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l.h;
import m.g;
import m0.u1;
import p9.b;
import p9.f;
import p9.l;
import q9.e;
import xa.j;
import y9.d;
import y9.v;
import z5.i;

public final class w implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f14914a;

    public w(i iVar) {
        this.f14914a = iVar;
    }

    public final void a(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new s(this, bVar, 1));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 2));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_COMPLETED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_COMPLETED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void b(b bVar, f fVar, Throwable th) {
        j.g("download", bVar);
        j.g("error", fVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new g(this, bVar, fVar, th, 1));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new u1(lVar, this, bVar, fVar, th));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_ERROR);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_ERROR);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void c(b bVar, boolean z10) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new v(lVar, bVar, z10));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_QUEUED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_QUEUED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void d(b bVar, long j10, long j11) {
        b bVar2 = bVar;
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new t(this, bVar));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new u(lVar, bVar, j10, j11));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar2).f13437l, bVar, v.DOWNLOAD_PROGRESS_CHANGED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar2).f13437l, bVar, v.DOWNLOAD_PROGRESS_CHANGED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar2).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void e(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new s(this, bVar, 4));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 5));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_REMOVED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_REMOVED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void f(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 0));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_ADDED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_ADDED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void g(b bVar, List list, int i10) {
        j.g("download", bVar);
        j.g("downloadBlocks", list);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new k1(this, bVar, i10));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new androidx.recyclerview.widget.f(lVar, this, bVar, list, i10));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_STARTED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_STARTED);
            }
            List<WeakReference> list2 = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list2 != null) {
                for (WeakReference weakReference : list2) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void h(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 7));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_WAITING_ON_NETWORK);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_WAITING_ON_NETWORK);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void i(e eVar, d dVar, int i10) {
        j.g("download", eVar);
        j.g("downloadBlock", dVar);
        synchronized (this.f14914a.f17664b) {
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        lVar.i(eVar, dVar, i10);
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(eVar.f13437l, eVar, v.DOWNLOAD_BLOCK_UPDATED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            }
            la.v vVar = la.v.f9814a;
        }
    }

    public final void j(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new s(this, bVar, 2));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 3));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_DELETED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_DELETED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void k(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new s(this, bVar, 3));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 4));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_PAUSED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_PAUSED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void l(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new s(this, bVar, 5));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 6));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_RESUMED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_RESUMED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }

    public final void m(b bVar) {
        j.g("download", bVar);
        synchronized (this.f14914a.f17664b) {
            ((Handler) this.f14914a.f17671i).post(new s(this, bVar, 0));
            for (Set it : ((Map) this.f14914a.f17665c).values()) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    l lVar = (l) ((WeakReference) it2.next()).get();
                    if (lVar == null) {
                        it2.remove();
                    } else {
                        ((Handler) this.f14914a.f17669g).post(new r(lVar, bVar, 1));
                    }
                }
            }
            if (!((Map) this.f14914a.f17668f).isEmpty()) {
                ((h) this.f14914a.f17674l).q(((e) bVar).f13437l, bVar, v.DOWNLOAD_CANCELLED);
                for (Set it3 : ((Map) this.f14914a.f17668f).values()) {
                    Iterator it4 = it3.iterator();
                    while (it4.hasNext()) {
                        android.support.v4.media.h.y(((WeakReference) it4.next()).get());
                        it4.remove();
                    }
                }
            } else {
                ((h) this.f14914a.f17674l).u(((e) bVar).f13437l, bVar, v.DOWNLOAD_CANCELLED);
            }
            List<WeakReference> list = (List) ((Map) this.f14914a.f17672j).get(Integer.valueOf(((e) bVar).f13433h));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    android.support.v4.media.h.y(weakReference.get());
                }
                la.v vVar = la.v.f9814a;
            }
        }
    }
}

package d9;

import c9.q;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class e implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4604h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Iterator f4605i;

    /* renamed from: j  reason: collision with root package name */
    public Object f4606j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f4607k;

    public e(f fVar) {
        this.f4607k = fVar;
        this.f4605i = fVar.f4611k.entrySet().iterator();
    }

    public final void a() {
        Object obj = this.f4607k;
        ((n) obj).b();
        if (((n) obj).f4635i != ((Collection) this.f4606j)) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        int i10 = this.f4604h;
        Iterator it = this.f4605i;
        switch (i10) {
            case 0:
                return it.hasNext();
            case 1:
                return it.hasNext();
            default:
                a();
                return it.hasNext();
        }
    }

    public final Object next() {
        int i10 = this.f4604h;
        Iterator it = this.f4605i;
        switch (i10) {
            case 0:
                Map.Entry entry = (Map.Entry) it.next();
                this.f4606j = (Collection) entry.getValue();
                return ((f) this.f4607k).c(entry);
            case 1:
                Map.Entry entry2 = (Map.Entry) it.next();
                this.f4606j = entry2;
                return entry2.getKey();
            default:
                a();
                return it.next();
        }
    }

    public final void remove() {
        boolean z10 = false;
        int i10 = this.f4604h;
        Object obj = this.f4607k;
        Iterator it = this.f4605i;
        switch (i10) {
            case 0:
                if (((Collection) this.f4606j) != null) {
                    z10 = true;
                }
                q.f("no calls to next() since the last call to remove()", z10);
                it.remove();
                ((f) obj).f4612l.f4593m -= ((Collection) this.f4606j).size();
                ((Collection) this.f4606j).clear();
                this.f4606j = null;
                return;
            case 1:
                if (((Map.Entry) this.f4606j) != null) {
                    z10 = true;
                }
                q.f("no calls to next() since the last call to remove()", z10);
                Collection collection = (Collection) ((Map.Entry) this.f4606j).getValue();
                it.remove();
                ((h) obj).f4621i.f4593m -= collection.size();
                collection.clear();
                this.f4606j = null;
                return;
            default:
                it.remove();
                n nVar = (n) obj;
                b bVar = nVar.f4638l;
                bVar.f4593m--;
                nVar.c();
                return;
        }
    }

    public e(h hVar, Iterator it) {
        this.f4607k = hVar;
        this.f4605i = it;
    }

    public e(n nVar) {
        this.f4607k = nVar;
        Collection collection = nVar.f4635i;
        this.f4606j = collection;
        this.f4605i = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public e(n nVar, ListIterator listIterator) {
        this.f4607k = nVar;
        this.f4606j = nVar.f4635i;
        this.f4605i = listIterator;
    }
}

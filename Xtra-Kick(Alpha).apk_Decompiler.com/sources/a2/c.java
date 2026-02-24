package a2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import n1.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f21a = new CopyOnWriteArrayList();

    public final void a(a aVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f21a;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f19b == aVar) {
                bVar.f20c = true;
                copyOnWriteArrayList.remove(bVar);
            }
        }
    }
}

package androidx.recyclerview.widget;

import android.support.v4.media.session.u;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class w0 extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public final h f2224a;

    public w0(w wVar) {
        v0 v0Var = new v0(this);
        c cVar = new c(this);
        d dVar = new d(wVar);
        if (dVar.f1957a == null) {
            synchronized (d.f1955b) {
                try {
                    if (d.f1956c == null) {
                        d.f1956c = Executors.newFixedThreadPool(2);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            dVar.f1957a = d.f1956c;
        }
        h hVar = new h(cVar, new u((Object) null, (Object) dVar.f1957a, (Object) wVar, 15, 0));
        this.f2224a = hVar;
        hVar.f2036d.add(v0Var);
    }

    public final void a(List list) {
        h hVar = this.f2224a;
        int i10 = hVar.f2039g + 1;
        hVar.f2039g = i10;
        List list2 = hVar.f2037e;
        if (list != list2) {
            x0 x0Var = hVar.f2033a;
            if (list == null) {
                int size = list2.size();
                hVar.f2037e = null;
                hVar.f2038f = Collections.emptyList();
                x0Var.a(0, size);
            } else if (list2 == null) {
                hVar.f2037e = list;
                hVar.f2038f = Collections.unmodifiableList(list);
                x0Var.c(0, list.size());
            } else {
                ((Executor) hVar.f2034b.f429j).execute(new f(hVar, list2, list, i10));
                return;
            }
            hVar.a((Runnable) null);
        }
    }

    public final int getItemCount() {
        return this.f2224a.f2038f.size();
    }
}

package androidx.recyclerview.widget;

import android.support.v4.media.session.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public final class h {

    /* renamed from: h  reason: collision with root package name */
    public static final g f2032h = new g();

    /* renamed from: a  reason: collision with root package name */
    public final x0 f2033a;

    /* renamed from: b  reason: collision with root package name */
    public final u f2034b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f2035c;

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList f2036d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List f2037e;

    /* renamed from: f  reason: collision with root package name */
    public List f2038f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public int f2039g;

    public h(c cVar, u uVar) {
        this.f2033a = cVar;
        this.f2034b = uVar;
        Executor executor = (Executor) uVar.f428i;
        this.f2035c = executor == null ? f2032h : executor;
    }

    public final void a(Runnable runnable) {
        Iterator it = this.f2036d.iterator();
        while (it.hasNext()) {
            ((v0) it.next()).f2221a.getClass();
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}

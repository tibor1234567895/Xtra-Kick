package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l0.a;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public boolean f489a;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList f490b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public a f491c;

    public n(boolean z10) {
        this.f489a = z10;
    }

    public final void a() {
        Iterator it = this.f490b.iterator();
        while (it.hasNext()) {
            ((d) it.next()).cancel();
        }
    }
}

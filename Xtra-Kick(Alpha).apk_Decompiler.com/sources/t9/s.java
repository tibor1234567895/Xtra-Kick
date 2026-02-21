package t9;

import android.support.v4.media.h;
import java.util.Iterator;
import java.util.List;
import la.v;
import p9.b;

public final class s implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14904h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ w f14905i;

    public /* synthetic */ s(w wVar, b bVar, int i10) {
        this.f14904h = i10;
        this.f14905i = wVar;
    }

    private final void a() {
        synchronized (this.f14905i.f14914a.f17664b) {
            Iterator it = ((List) this.f14905i.f14914a.f17670h).iterator();
            if (!it.hasNext()) {
                v vVar = v.f9814a;
            } else {
                h.y(it.next());
                throw null;
            }
        }
    }

    private final void b() {
        synchronized (this.f14905i.f14914a.f17664b) {
            Iterator it = ((List) this.f14905i.f14914a.f17670h).iterator();
            if (!it.hasNext()) {
                v vVar = v.f9814a;
            } else {
                h.y(it.next());
                throw null;
            }
        }
    }

    private final void c() {
        synchronized (this.f14905i.f14914a.f17664b) {
            Iterator it = ((List) this.f14905i.f14914a.f17670h).iterator();
            if (!it.hasNext()) {
                v vVar = v.f9814a;
            } else {
                h.y(it.next());
                throw null;
            }
        }
    }

    private final void d() {
        synchronized (this.f14905i.f14914a.f17664b) {
            Iterator it = ((List) this.f14905i.f14914a.f17670h).iterator();
            if (!it.hasNext()) {
                v vVar = v.f9814a;
            } else {
                h.y(it.next());
                throw null;
            }
        }
    }

    private final void e() {
        synchronized (this.f14905i.f14914a.f17664b) {
            Iterator it = ((List) this.f14905i.f14914a.f17670h).iterator();
            if (!it.hasNext()) {
                v vVar = v.f9814a;
            } else {
                h.y(it.next());
                throw null;
            }
        }
    }

    public final void run() {
        switch (this.f14904h) {
            case 0:
                synchronized (this.f14905i.f14914a.f17664b) {
                    Iterator it = ((List) this.f14905i.f14914a.f17670h).iterator();
                    if (!it.hasNext()) {
                        v vVar = v.f9814a;
                    } else {
                        h.y(it.next());
                        throw null;
                    }
                }
                return;
            case 1:
                a();
                return;
            case 2:
                b();
                return;
            case 3:
                c();
                return;
            case 4:
                d();
                return;
            default:
                e();
                return;
        }
    }
}

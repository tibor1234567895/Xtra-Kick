package h3;

import android.os.Handler;
import g1.m;
import j1.v;
import java.util.ArrayList;
import java.util.Iterator;
import q.e;

public final class e4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f7006a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public int f7007b;

    /* renamed from: c  reason: collision with root package name */
    public final e f7008c = new e();

    /* renamed from: d  reason: collision with root package name */
    public Runnable f7009d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f7010e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7011f;

    public final int a() {
        int i10;
        synchronized (this.f7006a) {
            i10 = this.f7007b;
            this.f7007b = i10 + 1;
        }
        return i10;
    }

    public final void b() {
        ArrayList arrayList;
        synchronized (this.f7006a) {
            this.f7011f = true;
            arrayList = new ArrayList(this.f7008c.values());
            this.f7008c.clear();
            if (this.f7009d != null) {
                Handler handler = this.f7010e;
                handler.getClass();
                handler.post(this.f7009d);
                this.f7009d = null;
                this.f7010e = null;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((d4) it.next()).n();
        }
    }

    public final void c(int i10, m mVar) {
        synchronized (this.f7006a) {
            d4 d4Var = (d4) this.f7008c.remove(Integer.valueOf(i10));
            if (d4Var != null) {
                if (d4Var.f6986p.getClass() == mVar.getClass()) {
                    d4Var.l(mVar);
                } else {
                    v.g("SequencedFutureManager", "Type mismatch, expected " + d4Var.f6986p.getClass() + ", but was " + mVar.getClass());
                }
            }
            if (this.f7009d != null && this.f7008c.isEmpty()) {
                b();
            }
        }
    }
}

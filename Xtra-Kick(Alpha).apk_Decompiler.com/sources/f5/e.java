package f5;

import java.util.HashMap;
import w5.n;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f5818a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final d f5819b = new d();

    public final void a(String str) {
        c cVar;
        synchronized (this) {
            Object obj = this.f5818a.get(str);
            n.b(obj);
            cVar = (c) obj;
            int i10 = cVar.f5816b;
            if (i10 >= 1) {
                int i11 = i10 - 1;
                cVar.f5816b = i11;
                if (i11 == 0) {
                    c cVar2 = (c) this.f5818a.remove(str);
                    if (cVar2.equals(cVar)) {
                        this.f5819b.b(cVar2);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + cVar + ", but actually removed: " + cVar2 + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + cVar.f5816b);
            }
        }
        cVar.f5815a.unlock();
    }
}

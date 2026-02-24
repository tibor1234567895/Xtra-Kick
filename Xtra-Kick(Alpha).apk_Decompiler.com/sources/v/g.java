package v;

import java.util.Iterator;

public class g extends f {

    /* renamed from: m  reason: collision with root package name */
    public int f15520m;

    public g(q qVar) {
        super(qVar);
        this.f15512e = qVar instanceof l ? 2 : 3;
    }

    public final void d(int i10) {
        if (!this.f15517j) {
            this.f15517j = true;
            this.f15514g = i10;
            Iterator it = this.f15518k.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                dVar.a(dVar);
            }
        }
    }
}

package u;

import java.util.ArrayList;
import s.d;

public class o extends f {

    /* renamed from: r0  reason: collision with root package name */
    public ArrayList f15168r0 = new ArrayList();

    public void C() {
        this.f15168r0.clear();
        super.C();
    }

    public final void F(d dVar) {
        super.F(dVar);
        int size = this.f15168r0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((f) this.f15168r0.get(i10)).F(dVar);
        }
    }

    public void Q() {
        ArrayList arrayList = this.f15168r0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = (f) this.f15168r0.get(i10);
                if (fVar instanceof o) {
                    ((o) fVar).Q();
                }
            }
        }
    }
}

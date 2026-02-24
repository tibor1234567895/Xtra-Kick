package u;

import java.util.ArrayList;
import v.i;
import v.p;

public class l extends f implements k {

    /* renamed from: r0  reason: collision with root package name */
    public f[] f15158r0 = new f[4];

    /* renamed from: s0  reason: collision with root package name */
    public int f15159s0 = 0;

    public final void Q(int i10, p pVar, ArrayList arrayList) {
        for (int i11 = 0; i11 < this.f15159s0; i11++) {
            f fVar = this.f15158r0[i11];
            ArrayList arrayList2 = pVar.f15536a;
            if (!arrayList2.contains(fVar)) {
                arrayList2.add(fVar);
            }
        }
        for (int i12 = 0; i12 < this.f15159s0; i12++) {
            i.a(this.f15158r0[i12], i10, arrayList, pVar);
        }
    }

    public void a() {
    }
}

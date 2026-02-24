package v;

import java.util.ArrayList;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final q f15523a = null;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f15524b = new ArrayList();

    public m(q qVar) {
        this.f15523a = qVar;
    }

    public static long a(f fVar, long j10) {
        q qVar = fVar.f15511d;
        if (qVar instanceof k) {
            return j10;
        }
        ArrayList arrayList = fVar.f15518k;
        int size = arrayList.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f15511d != qVar) {
                    j11 = Math.min(j11, a(fVar2, ((long) fVar2.f15513f) + j10));
                }
            }
        }
        if (fVar != qVar.f15549i) {
            return j11;
        }
        long j12 = qVar.j();
        f fVar3 = qVar.f15548h;
        long j13 = j10 - j12;
        return Math.min(Math.min(j11, a(fVar3, j13)), j13 - ((long) fVar3.f15513f));
    }

    public static long b(f fVar, long j10) {
        q qVar = fVar.f15511d;
        if (qVar instanceof k) {
            return j10;
        }
        ArrayList arrayList = fVar.f15518k;
        int size = arrayList.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f15511d != qVar) {
                    j11 = Math.max(j11, b(fVar2, ((long) fVar2.f15513f) + j10));
                }
            }
        }
        if (fVar != qVar.f15548h) {
            return j11;
        }
        long j12 = qVar.j();
        f fVar3 = qVar.f15549i;
        long j13 = j10 + j12;
        return Math.max(Math.max(j11, b(fVar3, j13)), j13 - ((long) fVar3.f15513f));
    }
}

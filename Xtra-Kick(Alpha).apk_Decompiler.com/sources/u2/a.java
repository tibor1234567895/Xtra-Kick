package u2;

import java.util.ArrayList;
import java.util.Arrays;

public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public final long f15196c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f15197d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f15198e = new ArrayList();

    public a(int i10, long j10) {
        super(i10, 0);
        this.f15196c = j10;
    }

    public final a i(int i10) {
        ArrayList arrayList = this.f15198e;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = (a) arrayList.get(i11);
            if (aVar.f15201b == i10) {
                return aVar;
            }
        }
        return null;
    }

    public final b j(int i10) {
        ArrayList arrayList = this.f15197d;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) arrayList.get(i11);
            if (bVar.f15201b == i10) {
                return bVar;
            }
        }
        return null;
    }

    public final String toString() {
        return c.c(this.f15201b) + " leaves: " + Arrays.toString(this.f15197d.toArray()) + " containers: " + Arrays.toString(this.f15198e.toArray());
    }
}

package a3;

import i1.b;
import j1.a;
import j1.l0;
import java.util.Collections;
import java.util.List;
import w2.d;

public final class f implements d {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f131h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f132i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f133j;

    public /* synthetic */ f(Object obj, int i10, Object obj2) {
        this.f131h = i10;
        this.f132i = obj;
        this.f133j = obj2;
    }

    public final int a(long j10) {
        int i10;
        int i11 = this.f131h;
        Object obj = this.f133j;
        switch (i11) {
            case 0:
                List list = (List) obj;
                Long valueOf = Long.valueOf(j10);
                int i12 = l0.f8453a;
                int binarySearch = Collections.binarySearch(list, valueOf);
                if (binarySearch < 0) {
                    i10 = ~binarySearch;
                } else {
                    int size = list.size();
                    do {
                        binarySearch++;
                        if (binarySearch >= size || ((Comparable) list.get(binarySearch)).compareTo(valueOf) != 0) {
                            i10 = binarySearch;
                        }
                        binarySearch++;
                        i10 = binarySearch;
                    } while (((Comparable) list.get(binarySearch)).compareTo(valueOf) != 0);
                    i10 = binarySearch;
                }
                if (i10 < list.size()) {
                    return i10;
                }
                return -1;
            default:
                long[] jArr = (long[]) obj;
                int b10 = l0.b(jArr, j10, false);
                if (b10 < jArr.length) {
                    return b10;
                }
                return -1;
        }
    }

    public final long b(int i10) {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        int i11 = this.f131h;
        Object obj = this.f133j;
        switch (i11) {
            case 0:
                if (i10 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                a.b(z11);
                List list = (List) obj;
                if (i10 >= list.size()) {
                    z12 = false;
                }
                a.b(z12);
                return ((Long) list.get(i10)).longValue();
            default:
                if (i10 >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a.b(z10);
                long[] jArr = (long[]) obj;
                if (i10 >= jArr.length) {
                    z12 = false;
                }
                a.b(z12);
                return jArr[i10];
        }
    }

    public final List c(long j10) {
        b bVar;
        int i10 = this.f131h;
        Object obj = this.f132i;
        Object obj2 = this.f133j;
        switch (i10) {
            case 0:
                int d10 = l0.d((List) obj2, Long.valueOf(j10), false);
                if (d10 == -1) {
                    return Collections.emptyList();
                }
                return (List) ((List) obj).get(d10);
            default:
                int f10 = l0.f((long[]) obj2, j10, false);
                if (f10 == -1 || (bVar = ((b[]) obj)[f10]) == b.f7970y) {
                    return Collections.emptyList();
                }
                return Collections.singletonList(bVar);
        }
    }

    public final int d() {
        int i10 = this.f131h;
        Object obj = this.f133j;
        switch (i10) {
            case 0:
                return ((List) obj).size();
            default:
                return ((long[]) obj).length;
        }
    }
}

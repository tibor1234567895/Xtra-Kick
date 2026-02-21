package x2;

import j1.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import w2.d;

public final class j implements d {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16643h;

    /* renamed from: i  reason: collision with root package name */
    public final List f16644i;

    public j(ArrayList arrayList) {
        this.f16643h = 3;
        this.f16644i = Collections.unmodifiableList(arrayList);
    }

    public final int a(long j10) {
        switch (this.f16643h) {
            case 0:
                return j10 < 0 ? 0 : -1;
            case 1:
            case 2:
                return -1;
            default:
                return j10 < 0 ? 0 : -1;
        }
    }

    public final long b(int i10) {
        boolean z10 = false;
        switch (this.f16643h) {
            case 0:
                if (i10 == 0) {
                    z10 = true;
                }
                a.b(z10);
                return 0;
            case 1:
            case 2:
                return 0;
            default:
                if (i10 == 0) {
                    z10 = true;
                }
                a.b(z10);
                return 0;
        }
    }

    public final List c(long j10) {
        int i10 = this.f16643h;
        List list = this.f16644i;
        switch (i10) {
            case 0:
                if (j10 >= 0) {
                    return list;
                }
                return Collections.emptyList();
            case 1:
            case 2:
                return list;
            default:
                if (j10 >= 0) {
                    return list;
                }
                return Collections.emptyList();
        }
    }

    public final int d() {
        return 1;
    }

    public /* synthetic */ j(List list, int i10) {
        this.f16643h = i10;
        this.f16644i = list;
    }
}

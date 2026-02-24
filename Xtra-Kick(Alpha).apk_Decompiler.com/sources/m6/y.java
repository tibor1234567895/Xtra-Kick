package m6;

import wa.l;
import xa.k;

public final class y extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10676h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f10677i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f10678j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(int i10, long j10, long j11) {
        super(1);
        this.f10676h = i10;
        this.f10677i = j10;
        this.f10678j = j11;
    }

    public final Integer a(long j10) {
        int i10 = 0;
        int i11 = this.f10676h;
        long j11 = this.f10678j;
        long j12 = this.f10677i;
        switch (i11) {
            case 0:
                if (j10 > j12) {
                    i10 = 1;
                } else if (j10 < j11) {
                    i10 = -1;
                }
                return Integer.valueOf(i10);
            default:
                if (j10 > j12) {
                    i10 = 1;
                } else if (j10 < j11) {
                    i10 = -1;
                }
                return Integer.valueOf(i10);
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f10676h) {
            case 0:
                return a(((Number) obj).longValue());
            default:
                return a(((Number) obj).longValue());
        }
    }
}

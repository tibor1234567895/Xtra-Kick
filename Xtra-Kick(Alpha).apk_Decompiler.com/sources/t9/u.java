package t9;

import p9.b;
import p9.l;

public final class u implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ b f14907h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f14908i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f14909j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f14910k;

    public /* synthetic */ u(l lVar, b bVar, long j10, long j11) {
        this.f14910k = lVar;
        this.f14907h = bVar;
        this.f14908i = j10;
        this.f14909j = j11;
    }

    public final void run() {
        ((l) this.f14910k).d(this.f14907h, this.f14908i, this.f14909j);
    }
}

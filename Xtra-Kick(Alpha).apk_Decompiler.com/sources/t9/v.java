package t9;

import p9.b;
import p9.l;

public final class v implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ b f14911h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f14912i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f14913j;

    public /* synthetic */ v(l lVar, b bVar, boolean z10) {
        this.f14913j = lVar;
        this.f14911h = bVar;
        this.f14912i = z10;
    }

    public final void run() {
        ((l) this.f14913j).c(this.f14911h, this.f14912i);
    }
}

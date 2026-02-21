package tb;

import dc.k;
import dc.l;
import java.io.Closeable;
import java.io.IOException;

public final class q implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f14998h = true;

    /* renamed from: i  reason: collision with root package name */
    public final l f14999i;

    /* renamed from: j  reason: collision with root package name */
    public final k f15000j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g f15001k;

    public q(l lVar, k kVar, g gVar) {
        this.f15001k = gVar;
        this.f14999i = lVar;
        this.f15000j = kVar;
    }

    public final void close() {
        this.f15001k.a(true, true, (IOException) null);
    }
}

package cc;

import dc.j;
import dc.p0;
import dc.x;
import java.io.Closeable;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import vb.h;

public final class a implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3079h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3080i;

    /* renamed from: j  reason: collision with root package name */
    public final j f3081j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f3082k;

    /* renamed from: l  reason: collision with root package name */
    public final Closeable f3083l;

    public a(int i10, boolean z10) {
        this.f3079h = i10;
        if (i10 != 1) {
            this.f3080i = z10;
            j jVar = new j();
            this.f3081j = jVar;
            Deflater deflater = new Deflater(-1, true);
            this.f3082k = deflater;
            this.f3083l = new h(jVar, deflater);
            return;
        }
        this.f3080i = z10;
        j jVar2 = new j();
        this.f3081j = jVar2;
        Inflater inflater = new Inflater(true);
        this.f3082k = inflater;
        this.f3083l = new x((p0) jVar2, inflater);
    }

    public final void close() {
        int i10 = this.f3079h;
        Closeable closeable = this.f3083l;
        switch (i10) {
            case 0:
                ((h) closeable).close();
                return;
            default:
                ((x) closeable).close();
                return;
        }
    }
}

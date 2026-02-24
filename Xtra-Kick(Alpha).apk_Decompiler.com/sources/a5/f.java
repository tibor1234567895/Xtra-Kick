package a5;

import b5.m;
import b5.n;
import b5.p;
import com.bumptech.glide.integration.webp.e;
import d5.o0;
import e5.k;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class f implements p {

    /* renamed from: c  reason: collision with root package name */
    public static final m f150c = m.a("com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: a  reason: collision with root package name */
    public final p f151a;

    /* renamed from: b  reason: collision with root package name */
    public final k f152b;

    public f(d dVar, k kVar) {
        this.f151a = dVar;
        this.f152b = kVar;
    }

    public final boolean a(Object obj, n nVar) {
        InputStream inputStream = (InputStream) obj;
        if (!((Boolean) nVar.c(f150c)).booleanValue() && e.b(inputStream, this.f152b) == 6) {
            return true;
        }
        return false;
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        byte[] a10 = g.a((InputStream) obj);
        if (a10 == null) {
            return null;
        }
        return this.f151a.b(ByteBuffer.wrap(a10), i10, i11, nVar);
    }
}

package a5;

import android.util.Log;
import b5.m;
import com.bumptech.glide.integration.webp.WebpImage;
import e5.c;
import e5.k;
import java.nio.ByteBuffer;
import k5.d;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final m f136d = m.a("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);

    /* renamed from: a  reason: collision with root package name */
    public final k f137a;

    /* renamed from: b  reason: collision with root package name */
    public final c f138b;

    /* renamed from: c  reason: collision with root package name */
    public final k5.a f139c;

    public a(k kVar, c cVar) {
        this.f137a = kVar;
        this.f138b = cVar;
        this.f139c = new k5.a((Object) cVar, 3, (Object) kVar);
    }

    public final d a(ByteBuffer byteBuffer, int i10, int i11) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        int i12 = 0;
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        int min = Math.min(create.getHeight() / i11, create.getWidth() / i10);
        if (min != 0) {
            i12 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i12);
        Log.isLoggable("Utils", 2);
        j jVar = new j(this.f139c, create, byteBuffer, max, r.f187b);
        try {
            jVar.c();
            return d.c(jVar.b(), this.f138b);
        } finally {
            jVar.clear();
        }
    }
}

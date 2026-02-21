package a5;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.emoji2.text.b0;
import b5.m;
import b5.n;
import b5.p;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.integration.webp.e;
import d5.o0;
import e5.c;
import e5.k;
import java.nio.ByteBuffer;
import k5.a;

public final class d implements p {

    /* renamed from: c  reason: collision with root package name */
    public static final m f144c = m.a("com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: a  reason: collision with root package name */
    public final Context f145a;

    /* renamed from: b  reason: collision with root package name */
    public final a f146b;

    public d(Context context, k kVar, c cVar) {
        this.f145a = context.getApplicationContext();
        this.f146b = new a((Object) cVar, 3, (Object) kVar);
    }

    public final boolean a(Object obj, n nVar) {
        int i10;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (((Boolean) nVar.c(f144c)).booleanValue()) {
            return false;
        }
        if (byteBuffer == null) {
            i10 = 7;
        } else {
            i10 = e.a(new b0(1, byteBuffer));
        }
        if (i10 == 6) {
            return true;
        }
        return false;
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        int i12;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        int min = Math.min(create.getHeight() / i11, create.getWidth() / i10);
        if (min == 0) {
            i12 = 0;
        } else {
            i12 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i12);
        Log.isLoggable("Utils", 2);
        a aVar = this.f146b;
        j jVar = new j(aVar, create, byteBuffer, max, (r) nVar.c(w.f198q));
        jVar.c();
        Bitmap b10 = jVar.b();
        return new p(new n(new m(new w(com.bumptech.glide.c.a(this.f145a), jVar, i10, i11, j5.c.f8808b, b10))), 0);
    }
}

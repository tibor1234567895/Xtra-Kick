package a5;

import androidx.emoji2.text.b0;
import b5.n;
import b5.p;
import com.bumptech.glide.integration.webp.e;
import d5.o0;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f140a;

    /* renamed from: b  reason: collision with root package name */
    public final a f141b;

    public /* synthetic */ b(a aVar, int i10) {
        this.f140a = i10;
        this.f141b = aVar;
    }

    public final boolean a(Object obj, n nVar) {
        int i10;
        boolean z10 = true;
        int i11 = this.f140a;
        a aVar = this.f141b;
        switch (i11) {
            case 0:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                aVar.getClass();
                if (((Boolean) nVar.c(a.f136d)).booleanValue()) {
                    return false;
                }
                if (byteBuffer == null) {
                    i10 = 7;
                } else {
                    i10 = e.a(new b0(1, byteBuffer));
                }
                if (i10 != 6) {
                    z10 = false;
                }
                return z10;
            default:
                InputStream inputStream = (InputStream) obj;
                aVar.getClass();
                if (((Boolean) nVar.c(a.f136d)).booleanValue()) {
                    return false;
                }
                if (e.b(inputStream, aVar.f137a) != 6) {
                    z10 = false;
                }
                return z10;
        }
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        int i12 = this.f140a;
        a aVar = this.f141b;
        switch (i12) {
            case 0:
                return aVar.a((ByteBuffer) obj, i10, i11);
            default:
                aVar.getClass();
                byte[] a10 = g.a((InputStream) obj);
                if (a10 == null) {
                    return null;
                }
                return aVar.a(ByteBuffer.wrap(a10), i10, i11);
        }
    }
}

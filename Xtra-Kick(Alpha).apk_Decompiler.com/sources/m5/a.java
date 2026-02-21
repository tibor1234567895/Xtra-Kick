package m5;

import android.graphics.ImageDecoder;
import android.os.Build;
import b5.i;
import b5.n;
import b5.p;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d5.o0;
import e5.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10603a;

    /* renamed from: b  reason: collision with root package name */
    public final k5.a f10604b;

    public /* synthetic */ a(k5.a aVar, int i10) {
        this.f10603a = i10;
        this.f10604b = aVar;
    }

    public final boolean a(Object obj, n nVar) {
        int i10 = this.f10603a;
        k5.a aVar = this.f10604b;
        switch (i10) {
            case 0:
                ImageHeaderParser$ImageType d10 = i.d((List) aVar.f9124i, (ByteBuffer) obj);
                if (d10 == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && d10 == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                    return true;
                }
                return false;
            default:
                ImageHeaderParser$ImageType c10 = i.c((k) aVar.f9125j, (InputStream) obj, (List) aVar.f9124i);
                if (c10 == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && c10 == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                    return true;
                }
                return false;
        }
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        int i12 = this.f10603a;
        k5.a aVar = this.f10604b;
        switch (i12) {
            case 0:
                ImageDecoder.Source j10 = ImageDecoder.createSource((ByteBuffer) obj);
                aVar.getClass();
                return k5.a.e(j10, i10, i11, nVar);
            default:
                ImageDecoder.Source j11 = ImageDecoder.createSource(w5.a.b((InputStream) obj));
                aVar.getClass();
                return k5.a.e(j11, i10, i11, nVar);
        }
    }
}

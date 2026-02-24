package o5;

import android.util.Log;
import b5.i;
import b5.n;
import b5.p;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d5.o0;
import e5.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final List f12234a;

    /* renamed from: b  reason: collision with root package name */
    public final p f12235b;

    /* renamed from: c  reason: collision with root package name */
    public final k f12236c;

    public l(ArrayList arrayList, c cVar, k kVar) {
        this.f12234a = arrayList;
        this.f12235b = cVar;
        this.f12236c = kVar;
    }

    public final boolean a(Object obj, n nVar) {
        InputStream inputStream = (InputStream) obj;
        if (!((Boolean) nVar.c(k.f12233b)).booleanValue()) {
            if (i.c(this.f12236c, inputStream, this.f12234a) == ImageHeaderParser$ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e10);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.f12235b.b(ByteBuffer.wrap(bArr), i10, i11, nVar);
    }
}

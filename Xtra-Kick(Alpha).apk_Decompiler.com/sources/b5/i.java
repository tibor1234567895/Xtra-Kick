package b5;

import android.support.v4.media.n;
import androidx.emoji2.text.b0;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import e5.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import k5.e0;

public final class i {
    private i() {
    }

    public static int a(k kVar, InputStream inputStream, List list) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, kVar);
        }
        inputStream.mark(5242880);
        return b(list, new n((Object) inputStream, 25, (Object) kVar));
    }

    public static int b(List list, h hVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            int k10 = hVar.k((f) list.get(i10));
            if (k10 != -1) {
                return k10;
            }
        }
        return -1;
    }

    /* JADX INFO: finally extract failed */
    public static ImageHeaderParser$ImageType c(k kVar, InputStream inputStream, List list) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, kVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            try {
                ImageHeaderParser$ImageType c10 = ((f) list.get(i10)).c(inputStream);
                inputStream.reset();
                if (c10 != ImageHeaderParser$ImageType.UNKNOWN) {
                    return c10;
                }
                i10++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType d(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        b0 b0Var = new b0(byteBuffer, 2);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser$ImageType i11 = b0Var.i((f) list.get(i10));
            if (i11 != ImageHeaderParser$ImageType.UNKNOWN) {
                return i11;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}

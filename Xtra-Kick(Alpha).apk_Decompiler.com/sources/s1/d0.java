package s1;

import android.media.MediaCodec;
import j1.i0;
import java.io.IOException;

public final class d0 implements l {
    public static MediaCodec b(k kVar) {
        kVar.f14027a.getClass();
        String str = kVar.f14027a.f14033a;
        i0.a("createCodec:" + str);
        MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
        i0.b();
        return createByCodecName;
    }

    public final m a(k kVar) {
        MediaCodec mediaCodec = null;
        try {
            mediaCodec = b(kVar);
            i0.a("configureCodec");
            mediaCodec.configure(kVar.f14028b, kVar.f14030d, kVar.f14031e, 0);
            i0.b();
            i0.a("startCodec");
            mediaCodec.start();
            i0.b();
            return new e0(mediaCodec);
        } catch (IOException | RuntimeException e10) {
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e10;
        }
    }
}

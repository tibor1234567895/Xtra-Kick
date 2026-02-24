package s1;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

public final class a0 implements z {
    private a0() {
    }

    public /* synthetic */ a0(int i10) {
        this();
    }

    public final MediaCodecInfo a(int i10) {
        return MediaCodecList.getCodecInfoAt(i10);
    }

    public final boolean e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    public final int f() {
        return MediaCodecList.getCodecCount();
    }

    public final boolean g(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    public final boolean h() {
        return false;
    }
}

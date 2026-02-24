package o1;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import n0.f;

public final class i0 {
    private i0() {
    }

    public static void a(m mVar, Object obj) {
        u uVar;
        AudioDeviceInfo e10 = f.e(obj);
        e0 e0Var = (e0) mVar;
        if (e10 == null) {
            uVar = null;
        } else {
            e0Var.getClass();
            uVar = new u(e10);
        }
        e0Var.Y = uVar;
        AudioTrack audioTrack = e0Var.f11900u;
        if (audioTrack != null) {
            s.a(audioTrack, uVar);
        }
    }
}

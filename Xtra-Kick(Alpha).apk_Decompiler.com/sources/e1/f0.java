package e1;

import android.media.session.MediaSessionManager;
import android.support.v4.media.session.d0;

public final class f0 extends h0 {
    public f0(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
    }

    public f0(String str, int i10, int i11) {
        super(str, i10, i11);
        d0.s();
        d0.y(str, i10, i11);
    }
}

package e1;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f4895a;

    public c0(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String q10 = remoteUserInfo.getPackageName();
        if (q10 == null) {
            throw new NullPointerException("package shouldn't be null");
        } else if (!TextUtils.isEmpty(q10)) {
            this.f4895a = new f0(remoteUserInfo);
        } else {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        return this.f4895a.equals(((c0) obj).f4895a);
    }

    public final int hashCode() {
        return this.f4895a.hashCode();
    }

    public c0(String str, int i10, int i11) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        } else if (!TextUtils.isEmpty(str)) {
            this.f4895a = Build.VERSION.SDK_INT >= 28 ? new f0(str, i10, i11) : new h0(str, i10, i11);
        } else {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
    }
}

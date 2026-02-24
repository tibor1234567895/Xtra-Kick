package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

public final class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public boolean f395a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f396b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(j jVar, Looper looper) {
        super(looper);
        this.f396b = jVar;
    }

    public final void handleMessage(Message message) {
        if (this.f395a) {
            int i10 = message.what;
            j jVar = this.f396b;
            switch (i10) {
                case 1:
                    Bundle data = message.getData();
                    u.p(data);
                    jVar.j((String) message.obj, data);
                    return;
                case 2:
                    jVar.e((PlaybackStateCompat) message.obj);
                    return;
                case 3:
                    jVar.d((MediaMetadataCompat) message.obj);
                    return;
                case 4:
                    jVar.a((o) message.obj);
                    return;
                case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                    jVar.f((List) message.obj);
                    return;
                case 6:
                    jVar.g((CharSequence) message.obj);
                    return;
                case 7:
                    Bundle bundle = (Bundle) message.obj;
                    u.p(bundle);
                    jVar.c(bundle);
                    return;
                case 8:
                    jVar.i();
                    return;
                case 9:
                    jVar.h(((Integer) message.obj).intValue());
                    return;
                case 11:
                    jVar.b(((Boolean) message.obj).booleanValue());
                    return;
                case 12:
                    jVar.l(((Integer) message.obj).intValue());
                    return;
                case 13:
                    jVar.k();
                    return;
                default:
                    return;
            }
        }
    }
}

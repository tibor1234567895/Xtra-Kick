package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public final class s {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f343b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a  reason: collision with root package name */
    public final e f344a;

    public s(Context context, ComponentName componentName, d dVar) {
        int i10 = Build.VERSION.SDK_INT;
        this.f344a = i10 >= 26 ? new g(context, componentName, dVar) : i10 >= 23 ? new f(context, componentName, dVar) : new e(context, componentName, dVar);
    }

    public final void a() {
        Messenger messenger;
        e eVar = this.f344a;
        n nVar = eVar.f325f;
        if (!(nVar == null || (messenger = eVar.f326g) == null)) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 7;
                obtain.arg1 = 1;
                obtain.setData((Bundle) null);
                obtain.replyTo = messenger;
                ((Messenger) nVar.f337i).send(obtain);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
        }
        eVar.f321b.disconnect();
    }
}

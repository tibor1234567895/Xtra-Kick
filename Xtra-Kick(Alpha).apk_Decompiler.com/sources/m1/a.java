package m1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.bumptech.glide.manager.b0;

public final class a extends BroadcastReceiver implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final k0 f10169h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f10170i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b0 f10171j;

    public a(b0 b0Var, Handler handler, k0 k0Var) {
        this.f10171j = b0Var;
        this.f10170i = handler;
        this.f10169h = k0Var;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f10170i.post(this);
        }
    }

    public final void run() {
        if (this.f10171j.f3256a) {
            this.f10169h.f10314h.t1(-1, 3, false);
        }
    }
}

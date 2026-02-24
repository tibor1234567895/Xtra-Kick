package m1;

import android.media.AudioManager;
import android.os.Handler;
import d0.o;

public final class c implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f10190a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f10191b;

    public c(e eVar, Handler handler) {
        this.f10191b = eVar;
        this.f10190a = handler;
    }

    public final void onAudioFocusChange(int i10) {
        this.f10190a.post(new o(this, i10, 1));
    }
}

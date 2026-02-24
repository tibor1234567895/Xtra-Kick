package y5;

import android.app.Application;
import b4.e0;
import com.github.andreyasadchy.xtra.XtraApp;
import dagger.hilt.android.internal.managers.h;
import ja.b;

public abstract class n extends Application implements b {

    /* renamed from: h  reason: collision with root package name */
    public boolean f17032h = false;

    /* renamed from: i  reason: collision with root package name */
    public final h f17033i = new h(new e0(16, this));

    public final Object c() {
        return this.f17033i.c();
    }

    public void onCreate() {
        if (!this.f17032h) {
            this.f17032h = true;
            XtraApp xtraApp = (XtraApp) this;
            ((w) c()).getClass();
        }
        super.onCreate();
    }
}

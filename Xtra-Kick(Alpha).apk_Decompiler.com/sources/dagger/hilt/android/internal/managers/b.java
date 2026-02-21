package dagger.hilt.android.internal.managers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.media.session.u;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.b2;
import androidx.lifecycle.h2;
import da.a;
import y5.c;
import y5.h;

public final class b implements ja.b {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4727h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Object f4728i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public final Activity f4729j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f4730k;

    /* renamed from: l  reason: collision with root package name */
    public volatile Object f4731l;

    public b(Activity activity) {
        this.f4729j = activity;
        this.f4730k = new b((ComponentActivity) activity);
    }

    private a b() {
        if (((a) this.f4731l) == null) {
            synchronized (this.f4728i) {
                if (((a) this.f4731l) == null) {
                    this.f4731l = ((e) new u((h2) this.f4729j, (b2) new c((Context) this.f4730k)).q(e.class)).f4733d;
                }
            }
        }
        return (a) this.f4731l;
    }

    public final Object a() {
        String str;
        Activity activity = this.f4729j;
        if (!(activity.getApplication() instanceof ja.b)) {
            StringBuilder sb2 = new StringBuilder("Hilt Activity must be attached to an @HiltAndroidApp Application. ");
            if (Application.class.equals(activity.getApplication().getClass())) {
                str = "Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?";
            } else {
                str = "Found: " + activity.getApplication().getClass();
            }
            sb2.append(str);
            throw new IllegalStateException(sb2.toString());
        }
        c cVar = (c) ((a) ba.a.a(a.class, (ja.b) this.f4730k));
        u uVar = new u(cVar.f16967a, cVar.f16968b, 0);
        activity.getClass();
        uVar.f430k = activity;
        return new y5.a((h) uVar.f428i, (c) uVar.f429j);
    }

    public final Object c() {
        switch (this.f4727h) {
            case 0:
                if (this.f4731l == null) {
                    synchronized (this.f4728i) {
                        if (this.f4731l == null) {
                            this.f4731l = a();
                        }
                    }
                }
                return this.f4731l;
            default:
                return b();
        }
    }

    public b(ComponentActivity componentActivity) {
        this.f4729j = componentActivity;
        this.f4730k = componentActivity;
    }
}

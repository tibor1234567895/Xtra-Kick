package dagger.hilt.android.internal.managers;

import android.app.Application;
import android.app.Service;
import ba.a;
import ja.b;
import ja.c;
import y5.f;
import y5.h;

public final class k implements b {

    /* renamed from: h  reason: collision with root package name */
    public final Service f4738h;

    /* renamed from: i  reason: collision with root package name */
    public f f4739i;

    public k(Service service) {
        this.f4738h = service;
    }

    public final Object c() {
        if (this.f4739i == null) {
            Service service = this.f4738h;
            Application application = service.getApplication();
            c.a(application instanceof b, "Hilt service must be attached to an @HiltAndroidApp Application. Found: %s", application.getClass());
            h hVar = ((h) ((j) a.a(j.class, application))).f16980d;
            new k5.a(hVar, 0).f9125j = service;
            this.f4739i = new f(hVar);
        }
        return this.f4739i;
    }
}

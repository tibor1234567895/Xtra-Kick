package ia;

import android.app.Application;
import android.content.Context;
import dagger.Provides;
import y5.n;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8372a;

    public a(n nVar) {
        this.f8372a = nVar;
    }

    @Provides
    public Application a() {
        return fa.a.a(this.f8372a);
    }

    @Provides
    public Context b() {
        return this.f8372a;
    }
}

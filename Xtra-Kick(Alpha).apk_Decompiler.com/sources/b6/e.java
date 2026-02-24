package b6;

import a6.b;
import a6.d0;
import a6.g;
import a6.m;
import a6.p;
import a6.t;
import a6.v;
import a6.x;
import a6.z;
import android.app.Application;
import com.github.andreyasadchy.xtra.db.AppDatabase;
import dagger.Provides;
import e6.c2;
import e6.e0;
import e6.e1;
import e6.f2;
import e6.j2;
import e6.o1;
import e6.y0;
import javax.inject.Singleton;
import r3.h0;
import r3.i0;
import xa.j;

public final class e {
    static {
        new d(0);
    }

    @Singleton
    @Provides
    public final AppDatabase a(Application application) {
        j.f("application", application);
        i0 a10 = h0.a(application, AppDatabase.class, "db");
        a10.f13691j = false;
        a10.f13692k = true;
        return (AppDatabase) a10.a();
    }

    @Singleton
    @Provides
    public final b b(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.t();
    }

    @Singleton
    @Provides
    public final e0 c(b bVar, g gVar, z zVar) {
        j.f("bookmarksDao", bVar);
        j.f("localFollowsChannelDao", gVar);
        j.f("videosDao", zVar);
        return new e0(bVar, gVar, zVar);
    }

    @Singleton
    @Provides
    public final g d(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.u();
    }

    @Singleton
    @Provides
    public final y0 e(g gVar, z zVar, b bVar) {
        j.f("localFollowsChannelDao", gVar);
        j.f("videosDao", zVar);
        j.f("bookmarksDao", bVar);
        return new y0(gVar, zVar, bVar);
    }

    @Singleton
    @Provides
    public final a6.j f(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.v();
    }

    @Singleton
    @Provides
    public final e1 g(a6.j jVar) {
        j.f("localFollowsGameDao", jVar);
        return new e1(jVar);
    }

    @Singleton
    @Provides
    public final m h(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.w();
    }

    @Singleton
    @Provides
    public final o1 i(z zVar, p pVar, g gVar, b bVar) {
        j.f("videosDao", zVar);
        j.f("requestsDao", pVar);
        j.f("localFollowsChannelDao", gVar);
        j.f("bookmarksDao", bVar);
        return new o1(zVar, pVar, gVar, bVar);
    }

    @Singleton
    @Provides
    public final p j(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.x();
    }

    @Singleton
    @Provides
    public final t k(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.y();
    }

    @Singleton
    @Provides
    public final c2 l(t tVar) {
        j.f("sortChannelDao", tVar);
        return new c2(tVar);
    }

    @Singleton
    @Provides
    public final v m(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.z();
    }

    @Singleton
    @Provides
    public final f2 n(v vVar) {
        j.f("sortGameDao", vVar);
        return new f2(vVar);
    }

    @Singleton
    @Provides
    public final x o(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.A();
    }

    @Singleton
    @Provides
    public final z p(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.B();
    }

    @Singleton
    @Provides
    public final d0 q(AppDatabase appDatabase) {
        j.f("database", appDatabase);
        return appDatabase.C();
    }

    @Singleton
    @Provides
    public final j2 r(d0 d0Var) {
        j.f("vodBookmarkIgnoredUsersDao", d0Var);
        return new j2(d0Var);
    }
}

package b6;

import aa.a;
import android.app.Application;
import com.github.andreyasadchy.xtra.api.KickApi;
import com.github.andreyasadchy.xtra.api.MiscApi;
import com.github.andreyasadchy.xtra.model.chat.StvChannelDeserializer;
import com.github.andreyasadchy.xtra.model.chat.StvChannelResponse;
import com.github.andreyasadchy.xtra.model.chat.StvGlobalDeserializer;
import com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse;
import com.google.gson.internal.bind.s0;
import dagger.Provides;
import j9.n;
import j9.o;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import p9.i;
import pb.d1;
import pb.f1;
import qb.h;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import s7.f;
import xa.j;

public final class g {
    @Singleton
    @Provides
    public final i a(Application application, f1 f1Var) {
        j.f("application", application);
        j.f("okHttpClient", f1Var);
        i iVar = new i(application);
        iVar.f12662e = false;
        iVar.f12667j = true;
        iVar.f12660c = 3;
        iVar.f12663f = new a(f1Var, 2);
        iVar.f12661d = 1000;
        iVar.f12674q = 3;
        return iVar;
    }

    @Singleton
    @Provides
    public final f b(i iVar) {
        j.f("fetchConfigurationBuilder", iVar);
        return new f(iVar);
    }

    @Singleton
    @Provides
    public final GsonConverterFactory c() {
        j9.a aVar;
        j9.a aVar2;
        j9.a aVar3;
        int i10;
        o oVar = new o();
        oVar.f8873g = "yyyy-MM-dd'T'HH:mm:ss";
        oVar.a(StvGlobalResponse.class, new StvGlobalDeserializer());
        oVar.a(StvChannelResponse.class, new StvChannelDeserializer());
        ArrayList arrayList = oVar.f8871e;
        int size = arrayList.size();
        ArrayList arrayList2 = oVar.f8872f;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        String str = oVar.f8873g;
        Class<Date> cls = Date.class;
        Class<Timestamp> cls2 = Timestamp.class;
        Class<java.util.Date> cls3 = java.util.Date.class;
        if (str == null || "".equals(str.trim())) {
            int i11 = oVar.f8874h;
            if (!(i11 == 2 || (i10 = oVar.f8875i) == 2)) {
                aVar3 = new j9.a(i11, i10, cls3);
                j9.a aVar4 = new j9.a(i11, i10, cls2);
                j9.a aVar5 = new j9.a(i11, i10, cls);
                aVar2 = aVar4;
                aVar = aVar5;
            }
            GsonConverterFactory create = GsonConverterFactory.create(new n(oVar.f8867a, oVar.f8869c, oVar.f8870d, oVar.f8868b, arrayList3));
            j.e("create(\n            Gson…      .create()\n        )", create);
            return create;
        }
        aVar3 = new j9.a(cls3, str);
        aVar2 = new j9.a(cls2, str);
        aVar = new j9.a(cls, str);
        arrayList3.add(s0.a(cls3, aVar3));
        arrayList3.add(s0.a(cls2, aVar2));
        arrayList3.add(s0.a(cls, aVar));
        GsonConverterFactory create2 = GsonConverterFactory.create(new n(oVar.f8867a, oVar.f8869c, oVar.f8870d, oVar.f8868b, arrayList3));
        j.e("create(\n            Gson…      .create()\n        )", create2);
        return create2;
    }

    @Singleton
    @Provides
    public final KickApi d(f1 f1Var, GsonConverterFactory gsonConverterFactory) {
        j.f("client", f1Var);
        j.f("gsonConverterFactory", gsonConverterFactory);
        Object create = new Retrofit.Builder().baseUrl("https://kick.com/").client(f1Var).addConverterFactory(gsonConverterFactory).build().create(KickApi.class);
        j.e("Builder()\n            .b…eate(KickApi::class.java)", create);
        return (KickApi) create;
    }

    @Singleton
    @Provides
    public final MiscApi e(f1 f1Var, GsonConverterFactory gsonConverterFactory) {
        j.f("client", f1Var);
        j.f("gsonConverterFactory", gsonConverterFactory);
        Object create = new Retrofit.Builder().baseUrl("https://api.twitch.tv/").client(f1Var).addConverterFactory(gsonConverterFactory).build().create(MiscApi.class);
        j.e("Builder()\n            .b…eate(MiscApi::class.java)", create);
        return (MiscApi) create;
    }

    @Singleton
    @Provides
    public final f1 f() {
        d1 d1Var = new d1();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        j.f("unit", timeUnit);
        d1Var.f12812y = h.b(5, timeUnit);
        d1Var.A = h.b(5, timeUnit);
        d1Var.f12813z = h.b(5, timeUnit);
        return new f1(d1Var);
    }

    @Singleton
    @Provides
    public final s7.h g() {
        return s7.h.f14375a;
    }
}

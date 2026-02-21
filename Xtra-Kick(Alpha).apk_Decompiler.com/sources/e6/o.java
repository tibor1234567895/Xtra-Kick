package e6;

import c6.b;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Livestream;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.User;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class o extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public b f5198i;

    /* renamed from: j  reason: collision with root package name */
    public int f5199j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5200k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ x f5201l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(x xVar, String str, e eVar) {
        super(2, eVar);
        this.f5200k = str;
        this.f5201l = xVar;
    }

    public final e create(Object obj, e eVar) {
        return new o(this.f5201l, this.f5200k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((o) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        b bVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5199j;
        String str = null;
        boolean z10 = true;
        if (i10 == 0) {
            h0.O1(obj);
            String str2 = this.f5200k;
            if (str2 == null) {
                return null;
            }
            x xVar = this.f5201l;
            b bVar2 = xVar.f5266b;
            this.f5198i = bVar2;
            this.f5199j = 1;
            obj2 = xVar.f5265a.a(str2, this);
            if (obj2 == aVar) {
                return aVar;
            }
            bVar = bVar2;
        } else if (i10 == 1) {
            bVar = this.f5198i;
            h0.O1(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Channel channel = (Channel) obj2;
        bVar.getClass();
        j.f("channel", channel);
        User user = channel.getUser();
        int id = channel.getId();
        int id2 = user.getId();
        String slug = channel.getSlug();
        String username = user.getUsername();
        String profilePicture = user.getProfilePicture();
        c6.a aVar2 = b.f2971b;
        if (profilePicture != null) {
            str = c6.a.a(aVar2, profilePicture);
        }
        String str3 = str;
        Integer valueOf = Integer.valueOf(channel.getFollowers());
        String a10 = c6.a.a(aVar2, channel.getBannerImage().getUrl());
        Livestream livestream = channel.getLivestream();
        if (livestream == null || !livestream.isLive()) {
            z10 = false;
        }
        return new com.github.andreyasadchy.xtra.model.ui.User(id, id2, slug, username, (String) null, (String) null, str3, (String) null, valueOf, a10, (String) null, (String) null, Boolean.valueOf(z10), b.b(channel), false, false);
    }
}

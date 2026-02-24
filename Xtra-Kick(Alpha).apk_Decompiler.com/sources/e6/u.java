package e6;

import c6.b;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.CategoriesItem;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Channel;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.LivestreamVideo;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.User;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Video;
import hb.f0;
import hb.h0;
import hb.p0;
import java.util.List;
import la.v;
import ma.z;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.f;
import xa.j;

public final class u extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public b f5244i;

    /* renamed from: j  reason: collision with root package name */
    public int f5245j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5246k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ x f5247l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(x xVar, String str, e eVar) {
        super(2, eVar);
        this.f5246k = str;
        this.f5247l = xVar;
    }

    public final e create(Object obj, e eVar) {
        return new u(this.f5247l, this.f5246k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((u) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        b bVar;
        CategoriesItem categoriesItem;
        Channel channel;
        User user;
        int i10;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer num;
        Integer num2;
        String str6;
        int i11;
        String str7;
        String str8;
        String profilepic;
        String thumbnail;
        List<CategoriesItem> categories;
        a aVar = a.COROUTINE_SUSPENDED;
        int i12 = this.f5245j;
        String str9 = null;
        if (i12 == 0) {
            h0.O1(obj);
            String str10 = this.f5246k;
            if (str10 == null) {
                return null;
            }
            x xVar = this.f5247l;
            b bVar2 = xVar.f5266b;
            this.f5244i = bVar2;
            this.f5245j = 1;
            s0 s0Var = xVar.f5265a;
            s0Var.getClass();
            obj2 = h0.c2(p0.f7834b, new m0(s0Var, str10, (e) null), this);
            if (obj2 == aVar) {
                return aVar;
            }
            bVar = bVar2;
        } else if (i12 == 1) {
            bVar = this.f5244i;
            h0.O1(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Video video = (Video) obj2;
        bVar.getClass();
        j.f("video", video);
        LivestreamVideo livestream = video.getLivestream();
        if (livestream == null || (categories = livestream.getCategories()) == null) {
            categoriesItem = null;
        } else {
            categoriesItem = (CategoriesItem) z.u(categories);
        }
        if (livestream != null) {
            channel = livestream.getChannel();
        } else {
            channel = null;
        }
        if (channel != null) {
            user = channel.getUser();
        } else {
            user = null;
        }
        String uuid = video.getUuid();
        if (livestream != null) {
            i10 = livestream.getChannelId();
        } else {
            i10 = 0;
        }
        if (channel != null) {
            str = channel.getSlug();
        } else {
            str = null;
        }
        if (user != null) {
            str2 = user.getUsername();
        } else {
            str2 = null;
        }
        if (livestream != null) {
            str3 = livestream.getTitle();
        } else {
            str3 = null;
        }
        if (livestream != null) {
            str4 = livestream.getCreatedAt();
        } else {
            str4 = null;
        }
        c6.a aVar2 = b.f2971b;
        if (livestream == null || (thumbnail = livestream.getThumbnail()) == null) {
            str5 = null;
        } else {
            str5 = c6.a.a(aVar2, thumbnail);
        }
        if (livestream != null) {
            num = Integer.valueOf(livestream.getViewerCount());
        } else {
            num = null;
        }
        if (livestream != null) {
            num2 = Integer.valueOf(livestream.getDuration() / 1000);
        } else {
            num2 = null;
        }
        String valueOf = String.valueOf(num2);
        String source = video.getSource();
        if (source != null) {
            str6 = c6.a.a(aVar2, source);
        } else {
            str6 = null;
        }
        if (categoriesItem != null) {
            i11 = categoriesItem.getCategoryId();
        } else {
            i11 = 0;
        }
        if (categoriesItem != null) {
            str7 = categoriesItem.getName();
        } else {
            str7 = null;
        }
        if (categoriesItem != null) {
            str8 = categoriesItem.getSlug();
        } else {
            str8 = null;
        }
        if (!(user == null || (profilepic = user.getProfilepic()) == null)) {
            str9 = c6.a.a(aVar2, profilepic);
        }
        return new com.github.andreyasadchy.xtra.model.ui.Video(uuid, i10, str, str2, str3, str4, str5, num, (String) null, valueOf, str6, i11, str7, str8, (String) null, str9, (List) null, (String) null, 212992, (f) null);
    }
}

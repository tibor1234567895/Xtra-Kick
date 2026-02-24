package x6;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.c;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.github.andreyasadchy.xtra.model.ui.User;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import e6.c0;
import e6.e0;
import e6.t;
import e6.x;
import fb.w;
import hb.f0;
import hb.h0;
import hb.p0;
import java.io.File;
import java.util.List;
import la.v;
import ma.q;
import ma.z;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.f;
import xa.j;

public final class n extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16707i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VideoPlayerViewModel f16708j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f16709k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Video f16710l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(VideoPlayerViewModel videoPlayerViewModel, Context context, Video video, e eVar) {
        super(2, eVar);
        this.f16708j = videoPlayerViewModel;
        this.f16709k = context;
        this.f16710l = video;
    }

    public final e create(Object obj, e eVar) {
        return new n(this.f16708j, this.f16709k, this.f16710l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((n) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        User user;
        String str;
        String str2;
        String str3;
        Object obj2;
        boolean z10;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16707i;
        VideoPlayerViewModel videoPlayerViewModel = this.f16708j;
        Context context = this.f16709k;
        Video video = this.f16710l;
        if (i10 == 0) {
            h0.O1(obj);
            if (videoPlayerViewModel.f3450q.d() != null) {
                Object d10 = videoPlayerViewModel.f3450q.d();
                j.c(d10);
                videoPlayerViewModel.f3448o.a(context, (Bookmark) d10);
                return v.f9814a;
            }
            String uuid = video.getUuid();
            if (uuid == null || w.h(uuid)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                try {
                    c.e(context).m().F(video.getThumbnail()).D(new m(context, video, 0));
                } catch (Exception unused) {
                }
            }
            if (video.getChannelId() != 0) {
                try {
                    c.e(context).m().F(video.getChannelLogo()).D(new m(context, video, 1));
                } catch (Exception e10) {
                    Log.e("NOP", "error: ", e10);
                }
            }
            int channelId = video.getChannelId();
            x xVar = videoPlayerViewModel.f14603d;
            q.b(new Integer(channelId));
            this.f16707i = 1;
            xVar.getClass();
            obj2 = h0.c2(p0.f7834b, new t((e) null), this);
            if (obj2 == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
                obj2 = obj;
            } catch (Exception unused2) {
                user = null;
            }
        } else if (i10 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        user = (User) z.u((List) obj2);
        String uuid2 = video.getUuid();
        if (uuid2 != null) {
            String file = context.getFilesDir().toString();
            String str4 = File.separator;
            str = new File(file + str4 + "thumbnails" + str4 + uuid2 + ".png").getAbsolutePath();
        } else {
            str = null;
        }
        int channelId2 = video.getChannelId();
        String file2 = context.getFilesDir().toString();
        String str5 = File.separator;
        String absolutePath = new File(file2 + str5 + "profile_pics" + str5 + channelId2 + ".png").getAbsolutePath();
        e0 e0Var = videoPlayerViewModel.f3448o;
        String uuid3 = video.getUuid();
        int channelId3 = video.getChannelId();
        String channelSlug = video.getChannelSlug();
        String channelName = video.getChannelName();
        if (user != null) {
            str2 = user.getType();
        } else {
            str2 = null;
        }
        if (user != null) {
            str3 = user.getBroadcasterType();
        } else {
            str3 = null;
        }
        Bookmark bookmark = new Bookmark(uuid3, channelId3, channelSlug, channelName, str2, str3, absolutePath, video.getGameId(), video.getGameName(), (String) null, (String) null, video.getTitle(), video.getUploadDate(), str, video.getType(), video.getDuration(), video.getAnimatedPreviewURL(), 1536, (f) null);
        this.f16707i = 2;
        e0Var.getClass();
        Object c22 = h0.c2(p0.f7834b, new c0(e0Var, bookmark, (e) null), this);
        if (c22 != aVar) {
            c22 = v.f9814a;
        }
        if (c22 == aVar) {
            return aVar;
        }
        return v.f9814a;
    }
}

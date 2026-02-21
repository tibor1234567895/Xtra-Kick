package o7;

import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel;
import e6.c2;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12296i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FollowedVideosViewModel f12297j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VideoSortEnum f12298k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BroadcastTypeEnum f12299l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(FollowedVideosViewModel followedVideosViewModel, VideoSortEnum videoSortEnum, BroadcastTypeEnum broadcastTypeEnum, e eVar) {
        super(2, eVar);
        this.f12297j = followedVideosViewModel;
        this.f12298k = videoSortEnum;
        this.f12299l = broadcastTypeEnum;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f12297j, this.f12298k, this.f12299l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f12296i;
        FollowedVideosViewModel followedVideosViewModel = this.f12297j;
        if (i10 == 0) {
            h0.O1(obj);
            c2 c2Var = followedVideosViewModel.f3520h;
            this.f12296i = 1;
            obj = c2Var.a("followed_videos", this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else if (i10 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SortChannel sortChannel = (SortChannel) obj;
        BroadcastTypeEnum broadcastTypeEnum = this.f12299l;
        VideoSortEnum videoSortEnum = this.f12298k;
        if (sortChannel != null) {
            sortChannel.setVideoSort(videoSortEnum.getValue());
            sortChannel.setVideoType(broadcastTypeEnum.getValue());
        } else {
            sortChannel = new SortChannel("followed_videos", (Boolean) null, videoSortEnum.getValue(), broadcastTypeEnum.getValue(), (String) null, 18, (xa.f) null);
        }
        c2 c2Var2 = followedVideosViewModel.f3520h;
        this.f12296i = 2;
        if (c2Var2.b(sortChannel, this) == aVar) {
            return aVar;
        }
        return v.f9814a;
    }
}

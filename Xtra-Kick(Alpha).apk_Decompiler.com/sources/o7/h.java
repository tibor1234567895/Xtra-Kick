package o7;

import com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel;
import e6.c2;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12301i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FollowedVideosViewModel f12302j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(FollowedVideosViewModel followedVideosViewModel, e eVar) {
        super(2, eVar);
        this.f12302j = followedVideosViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f12302j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f12301i;
        if (i10 == 0) {
            h0.O1(obj);
            c2 c2Var = this.f12302j.f3520h;
            this.f12301i = 1;
            obj = c2Var.a("followed_videos", this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

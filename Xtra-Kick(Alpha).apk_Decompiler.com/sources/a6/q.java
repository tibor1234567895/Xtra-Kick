package a6;

import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser;
import r3.l;
import r3.n0;
import u3.o;

public final class q extends l {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f253d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f254e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, n0 n0Var, int i10) {
        super(n0Var, 0);
        this.f253d = i10;
        this.f254e = obj;
    }

    public final String e() {
        switch (this.f253d) {
            case 0:
                return "DELETE FROM `requests` WHERE `offline_video_id` = ?";
            default:
                return "DELETE FROM `vod_bookmark_ignored_users` WHERE `user_id` = ?";
        }
    }

    public final void h(o oVar, Object obj) {
        switch (this.f253d) {
            case 0:
                oVar.g0(1, (long) ((Request) obj).getOfflineVideoId());
                return;
            default:
                oVar.g0(1, (long) ((VodBookmarkIgnoredUser) obj).getUser_id());
                return;
        }
    }
}

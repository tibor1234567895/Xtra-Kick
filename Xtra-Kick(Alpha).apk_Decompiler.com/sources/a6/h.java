package a6;

import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import r3.l;
import r3.n0;
import u3.o;

public final class h extends l {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f238d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(n0 n0Var, int i10) {
        super(n0Var, 0);
        this.f238d = i10;
    }

    public final String e() {
        switch (this.f238d) {
            case 0:
                return "DELETE FROM `local_follows` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `local_follows` SET `userId` = ?,`userLogin` = ?,`userName` = ?,`channelLogo` = ?,`id` = ? WHERE `id` = ?";
        }
    }

    public final /* bridge */ /* synthetic */ void h(o oVar, Object obj) {
        switch (this.f238d) {
            case 0:
                l(oVar, (LocalFollowChannel) obj);
                return;
            default:
                l(oVar, (LocalFollowChannel) obj);
                return;
        }
    }

    public final void l(o oVar, LocalFollowChannel localFollowChannel) {
        switch (this.f238d) {
            case 0:
                oVar.g0(1, (long) localFollowChannel.getId());
                return;
            default:
                oVar.g0(1, (long) localFollowChannel.getUserId());
                if (localFollowChannel.getUserLogin() == null) {
                    oVar.F(2);
                } else {
                    oVar.q(2, localFollowChannel.getUserLogin());
                }
                if (localFollowChannel.getUserName() == null) {
                    oVar.F(3);
                } else {
                    oVar.q(3, localFollowChannel.getUserName());
                }
                if (localFollowChannel.getChannelLogo() == null) {
                    oVar.F(4);
                } else {
                    oVar.q(4, localFollowChannel.getChannelLogo());
                }
                oVar.g0(5, (long) localFollowChannel.getId());
                oVar.g0(6, (long) localFollowChannel.getId());
                return;
        }
    }
}

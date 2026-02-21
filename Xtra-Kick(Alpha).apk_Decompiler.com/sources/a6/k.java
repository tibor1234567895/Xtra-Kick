package a6;

import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import r3.l;
import r3.n0;
import u3.o;

public final class k extends l {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f243d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(n0 n0Var, int i10) {
        super(n0Var, 0);
        this.f243d = i10;
    }

    public final String e() {
        switch (this.f243d) {
            case 0:
                return "DELETE FROM `local_follows_games` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `local_follows_games` SET `gameId` = ?,`gameSlug` = ?,`gameName` = ?,`boxArt` = ?,`id` = ? WHERE `id` = ?";
        }
    }

    public final /* bridge */ /* synthetic */ void h(o oVar, Object obj) {
        switch (this.f243d) {
            case 0:
                l(oVar, (LocalFollowGame) obj);
                return;
            default:
                l(oVar, (LocalFollowGame) obj);
                return;
        }
    }

    public final void l(o oVar, LocalFollowGame localFollowGame) {
        switch (this.f243d) {
            case 0:
                oVar.g0(1, (long) localFollowGame.getId());
                return;
            default:
                if (localFollowGame.getGameId() == null) {
                    oVar.F(1);
                } else {
                    oVar.g0(1, (long) localFollowGame.getGameId().intValue());
                }
                if (localFollowGame.getGameSlug() == null) {
                    oVar.F(2);
                } else {
                    oVar.q(2, localFollowGame.getGameSlug());
                }
                if (localFollowGame.getGameName() == null) {
                    oVar.F(3);
                } else {
                    oVar.q(3, localFollowGame.getGameName());
                }
                if (localFollowGame.getBoxArt() == null) {
                    oVar.F(4);
                } else {
                    oVar.q(4, localFollowGame.getBoxArt());
                }
                oVar.g0(5, (long) localFollowGame.getId());
                oVar.g0(6, (long) localFollowGame.getId());
                return;
        }
    }
}

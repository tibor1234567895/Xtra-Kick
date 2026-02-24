package a6;

import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import r3.l;
import r3.n0;
import u3.o;

public final class d extends l {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f227d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(n0 n0Var, int i10) {
        super(n0Var, 0);
        this.f227d = i10;
    }

    public final String e() {
        switch (this.f227d) {
            case 0:
                return "DELETE FROM `bookmarks` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `bookmarks` SET `videoId` = ?,`userId` = ?,`userLogin` = ?,`userName` = ?,`userType` = ?,`userBroadcasterType` = ?,`userLogo` = ?,`gameId` = ?,`gameName` = ?,`gameSlug` = ?,`boxArtUrl` = ?,`title` = ?,`createdAt` = ?,`thumbnail` = ?,`type` = ?,`duration` = ?,`animatedPreviewURL` = ?,`id` = ? WHERE `id` = ?";
        }
    }

    public final /* bridge */ /* synthetic */ void h(o oVar, Object obj) {
        switch (this.f227d) {
            case 0:
                l(oVar, (Bookmark) obj);
                return;
            default:
                l(oVar, (Bookmark) obj);
                return;
        }
    }

    public final void l(o oVar, Bookmark bookmark) {
        switch (this.f227d) {
            case 0:
                oVar.g0(1, (long) bookmark.getId());
                return;
            default:
                if (bookmark.getVideoId() == null) {
                    oVar.F(1);
                } else {
                    oVar.q(1, bookmark.getVideoId());
                }
                oVar.g0(2, (long) bookmark.getUserId());
                if (bookmark.getUserLogin() == null) {
                    oVar.F(3);
                } else {
                    oVar.q(3, bookmark.getUserLogin());
                }
                if (bookmark.getUserName() == null) {
                    oVar.F(4);
                } else {
                    oVar.q(4, bookmark.getUserName());
                }
                if (bookmark.getUserType() == null) {
                    oVar.F(5);
                } else {
                    oVar.q(5, bookmark.getUserType());
                }
                if (bookmark.getUserBroadcasterType() == null) {
                    oVar.F(6);
                } else {
                    oVar.q(6, bookmark.getUserBroadcasterType());
                }
                if (bookmark.getUserLogo() == null) {
                    oVar.F(7);
                } else {
                    oVar.q(7, bookmark.getUserLogo());
                }
                oVar.g0(8, (long) bookmark.getGameId());
                if (bookmark.getGameName() == null) {
                    oVar.F(9);
                } else {
                    oVar.q(9, bookmark.getGameName());
                }
                if (bookmark.getGameSlug() == null) {
                    oVar.F(10);
                } else {
                    oVar.q(10, bookmark.getGameSlug());
                }
                if (bookmark.getBoxArtUrl() == null) {
                    oVar.F(11);
                } else {
                    oVar.q(11, bookmark.getBoxArtUrl());
                }
                if (bookmark.getTitle() == null) {
                    oVar.F(12);
                } else {
                    oVar.q(12, bookmark.getTitle());
                }
                if (bookmark.getCreatedAt() == null) {
                    oVar.F(13);
                } else {
                    oVar.q(13, bookmark.getCreatedAt());
                }
                if (bookmark.getThumbnail() == null) {
                    oVar.F(14);
                } else {
                    oVar.q(14, bookmark.getThumbnail());
                }
                if (bookmark.getType() == null) {
                    oVar.F(15);
                } else {
                    oVar.q(15, bookmark.getType());
                }
                if (bookmark.getDuration() == null) {
                    oVar.F(16);
                } else {
                    oVar.q(16, bookmark.getDuration());
                }
                if (bookmark.getAnimatedPreviewURL() == null) {
                    oVar.F(17);
                } else {
                    oVar.q(17, bookmark.getAnimatedPreviewURL());
                }
                oVar.g0(18, (long) bookmark.getId());
                oVar.g0(19, (long) bookmark.getId());
                return;
        }
    }
}

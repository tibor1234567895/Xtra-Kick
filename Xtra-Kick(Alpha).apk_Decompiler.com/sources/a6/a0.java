package a6;

import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import r3.l;
import r3.n0;
import u3.o;

public final class a0 extends l {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f217d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(n0 n0Var, int i10) {
        super(n0Var, 0);
        this.f217d = i10;
    }

    public final String e() {
        switch (this.f217d) {
            case 0:
                return "DELETE FROM `videos` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `videos` SET `url` = ?,`source_url` = ?,`source_start_position` = ?,`name` = ?,`channel_id` = ?,`channel_login` = ?,`channel_name` = ?,`channel_logo` = ?,`thumbnail` = ?,`gameId` = ?,`gameName` = ?,`gameSlug` = ?,`boxArtUrl` = ?,`duration` = ?,`upload_date` = ?,`download_date` = ?,`last_watch_position` = ?,`progress` = ?,`max_progress` = ?,`status` = ?,`type` = ?,`videoId` = ?,`id` = ?,`is_vod` = ? WHERE `id` = ?";
        }
    }

    public final /* bridge */ /* synthetic */ void h(o oVar, Object obj) {
        switch (this.f217d) {
            case 0:
                l(oVar, (OfflineVideo) obj);
                return;
            default:
                l(oVar, (OfflineVideo) obj);
                return;
        }
    }

    public final void l(o oVar, OfflineVideo offlineVideo) {
        switch (this.f217d) {
            case 0:
                oVar.g0(1, (long) offlineVideo.getId());
                return;
            default:
                if (offlineVideo.getUrl() == null) {
                    oVar.F(1);
                } else {
                    oVar.q(1, offlineVideo.getUrl());
                }
                if (offlineVideo.getSourceUrl() == null) {
                    oVar.F(2);
                } else {
                    oVar.q(2, offlineVideo.getSourceUrl());
                }
                if (offlineVideo.getSourceStartPosition() == null) {
                    oVar.F(3);
                } else {
                    oVar.g0(3, offlineVideo.getSourceStartPosition().longValue());
                }
                if (offlineVideo.getName() == null) {
                    oVar.F(4);
                } else {
                    oVar.q(4, offlineVideo.getName());
                }
                oVar.g0(5, (long) offlineVideo.getChannelId());
                if (offlineVideo.getChannelLogin() == null) {
                    oVar.F(6);
                } else {
                    oVar.q(6, offlineVideo.getChannelLogin());
                }
                if (offlineVideo.getChannelName() == null) {
                    oVar.F(7);
                } else {
                    oVar.q(7, offlineVideo.getChannelName());
                }
                if (offlineVideo.getChannelLogo() == null) {
                    oVar.F(8);
                } else {
                    oVar.q(8, offlineVideo.getChannelLogo());
                }
                if (offlineVideo.getThumbnail() == null) {
                    oVar.F(9);
                } else {
                    oVar.q(9, offlineVideo.getThumbnail());
                }
                oVar.g0(10, (long) offlineVideo.getGameId());
                if (offlineVideo.getGameName() == null) {
                    oVar.F(11);
                } else {
                    oVar.q(11, offlineVideo.getGameName());
                }
                if (offlineVideo.getGameSlug() == null) {
                    oVar.F(12);
                } else {
                    oVar.q(12, offlineVideo.getGameSlug());
                }
                if (offlineVideo.getBoxArtUrl() == null) {
                    oVar.F(13);
                } else {
                    oVar.q(13, offlineVideo.getBoxArtUrl());
                }
                if (offlineVideo.getDuration() == null) {
                    oVar.F(14);
                } else {
                    oVar.g0(14, offlineVideo.getDuration().longValue());
                }
                if (offlineVideo.getUploadDate() == null) {
                    oVar.F(15);
                } else {
                    oVar.g0(15, offlineVideo.getUploadDate().longValue());
                }
                if (offlineVideo.getDownloadDate() == null) {
                    oVar.F(16);
                } else {
                    oVar.g0(16, offlineVideo.getDownloadDate().longValue());
                }
                if (offlineVideo.getLastWatchPosition() == null) {
                    oVar.F(17);
                } else {
                    oVar.g0(17, offlineVideo.getLastWatchPosition().longValue());
                }
                oVar.g0(18, (long) offlineVideo.getProgress());
                oVar.g0(19, (long) offlineVideo.getMaxProgress());
                oVar.g0(20, (long) offlineVideo.getStatus());
                if (offlineVideo.getType() == null) {
                    oVar.F(21);
                } else {
                    oVar.q(21, offlineVideo.getType());
                }
                if (offlineVideo.getVideoId() == null) {
                    oVar.F(22);
                } else {
                    oVar.q(22, offlineVideo.getVideoId());
                }
                oVar.g0(23, (long) offlineVideo.getId());
                oVar.g0(24, offlineVideo.getVod() ? 1 : 0);
                oVar.g0(25, (long) offlineVideo.getId());
                return;
        }
    }
}

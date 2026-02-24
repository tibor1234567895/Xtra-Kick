package a6;

import androidx.appcompat.widget.j3;
import com.github.andreyasadchy.xtra.model.VideoPosition;
import com.github.andreyasadchy.xtra.model.chat.RecentEmote;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import com.github.andreyasadchy.xtra.model.offline.SortGame;
import com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser;
import java.util.Map;
import p9.d;
import p9.f;
import p9.p;
import p9.r;
import p9.x;
import q9.a;
import q9.e;
import r3.l;
import r3.n0;
import u3.o;
import xa.j;

public final class c extends l {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f219d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f220e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, n0 n0Var, int i10) {
        super(n0Var, 1);
        this.f219d = i10;
        this.f220e = obj;
    }

    public final String e() {
        switch (this.f219d) {
            case 0:
                return "INSERT OR ABORT INTO `bookmarks` (`videoId`,`userId`,`userLogin`,`userName`,`userType`,`userBroadcasterType`,`userLogo`,`gameId`,`gameName`,`gameSlug`,`boxArtUrl`,`title`,`createdAt`,`thumbnail`,`type`,`duration`,`animatedPreviewURL`,`id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0))";
            case 1:
                return "INSERT OR ABORT INTO `local_follows` (`userId`,`userLogin`,`userName`,`channelLogo`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
            case 2:
                return "INSERT OR ABORT INTO `local_follows_games` (`gameId`,`gameSlug`,`gameName`,`boxArt`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
            case 3:
                return "INSERT OR REPLACE INTO `recent_emotes` (`name`,`used_at`) VALUES (?,?)";
            case 4:
                return "INSERT OR ABORT INTO `requests` (`offline_video_id`,`url`,`path`,`video_id`,`video_type`,`segment_from`,`segment_to`) VALUES (?,?,?,?,?,?,?)";
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                return "INSERT OR REPLACE INTO `sort_channel` (`id`,`saveSort`,`videoSort`,`videoType`,`clipPeriod`) VALUES (?,?,?,?,?)";
            case 6:
                return "INSERT OR REPLACE INTO `sort_game` (`id`,`saveSort`,`videoSort`,`videoPeriod`,`videoType`,`videoLanguageIndex`,`clipPeriod`,`clipLanguageIndex`) VALUES (?,?,?,?,?,?,?,?)";
            case 7:
                return "INSERT OR REPLACE INTO `video_positions` (`id`,`position`) VALUES (?,?)";
            case 8:
                return "INSERT OR ABORT INTO `videos` (`url`,`source_url`,`source_start_position`,`name`,`channel_id`,`channel_login`,`channel_name`,`channel_logo`,`thumbnail`,`gameId`,`gameName`,`gameSlug`,`boxArtUrl`,`duration`,`upload_date`,`download_date`,`last_watch_position`,`progress`,`max_progress`,`status`,`type`,`videoId`,`id`,`is_vod`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?)";
            case 9:
                return "INSERT OR ABORT INTO `vod_bookmark_ignored_users` (`user_id`) VALUES (?)";
            default:
                return "INSERT OR ABORT INTO `requests` (`_id`,`_namespace`,`_url`,`_file`,`_group`,`_priority`,`_headers`,`_written_bytes`,`_total_bytes`,`_status`,`_error`,`_network_type`,`_created`,`_tag`,`_enqueue_action`,`_identifier`,`_download_on_enqueue`,`_extras`,`_auto_retry_max_attempts`,`_auto_retry_attempts`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public final void h(o oVar, Object obj) {
        Integer num;
        Integer num2;
        o oVar2 = oVar;
        switch (this.f219d) {
            case 0:
                Bookmark bookmark = (Bookmark) obj;
                if (bookmark.getVideoId() == null) {
                    oVar2.F(1);
                } else {
                    oVar2.q(1, bookmark.getVideoId());
                }
                oVar2.g0(2, (long) bookmark.getUserId());
                if (bookmark.getUserLogin() == null) {
                    oVar2.F(3);
                } else {
                    oVar2.q(3, bookmark.getUserLogin());
                }
                if (bookmark.getUserName() == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, bookmark.getUserName());
                }
                if (bookmark.getUserType() == null) {
                    oVar2.F(5);
                } else {
                    oVar2.q(5, bookmark.getUserType());
                }
                if (bookmark.getUserBroadcasterType() == null) {
                    oVar2.F(6);
                } else {
                    oVar2.q(6, bookmark.getUserBroadcasterType());
                }
                if (bookmark.getUserLogo() == null) {
                    oVar2.F(7);
                } else {
                    oVar2.q(7, bookmark.getUserLogo());
                }
                oVar2.g0(8, (long) bookmark.getGameId());
                if (bookmark.getGameName() == null) {
                    oVar2.F(9);
                } else {
                    oVar2.q(9, bookmark.getGameName());
                }
                if (bookmark.getGameSlug() == null) {
                    oVar2.F(10);
                } else {
                    oVar2.q(10, bookmark.getGameSlug());
                }
                if (bookmark.getBoxArtUrl() == null) {
                    oVar2.F(11);
                } else {
                    oVar2.q(11, bookmark.getBoxArtUrl());
                }
                if (bookmark.getTitle() == null) {
                    oVar2.F(12);
                } else {
                    oVar2.q(12, bookmark.getTitle());
                }
                if (bookmark.getCreatedAt() == null) {
                    oVar2.F(13);
                } else {
                    oVar2.q(13, bookmark.getCreatedAt());
                }
                if (bookmark.getThumbnail() == null) {
                    oVar2.F(14);
                } else {
                    oVar2.q(14, bookmark.getThumbnail());
                }
                if (bookmark.getType() == null) {
                    oVar2.F(15);
                } else {
                    oVar2.q(15, bookmark.getType());
                }
                if (bookmark.getDuration() == null) {
                    oVar2.F(16);
                } else {
                    oVar2.q(16, bookmark.getDuration());
                }
                if (bookmark.getAnimatedPreviewURL() == null) {
                    oVar2.F(17);
                } else {
                    oVar2.q(17, bookmark.getAnimatedPreviewURL());
                }
                oVar2.g0(18, (long) bookmark.getId());
                return;
            case 1:
                LocalFollowChannel localFollowChannel = (LocalFollowChannel) obj;
                oVar2.g0(1, (long) localFollowChannel.getUserId());
                if (localFollowChannel.getUserLogin() == null) {
                    oVar2.F(2);
                } else {
                    oVar2.q(2, localFollowChannel.getUserLogin());
                }
                if (localFollowChannel.getUserName() == null) {
                    oVar2.F(3);
                } else {
                    oVar2.q(3, localFollowChannel.getUserName());
                }
                if (localFollowChannel.getChannelLogo() == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, localFollowChannel.getChannelLogo());
                }
                oVar2.g0(5, (long) localFollowChannel.getId());
                return;
            case 2:
                LocalFollowGame localFollowGame = (LocalFollowGame) obj;
                if (localFollowGame.getGameId() == null) {
                    oVar2.F(1);
                } else {
                    oVar2.g0(1, (long) localFollowGame.getGameId().intValue());
                }
                if (localFollowGame.getGameSlug() == null) {
                    oVar2.F(2);
                } else {
                    oVar2.q(2, localFollowGame.getGameSlug());
                }
                if (localFollowGame.getGameName() == null) {
                    oVar2.F(3);
                } else {
                    oVar2.q(3, localFollowGame.getGameName());
                }
                if (localFollowGame.getBoxArt() == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, localFollowGame.getBoxArt());
                }
                oVar2.g0(5, (long) localFollowGame.getId());
                return;
            case 3:
                RecentEmote recentEmote = (RecentEmote) obj;
                if (recentEmote.getName() == null) {
                    oVar2.F(1);
                } else {
                    oVar2.q(1, recentEmote.getName());
                }
                oVar2.g0(2, recentEmote.getUsedAt());
                return;
            case 4:
                Request request = (Request) obj;
                oVar2.g0(1, (long) request.getOfflineVideoId());
                if (request.getUrl() == null) {
                    oVar2.F(2);
                } else {
                    oVar2.q(2, request.getUrl());
                }
                if (request.getPath() == null) {
                    oVar2.F(3);
                } else {
                    oVar2.q(3, request.getPath());
                }
                if (request.getVideoId() == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, request.getVideoId());
                }
                if (request.getVideoType() == null) {
                    oVar2.F(5);
                } else {
                    oVar2.q(5, request.getVideoType());
                }
                if (request.getSegmentFrom() == null) {
                    oVar2.F(6);
                } else {
                    oVar2.g0(6, (long) request.getSegmentFrom().intValue());
                }
                if (request.getSegmentTo() == null) {
                    oVar2.F(7);
                    return;
                } else {
                    oVar2.g0(7, (long) request.getSegmentTo().intValue());
                    return;
                }
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                SortChannel sortChannel = (SortChannel) obj;
                if (sortChannel.getId() == null) {
                    oVar2.F(1);
                } else {
                    oVar2.q(1, sortChannel.getId());
                }
                if (sortChannel.getSaveSort() == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(sortChannel.getSaveSort().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    oVar2.F(2);
                } else {
                    oVar2.g0(2, (long) num.intValue());
                }
                if (sortChannel.getVideoSort() == null) {
                    oVar2.F(3);
                } else {
                    oVar2.q(3, sortChannel.getVideoSort());
                }
                if (sortChannel.getVideoType() == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, sortChannel.getVideoType());
                }
                if (sortChannel.getClipPeriod() == null) {
                    oVar2.F(5);
                    return;
                } else {
                    oVar2.q(5, sortChannel.getClipPeriod());
                    return;
                }
            case 6:
                SortGame sortGame = (SortGame) obj;
                if (sortGame.getId() == null) {
                    oVar2.F(1);
                } else {
                    oVar2.q(1, sortGame.getId());
                }
                if (sortGame.getSaveSort() == null) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(sortGame.getSaveSort().booleanValue() ? 1 : 0);
                }
                if (num2 == null) {
                    oVar2.F(2);
                } else {
                    oVar2.g0(2, (long) num2.intValue());
                }
                if (sortGame.getVideoSort() == null) {
                    oVar2.F(3);
                } else {
                    oVar2.q(3, sortGame.getVideoSort());
                }
                if (sortGame.getVideoPeriod() == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, sortGame.getVideoPeriod());
                }
                if (sortGame.getVideoType() == null) {
                    oVar2.F(5);
                } else {
                    oVar2.q(5, sortGame.getVideoType());
                }
                if (sortGame.getVideoLanguageIndex() == null) {
                    oVar2.F(6);
                } else {
                    oVar2.g0(6, (long) sortGame.getVideoLanguageIndex().intValue());
                }
                if (sortGame.getClipPeriod() == null) {
                    oVar2.F(7);
                } else {
                    oVar2.q(7, sortGame.getClipPeriod());
                }
                if (sortGame.getClipLanguageIndex() == null) {
                    oVar2.F(8);
                    return;
                } else {
                    oVar2.g0(8, (long) sortGame.getClipLanguageIndex().intValue());
                    return;
                }
            case 7:
                VideoPosition videoPosition = (VideoPosition) obj;
                oVar2.g0(1, videoPosition.getId());
                oVar2.g0(2, videoPosition.getPosition());
                return;
            case 8:
                OfflineVideo offlineVideo = (OfflineVideo) obj;
                if (offlineVideo.getUrl() == null) {
                    oVar2.F(1);
                } else {
                    oVar2.q(1, offlineVideo.getUrl());
                }
                if (offlineVideo.getSourceUrl() == null) {
                    oVar2.F(2);
                } else {
                    oVar2.q(2, offlineVideo.getSourceUrl());
                }
                if (offlineVideo.getSourceStartPosition() == null) {
                    oVar2.F(3);
                } else {
                    oVar2.g0(3, offlineVideo.getSourceStartPosition().longValue());
                }
                if (offlineVideo.getName() == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, offlineVideo.getName());
                }
                oVar2.g0(5, (long) offlineVideo.getChannelId());
                if (offlineVideo.getChannelLogin() == null) {
                    oVar2.F(6);
                } else {
                    oVar2.q(6, offlineVideo.getChannelLogin());
                }
                if (offlineVideo.getChannelName() == null) {
                    oVar2.F(7);
                } else {
                    oVar2.q(7, offlineVideo.getChannelName());
                }
                if (offlineVideo.getChannelLogo() == null) {
                    oVar2.F(8);
                } else {
                    oVar2.q(8, offlineVideo.getChannelLogo());
                }
                if (offlineVideo.getThumbnail() == null) {
                    oVar2.F(9);
                } else {
                    oVar2.q(9, offlineVideo.getThumbnail());
                }
                oVar2.g0(10, (long) offlineVideo.getGameId());
                if (offlineVideo.getGameName() == null) {
                    oVar2.F(11);
                } else {
                    oVar2.q(11, offlineVideo.getGameName());
                }
                if (offlineVideo.getGameSlug() == null) {
                    oVar2.F(12);
                } else {
                    oVar2.q(12, offlineVideo.getGameSlug());
                }
                if (offlineVideo.getBoxArtUrl() == null) {
                    oVar2.F(13);
                } else {
                    oVar2.q(13, offlineVideo.getBoxArtUrl());
                }
                if (offlineVideo.getDuration() == null) {
                    oVar2.F(14);
                } else {
                    oVar2.g0(14, offlineVideo.getDuration().longValue());
                }
                if (offlineVideo.getUploadDate() == null) {
                    oVar2.F(15);
                } else {
                    oVar2.g0(15, offlineVideo.getUploadDate().longValue());
                }
                if (offlineVideo.getDownloadDate() == null) {
                    oVar2.F(16);
                } else {
                    oVar2.g0(16, offlineVideo.getDownloadDate().longValue());
                }
                if (offlineVideo.getLastWatchPosition() == null) {
                    oVar2.F(17);
                } else {
                    oVar2.g0(17, offlineVideo.getLastWatchPosition().longValue());
                }
                oVar2.g0(18, (long) offlineVideo.getProgress());
                oVar2.g0(19, (long) offlineVideo.getMaxProgress());
                oVar2.g0(20, (long) offlineVideo.getStatus());
                if (offlineVideo.getType() == null) {
                    oVar2.F(21);
                } else {
                    oVar2.q(21, offlineVideo.getType());
                }
                if (offlineVideo.getVideoId() == null) {
                    oVar2.F(22);
                } else {
                    oVar2.q(22, offlineVideo.getVideoId());
                }
                oVar2.g0(23, (long) offlineVideo.getId());
                oVar2.g0(24, offlineVideo.getVod() ? 1 : 0);
                return;
            case 9:
                oVar2.g0(1, (long) ((VodBookmarkIgnoredUser) obj).getUser_id());
                return;
            default:
                e eVar = (e) obj;
                oVar2.g0(1, (long) eVar.f13433h);
                String str = eVar.f13434i;
                if (str == null) {
                    oVar2.F(2);
                } else {
                    oVar2.q(2, str);
                }
                String str2 = eVar.f13435j;
                if (str2 == null) {
                    oVar2.F(3);
                } else {
                    oVar2.q(3, str2);
                }
                String str3 = eVar.f13436k;
                if (str3 == null) {
                    oVar2.F(4);
                } else {
                    oVar2.q(4, str3);
                }
                oVar2.g0(5, (long) eVar.f13437l);
                j3 j3Var = (j3) this.f220e;
                r rVar = eVar.f13438m;
                ((a) j3Var.f896c).getClass();
                j.g("priority", rVar);
                oVar2.g0(6, (long) rVar.f12715h);
                Map map = eVar.f13439n;
                ((a) j3Var.f896c).getClass();
                oVar2.q(7, a.i(map));
                oVar2.g0(8, eVar.f13440o);
                oVar2.g0(9, eVar.f13441p);
                x xVar = eVar.f13442q;
                ((a) j3Var.f896c).getClass();
                j.g("status", xVar);
                oVar2.g0(10, (long) xVar.f12744h);
                f fVar = eVar.f13443r;
                ((a) j3Var.f896c).getClass();
                j.g("error", fVar);
                oVar2.g0(11, (long) fVar.f12655h);
                p pVar = eVar.f13444s;
                ((a) j3Var.f896c).getClass();
                j.g("networkType", pVar);
                oVar2.g0(12, (long) pVar.f12709h);
                oVar2.g0(13, eVar.f13445t);
                String str4 = eVar.f13446u;
                if (str4 == null) {
                    oVar2.F(14);
                } else {
                    oVar2.q(14, str4);
                }
                d dVar = eVar.f13447v;
                ((a) j3Var.f896c).getClass();
                j.g("enqueueAction", dVar);
                oVar2.g0(15, (long) dVar.f12636h);
                oVar2.g0(16, eVar.f13448w);
                oVar2.g0(17, eVar.f13449x ? 1 : 0);
                y9.j jVar = eVar.f13450y;
                ((a) j3Var.f896c).getClass();
                oVar2.q(18, a.d(jVar));
                oVar2.g0(19, (long) eVar.f13451z);
                oVar2.g0(20, (long) eVar.A);
                return;
        }
    }
}

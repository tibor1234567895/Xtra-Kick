package a6;

import com.github.andreyasadchy.xtra.db.AppDatabase_Impl;
import com.tonyodev.fetch2.database.DownloadDatabase_Impl;
import h3.s2;
import hb.h0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import r3.j0;
import r3.n0;
import s3.b;
import s3.g;
import s3.h;
import u2.c;
import v3.d;

public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f215c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n0 f216d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(n0 n0Var, int i10, int i11) {
        super(i10, 1);
        this.f215c = i11;
        this.f216d = n0Var;
    }

    public final void a(d dVar) {
        switch (this.f215c) {
            case 0:
                dVar.p("CREATE TABLE IF NOT EXISTS `videos` (`url` TEXT NOT NULL, `source_url` TEXT, `source_start_position` INTEGER, `name` TEXT, `channel_id` INTEGER NOT NULL, `channel_login` TEXT, `channel_name` TEXT, `channel_logo` TEXT, `thumbnail` TEXT, `gameId` INTEGER NOT NULL, `gameName` TEXT, `gameSlug` TEXT, `boxArtUrl` TEXT, `duration` INTEGER, `upload_date` INTEGER, `download_date` INTEGER, `last_watch_position` INTEGER, `progress` INTEGER NOT NULL, `max_progress` INTEGER NOT NULL, `status` INTEGER NOT NULL, `type` TEXT, `videoId` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `is_vod` INTEGER NOT NULL)");
                dVar.p("CREATE TABLE IF NOT EXISTS `requests` (`offline_video_id` INTEGER NOT NULL, `url` TEXT NOT NULL, `path` TEXT NOT NULL, `video_id` TEXT, `video_type` TEXT, `segment_from` INTEGER, `segment_to` INTEGER, PRIMARY KEY(`offline_video_id`), FOREIGN KEY(`offline_video_id`) REFERENCES `videos`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                dVar.p("CREATE TABLE IF NOT EXISTS `recent_emotes` (`name` TEXT NOT NULL, `used_at` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                dVar.p("CREATE TABLE IF NOT EXISTS `video_positions` (`id` INTEGER NOT NULL, `position` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                dVar.p("CREATE TABLE IF NOT EXISTS `local_follows` (`userId` INTEGER NOT NULL, `userLogin` TEXT, `userName` TEXT, `channelLogo` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                dVar.p("CREATE TABLE IF NOT EXISTS `local_follows_games` (`gameId` INTEGER, `gameSlug` TEXT, `gameName` TEXT, `boxArt` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                dVar.p("CREATE TABLE IF NOT EXISTS `bookmarks` (`videoId` TEXT, `userId` INTEGER NOT NULL, `userLogin` TEXT, `userName` TEXT, `userType` TEXT, `userBroadcasterType` TEXT, `userLogo` TEXT, `gameId` INTEGER NOT NULL, `gameName` TEXT, `gameSlug` TEXT, `boxArtUrl` TEXT, `title` TEXT, `createdAt` TEXT, `thumbnail` TEXT, `type` TEXT, `duration` TEXT, `animatedPreviewURL` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                dVar.p("CREATE TABLE IF NOT EXISTS `vod_bookmark_ignored_users` (`user_id` INTEGER NOT NULL, PRIMARY KEY(`user_id`))");
                dVar.p("CREATE TABLE IF NOT EXISTS `sort_channel` (`id` TEXT NOT NULL, `saveSort` INTEGER, `videoSort` TEXT, `videoType` TEXT, `clipPeriod` TEXT, PRIMARY KEY(`id`))");
                dVar.p("CREATE TABLE IF NOT EXISTS `sort_game` (`id` TEXT NOT NULL, `saveSort` INTEGER, `videoSort` TEXT, `videoPeriod` TEXT, `videoType` TEXT, `videoLanguageIndex` INTEGER, `clipPeriod` TEXT, `clipLanguageIndex` INTEGER, PRIMARY KEY(`id`))");
                dVar.p("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                dVar.p("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a5893511da8448365cfc906dacc8e89a')");
                return;
            default:
                dVar.p("CREATE TABLE IF NOT EXISTS `requests` (`_id` INTEGER NOT NULL, `_namespace` TEXT NOT NULL, `_url` TEXT NOT NULL, `_file` TEXT NOT NULL, `_group` INTEGER NOT NULL, `_priority` INTEGER NOT NULL, `_headers` TEXT NOT NULL, `_written_bytes` INTEGER NOT NULL, `_total_bytes` INTEGER NOT NULL, `_status` INTEGER NOT NULL, `_error` INTEGER NOT NULL, `_network_type` INTEGER NOT NULL, `_created` INTEGER NOT NULL, `_tag` TEXT, `_enqueue_action` INTEGER NOT NULL, `_identifier` INTEGER NOT NULL, `_download_on_enqueue` INTEGER NOT NULL, `_extras` TEXT NOT NULL, `_auto_retry_max_attempts` INTEGER NOT NULL, `_auto_retry_attempts` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
                dVar.p("CREATE UNIQUE INDEX IF NOT EXISTS `index_requests__file` ON `requests` (`_file`)");
                dVar.p("CREATE INDEX IF NOT EXISTS `index_requests__group__status` ON `requests` (`_group`, `_status`)");
                dVar.p("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                dVar.p("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
                return;
        }
    }

    public final void b(d dVar) {
        int i10 = this.f215c;
        n0 n0Var = this.f216d;
        switch (i10) {
            case 0:
                dVar.p("DROP TABLE IF EXISTS `videos`");
                dVar.p("DROP TABLE IF EXISTS `requests`");
                dVar.p("DROP TABLE IF EXISTS `recent_emotes`");
                dVar.p("DROP TABLE IF EXISTS `video_positions`");
                dVar.p("DROP TABLE IF EXISTS `local_follows`");
                dVar.p("DROP TABLE IF EXISTS `local_follows_games`");
                dVar.p("DROP TABLE IF EXISTS `bookmarks`");
                dVar.p("DROP TABLE IF EXISTS `vod_bookmark_ignored_users`");
                dVar.p("DROP TABLE IF EXISTS `sort_channel`");
                dVar.p("DROP TABLE IF EXISTS `sort_game`");
                int i11 = AppDatabase_Impl.f3322y;
                List<j0> list = ((AppDatabase_Impl) n0Var).f13724g;
                if (list != null) {
                    for (j0 j0Var : list) {
                        j0Var.getClass();
                    }
                    return;
                }
                return;
            default:
                dVar.p("DROP TABLE IF EXISTS `requests`");
                DownloadDatabase_Impl downloadDatabase_Impl = (DownloadDatabase_Impl) n0Var;
                int i12 = DownloadDatabase_Impl.f4075q;
                List list2 = downloadDatabase_Impl.f13724g;
                if (list2 != null) {
                    int size = list2.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        ((j0) downloadDatabase_Impl.f13724g.get(i13)).getClass();
                    }
                    return;
                }
                return;
        }
    }

    public final void d(d dVar) {
        int i10 = this.f215c;
        n0 n0Var = this.f216d;
        switch (i10) {
            case 0:
                int i11 = AppDatabase_Impl.f3322y;
                List<j0> list = ((AppDatabase_Impl) n0Var).f13724g;
                if (list != null) {
                    for (j0 j0Var : list) {
                        j0Var.getClass();
                    }
                    return;
                }
                return;
            default:
                DownloadDatabase_Impl downloadDatabase_Impl = (DownloadDatabase_Impl) n0Var;
                int i12 = DownloadDatabase_Impl.f4075q;
                List list2 = downloadDatabase_Impl.f13724g;
                if (list2 != null) {
                    int size = list2.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        ((j0) downloadDatabase_Impl.f13724g.get(i13)).getClass();
                    }
                    return;
                }
                return;
        }
    }

    public final void e(d dVar) {
        switch (this.f215c) {
            case 0:
                int i10 = AppDatabase_Impl.f3322y;
                ((AppDatabase_Impl) this.f216d).f13718a = dVar;
                dVar.p("PRAGMA foreign_keys = ON");
                ((AppDatabase_Impl) this.f216d).o(dVar);
                List<j0> list = ((AppDatabase_Impl) this.f216d).f13724g;
                if (list != null) {
                    for (j0 j0Var : list) {
                        j0Var.getClass();
                    }
                    return;
                }
                return;
            default:
                int i11 = DownloadDatabase_Impl.f4075q;
                ((DownloadDatabase_Impl) this.f216d).f13718a = dVar;
                ((DownloadDatabase_Impl) this.f216d).o(dVar);
                List list2 = ((DownloadDatabase_Impl) this.f216d).f13724g;
                if (list2 != null) {
                    int size = list2.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        ((j0) ((DownloadDatabase_Impl) this.f216d).f13724g.get(i12)).getClass();
                    }
                    return;
                }
                return;
        }
    }

    public final void f() {
    }

    public final void g(d dVar) {
        switch (this.f215c) {
            case 0:
                h0.P(dVar);
                return;
            default:
                h0.P(dVar);
                return;
        }
    }

    public final s2 h(d dVar) {
        d dVar2 = dVar;
        switch (this.f215c) {
            case 0:
                HashMap hashMap = new HashMap(24);
                hashMap.put("url", new b(0, 1, "url", "TEXT", (String) null, true));
                hashMap.put("source_url", new b(0, 1, "source_url", "TEXT", (String) null, false));
                hashMap.put("source_start_position", new b(0, 1, "source_start_position", "INTEGER", (String) null, false));
                hashMap.put("name", new b(0, 1, "name", "TEXT", (String) null, false));
                hashMap.put("channel_id", new b(0, 1, "channel_id", "INTEGER", (String) null, true));
                hashMap.put("channel_login", new b(0, 1, "channel_login", "TEXT", (String) null, false));
                hashMap.put("channel_name", new b(0, 1, "channel_name", "TEXT", (String) null, false));
                hashMap.put("channel_logo", new b(0, 1, "channel_logo", "TEXT", (String) null, false));
                hashMap.put("thumbnail", new b(0, 1, "thumbnail", "TEXT", (String) null, false));
                hashMap.put("gameId", new b(0, 1, "gameId", "INTEGER", (String) null, true));
                hashMap.put("gameName", new b(0, 1, "gameName", "TEXT", (String) null, false));
                hashMap.put("gameSlug", new b(0, 1, "gameSlug", "TEXT", (String) null, false));
                hashMap.put("boxArtUrl", new b(0, 1, "boxArtUrl", "TEXT", (String) null, false));
                hashMap.put("duration", new b(0, 1, "duration", "INTEGER", (String) null, false));
                hashMap.put("upload_date", new b(0, 1, "upload_date", "INTEGER", (String) null, false));
                hashMap.put("download_date", new b(0, 1, "download_date", "INTEGER", (String) null, false));
                hashMap.put("last_watch_position", new b(0, 1, "last_watch_position", "INTEGER", (String) null, false));
                hashMap.put("progress", new b(0, 1, "progress", "INTEGER", (String) null, true));
                hashMap.put("max_progress", new b(0, 1, "max_progress", "INTEGER", (String) null, true));
                hashMap.put("status", new b(0, 1, "status", "INTEGER", (String) null, true));
                hashMap.put("type", new b(0, 1, "type", "TEXT", (String) null, false));
                hashMap.put("videoId", new b(0, 1, "videoId", "TEXT", (String) null, false));
                hashMap.put("id", new b(1, 1, "id", "INTEGER", (String) null, true));
                Object obj = "duration";
                hashMap.put("is_vod", new b(0, 1, "is_vod", "INTEGER", (String) null, true));
                Object obj2 = "type";
                Object obj3 = "thumbnail";
                h hVar = new h("videos", hashMap, new HashSet(0), new HashSet(0));
                h a10 = h.a(dVar2, "videos");
                if (!hVar.equals(a10)) {
                    return new s2("videos(com.github.andreyasadchy.xtra.model.offline.OfflineVideo).\n Expected:\n" + hVar + "\n Found:\n" + a10, false);
                }
                HashMap hashMap2 = new HashMap(7);
                hashMap2.put("offline_video_id", new b(1, 1, "offline_video_id", "INTEGER", (String) null, true));
                hashMap2.put("url", new b(0, 1, "url", "TEXT", (String) null, true));
                hashMap2.put("path", new b(0, 1, "path", "TEXT", (String) null, true));
                hashMap2.put("video_id", new b(0, 1, "video_id", "TEXT", (String) null, false));
                hashMap2.put("video_type", new b(0, 1, "video_type", "TEXT", (String) null, false));
                hashMap2.put("segment_from", new b(0, 1, "segment_from", "INTEGER", (String) null, false));
                hashMap2.put("segment_to", new b(0, 1, "segment_to", "INTEGER", (String) null, false));
                HashSet hashSet = new HashSet(1);
                hashSet.add(new s3.d("videos", "CASCADE", "NO ACTION", Arrays.asList(new String[]{"offline_video_id"}), Arrays.asList(new String[]{"id"})));
                h hVar2 = new h("requests", hashMap2, hashSet, new HashSet(0));
                h a11 = h.a(dVar2, "requests");
                if (!hVar2.equals(a11)) {
                    return new s2("requests(com.github.andreyasadchy.xtra.model.offline.Request).\n Expected:\n" + hVar2 + "\n Found:\n" + a11, false);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("name", new b(1, 1, "name", "TEXT", (String) null, true));
                hashMap3.put("used_at", new b(0, 1, "used_at", "INTEGER", (String) null, true));
                h hVar3 = new h("recent_emotes", hashMap3, new HashSet(0), new HashSet(0));
                h a12 = h.a(dVar2, "recent_emotes");
                if (!hVar3.equals(a12)) {
                    return new s2("recent_emotes(com.github.andreyasadchy.xtra.model.chat.RecentEmote).\n Expected:\n" + hVar3 + "\n Found:\n" + a12, false);
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put("id", new b(1, 1, "id", "INTEGER", (String) null, true));
                hashMap4.put("position", new b(0, 1, "position", "INTEGER", (String) null, true));
                h hVar4 = new h("video_positions", hashMap4, new HashSet(0), new HashSet(0));
                h a13 = h.a(dVar2, "video_positions");
                if (!hVar4.equals(a13)) {
                    return new s2("video_positions(com.github.andreyasadchy.xtra.model.VideoPosition).\n Expected:\n" + hVar4 + "\n Found:\n" + a13, false);
                }
                HashMap hashMap5 = new HashMap(5);
                hashMap5.put("userId", new b(0, 1, "userId", "INTEGER", (String) null, true));
                hashMap5.put("userLogin", new b(0, 1, "userLogin", "TEXT", (String) null, false));
                hashMap5.put("userName", new b(0, 1, "userName", "TEXT", (String) null, false));
                hashMap5.put("channelLogo", new b(0, 1, "channelLogo", "TEXT", (String) null, false));
                hashMap5.put("id", new b(1, 1, "id", "INTEGER", (String) null, true));
                h hVar5 = new h("local_follows", hashMap5, new HashSet(0), new HashSet(0));
                h a14 = h.a(dVar2, "local_follows");
                if (!hVar5.equals(a14)) {
                    return new s2("local_follows(com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel).\n Expected:\n" + hVar5 + "\n Found:\n" + a14, false);
                }
                HashMap hashMap6 = new HashMap(5);
                hashMap6.put("gameId", new b(0, 1, "gameId", "INTEGER", (String) null, false));
                hashMap6.put("gameSlug", new b(0, 1, "gameSlug", "TEXT", (String) null, false));
                hashMap6.put("gameName", new b(0, 1, "gameName", "TEXT", (String) null, false));
                hashMap6.put("boxArt", new b(0, 1, "boxArt", "TEXT", (String) null, false));
                hashMap6.put("id", new b(1, 1, "id", "INTEGER", (String) null, true));
                h hVar6 = new h("local_follows_games", hashMap6, new HashSet(0), new HashSet(0));
                h a15 = h.a(dVar2, "local_follows_games");
                if (!hVar6.equals(a15)) {
                    return new s2("local_follows_games(com.github.andreyasadchy.xtra.model.offline.LocalFollowGame).\n Expected:\n" + hVar6 + "\n Found:\n" + a15, false);
                }
                HashMap hashMap7 = new HashMap(18);
                hashMap7.put("videoId", new b(0, 1, "videoId", "TEXT", (String) null, false));
                hashMap7.put("userId", new b(0, 1, "userId", "INTEGER", (String) null, true));
                hashMap7.put("userLogin", new b(0, 1, "userLogin", "TEXT", (String) null, false));
                hashMap7.put("userName", new b(0, 1, "userName", "TEXT", (String) null, false));
                hashMap7.put("userType", new b(0, 1, "userType", "TEXT", (String) null, false));
                hashMap7.put("userBroadcasterType", new b(0, 1, "userBroadcasterType", "TEXT", (String) null, false));
                hashMap7.put("userLogo", new b(0, 1, "userLogo", "TEXT", (String) null, false));
                hashMap7.put("gameId", new b(0, 1, "gameId", "INTEGER", (String) null, true));
                hashMap7.put("gameName", new b(0, 1, "gameName", "TEXT", (String) null, false));
                hashMap7.put("gameSlug", new b(0, 1, "gameSlug", "TEXT", (String) null, false));
                hashMap7.put("boxArtUrl", new b(0, 1, "boxArtUrl", "TEXT", (String) null, false));
                hashMap7.put("title", new b(0, 1, "title", "TEXT", (String) null, false));
                hashMap7.put("createdAt", new b(0, 1, "createdAt", "TEXT", (String) null, false));
                hashMap7.put(obj3, new b(0, 1, "thumbnail", "TEXT", (String) null, false));
                hashMap7.put(obj2, new b(0, 1, "type", "TEXT", (String) null, false));
                hashMap7.put(obj, new b(0, 1, "duration", "TEXT", (String) null, false));
                hashMap7.put("animatedPreviewURL", new b(0, 1, "animatedPreviewURL", "TEXT", (String) null, false));
                hashMap7.put("id", new b(1, 1, "id", "INTEGER", (String) null, true));
                h hVar7 = new h("bookmarks", hashMap7, new HashSet(0), new HashSet(0));
                h a16 = h.a(dVar2, "bookmarks");
                if (!hVar7.equals(a16)) {
                    return new s2("bookmarks(com.github.andreyasadchy.xtra.model.offline.Bookmark).\n Expected:\n" + hVar7 + "\n Found:\n" + a16, false);
                }
                HashMap hashMap8 = new HashMap(1);
                hashMap8.put("user_id", new b(1, 1, "user_id", "INTEGER", (String) null, true));
                h hVar8 = new h("vod_bookmark_ignored_users", hashMap8, new HashSet(0), new HashSet(0));
                h a17 = h.a(dVar2, "vod_bookmark_ignored_users");
                if (!hVar8.equals(a17)) {
                    return new s2("vod_bookmark_ignored_users(com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser).\n Expected:\n" + hVar8 + "\n Found:\n" + a17, false);
                }
                HashMap hashMap9 = new HashMap(5);
                hashMap9.put("id", new b(1, 1, "id", "TEXT", (String) null, true));
                hashMap9.put("saveSort", new b(0, 1, "saveSort", "INTEGER", (String) null, false));
                hashMap9.put("videoSort", new b(0, 1, "videoSort", "TEXT", (String) null, false));
                hashMap9.put("videoType", new b(0, 1, "videoType", "TEXT", (String) null, false));
                hashMap9.put("clipPeriod", new b(0, 1, "clipPeriod", "TEXT", (String) null, false));
                h hVar9 = new h("sort_channel", hashMap9, new HashSet(0), new HashSet(0));
                h a18 = h.a(dVar2, "sort_channel");
                if (!hVar9.equals(a18)) {
                    return new s2("sort_channel(com.github.andreyasadchy.xtra.model.offline.SortChannel).\n Expected:\n" + hVar9 + "\n Found:\n" + a18, false);
                }
                HashMap hashMap10 = new HashMap(8);
                hashMap10.put("id", new b(1, 1, "id", "TEXT", (String) null, true));
                hashMap10.put("saveSort", new b(0, 1, "saveSort", "INTEGER", (String) null, false));
                hashMap10.put("videoSort", new b(0, 1, "videoSort", "TEXT", (String) null, false));
                hashMap10.put("videoPeriod", new b(0, 1, "videoPeriod", "TEXT", (String) null, false));
                hashMap10.put("videoType", new b(0, 1, "videoType", "TEXT", (String) null, false));
                hashMap10.put("videoLanguageIndex", new b(0, 1, "videoLanguageIndex", "INTEGER", (String) null, false));
                hashMap10.put("clipPeriod", new b(0, 1, "clipPeriod", "TEXT", (String) null, false));
                hashMap10.put("clipLanguageIndex", new b(0, 1, "clipLanguageIndex", "INTEGER", (String) null, false));
                h hVar10 = new h("sort_game", hashMap10, new HashSet(0), new HashSet(0));
                h a19 = h.a(dVar2, "sort_game");
                if (hVar10.equals(a19)) {
                    return new s2((String) null, true);
                }
                return new s2("sort_game(com.github.andreyasadchy.xtra.model.offline.SortGame).\n Expected:\n" + hVar10 + "\n Found:\n" + a19, false);
            default:
                HashMap hashMap11 = new HashMap(20);
                hashMap11.put("_id", new b(1, 1, "_id", "INTEGER", (String) null, true));
                hashMap11.put("_namespace", new b(0, 1, "_namespace", "TEXT", (String) null, true));
                hashMap11.put("_url", new b(0, 1, "_url", "TEXT", (String) null, true));
                hashMap11.put("_file", new b(0, 1, "_file", "TEXT", (String) null, true));
                hashMap11.put("_group", new b(0, 1, "_group", "INTEGER", (String) null, true));
                hashMap11.put("_priority", new b(0, 1, "_priority", "INTEGER", (String) null, true));
                hashMap11.put("_headers", new b(0, 1, "_headers", "TEXT", (String) null, true));
                hashMap11.put("_written_bytes", new b(0, 1, "_written_bytes", "INTEGER", (String) null, true));
                hashMap11.put("_total_bytes", new b(0, 1, "_total_bytes", "INTEGER", (String) null, true));
                hashMap11.put("_status", new b(0, 1, "_status", "INTEGER", (String) null, true));
                hashMap11.put("_error", new b(0, 1, "_error", "INTEGER", (String) null, true));
                hashMap11.put("_network_type", new b(0, 1, "_network_type", "INTEGER", (String) null, true));
                hashMap11.put("_created", new b(0, 1, "_created", "INTEGER", (String) null, true));
                hashMap11.put("_tag", new b(0, 1, "_tag", "TEXT", (String) null, false));
                hashMap11.put("_enqueue_action", new b(0, 1, "_enqueue_action", "INTEGER", (String) null, true));
                hashMap11.put("_identifier", new b(0, 1, "_identifier", "INTEGER", (String) null, true));
                hashMap11.put("_download_on_enqueue", new b(0, 1, "_download_on_enqueue", "INTEGER", (String) null, true));
                hashMap11.put("_extras", new b(0, 1, "_extras", "TEXT", (String) null, true));
                hashMap11.put("_auto_retry_max_attempts", new b(0, 1, "_auto_retry_max_attempts", "INTEGER", (String) null, true));
                hashMap11.put("_auto_retry_attempts", new b(0, 1, "_auto_retry_attempts", "INTEGER", (String) null, true));
                HashSet hashSet2 = new HashSet(0);
                HashSet hashSet3 = new HashSet(2);
                hashSet3.add(new g("index_requests__file", Arrays.asList(new String[]{"_file"}), true));
                hashSet3.add(new g("index_requests__group__status", Arrays.asList(new String[]{"_group", "_status"}), false));
                h hVar11 = new h("requests", hashMap11, hashSet2, hashSet3);
                h a20 = h.a(dVar2, "requests");
                if (hVar11.equals(a20)) {
                    return new s2((String) null, true);
                }
                return new s2("requests(com.tonyodev.fetch2.database.DownloadInfo).\n Expected:\n" + hVar11 + "\n Found:\n" + a20, false);
        }
    }
}

package y5;

import a6.z;
import android.app.Application;
import b6.f;
import c6.b;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import com.github.andreyasadchy.xtra.ui.download.ClipDownloadViewModel;
import com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel;
import com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel;
import com.github.andreyasadchy.xtra.ui.follow.games.FollowedGamesViewModel;
import com.github.andreyasadchy.xtra.ui.games.GamePagerViewModel;
import com.github.andreyasadchy.xtra.ui.games.GamesViewModel;
import com.github.andreyasadchy.xtra.ui.main.MainViewModel;
import com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.player.offline.OfflinePlayerViewModel;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import com.github.andreyasadchy.xtra.ui.saved.downloads.DownloadsViewModel;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerViewModel;
import com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.streams.StreamSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.videos.VideoSearchViewModel;
import com.github.andreyasadchy.xtra.ui.settings.SettingsViewModel;
import com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel;
import com.github.andreyasadchy.xtra.ui.streams.followed.FollowedStreamsViewModel;
import com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel;
import com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel;
import com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel;
import com.github.andreyasadchy.xtra.ui.view.chat.MessageClickedViewModel;
import e6.c2;
import e6.e0;
import e6.e1;
import e6.f2;
import e6.j2;
import e6.o1;
import e6.s0;
import e6.x;
import e6.y0;
import e6.z1;
import javax.inject.Provider;
import pb.f1;

public final class i implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final h f17003a;

    /* renamed from: b  reason: collision with root package name */
    public final j f17004b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17005c;

    public i(h hVar, j jVar, int i10) {
        this.f17003a = hVar;
        this.f17004b = jVar;
        this.f17005c = i10;
    }

    public final Object get() {
        j jVar = this.f17004b;
        h hVar = this.f17003a;
        int i10 = this.f17005c;
        switch (i10) {
            case 0:
                return new BookmarksViewModel((x) hVar.f16987k.get(), (e0) hVar.f16992p.get(), (z1) hVar.f16996t.get(), (j2) hVar.f16998v.get());
            case 1:
                return new ChannelPagerViewModel((x) hVar.f16987k.get(), (y0) hVar.f16999w.get(), (o1) hVar.f17001y.get(), (e0) hVar.f16992p.get(), jVar.f17006a);
            case 2:
                return new ChannelSearchViewModel((x) hVar.f16987k.get());
            case 3:
                return new ChannelVideosViewModel(f.a(hVar.f16979c), (c2) hVar.A.get(), (x) hVar.f16987k.get(), (z1) hVar.f16996t.get(), (e0) hVar.f16992p.get(), jVar.f17006a, (s0) hVar.f16984h.get(), (b) hVar.f16986j.get());
            case 4:
                return new ChatViewModel((x) hVar.f16987k.get(), (z1) hVar.f16996t.get(), (f1) hVar.f16981e.get(), (s0) hVar.f16984h.get(), (b) hVar.f16986j.get());
            case Constants.MAX_COMPATIBILITY_VERSION:
                Application a10 = hVar.f16979c.a();
                ka.b.a(a10);
                return new ClipDownloadViewModel(a10, (o1) hVar.f17001y.get());
            case 6:
                return new ClipPlayerViewModel((x) hVar.f16987k.get(), (y0) hVar.f16999w.get());
            case 7:
                return new ClipsViewModel(f.a(hVar.f16979c), (c2) hVar.A.get(), (f2) hVar.C.get(), (x) hVar.f16987k.get(), jVar.f17006a);
            case 8:
                return new DownloadsViewModel((o1) hVar.f17001y.get(), (s7.f) hVar.E.get());
            case 9:
                return new FollowedChannelsViewModel(f.a(hVar.f16979c), (c2) hVar.A.get(), (y0) hVar.f16999w.get(), (o1) hVar.f17001y.get(), (e0) hVar.f16992p.get());
            case 10:
                return new FollowedGamesViewModel(f.a(hVar.f16979c), (e1) hVar.G.get());
            case 11:
                return new FollowedStreamsViewModel(f.a(hVar.f16979c), (y0) hVar.f16999w.get(), (x) hVar.f16987k.get());
            case 12:
                return new FollowedVideosViewModel(f.a(hVar.f16979c), (c2) hVar.A.get(), (x) hVar.f16987k.get(), (z1) hVar.f16996t.get(), (e0) hVar.f16992p.get());
            case 13:
                return new GamePagerViewModel((e1) hVar.G.get());
            case 14:
                return new GameSearchViewModel((x) hVar.f16987k.get());
            case 15:
                return new GameVideosViewModel(f.a(hVar.f16979c), (f2) hVar.C.get(), (x) hVar.f16987k.get(), (z1) hVar.f16996t.get(), (e0) hVar.f16992p.get(), jVar.f17006a);
            case Constants.IV_SIZE:
                return new GamesViewModel((x) hVar.f16987k.get());
            case 17:
                Application a11 = hVar.f16979c.a();
                ka.b.a(a11);
                return new MainViewModel(a11, (x) hVar.f16987k.get(), (o1) hVar.f17001y.get());
            case 18:
                return new MessageClickedViewModel((x) hVar.f16987k.get());
            case 19:
                return new OfflinePlayerViewModel((o1) hVar.f17001y.get(), (x) hVar.f16987k.get(), (y0) hVar.f16999w.get());
            case 20:
                return new SearchPagerViewModel((x) hVar.f16987k.get());
            case 21:
                return new SettingsViewModel((a6.x) hVar.f16995s.get(), (z) hVar.f16991o.get());
            case 22:
                return new StreamPlayerViewModel((z1) hVar.f16996t.get(), (x) hVar.f16987k.get(), (y0) hVar.f16999w.get());
            case 23:
                return new StreamSearchViewModel(f.a(hVar.f16979c));
            case 24:
                return new StreamsViewModel(f.a(hVar.f16979c), (x) hVar.f16987k.get(), jVar.f17006a);
            case 25:
                return new TagSearchViewModel(jVar.f17006a);
            case 26:
                Application a12 = hVar.f16979c.a();
                ka.b.a(a12);
                return new VideoDownloadViewModel(a12, (z1) hVar.f16996t.get(), (o1) hVar.f17001y.get());
            case 27:
                return new VideoPlayerViewModel((z1) hVar.f16996t.get(), (x) hVar.f16987k.get(), (y0) hVar.f16999w.get(), (e0) hVar.f16992p.get());
            case 28:
                return new VideoSearchViewModel((z1) hVar.f16996t.get(), (e0) hVar.f16992p.get(), (x) hVar.f16987k.get());
            default:
                throw new AssertionError(i10);
        }
    }
}

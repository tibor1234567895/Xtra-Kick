package ha;

import androidx.lifecycle.b;
import androidx.lifecycle.j1;
import androidx.lifecycle.w1;
import ba.a;
import d9.s0;
import d9.u;
import ga.d;
import java.util.LinkedHashSet;
import javax.inject.Provider;
import l.h;
import y5.c;
import y5.j;

public final class f extends b {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f7770d;

    public f(d dVar) {
        this.f7770d = dVar;
    }

    public final w1 d(String str, Class cls, j1 j1Var) {
        i iVar = new i();
        h hVar = (h) this.f7770d;
        hVar.getClass();
        j1Var.getClass();
        hVar.f9449k = j1Var;
        hVar.f9450l = iVar;
        j jVar = (j) ((g) a.a(g.class, new j((y5.h) hVar.f9447i, (c) hVar.f9448j, j1Var)));
        jVar.getClass();
        u.a(29, "expectedSize");
        s0 s0Var = new s0(29);
        s0Var.b("com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel", jVar.f17007b);
        s0Var.b("com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel", jVar.f17008c);
        s0Var.b("com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel", jVar.f17009d);
        s0Var.b("com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel", jVar.f17010e);
        s0Var.b("com.github.andreyasadchy.xtra.ui.chat.ChatViewModel", jVar.f17011f);
        s0Var.b("com.github.andreyasadchy.xtra.ui.download.ClipDownloadViewModel", jVar.f17012g);
        s0Var.b("com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel", jVar.f17013h);
        s0Var.b("com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel", jVar.f17014i);
        s0Var.b("com.github.andreyasadchy.xtra.ui.saved.downloads.DownloadsViewModel", jVar.f17015j);
        s0Var.b("com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel", jVar.f17016k);
        s0Var.b("com.github.andreyasadchy.xtra.ui.follow.games.FollowedGamesViewModel", jVar.f17017l);
        s0Var.b("com.github.andreyasadchy.xtra.ui.streams.followed.FollowedStreamsViewModel", jVar.f17018m);
        s0Var.b("com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel", jVar.f17019n);
        s0Var.b("com.github.andreyasadchy.xtra.ui.games.GamePagerViewModel", jVar.f17020o);
        s0Var.b("com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel", jVar.f17021p);
        s0Var.b("com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel", jVar.f17022q);
        s0Var.b("com.github.andreyasadchy.xtra.ui.games.GamesViewModel", jVar.f17023r);
        s0Var.b("com.github.andreyasadchy.xtra.ui.main.MainViewModel", jVar.f17024s);
        s0Var.b("com.github.andreyasadchy.xtra.ui.view.chat.MessageClickedViewModel", jVar.f17025t);
        s0Var.b("com.github.andreyasadchy.xtra.ui.player.offline.OfflinePlayerViewModel", jVar.f17026u);
        s0Var.b("com.github.andreyasadchy.xtra.ui.search.SearchPagerViewModel", jVar.f17027v);
        s0Var.b("com.github.andreyasadchy.xtra.ui.settings.SettingsViewModel", jVar.f17028w);
        s0Var.b("com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel", jVar.f17029x);
        s0Var.b("com.github.andreyasadchy.xtra.ui.search.streams.StreamSearchViewModel", jVar.f17030y);
        s0Var.b("com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel", jVar.f17031z);
        s0Var.b("com.github.andreyasadchy.xtra.ui.search.tags.TagSearchViewModel", jVar.A);
        s0Var.b("com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel", jVar.B);
        s0Var.b("com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel", jVar.C);
        s0Var.b("com.github.andreyasadchy.xtra.ui.search.videos.VideoSearchViewModel", jVar.D);
        Provider provider = (Provider) ((d9.w1) s0Var.a()).get(cls.getName());
        if (provider != null) {
            w1 w1Var = (w1) provider.get();
            e eVar = new e(iVar);
            LinkedHashSet linkedHashSet = w1Var.f1782b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    w1Var.f1782b.add(eVar);
                }
            }
            return w1Var;
        }
        throw new IllegalStateException("Expected the @HiltViewModel-annotated class '" + cls.getName() + "' to be available in the multi-binding of @HiltViewModelMap but none was found.");
    }
}

package a7;

import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.ui.saved.downloads.DownloadsViewModel;
import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.Format;
import com.iheartradio.m3u8.PlaylistParser;
import com.iheartradio.m3u8.data.TrackData;
import hb.f0;
import hb.h0;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import la.v;
import ma.z;
import pa.e;
import ra.i;
import t9.g;
import t9.m;
import va.k;
import wa.p;
import xa.j;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OfflineVideo f282i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DownloadsViewModel f283j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(OfflineVideo offlineVideo, DownloadsViewModel downloadsViewModel, e eVar) {
        super(2, eVar);
        this.f282i = offlineVideo;
        this.f283j = downloadsViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f282i, this.f283j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        h0.O1(obj);
        OfflineVideo offlineVideo = this.f282i;
        if (offlineVideo.getStatus() == 2) {
            File file = new File(offlineVideo.getUrl());
            if (!file.exists()) {
                return v.f9814a;
            }
            if (offlineVideo.getVod()) {
                File parentFile = file.getParentFile();
                File[] listFiles = parentFile.listFiles(new g(file));
                j.e("playlists", listFiles);
                if (listFiles.length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    k.a(parentFile);
                } else {
                    List<TrackData> tracks = new PlaylistParser((InputStream) new FileInputStream(file), Format.EXT_M3U, Encoding.UTF_8).parse().getMediaPlaylist().getTracks();
                    j.e("playlist.mediaPlaylist.tracks", tracks);
                    Set<TrackData> M = z.M(tracks);
                    for (File file2 : listFiles) {
                        j.e("it", file2);
                        List<TrackData> tracks2 = new PlaylistParser((InputStream) new FileInputStream(file2), Format.EXT_M3U, Encoding.UTF_8).parse().getMediaPlaylist().getTracks();
                        j.e("p.mediaPlaylist.tracks", tracks2);
                        M.removeAll(z.N(tracks2));
                    }
                    file.delete();
                    for (TrackData uri : M) {
                        new File(uri.getUri()).delete();
                    }
                }
            } else {
                file.delete();
            }
        } else {
            m mVar = (m) this.f283j.f3466e.a(new Integer(offlineVideo.getId()));
            g gVar = new g(mVar, offlineVideo.getId());
            synchronized (mVar.f14875b) {
                mVar.e();
                mVar.f14881h.d(new t9.k(mVar, gVar, (t9.i) null, (t9.i) null, 1));
            }
        }
        return v.f9814a;
    }
}

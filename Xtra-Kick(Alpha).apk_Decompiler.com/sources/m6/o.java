package m6;

import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class o extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DownloadService f10656i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(DownloadService downloadService, e eVar) {
        super(2, eVar);
        this.f10656i = downloadService;
    }

    public final e create(Object obj, e eVar) {
        return new o(this.f10656i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((o) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        hb.h0.A(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            com.github.andreyasadchy.xtra.ui.download.DownloadService r0 = r6.f10656i
            hb.h0.O1(r7)
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x0056 }
            com.github.andreyasadchy.xtra.model.offline.Request r1 = r0.f3388q     // Catch:{ Exception -> 0x0056 }
            r2 = 0
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = r1.getUrl()     // Catch:{ Exception -> 0x0056 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0056 }
            r3.<init>()     // Catch:{ Exception -> 0x0056 }
            r3.append(r1)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r1 = "playlist.m3u8"
            r3.append(r1)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0056 }
            r7.<init>(r1)     // Catch:{ Exception -> 0x0056 }
            java.io.InputStream r7 = r7.openStream()     // Catch:{ Exception -> 0x0056 }
            com.iheartradio.m3u8.PlaylistParser r1 = new com.iheartradio.m3u8.PlaylistParser     // Catch:{ all -> 0x0049 }
            com.iheartradio.m3u8.Format r3 = com.iheartradio.m3u8.Format.EXT_M3U     // Catch:{ all -> 0x0049 }
            com.iheartradio.m3u8.Encoding r4 = com.iheartradio.m3u8.Encoding.UTF_8     // Catch:{ all -> 0x0049 }
            com.iheartradio.m3u8.ParsingMode r5 = com.iheartradio.m3u8.ParsingMode.LENIENT     // Catch:{ all -> 0x0049 }
            r1.<init>((java.io.InputStream) r7, (com.iheartradio.m3u8.Format) r3, (com.iheartradio.m3u8.Encoding) r4, (com.iheartradio.m3u8.ParsingMode) r5)     // Catch:{ all -> 0x0049 }
            com.iheartradio.m3u8.data.Playlist r1 = r1.parse()     // Catch:{ all -> 0x0049 }
            com.iheartradio.m3u8.data.MediaPlaylist r1 = r1.getMediaPlaylist()     // Catch:{ all -> 0x0049 }
            hb.h0.A(r7, r2)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r7 = "URL(request.url + \"playl…ist\n                    }"
            xa.j.e(r7, r1)     // Catch:{ Exception -> 0x0056 }
            r0.f3390s = r1     // Catch:{ Exception -> 0x0056 }
            com.github.andreyasadchy.xtra.ui.download.DownloadService.a(r0)     // Catch:{ Exception -> 0x0056 }
            goto L_0x005e
        L_0x0049:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004b }
        L_0x004b:
            r1 = move-exception
            hb.h0.A(r7, r0)     // Catch:{ Exception -> 0x0056 }
            throw r1     // Catch:{ Exception -> 0x0056 }
        L_0x0050:
            java.lang.String r7 = "request"
            xa.j.l(r7)     // Catch:{ Exception -> 0x0056 }
            throw r2     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            r7 = move-exception
            java.lang.String r0 = "NOP"
            java.lang.String r1 = "error: "
            android.util.Log.e(r0, r1, r7)
        L_0x005e:
            la.v r7 = la.v.f9814a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.o.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

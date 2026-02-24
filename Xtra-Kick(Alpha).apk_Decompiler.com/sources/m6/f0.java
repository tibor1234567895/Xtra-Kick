package m6;

import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class f0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f10639i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f10640j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Video f10641k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VideoDownloadViewModel f10642l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f10643m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(Video video, VideoDownloadViewModel videoDownloadViewModel, String str, e eVar) {
        super(2, eVar);
        this.f10641k = video;
        this.f10642l = videoDownloadViewModel;
        this.f10643m = str;
    }

    public final e create(Object obj, e eVar) {
        f0 f0Var = new f0(this.f10641k, this.f10642l, this.f10643m, eVar);
        f0Var.f10640j = obj;
        return f0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((f0) create((hb.f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: hb.f0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5 A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c9 A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e4 A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0156 A[Catch:{ Exception -> 0x00a0 }, LOOP:1: B:53:0x0150->B:55:0x0156, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a0 A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00df A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r2 = r1.f10639i
            com.github.andreyasadchy.xtra.model.ui.Video r4 = r1.f10641k
            com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel r5 = r1.f10642l
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0023
            if (r2 != r7) goto L_0x001b
            java.lang.Object r0 = r1.f10640j
            r2 = r0
            hb.f0 r2 = (hb.f0) r2
            hb.h0.O1(r20)     // Catch:{ Exception -> 0x00a0 }
            r8 = r20
            goto L_0x0053
        L_0x001b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0023:
            hb.h0.O1(r20)
            java.lang.Object r2 = r1.f10640j
            hb.f0 r2 = (hb.f0) r2
            java.lang.String r8 = r4.getAnimatedPreviewURL()     // Catch:{ Exception -> 0x00a0 }
            if (r8 == 0) goto L_0x0039
            boolean r8 = fb.w.h(r8)     // Catch:{ Exception -> 0x00a0 }
            if (r8 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r8 = 0
            goto L_0x003a
        L_0x0039:
            r8 = 1
        L_0x003a:
            if (r8 != 0) goto L_0x0043
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x00a0 }
            r0.<init>()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00ba
        L_0x0043:
            e6.z1 r8 = r5.f3394e     // Catch:{ Exception -> 0x00a0 }
            r4.getUuid()     // Catch:{ Exception -> 0x00a0 }
            r1.f10640j = r2     // Catch:{ Exception -> 0x00a0 }
            r1.f10639i = r7     // Catch:{ Exception -> 0x00a0 }
            java.lang.Object r8 = r8.a(r1)     // Catch:{ Exception -> 0x00a0 }
            if (r8 != r0) goto L_0x0053
            return r0
        L_0x0053:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x00a0 }
            boolean r0 = r8.isSuccessful()     // Catch:{ Exception -> 0x00a0 }
            if (r0 == 0) goto L_0x00a3
            java.lang.Object r0 = r8.body()     // Catch:{ Exception -> 0x00a0 }
            xa.j.c(r0)     // Catch:{ Exception -> 0x00a0 }
            pb.u1 r0 = (pb.u1) r0     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r0 = r0.string()     // Catch:{ Exception -> 0x00a0 }
            fb.l r4 = new fb.l     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r8 = "NAME=\"(.*)\""
            r4.<init>(r8)     // Catch:{ Exception -> 0x00a0 }
            eb.r r4 = fb.l.a(r4, r0)     // Catch:{ Exception -> 0x00a0 }
            m6.d0 r8 = m6.d0.f10630h     // Catch:{ Exception -> 0x00a0 }
            eb.r r4 = eb.q.c(r4, r8)     // Catch:{ Exception -> 0x00a0 }
            java.util.ArrayList r4 = eb.q.e(r4)     // Catch:{ Exception -> 0x00a0 }
            fb.l r8 = new fb.l     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r9 = "https://.*\\.m3u8"
            r8.<init>(r9)     // Catch:{ Exception -> 0x00a0 }
            eb.r r0 = fb.l.a(r8, r0)     // Catch:{ Exception -> 0x00a0 }
            m6.e0 r8 = m6.e0.f10631p     // Catch:{ Exception -> 0x00a0 }
            eb.r r0 = eb.q.c(r0, r8)     // Catch:{ Exception -> 0x00a0 }
            java.util.ArrayList r0 = eb.q.e(r0)     // Catch:{ Exception -> 0x00a0 }
            java.util.ArrayList r0 = ma.z.O(r4, r0)     // Catch:{ Exception -> 0x00a0 }
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x00a0 }
            r4.<init>()     // Catch:{ Exception -> 0x00a0 }
            ma.j0.h(r0, r4)     // Catch:{ Exception -> 0x00a0 }
            r10 = r4
            goto L_0x00bb
        L_0x00a0:
            r0 = move-exception
            goto L_0x01a6
        L_0x00a3:
            java.lang.String r0 = r4.getAnimatedPreviewURL()     // Catch:{ Exception -> 0x00a0 }
            if (r0 == 0) goto L_0x00b2
            boolean r0 = fb.w.h(r0)     // Catch:{ Exception -> 0x00a0 }
            if (r0 == 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r0 = 0
            goto L_0x00b3
        L_0x00b2:
            r0 = 1
        L_0x00b3:
            if (r0 != 0) goto L_0x01a0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x00a0 }
            r0.<init>()     // Catch:{ Exception -> 0x00a0 }
        L_0x00ba:
            r10 = r0
        L_0x00bb:
            java.util.Set r0 = r10.entrySet()     // Catch:{ Exception -> 0x00a0 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00a0 }
        L_0x00c3:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x00a0 }
            if (r4 == 0) goto L_0x00df
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x00a0 }
            r8 = r4
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ Exception -> 0x00a0 }
            java.lang.Object r8 = r8.getKey()     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r9 = "audio"
            boolean r8 = fb.w.m(r8, r9, r7)     // Catch:{ Exception -> 0x00a0 }
            if (r8 == 0) goto L_0x00c3
            goto L_0x00e0
        L_0x00df:
            r4 = r6
        L_0x00e0:
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x00a0 }
            if (r4 == 0) goto L_0x0105
            java.lang.Object r0 = r4.getKey()     // Catch:{ Exception -> 0x00a0 }
            r10.remove(r0)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r0 = "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication"
            android.app.Application r7 = r5.f1665d     // Catch:{ Exception -> 0x00a0 }
            xa.j.d(r0, r7)     // Catch:{ Exception -> 0x00a0 }
            r0 = 2131951674(0x7f13003a, float:1.953977E38)
            java.lang.String r0 = r7.getString(r0)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r7 = "getApplication<Applicati…ring(R.string.audio_only)"
            xa.j.e(r7, r0)     // Catch:{ Exception -> 0x00a0 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x00a0 }
            r10.put(r0, r4)     // Catch:{ Exception -> 0x00a0 }
        L_0x0105:
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00a0 }
            java.util.Collection r4 = r10.values()     // Catch:{ Exception -> 0x00a0 }
            java.lang.Object r4 = ma.z.o(r4)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00a0 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00a0 }
            java.io.InputStream r4 = r0.openStream()     // Catch:{ Exception -> 0x00a0 }
            com.iheartradio.m3u8.PlaylistParser r0 = new com.iheartradio.m3u8.PlaylistParser     // Catch:{ all -> 0x0197 }
            com.iheartradio.m3u8.Format r7 = com.iheartradio.m3u8.Format.EXT_M3U     // Catch:{ all -> 0x0197 }
            com.iheartradio.m3u8.Encoding r8 = com.iheartradio.m3u8.Encoding.UTF_8     // Catch:{ all -> 0x0197 }
            com.iheartradio.m3u8.ParsingMode r9 = com.iheartradio.m3u8.ParsingMode.LENIENT     // Catch:{ all -> 0x0197 }
            r0.<init>((java.io.InputStream) r4, (com.iheartradio.m3u8.Format) r7, (com.iheartradio.m3u8.Encoding) r8, (com.iheartradio.m3u8.ParsingMode) r9)     // Catch:{ all -> 0x0197 }
            com.iheartradio.m3u8.data.Playlist r0 = r0.parse()     // Catch:{ all -> 0x0197 }
            com.iheartradio.m3u8.data.MediaPlaylist r0 = r0.getMediaPlaylist()     // Catch:{ all -> 0x0197 }
            hb.h0.A(r4, r6)     // Catch:{ Exception -> 0x00a0 }
            java.util.List r4 = r0.getTracks()     // Catch:{ Exception -> 0x00a0 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x00a0 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a0 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x00a0 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a0 }
            r12.<init>(r4)     // Catch:{ Exception -> 0x00a0 }
            java.util.List r4 = r0.getTracks()     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r7 = "mediaPlaylist.tracks"
            xa.j.e(r7, r4)     // Catch:{ Exception -> 0x00a0 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a0 }
            r7 = 0
            r13 = r7
        L_0x0150:
            boolean r9 = r4.hasNext()     // Catch:{ Exception -> 0x00a0 }
            if (r9 == 0) goto L_0x017e
            java.lang.Object r9 = r4.next()     // Catch:{ Exception -> 0x00a0 }
            com.iheartradio.m3u8.data.TrackData r9 = (com.iheartradio.m3u8.data.TrackData) r9     // Catch:{ Exception -> 0x00a0 }
            com.iheartradio.m3u8.data.TrackInfo r9 = r9.getTrackInfo()     // Catch:{ Exception -> 0x00a0 }
            float r9 = r9.duration     // Catch:{ Exception -> 0x00a0 }
            r15 = 1148846080(0x447a0000, float:1000.0)
            float r9 = r9 * r15
            r20 = r4
            long r3 = (long) r9     // Catch:{ Exception -> 0x00a0 }
            java.lang.Long r9 = new java.lang.Long     // Catch:{ Exception -> 0x00a0 }
            r9.<init>(r3)     // Catch:{ Exception -> 0x00a0 }
            r12.add(r9)     // Catch:{ Exception -> 0x00a0 }
            long r13 = r13 + r3
            java.lang.Long r9 = new java.lang.Long     // Catch:{ Exception -> 0x00a0 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00a0 }
            r11.add(r9)     // Catch:{ Exception -> 0x00a0 }
            long r7 = r7 + r3
            r4 = r20
            goto L_0x0150
        L_0x017e:
            androidx.lifecycle.o0 r3 = r5.f3396g     // Catch:{ Exception -> 0x00a0 }
            com.github.andreyasadchy.xtra.model.VideoDownloadInfo r4 = new com.github.andreyasadchy.xtra.model.VideoDownloadInfo     // Catch:{ Exception -> 0x00a0 }
            com.github.andreyasadchy.xtra.model.ui.Video r9 = r1.f10641k     // Catch:{ Exception -> 0x00a0 }
            int r0 = r0.getTargetDuration()     // Catch:{ Exception -> 0x00a0 }
            long r7 = (long) r0     // Catch:{ Exception -> 0x00a0 }
            r15 = 1000(0x3e8, double:4.94E-321)
            long r15 = r15 * r7
            r17 = 0
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13, r15, r17)     // Catch:{ Exception -> 0x00a0 }
            r3.j(r4)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x01b8
        L_0x0197:
            r0 = move-exception
            r3 = r0
            throw r3     // Catch:{ all -> 0x019a }
        L_0x019a:
            r0 = move-exception
            r7 = r0
            hb.h0.A(r4, r3)     // Catch:{ Exception -> 0x00a0 }
            throw r7     // Catch:{ Exception -> 0x00a0 }
        L_0x01a0:
            java.lang.IllegalAccessException r0 = new java.lang.IllegalAccessException     // Catch:{ Exception -> 0x00a0 }
            r0.<init>()     // Catch:{ Exception -> 0x00a0 }
            throw r0     // Catch:{ Exception -> 0x00a0 }
        L_0x01a6:
            boolean r0 = r0 instanceof java.lang.IllegalAccessException
            if (r0 == 0) goto L_0x01b8
            nb.e r0 = hb.p0.f7833a
            hb.x1 r0 = mb.u.f10886a
            m6.c0 r3 = new m6.c0
            r3.<init>(r5, r6)
            r4 = 2
            r5 = 0
            hb.h0.b1(r2, r0, r5, r3, r4)
        L_0x01b8:
            la.v r0 = la.v.f9814a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.f0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

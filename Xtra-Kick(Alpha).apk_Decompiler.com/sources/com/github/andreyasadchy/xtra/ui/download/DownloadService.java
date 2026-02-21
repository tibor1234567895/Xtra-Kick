package com.github.andreyasadchy.xtra.ui.download;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import b0.l0;
import b0.o;
import b0.p;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.iheartradio.m3u8.data.MediaPlaylist;
import com.iheartradio.m3u8.data.TrackData;
import com.woxthebox.draglistview.R;
import e6.o1;
import e6.z1;
import f0.g;
import g.g0;
import hb.d1;
import hb.h0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.inject.Inject;
import la.v;
import m1.b;
import m6.i;
import m6.k;
import m6.n;
import m6.t;
import ma.q;
import ma.r;
import p9.h;
import p9.u;
import pa.e;
import pa.l;
import s7.f;
import t9.m;
import xa.j;

public final class DownloadService extends t {

    /* renamed from: w  reason: collision with root package name */
    public static final i f3380w = new i(0);

    /* renamed from: x  reason: collision with root package name */
    public static final HashSet f3381x = new HashSet();
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public z1 f3382k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public o1 f3383l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public f f3384m;

    /* renamed from: n  reason: collision with root package name */
    public h f3385n;

    /* renamed from: o  reason: collision with root package name */
    public p f3386o;

    /* renamed from: p  reason: collision with root package name */
    public l0 f3387p;

    /* renamed from: q  reason: collision with root package name */
    public Request f3388q;

    /* renamed from: r  reason: collision with root package name */
    public OfflineVideo f3389r;

    /* renamed from: s  reason: collision with root package name */
    public MediaPlaylist f3390s;

    /* renamed from: t  reason: collision with root package name */
    public final g0 f3391t = new g0(5, this);

    /* renamed from: u  reason: collision with root package name */
    public o f3392u;

    /* renamed from: v  reason: collision with root package name */
    public o f3393v;

    public DownloadService() {
        setIntentRedelivery(true);
    }

    public static final void a(DownloadService downloadService) {
        downloadService.getClass();
        ArrayList arrayList = new ArrayList();
        try {
            MediaPlaylist mediaPlaylist = downloadService.f3390s;
            if (mediaPlaylist != null) {
                List<TrackData> tracks = mediaPlaylist.getTracks();
                j.e("playlist.tracks", tracks);
                Request request = downloadService.f3388q;
                if (request != null) {
                    Integer segmentFrom = request.getSegmentFrom();
                    j.c(segmentFrom);
                    int intValue = segmentFrom.intValue();
                    OfflineVideo offlineVideo = downloadService.f3389r;
                    if (offlineVideo != null) {
                        int progress = offlineVideo.getProgress() + intValue;
                        int i10 = progress + 15;
                        try {
                            Integer segmentTo = request.getSegmentTo();
                            j.c(segmentTo);
                            int min = Math.min(i10, segmentTo.intValue());
                            if (progress <= min) {
                                while (true) {
                                    String uri = tracks.get(progress).getUri();
                                    u uVar = new u(request.getUrl() + uri, request.getPath() + uri);
                                    uVar.f12723i = request.getOfflineVideoId();
                                    arrayList.add(uVar);
                                    if (progress == min) {
                                        break;
                                    }
                                    progress++;
                                }
                            }
                        } catch (IndexOutOfBoundsException unused) {
                            o1 e10 = downloadService.e();
                            OfflineVideo offlineVideo2 = downloadService.f3389r;
                            if (offlineVideo2 != null) {
                                request.setSegmentTo(Integer.valueOf(r.d(tracks)));
                                e10.b(offlineVideo2);
                            } else {
                                j.l("offlineVideo");
                                throw null;
                            }
                        }
                        h hVar = downloadService.f3385n;
                        if (hVar != null) {
                            ((m) hVar).b(arrayList, (t9.i) null, (t9.i) null);
                        } else {
                            j.l("fetch");
                            throw null;
                        }
                    } else {
                        j.l("offlineVideo");
                        throw null;
                    }
                } else {
                    j.l("request");
                    throw null;
                }
            } else {
                j.l("playlist");
                throw null;
            }
        } catch (la.u unused2) {
            h0.b1(d1.f7786h, (pa.h) null, 0, new k(downloadService, (e) null), 3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d8, code lost:
        hb.h0.A(r1, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00db, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(com.github.andreyasadchy.xtra.ui.download.DownloadService r15) {
        /*
            java.lang.String r0 = "playlist"
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r1 = r15.f3389r
            r2 = 0
            java.lang.String r3 = "offlineVideo"
            if (r1 == 0) goto L_0x01a9
            boolean r1 = r1.getVod()
            r4 = 3
            r5 = 0
            java.lang.String r6 = "request"
            if (r1 == 0) goto L_0x00f8
            com.github.andreyasadchy.xtra.model.offline.Request r1 = r15.f3388q
            if (r1 == 0) goto L_0x00f4
            java.util.ArrayList r7 = new java.util.ArrayList
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r8 = r15.f3389r
            if (r8 == 0) goto L_0x00f0
            int r8 = r8.getMaxProgress()
            r7.<init>(r8)
            java.lang.Integer r8 = r1.getSegmentFrom()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            xa.j.c(r8)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            int r8 = r8.intValue()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            java.lang.Integer r9 = r1.getSegmentTo()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            xa.j.c(r9)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            int r9 = r9.intValue()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            if (r8 > r9) goto L_0x0090
        L_0x003c:
            com.iheartradio.m3u8.data.MediaPlaylist r10 = r15.f3390s     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            if (r10 == 0) goto L_0x008b
            java.util.List r10 = r10.getTracks()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackData r10 = (com.iheartradio.m3u8.data.TrackData) r10     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackData$Builder r11 = new com.iheartradio.m3u8.data.TrackData$Builder     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            r11.<init>()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            java.lang.String r12 = r1.getPath()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            java.lang.String r13 = r10.getUri()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            r14.<init>()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            r14.append(r12)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            r14.append(r13)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            java.lang.String r12 = r14.toString()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackData$Builder r11 = r11.withUri(r12)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackInfo r12 = new com.iheartradio.m3u8.data.TrackInfo     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackInfo r13 = r10.getTrackInfo()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            float r13 = r13.duration     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackInfo r10 = r10.getTrackInfo()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            java.lang.String r10 = r10.title     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            r12.<init>(r13, r10)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackData$Builder r10 = r11.withTrackInfo(r12)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            com.iheartradio.m3u8.data.TrackData r10 = r10.build()     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            r7.add(r10)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            if (r8 == r9) goto L_0x0090
            int r8 = r8 + 1
            goto L_0x003c
        L_0x008b:
            xa.j.l(r0)     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
            throw r2     // Catch:{ u -> 0x00e4, IndexOutOfBoundsException -> 0x008f }
        L_0x008f:
        L_0x0090:
            com.iheartradio.m3u8.data.MediaPlaylist$Builder r1 = new com.iheartradio.m3u8.data.MediaPlaylist$Builder
            r1.<init>()
            com.iheartradio.m3u8.data.MediaPlaylist r8 = r15.f3390s
            if (r8 == 0) goto L_0x00e0
            int r0 = r8.getTargetDuration()
            com.iheartradio.m3u8.data.MediaPlaylist$Builder r0 = r1.withTargetDuration(r0)
            com.iheartradio.m3u8.data.MediaPlaylist$Builder r0 = r0.withTracks(r7)
            com.iheartradio.m3u8.data.MediaPlaylist r0 = r0.build()
            com.iheartradio.m3u8.data.Playlist$Builder r1 = new com.iheartradio.m3u8.data.Playlist$Builder
            r1.<init>()
            com.iheartradio.m3u8.data.Playlist$Builder r0 = r1.withMediaPlaylist(r0)
            com.iheartradio.m3u8.data.Playlist r0 = r0.build()
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r7 = r15.f3389r
            if (r7 == 0) goto L_0x00dc
            java.lang.String r7 = r7.getUrl()
            r1.<init>(r7)
            com.iheartradio.m3u8.PlaylistWriter r7 = new com.iheartradio.m3u8.PlaylistWriter     // Catch:{ all -> 0x00d5 }
            com.iheartradio.m3u8.Format r8 = com.iheartradio.m3u8.Format.EXT_M3U     // Catch:{ all -> 0x00d5 }
            com.iheartradio.m3u8.Encoding r9 = com.iheartradio.m3u8.Encoding.UTF_8     // Catch:{ all -> 0x00d5 }
            r7.<init>(r1, r8, r9)     // Catch:{ all -> 0x00d5 }
            r7.write(r0)     // Catch:{ all -> 0x00d5 }
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x00d5 }
            hb.h0.A(r1, r2)
            goto L_0x00f8
        L_0x00d5:
            r15 = move-exception
            throw r15     // Catch:{ all -> 0x00d7 }
        L_0x00d7:
            r0 = move-exception
            hb.h0.A(r1, r15)
            throw r0
        L_0x00dc:
            xa.j.l(r3)
            throw r2
        L_0x00e0:
            xa.j.l(r0)
            throw r2
        L_0x00e4:
            hb.d1 r0 = hb.d1.f7786h
            m6.l r1 = new m6.l
            r1.<init>(r15, r2)
            hb.h0.b1(r0, r2, r5, r1, r4)
            goto L_0x018a
        L_0x00f0:
            xa.j.l(r3)
            throw r2
        L_0x00f4:
            xa.j.l(r6)
            throw r2
        L_0x00f8:
            e6.o1 r0 = r15.e()
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r1 = r15.f3389r
            if (r1 == 0) goto L_0x01a5
            r7 = 2
            r1.setStatus(r7)
            r0.b(r1)
            e6.o1 r0 = r15.e()
            com.github.andreyasadchy.xtra.model.offline.Request r1 = r15.f3388q
            if (r1 == 0) goto L_0x01a1
            hb.d1 r6 = hb.d1.f7786h
            e6.f1 r8 = new e6.f1
            r8.<init>(r0, r1, r2)
            hb.h0.b1(r6, r2, r5, r8, r4)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.github.andreyasadchy.xtra.ui.main.MainActivity> r1 = com.github.andreyasadchy.xtra.ui.main.MainActivity.class
            r0.<init>(r15, r1)
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r0.setFlags(r1)
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r4 = r15.f3389r
            if (r4 == 0) goto L_0x019d
            java.lang.String r6 = "video"
            r0.putExtra(r6, r4)
            java.lang.String r4 = "code"
            r6 = 1
            r0.putExtra(r4, r6)
            b0.p r4 = r15.f3386o
            java.lang.String r8 = "notificationBuilder"
            if (r4 == 0) goto L_0x0199
            r9 = 16
            r4.c(r9, r6)
            r9 = 2131951759(0x7f13008f, float:1.9539942E38)
            java.lang.String r9 = r15.getString(r9)
            java.lang.CharSequence r9 = b0.p.b(r9)
            r4.f2389e = r9
            r4.f2396l = r5
            r4.f2397m = r5
            r4.f2398n = r5
            r4.c(r7, r5)
            android.app.Notification r7 = r4.f2404t
            r9 = 17301634(0x1080082, float:2.497962E-38)
            r7.icon = r9
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 31
            if (r7 < r9) goto L_0x0163
            goto L_0x0165
        L_0x0163:
            r1 = 134217728(0x8000000, float:3.85186E-34)
        L_0x0165:
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r15, r6, r0, r1)
            r4.f2391g = r0
            java.util.ArrayList r0 = r4.f2386b
            r0.clear()
            b0.l0 r0 = r15.f3387p
            if (r0 == 0) goto L_0x0193
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r1 = r15.f3389r
            if (r1 == 0) goto L_0x018f
            int r1 = r1.getId()
            b0.p r3 = r15.f3386o
            if (r3 == 0) goto L_0x018b
            android.app.Notification r2 = r3.a()
            r0.a(r1, r2)
            r15.f(r5)
        L_0x018a:
            return
        L_0x018b:
            xa.j.l(r8)
            throw r2
        L_0x018f:
            xa.j.l(r3)
            throw r2
        L_0x0193:
            java.lang.String r15 = "notificationManager"
            xa.j.l(r15)
            throw r2
        L_0x0199:
            xa.j.l(r8)
            throw r2
        L_0x019d:
            xa.j.l(r3)
            throw r2
        L_0x01a1:
            xa.j.l(r6)
            throw r2
        L_0x01a5:
            xa.j.l(r3)
            throw r2
        L_0x01a9:
            xa.j.l(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.download.DownloadService.b(com.github.andreyasadchy.xtra.ui.download.DownloadService):void");
    }

    public final o d(int i10, int i11, String str) {
        int i12;
        String string = getString(i10);
        Intent intent = new Intent(str);
        if (Build.VERSION.SDK_INT >= 31) {
            i12 = 67108864;
        } else {
            i12 = 134217728;
        }
        return new o((IconCompat) null, string, PendingIntent.getBroadcast(this, i11, intent, i12));
    }

    public final o1 e() {
        o1 o1Var = this.f3383l;
        if (o1Var != null) {
            return o1Var;
        }
        j.l("offlineRepository");
        throw null;
    }

    public final void f(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(z10 ? 1 : 2);
        } else {
            stopForeground(z10);
        }
    }

    public final void g(int i10, int i11) {
        l0 l0Var = this.f3387p;
        if (l0Var != null) {
            OfflineVideo offlineVideo = this.f3389r;
            if (offlineVideo != null) {
                int id = offlineVideo.getId();
                p pVar = this.f3386o;
                if (pVar != null) {
                    pVar.f2396l = i10;
                    pVar.f2397m = i11;
                    pVar.f2398n = false;
                    l0Var.a(id, pVar.a());
                    o1 e10 = e();
                    OfflineVideo offlineVideo2 = this.f3389r;
                    if (offlineVideo2 != null) {
                        e10.b(offlineVideo2);
                    } else {
                        j.l("offlineVideo");
                        throw null;
                    }
                } else {
                    j.l("notificationBuilder");
                    throw null;
                }
            } else {
                j.l("offlineVideo");
                throw null;
            }
        } else {
            j.l("notificationManager");
            throw null;
        }
    }

    public final void onCreate() {
        super.onCreate();
        this.f3392u = d(R.string.pause, 1, "com.github.andreyasadchy.xtra.ACTION_DOWNLOAD_PAUSE");
        this.f3393v = d(R.string.resume, 2, "com.github.andreyasadchy.xtra.ACTION_DOWNLOAD_RESUME");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.github.andreyasadchy.xtra.ACTION_DOWNLOAD_PAUSE");
        intentFilter.addAction("com.github.andreyasadchy.xtra.ACTION_DOWNLOAD_RESUME");
        v vVar = v.f9814a;
        registerReceiver(this.f3391t, intentFilter);
    }

    public final void onDestroy() {
        unregisterReceiver(this.f3391t);
        super.onDestroy();
    }

    public final void onHandleIntent(Intent intent) {
        j.c(intent);
        Parcelable parcelableExtra = intent.getParcelableExtra("request");
        j.c(parcelableExtra);
        this.f3388q = (Request) parcelableExtra;
        OfflineVideo offlineVideo = (OfflineVideo) h0.v1(l.f12754h, new m6.m(this, (e) null));
        if (offlineVideo != null) {
            this.f3389r = offlineVideo;
            offlineVideo.getId();
            f fVar = this.f3384m;
            if (fVar != null) {
                OfflineVideo offlineVideo2 = this.f3389r;
                if (offlineVideo2 != null) {
                    this.f3385n = fVar.a(Integer.valueOf(offlineVideo2.getId()));
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    String string = getString(R.string.notification_downloads_channel_id);
                    j.e("getString(R.string.notif…ion_downloads_channel_id)", string);
                    p pVar = new p(this, string);
                    pVar.f2404t.icon = 17301633;
                    pVar.f2399o = "com.github.andreyasadchy.xtra.DOWNLOADS";
                    pVar.f2389e = p.b(getString(R.string.downloading));
                    pVar.c(2, true);
                    OfflineVideo offlineVideo3 = this.f3389r;
                    if (offlineVideo3 != null) {
                        pVar.f2390f = p.b(offlineVideo3.getName());
                        Intent intent2 = new Intent(this, MainActivity.class);
                        int i10 = 67108864;
                        intent2.setFlags(67108864);
                        intent2.putExtra("code", 0);
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 < 31) {
                            i10 = 134217728;
                        }
                        pVar.f2391g = PendingIntent.getActivity(this, 0, intent2, i10);
                        o oVar = this.f3392u;
                        if (oVar != null) {
                            pVar.f2386b.add(oVar);
                            this.f3386o = pVar;
                            this.f3387p = new l0(this);
                            if (i11 >= 26) {
                                Object systemService = getSystemService("notification");
                                j.d("null cannot be cast to non-null type android.app.NotificationManager", systemService);
                                NotificationManager notificationManager = (NotificationManager) systemService;
                                if (notificationManager.getNotificationChannel(string) == null) {
                                    g.r();
                                    NotificationChannel b10 = b.b(string, getString(R.string.notification_downloads_channel_title));
                                    b10.setSound((Uri) null, (AudioAttributes) null);
                                    notificationManager.createNotificationChannel(b10);
                                }
                            }
                            OfflineVideo offlineVideo4 = this.f3389r;
                            if (offlineVideo4 != null) {
                                int maxProgress = offlineVideo4.getMaxProgress();
                                OfflineVideo offlineVideo5 = this.f3389r;
                                if (offlineVideo5 != null) {
                                    g(maxProgress, offlineVideo5.getProgress());
                                    OfflineVideo offlineVideo6 = this.f3389r;
                                    if (offlineVideo6 != null) {
                                        if (offlineVideo6.getVod()) {
                                            h hVar = this.f3385n;
                                            if (hVar != null) {
                                                ((m) hVar).a(new n(this, countDownLatch));
                                                h0.b1(d1.f7786h, (pa.h) null, 0, new m6.o(this, (e) null), 3);
                                            } else {
                                                j.l("fetch");
                                                throw null;
                                            }
                                        } else {
                                            h hVar2 = this.f3385n;
                                            if (hVar2 != null) {
                                                ((m) hVar2).a(new m6.p(this, countDownLatch));
                                                h hVar3 = this.f3385n;
                                                if (hVar3 != null) {
                                                    Request request = this.f3388q;
                                                    if (request != null) {
                                                        String url = request.getUrl();
                                                        Request request2 = this.f3388q;
                                                        if (request2 != null) {
                                                            u uVar = new u(url, request2.getPath());
                                                            Request request3 = this.f3388q;
                                                            if (request3 != null) {
                                                                uVar.f12723i = request3.getOfflineVideoId();
                                                                m mVar = (m) hVar3;
                                                                mVar.b(q.b(uVar), new t9.i(mVar, (t9.i) null, (t9.i) null), (t9.i) null);
                                                            } else {
                                                                j.l("request");
                                                                throw null;
                                                            }
                                                        } else {
                                                            j.l("request");
                                                            throw null;
                                                        }
                                                    } else {
                                                        j.l("request");
                                                        throw null;
                                                    }
                                                } else {
                                                    j.l("fetch");
                                                    throw null;
                                                }
                                            } else {
                                                j.l("fetch");
                                                throw null;
                                            }
                                        }
                                        o1 e10 = e();
                                        OfflineVideo offlineVideo7 = this.f3389r;
                                        if (offlineVideo7 != null) {
                                            offlineVideo7.setStatus(1);
                                            e10.b(offlineVideo7);
                                            OfflineVideo offlineVideo8 = this.f3389r;
                                            if (offlineVideo8 != null) {
                                                int id = offlineVideo8.getId();
                                                p pVar2 = this.f3386o;
                                                if (pVar2 != null) {
                                                    startForeground(id, pVar2.a());
                                                    countDownLatch.await();
                                                    HashSet hashSet = f3381x;
                                                    Request request4 = this.f3388q;
                                                    if (request4 != null) {
                                                        hashSet.remove(Integer.valueOf(request4.getOfflineVideoId()));
                                                        h hVar4 = this.f3385n;
                                                        if (hVar4 != null) {
                                                            m mVar2 = (m) hVar4;
                                                            synchronized (mVar2.f14875b) {
                                                                if (!mVar2.f14876c) {
                                                                    mVar2.f14876c = true;
                                                                    y9.l lVar = mVar2.f14884k;
                                                                    lVar.a(mVar2.f14879f + " closing/shutting down");
                                                                    mVar2.f14881h.e(mVar2.f14878e);
                                                                    mVar2.f14881h.d(new t9.b(mVar2, 2));
                                                                    v vVar = v.f9814a;
                                                                }
                                                            }
                                                            return;
                                                        }
                                                        j.l("fetch");
                                                        throw null;
                                                    }
                                                    j.l("request");
                                                    throw null;
                                                }
                                                j.l("notificationBuilder");
                                                throw null;
                                            }
                                            j.l("offlineVideo");
                                            throw null;
                                        }
                                        j.l("offlineVideo");
                                        throw null;
                                    }
                                    j.l("offlineVideo");
                                    throw null;
                                }
                                j.l("offlineVideo");
                                throw null;
                            }
                            j.l("offlineVideo");
                            throw null;
                        }
                        j.l("pauseAction");
                        throw null;
                    }
                    j.l("offlineVideo");
                    throw null;
                }
                j.l("offlineVideo");
                throw null;
            }
            j.l("fetchProvider");
            throw null;
        }
    }
}

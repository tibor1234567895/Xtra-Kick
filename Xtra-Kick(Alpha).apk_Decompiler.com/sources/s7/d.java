package s7;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import com.bumptech.glide.c;
import com.github.andreyasadchy.xtra.model.offline.Downloadable;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import fb.w;
import java.io.File;
import java.io.FileOutputStream;
import xa.f;
import xa.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f14369a = new d();

    private d() {
    }

    public static void a(Context context, Request request) {
        j.f("context", context);
        Intent putExtra = new Intent(context, DownloadService.class).putExtra("request", request);
        j.e("Intent(context, Download…tra(KEY_REQUEST, request)", putExtra);
        context.startService(putExtra);
        DownloadService.f3380w.getClass();
        DownloadService.f3381x.add(Integer.valueOf(request.getOfflineVideoId()));
    }

    public static OfflineVideo b(Application application, Downloadable downloadable, String str, String str2, Long l10, Long l11, Integer num, Integer num2) {
        String str3;
        boolean z10;
        String str4;
        Long l12;
        int i10;
        Application application2 = application;
        Downloadable downloadable2 = downloadable;
        String str5 = str2;
        j.f("downloadable", downloadable2);
        j.f("url", str);
        j.f("path", str5);
        if (downloadable2 instanceof Video) {
            str3 = str5 + System.currentTimeMillis() + ".m3u8";
        } else {
            str3 = str5.concat(".mp4");
        }
        String str6 = str3;
        String uuid = downloadable.getUuid();
        if (uuid == null || w.h(uuid)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            try {
                c.b(application).b(application2).m().F(downloadable.getThumbnail()).D(new c(0, application2, (Parcelable) downloadable2));
            } catch (Exception unused) {
            }
        }
        if (downloadable.getChannelId() != 0) {
            try {
                c.b(application).b(application2).m().F(downloadable.getChannelLogo()).D(new c(1, application2, (Parcelable) downloadable2));
            } catch (Exception unused2) {
            }
        }
        String uuid2 = downloadable.getUuid();
        if (uuid2 != null) {
            String file = application.getFilesDir().toString();
            String str7 = File.separator;
            str4 = new File(file + str7 + "thumbnails" + str7 + uuid2 + ".png").getAbsolutePath();
        } else {
            str4 = null;
        }
        int channelId = downloadable.getChannelId();
        String file2 = application.getFilesDir().toString();
        String str8 = File.separator;
        String absolutePath = new File(file2 + str8 + "profile_pics" + str8 + channelId + ".png").getAbsolutePath();
        String title = downloadable.getTitle();
        int channelId2 = downloadable.getChannelId();
        String channelSlug = downloadable.getChannelSlug();
        String channelName = downloadable.getChannelName();
        int gameId = downloadable.getGameId();
        String gameName = downloadable.getGameName();
        String uploadDate = downloadable.getUploadDate();
        if (uploadDate != null) {
            h.f14375a.getClass();
            l12 = h.l(uploadDate);
        } else {
            l12 = null;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (num2 == null || num == null) {
            i10 = 100;
        } else {
            i10 = (num2.intValue() - num.intValue()) + 1;
        }
        return new OfflineVideo(str6, str, l11, title, channelId2, channelSlug, channelName, absolutePath, str4, gameId, gameName, (String) null, (String) null, l10, l12, valueOf, (Long) null, 0, i10, 0, downloadable.getType(), downloadable.getUuid(), 595968, (f) null);
    }

    public static void c(Context context, String str, String str2, Bitmap bitmap) {
        j.f("context", context);
        j.f("fileName", str2);
        j.f("bitmap", bitmap);
        try {
            String file = context.getFilesDir().toString();
            String str3 = File.separator;
            new File(context.getFilesDir(), str).mkdir();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file + str3 + str + str3 + str2 + ".png"));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}

package x6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.github.andreyasadchy.xtra.model.ui.Video;
import s7.d;
import t5.c;
import u5.g;

public final class m extends c {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f16704k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f16705l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Video f16706m;

    public /* synthetic */ m(Context context, Video video, int i10) {
        this.f16704k = i10;
        this.f16705l = context;
        this.f16706m = video;
    }

    public final /* bridge */ /* synthetic */ void f(Object obj, g gVar) {
        switch (this.f16704k) {
            case 0:
                l((Bitmap) obj);
                return;
            case 1:
                l((Bitmap) obj);
                return;
            case 2:
                l((Bitmap) obj);
                return;
            case 3:
                l((Bitmap) obj);
                return;
            case 4:
                l((Bitmap) obj);
                return;
            default:
                l((Bitmap) obj);
                return;
        }
    }

    public final void i(Drawable drawable) {
    }

    public final void l(Bitmap bitmap) {
        int i10 = this.f16704k;
        Context context = this.f16705l;
        Video video = this.f16706m;
        switch (i10) {
            case 0:
                d dVar = d.f14369a;
                String uuid = video.getUuid();
                dVar.getClass();
                d.c(context, "thumbnails", uuid, bitmap);
                return;
            case 1:
                d dVar2 = d.f14369a;
                String valueOf = String.valueOf(video.getChannelId());
                dVar2.getClass();
                d.c(context, "profile_pics", valueOf, bitmap);
                return;
            case 2:
                d dVar3 = d.f14369a;
                String uuid2 = video.getUuid();
                dVar3.getClass();
                d.c(context, "thumbnails", uuid2, bitmap);
                return;
            case 3:
                d dVar4 = d.f14369a;
                String uuid3 = video.getUuid();
                dVar4.getClass();
                d.c(context, "thumbnails", uuid3, bitmap);
                return;
            case 4:
                d dVar5 = d.f14369a;
                String uuid4 = video.getUuid();
                dVar5.getClass();
                d.c(context, "thumbnails", uuid4, bitmap);
                return;
            default:
                d dVar6 = d.f14369a;
                String valueOf2 = String.valueOf(video.getChannelId());
                dVar6.getClass();
                d.c(context, "profile_pics", valueOf2, bitmap);
                return;
        }
    }
}

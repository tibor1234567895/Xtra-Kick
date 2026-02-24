package s7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import com.github.andreyasadchy.xtra.model.offline.Downloadable;
import com.github.andreyasadchy.xtra.model.ui.User;
import u5.g;
import xa.j;

public final class c extends t5.c {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f14366k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f14367l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f14368m;

    public /* synthetic */ c(int i10, Context context, Parcelable parcelable) {
        this.f14366k = i10;
        this.f14367l = context;
        this.f14368m = parcelable;
    }

    public final /* bridge */ /* synthetic */ void f(Object obj, g gVar) {
        switch (this.f14366k) {
            case 0:
                l((Bitmap) obj);
                return;
            case 1:
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
        int i10 = this.f14366k;
        Context context = this.f14367l;
        Object obj = this.f14368m;
        switch (i10) {
            case 0:
                d dVar = d.f14369a;
                String uuid = ((Downloadable) obj).getUuid();
                j.c(uuid);
                dVar.getClass();
                d.c(context, "thumbnails", uuid, bitmap);
                return;
            case 1:
                d dVar2 = d.f14369a;
                String valueOf = String.valueOf(((Downloadable) obj).getChannelId());
                dVar2.getClass();
                d.c(context, "profile_pics", valueOf, bitmap);
                return;
            default:
                d dVar3 = d.f14369a;
                String valueOf2 = String.valueOf(((User) obj).getChannelId());
                dVar3.getClass();
                d.c(context, "profile_pics", valueOf2, bitmap);
                return;
        }
    }
}

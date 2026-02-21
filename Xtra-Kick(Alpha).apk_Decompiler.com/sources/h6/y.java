package h6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import s7.d;
import t5.c;
import u5.g;

public final class y extends c {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7698k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f7699l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7700m;

    public /* synthetic */ y(Context context, int i10, int i11) {
        this.f7698k = i11;
        this.f7699l = context;
        this.f7700m = i10;
    }

    public final /* bridge */ /* synthetic */ void f(Object obj, g gVar) {
        switch (this.f7698k) {
            case 0:
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
        int i10 = this.f7698k;
        Context context = this.f7699l;
        int i11 = this.f7700m;
        switch (i10) {
            case 0:
                d dVar = d.f14369a;
                String valueOf = String.valueOf(i11);
                dVar.getClass();
                d.c(context, "profile_pics", valueOf, bitmap);
                return;
            default:
                d dVar2 = d.f14369a;
                String valueOf2 = String.valueOf(i11);
                dVar2.getClass();
                d.c(context, "profile_pics", valueOf2, bitmap);
                return;
        }
    }
}

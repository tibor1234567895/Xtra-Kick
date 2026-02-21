package o5;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import t5.c;
import u5.g;

public final class h extends c {

    /* renamed from: k  reason: collision with root package name */
    public final Handler f12212k;

    /* renamed from: l  reason: collision with root package name */
    public final int f12213l;

    /* renamed from: m  reason: collision with root package name */
    public final long f12214m;

    /* renamed from: n  reason: collision with root package name */
    public Bitmap f12215n;

    public h(Handler handler, int i10, long j10) {
        this.f12212k = handler;
        this.f12213l = i10;
        this.f12214m = j10;
    }

    public final void f(Object obj, g gVar) {
        this.f12215n = (Bitmap) obj;
        Handler handler = this.f12212k;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f12214m);
    }

    public final void i(Drawable drawable) {
        this.f12215n = null;
    }
}

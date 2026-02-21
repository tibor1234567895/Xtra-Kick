package a5;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import t5.c;
import u5.g;

public final class s extends c {

    /* renamed from: k  reason: collision with root package name */
    public final Handler f190k;

    /* renamed from: l  reason: collision with root package name */
    public final int f191l;

    /* renamed from: m  reason: collision with root package name */
    public final long f192m;

    /* renamed from: n  reason: collision with root package name */
    public Bitmap f193n;

    public s(Handler handler, int i10, long j10) {
        this.f190k = handler;
        this.f191l = i10;
        this.f192m = j10;
    }

    public final void f(Object obj, g gVar) {
        this.f193n = (Bitmap) obj;
        Handler handler = this.f190k;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f192m);
    }

    public final void i(Drawable drawable) {
        this.f193n = null;
    }
}

package t5;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import s5.d;
import s5.h;
import w5.p;

public abstract class c implements g {

    /* renamed from: h  reason: collision with root package name */
    public final int f14556h;

    /* renamed from: i  reason: collision with root package name */
    public final int f14557i;

    /* renamed from: j  reason: collision with root package name */
    public d f14558j;

    public c() {
        if (p.h(RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION)) {
            this.f14556h = RecyclerView.UNDEFINED_DURATION;
            this.f14557i = RecyclerView.UNDEFINED_DURATION;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
    }

    public final void a(d dVar) {
        this.f14558j = dVar;
    }

    public final void b(Drawable drawable) {
    }

    public final void c() {
    }

    public final void d(f fVar) {
        ((h) fVar).n(this.f14556h, this.f14557i);
    }

    public final void e(f fVar) {
    }

    public final void g(Drawable drawable) {
    }

    public final d h() {
        return this.f14558j;
    }

    public final void j() {
    }

    public final void k() {
    }
}

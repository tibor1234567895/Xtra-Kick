package t5;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.woxthebox.draglistview.R;
import u5.f;
import u5.g;

public abstract class d extends a implements f {

    /* renamed from: i  reason: collision with root package name */
    public final View f14559i;

    /* renamed from: j  reason: collision with root package name */
    public final h f14560j;

    /* renamed from: k  reason: collision with root package name */
    public Animatable f14561k;

    public d(ImageView imageView) {
        this.f14559i = imageView;
        this.f14560j = new h(imageView);
    }

    public final void a(s5.d dVar) {
        this.f14559i.setTag(R.id.glide_custom_view_target_tag, dVar);
    }

    public final void b(Drawable drawable) {
        l((Object) null);
        ((ImageView) this.f14559i).setImageDrawable(drawable);
    }

    public final void c() {
        Animatable animatable = this.f14561k;
        if (animatable != null) {
            animatable.stop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r5 != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(t5.f r8) {
        /*
            r7 = this;
            t5.h r0 = r7.f14560j
            int r1 = r0.c()
            int r2 = r0.b()
            r3 = 1
            r4 = 0
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 > 0) goto L_0x0015
            if (r1 != r5) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r6 = 0
            goto L_0x0016
        L_0x0015:
            r6 = 1
        L_0x0016:
            if (r6 == 0) goto L_0x0023
            if (r2 > 0) goto L_0x001f
            if (r2 != r5) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = 1
        L_0x0020:
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            if (r3 == 0) goto L_0x002c
            s5.h r8 = (s5.h) r8
            r8.n(r1, r2)
            goto L_0x004b
        L_0x002c:
            java.util.ArrayList r1 = r0.f14564b
            boolean r2 = r1.contains(r8)
            if (r2 != 0) goto L_0x0037
            r1.add(r8)
        L_0x0037:
            z.f r8 = r0.f14565c
            if (r8 != 0) goto L_0x004b
            android.view.View r8 = r0.f14563a
            android.view.ViewTreeObserver r8 = r8.getViewTreeObserver()
            z.f r1 = new z.f
            r1.<init>(r0)
            r0.f14565c = r1
            r8.addOnPreDrawListener(r1)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.d.d(t5.f):void");
    }

    public final void e(f fVar) {
        this.f14560j.f14564b.remove(fVar);
    }

    public final void f(Object obj, g gVar) {
        if (gVar == null || !gVar.a(obj, this)) {
            l(obj);
        } else if (obj instanceof Animatable) {
            Animatable animatable = (Animatable) obj;
            this.f14561k = animatable;
            animatable.start();
        } else {
            this.f14561k = null;
        }
    }

    public final void g(Drawable drawable) {
        l((Object) null);
        ((ImageView) this.f14559i).setImageDrawable(drawable);
    }

    public final s5.d h() {
        Object tag = this.f14559i.getTag(R.id.glide_custom_view_target_tag);
        if (tag == null) {
            return null;
        }
        if (tag instanceof s5.d) {
            return (s5.d) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public final void i(Drawable drawable) {
        h hVar = this.f14560j;
        ViewTreeObserver viewTreeObserver = hVar.f14563a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(hVar.f14565c);
        }
        hVar.f14565c = null;
        hVar.f14564b.clear();
        Animatable animatable = this.f14561k;
        if (animatable != null) {
            animatable.stop();
        }
        l((Object) null);
        ((ImageView) this.f14559i).setImageDrawable(drawable);
    }

    public final void j() {
        Animatable animatable = this.f14561k;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void l(Object obj) {
        b bVar = (b) this;
        int i10 = bVar.f14555l;
        View view = bVar.f14559i;
        switch (i10) {
            case 0:
                ((ImageView) view).setImageBitmap((Bitmap) obj);
                break;
            default:
                ((ImageView) view).setImageDrawable((Drawable) obj);
                break;
        }
        if (obj instanceof Animatable) {
            Animatable animatable = (Animatable) obj;
            this.f14561k = animatable;
            animatable.start();
            return;
        }
        this.f14561k = null;
    }

    /* renamed from: m */
    public final String toString() {
        return "Target for: " + this.f14559i;
    }
}

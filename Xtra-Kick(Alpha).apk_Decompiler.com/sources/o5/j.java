package o5;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import b5.r;
import com.bumptech.glide.h;
import com.bumptech.glide.q;
import com.bumptech.glide.s;
import d5.u;
import e5.c;
import java.util.ArrayList;
import s5.f;
import v5.b;
import w5.n;
import w5.p;
import y4.a;
import y4.e;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final a f12216a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f12217b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f12218c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final s f12219d;

    /* renamed from: e  reason: collision with root package name */
    public final c f12220e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12221f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12222g;

    /* renamed from: h  reason: collision with root package name */
    public q f12223h;

    /* renamed from: i  reason: collision with root package name */
    public h f12224i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12225j;

    /* renamed from: k  reason: collision with root package name */
    public h f12226k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f12227l;

    /* renamed from: m  reason: collision with root package name */
    public h f12228m;

    /* renamed from: n  reason: collision with root package name */
    public int f12229n;

    /* renamed from: o  reason: collision with root package name */
    public int f12230o;

    /* renamed from: p  reason: collision with root package name */
    public int f12231p;

    public j(com.bumptech.glide.c cVar, e eVar, int i10, int i11, j5.c cVar2, Bitmap bitmap) {
        c cVar3 = cVar.f3164h;
        h hVar = cVar.f3166j;
        s e10 = com.bumptech.glide.c.e(hVar.getBaseContext());
        q z10 = com.bumptech.glide.c.e(hVar.getBaseContext()).m().a(((f) ((f) ((f) new f().f(u.f4491a)).x()).s(true)).n(i10, i11));
        this.f12219d = e10;
        Handler handler = new Handler(Looper.getMainLooper(), new a5.u(1, this));
        this.f12220e = cVar3;
        this.f12217b = handler;
        this.f12223h = z10;
        this.f12216a = eVar;
        c(cVar2, bitmap);
    }

    public final void a() {
        if (this.f12221f && !this.f12222g) {
            h hVar = this.f12228m;
            if (hVar != null) {
                this.f12228m = null;
                b(hVar);
                return;
            }
            this.f12222g = true;
            a aVar = this.f12216a;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) aVar.e());
            aVar.c();
            this.f12226k = new h(this.f12217b, aVar.a(), uptimeMillis);
            this.f12223h.a((f) new f().r(new b(Double.valueOf(Math.random())))).G(aVar).D(this.f12226k);
        }
    }

    public final void b(h hVar) {
        int i10;
        this.f12222g = false;
        boolean z10 = this.f12225j;
        Handler handler = this.f12217b;
        if (z10) {
            handler.obtainMessage(2, hVar).sendToTarget();
        } else if (!this.f12221f) {
            this.f12228m = hVar;
        } else {
            if (hVar.f12215n != null) {
                Bitmap bitmap = this.f12227l;
                if (bitmap != null) {
                    this.f12220e.c(bitmap);
                    this.f12227l = null;
                }
                h hVar2 = this.f12224i;
                this.f12224i = hVar;
                ArrayList arrayList = this.f12218c;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    e eVar = (e) ((i) arrayList.get(size));
                    Drawable.Callback callback = eVar.getCallback();
                    while (callback instanceof Drawable) {
                        callback = ((Drawable) callback).getCallback();
                    }
                    if (callback == null) {
                        eVar.stop();
                        eVar.invalidateSelf();
                    } else {
                        eVar.invalidateSelf();
                        j jVar = eVar.f12201h.f12200a;
                        h hVar3 = jVar.f12224i;
                        if (hVar3 != null) {
                            i10 = hVar3.f12213l;
                        } else {
                            i10 = -1;
                        }
                        if (i10 == jVar.f12216a.d() - 1) {
                            eVar.f12206m++;
                        }
                        int i11 = eVar.f12207n;
                        if (i11 != -1 && eVar.f12206m >= i11) {
                            eVar.stop();
                        }
                    }
                }
                if (hVar2 != null) {
                    handler.obtainMessage(2, hVar2).sendToTarget();
                }
            }
            a();
        }
    }

    public final void c(r rVar, Bitmap bitmap) {
        n.b(rVar);
        n.b(bitmap);
        this.f12227l = bitmap;
        this.f12223h = this.f12223h.a(new f().t(rVar, true));
        this.f12229n = p.c(bitmap);
        this.f12230o = bitmap.getWidth();
        this.f12231p = bitmap.getHeight();
    }
}

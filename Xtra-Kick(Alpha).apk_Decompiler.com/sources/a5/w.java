package a5;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import b5.m;
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

public final class w {

    /* renamed from: q  reason: collision with root package name */
    public static final m f198q = m.a("com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.CacheStrategy", r.f188c);

    /* renamed from: a  reason: collision with root package name */
    public final j f199a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f200b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f201c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final s f202d;

    /* renamed from: e  reason: collision with root package name */
    public final c f203e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f204f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f205g = false;

    /* renamed from: h  reason: collision with root package name */
    public q f206h;

    /* renamed from: i  reason: collision with root package name */
    public s f207i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f208j;

    /* renamed from: k  reason: collision with root package name */
    public s f209k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f210l;

    /* renamed from: m  reason: collision with root package name */
    public s f211m;

    /* renamed from: n  reason: collision with root package name */
    public int f212n;

    /* renamed from: o  reason: collision with root package name */
    public int f213o;

    /* renamed from: p  reason: collision with root package name */
    public int f214p;

    public w(com.bumptech.glide.c cVar, j jVar, int i10, int i11, j5.c cVar2, Bitmap bitmap) {
        c cVar3 = cVar.f3164h;
        h hVar = cVar.f3166j;
        s e10 = com.bumptech.glide.c.e(hVar.getBaseContext());
        q z10 = com.bumptech.glide.c.e(hVar.getBaseContext()).m().a(((f) ((f) ((f) new f().f(u.f4491a)).x()).s(true)).n(i10, i11));
        this.f202d = e10;
        Handler handler = new Handler(Looper.getMainLooper(), new u(0, this));
        this.f203e = cVar3;
        this.f200b = handler;
        this.f206h = z10;
        this.f199a = jVar;
        n.b(cVar2);
        this.f210l = bitmap;
        this.f206h = this.f206h.a(new f().t(cVar2, true));
        this.f212n = p.c(bitmap);
        this.f213o = bitmap.getWidth();
        this.f214p = bitmap.getHeight();
    }

    public final void a() {
        if (this.f204f && !this.f205g) {
            s sVar = this.f211m;
            if (sVar != null) {
                this.f211m = null;
                b(sVar);
                return;
            }
            boolean z10 = true;
            this.f205g = true;
            j jVar = this.f199a;
            int e10 = jVar.e();
            jVar.c();
            int i10 = jVar.f157d;
            this.f209k = new s(this.f200b, i10, SystemClock.uptimeMillis() + ((long) e10));
            f fVar = (f) new f().r(new v(new b(jVar), i10));
            if (jVar.f164k.f189a != 1) {
                z10 = false;
            }
            this.f206h.a((f) fVar.s(z10)).G(jVar).D(this.f209k);
        }
    }

    public final void b(s sVar) {
        this.f205g = false;
        boolean z10 = this.f208j;
        Handler handler = this.f200b;
        if (z10) {
            handler.obtainMessage(2, sVar).sendToTarget();
        } else if (!this.f204f) {
            this.f211m = sVar;
        } else {
            if (sVar.f193n != null) {
                Bitmap bitmap = this.f210l;
                if (bitmap != null) {
                    this.f203e.c(bitmap);
                    this.f210l = null;
                }
                s sVar2 = this.f207i;
                this.f207i = sVar;
                ArrayList arrayList = this.f201c;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    try {
                        t tVar = (t) arrayList.get(size);
                        if (tVar != null) {
                            ((n) tVar).a();
                        }
                    } catch (IndexOutOfBoundsException e10) {
                        e10.printStackTrace();
                    }
                }
                if (sVar2 != null) {
                    handler.obtainMessage(2, sVar2).sendToTarget();
                }
            }
            a();
        }
    }
}

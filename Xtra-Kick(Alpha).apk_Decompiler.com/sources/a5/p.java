package a5;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.s;
import m5.c;
import o5.e;
import o5.h;
import o5.j;

public final class p extends c {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f185i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Drawable drawable, int i10) {
        super(drawable);
        this.f185i = i10;
    }

    public final void a() {
        Bitmap bitmap;
        int i10 = this.f185i;
        Drawable drawable = this.f10606h;
        switch (i10) {
            case 0:
                ((n) drawable).f175h.f174a.f210l.prepareToDraw();
                return;
            case 2:
                ((e) drawable).f12201h.f12200a.f12227l.prepareToDraw();
                return;
            default:
                if (drawable instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) drawable).getBitmap();
                } else if (drawable instanceof e) {
                    bitmap = ((e) drawable).f12201h.f12200a.f12227l;
                } else {
                    return;
                }
                bitmap.prepareToDraw();
                return;
        }
    }

    public final int b() {
        int f10;
        int i10;
        int i11 = this.f185i;
        Drawable drawable = this.f10606h;
        switch (i11) {
            case 0:
                w wVar = ((n) drawable).f175h.f174a;
                f10 = wVar.f199a.f();
                i10 = wVar.f212n;
                break;
            case 1:
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                j jVar = ((e) drawable).f12201h.f12200a;
                f10 = jVar.f12216a.f();
                i10 = jVar.f12229n;
                break;
        }
        return f10 + i10;
    }

    public final Class d() {
        switch (this.f185i) {
            case 0:
                return n.class;
            case 1:
                return this.f10606h.getClass();
            default:
                return e.class;
        }
    }

    public final void e() {
        int i10 = this.f185i;
        Drawable drawable = this.f10606h;
        switch (i10) {
            case 0:
                n nVar = (n) drawable;
                nVar.stop();
                nVar.f178k = true;
                w wVar = nVar.f175h.f174a;
                wVar.f201c.clear();
                Bitmap bitmap = wVar.f210l;
                if (bitmap != null) {
                    wVar.f203e.c(bitmap);
                    wVar.f210l = null;
                }
                wVar.f204f = false;
                s sVar = wVar.f207i;
                s sVar2 = wVar.f202d;
                if (sVar != null) {
                    sVar2.o(sVar);
                    wVar.f207i = null;
                }
                s sVar3 = wVar.f209k;
                if (sVar3 != null) {
                    sVar2.o(sVar3);
                    wVar.f209k = null;
                }
                s sVar4 = wVar.f211m;
                if (sVar4 != null) {
                    sVar2.o(sVar4);
                    wVar.f211m = null;
                }
                wVar.f199a.clear();
                wVar.f208j = true;
                return;
            case 1:
                return;
            default:
                e eVar = (e) drawable;
                eVar.stop();
                eVar.f12204k = true;
                j jVar = eVar.f12201h.f12200a;
                jVar.f12218c.clear();
                Bitmap bitmap2 = jVar.f12227l;
                if (bitmap2 != null) {
                    jVar.f12220e.c(bitmap2);
                    jVar.f12227l = null;
                }
                jVar.f12221f = false;
                h hVar = jVar.f12224i;
                s sVar5 = jVar.f12219d;
                if (hVar != null) {
                    sVar5.o(hVar);
                    jVar.f12224i = null;
                }
                h hVar2 = jVar.f12226k;
                if (hVar2 != null) {
                    sVar5.o(hVar2);
                    jVar.f12226k = null;
                }
                h hVar3 = jVar.f12228m;
                if (hVar3 != null) {
                    sVar5.o(hVar3);
                    jVar.f12228m = null;
                }
                jVar.f12216a.clear();
                jVar.f12225j = true;
                return;
        }
    }
}

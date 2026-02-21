package q4;

import android.graphics.Bitmap;
import hb.h0;
import java.util.Map;

public final class k implements o {

    /* renamed from: a  reason: collision with root package name */
    public final p f13337a;

    /* renamed from: b  reason: collision with root package name */
    public final j f13338b;

    public k(int i10, p pVar) {
        this.f13337a = pVar;
        this.f13338b = new j(i10, this);
    }

    public final void a(int i10) {
        boolean z10;
        int i11;
        if (i10 >= 40) {
            this.f13338b.g(-1);
            return;
        }
        if (10 > i10 || i10 >= 20) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            j jVar = this.f13338b;
            synchronized (jVar) {
                i11 = jVar.f13071b;
            }
            jVar.g(i11 / 2);
        }
    }

    public final e b(d dVar) {
        i iVar = (i) this.f13338b.b(dVar);
        if (iVar != null) {
            return new e(iVar.f13333a, iVar.f13334b);
        }
        return null;
    }

    public final void c(d dVar, Bitmap bitmap, Map map) {
        int i10;
        int a02 = h0.a0(bitmap);
        j jVar = this.f13338b;
        synchronized (jVar) {
            i10 = jVar.f13072c;
        }
        j jVar2 = this.f13338b;
        if (a02 <= i10) {
            jVar2.c(dVar, new i(bitmap, map, a02));
            return;
        }
        jVar2.d(dVar);
        this.f13337a.c(dVar, bitmap, map, a02);
    }
}

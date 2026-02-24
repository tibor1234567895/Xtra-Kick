package h3;

import android.graphics.Bitmap;
import b0.p;
import h9.v;
import n1.h;

public final class k implements v {

    /* renamed from: h  reason: collision with root package name */
    public final p f7146h;

    /* renamed from: i  reason: collision with root package name */
    public final h f7147i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7148j;

    public k(p pVar, h hVar) {
        this.f7146h = pVar;
        this.f7147i = hVar;
    }

    public final void c(Throwable th) {
        if (!this.f7148j) {
            j1.v.g("NotificationProvider", "Failed to load bitmap: " + th.getMessage());
        }
    }

    public final void d(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (!this.f7148j) {
            p pVar = this.f7146h;
            pVar.d(bitmap);
            r1 r1Var = new r1(1001, pVar.a());
            h hVar = this.f7147i;
            y1 y1Var = (y1) hVar.f10970i;
            y1Var.f7483e.execute(new t1(y1Var, hVar.f10969h, (g2) hVar.f10971j, r1Var, 0));
        }
    }
}

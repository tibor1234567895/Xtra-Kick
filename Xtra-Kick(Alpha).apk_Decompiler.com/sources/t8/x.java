package t8;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public float f14821a;

    /* renamed from: b  reason: collision with root package name */
    public float f14822b;

    /* renamed from: c  reason: collision with root package name */
    public float f14823c;

    /* renamed from: d  reason: collision with root package name */
    public float f14824d;

    /* renamed from: e  reason: collision with root package name */
    public float f14825e;

    /* renamed from: f  reason: collision with root package name */
    public float f14826f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f14827g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f14828h = new ArrayList();

    public x() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f10) {
        float f11 = this.f14825e;
        if (f11 != f10) {
            float f12 = ((f10 - f11) + 360.0f) % 360.0f;
            if (f12 <= 180.0f) {
                float f13 = this.f14823c;
                float f14 = this.f14824d;
                t tVar = new t(f13, f14, f13, f14);
                tVar.f14814f = this.f14825e;
                tVar.f14815g = f12;
                this.f14828h.add(new r(tVar));
                this.f14825e = f10;
            }
        }
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f14827g;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((v) arrayList.get(i10)).a(matrix, path);
        }
    }

    public final void c(float f10, float f11) {
        u uVar = new u();
        uVar.f14816b = f10;
        uVar.f14817c = f11;
        this.f14827g.add(uVar);
        s sVar = new s(uVar, this.f14823c, this.f14824d);
        a(sVar.b() + 270.0f);
        this.f14828h.add(sVar);
        this.f14825e = sVar.b() + 270.0f;
        this.f14823c = f10;
        this.f14824d = f11;
    }

    public final void d(float f10, float f11, float f12) {
        this.f14821a = 0.0f;
        this.f14822b = f10;
        this.f14823c = 0.0f;
        this.f14824d = f10;
        this.f14825e = f11;
        this.f14826f = (f11 + f12) % 360.0f;
        this.f14827g.clear();
        this.f14828h.clear();
    }
}

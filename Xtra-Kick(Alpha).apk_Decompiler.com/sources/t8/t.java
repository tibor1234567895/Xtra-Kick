package t8;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

public final class t extends v {

    /* renamed from: h  reason: collision with root package name */
    public static final RectF f14809h = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public float f14810b;

    /* renamed from: c  reason: collision with root package name */
    public float f14811c;

    /* renamed from: d  reason: collision with root package name */
    public float f14812d;

    /* renamed from: e  reason: collision with root package name */
    public float f14813e;

    /* renamed from: f  reason: collision with root package name */
    public float f14814f;

    /* renamed from: g  reason: collision with root package name */
    public float f14815g;

    public t(float f10, float f11, float f12, float f13) {
        this.f14810b = f10;
        this.f14811c = f11;
        this.f14812d = f12;
        this.f14813e = f13;
    }

    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f14818a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f14809h;
        rectF.set(this.f14810b, this.f14811c, this.f14812d, this.f14813e);
        path.arcTo(rectF, this.f14814f, this.f14815g, false);
        path.transform(matrix);
    }
}

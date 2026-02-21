package t8;

import android.graphics.Matrix;
import android.graphics.Path;

public final class u extends v {

    /* renamed from: b  reason: collision with root package name */
    public float f14816b;

    /* renamed from: c  reason: collision with root package name */
    public float f14817c;

    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f14818a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f14816b, this.f14817c);
        path.transform(matrix);
    }
}

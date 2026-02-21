package t8;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import s8.a;

public final class s extends w {

    /* renamed from: c  reason: collision with root package name */
    public final u f14806c;

    /* renamed from: d  reason: collision with root package name */
    public final float f14807d;

    /* renamed from: e  reason: collision with root package name */
    public final float f14808e;

    public s(u uVar, float f10, float f11) {
        this.f14806c = uVar;
        this.f14807d = f10;
        this.f14808e = f11;
    }

    public final void a(Matrix matrix, a aVar, int i10, Canvas canvas) {
        a aVar2 = aVar;
        int i11 = i10;
        Canvas canvas2 = canvas;
        u uVar = this.f14806c;
        float f10 = uVar.f14817c;
        float f11 = this.f14808e;
        float f12 = uVar.f14816b;
        float f13 = this.f14807d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (f10 - f11), (double) (f12 - f13)), 0.0f);
        Matrix matrix2 = this.f14820a;
        matrix2.set(matrix);
        matrix2.preTranslate(f13, f11);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += (float) i11;
        rectF.offset(0.0f, (float) (-i11));
        int[] iArr = a.f14379i;
        iArr[0] = aVar2.f14388f;
        iArr[1] = aVar2.f14387e;
        iArr[2] = aVar2.f14386d;
        Paint paint = aVar2.f14385c;
        float f14 = rectF.left;
        paint.setShader(new LinearGradient(f14, rectF.top, f14, rectF.bottom, iArr, a.f14380j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas2.concat(matrix2);
        canvas2.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        u uVar = this.f14806c;
        return (float) Math.toDegrees(Math.atan((double) ((uVar.f14817c - this.f14808e) / (uVar.f14816b - this.f14807d))));
    }
}

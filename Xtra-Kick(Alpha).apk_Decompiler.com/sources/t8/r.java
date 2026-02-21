package t8;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import s8.a;

public final class r extends w {

    /* renamed from: c  reason: collision with root package name */
    public final t f14805c;

    public r(t tVar) {
        this.f14805c = tVar;
    }

    public final void a(Matrix matrix, a aVar, int i10, Canvas canvas) {
        boolean z10;
        a aVar2 = aVar;
        int i11 = i10;
        Canvas canvas2 = canvas;
        t tVar = this.f14805c;
        float f10 = tVar.f14814f;
        float f11 = tVar.f14815g;
        RectF rectF = new RectF(tVar.f14810b, tVar.f14811c, tVar.f14812d, tVar.f14813e);
        aVar.getClass();
        if (f11 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        Path path = aVar2.f14389g;
        int[] iArr = a.f14381k;
        if (z10) {
            iArr[0] = 0;
            iArr[1] = aVar2.f14388f;
            iArr[2] = aVar2.f14387e;
            iArr[3] = aVar2.f14386d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = (float) (-i11);
            rectF.inset(f12, f12);
            iArr[0] = 0;
            iArr[1] = aVar2.f14386d;
            iArr[2] = aVar2.f14387e;
            iArr[3] = aVar2.f14388f;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f13 = 1.0f - (((float) i11) / width);
            float[] fArr = a.f14382l;
            fArr[1] = f13;
            fArr[2] = ((1.0f - f13) / 2.0f) + f13;
            RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP);
            Paint paint = aVar2.f14384b;
            paint.setShader(radialGradient);
            canvas.save();
            canvas2.concat(matrix);
            canvas2.scale(1.0f, rectF.height() / rectF.width());
            if (!z10) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, aVar2.f14390h);
            }
            canvas.drawArc(rectF, f10, f11, true, paint);
            canvas.restore();
        }
    }
}

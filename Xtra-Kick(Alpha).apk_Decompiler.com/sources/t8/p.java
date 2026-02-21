package t8;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import b4.e0;
import java.util.ArrayList;
import java.util.BitSet;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final x[] f14791a = new x[4];

    /* renamed from: b  reason: collision with root package name */
    public final Matrix[] f14792b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix[] f14793c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    public final PointF f14794d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    public final Path f14795e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public final Path f14796f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final x f14797g = new x();

    /* renamed from: h  reason: collision with root package name */
    public final float[] f14798h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f14799i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    public final Path f14800j = new Path();

    /* renamed from: k  reason: collision with root package name */
    public final Path f14801k = new Path();

    /* renamed from: l  reason: collision with root package name */
    public final boolean f14802l = true;

    public p() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f14791a[i10] = new x();
            this.f14792b[i10] = new Matrix();
            this.f14793c[i10] = new Matrix();
        }
    }

    public final void a(n nVar, float f10, RectF rectF, e0 e0Var, Path path) {
        int i10;
        Matrix[] matrixArr;
        float[] fArr;
        Matrix[] matrixArr2;
        x[] xVarArr;
        float f11;
        float f12;
        f fVar;
        c cVar;
        d dVar;
        float f13;
        float f14;
        float f15;
        float f16;
        p pVar = this;
        n nVar2 = nVar;
        RectF rectF2 = rectF;
        e0 e0Var2 = e0Var;
        Path path2 = path;
        path.rewind();
        Path path3 = pVar.f14795e;
        path3.rewind();
        Path path4 = pVar.f14796f;
        path4.rewind();
        path4.addRect(rectF2, Path.Direction.CW);
        int i11 = 0;
        while (true) {
            i10 = 4;
            matrixArr = pVar.f14793c;
            fArr = pVar.f14798h;
            matrixArr2 = pVar.f14792b;
            xVarArr = pVar.f14791a;
            if (i11 >= 4) {
                break;
            }
            if (i11 == 1) {
                cVar = nVar2.f14784g;
            } else if (i11 == 2) {
                cVar = nVar2.f14785h;
            } else if (i11 != 3) {
                cVar = nVar2.f14783f;
            } else {
                cVar = nVar2.f14782e;
            }
            if (i11 == 1) {
                dVar = nVar2.f14780c;
            } else if (i11 == 2) {
                dVar = nVar2.f14781d;
            } else if (i11 != 3) {
                dVar = nVar2.f14779b;
            } else {
                dVar = nVar2.f14778a;
            }
            x xVar = xVarArr[i11];
            dVar.getClass();
            dVar.a(f10, cVar.a(rectF2), xVar);
            int i12 = i11 + 1;
            float f17 = (float) ((i12 % 4) * 90);
            matrixArr2[i11].reset();
            PointF pointF = pVar.f14794d;
            int i13 = i12;
            if (i11 == 1) {
                f15 = rectF2.right;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    f16 = rectF2.right;
                } else {
                    f16 = rectF2.left;
                }
                f13 = f16;
                f14 = rectF2.top;
                pointF.set(f13, f14);
                matrixArr2[i11].setTranslate(pointF.x, pointF.y);
                matrixArr2[i11].preRotate(f17);
                x xVar2 = xVarArr[i11];
                fArr[0] = xVar2.f14823c;
                fArr[1] = xVar2.f14824d;
                matrixArr2[i11].mapPoints(fArr);
                matrixArr[i11].reset();
                matrixArr[i11].setTranslate(fArr[0], fArr[1]);
                matrixArr[i11].preRotate(f17);
                rectF2 = rectF;
                i11 = i13;
            } else {
                f15 = rectF2.left;
            }
            f13 = f15;
            f14 = rectF2.bottom;
            pointF.set(f13, f14);
            matrixArr2[i11].setTranslate(pointF.x, pointF.y);
            matrixArr2[i11].preRotate(f17);
            x xVar22 = xVarArr[i11];
            fArr[0] = xVar22.f14823c;
            fArr[1] = xVar22.f14824d;
            matrixArr2[i11].mapPoints(fArr);
            matrixArr[i11].reset();
            matrixArr[i11].setTranslate(fArr[0], fArr[1]);
            matrixArr[i11].preRotate(f17);
            rectF2 = rectF;
            i11 = i13;
        }
        char c10 = 1;
        char c11 = 0;
        int i14 = 0;
        while (i14 < i10) {
            x xVar3 = xVarArr[i14];
            fArr[c11] = xVar3.f14821a;
            fArr[c10] = xVar3.f14822b;
            matrixArr2[i14].mapPoints(fArr);
            if (i14 == 0) {
                path2.moveTo(fArr[c11], fArr[c10]);
            } else {
                path2.lineTo(fArr[c11], fArr[c10]);
            }
            xVarArr[i14].b(matrixArr2[i14], path2);
            if (e0Var2 != null) {
                x xVar4 = xVarArr[i14];
                Matrix matrix = matrixArr2[i14];
                i iVar = (i) e0Var2.f2538i;
                BitSet bitSet = iVar.f14747k;
                xVar4.getClass();
                bitSet.set(i14, false);
                xVar4.a(xVar4.f14826f);
                iVar.f14745i[i14] = new q(new ArrayList(xVar4.f14828h), new Matrix(matrix));
            }
            int i15 = i14 + 1;
            int i16 = i15 % 4;
            x xVar5 = xVarArr[i14];
            fArr[0] = xVar5.f14823c;
            fArr[1] = xVar5.f14824d;
            matrixArr2[i14].mapPoints(fArr);
            x xVar6 = xVarArr[i16];
            float f18 = xVar6.f14821a;
            int i17 = i15;
            float[] fArr2 = pVar.f14799i;
            fArr2[0] = f18;
            fArr2[1] = xVar6.f14822b;
            matrixArr2[i16].mapPoints(fArr2);
            float max = Math.max(((float) Math.hypot((double) (fArr[0] - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
            x xVar7 = xVarArr[i14];
            fArr[0] = xVar7.f14823c;
            fArr[1] = xVar7.f14824d;
            matrixArr2[i14].mapPoints(fArr);
            if (i14 == 1 || i14 == 3) {
                f12 = rectF.centerX();
                f11 = fArr[0];
            } else {
                f12 = rectF.centerY();
                f11 = fArr[1];
            }
            Math.abs(f12 - f11);
            x xVar8 = pVar.f14797g;
            xVar8.d(0.0f, 270.0f, 0.0f);
            if (i14 == 1) {
                fVar = nVar2.f14788k;
            } else if (i14 == 2) {
                fVar = nVar2.f14789l;
            } else if (i14 != 3) {
                fVar = nVar2.f14787j;
            } else {
                fVar = nVar2.f14786i;
            }
            fVar.getClass();
            xVar8.c(max, 0.0f);
            Path path5 = pVar.f14800j;
            path5.reset();
            xVar8.b(matrixArr[i14], path5);
            if (!pVar.f14802l || (!pVar.b(path5, i14) && !pVar.b(path5, i16))) {
                path2 = path;
                xVar8.b(matrixArr[i14], path2);
                e0Var2 = e0Var;
            } else {
                path5.op(path5, path4, Path.Op.DIFFERENCE);
                fArr[0] = xVar8.f14821a;
                fArr[1] = xVar8.f14822b;
                matrixArr[i14].mapPoints(fArr);
                path3.moveTo(fArr[0], fArr[1]);
                xVar8.b(matrixArr[i14], path3);
                e0Var2 = e0Var;
                path2 = path;
            }
            if (e0Var2 != null) {
                Matrix matrix2 = matrixArr[i14];
                i iVar2 = (i) e0Var2.f2538i;
                iVar2.f14747k.set(i14 + 4, false);
                xVar8.a(xVar8.f14826f);
                iVar2.f14746j[i14] = new q(new ArrayList(xVar8.f14828h), new Matrix(matrix2));
            }
            pVar = this;
            i14 = i17;
            c10 = 1;
            i10 = 4;
            c11 = 0;
        }
        path.close();
        path3.close();
        if (!path3.isEmpty()) {
            path2.op(path3, Path.Op.UNION);
        }
    }

    public final boolean b(Path path, int i10) {
        Path path2 = this.f14801k;
        path2.reset();
        this.f14791a[i10].b(this.f14792b[i10], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}

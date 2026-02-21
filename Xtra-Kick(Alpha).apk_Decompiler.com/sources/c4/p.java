package c4;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import d0.d;
import e0.h;
import java.util.ArrayList;
import q.e;

public final class p {

    /* renamed from: p  reason: collision with root package name */
    public static final Matrix f2920p = new Matrix();

    /* renamed from: a  reason: collision with root package name */
    public final Path f2921a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f2922b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f2923c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f2924d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f2925e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f2926f;

    /* renamed from: g  reason: collision with root package name */
    public final m f2927g;

    /* renamed from: h  reason: collision with root package name */
    public float f2928h;

    /* renamed from: i  reason: collision with root package name */
    public float f2929i;

    /* renamed from: j  reason: collision with root package name */
    public float f2930j;

    /* renamed from: k  reason: collision with root package name */
    public float f2931k;

    /* renamed from: l  reason: collision with root package name */
    public int f2932l;

    /* renamed from: m  reason: collision with root package name */
    public String f2933m;

    /* renamed from: n  reason: collision with root package name */
    public Boolean f2934n;

    /* renamed from: o  reason: collision with root package name */
    public final e f2935o;

    public p() {
        this.f2923c = new Matrix();
        this.f2928h = 0.0f;
        this.f2929i = 0.0f;
        this.f2930j = 0.0f;
        this.f2931k = 0.0f;
        this.f2932l = 255;
        this.f2933m = null;
        this.f2934n = null;
        this.f2935o = new e();
        this.f2927g = new m();
        this.f2921a = new Path();
        this.f2922b = new Path();
    }

    public final void a(m mVar, Matrix matrix, Canvas canvas, int i10, int i11) {
        int i12;
        float f10;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Path.FillType fillType;
        float f11;
        Path.FillType fillType2;
        m mVar2 = mVar;
        Canvas canvas2 = canvas;
        mVar2.f2904a.set(matrix);
        Matrix matrix2 = mVar2.f2904a;
        matrix2.preConcat(mVar2.f2913j);
        canvas.save();
        char c10 = 0;
        int i13 = 0;
        while (true) {
            ArrayList arrayList = mVar2.f2905b;
            if (i13 < arrayList.size()) {
                n nVar = (n) arrayList.get(i13);
                if (nVar instanceof m) {
                    a((m) nVar, matrix2, canvas, i10, i11);
                } else if (nVar instanceof o) {
                    o oVar = (o) nVar;
                    float f12 = ((float) i10) / this.f2930j;
                    float f13 = ((float) i11) / this.f2931k;
                    float min = Math.min(f12, f13);
                    Matrix matrix3 = this.f2923c;
                    matrix3.set(matrix2);
                    matrix3.postScale(f12, f13);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float f14 = min;
                    i12 = i13;
                    float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                    float f15 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[c10], (double) fArr[1]), hypot);
                    if (max > 0.0f) {
                        f10 = Math.abs(f15) / max;
                    } else {
                        f10 = 0.0f;
                    }
                    if (f10 != 0.0f) {
                        oVar.getClass();
                        Path path = this.f2921a;
                        path.reset();
                        h[] hVarArr = oVar.f2916a;
                        if (hVarArr != null) {
                            h.b(hVarArr, path);
                        }
                        Path path2 = this.f2922b;
                        path2.reset();
                        if (oVar instanceof k) {
                            if (oVar.f2918c == 0) {
                                fillType2 = Path.FillType.WINDING;
                            } else {
                                fillType2 = Path.FillType.EVEN_ODD;
                            }
                            path2.setFillType(fillType2);
                            path2.addPath(path, matrix3);
                            canvas2.clipPath(path2);
                        } else {
                            l lVar = (l) oVar;
                            float f16 = lVar.f2898j;
                            if (!(f16 == 0.0f && lVar.f2899k == 1.0f)) {
                                float f17 = lVar.f2900l;
                                float f18 = (f16 + f17) % 1.0f;
                                float f19 = (lVar.f2899k + f17) % 1.0f;
                                if (this.f2926f == null) {
                                    this.f2926f = new PathMeasure();
                                }
                                this.f2926f.setPath(path, false);
                                float length = this.f2926f.getLength();
                                float f20 = f18 * length;
                                float f21 = f19 * length;
                                path.reset();
                                if (f20 > f21) {
                                    this.f2926f.getSegment(f20, length, path, true);
                                    f11 = 0.0f;
                                    this.f2926f.getSegment(0.0f, f21, path, true);
                                } else {
                                    f11 = 0.0f;
                                    this.f2926f.getSegment(f20, f21, path, true);
                                }
                                path.rLineTo(f11, f11);
                            }
                            path2.addPath(path, matrix3);
                            d dVar = lVar.f2895g;
                            if (((Shader) dVar.f4091i) != null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10 || dVar.f4090h != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                if (this.f2925e == null) {
                                    Paint paint = new Paint(1);
                                    this.f2925e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = this.f2925e;
                                Object obj = dVar.f4091i;
                                if (((Shader) obj) != null) {
                                    z15 = true;
                                } else {
                                    z15 = false;
                                }
                                if (z15) {
                                    Shader shader = (Shader) obj;
                                    shader.setLocalMatrix(matrix3);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(lVar.f2897i * 255.0f));
                                } else {
                                    paint2.setShader((Shader) null);
                                    paint2.setAlpha(255);
                                    int i14 = dVar.f4090h;
                                    float f22 = lVar.f2897i;
                                    PorterDuff.Mode mode = s.f2949q;
                                    paint2.setColor((i14 & 16777215) | (((int) (((float) Color.alpha(i14)) * f22)) << 24));
                                }
                                paint2.setColorFilter((ColorFilter) null);
                                if (lVar.f2918c == 0) {
                                    fillType = Path.FillType.WINDING;
                                } else {
                                    fillType = Path.FillType.EVEN_ODD;
                                }
                                path2.setFillType(fillType);
                                canvas2.drawPath(path2, paint2);
                            }
                            d dVar2 = lVar.f2893e;
                            if (((Shader) dVar2.f4091i) != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12 || dVar2.f4090h != 0) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (z13) {
                                if (this.f2924d == null) {
                                    z14 = true;
                                    Paint paint3 = new Paint(1);
                                    this.f2924d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                } else {
                                    z14 = true;
                                }
                                Paint paint4 = this.f2924d;
                                Paint.Join join = lVar.f2902n;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = lVar.f2901m;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(lVar.f2903o);
                                Object obj2 = dVar2.f4091i;
                                if (((Shader) obj2) == null) {
                                    z14 = false;
                                }
                                if (z14) {
                                    Shader shader2 = (Shader) obj2;
                                    shader2.setLocalMatrix(matrix3);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(lVar.f2896h * 255.0f));
                                } else {
                                    paint4.setShader((Shader) null);
                                    paint4.setAlpha(255);
                                    int i15 = dVar2.f4090h;
                                    float f23 = lVar.f2896h;
                                    PorterDuff.Mode mode2 = s.f2949q;
                                    paint4.setColor((i15 & 16777215) | (((int) (((float) Color.alpha(i15)) * f23)) << 24));
                                }
                                paint4.setColorFilter((ColorFilter) null);
                                paint4.setStrokeWidth(lVar.f2894f * f10 * f14);
                                canvas2.drawPath(path2, paint4);
                            }
                        }
                    }
                    i13 = i12 + 1;
                    c10 = 0;
                }
                int i16 = i10;
                int i17 = i11;
                i12 = i13;
                i13 = i12 + 1;
                c10 = 0;
            } else {
                canvas.restore();
                return;
            }
        }
    }

    public float getAlpha() {
        return ((float) getRootAlpha()) / 255.0f;
    }

    public int getRootAlpha() {
        return this.f2932l;
    }

    public void setAlpha(float f10) {
        setRootAlpha((int) (f10 * 255.0f));
    }

    public void setRootAlpha(int i10) {
        this.f2932l = i10;
    }

    public p(p pVar) {
        this.f2923c = new Matrix();
        this.f2928h = 0.0f;
        this.f2929i = 0.0f;
        this.f2930j = 0.0f;
        this.f2931k = 0.0f;
        this.f2932l = 255;
        this.f2933m = null;
        this.f2934n = null;
        e eVar = new e();
        this.f2935o = eVar;
        this.f2927g = new m(pVar.f2927g, eVar);
        this.f2921a = new Path(pVar.f2921a);
        this.f2922b = new Path(pVar.f2922b);
        this.f2928h = pVar.f2928h;
        this.f2929i = pVar.f2929i;
        this.f2930j = pVar.f2930j;
        this.f2931k = pVar.f2931k;
        this.f2932l = pVar.f2932l;
        this.f2933m = pVar.f2933m;
        String str = pVar.f2933m;
        if (str != null) {
            eVar.put(str, this);
        }
        this.f2934n = pVar.f2934n;
    }
}

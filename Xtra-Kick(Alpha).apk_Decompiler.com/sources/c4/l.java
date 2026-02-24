package c4;

import android.graphics.Paint;
import d0.d;

public final class l extends o {

    /* renamed from: e  reason: collision with root package name */
    public d f2893e;

    /* renamed from: f  reason: collision with root package name */
    public float f2894f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public d f2895g;

    /* renamed from: h  reason: collision with root package name */
    public float f2896h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f2897i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f2898j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f2899k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f2900l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public Paint.Cap f2901m = Paint.Cap.BUTT;

    /* renamed from: n  reason: collision with root package name */
    public Paint.Join f2902n = Paint.Join.MITER;

    /* renamed from: o  reason: collision with root package name */
    public float f2903o = 4.0f;

    public l() {
    }

    public final boolean a() {
        return this.f2895g.c() || this.f2893e.c();
    }

    public final boolean b(int[] iArr) {
        return this.f2893e.d(iArr) | this.f2895g.d(iArr);
    }

    public float getFillAlpha() {
        return this.f2897i;
    }

    public int getFillColor() {
        return this.f2895g.f4090h;
    }

    public float getStrokeAlpha() {
        return this.f2896h;
    }

    public int getStrokeColor() {
        return this.f2893e.f4090h;
    }

    public float getStrokeWidth() {
        return this.f2894f;
    }

    public float getTrimPathEnd() {
        return this.f2899k;
    }

    public float getTrimPathOffset() {
        return this.f2900l;
    }

    public float getTrimPathStart() {
        return this.f2898j;
    }

    public void setFillAlpha(float f10) {
        this.f2897i = f10;
    }

    public void setFillColor(int i10) {
        this.f2895g.f4090h = i10;
    }

    public void setStrokeAlpha(float f10) {
        this.f2896h = f10;
    }

    public void setStrokeColor(int i10) {
        this.f2893e.f4090h = i10;
    }

    public void setStrokeWidth(float f10) {
        this.f2894f = f10;
    }

    public void setTrimPathEnd(float f10) {
        this.f2899k = f10;
    }

    public void setTrimPathOffset(float f10) {
        this.f2900l = f10;
    }

    public void setTrimPathStart(float f10) {
        this.f2898j = f10;
    }

    public l(l lVar) {
        super(lVar);
        this.f2893e = lVar.f2893e;
        this.f2894f = lVar.f2894f;
        this.f2896h = lVar.f2896h;
        this.f2895g = lVar.f2895g;
        this.f2918c = lVar.f2918c;
        this.f2897i = lVar.f2897i;
        this.f2898j = lVar.f2898j;
        this.f2899k = lVar.f2899k;
        this.f2900l = lVar.f2900l;
        this.f2901m = lVar.f2901m;
        this.f2902n = lVar.f2902n;
        this.f2903o = lVar.f2903o;
    }
}

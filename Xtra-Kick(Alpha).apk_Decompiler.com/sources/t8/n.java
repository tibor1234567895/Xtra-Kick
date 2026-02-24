package t8;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import v7.a;

public final class n {

    /* renamed from: m  reason: collision with root package name */
    public static final k f14777m = new k(0.5f);

    /* renamed from: a  reason: collision with root package name */
    public final d f14778a;

    /* renamed from: b  reason: collision with root package name */
    public final d f14779b;

    /* renamed from: c  reason: collision with root package name */
    public final d f14780c;

    /* renamed from: d  reason: collision with root package name */
    public final d f14781d;

    /* renamed from: e  reason: collision with root package name */
    public final c f14782e;

    /* renamed from: f  reason: collision with root package name */
    public final c f14783f;

    /* renamed from: g  reason: collision with root package name */
    public final c f14784g;

    /* renamed from: h  reason: collision with root package name */
    public final c f14785h;

    /* renamed from: i  reason: collision with root package name */
    public final f f14786i;

    /* renamed from: j  reason: collision with root package name */
    public final f f14787j;

    /* renamed from: k  reason: collision with root package name */
    public final f f14788k;

    /* renamed from: l  reason: collision with root package name */
    public final f f14789l;

    public n() {
        this.f14778a = new l();
        this.f14779b = new l();
        this.f14780c = new l();
        this.f14781d = new l();
        this.f14782e = new a(0.0f);
        this.f14783f = new a(0.0f);
        this.f14784g = new a(0.0f);
        this.f14785h = new a(0.0f);
        this.f14786i = new f();
        this.f14787j = new f();
        this.f14788k = new f();
        this.f14789l = new f();
    }

    public static m a(Context context, int i10, int i11, c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i11);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(a.D);
        try {
            int i12 = obtainStyledAttributes.getInt(0, 0);
            int i13 = obtainStyledAttributes.getInt(3, i12);
            int i14 = obtainStyledAttributes.getInt(4, i12);
            int i15 = obtainStyledAttributes.getInt(2, i12);
            int i16 = obtainStyledAttributes.getInt(1, i12);
            c c10 = c(obtainStyledAttributes, 5, cVar);
            c c11 = c(obtainStyledAttributes, 8, c10);
            c c12 = c(obtainStyledAttributes, 9, c10);
            c c13 = c(obtainStyledAttributes, 7, c10);
            c c14 = c(obtainStyledAttributes, 6, c10);
            m mVar = new m();
            d a10 = j.a(i13);
            mVar.f14765a = a10;
            float b10 = m.b(a10);
            if (b10 != -1.0f) {
                mVar.f14769e = new a(b10);
            }
            mVar.f14769e = c11;
            d a11 = j.a(i14);
            mVar.f14766b = a11;
            float b11 = m.b(a11);
            if (b11 != -1.0f) {
                mVar.f14770f = new a(b11);
            }
            mVar.f14770f = c12;
            d a12 = j.a(i15);
            mVar.f14767c = a12;
            float b12 = m.b(a12);
            if (b12 != -1.0f) {
                mVar.f14771g = new a(b12);
            }
            mVar.f14771g = c13;
            d a13 = j.a(i16);
            mVar.f14768d = a13;
            float b13 = m.b(a13);
            if (b13 != -1.0f) {
                mVar.f14772h = new a(b13);
            }
            mVar.f14772h = c14;
            return mVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static m b(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a((float) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f15953v, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static c c(TypedArray typedArray, int i10, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue == null) {
            return cVar;
        }
        int i11 = peekValue.type;
        return i11 == 5 ? new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i11 == 6 ? new k(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public final boolean d(RectF rectF) {
        Class<f> cls = f.class;
        boolean z10 = this.f14789l.getClass().equals(cls) && this.f14787j.getClass().equals(cls) && this.f14786i.getClass().equals(cls) && this.f14788k.getClass().equals(cls);
        float a10 = this.f14782e.a(rectF);
        return z10 && ((this.f14783f.a(rectF) > a10 ? 1 : (this.f14783f.a(rectF) == a10 ? 0 : -1)) == 0 && (this.f14785h.a(rectF) > a10 ? 1 : (this.f14785h.a(rectF) == a10 ? 0 : -1)) == 0 && (this.f14784g.a(rectF) > a10 ? 1 : (this.f14784g.a(rectF) == a10 ? 0 : -1)) == 0) && ((this.f14779b instanceof l) && (this.f14778a instanceof l) && (this.f14780c instanceof l) && (this.f14781d instanceof l));
    }

    public final n e(float f10) {
        m mVar = new m(this);
        mVar.f14769e = new a(f10);
        mVar.f14770f = new a(f10);
        mVar.f14771g = new a(f10);
        mVar.f14772h = new a(f10);
        return new n(mVar);
    }

    public n(m mVar) {
        this.f14778a = mVar.f14765a;
        this.f14779b = mVar.f14766b;
        this.f14780c = mVar.f14767c;
        this.f14781d = mVar.f14768d;
        this.f14782e = mVar.f14769e;
        this.f14783f = mVar.f14770f;
        this.f14784g = mVar.f14771g;
        this.f14785h = mVar.f14772h;
        this.f14786i = mVar.f14773i;
        this.f14787j = mVar.f14774j;
        this.f14788k = mVar.f14775k;
        this.f14789l = mVar.f14776l;
    }
}

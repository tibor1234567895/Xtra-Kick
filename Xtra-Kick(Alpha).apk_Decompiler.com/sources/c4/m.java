package c4;

import android.graphics.Matrix;
import java.util.ArrayList;
import q.e;

public final class m extends n {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f2904a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f2905b;

    /* renamed from: c  reason: collision with root package name */
    public float f2906c;

    /* renamed from: d  reason: collision with root package name */
    public float f2907d;

    /* renamed from: e  reason: collision with root package name */
    public float f2908e;

    /* renamed from: f  reason: collision with root package name */
    public float f2909f;

    /* renamed from: g  reason: collision with root package name */
    public float f2910g;

    /* renamed from: h  reason: collision with root package name */
    public float f2911h;

    /* renamed from: i  reason: collision with root package name */
    public float f2912i;

    /* renamed from: j  reason: collision with root package name */
    public final Matrix f2913j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2914k;

    /* renamed from: l  reason: collision with root package name */
    public String f2915l;

    public m() {
        super(0);
        this.f2904a = new Matrix();
        this.f2905b = new ArrayList();
        this.f2906c = 0.0f;
        this.f2907d = 0.0f;
        this.f2908e = 0.0f;
        this.f2909f = 1.0f;
        this.f2910g = 1.0f;
        this.f2911h = 0.0f;
        this.f2912i = 0.0f;
        this.f2913j = new Matrix();
        this.f2915l = null;
    }

    public final boolean a() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2905b;
            if (i10 >= arrayList.size()) {
                return false;
            }
            if (((n) arrayList.get(i10)).a()) {
                return true;
            }
            i10++;
        }
    }

    public final boolean b(int[] iArr) {
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            ArrayList arrayList = this.f2905b;
            if (i10 >= arrayList.size()) {
                return z10;
            }
            z10 |= ((n) arrayList.get(i10)).b(iArr);
            i10++;
        }
    }

    public final void c() {
        Matrix matrix = this.f2913j;
        matrix.reset();
        matrix.postTranslate(-this.f2907d, -this.f2908e);
        matrix.postScale(this.f2909f, this.f2910g);
        matrix.postRotate(this.f2906c, 0.0f, 0.0f);
        matrix.postTranslate(this.f2911h + this.f2907d, this.f2912i + this.f2908e);
    }

    public String getGroupName() {
        return this.f2915l;
    }

    public Matrix getLocalMatrix() {
        return this.f2913j;
    }

    public float getPivotX() {
        return this.f2907d;
    }

    public float getPivotY() {
        return this.f2908e;
    }

    public float getRotation() {
        return this.f2906c;
    }

    public float getScaleX() {
        return this.f2909f;
    }

    public float getScaleY() {
        return this.f2910g;
    }

    public float getTranslateX() {
        return this.f2911h;
    }

    public float getTranslateY() {
        return this.f2912i;
    }

    public void setPivotX(float f10) {
        if (f10 != this.f2907d) {
            this.f2907d = f10;
            c();
        }
    }

    public void setPivotY(float f10) {
        if (f10 != this.f2908e) {
            this.f2908e = f10;
            c();
        }
    }

    public void setRotation(float f10) {
        if (f10 != this.f2906c) {
            this.f2906c = f10;
            c();
        }
    }

    public void setScaleX(float f10) {
        if (f10 != this.f2909f) {
            this.f2909f = f10;
            c();
        }
    }

    public void setScaleY(float f10) {
        if (f10 != this.f2910g) {
            this.f2910g = f10;
            c();
        }
    }

    public void setTranslateX(float f10) {
        if (f10 != this.f2911h) {
            this.f2911h = f10;
            c();
        }
    }

    public void setTranslateY(float f10) {
        if (f10 != this.f2912i) {
            this.f2912i = f10;
            c();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(m mVar, e eVar) {
        super(0);
        o oVar;
        this.f2904a = new Matrix();
        this.f2905b = new ArrayList();
        this.f2906c = 0.0f;
        this.f2907d = 0.0f;
        this.f2908e = 0.0f;
        this.f2909f = 1.0f;
        this.f2910g = 1.0f;
        this.f2911h = 0.0f;
        this.f2912i = 0.0f;
        Matrix matrix = new Matrix();
        this.f2913j = matrix;
        this.f2915l = null;
        this.f2906c = mVar.f2906c;
        this.f2907d = mVar.f2907d;
        this.f2908e = mVar.f2908e;
        this.f2909f = mVar.f2909f;
        this.f2910g = mVar.f2910g;
        this.f2911h = mVar.f2911h;
        this.f2912i = mVar.f2912i;
        String str = mVar.f2915l;
        this.f2915l = str;
        this.f2914k = mVar.f2914k;
        if (str != null) {
            eVar.put(str, this);
        }
        matrix.set(mVar.f2913j);
        ArrayList arrayList = mVar.f2905b;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            Object obj = arrayList.get(i10);
            if (obj instanceof m) {
                this.f2905b.add(new m((m) obj, eVar));
            } else {
                if (obj instanceof l) {
                    oVar = new l((l) obj);
                } else if (obj instanceof k) {
                    oVar = new k((k) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f2905b.add(oVar);
                String str2 = oVar.f2917b;
                if (str2 != null) {
                    eVar.put(str2, oVar);
                }
            }
        }
    }
}

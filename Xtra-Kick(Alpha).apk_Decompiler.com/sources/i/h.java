package i;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import f0.b;
import f0.d;

public abstract class h extends Drawable.ConstantState {
    public int A = 0;
    public boolean B;
    public ColorFilter C;
    public boolean D;
    public ColorStateList E;
    public PorterDuff.Mode F;
    public boolean G;
    public boolean H;

    /* renamed from: a  reason: collision with root package name */
    public final i f7899a;

    /* renamed from: b  reason: collision with root package name */
    public Resources f7900b;

    /* renamed from: c  reason: collision with root package name */
    public int f7901c;

    /* renamed from: d  reason: collision with root package name */
    public int f7902d;

    /* renamed from: e  reason: collision with root package name */
    public int f7903e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray f7904f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable[] f7905g;

    /* renamed from: h  reason: collision with root package name */
    public int f7906h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7907i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7908j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f7909k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f7910l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f7911m;

    /* renamed from: n  reason: collision with root package name */
    public int f7912n;

    /* renamed from: o  reason: collision with root package name */
    public int f7913o;

    /* renamed from: p  reason: collision with root package name */
    public int f7914p;

    /* renamed from: q  reason: collision with root package name */
    public int f7915q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f7916r;

    /* renamed from: s  reason: collision with root package name */
    public int f7917s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f7918t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f7919u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f7920v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f7921w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f7922x = true;

    /* renamed from: y  reason: collision with root package name */
    public int f7923y;

    /* renamed from: z  reason: collision with root package name */
    public int f7924z = 0;

    public h(h hVar, i iVar, Resources resources) {
        Resources resources2;
        int i10;
        SparseArray sparseArray;
        this.f7899a = iVar;
        Rect rect = null;
        if (resources != null) {
            resources2 = resources;
        } else if (hVar != null) {
            resources2 = hVar.f7900b;
        } else {
            resources2 = null;
        }
        this.f7900b = resources2;
        if (hVar != null) {
            i10 = hVar.f7901c;
        } else {
            i10 = 0;
        }
        int i11 = i.f7925t;
        i10 = resources != null ? resources.getDisplayMetrics().densityDpi : i10;
        i10 = i10 == 0 ? 160 : i10;
        this.f7901c = i10;
        if (hVar != null) {
            this.f7902d = hVar.f7902d;
            this.f7903e = hVar.f7903e;
            this.f7920v = true;
            this.f7921w = true;
            this.f7907i = hVar.f7907i;
            this.f7910l = hVar.f7910l;
            this.f7922x = hVar.f7922x;
            this.f7923y = hVar.f7923y;
            this.f7924z = hVar.f7924z;
            this.A = hVar.A;
            this.B = hVar.B;
            this.C = hVar.C;
            this.D = hVar.D;
            this.E = hVar.E;
            this.F = hVar.F;
            this.G = hVar.G;
            this.H = hVar.H;
            if (hVar.f7901c == i10) {
                if (hVar.f7908j) {
                    this.f7909k = hVar.f7909k != null ? new Rect(hVar.f7909k) : rect;
                    this.f7908j = true;
                }
                if (hVar.f7911m) {
                    this.f7912n = hVar.f7912n;
                    this.f7913o = hVar.f7913o;
                    this.f7914p = hVar.f7914p;
                    this.f7915q = hVar.f7915q;
                    this.f7911m = true;
                }
            }
            if (hVar.f7916r) {
                this.f7917s = hVar.f7917s;
                this.f7916r = true;
            }
            if (hVar.f7918t) {
                this.f7919u = hVar.f7919u;
                this.f7918t = true;
            }
            Drawable[] drawableArr = hVar.f7905g;
            this.f7905g = new Drawable[drawableArr.length];
            this.f7906h = hVar.f7906h;
            SparseArray sparseArray2 = hVar.f7904f;
            if (sparseArray2 != null) {
                sparseArray = sparseArray2.clone();
            } else {
                sparseArray = new SparseArray(this.f7906h);
            }
            this.f7904f = sparseArray;
            int i12 = this.f7906h;
            for (int i13 = 0; i13 < i12; i13++) {
                Drawable drawable = drawableArr[i13];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f7904f.put(i13, constantState);
                    } else {
                        this.f7905g[i13] = drawableArr[i13];
                    }
                }
            }
            return;
        }
        this.f7905g = new Drawable[10];
        this.f7906h = 0;
    }

    public final int a(Drawable drawable) {
        int i10 = this.f7906h;
        if (i10 >= this.f7905g.length) {
            int i11 = i10 + 10;
            j jVar = (j) this;
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = jVar.f7905g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            jVar.f7905g = drawableArr;
            int[][] iArr = new int[i11][];
            System.arraycopy(jVar.I, 0, iArr, 0, i10);
            jVar.I = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f7899a);
        this.f7905g[i10] = drawable;
        this.f7906h++;
        this.f7903e = drawable.getChangingConfigurations() | this.f7903e;
        this.f7916r = false;
        this.f7918t = false;
        this.f7909k = null;
        this.f7908j = false;
        this.f7911m = false;
        this.f7920v = false;
        return i10;
    }

    public final void b() {
        this.f7911m = true;
        c();
        int i10 = this.f7906h;
        Drawable[] drawableArr = this.f7905g;
        this.f7913o = -1;
        this.f7912n = -1;
        this.f7915q = 0;
        this.f7914p = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            Drawable drawable = drawableArr[i11];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f7912n) {
                this.f7912n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f7913o) {
                this.f7913o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f7914p) {
                this.f7914p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f7915q) {
                this.f7915q = minimumHeight;
            }
        }
    }

    public final void c() {
        SparseArray sparseArray = this.f7904f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.f7904f.keyAt(i10);
                Drawable[] drawableArr = this.f7905g;
                Drawable newDrawable = ((Drawable.ConstantState) this.f7904f.valueAt(i10)).newDrawable(this.f7900b);
                if (Build.VERSION.SDK_INT >= 23) {
                    d.c(newDrawable, this.f7923y);
                }
                Drawable mutate = newDrawable.mutate();
                mutate.setCallback(this.f7899a);
                drawableArr[keyAt] = mutate;
            }
            this.f7904f = null;
        }
    }

    public final boolean canApplyTheme() {
        int i10 = this.f7906h;
        Drawable[] drawableArr = this.f7905g;
        for (int i11 = 0; i11 < i10; i11++) {
            Drawable drawable = drawableArr[i11];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f7904f.get(i11);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (b.b(drawable)) {
                return true;
            }
        }
        return false;
    }

    public final Drawable d(int i10) {
        int indexOfKey;
        Drawable drawable = this.f7905g[i10];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f7904f;
        if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
            return null;
        }
        Drawable newDrawable = ((Drawable.ConstantState) this.f7904f.valueAt(indexOfKey)).newDrawable(this.f7900b);
        if (Build.VERSION.SDK_INT >= 23) {
            d.c(newDrawable, this.f7923y);
        }
        Drawable mutate = newDrawable.mutate();
        mutate.setCallback(this.f7899a);
        this.f7905g[i10] = mutate;
        this.f7904f.removeAt(indexOfKey);
        if (this.f7904f.size() == 0) {
            this.f7904f = null;
        }
        return mutate;
    }

    public abstract void e();

    public final int getChangingConfigurations() {
        return this.f7902d | this.f7903e;
    }
}

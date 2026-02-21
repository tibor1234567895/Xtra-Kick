package z3;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final RectF f17512a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f17513b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f17514c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f17515d;

    /* renamed from: e  reason: collision with root package name */
    public float f17516e;

    /* renamed from: f  reason: collision with root package name */
    public float f17517f;

    /* renamed from: g  reason: collision with root package name */
    public float f17518g;

    /* renamed from: h  reason: collision with root package name */
    public float f17519h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f17520i;

    /* renamed from: j  reason: collision with root package name */
    public int f17521j;

    /* renamed from: k  reason: collision with root package name */
    public float f17522k;

    /* renamed from: l  reason: collision with root package name */
    public float f17523l;

    /* renamed from: m  reason: collision with root package name */
    public float f17524m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f17525n;

    /* renamed from: o  reason: collision with root package name */
    public Path f17526o;

    /* renamed from: p  reason: collision with root package name */
    public float f17527p;

    /* renamed from: q  reason: collision with root package name */
    public float f17528q;

    /* renamed from: r  reason: collision with root package name */
    public int f17529r;

    /* renamed from: s  reason: collision with root package name */
    public int f17530s;

    /* renamed from: t  reason: collision with root package name */
    public int f17531t;

    /* renamed from: u  reason: collision with root package name */
    public int f17532u;

    public d() {
        Paint paint = new Paint();
        this.f17513b = paint;
        Paint paint2 = new Paint();
        this.f17514c = paint2;
        Paint paint3 = new Paint();
        this.f17515d = paint3;
        this.f17516e = 0.0f;
        this.f17517f = 0.0f;
        this.f17518g = 0.0f;
        this.f17519h = 5.0f;
        this.f17527p = 1.0f;
        this.f17531t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i10) {
        this.f17521j = i10;
        this.f17532u = this.f17520i[i10];
    }
}

package s8;

import android.graphics.Paint;
import android.graphics.Path;

public final class a {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f14379i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f14380j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f14381k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f14382l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f14383a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f14384b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f14385c;

    /* renamed from: d  reason: collision with root package name */
    public int f14386d;

    /* renamed from: e  reason: collision with root package name */
    public int f14387e;

    /* renamed from: f  reason: collision with root package name */
    public int f14388f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f14389g = new Path();

    /* renamed from: h  reason: collision with root package name */
    public final Paint f14390h;

    public a() {
        Paint paint = new Paint();
        this.f14390h = paint;
        this.f14383a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f14384b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f14385c = new Paint(paint2);
    }

    public final void a(int i10) {
        this.f14386d = e0.a.d(i10, 68);
        this.f14387e = e0.a.d(i10, 20);
        this.f14388f = e0.a.d(i10, 0);
        this.f14383a.setColor(this.f14386d);
    }
}

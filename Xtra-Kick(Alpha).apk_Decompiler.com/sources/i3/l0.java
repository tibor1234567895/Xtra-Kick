package i3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;

public final class l0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* renamed from: a  reason: collision with root package name */
    public final float f8116a;

    /* renamed from: b  reason: collision with root package name */
    public final float f8117b;

    /* renamed from: c  reason: collision with root package name */
    public final float f8118c;

    /* renamed from: d  reason: collision with root package name */
    public final float f8119d;

    /* renamed from: e  reason: collision with root package name */
    public final float f8120e;

    /* renamed from: f  reason: collision with root package name */
    public final TextPaint f8121f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f8122g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f8123h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f8124i;

    /* renamed from: j  reason: collision with root package name */
    public Layout.Alignment f8125j;

    /* renamed from: k  reason: collision with root package name */
    public Bitmap f8126k;

    /* renamed from: l  reason: collision with root package name */
    public float f8127l;

    /* renamed from: m  reason: collision with root package name */
    public int f8128m;

    /* renamed from: n  reason: collision with root package name */
    public int f8129n;

    /* renamed from: o  reason: collision with root package name */
    public float f8130o;

    /* renamed from: p  reason: collision with root package name */
    public int f8131p;

    /* renamed from: q  reason: collision with root package name */
    public float f8132q;

    /* renamed from: r  reason: collision with root package name */
    public float f8133r;

    /* renamed from: s  reason: collision with root package name */
    public int f8134s;

    /* renamed from: t  reason: collision with root package name */
    public int f8135t;

    /* renamed from: u  reason: collision with root package name */
    public int f8136u;

    /* renamed from: v  reason: collision with root package name */
    public int f8137v;

    /* renamed from: w  reason: collision with root package name */
    public int f8138w;

    /* renamed from: x  reason: collision with root package name */
    public float f8139x;

    /* renamed from: y  reason: collision with root package name */
    public float f8140y;

    /* renamed from: z  reason: collision with root package name */
    public float f8141z;

    public l0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.f8120e = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f8119d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f8116a = round;
        this.f8117b = round;
        this.f8118c = round;
        TextPaint textPaint = new TextPaint();
        this.f8121f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f8122g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f8123h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z10) {
        int i10;
        if (z10) {
            StaticLayout staticLayout = this.E;
            StaticLayout staticLayout2 = this.F;
            if (staticLayout != null && staticLayout2 != null) {
                int save = canvas.save();
                canvas.translate((float) this.G, (float) this.H);
                if (Color.alpha(this.f8136u) > 0) {
                    Paint paint = this.f8122g;
                    paint.setColor(this.f8136u);
                    canvas.drawRect((float) (-this.I), 0.0f, (float) (staticLayout.getWidth() + this.I), (float) staticLayout.getHeight(), paint);
                }
                int i11 = this.f8138w;
                TextPaint textPaint = this.f8121f;
                boolean z11 = true;
                if (i11 == 1) {
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStrokeWidth(this.f8116a);
                    textPaint.setColor(this.f8137v);
                    textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                    staticLayout2.draw(canvas);
                } else {
                    float f10 = this.f8117b;
                    if (i11 == 2) {
                        float f11 = this.f8118c;
                        textPaint.setShadowLayer(f10, f11, f11, this.f8137v);
                    } else if (i11 == 3 || i11 == 4) {
                        if (i11 != 3) {
                            z11 = false;
                        }
                        int i12 = -1;
                        if (z11) {
                            i10 = -1;
                        } else {
                            i10 = this.f8137v;
                        }
                        if (z11) {
                            i12 = this.f8137v;
                        }
                        float f12 = f10 / 2.0f;
                        textPaint.setColor(this.f8134s);
                        textPaint.setStyle(Paint.Style.FILL);
                        float f13 = -f12;
                        textPaint.setShadowLayer(f10, f13, f13, i10);
                        staticLayout2.draw(canvas);
                        textPaint.setShadowLayer(f10, f12, f12, i12);
                    }
                }
                textPaint.setColor(this.f8134s);
                textPaint.setStyle(Paint.Style.FILL);
                staticLayout.draw(canvas);
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                canvas.restoreToCount(save);
                return;
            }
            return;
        }
        this.J.getClass();
        this.f8126k.getClass();
        canvas.drawBitmap(this.f8126k, (Rect) null, this.J, this.f8123h);
    }
}

package l4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.media.h;
import c4.c;
import j4.i;
import java.util.ArrayList;
import xa.j;

public final class b extends Drawable implements Animatable {
    public boolean A;

    /* renamed from: h  reason: collision with root package name */
    public final Movie f9563h;

    /* renamed from: i  reason: collision with root package name */
    public final Bitmap.Config f9564i;

    /* renamed from: j  reason: collision with root package name */
    public final int f9565j;

    /* renamed from: k  reason: collision with root package name */
    public final Paint f9566k = new Paint(3);

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f9567l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final Rect f9568m = new Rect();

    /* renamed from: n  reason: collision with root package name */
    public final Rect f9569n = new Rect();

    /* renamed from: o  reason: collision with root package name */
    public Canvas f9570o;

    /* renamed from: p  reason: collision with root package name */
    public Bitmap f9571p;

    /* renamed from: q  reason: collision with root package name */
    public float f9572q = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    public float f9573r = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    public float f9574s;

    /* renamed from: t  reason: collision with root package name */
    public float f9575t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f9576u;

    /* renamed from: v  reason: collision with root package name */
    public long f9577v;

    /* renamed from: w  reason: collision with root package name */
    public long f9578w;

    /* renamed from: x  reason: collision with root package name */
    public int f9579x = -1;

    /* renamed from: y  reason: collision with root package name */
    public Picture f9580y;

    /* renamed from: z  reason: collision with root package name */
    public int f9581z = 1;

    static {
        new a(0);
    }

    public b(Movie movie, Bitmap.Config config, int i10) {
        boolean z10;
        this.f9563h = movie;
        this.f9564i = config;
        this.f9565j = i10;
        if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.HARDWARE) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!(true ^ z10)) {
            throw new IllegalArgumentException("Bitmap config must not be hardware.".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final void a(Canvas canvas) {
        Canvas canvas2 = this.f9570o;
        Bitmap bitmap = this.f9571p;
        if (canvas2 != null && bitmap != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            int save = canvas2.save();
            try {
                float f10 = this.f9572q;
                canvas2.scale(f10, f10);
                Movie movie = this.f9563h;
                Paint paint = this.f9566k;
                movie.draw(canvas2, 0.0f, 0.0f, paint);
                Picture picture = this.f9580y;
                if (picture != null) {
                    picture.draw(canvas2);
                }
                canvas2.restoreToCount(save);
                int save2 = canvas.save();
                try {
                    canvas.translate(this.f9574s, this.f9575t);
                    float f11 = this.f9573r;
                    canvas.scale(f11, f11);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                } finally {
                    canvas.restoreToCount(save2);
                }
            } catch (Throwable th) {
                canvas2.restoreToCount(save);
                throw th;
            }
        }
    }

    public final void b(Rect rect) {
        Rect rect2 = this.f9568m;
        if (!j.a(rect2, rect)) {
            rect2.set(rect);
            int width = rect.width();
            int height = rect.height();
            Movie movie = this.f9563h;
            int width2 = movie.width();
            int height2 = movie.height();
            if (width2 > 0 && height2 > 0) {
                int i10 = this.f9565j;
                double a10 = i.a(width2, height2, width, height, i10);
                if (!this.A && a10 > 1.0d) {
                    a10 = 1.0d;
                }
                float f10 = (float) a10;
                this.f9572q = f10;
                int i11 = (int) (((float) width2) * f10);
                int i12 = (int) (f10 * ((float) height2));
                Bitmap createBitmap = Bitmap.createBitmap(i11, i12, this.f9564i);
                j.e("createBitmap(width, height, config)", createBitmap);
                Bitmap bitmap = this.f9571p;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.f9571p = createBitmap;
                this.f9570o = new Canvas(createBitmap);
                if (this.A) {
                    this.f9573r = 1.0f;
                    this.f9574s = 0.0f;
                    this.f9575t = 0.0f;
                    return;
                }
                float a11 = (float) i.a(i11, i12, width, height, i10);
                this.f9573r = a11;
                float f11 = ((float) width) - (((float) i11) * a11);
                float f12 = (float) 2;
                this.f9574s = (f11 / f12) + ((float) rect.left);
                this.f9575t = ((((float) height) - (a11 * ((float) i12))) / f12) + ((float) rect.top);
            }
        }
    }

    public final void draw(Canvas canvas) {
        boolean z10;
        Movie movie = this.f9563h;
        int duration = movie.duration();
        if (duration == 0) {
            duration = 0;
            z10 = false;
        } else {
            if (this.f9576u) {
                this.f9578w = SystemClock.uptimeMillis();
            }
            int i10 = (int) (this.f9578w - this.f9577v);
            int i11 = i10 / duration;
            int i12 = this.f9579x;
            if (i12 == -1 || i11 <= i12) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                duration = i10 - (i11 * duration);
            }
        }
        movie.setTime(duration);
        if (this.A) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Rect rect = this.f9569n;
            rect.set(0, 0, width, height);
            b(rect);
            int save = canvas.save();
            try {
                float f10 = ((float) 1) / this.f9572q;
                canvas.scale(f10, f10);
                a(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        } else {
            b(getBounds());
            a(canvas);
        }
        if (!this.f9576u || !z10) {
            stop();
        } else {
            invalidateSelf();
        }
    }

    public final int getIntrinsicHeight() {
        return this.f9563h.height();
    }

    public final int getIntrinsicWidth() {
        return this.f9563h.width();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r2.f9581z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getOpacity() {
        /*
            r2 = this;
            android.graphics.Paint r0 = r2.f9566k
            int r0 = r0.getAlpha()
            r1 = 255(0xff, float:3.57E-43)
            if (r0 != r1) goto L_0x001c
            int r0 = r2.f9581z
            r1 = 3
            if (r0 == r1) goto L_0x001a
            r1 = 1
            if (r0 != r1) goto L_0x001c
            android.graphics.Movie r0 = r2.f9563h
            boolean r0 = r0.isOpaque()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = -1
            goto L_0x001d
        L_0x001c:
            r0 = -3
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.b.getOpacity():int");
    }

    public final boolean isRunning() {
        return this.f9576u;
    }

    public final void setAlpha(int i10) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 256) {
            z10 = true;
        }
        if (z10) {
            this.f9566k.setAlpha(i10);
            return;
        }
        throw new IllegalArgumentException(h.i("Invalid alpha: ", i10).toString());
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9566k.setColorFilter(colorFilter);
    }

    public final void start() {
        if (!this.f9576u) {
            this.f9576u = true;
            this.f9577v = SystemClock.uptimeMillis();
            ArrayList arrayList = this.f9567l;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((c) arrayList.get(i10)).b(this);
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.f9576u) {
            this.f9576u = false;
            ArrayList arrayList = this.f9567l;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((c) arrayList.get(i10)).a(this);
            }
        }
    }
}

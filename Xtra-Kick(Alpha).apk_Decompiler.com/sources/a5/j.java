package a5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.support.v4.media.h;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpImage;
import java.nio.ByteBuffer;
import y4.a;
import y4.c;

public final class j implements a {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f154a;

    /* renamed from: b  reason: collision with root package name */
    public WebpImage f155b;

    /* renamed from: c  reason: collision with root package name */
    public final k5.a f156c;

    /* renamed from: d  reason: collision with root package name */
    public int f157d = -1;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f158e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bumptech.glide.integration.webp.a[] f159f;

    /* renamed from: g  reason: collision with root package name */
    public int f160g;

    /* renamed from: h  reason: collision with root package name */
    public int f161h;

    /* renamed from: i  reason: collision with root package name */
    public int f162i;

    /* renamed from: j  reason: collision with root package name */
    public final Paint f163j;

    /* renamed from: k  reason: collision with root package name */
    public final r f164k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap.Config f165l = Bitmap.Config.ARGB_8888;

    /* renamed from: m  reason: collision with root package name */
    public final i f166m;

    public j(k5.a aVar, WebpImage webpImage, ByteBuffer byteBuffer, int i10, r rVar) {
        boolean z10;
        int i11;
        this.f156c = aVar;
        this.f155b = webpImage;
        this.f158e = webpImage.getFrameDurations();
        this.f159f = new com.bumptech.glide.integration.webp.a[webpImage.getFrameCount()];
        for (int i12 = 0; i12 < this.f155b.getFrameCount(); i12++) {
            this.f159f[i12] = this.f155b.getFrameInfo(i12);
            if (Log.isLoggable("WebpDecoder", 3)) {
                this.f159f[i12].toString();
            }
        }
        this.f164k = rVar;
        Paint paint = new Paint();
        this.f163j = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        if (rVar.f189a == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i11 = webpImage.getFrameCount();
        } else {
            i11 = Math.max(5, 0);
        }
        this.f166m = new i(this, i11);
        new c();
        if (i10 > 0) {
            int highestOneBit = Integer.highestOneBit(i10);
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f154a = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f160g = highestOneBit;
            this.f162i = this.f155b.getWidth() / highestOneBit;
            this.f161h = this.f155b.getHeight() / highestOneBit;
            return;
        }
        throw new IllegalArgumentException(h.i("Sample size must be >=0, not: ", i10));
    }

    public final int a() {
        return this.f157d;
    }

    public final Bitmap b() {
        int i10;
        Bitmap bitmap;
        int i11 = this.f157d;
        int i12 = this.f162i;
        int i13 = this.f161h;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        k5.a aVar = this.f156c;
        Bitmap d10 = ((e5.c) aVar.f9124i).d(i12, i13, config);
        d10.eraseColor(0);
        if (Build.VERSION.SDK_INT >= 24) {
            d10.setDensity(DisplayMetrics.DENSITY_DEVICE_STABLE);
        }
        Canvas canvas = new Canvas(d10);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        boolean z10 = true;
        if (this.f164k.f189a != 1) {
            z10 = false;
        }
        i iVar = this.f166m;
        if (z10 || (bitmap = (Bitmap) iVar.get(Integer.valueOf(i11))) == null) {
            boolean i14 = i(i11);
            com.bumptech.glide.integration.webp.a[] aVarArr = this.f159f;
            if (!i14) {
                i10 = i11 - 1;
                while (true) {
                    if (i10 < 0) {
                        i10 = 0;
                        break;
                    }
                    com.bumptech.glide.integration.webp.a aVar2 = aVarArr[i10];
                    if (aVar2.f3206h && h(aVar2)) {
                        break;
                    }
                    Bitmap bitmap2 = (Bitmap) iVar.get(Integer.valueOf(i10));
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        bitmap2.setDensity(canvas.getDensity());
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        if (aVar2.f3206h) {
                            g(canvas, aVar2);
                        }
                    } else if (i(i10)) {
                        break;
                    } else {
                        i10--;
                    }
                }
                i10++;
            } else {
                i10 = i11;
            }
            Log.isLoggable("WebpDecoder", 3);
            while (i10 < i11) {
                com.bumptech.glide.integration.webp.a aVar3 = aVarArr[i10];
                if (!aVar3.f3205g) {
                    g(canvas, aVar3);
                }
                j(i10, canvas);
                Log.isLoggable("WebpDecoder", 3);
                if (aVar3.f3206h) {
                    g(canvas, aVar3);
                }
                i10++;
            }
            com.bumptech.glide.integration.webp.a aVar4 = aVarArr[i11];
            if (!aVar4.f3205g) {
                g(canvas, aVar4);
            }
            j(i11, canvas);
            Log.isLoggable("WebpDecoder", 3);
            iVar.remove(Integer.valueOf(i11));
            Bitmap d11 = ((e5.c) aVar.f9124i).d(d10.getWidth(), d10.getHeight(), d10.getConfig());
            d11.eraseColor(0);
            d11.setDensity(d10.getDensity());
            Canvas canvas2 = new Canvas(d11);
            canvas2.drawColor(0, PorterDuff.Mode.SRC);
            canvas2.drawBitmap(d10, 0.0f, 0.0f, (Paint) null);
            iVar.put(Integer.valueOf(i11), d11);
            return d10;
        }
        Log.isLoggable("WebpDecoder", 3);
        bitmap.setDensity(canvas.getDensity());
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return d10;
    }

    public final void c() {
        this.f157d = (this.f157d + 1) % this.f155b.getFrameCount();
    }

    public final void clear() {
        this.f155b.dispose();
        this.f155b = null;
        this.f166m.evictAll();
        this.f154a = null;
    }

    public final int d() {
        return this.f155b.getFrameCount();
    }

    public final int e() {
        int i10;
        int[] iArr = this.f158e;
        if (iArr.length == 0 || (i10 = this.f157d) < 0) {
            return 0;
        }
        if (i10 < 0 || i10 >= iArr.length) {
            return -1;
        }
        return iArr[i10];
    }

    public final int f() {
        return this.f155b.getSizeInBytes();
    }

    public final void g(Canvas canvas, com.bumptech.glide.integration.webp.a aVar) {
        int i10 = this.f160g;
        int i11 = aVar.f3200b;
        int i12 = aVar.f3201c;
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) (i11 / i10), (float) (i12 / i10), (float) ((i11 + aVar.f3202d) / i10), (float) ((i12 + aVar.f3203e) / i10), this.f163j);
    }

    public final ByteBuffer getData() {
        return this.f154a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r2.f155b.getWidth();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r2.f155b.getHeight();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(com.bumptech.glide.integration.webp.a r3) {
        /*
            r2 = this;
            int r0 = r3.f3200b
            if (r0 != 0) goto L_0x001e
            int r0 = r3.f3201c
            if (r0 != 0) goto L_0x001e
            com.bumptech.glide.integration.webp.WebpImage r0 = r2.f155b
            int r0 = r0.getWidth()
            int r1 = r3.f3202d
            if (r1 != r0) goto L_0x001e
            com.bumptech.glide.integration.webp.WebpImage r0 = r2.f155b
            int r0 = r0.getHeight()
            int r3 = r3.f3203e
            if (r3 != r0) goto L_0x001e
            r3 = 1
            goto L_0x001f
        L_0x001e:
            r3 = 0
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.j.h(com.bumptech.glide.integration.webp.a):boolean");
    }

    public final boolean i(int i10) {
        if (i10 == 0) {
            return true;
        }
        com.bumptech.glide.integration.webp.a[] aVarArr = this.f159f;
        com.bumptech.glide.integration.webp.a aVar = aVarArr[i10];
        com.bumptech.glide.integration.webp.a aVar2 = aVarArr[i10 - 1];
        if (aVar.f3205g || !h(aVar)) {
            return aVar2.f3206h && h(aVar2);
        }
        return true;
    }

    public final void j(int i10, Canvas canvas) {
        k5.a aVar = this.f156c;
        com.bumptech.glide.integration.webp.a aVar2 = this.f159f[i10];
        int i11 = aVar2.f3202d;
        int i12 = this.f160g;
        int i13 = i11 / i12;
        int i14 = aVar2.f3203e / i12;
        int i15 = aVar2.f3200b / i12;
        int i16 = aVar2.f3201c / i12;
        if (i13 != 0 && i14 != 0) {
            WebpFrame frame = this.f155b.getFrame(i10);
            try {
                Bitmap d10 = ((e5.c) aVar.f9124i).d(i13, i14, this.f165l);
                d10.eraseColor(0);
                d10.setDensity(canvas.getDensity());
                frame.renderFrame(i13, i14, d10);
                canvas.drawBitmap(d10, (float) i15, (float) i16, (Paint) null);
                ((e5.c) aVar.f9124i).c(d10);
            } catch (IllegalArgumentException | IllegalStateException unused) {
                Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + i10);
            } catch (Throwable th) {
                frame.dispose();
                throw th;
            }
            frame.dispose();
        }
    }
}

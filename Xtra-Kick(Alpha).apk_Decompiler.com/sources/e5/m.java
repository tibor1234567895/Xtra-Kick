package e5;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class m implements c {

    /* renamed from: f  reason: collision with root package name */
    public static final Bitmap.Config f5057f = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    public final n f5058a;

    /* renamed from: b  reason: collision with root package name */
    public final Set f5059b;

    /* renamed from: c  reason: collision with root package name */
    public final l f5060c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5061d;

    /* renamed from: e  reason: collision with root package name */
    public long f5062e;

    public m(long j10) {
        s sVar = new s();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add((Object) null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f5061d = j10;
        this.f5058a = sVar;
        this.f5059b = unmodifiableSet;
        this.f5060c = new l();
    }

    public final void a(int i10) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i10 >= 40 || (Build.VERSION.SDK_INT >= 23 && i10 >= 20)) {
            e();
        } else if (i10 >= 20 || i10 == 15) {
            g(this.f5061d / 2);
        }
    }

    public final Bitmap b(int i10, int i11, Bitmap.Config config) {
        Bitmap f10 = f(i10, i11, config);
        if (f10 != null) {
            f10.eraseColor(0);
            return f10;
        }
        if (config == null) {
            config = f5057f;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public final synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f5058a.d(bitmap)) <= this.f5061d) {
                        if (this.f5059b.contains(bitmap.getConfig())) {
                            int d10 = this.f5058a.d(bitmap);
                            this.f5058a.c(bitmap);
                            this.f5060c.getClass();
                            this.f5062e += (long) d10;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                this.f5058a.f(bitmap);
                            }
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Objects.toString(this.f5058a);
                            }
                            g(this.f5061d);
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        this.f5058a.f(bitmap);
                        bitmap.isMutable();
                        this.f5059b.contains(bitmap.getConfig());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public final Bitmap d(int i10, int i11, Bitmap.Config config) {
        Bitmap f10 = f(i10, i11, config);
        if (f10 != null) {
            return f10;
        }
        if (config == null) {
            config = f5057f;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public final void e() {
        Log.isLoggable("LruBitmapPool", 3);
        g(0);
    }

    public final synchronized Bitmap f(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap b10;
        if (Build.VERSION.SDK_INT >= 26) {
            if (config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
        }
        n nVar = this.f5058a;
        if (config != null) {
            config2 = config;
        } else {
            config2 = f5057f;
        }
        b10 = nVar.b(i10, i11, config2);
        if (b10 != null) {
            this.f5062e -= (long) this.f5058a.d(b10);
            this.f5060c.getClass();
            b10.setHasAlpha(true);
            b10.setPremultiplied(true);
        } else if (Log.isLoggable("LruBitmapPool", 3)) {
            this.f5058a.a(i10, i11, config);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            this.f5058a.a(i10, i11, config);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Objects.toString(this.f5058a);
        }
        return b10;
    }

    public final synchronized void g(long j10) {
        while (this.f5062e > j10) {
            Bitmap e10 = this.f5058a.e();
            if (e10 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    Objects.toString(this.f5058a);
                }
                this.f5062e = 0;
                return;
            }
            this.f5060c.getClass();
            this.f5062e -= (long) this.f5058a.d(e10);
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.f5058a.f(e10);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Objects.toString(this.f5058a);
            }
            e10.recycle();
        }
    }
}

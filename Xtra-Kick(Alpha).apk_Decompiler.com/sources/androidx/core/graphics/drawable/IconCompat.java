package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import f0.f;
import f0.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f1210k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f1211a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1212b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1213c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1214d;

    /* renamed from: e  reason: collision with root package name */
    public int f1215e;

    /* renamed from: f  reason: collision with root package name */
    public int f1216f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f1217g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f1218h;

    /* renamed from: i  reason: collision with root package name */
    public String f1219i;

    /* renamed from: j  reason: collision with root package name */
    public String f1220j;

    public IconCompat() {
        this.f1211a = -1;
        this.f1213c = null;
        this.f1214d = null;
        this.f1215e = 0;
        this.f1216f = 0;
        this.f1217g = null;
        this.f1218h = f1210k;
        this.f1219i = null;
    }

    public static Bitmap a(Bitmap bitmap) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = ((float) min) * 0.5f;
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f10, f10, 0.9166667f * f10, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat f(Resources resources, String str, int i10) {
        str.getClass();
        if (i10 != 0) {
            IconCompat iconCompat = new IconCompat(0);
            iconCompat.f1215e = i10;
            if (resources != null) {
                try {
                    iconCompat.f1212b = resources.getResourceName(i10);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f1212b = str;
            }
            iconCompat.f1220j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public final int g() {
        int i10;
        int i11 = this.f1211a;
        if (i11 == -1 && (i10 = Build.VERSION.SDK_INT) >= 23) {
            Object obj = this.f1212b;
            if (i10 >= 28) {
                return i.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            }
        } else if (i11 == 2) {
            return this.f1215e;
        } else {
            throw new IllegalStateException("called getResId() on " + this);
        }
    }

    public final String h() {
        int i10;
        int i11 = this.f1211a;
        if (i11 == -1 && (i10 = Build.VERSION.SDK_INT) >= 23) {
            Object obj = this.f1212b;
            if (i10 >= 28) {
                return i.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            }
        } else if (i11 == 2) {
            String str = this.f1220j;
            if (str == null || TextUtils.isEmpty(str)) {
                return ((String) this.f1212b).split(Constants.EXT_TAG_END, -1)[0];
            }
            return this.f1220j;
        } else {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
    }

    public final Uri i() {
        int i10 = this.f1211a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return f.a(this.f1212b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f1212b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final InputStream j(Context context) {
        StringBuilder sb2;
        Uri i10 = i();
        String scheme = i10.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(i10);
            } catch (Exception e10) {
                e = e10;
                sb2 = new StringBuilder("Unable to load image from URI: ");
                sb2.append(i10);
                Log.w("IconCompat", sb2.toString(), e);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f1212b));
            } catch (FileNotFoundException e11) {
                e = e11;
                sb2 = new StringBuilder("Unable to load image from path: ");
                sb2.append(i10);
                Log.w("IconCompat", sb2.toString(), e);
                return null;
            }
        }
    }

    public final Icon k(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return f.c(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f1211a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.f1212b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f1211a
            switch(r1) {
                case 1: goto L_0x002a;
                case 2: goto L_0x0027;
                case 3: goto L_0x0024;
                case 4: goto L_0x0021;
                case 5: goto L_0x001e;
                case 6: goto L_0x001b;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.String r1 = "UNKNOWN"
            goto L_0x002c
        L_0x001b:
            java.lang.String r1 = "URI_MASKABLE"
            goto L_0x002c
        L_0x001e:
            java.lang.String r1 = "BITMAP_MASKABLE"
            goto L_0x002c
        L_0x0021:
            java.lang.String r1 = "URI"
            goto L_0x002c
        L_0x0024:
            java.lang.String r1 = "DATA"
            goto L_0x002c
        L_0x0027:
            java.lang.String r1 = "RESOURCE"
            goto L_0x002c
        L_0x002a:
            java.lang.String r1 = "BITMAP"
        L_0x002c:
            r0.append(r1)
            int r1 = r4.f1211a
            switch(r1) {
                case 1: goto L_0x007d;
                case 2: goto L_0x0056;
                case 3: goto L_0x0040;
                case 4: goto L_0x0035;
                case 5: goto L_0x007d;
                case 6: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x009d
        L_0x0035:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f1212b
            r0.append(r1)
            goto L_0x009d
        L_0x0040:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f1215e
            r0.append(r1)
            int r1 = r4.f1216f
            if (r1 == 0) goto L_0x009d
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f1216f
            goto L_0x009a
        L_0x0056:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.f1220j
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r2 = r4.g()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L_0x009d
        L_0x007d:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f1212b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f1212b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L_0x009a:
            r0.append(r1)
        L_0x009d:
            android.content.res.ColorStateList r1 = r4.f1217g
            if (r1 == 0) goto L_0x00ab
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f1217g
            r0.append(r1)
        L_0x00ab:
            android.graphics.PorterDuff$Mode r1 = r4.f1218h
            android.graphics.PorterDuff$Mode r2 = f1210k
            if (r1 == r2) goto L_0x00bb
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f1218h
            r0.append(r1)
        L_0x00bb:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    public IconCompat(int i10) {
        this.f1213c = null;
        this.f1214d = null;
        this.f1215e = 0;
        this.f1216f = 0;
        this.f1217g = null;
        this.f1218h = f1210k;
        this.f1219i = null;
        this.f1211a = 2;
    }
}

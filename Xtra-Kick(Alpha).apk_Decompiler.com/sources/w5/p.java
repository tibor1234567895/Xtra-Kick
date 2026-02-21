package w5;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Set;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f16126a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f16127b = new char[64];

    /* renamed from: c  reason: collision with root package name */
    public static volatile Handler f16128c;

    private p() {
    }

    public static void a() {
        boolean z10;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int c(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        } else {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
    }

    public static ArrayList d(Set set) {
        ArrayList arrayList = new ArrayList(set.size());
        for (Object next : set) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Handler e() {
        if (f16128c == null) {
            synchronized (p.class) {
                if (f16128c == null) {
                    f16128c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f16128c;
    }

    public static int f(int i10, Object obj) {
        return (i10 * 31) + (obj == null ? 0 : obj.hashCode());
    }

    public static int g(int i10, boolean z10) {
        return (i10 * 31) + (z10 ? 1 : 0);
    }

    public static boolean h(int i10, int i11) {
        if (!(i10 > 0 || i10 == Integer.MIN_VALUE)) {
            return false;
        }
        return i11 > 0 || i11 == Integer.MIN_VALUE;
    }
}

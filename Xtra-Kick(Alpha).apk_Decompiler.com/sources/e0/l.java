package e0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import d0.g;
import d0.h;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class l extends r {

    /* renamed from: b  reason: collision with root package name */
    public static Class f4867b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Constructor f4868c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f4869d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f4870e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f4871f = false;

    public static boolean g(Object obj, String str, int i10, boolean z10) {
        h();
        try {
            return ((Boolean) f4869d.invoke(obj, new Object[]{str, Integer.valueOf(i10), Boolean.valueOf(z10)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void h() {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        Method method2;
        if (!f4871f) {
            f4871f = true;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                constructor = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            } catch (ClassNotFoundException | NoSuchMethodException e10) {
                Log.e("TypefaceCompatApi21Impl", e10.getClass().getName(), e10);
                cls = null;
                method2 = null;
                constructor = null;
                method = null;
            }
            f4868c = constructor;
            f4867b = cls;
            f4869d = method;
            f4870e = method2;
        }
    }

    public Typeface a(Context context, g gVar, Resources resources, int i10) {
        h();
        try {
            Object newInstance = f4868c.newInstance(new Object[0]);
            h[] hVarArr = gVar.f4093a;
            int length = hVarArr.length;
            int i11 = 0;
            while (i11 < length) {
                h hVar = hVarArr[i11];
                File d10 = t.d(context);
                if (d10 == null) {
                    return null;
                }
                try {
                    if (!t.b(d10, resources, hVar.f4099f)) {
                        d10.delete();
                        return null;
                    } else if (!g(newInstance, d10.getPath(), hVar.f4095b, hVar.f4096c)) {
                        return null;
                    } else {
                        i11++;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    d10.delete();
                }
            }
            h();
            try {
                Object newInstance2 = Array.newInstance(f4867b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f4870e.invoke((Object) null, new Object[]{newInstance2});
            } catch (IllegalAccessException | InvocationTargetException e10) {
                throw new RuntimeException(e10);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a A[SYNTHETIC, Splitter:B:18:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface b(android.content.Context r4, j0.i[] r5, int r6) {
        /*
            r3 = this;
            int r0 = r5.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L_0x0006
            return r2
        L_0x0006:
            j0.i r5 = r3.f(r6, r5)
            android.content.ContentResolver r6 = r4.getContentResolver()
            android.net.Uri r5 = r5.f8397a     // Catch:{ IOException -> 0x0081 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r5 = r6.openFileDescriptor(r5, r0, r2)     // Catch:{ IOException -> 0x0081 }
            if (r5 != 0) goto L_0x001e
            if (r5 == 0) goto L_0x001d
            r5.close()     // Catch:{ IOException -> 0x0081 }
        L_0x001d:
            return r2
        L_0x001e:
            java.lang.String r6 = "/proc/self/fd/"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ErrnoException -> 0x0046 }
            r0.<init>(r6)     // Catch:{ ErrnoException -> 0x0046 }
            int r6 = r5.getFd()     // Catch:{ ErrnoException -> 0x0046 }
            r0.append(r6)     // Catch:{ ErrnoException -> 0x0046 }
            java.lang.String r6 = r0.toString()     // Catch:{ ErrnoException -> 0x0046 }
            java.lang.String r6 = android.system.Os.readlink(r6)     // Catch:{ ErrnoException -> 0x0046 }
            android.system.StructStat r0 = android.system.Os.stat(r6)     // Catch:{ ErrnoException -> 0x0046 }
            int r0 = r0.st_mode     // Catch:{ ErrnoException -> 0x0046 }
            boolean r0 = android.system.OsConstants.S_ISREG(r0)     // Catch:{ ErrnoException -> 0x0046 }
            if (r0 == 0) goto L_0x0047
            java.io.File r0 = new java.io.File     // Catch:{ ErrnoException -> 0x0046 }
            r0.<init>(r6)     // Catch:{ ErrnoException -> 0x0046 }
            goto L_0x0048
        L_0x0046:
        L_0x0047:
            r0 = r2
        L_0x0048:
            if (r0 == 0) goto L_0x0059
            boolean r6 = r0.canRead()     // Catch:{ all -> 0x0077 }
            if (r6 != 0) goto L_0x0051
            goto L_0x0059
        L_0x0051:
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r0)     // Catch:{ all -> 0x0077 }
            r5.close()     // Catch:{ IOException -> 0x0081 }
            return r4
        L_0x0059:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x0077 }
            java.io.FileDescriptor r0 = r5.getFileDescriptor()     // Catch:{ all -> 0x0077 }
            r6.<init>(r0)     // Catch:{ all -> 0x0077 }
            android.graphics.Typeface r4 = r3.c(r4, r6)     // Catch:{ all -> 0x006d }
            r6.close()     // Catch:{ all -> 0x0077 }
            r5.close()     // Catch:{ IOException -> 0x0081 }
            return r4
        L_0x006d:
            r4 = move-exception
            r6.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch:{ all -> 0x0077 }
        L_0x0076:
            throw r4     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r4 = move-exception
            r5.close()     // Catch:{ all -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r5 = move-exception
            r4.addSuppressed(r5)     // Catch:{ IOException -> 0x0081 }
        L_0x0080:
            throw r4     // Catch:{ IOException -> 0x0081 }
        L_0x0081:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.l.b(android.content.Context, j0.i[], int):android.graphics.Typeface");
    }
}

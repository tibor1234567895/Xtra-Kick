package e0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import d0.h;
import j0.i;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f4884a = new ConcurrentHashMap();

    public static Object e(Object[] objArr, int i10, q qVar) {
        int i11;
        boolean z10;
        int i12;
        boolean z11;
        int i13;
        if ((i10 & 1) == 0) {
            i11 = 400;
        } else {
            i11 = 700;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h hVar = null;
        int i14 = Integer.MAX_VALUE;
        for (i iVar : objArr) {
            int i15 = qVar.f4883h;
            switch (i15) {
                case 0:
                    i12 = iVar.f8399c;
                    break;
                default:
                    i12 = iVar.f4095b;
                    break;
            }
            int abs = Math.abs(i12 - i11) * 2;
            switch (i15) {
                case 0:
                    z11 = iVar.f8400d;
                    break;
                default:
                    z11 = iVar.f4096c;
                    break;
            }
            if (z11 == z10) {
                i13 = 0;
            } else {
                i13 = 1;
            }
            int i16 = abs + i13;
            if (hVar == null || i14 > i16) {
                hVar = iVar;
                i14 = i16;
            }
        }
        return hVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface a(android.content.Context r10, d0.g r11, android.content.res.Resources r12, int r13) {
        /*
            r9 = this;
            e0.q r0 = new e0.q
            r1 = 1
            r0.<init>(r1)
            d0.h[] r2 = r11.f4093a
            java.lang.Object r0 = e(r2, r13, r0)
            d0.h r0 = (d0.h) r0
            if (r0 != 0) goto L_0x0012
            r10 = 0
            return r10
        L_0x0012:
            int r8 = r0.f4099f
            java.lang.String r0 = r0.f4094a
            e0.r r2 = e0.k.f4865a
            r3 = r10
            r4 = r12
            r5 = r8
            r6 = r0
            r7 = r13
            android.graphics.Typeface r10 = r2.d(r3, r4, r5, r6, r7)
            if (r10 == 0) goto L_0x002d
            r2 = 0
            java.lang.String r12 = e0.k.b(r12, r8, r0, r2, r13)
            q.j r13 = e0.k.f4866b
            r13.c(r12, r10)
        L_0x002d:
            java.lang.String r12 = "Could not retrieve font from family."
            java.lang.String r13 = "TypefaceCompatBaseImpl"
            r2 = 0
            if (r10 != 0) goto L_0x0037
        L_0x0035:
            r12 = r2
            goto L_0x0054
        L_0x0037:
            java.lang.Class<android.graphics.Typeface> r0 = android.graphics.Typeface.class
            java.lang.String r4 = "native_instance"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x004f, IllegalAccessException -> 0x004d }
            r0.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x004f, IllegalAccessException -> 0x004d }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ NoSuchFieldException -> 0x004f, IllegalAccessException -> 0x004d }
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ NoSuchFieldException -> 0x004f, IllegalAccessException -> 0x004d }
            long r12 = r0.longValue()     // Catch:{ NoSuchFieldException -> 0x004f, IllegalAccessException -> 0x004d }
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            goto L_0x0050
        L_0x004f:
            r0 = move-exception
        L_0x0050:
            android.util.Log.e(r13, r12, r0)
            goto L_0x0035
        L_0x0054:
            int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0061
            java.util.concurrent.ConcurrentHashMap r0 = r9.f4884a
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r0.put(r12, r11)
        L_0x0061:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.r.a(android.content.Context, d0.g, android.content.res.Resources, int):android.graphics.Typeface");
    }

    public Typeface b(Context context, i[] iVarArr, int i10) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (iVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(f(i10, iVarArr).f8397a);
            try {
                Typeface c10 = c(context, inputStream);
                t.a(inputStream);
                return c10;
            } catch (IOException unused) {
                t.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                t.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            t.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            t.a(inputStream2);
            throw th;
        }
    }

    public Typeface c(Context context, InputStream inputStream) {
        File d10 = t.d(context);
        if (d10 == null) {
            return null;
        }
        try {
            if (!t.c(d10, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(d10.getPath());
            d10.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            d10.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        File d10 = t.d(context);
        if (d10 == null) {
            return null;
        }
        try {
            if (!t.b(d10, resources, i10)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(d10.getPath());
            d10.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            d10.delete();
        }
    }

    public i f(int i10, i[] iVarArr) {
        return (i) e(iVarArr, i10, new q(0));
    }
}

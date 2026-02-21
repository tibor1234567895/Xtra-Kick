package w4;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.MimeTypeMap;
import androidx.recyclerview.widget.RecyclerView;
import fb.w;
import fb.y;
import java.io.Closeable;
import java.io.File;
import la.g;
import pb.n0;
import pb.p0;
import t4.a;
import t4.c;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config[] f16080a;

    /* renamed from: b  reason: collision with root package name */
    public static final Bitmap.Config f16081b;

    /* renamed from: c  reason: collision with root package name */
    public static final p0 f16082c = new n0().b();

    static {
        int i10 = Build.VERSION.SDK_INT;
        f16080a = i10 >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        f16081b = i10 >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public static final void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final String b(MimeTypeMap mimeTypeMap, String str) {
        boolean z10;
        if (str == null || w.h(str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        String Q = y.Q(y.Q(str, '#'), '?');
        return mimeTypeMap.getMimeTypeFromExtension(y.K(y.K(Q, '/', Q), '.', ""));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: s4.u} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final s4.u c(android.view.View r4) {
        /*
            r0 = 2131361972(0x7f0a00b4, float:1.8343711E38)
            java.lang.Object r1 = r4.getTag(r0)
            boolean r2 = r1 instanceof s4.u
            r3 = 0
            if (r2 == 0) goto L_0x000f
            s4.u r1 = (s4.u) r1
            goto L_0x0010
        L_0x000f:
            r1 = r3
        L_0x0010:
            if (r1 != 0) goto L_0x0032
            monitor-enter(r4)
            java.lang.Object r1 = r4.getTag(r0)     // Catch:{ all -> 0x002f }
            boolean r2 = r1 instanceof s4.u     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x001e
            r3 = r1
            s4.u r3 = (s4.u) r3     // Catch:{ all -> 0x002f }
        L_0x001e:
            if (r3 == 0) goto L_0x0022
            r1 = r3
            goto L_0x002d
        L_0x0022:
            s4.u r1 = new s4.u     // Catch:{ all -> 0x002f }
            r1.<init>(r4)     // Catch:{ all -> 0x002f }
            r4.addOnAttachStateChangeListener(r1)     // Catch:{ all -> 0x002f }
            r4.setTag(r0, r1)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r4)
            goto L_0x0032
        L_0x002f:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.e.c(android.view.View):s4.u");
    }

    public static final File d(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            cacheDir.mkdirs();
            return cacheDir;
        }
        throw new IllegalStateException("cacheDir == null".toString());
    }

    public static final int e(c cVar, int i10) {
        if (cVar instanceof a) {
            return ((a) cVar).f14542a;
        }
        if (i10 != 0) {
            int i11 = i10 - 1;
            if (i11 == 0) {
                return RecyclerView.UNDEFINED_DURATION;
            }
            if (i11 == 1) {
                return Integer.MAX_VALUE;
            }
            throw new g();
        }
        throw null;
    }
}

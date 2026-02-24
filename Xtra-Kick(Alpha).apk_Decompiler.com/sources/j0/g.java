package j0;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q.j;
import q.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f8391a = new j(16);

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadPoolExecutor f8392b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f8393c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final k f8394d = new k();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new l());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f8392b = threadPoolExecutor;
    }

    private g() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j0.f a(java.lang.String r7, android.content.Context r8, androidx.appcompat.widget.b0 r9, int r10) {
        /*
            q.j r0 = f8391a
            java.lang.Object r1 = r0.b(r7)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0010
            j0.f r7 = new j0.f
            r7.<init>((android.graphics.Typeface) r1)
            return r7
        L_0x0010:
            j0.h r9 = j0.c.a(r8, r9)     // Catch:{ NameNotFoundException -> 0x0062 }
            int r1 = r9.f8395h
            r2 = -3
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r3) goto L_0x001d
            goto L_0x0036
        L_0x001d:
            r1 = -2
            goto L_0x003f
        L_0x001f:
            java.lang.Object r1 = r9.f8396i
            j0.i[] r1 = (j0.i[]) r1
            if (r1 == 0) goto L_0x003e
            int r4 = r1.length
            if (r4 != 0) goto L_0x0029
            goto L_0x003e
        L_0x0029:
            int r3 = r1.length
            r4 = 0
            r5 = 0
        L_0x002c:
            if (r5 >= r3) goto L_0x003d
            r6 = r1[r5]
            int r6 = r6.f8401e
            if (r6 == 0) goto L_0x003a
            if (r6 >= 0) goto L_0x0038
        L_0x0036:
            r1 = -3
            goto L_0x003f
        L_0x0038:
            r1 = r6
            goto L_0x003f
        L_0x003a:
            int r5 = r5 + 1
            goto L_0x002c
        L_0x003d:
            r3 = 0
        L_0x003e:
            r1 = r3
        L_0x003f:
            if (r1 == 0) goto L_0x0047
            j0.f r7 = new j0.f
            r7.<init>((int) r1)
            return r7
        L_0x0047:
            java.lang.Object r9 = r9.f8396i
            j0.i[] r9 = (j0.i[]) r9
            e0.r r1 = e0.k.f4865a
            android.graphics.Typeface r8 = r1.b(r8, r9, r10)
            if (r8 == 0) goto L_0x005c
            r0.c(r7, r8)
            j0.f r7 = new j0.f
            r7.<init>((android.graphics.Typeface) r8)
            return r7
        L_0x005c:
            j0.f r7 = new j0.f
            r7.<init>((int) r2)
            return r7
        L_0x0062:
            j0.f r7 = new j0.f
            r8 = -1
            r7.<init>((int) r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.g.a(java.lang.String, android.content.Context, androidx.appcompat.widget.b0, int):j0.f");
    }
}

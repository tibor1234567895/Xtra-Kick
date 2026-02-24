package c5;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import b5.a;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e implements com.bumptech.glide.load.data.e {

    /* renamed from: h  reason: collision with root package name */
    public final Uri f2962h;

    /* renamed from: i  reason: collision with root package name */
    public final g f2963i;

    /* renamed from: j  reason: collision with root package name */
    public InputStream f2964j;

    public e(Uri uri, g gVar) {
        this.f2962h = uri;
        this.f2963i = gVar;
    }

    public static e b(Context context, Uri uri, f fVar) {
        return new e(uri, new g(c.a(context).f3166j.b().f(), fVar, c.a(context).f3167k, context.getContentResolver()));
    }

    public final Class a() {
        return InputStream.class;
    }

    public final void c() {
        InputStream inputStream = this.f2964j;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public final void cancel() {
    }

    public final a d() {
        return a.LOCAL;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|(1:18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r6 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (android.util.Log.isLoggable("ThumbStreamOpener", 3) != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        java.util.Objects.toString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r6 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (android.util.Log.isLoggable("ThumbStreamOpener", 3) != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0090, code lost:
        java.util.Objects.toString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009b, code lost:
        if (r4 != 0) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d0, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x008a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.InputStream e() {
        /*
            r12 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            android.net.Uri r1 = r12.f2962h
            c5.g r2 = r12.f2963i
            r2.getClass()
            r3 = 3
            r4 = 0
            r5 = 0
            c5.f r6 = r2.f2967b     // Catch:{ SecurityException -> 0x002c, all -> 0x0029 }
            android.database.Cursor r6 = r6.a(r1)     // Catch:{ SecurityException -> 0x002c, all -> 0x0029 }
            if (r6 == 0) goto L_0x0026
            boolean r7 = r6.moveToFirst()     // Catch:{ SecurityException -> 0x002d }
            if (r7 == 0) goto L_0x0026
            java.lang.String r7 = r6.getString(r5)     // Catch:{ SecurityException -> 0x002d }
            r6.close()
            goto L_0x003c
        L_0x0022:
            r0 = move-exception
            r4 = r6
            goto L_0x00ce
        L_0x0026:
            if (r6 == 0) goto L_0x003b
            goto L_0x0038
        L_0x0029:
            r0 = move-exception
            goto L_0x00ce
        L_0x002c:
            r6 = r4
        L_0x002d:
            boolean r7 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0036
            java.util.Objects.toString(r1)     // Catch:{ all -> 0x0022 }
        L_0x0036:
            if (r6 == 0) goto L_0x003b
        L_0x0038:
            r6.close()
        L_0x003b:
            r7 = r4
        L_0x003c:
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            if (r6 == 0) goto L_0x0044
        L_0x0042:
            r5 = r4
            goto L_0x006c
        L_0x0044:
            c5.a r6 = r2.f2966a
            r6.getClass()
            java.io.File r6 = new java.io.File
            r6.<init>(r7)
            boolean r7 = r6.exists()
            if (r7 == 0) goto L_0x005f
            long r7 = r6.length()
            r9 = 0
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x005f
            r5 = 1
        L_0x005f:
            if (r5 != 0) goto L_0x0062
            goto L_0x0042
        L_0x0062:
            android.net.Uri r5 = android.net.Uri.fromFile(r6)
            android.content.ContentResolver r6 = r2.f2969d     // Catch:{ NullPointerException -> 0x00ab }
            java.io.InputStream r5 = r6.openInputStream(r5)     // Catch:{ NullPointerException -> 0x00ab }
        L_0x006c:
            r6 = -1
            if (r5 == 0) goto L_0x00a1
            r2.getClass()
            android.content.ContentResolver r7 = r2.f2969d     // Catch:{ IOException | NullPointerException -> 0x008a }
            java.io.InputStream r4 = r7.openInputStream(r1)     // Catch:{ IOException | NullPointerException -> 0x008a }
            java.util.List r7 = r2.f2970e     // Catch:{ IOException | NullPointerException -> 0x008a }
            e5.k r2 = r2.f2968c     // Catch:{ IOException | NullPointerException -> 0x008a }
            int r0 = b5.i.a(r2, r4, r7)     // Catch:{ IOException | NullPointerException -> 0x008a }
            if (r4 == 0) goto L_0x00a2
            r4.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x00a2
        L_0x0086:
            goto L_0x00a2
        L_0x0088:
            r0 = move-exception
            goto L_0x009b
        L_0x008a:
            boolean r0 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0093
            java.util.Objects.toString(r1)     // Catch:{ all -> 0x0088 }
        L_0x0093:
            if (r4 == 0) goto L_0x00a1
            r4.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x00a1
        L_0x0099:
            goto L_0x00a1
        L_0x009b:
            if (r4 == 0) goto L_0x00a0
            r4.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x00a0:
            throw r0
        L_0x00a1:
            r0 = -1
        L_0x00a2:
            if (r0 == r6) goto L_0x00aa
            com.bumptech.glide.load.data.j r1 = new com.bumptech.glide.load.data.j
            r1.<init>(r5, r0)
            r5 = r1
        L_0x00aa:
            return r5
        L_0x00ab:
            r0 = move-exception
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "NPE opening uri: "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " -> "
            r3.append(r1)
            r3.append(r5)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            java.lang.Throwable r0 = r2.initCause(r0)
            java.io.FileNotFoundException r0 = (java.io.FileNotFoundException) r0
            throw r0
        L_0x00ce:
            if (r4 == 0) goto L_0x00d3
            r4.close()
        L_0x00d3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.e.e():java.io.InputStream");
    }

    public final void f(j jVar, d dVar) {
        try {
            InputStream e10 = e();
            this.f2964j = e10;
            dVar.g(e10);
        } catch (FileNotFoundException e11) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            dVar.e(e11);
        }
    }
}

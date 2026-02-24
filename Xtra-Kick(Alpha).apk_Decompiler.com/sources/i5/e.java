package i5;

import android.content.Context;
import android.net.Uri;
import b5.a;
import b5.n;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import h5.i0;
import java.io.FileNotFoundException;

public final class e implements com.bumptech.glide.load.data.e {

    /* renamed from: r  reason: collision with root package name */
    public static final String[] f8284r = {"_data"};

    /* renamed from: h  reason: collision with root package name */
    public final Context f8285h;

    /* renamed from: i  reason: collision with root package name */
    public final i0 f8286i;

    /* renamed from: j  reason: collision with root package name */
    public final i0 f8287j;

    /* renamed from: k  reason: collision with root package name */
    public final Uri f8288k;

    /* renamed from: l  reason: collision with root package name */
    public final int f8289l;

    /* renamed from: m  reason: collision with root package name */
    public final int f8290m;

    /* renamed from: n  reason: collision with root package name */
    public final n f8291n;

    /* renamed from: o  reason: collision with root package name */
    public final Class f8292o;

    /* renamed from: p  reason: collision with root package name */
    public volatile boolean f8293p;

    /* renamed from: q  reason: collision with root package name */
    public volatile com.bumptech.glide.load.data.e f8294q;

    public e(Context context, i0 i0Var, i0 i0Var2, Uri uri, int i10, int i11, n nVar, Class cls) {
        this.f8285h = context.getApplicationContext();
        this.f8286i = i0Var;
        this.f8287j = i0Var2;
        this.f8288k = uri;
        this.f8289l = i10;
        this.f8290m = i11;
        this.f8291n = nVar;
        this.f8292o = cls;
    }

    public final Class a() {
        return this.f8292o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.load.data.e b() {
        /*
            r14 = this;
            boolean r0 = android.os.Environment.isExternalStorageLegacy()
            r1 = 0
            b5.n r2 = r14.f8291n
            int r3 = r14.f8290m
            int r4 = r14.f8289l
            android.content.Context r5 = r14.f8285h
            if (r0 == 0) goto L_0x0078
            android.net.Uri r0 = r14.f8288k
            java.lang.String r12 = "File path was empty in media store for: "
            java.lang.String r13 = "Failed to media store entry for: "
            android.content.ContentResolver r6 = r5.getContentResolver()     // Catch:{ all -> 0x0071 }
            java.lang.String[] r8 = f8284r     // Catch:{ all -> 0x0071 }
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r0
            android.database.Cursor r5 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0071 }
            if (r5 == 0) goto L_0x005c
            boolean r6 = r5.moveToFirst()     // Catch:{ all -> 0x006e }
            if (r6 == 0) goto L_0x005c
            java.lang.String r6 = "_data"
            int r6 = r5.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x006e }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ all -> 0x006e }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x006e }
            if (r7 != 0) goto L_0x004a
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x006e }
            r0.<init>(r6)     // Catch:{ all -> 0x006e }
            r5.close()
            h5.i0 r5 = r14.f8286i
            h5.h0 r0 = r5.a(r0, r4, r3, r2)
            goto L_0x008f
        L_0x004a:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r2.<init>(r12)     // Catch:{ all -> 0x006e }
            r2.append(r0)     // Catch:{ all -> 0x006e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x006e }
            r1.<init>(r0)     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x005c:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r2.<init>(r13)     // Catch:{ all -> 0x006e }
            r2.append(r0)     // Catch:{ all -> 0x006e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x006e }
            r1.<init>(r0)     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x006e:
            r0 = move-exception
            r1 = r5
            goto L_0x0072
        L_0x0071:
            r0 = move-exception
        L_0x0072:
            if (r1 == 0) goto L_0x0077
            r1.close()
        L_0x0077:
            throw r0
        L_0x0078:
            int r0 = r5.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION")
            if (r0 != 0) goto L_0x0080
            r0 = 1
            goto L_0x0081
        L_0x0080:
            r0 = 0
        L_0x0081:
            android.net.Uri r5 = r14.f8288k
            if (r0 == 0) goto L_0x0089
            android.net.Uri r5 = android.provider.MediaStore.setRequireOriginal(r5)
        L_0x0089:
            h5.i0 r0 = r14.f8287j
            h5.h0 r0 = r0.a(r5, r4, r3, r2)
        L_0x008f:
            if (r0 == 0) goto L_0x0093
            com.bumptech.glide.load.data.e r1 = r0.f7577c
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.e.b():com.bumptech.glide.load.data.e");
    }

    public final void c() {
        com.bumptech.glide.load.data.e eVar = this.f8294q;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final void cancel() {
        this.f8293p = true;
        com.bumptech.glide.load.data.e eVar = this.f8294q;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public final a d() {
        return a.LOCAL;
    }

    public final void f(j jVar, d dVar) {
        try {
            com.bumptech.glide.load.data.e b10 = b();
            if (b10 == null) {
                dVar.e(new IllegalArgumentException("Failed to build fetcher for: " + this.f8288k));
                return;
            }
            this.f8294q = b10;
            if (this.f8293p) {
                cancel();
            } else {
                b10.f(jVar, dVar);
            }
        } catch (FileNotFoundException e10) {
            dVar.e(e10);
        }
    }
}

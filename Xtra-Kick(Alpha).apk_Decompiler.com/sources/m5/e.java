package m5;

import android.content.Context;
import android.net.Uri;
import b5.m;
import b5.n;
import b5.p;
import d5.o0;

public final class e implements p {

    /* renamed from: b  reason: collision with root package name */
    public static final m f10607b = new m("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme", (Object) null, m.f2630e);

    /* renamed from: a  reason: collision with root package name */
    public final Context f10608a;

    public e(Context context) {
        this.f10608a = context.getApplicationContext();
    }

    public final boolean a(Object obj, n nVar) {
        String scheme = ((Uri) obj).getScheme();
        if (scheme == null || !scheme.equals("android.resource")) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ o0 b(Object obj, int i10, int i11, n nVar) {
        return c((Uri) obj, nVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final d5.o0 c(android.net.Uri r9, b5.n r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getAuthority()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x00eb
            android.content.Context r1 = r8.f10608a
            java.lang.String r2 = r1.getPackageName()
            boolean r2 = r0.equals(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0018
            goto L_0x0028
        L_0x0018:
            android.content.Context r2 = r1.createPackageContext(r0, r3)     // Catch:{ NameNotFoundException -> 0x001d }
            goto L_0x0029
        L_0x001d:
            r2 = move-exception
            java.lang.String r4 = r1.getPackageName()
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00d7
        L_0x0028:
            r2 = r1
        L_0x0029:
            java.util.List r4 = r9.getPathSegments()
            int r5 = r4.size()
            r6 = 2
            r7 = 1
            if (r5 != r6) goto L_0x0074
            java.util.List r4 = r9.getPathSegments()
            java.lang.String r5 = r9.getAuthority()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r4.get(r7)
            java.lang.String r4 = (java.lang.String) r4
            android.content.res.Resources r6 = r2.getResources()
            int r5 = r6.getIdentifier(r4, r3, r5)
            if (r5 != 0) goto L_0x005d
            android.content.res.Resources r5 = android.content.res.Resources.getSystem()
            java.lang.String r6 = "android"
            int r5 = r5.getIdentifier(r4, r3, r6)
        L_0x005d:
            if (r5 == 0) goto L_0x0060
            goto L_0x008a
        L_0x0060:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to find resource id for: "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9)
            throw r10
        L_0x0074:
            int r4 = r4.size()
            java.lang.String r5 = "Unrecognized Uri format: "
            if (r4 != r7) goto L_0x00c5
            java.util.List r4 = r9.getPathSegments()
            java.lang.Object r3 = r4.get(r3)     // Catch:{ NumberFormatException -> 0x00b2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x00b2 }
            int r5 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00b2 }
        L_0x008a:
            java.lang.String r9 = r1.getPackageName()
            boolean r9 = r0.equals(r9)
            r0 = 0
            if (r9 == 0) goto L_0x009e
            b5.m r9 = f10607b
            java.lang.Object r9 = r10.c(r9)
            android.content.res.Resources$Theme r9 = (android.content.res.Resources.Theme) r9
            goto L_0x009f
        L_0x009e:
            r9 = r0
        L_0x009f:
            if (r9 != 0) goto L_0x00a6
            android.graphics.drawable.Drawable r9 = m5.b.a(r1, r2, r5, r0)
            goto L_0x00aa
        L_0x00a6:
            android.graphics.drawable.Drawable r9 = m5.b.a(r1, r1, r5, r9)
        L_0x00aa:
            if (r9 == 0) goto L_0x00b1
            a5.p r0 = new a5.p
            r0.<init>(r9, r7)
        L_0x00b1:
            return r0
        L_0x00b2:
            r10 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9, r10)
            throw r0
        L_0x00c5:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9)
            throw r10
        L_0x00d7:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to obtain context or unrecognized Uri format for: "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9, r2)
            throw r10
        L_0x00eb:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Package name for "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = " is null or empty"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.e.c(android.net.Uri, b5.n):d5.o0");
    }
}

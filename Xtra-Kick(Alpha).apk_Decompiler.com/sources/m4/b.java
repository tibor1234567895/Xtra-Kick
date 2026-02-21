package m4;

import android.net.Uri;
import s4.m;

public final class b implements k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10569a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f10570b;

    /* renamed from: c  reason: collision with root package name */
    public final m f10571c;

    public /* synthetic */ b(Uri uri, m mVar, int i10) {
        this.f10569a = i10;
        this.f10570b = uri;
        this.f10571c = mVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(pa.e r12) {
        /*
            r11 = this;
            int r12 = r11.f10569a
            r0 = 3
            s4.m r1 = r11.f10571c
            android.net.Uri r2 = r11.f10570b
            r3 = 1
            switch(r12) {
                case 0: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0095
        L_0x000d:
            java.util.List r12 = r2.getPathSegments()
            java.lang.String r2 = "<this>"
            xa.j.f(r2, r12)
            int r2 = r12.size()
            int r2 = r2 - r3
            if (r2 > 0) goto L_0x0020
            ma.b0 r12 = ma.b0.f10801h
            goto L_0x002a
        L_0x0020:
            if (r2 != r3) goto L_0x002c
            java.lang.Object r12 = ma.z.z(r12)
            java.util.List r12 = ma.q.b(r12)
        L_0x002a:
            r5 = r12
            goto L_0x0059
        L_0x002c:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r2)
            boolean r2 = r12 instanceof java.util.RandomAccess
            if (r2 == 0) goto L_0x0046
            int r2 = r12.size()
            r5 = 1
        L_0x003a:
            if (r5 >= r2) goto L_0x0058
            java.lang.Object r6 = r12.get(r5)
            r4.add(r6)
            int r5 = r5 + 1
            goto L_0x003a
        L_0x0046:
            java.util.ListIterator r12 = r12.listIterator(r3)
        L_0x004a:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r12.next()
            r4.add(r2)
            goto L_0x004a
        L_0x0058:
            r5 = r4
        L_0x0059:
            java.lang.String r6 = "/"
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 62
            java.lang.String r12 = ma.z.y(r5, r6, r7, r8, r9, r10)
            m4.v r2 = new m4.v
            android.content.Context r4 = r1.f14276a
            android.content.res.AssetManager r4 = r4.getAssets()
            java.io.InputStream r4 = r4.open(r12)
            dc.d r4 = hb.h0.I1(r4)
            dc.i0 r4 = hb.h0.o(r4)
            j4.a r5 = new j4.a
            r5.<init>(r12)
            j4.h0 r6 = new j4.h0
            j4.f0 r7 = new j4.f0
            android.content.Context r1 = r1.f14276a
            r7.<init>(r1, r3)
            r6.<init>(r4, r7, r5)
            android.webkit.MimeTypeMap r1 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r12 = w4.e.b(r1, r12)
            r2.<init>(r6, r12, r0)
            return r2
        L_0x0095:
            android.content.Context r12 = r1.f14276a
            android.content.ContentResolver r12 = r12.getContentResolver()
            java.lang.String r4 = r2.getAuthority()
            java.lang.String r5 = "com.android.contacts"
            boolean r4 = xa.j.a(r4, r5)
            r5 = 0
            if (r4 == 0) goto L_0x00b6
            java.lang.String r4 = r2.getLastPathSegment()
            java.lang.String r6 = "display_photo"
            boolean r4 = xa.j.a(r4, r6)
            if (r4 == 0) goto L_0x00b6
            r4 = 1
            goto L_0x00b7
        L_0x00b6:
            r4 = 0
        L_0x00b7:
            java.lang.String r6 = "'."
            r7 = 0
            if (r4 == 0) goto L_0x00e7
            java.lang.String r4 = "r"
            android.content.res.AssetFileDescriptor r4 = r12.openAssetFileDescriptor(r2, r4)
            if (r4 == 0) goto L_0x00c8
            java.io.FileInputStream r7 = r4.createInputStream()
        L_0x00c8:
            if (r7 == 0) goto L_0x00cc
            goto L_0x0180
        L_0x00cc:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to find a contact photo associated with '"
            r12.<init>(r0)
            r12.append(r2)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r12 = r12.toString()
            r0.<init>(r12)
            throw r0
        L_0x00e7:
            int r4 = android.os.Build.VERSION.SDK_INT
            r8 = 29
            if (r4 < r8) goto L_0x017a
            java.lang.String r4 = r2.getAuthority()
            java.lang.String r8 = "media"
            boolean r4 = xa.j.a(r4, r8)
            if (r4 != 0) goto L_0x00fa
            goto L_0x0121
        L_0x00fa:
            java.util.List r4 = r2.getPathSegments()
            int r8 = r4.size()
            if (r8 < r0) goto L_0x0121
            int r9 = r8 + -3
            java.lang.Object r9 = r4.get(r9)
            java.lang.String r10 = "audio"
            boolean r9 = xa.j.a(r9, r10)
            if (r9 == 0) goto L_0x0121
            int r8 = r8 + -2
            java.lang.Object r4 = r4.get(r8)
            java.lang.String r8 = "albums"
            boolean r4 = xa.j.a(r4, r8)
            if (r4 == 0) goto L_0x0121
            r5 = 1
        L_0x0121:
            if (r5 == 0) goto L_0x017a
            t4.g r4 = r1.f14279d
            t4.c r5 = r4.f14548a
            boolean r8 = r5 instanceof t4.a
            if (r8 == 0) goto L_0x012e
            t4.a r5 = (t4.a) r5
            goto L_0x012f
        L_0x012e:
            r5 = r7
        L_0x012f:
            if (r5 == 0) goto L_0x0151
            t4.c r4 = r4.f14549b
            boolean r8 = r4 instanceof t4.a
            if (r8 == 0) goto L_0x013a
            t4.a r4 = (t4.a) r4
            goto L_0x013b
        L_0x013a:
            r4 = r7
        L_0x013b:
            if (r4 == 0) goto L_0x0151
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>(r3)
            android.graphics.Point r9 = new android.graphics.Point
            int r5 = r5.f14542a
            int r4 = r4.f14542a
            r9.<init>(r5, r4)
            java.lang.String r4 = "android.content.extra.SIZE"
            r8.putParcelable(r4, r9)
            goto L_0x0152
        L_0x0151:
            r8 = r7
        L_0x0152:
            android.content.res.AssetFileDescriptor r4 = r12.openTypedAssetFile(r2, "image/*", r8, (android.os.CancellationSignal) null)
            if (r4 == 0) goto L_0x015c
            java.io.FileInputStream r7 = r4.createInputStream()
        L_0x015c:
            if (r7 == 0) goto L_0x015f
            goto L_0x0180
        L_0x015f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to find a music thumbnail associated with '"
            r12.<init>(r0)
            r12.append(r2)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r12 = r12.toString()
            r0.<init>(r12)
            throw r0
        L_0x017a:
            java.io.InputStream r7 = r12.openInputStream(r2)
            if (r7 == 0) goto L_0x01a3
        L_0x0180:
            m4.v r4 = new m4.v
            dc.d r5 = hb.h0.I1(r7)
            dc.i0 r5 = hb.h0.o(r5)
            j4.g r6 = new j4.g
            r6.<init>(r2)
            j4.h0 r7 = new j4.h0
            j4.f0 r8 = new j4.f0
            android.content.Context r1 = r1.f14276a
            r8.<init>(r1, r3)
            r7.<init>(r5, r8, r6)
            java.lang.String r12 = r12.getType(r2)
            r4.<init>(r7, r12, r0)
            return r4
        L_0x01a3:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to open '"
            r12.<init>(r0)
            r12.append(r2)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r12 = r12.toString()
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.b.a(pa.e):java.lang.Object");
    }
}

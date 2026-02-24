package m4;

import android.net.Uri;
import s4.m;

public final class u implements k {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f10598a;

    /* renamed from: b  reason: collision with root package name */
    public final m f10599b;

    static {
        new s(0);
    }

    public u(Uri uri, m mVar) {
        this.f10598a = uri;
        this.f10599b = mVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: c4.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: c4.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: c4.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(pa.e r10) {
        /*
            r9 = this;
            android.net.Uri r10 = r9.f10598a
            java.lang.String r0 = r10.getAuthority()
            java.lang.String r1 = "Invalid android.resource URI: "
            if (r0 == 0) goto L_0x0160
            boolean r2 = fb.w.h(r0)
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0160
            java.util.List r2 = r10.getPathSegments()
            java.lang.Object r2 = ma.z.A(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x014e
            java.lang.Integer r2 = fb.v.d(r2)
            if (r2 == 0) goto L_0x014e
            int r10 = r2.intValue()
            s4.m r1 = r9.f10599b
            android.content.Context r2 = r1.f14276a
            java.lang.String r4 = r2.getPackageName()
            boolean r4 = xa.j.a(r0, r4)
            if (r4 == 0) goto L_0x003f
            android.content.res.Resources r4 = r2.getResources()
            goto L_0x0047
        L_0x003f:
            android.content.pm.PackageManager r4 = r2.getPackageManager()
            android.content.res.Resources r4 = r4.getResourcesForApplication(r0)
        L_0x0047:
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            r4.getValue(r10, r5, r3)
            java.lang.CharSequence r5 = r5.string
            r6 = 47
            r7 = 6
            r8 = 0
            int r6 = fb.y.w(r5, r6, r8, r7)
            int r7 = r5.length()
            java.lang.CharSequence r5 = r5.subSequence(r6, r7)
            java.lang.String r5 = r5.toString()
            android.webkit.MimeTypeMap r6 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r5 = w4.e.b(r6, r5)
            java.lang.String r6 = "text/xml"
            boolean r6 = xa.j.a(r5, r6)
            r7 = 3
            if (r6 == 0) goto L_0x0125
            java.lang.String r5 = r2.getPackageName()
            boolean r0 = xa.j.a(r0, r5)
            if (r0 == 0) goto L_0x0085
            android.graphics.drawable.Drawable r10 = hb.h0.g0(r2, r10)
            goto L_0x00df
        L_0x0085:
            android.content.res.XmlResourceParser r0 = r4.getXml(r10)
        L_0x0089:
            int r5 = r0.next()
            r6 = 2
            if (r5 == r6) goto L_0x0093
            if (r5 == r3) goto L_0x0093
            goto L_0x0089
        L_0x0093:
            if (r5 != r6) goto L_0x011d
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 24
            if (r5 >= r6) goto L_0x00d2
            java.lang.String r5 = r0.getName()
            java.lang.String r6 = "vector"
            boolean r6 = xa.j.a(r5, r6)
            if (r6 == 0) goto L_0x00b9
            android.util.AttributeSet r10 = android.util.Xml.asAttributeSet(r0)
            android.content.res.Resources$Theme r5 = r2.getTheme()
            c4.s r6 = new c4.s
            r6.<init>()
            r6.inflate(r4, r0, r10, r5)
        L_0x00b7:
            r10 = r6
            goto L_0x00df
        L_0x00b9:
            java.lang.String r6 = "animated-vector"
            boolean r5 = xa.j.a(r5, r6)
            if (r5 == 0) goto L_0x00d2
            android.util.AttributeSet r10 = android.util.Xml.asAttributeSet(r0)
            android.content.res.Resources$Theme r5 = r2.getTheme()
            c4.f r6 = new c4.f
            r6.<init>(r2)
            r6.inflate(r4, r0, r10, r5)
            goto L_0x00b7
        L_0x00d2:
            android.content.res.Resources$Theme r0 = r2.getTheme()
            java.lang.ThreadLocal r5 = d0.s.f4115a
            android.graphics.drawable.Drawable r0 = d0.k.a(r4, r10, r0)
            if (r0 == 0) goto L_0x010d
            r10 = r0
        L_0x00df:
            boolean r0 = r10 instanceof android.graphics.drawable.VectorDrawable
            if (r0 != 0) goto L_0x00ea
            boolean r0 = r10 instanceof c4.s
            if (r0 == 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r3 = 0
        L_0x00ea:
            m4.h r0 = new m4.h
            if (r3 == 0) goto L_0x0109
            w4.g r4 = w4.g.f16085a
            r4.getClass()
            android.graphics.Bitmap$Config r4 = r1.f14277b
            t4.g r5 = r1.f14279d
            int r6 = r1.f14280e
            boolean r1 = r1.f14281f
            android.graphics.Bitmap r10 = w4.g.a(r10, r4, r5, r6, r1)
            android.content.res.Resources r1 = r2.getResources()
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            r2.<init>(r1, r10)
            r10 = r2
        L_0x0109:
            r0.<init>(r10, r3, r7)
            goto L_0x014d
        L_0x010d:
            java.lang.String r0 = "Invalid resource ID: "
            java.lang.String r10 = android.support.v4.media.h.i(r0, r10)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r10 = r10.toString()
            r0.<init>(r10)
            throw r0
        L_0x011d:
            org.xmlpull.v1.XmlPullParserException r10 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r0 = "No start tag found."
            r10.<init>(r0)
            throw r10
        L_0x0125:
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            java.io.InputStream r4 = r4.openRawResource(r10, r1)
            m4.v r6 = new m4.v
            dc.d r4 = hb.h0.I1(r4)
            dc.i0 r4 = hb.h0.o(r4)
            j4.g0 r8 = new j4.g0
            int r1 = r1.density
            r8.<init>(r0, r10, r1)
            j4.h0 r10 = new j4.h0
            j4.f0 r0 = new j4.f0
            r0.<init>(r2, r3)
            r10.<init>(r4, r0, r8)
            r6.<init>(r10, r5, r7)
            r0 = r6
        L_0x014d:
            return r0
        L_0x014e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r0.<init>(r10)
            throw r0
        L_0x0160:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.u.a(pa.e):java.lang.Object");
    }
}

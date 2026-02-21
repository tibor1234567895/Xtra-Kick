package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import q.i;
import q.k;
import q.l;

public final class q3 {

    /* renamed from: h  reason: collision with root package name */
    public static final PorterDuff.Mode f1012h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    public static q3 f1013i;

    /* renamed from: j  reason: collision with root package name */
    public static final m3 f1014j = new m3();

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap f1015a;

    /* renamed from: b  reason: collision with root package name */
    public k f1016b;

    /* renamed from: c  reason: collision with root package name */
    public l f1017c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakHashMap f1018d = new WeakHashMap(0);

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f1019e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1020f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f1021g;

    public static synchronized q3 d() {
        q3 q3Var;
        synchronized (q3.class) {
            if (f1013i == null) {
                q3 q3Var2 = new q3();
                f1013i = q3Var2;
                j(q3Var2);
            }
            q3Var = f1013i;
        }
        return q3Var;
    }

    public static synchronized PorterDuffColorFilter h(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (q3.class) {
            m3 m3Var = f1014j;
            m3Var.getClass();
            int i11 = (i10 + 31) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) m3Var.b(Integer.valueOf(mode.hashCode() + i11));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i10, mode);
                PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) m3Var.c(Integer.valueOf(mode.hashCode() + i11), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public static void j(q3 q3Var) {
        if (Build.VERSION.SDK_INT < 24) {
            q3Var.a("vector", new p3());
            q3Var.a("animated-vector", new l3());
            q3Var.a("animated-selector", new k3());
            q3Var.a("drawable", new n3());
        }
    }

    public final void a(String str, o3 o3Var) {
        if (this.f1016b == null) {
            this.f1016b = new k();
        }
        this.f1016b.put(str, o3Var);
    }

    public final synchronized void b(Context context, long j10, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            i iVar = (i) this.f1018d.get(context);
            if (iVar == null) {
                iVar = new i();
                this.f1018d.put(context, iVar);
            }
            iVar.g(j10, new WeakReference(constantState));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable c(android.content.Context r12, int r13) {
        /*
            r11 = this;
            android.util.TypedValue r0 = r11.f1019e
            if (r0 != 0) goto L_0x000b
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r11.f1019e = r0
        L_0x000b:
            android.util.TypedValue r0 = r11.f1019e
            android.content.res.Resources r1 = r12.getResources()
            r2 = 1
            r1.getValue(r13, r0, r2)
            int r1 = r0.assetCookie
            long r3 = (long) r1
            r1 = 32
            long r3 = r3 << r1
            int r1 = r0.data
            long r5 = (long) r1
            long r3 = r3 | r5
            android.graphics.drawable.Drawable r1 = r11.e(r12, r3)
            if (r1 == 0) goto L_0x0026
            return r1
        L_0x0026:
            androidx.appcompat.widget.g0 r1 = r11.f1021g
            if (r1 != 0) goto L_0x002c
            goto L_0x0104
        L_0x002c:
            r1 = 2131230776(0x7f080038, float:1.8077614E38)
            r5 = 0
            r6 = 2
            if (r13 != r1) goto L_0x004e
            android.graphics.drawable.LayerDrawable r13 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r1 = new android.graphics.drawable.Drawable[r6]
            r6 = 2131230775(0x7f080037, float:1.8077612E38)
            android.graphics.drawable.Drawable r6 = r11.f(r12, r6)
            r1[r5] = r6
            r5 = 2131230777(0x7f080039, float:1.8077616E38)
            android.graphics.drawable.Drawable r5 = r11.f(r12, r5)
            r1[r2] = r5
            r13.<init>(r1)
            goto L_0x0105
        L_0x004e:
            r1 = 2131230811(0x7f08005b, float:1.8077685E38)
            if (r13 != r1) goto L_0x0057
            r13 = 2131165243(0x7f07003b, float:1.7944698E38)
            goto L_0x0068
        L_0x0057:
            r1 = 2131230810(0x7f08005a, float:1.8077683E38)
            if (r13 != r1) goto L_0x0060
            r13 = 2131165244(0x7f07003c, float:1.79447E38)
            goto L_0x0068
        L_0x0060:
            r1 = 2131230812(0x7f08005c, float:1.8077687E38)
            if (r13 != r1) goto L_0x0104
            r13 = 2131165245(0x7f07003d, float:1.7944702E38)
        L_0x0068:
            android.content.res.Resources r1 = r12.getResources()
            int r13 = r1.getDimensionPixelSize(r13)
            r1 = 2131230823(0x7f080067, float:1.807771E38)
            android.graphics.drawable.Drawable r1 = r11.f(r12, r1)
            r7 = 2131230824(0x7f080068, float:1.8077712E38)
            android.graphics.drawable.Drawable r7 = r11.f(r12, r7)
            boolean r8 = r1 instanceof android.graphics.drawable.BitmapDrawable
            if (r8 == 0) goto L_0x009a
            int r8 = r1.getIntrinsicWidth()
            if (r8 != r13) goto L_0x009a
            int r8 = r1.getIntrinsicHeight()
            if (r8 != r13) goto L_0x009a
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            android.graphics.drawable.BitmapDrawable r8 = new android.graphics.drawable.BitmapDrawable
            android.graphics.Bitmap r9 = r1.getBitmap()
            r8.<init>(r9)
            goto L_0x00b6
        L_0x009a:
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r13, r13, r8)
            android.graphics.Canvas r9 = new android.graphics.Canvas
            r9.<init>(r8)
            r1.setBounds(r5, r5, r13, r13)
            r1.draw(r9)
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            r1.<init>(r8)
            android.graphics.drawable.BitmapDrawable r9 = new android.graphics.drawable.BitmapDrawable
            r9.<init>(r8)
            r8 = r9
        L_0x00b6:
            android.graphics.Shader$TileMode r9 = android.graphics.Shader.TileMode.REPEAT
            r8.setTileModeX(r9)
            boolean r9 = r7 instanceof android.graphics.drawable.BitmapDrawable
            if (r9 == 0) goto L_0x00ce
            int r9 = r7.getIntrinsicWidth()
            if (r9 != r13) goto L_0x00ce
            int r9 = r7.getIntrinsicHeight()
            if (r9 != r13) goto L_0x00ce
            android.graphics.drawable.BitmapDrawable r7 = (android.graphics.drawable.BitmapDrawable) r7
            goto L_0x00e4
        L_0x00ce:
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r13, r13, r9)
            android.graphics.Canvas r10 = new android.graphics.Canvas
            r10.<init>(r9)
            r7.setBounds(r5, r5, r13, r13)
            r7.draw(r10)
            android.graphics.drawable.BitmapDrawable r7 = new android.graphics.drawable.BitmapDrawable
            r7.<init>(r9)
        L_0x00e4:
            android.graphics.drawable.LayerDrawable r13 = new android.graphics.drawable.LayerDrawable
            r9 = 3
            android.graphics.drawable.Drawable[] r9 = new android.graphics.drawable.Drawable[r9]
            r9[r5] = r1
            r9[r2] = r7
            r9[r6] = r8
            r13.<init>(r9)
            r1 = 16908288(0x1020000, float:2.387723E-38)
            r13.setId(r5, r1)
            r1 = 16908303(0x102000f, float:2.387727E-38)
            r13.setId(r2, r1)
            r1 = 16908301(0x102000d, float:2.3877265E-38)
            r13.setId(r6, r1)
            goto L_0x0105
        L_0x0104:
            r13 = 0
        L_0x0105:
            if (r13 == 0) goto L_0x010f
            int r0 = r0.changingConfigurations
            r13.setChangingConfigurations(r0)
            r11.b(r12, r3, r13)
        L_0x010f:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q3.c(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable e(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap r0 = r3.f1018d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            q.i r0 = (q.i) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.e(r5, r1)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.h(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q3.e(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public final synchronized Drawable f(Context context, int i10) {
        return g(context, i10, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.graphics.PorterDuff$Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.graphics.PorterDuff$Mode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: android.graphics.PorterDuff$Mode} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r0 == false) goto L_0x01a8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a6 A[Catch:{ Exception -> 0x00d7, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cf A[Catch:{ Exception -> 0x00d7, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ea A[Catch:{ Exception -> 0x00d7, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f0 A[Catch:{ Exception -> 0x00d7, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f8 A[Catch:{ Exception -> 0x00d7, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0195 A[Catch:{ Exception -> 0x00d7, all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01a3 A[Catch:{ Exception -> 0x00d7, all -> 0x00cc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable g(android.content.Context r13, int r14, boolean r15) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.f1020f     // Catch:{ all -> 0x00cc }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0008
            goto L_0x002d
        L_0x0008:
            r12.f1020f = r2     // Catch:{ all -> 0x00cc }
            r0 = 2131230838(0x7f080076, float:1.807774E38)
            android.graphics.drawable.Drawable r0 = r12.f(r13, r0)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x01a8
            boolean r3 = r0 instanceof c4.s     // Catch:{ all -> 0x00cc }
            if (r3 != 0) goto L_0x002a
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = "android.graphics.drawable.VectorDrawable"
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r0 = 0
            goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x01a8
        L_0x002d:
            q.k r0 = r12.f1016b     // Catch:{ all -> 0x00cc }
            r3 = 0
            if (r0 == 0) goto L_0x00e7
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x00e7
            q.l r0 = r12.f1017c     // Catch:{ all -> 0x00cc }
            java.lang.String r4 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0056
            java.lang.Object r0 = r0.d(r14, r3)     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00cc }
            boolean r5 = r4.equals(r0)     // Catch:{ all -> 0x00cc }
            if (r5 != 0) goto L_0x00e7
            if (r0 == 0) goto L_0x005d
            q.k r5 = r12.f1016b     // Catch:{ all -> 0x00cc }
            java.lang.Object r0 = r5.getOrDefault(r0, r3)     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x005d
            goto L_0x00e7
        L_0x0056:
            q.l r0 = new q.l     // Catch:{ all -> 0x00cc }
            r0.<init>()     // Catch:{ all -> 0x00cc }
            r12.f1017c = r0     // Catch:{ all -> 0x00cc }
        L_0x005d:
            android.util.TypedValue r0 = r12.f1019e     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x0068
            android.util.TypedValue r0 = new android.util.TypedValue     // Catch:{ all -> 0x00cc }
            r0.<init>()     // Catch:{ all -> 0x00cc }
            r12.f1019e = r0     // Catch:{ all -> 0x00cc }
        L_0x0068:
            android.util.TypedValue r0 = r12.f1019e     // Catch:{ all -> 0x00cc }
            android.content.res.Resources r5 = r13.getResources()     // Catch:{ all -> 0x00cc }
            r5.getValue(r14, r0, r2)     // Catch:{ all -> 0x00cc }
            int r6 = r0.assetCookie     // Catch:{ all -> 0x00cc }
            long r6 = (long) r6     // Catch:{ all -> 0x00cc }
            r8 = 32
            long r6 = r6 << r8
            int r8 = r0.data     // Catch:{ all -> 0x00cc }
            long r8 = (long) r8     // Catch:{ all -> 0x00cc }
            long r6 = r6 | r8
            android.graphics.drawable.Drawable r8 = r12.e(r13, r6)     // Catch:{ all -> 0x00cc }
            if (r8 == 0) goto L_0x0082
            goto L_0x00e8
        L_0x0082:
            java.lang.CharSequence r9 = r0.string     // Catch:{ all -> 0x00cc }
            if (r9 == 0) goto L_0x00df
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00cc }
            java.lang.String r10 = ".xml"
            boolean r9 = r9.endsWith(r10)     // Catch:{ all -> 0x00cc }
            if (r9 == 0) goto L_0x00df
            android.content.res.XmlResourceParser r5 = r5.getXml(r14)     // Catch:{ Exception -> 0x00d7 }
            android.util.AttributeSet r9 = android.util.Xml.asAttributeSet(r5)     // Catch:{ Exception -> 0x00d7 }
        L_0x009a:
            int r10 = r5.next()     // Catch:{ Exception -> 0x00d7 }
            r11 = 2
            if (r10 == r11) goto L_0x00a4
            if (r10 == r2) goto L_0x00a4
            goto L_0x009a
        L_0x00a4:
            if (r10 != r11) goto L_0x00cf
            java.lang.String r10 = r5.getName()     // Catch:{ Exception -> 0x00d7 }
            q.l r11 = r12.f1017c     // Catch:{ Exception -> 0x00d7 }
            r11.a(r14, r10)     // Catch:{ Exception -> 0x00d7 }
            q.k r11 = r12.f1016b     // Catch:{ Exception -> 0x00d7 }
            java.lang.Object r10 = r11.getOrDefault(r10, r3)     // Catch:{ Exception -> 0x00d7 }
            androidx.appcompat.widget.o3 r10 = (androidx.appcompat.widget.o3) r10     // Catch:{ Exception -> 0x00d7 }
            if (r10 == 0) goto L_0x00c1
            android.content.res.Resources$Theme r11 = r13.getTheme()     // Catch:{ Exception -> 0x00d7 }
            android.graphics.drawable.Drawable r8 = r10.a(r13, r5, r9, r11)     // Catch:{ Exception -> 0x00d7 }
        L_0x00c1:
            if (r8 == 0) goto L_0x00df
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00d7 }
            r8.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00d7 }
            r12.b(r13, r6, r8)     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00df
        L_0x00cc:
            r13 = move-exception
            goto L_0x01b2
        L_0x00cf:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r5 = "No start tag found"
            r0.<init>(r5)     // Catch:{ Exception -> 0x00d7 }
            throw r0     // Catch:{ Exception -> 0x00d7 }
        L_0x00d7:
            r0 = move-exception
            java.lang.String r5 = "ResourceManagerInternal"
            java.lang.String r6 = "Exception while inflating drawable"
            android.util.Log.e(r5, r6, r0)     // Catch:{ all -> 0x00cc }
        L_0x00df:
            if (r8 != 0) goto L_0x00e8
            q.l r0 = r12.f1017c     // Catch:{ all -> 0x00cc }
            r0.a(r14, r4)     // Catch:{ all -> 0x00cc }
            goto L_0x00e8
        L_0x00e7:
            r8 = r3
        L_0x00e8:
            if (r8 != 0) goto L_0x00ee
            android.graphics.drawable.Drawable r8 = r12.c(r13, r14)     // Catch:{ all -> 0x00cc }
        L_0x00ee:
            if (r8 != 0) goto L_0x00f6
            java.lang.Object r0 = c0.g.f2717a     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r8 = c0.c.b(r13, r14)     // Catch:{ all -> 0x00cc }
        L_0x00f6:
            if (r8 == 0) goto L_0x01a1
            android.content.res.ColorStateList r0 = r12.i(r13, r14)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x011f
            int[] r13 = androidx.appcompat.widget.i2.f869a     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r13 = r8.mutate()     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r13 = f0.d.g(r13)     // Catch:{ all -> 0x00cc }
            f0.b.h(r13, r0)     // Catch:{ all -> 0x00cc }
            androidx.appcompat.widget.g0 r15 = r12.f1021g     // Catch:{ all -> 0x00cc }
            if (r15 != 0) goto L_0x0110
            goto L_0x0117
        L_0x0110:
            r15 = 2131230825(0x7f080069, float:1.8077714E38)
            if (r14 != r15) goto L_0x0117
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY     // Catch:{ all -> 0x00cc }
        L_0x0117:
            if (r3 == 0) goto L_0x011c
            f0.b.i(r13, r3)     // Catch:{ all -> 0x00cc }
        L_0x011c:
            r3 = r13
            goto L_0x01a0
        L_0x011f:
            androidx.appcompat.widget.g0 r0 = r12.f1021g     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x0196
            r0 = 2131230820(0x7f080064, float:1.8077704E38)
            r4 = 16908301(0x102000d, float:2.3877265E-38)
            r5 = 16908303(0x102000f, float:2.387727E-38)
            r6 = 16908288(0x1020000, float:2.387723E-38)
            r7 = 2130968839(0x7f040107, float:1.7546343E38)
            r9 = 2130968841(0x7f040109, float:1.7546347E38)
            if (r14 != r0) goto L_0x015d
            r0 = r8
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r1 = r0.findDrawableByLayerId(r6)     // Catch:{ all -> 0x00cc }
            int r6 = androidx.appcompat.widget.q4.c(r13, r9)     // Catch:{ all -> 0x00cc }
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.h0.f843b     // Catch:{ all -> 0x00cc }
            androidx.appcompat.widget.g0.d(r1, r6, r10)     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r1 = r0.findDrawableByLayerId(r5)     // Catch:{ all -> 0x00cc }
            int r5 = androidx.appcompat.widget.q4.c(r13, r9)     // Catch:{ all -> 0x00cc }
            androidx.appcompat.widget.g0.d(r1, r5, r10)     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r0 = r0.findDrawableByLayerId(r4)     // Catch:{ all -> 0x00cc }
            int r1 = androidx.appcompat.widget.q4.c(r13, r7)     // Catch:{ all -> 0x00cc }
            androidx.appcompat.widget.g0.d(r0, r1, r10)     // Catch:{ all -> 0x00cc }
            goto L_0x0192
        L_0x015d:
            r0 = 2131230811(0x7f08005b, float:1.8077685E38)
            if (r14 == r0) goto L_0x016c
            r0 = 2131230810(0x7f08005a, float:1.8077683E38)
            if (r14 == r0) goto L_0x016c
            r0 = 2131230812(0x7f08005c, float:1.8077687E38)
            if (r14 != r0) goto L_0x0193
        L_0x016c:
            r0 = r8
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r1 = r0.findDrawableByLayerId(r6)     // Catch:{ all -> 0x00cc }
            int r6 = androidx.appcompat.widget.q4.b(r13, r9)     // Catch:{ all -> 0x00cc }
            android.graphics.PorterDuff$Mode r9 = androidx.appcompat.widget.h0.f843b     // Catch:{ all -> 0x00cc }
            androidx.appcompat.widget.g0.d(r1, r6, r9)     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r1 = r0.findDrawableByLayerId(r5)     // Catch:{ all -> 0x00cc }
            int r5 = androidx.appcompat.widget.q4.c(r13, r7)     // Catch:{ all -> 0x00cc }
            androidx.appcompat.widget.g0.d(r1, r5, r9)     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r0 = r0.findDrawableByLayerId(r4)     // Catch:{ all -> 0x00cc }
            int r1 = androidx.appcompat.widget.q4.c(r13, r7)     // Catch:{ all -> 0x00cc }
            androidx.appcompat.widget.g0.d(r0, r1, r9)     // Catch:{ all -> 0x00cc }
        L_0x0192:
            r1 = 1
        L_0x0193:
            if (r1 == 0) goto L_0x0196
            goto L_0x019f
        L_0x0196:
            boolean r13 = r12.m(r13, r14, r8)     // Catch:{ all -> 0x00cc }
            if (r13 != 0) goto L_0x019f
            if (r15 == 0) goto L_0x019f
            goto L_0x01a0
        L_0x019f:
            r3 = r8
        L_0x01a0:
            r8 = r3
        L_0x01a1:
            if (r8 == 0) goto L_0x01a6
            androidx.appcompat.widget.i2.a(r8)     // Catch:{ all -> 0x00cc }
        L_0x01a6:
            monitor-exit(r12)
            return r8
        L_0x01a8:
            r12.f1020f = r1     // Catch:{ all -> 0x00cc }
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00cc }
            java.lang.String r14 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r13.<init>(r14)     // Catch:{ all -> 0x00cc }
            throw r13     // Catch:{ all -> 0x00cc }
        L_0x01b2:
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q3.g(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList i(Context context, int i10) {
        ColorStateList colorStateList;
        l lVar;
        try {
            WeakHashMap weakHashMap = this.f1015a;
            ColorStateList colorStateList2 = null;
            if (weakHashMap == null || (lVar = (l) weakHashMap.get(context)) == null) {
                colorStateList = null;
            } else {
                colorStateList = (ColorStateList) lVar.d(i10, (Integer) null);
            }
            if (colorStateList == null) {
                g0 g0Var = this.f1021g;
                if (g0Var != null) {
                    colorStateList2 = g0Var.c(context, i10);
                }
                if (colorStateList2 != null) {
                    if (this.f1015a == null) {
                        this.f1015a = new WeakHashMap();
                    }
                    l lVar2 = (l) this.f1015a.get(context);
                    if (lVar2 == null) {
                        lVar2 = new l();
                        this.f1015a.put(context, lVar2);
                    }
                    lVar2.a(i10, colorStateList2);
                }
                colorStateList = colorStateList2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return colorStateList;
    }

    public final synchronized void k(Context context) {
        i iVar = (i) this.f1018d.get(context);
        if (iVar != null) {
            iVar.b();
        }
    }

    public final synchronized void l(g0 g0Var) {
        this.f1021g = g0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            androidx.appcompat.widget.g0 r0 = r6.f1021g
            r1 = 0
            if (r0 == 0) goto L_0x0069
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.h0.f843b
            int[] r3 = r0.f820a
            boolean r3 = androidx.appcompat.widget.g0.a(r3, r8)
            r4 = 1
            r5 = -1
            if (r3 == 0) goto L_0x0015
            r8 = 2130968841(0x7f040109, float:1.7546347E38)
            goto L_0x0044
        L_0x0015:
            int[] r3 = r0.f822c
            boolean r3 = androidx.appcompat.widget.g0.a(r3, r8)
            if (r3 == 0) goto L_0x0021
            r8 = 2130968839(0x7f040107, float:1.7546343E38)
            goto L_0x0044
        L_0x0021:
            int[] r0 = r0.f823d
            boolean r0 = androidx.appcompat.widget.g0.a(r0, r8)
            if (r0 == 0) goto L_0x002c
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0041
        L_0x002c:
            r0 = 2131230797(0x7f08004d, float:1.8077657E38)
            if (r8 != r0) goto L_0x003c
            r8 = 1109603123(0x42233333, float:40.8)
            int r8 = java.lang.Math.round(r8)
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            goto L_0x0046
        L_0x003c:
            r0 = 2131230779(0x7f08003b, float:1.807762E38)
            if (r8 != r0) goto L_0x0048
        L_0x0041:
            r8 = 16842801(0x1010031, float:2.3693695E-38)
        L_0x0044:
            r0 = r8
            r8 = -1
        L_0x0046:
            r3 = 1
            goto L_0x004b
        L_0x0048:
            r8 = -1
            r0 = 0
            r3 = 0
        L_0x004b:
            if (r3 == 0) goto L_0x0065
            int[] r3 = androidx.appcompat.widget.i2.f869a
            android.graphics.drawable.Drawable r9 = r9.mutate()
            int r7 = androidx.appcompat.widget.q4.c(r7, r0)
            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.h0.c(r7, r2)
            r9.setColorFilter(r7)
            if (r8 == r5) goto L_0x0063
            r9.setAlpha(r8)
        L_0x0063:
            r7 = 1
            goto L_0x0066
        L_0x0065:
            r7 = 0
        L_0x0066:
            if (r7 == 0) goto L_0x0069
            r1 = 1
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q3.m(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}

package e5;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.media.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import w5.o;
import w5.p;

public final class s implements n {

    /* renamed from: d  reason: collision with root package name */
    public static final Bitmap.Config[] f5067d;

    /* renamed from: e  reason: collision with root package name */
    public static final Bitmap.Config[] f5068e;

    /* renamed from: f  reason: collision with root package name */
    public static final Bitmap.Config[] f5069f = {Bitmap.Config.RGB_565};

    /* renamed from: g  reason: collision with root package name */
    public static final Bitmap.Config[] f5070g = {Bitmap.Config.ARGB_4444};

    /* renamed from: h  reason: collision with root package name */
    public static final Bitmap.Config[] f5071h = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    public final r f5072a = new r();

    /* renamed from: b  reason: collision with root package name */
    public final g f5073b = new g();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f5074c = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f5067d = configArr;
        f5068e = configArr;
    }

    public static String h(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    public final String a(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        char[] cArr = p.f16126a;
        int i12 = i10 * i11;
        if (config == null) {
            config2 = Bitmap.Config.ARGB_8888;
        } else {
            config2 = config;
        }
        int i13 = o.f16125a[config2.ordinal()];
        int i14 = 1;
        if (i13 != 1) {
            i14 = 2;
            if (!(i13 == 2 || i13 == 3)) {
                i14 = 4;
                if (i13 == 4) {
                    i14 = 8;
                }
            }
        }
        return h(i14 * i12, config);
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [e5.o] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(int r11, int r12, android.graphics.Bitmap.Config r13) {
        /*
            r10 = this;
            char[] r0 = w5.p.f16126a
            int r0 = r11 * r12
            if (r13 != 0) goto L_0x0009
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            int[] r2 = w5.o.f16125a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x0025
            if (r1 == r4) goto L_0x0023
            if (r1 == r3) goto L_0x0023
            if (r1 == r2) goto L_0x0020
            r1 = 4
            goto L_0x0026
        L_0x0020:
            r1 = 8
            goto L_0x0026
        L_0x0023:
            r1 = 2
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            int r1 = r1 * r0
            e5.r r0 = r10.f5072a
            e5.o r6 = r0.b()
            e5.q r6 = (e5.q) r6
            r6.f5065b = r1
            r6.f5066c = r13
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 26
            r9 = 0
            if (r7 < r8) goto L_0x0048
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGBA_F16
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0048
            android.graphics.Bitmap$Config[] r2 = f5068e
            goto L_0x0068
        L_0x0048:
            int[] r7 = e5.p.f5063a
            int r8 = r13.ordinal()
            r7 = r7[r8]
            if (r7 == r5) goto L_0x0066
            if (r7 == r4) goto L_0x0063
            if (r7 == r3) goto L_0x0060
            if (r7 == r2) goto L_0x005d
            android.graphics.Bitmap$Config[] r2 = new android.graphics.Bitmap.Config[r5]
            r2[r9] = r13
            goto L_0x0068
        L_0x005d:
            android.graphics.Bitmap$Config[] r2 = f5071h
            goto L_0x0068
        L_0x0060:
            android.graphics.Bitmap$Config[] r2 = f5070g
            goto L_0x0068
        L_0x0063:
            android.graphics.Bitmap$Config[] r2 = f5069f
            goto L_0x0068
        L_0x0066:
            android.graphics.Bitmap$Config[] r2 = f5067d
        L_0x0068:
            int r3 = r2.length
        L_0x0069:
            if (r9 >= r3) goto L_0x00ac
            r4 = r2[r9]
            java.util.NavigableMap r5 = r10.i(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            java.lang.Object r5 = r5.ceilingKey(r7)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x00a9
            int r7 = r5.intValue()
            int r8 = r1 * 8
            if (r7 > r8) goto L_0x00a9
            int r2 = r5.intValue()
            if (r2 != r1) goto L_0x0096
            if (r4 != 0) goto L_0x0090
            if (r13 == 0) goto L_0x00ac
            goto L_0x0096
        L_0x0090:
            boolean r1 = r4.equals(r13)
            if (r1 != 0) goto L_0x00ac
        L_0x0096:
            r0.c(r6)
            int r1 = r5.intValue()
            e5.o r0 = r0.b()
            r6 = r0
            e5.q r6 = (e5.q) r6
            r6.f5065b = r1
            r6.f5066c = r4
            goto L_0x00ac
        L_0x00a9:
            int r9 = r9 + 1
            goto L_0x0069
        L_0x00ac:
            e5.g r0 = r10.f5073b
            java.lang.Object r0 = r0.a(r6)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto L_0x00c2
            int r1 = r6.f5065b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.g(r1, r0)
            r0.reconfigure(r11, r12, r13)
        L_0x00c2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.s.b(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public final void c(Bitmap bitmap) {
        int c10 = p.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        q qVar = (q) this.f5072a.b();
        qVar.f5065b = c10;
        qVar.f5066c = config;
        this.f5073b.b(qVar, bitmap);
        NavigableMap i10 = i(bitmap.getConfig());
        Integer num = (Integer) i10.get(Integer.valueOf(qVar.f5065b));
        Integer valueOf = Integer.valueOf(qVar.f5065b);
        int i11 = 1;
        if (num != null) {
            i11 = 1 + num.intValue();
        }
        i10.put(valueOf, Integer.valueOf(i11));
    }

    public final int d(Bitmap bitmap) {
        return p.c(bitmap);
    }

    public final Bitmap e() {
        Bitmap bitmap = (Bitmap) this.f5073b.c();
        if (bitmap != null) {
            g(Integer.valueOf(p.c(bitmap)), bitmap);
        }
        return bitmap;
    }

    public final String f(Bitmap bitmap) {
        return h(p.c(bitmap), bitmap.getConfig());
    }

    public final void g(Integer num, Bitmap bitmap) {
        NavigableMap i10 = i(bitmap.getConfig());
        Integer num2 = (Integer) i10.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + f(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            i10.remove(num);
        } else {
            i10.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public final NavigableMap i(Bitmap.Config config) {
        HashMap hashMap = this.f5074c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(config, treeMap);
        return treeMap;
    }

    public final String toString() {
        StringBuilder q10 = h.q("SizeConfigStrategy{groupedMap=");
        q10.append(this.f5073b);
        q10.append(", sortedSizes=(");
        HashMap hashMap = this.f5074c;
        for (Map.Entry entry : hashMap.entrySet()) {
            q10.append(entry.getKey());
            q10.append('[');
            q10.append(entry.getValue());
            q10.append("], ");
        }
        if (!hashMap.isEmpty()) {
            q10.replace(q10.length() - 2, q10.length(), "");
        }
        q10.append(")}");
        return q10.toString();
    }
}

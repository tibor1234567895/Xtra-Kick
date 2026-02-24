package j3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import fb.w;
import k3.a;
import la.v;
import org.xmlpull.v1.XmlPullParserException;
import xa.j;

public final class l1 {

    /* renamed from: c  reason: collision with root package name */
    public static final k1 f8607c = new k1(0);

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal f8608d = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final Context f8609a;

    /* renamed from: b  reason: collision with root package name */
    public final q2 f8610b;

    public l1(Context context, q2 q2Var) {
        j.f("context", context);
        j.f("navigatorProvider", q2Var);
        this.f8609a = context;
        this.f8610b = q2Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: j3.z1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: j3.z1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: j3.z1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: j3.z1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v66, resolved type: j3.z1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v67, resolved type: j3.z1} */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:117|118|119|120|121|122|123|124|125|128) */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02ae, code lost:
        r2 = j3.g2.f8549l;
        xa.j.d("null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>", r2);
        r2 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:120:0x029c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x02a2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:124:0x02a8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j3.m c(android.content.res.TypedArray r17, android.content.res.Resources r18, int r19) {
        /*
            r0 = r17
            j3.l r1 = new j3.l
            r1.<init>()
            r2 = 3
            r3 = 0
            boolean r4 = r0.getBoolean(r2, r3)
            r1.f8604b = r4
            java.lang.ThreadLocal r4 = f8608d
            java.lang.Object r5 = r4.get()
            android.util.TypedValue r5 = (android.util.TypedValue) r5
            if (r5 != 0) goto L_0x0021
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            r4.set(r5)
        L_0x0021:
            r4 = 2
            java.lang.String r6 = r0.getString(r4)
            java.lang.String r7 = "boolean"
            java.lang.String r8 = "integer"
            java.lang.String r9 = "float"
            r10 = 1
            java.lang.Class<android.os.Parcelable> r11 = android.os.Parcelable.class
            java.lang.Class<java.io.Serializable> r12 = java.io.Serializable.class
            if (r6 == 0) goto L_0x0170
            j3.a2 r14 = j3.g2.f8539b
            java.lang.String r15 = r18.getResourcePackageName(r19)
            r14.getClass()
            j3.u1 r14 = j3.g2.f8540c
            r14.getClass()
            boolean r16 = xa.j.a(r8, r6)
            if (r16 == 0) goto L_0x0049
            goto L_0x0171
        L_0x0049:
            j3.t1 r14 = j3.g2.f8542e
            r14.getClass()
            java.lang.String r13 = "integer[]"
            boolean r13 = xa.j.a(r13, r6)
            if (r13 == 0) goto L_0x0058
            goto L_0x0171
        L_0x0058:
            j3.w1 r14 = j3.g2.f8543f
            r14.getClass()
            java.lang.String r13 = "long"
            boolean r13 = xa.j.a(r13, r6)
            if (r13 == 0) goto L_0x0067
            goto L_0x0171
        L_0x0067:
            j3.v1 r14 = j3.g2.f8544g
            r14.getClass()
            java.lang.String r13 = "long[]"
            boolean r13 = xa.j.a(r13, r6)
            if (r13 == 0) goto L_0x0076
            goto L_0x0171
        L_0x0076:
            j3.q1 r14 = j3.g2.f8547j
            r14.getClass()
            boolean r13 = xa.j.a(r7, r6)
            if (r13 == 0) goto L_0x0083
            goto L_0x0171
        L_0x0083:
            j3.p1 r14 = j3.g2.f8548k
            r14.getClass()
            java.lang.String r13 = "boolean[]"
            boolean r13 = xa.j.a(r13, r6)
            if (r13 == 0) goto L_0x0092
            goto L_0x0171
        L_0x0092:
            j3.z1 r14 = j3.g2.f8549l
            r14.getClass()
            java.lang.String r13 = "string"
            boolean r13 = xa.j.a(r13, r6)
            if (r13 == 0) goto L_0x00a1
            goto L_0x0171
        L_0x00a1:
            j3.y1 r13 = j3.g2.f8550m
            r13.getClass()
            java.lang.String r2 = "string[]"
            boolean r2 = xa.j.a(r2, r6)
            if (r2 == 0) goto L_0x00b1
            r14 = r13
            goto L_0x0171
        L_0x00b1:
            j3.s1 r2 = j3.g2.f8545h
            r2.getClass()
            boolean r13 = xa.j.a(r9, r6)
            if (r13 == 0) goto L_0x00bf
        L_0x00bc:
            r14 = r2
            goto L_0x0171
        L_0x00bf:
            j3.r1 r2 = j3.g2.f8546i
            r2.getClass()
            java.lang.String r13 = "float[]"
            boolean r13 = xa.j.a(r13, r6)
            if (r13 == 0) goto L_0x00cd
            goto L_0x00bc
        L_0x00cd:
            j3.x1 r2 = j3.g2.f8541d
            r2.getClass()
            java.lang.String r13 = "reference"
            boolean r13 = xa.j.a(r13, r6)
            if (r13 == 0) goto L_0x00db
            goto L_0x00bc
        L_0x00db:
            int r2 = r6.length()
            if (r2 != 0) goto L_0x00e3
            r2 = 1
            goto L_0x00e4
        L_0x00e3:
            r2 = 0
        L_0x00e4:
            if (r2 != 0) goto L_0x0171
            java.lang.String r2 = "."
            boolean r2 = fb.w.m(r6, r2, r3)     // Catch:{ ClassNotFoundException -> 0x0169 }
            if (r2 == 0) goto L_0x00f5
            if (r15 == 0) goto L_0x00f5
            java.lang.String r2 = r15.concat(r6)     // Catch:{ ClassNotFoundException -> 0x0169 }
            goto L_0x00f6
        L_0x00f5:
            r2 = r6
        L_0x00f6:
            java.lang.String r13 = "[]"
            boolean r13 = fb.w.f(r6, r13, r3)     // Catch:{ ClassNotFoundException -> 0x0169 }
            if (r13 == 0) goto L_0x0128
            int r13 = r2.length()     // Catch:{ ClassNotFoundException -> 0x0169 }
            int r13 = r13 - r4
            java.lang.String r2 = r2.substring(r3, r13)     // Catch:{ ClassNotFoundException -> 0x0169 }
            java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
            xa.j.e(r4, r2)     // Catch:{ ClassNotFoundException -> 0x0169 }
            java.lang.Class r4 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0169 }
            boolean r13 = r11.isAssignableFrom(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            if (r13 == 0) goto L_0x011c
            j3.c2 r14 = new j3.c2     // Catch:{ ClassNotFoundException -> 0x0169 }
            r14.<init>(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            goto L_0x0171
        L_0x011c:
            boolean r13 = r12.isAssignableFrom(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            if (r13 == 0) goto L_0x0152
            j3.e2 r14 = new j3.e2     // Catch:{ ClassNotFoundException -> 0x0169 }
            r14.<init>(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            goto L_0x0171
        L_0x0128:
            java.lang.Class r4 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0169 }
            boolean r13 = r11.isAssignableFrom(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            if (r13 == 0) goto L_0x0138
            j3.d2 r14 = new j3.d2     // Catch:{ ClassNotFoundException -> 0x0169 }
            r14.<init>(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            goto L_0x0171
        L_0x0138:
            java.lang.Class<java.lang.Enum> r13 = java.lang.Enum.class
            boolean r13 = r13.isAssignableFrom(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            if (r13 == 0) goto L_0x0146
            j3.b2 r14 = new j3.b2     // Catch:{ ClassNotFoundException -> 0x0169 }
            r14.<init>(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            goto L_0x0171
        L_0x0146:
            boolean r13 = r12.isAssignableFrom(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            if (r13 == 0) goto L_0x0152
            j3.f2 r14 = new j3.f2     // Catch:{ ClassNotFoundException -> 0x0169 }
            r14.<init>(r4)     // Catch:{ ClassNotFoundException -> 0x0169 }
            goto L_0x0171
        L_0x0152:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassNotFoundException -> 0x0169 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0169 }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x0169 }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x0169 }
            java.lang.String r2 = " is not Serializable or Parcelable."
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x0169 }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x0169 }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x0169 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x0169 }
        L_0x0169:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x0170:
            r14 = 0
        L_0x0171:
            boolean r2 = r0.getValue(r10, r5)
            java.lang.String r4 = "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>"
            if (r2 == 0) goto L_0x02b9
            j3.x1 r2 = j3.g2.f8541d
            java.lang.String r13 = "' for "
            java.lang.String r15 = "unsupported value '"
            r3 = 16
            if (r14 != r2) goto L_0x01bb
            int r0 = r5.resourceId
            if (r0 == 0) goto L_0x0189
            r3 = r0
            goto L_0x0192
        L_0x0189:
            int r0 = r5.type
            if (r0 != r3) goto L_0x0198
            int r0 = r5.data
            if (r0 != 0) goto L_0x0198
            r3 = 0
        L_0x0192:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            goto L_0x02ba
        L_0x0198:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r15)
            java.lang.CharSequence r2 = r5.string
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = r14.b()
            r1.append(r2)
            java.lang.String r2 = ". Must be a reference to a resource."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01bb:
            int r3 = r5.resourceId
            if (r3 == 0) goto L_0x01ee
            if (r14 != 0) goto L_0x01c8
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            r14 = r2
            goto L_0x02ba
        L_0x01c8:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r15)
            java.lang.CharSequence r3 = r5.string
            r1.append(r3)
            r1.append(r13)
            java.lang.String r3 = r14.b()
            r1.append(r3)
            java.lang.String r3 = ". You must use a \"reference\" type to reference other resources."
            r1.append(r3)
            r2.getClass()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01ee:
            j3.z1 r2 = j3.g2.f8549l
            if (r14 != r2) goto L_0x01f8
            java.lang.String r13 = r0.getString(r10)
            goto L_0x02ba
        L_0x01f8:
            int r0 = r5.type
            r2 = 3
            if (r0 == r2) goto L_0x0284
            r2 = 4
            j3.k1 r3 = f8607c
            if (r0 == r2) goto L_0x0271
            r2 = 5
            if (r0 == r2) goto L_0x0257
            r2 = 18
            if (r0 == r2) goto L_0x0242
            r2 = 16
            if (r0 < r2) goto L_0x022c
            r2 = 31
            if (r0 > r2) goto L_0x022c
            j3.s1 r0 = j3.g2.f8545h
            if (r14 != r0) goto L_0x0220
            r3.getClass()
            j3.g2 r0 = j3.k1.a(r5, r14, r0, r6, r9)
            int r2 = r5.data
            float r2 = (float) r2
            goto L_0x027e
        L_0x0220:
            j3.u1 r0 = j3.g2.f8540c
            r3.getClass()
            j3.g2 r0 = j3.k1.a(r5, r14, r0, r6, r8)
            int r2 = r5.data
            goto L_0x026b
        L_0x022c:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "unsupported argument type "
            r1.<init>(r2)
            int r2 = r5.type
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0242:
            j3.q1 r0 = j3.g2.f8547j
            r3.getClass()
            j3.g2 r14 = j3.k1.a(r5, r14, r0, r6, r7)
            int r0 = r5.data
            if (r0 == 0) goto L_0x0251
            r3 = 1
            goto L_0x0252
        L_0x0251:
            r3 = 0
        L_0x0252:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r3)
            goto L_0x02ba
        L_0x0257:
            j3.u1 r0 = j3.g2.f8540c
            r3.getClass()
            java.lang.String r2 = "dimension"
            j3.g2 r0 = j3.k1.a(r5, r14, r0, r6, r2)
            android.util.DisplayMetrics r2 = r18.getDisplayMetrics()
            float r2 = r5.getDimension(r2)
            int r2 = (int) r2
        L_0x026b:
            r14 = r0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)
            goto L_0x02ba
        L_0x0271:
            j3.s1 r0 = j3.g2.f8545h
            r3.getClass()
            j3.g2 r0 = j3.k1.a(r5, r14, r0, r6, r9)
            float r2 = r5.getFloat()
        L_0x027e:
            r14 = r0
            java.lang.Float r13 = java.lang.Float.valueOf(r2)
            goto L_0x02ba
        L_0x0284:
            java.lang.CharSequence r0 = r5.string
            java.lang.String r0 = r0.toString()
            if (r14 != 0) goto L_0x02b4
            j3.a2 r2 = j3.g2.f8539b
            r2.getClass()
            java.lang.String r2 = "value"
            xa.j.f(r2, r0)
            j3.u1 r2 = j3.g2.f8540c     // Catch:{ IllegalArgumentException -> 0x029c }
            r2.c(r0)     // Catch:{ IllegalArgumentException -> 0x029c }
            goto L_0x02b3
        L_0x029c:
            j3.w1 r2 = j3.g2.f8543f     // Catch:{ IllegalArgumentException -> 0x02a2 }
            r2.c(r0)     // Catch:{ IllegalArgumentException -> 0x02a2 }
            goto L_0x02b3
        L_0x02a2:
            j3.s1 r2 = j3.g2.f8545h     // Catch:{ IllegalArgumentException -> 0x02a8 }
            r2.c(r0)     // Catch:{ IllegalArgumentException -> 0x02a8 }
            goto L_0x02b3
        L_0x02a8:
            j3.q1 r2 = j3.g2.f8547j     // Catch:{ IllegalArgumentException -> 0x02ae }
            r2.c(r0)     // Catch:{ IllegalArgumentException -> 0x02ae }
            goto L_0x02b3
        L_0x02ae:
            j3.z1 r2 = j3.g2.f8549l
            xa.j.d(r4, r2)
        L_0x02b3:
            r14 = r2
        L_0x02b4:
            java.lang.Object r13 = r14.c(r0)
            goto L_0x02ba
        L_0x02b9:
            r13 = 0
        L_0x02ba:
            if (r13 == 0) goto L_0x02c0
            r1.f8605c = r13
            r1.f8606d = r10
        L_0x02c0:
            if (r14 == 0) goto L_0x02c4
            r1.f8603a = r14
        L_0x02c4:
            j3.g2 r0 = r1.f8603a
            if (r0 != 0) goto L_0x03d3
            j3.a2 r0 = j3.g2.f8539b
            java.lang.Object r2 = r1.f8605c
            r0.getClass()
            boolean r0 = r2 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x02d7
            j3.u1 r0 = j3.g2.f8540c
            goto L_0x03d0
        L_0x02d7:
            boolean r0 = r2 instanceof int[]
            if (r0 == 0) goto L_0x02df
            j3.t1 r0 = j3.g2.f8542e
            goto L_0x03d0
        L_0x02df:
            boolean r0 = r2 instanceof java.lang.Long
            if (r0 == 0) goto L_0x02e7
            j3.w1 r0 = j3.g2.f8543f
            goto L_0x03d0
        L_0x02e7:
            boolean r0 = r2 instanceof long[]
            if (r0 == 0) goto L_0x02ef
            j3.v1 r0 = j3.g2.f8544g
            goto L_0x03d0
        L_0x02ef:
            boolean r0 = r2 instanceof java.lang.Float
            if (r0 == 0) goto L_0x02f7
            j3.s1 r0 = j3.g2.f8545h
            goto L_0x03d0
        L_0x02f7:
            boolean r0 = r2 instanceof float[]
            if (r0 == 0) goto L_0x02ff
            j3.r1 r0 = j3.g2.f8546i
            goto L_0x03d0
        L_0x02ff:
            boolean r0 = r2 instanceof java.lang.Boolean
            if (r0 == 0) goto L_0x0307
            j3.q1 r0 = j3.g2.f8547j
            goto L_0x03d0
        L_0x0307:
            boolean r0 = r2 instanceof boolean[]
            if (r0 == 0) goto L_0x030f
            j3.p1 r0 = j3.g2.f8548k
            goto L_0x03d0
        L_0x030f:
            boolean r0 = r2 instanceof java.lang.String
            if (r0 != 0) goto L_0x03ce
            if (r2 != 0) goto L_0x0317
            goto L_0x03ce
        L_0x0317:
            boolean r0 = r2 instanceof java.lang.Object[]
            if (r0 == 0) goto L_0x0326
            r0 = r2
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            boolean r0 = r0 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x0326
            j3.y1 r0 = j3.g2.f8550m
            goto L_0x03d0
        L_0x0326:
            java.lang.Class r0 = r2.getClass()
            boolean r0 = r0.isArray()
            if (r0 == 0) goto L_0x0355
            java.lang.Class r0 = r2.getClass()
            java.lang.Class r0 = r0.getComponentType()
            xa.j.c(r0)
            boolean r0 = r11.isAssignableFrom(r0)
            if (r0 == 0) goto L_0x0355
            j3.c2 r0 = new j3.c2
            java.lang.Class r2 = r2.getClass()
            java.lang.Class r2 = r2.getComponentType()
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>"
            xa.j.d(r3, r2)
            r0.<init>(r2)
            goto L_0x03d3
        L_0x0355:
            java.lang.Class r0 = r2.getClass()
            boolean r0 = r0.isArray()
            if (r0 == 0) goto L_0x0383
            java.lang.Class r0 = r2.getClass()
            java.lang.Class r0 = r0.getComponentType()
            xa.j.c(r0)
            boolean r0 = r12.isAssignableFrom(r0)
            if (r0 == 0) goto L_0x0383
            j3.e2 r0 = new j3.e2
            java.lang.Class r2 = r2.getClass()
            java.lang.Class r2 = r2.getComponentType()
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>"
            xa.j.d(r3, r2)
            r0.<init>(r2)
            goto L_0x03d3
        L_0x0383:
            boolean r0 = r2 instanceof android.os.Parcelable
            if (r0 == 0) goto L_0x0391
            j3.d2 r0 = new j3.d2
            java.lang.Class r2 = r2.getClass()
            r0.<init>(r2)
            goto L_0x03d3
        L_0x0391:
            boolean r0 = r2 instanceof java.lang.Enum
            if (r0 == 0) goto L_0x039f
            j3.b2 r0 = new j3.b2
            java.lang.Class r2 = r2.getClass()
            r0.<init>(r2)
            goto L_0x03d3
        L_0x039f:
            boolean r0 = r2 instanceof java.io.Serializable
            if (r0 == 0) goto L_0x03ad
            j3.f2 r0 = new j3.f2
            java.lang.Class r2 = r2.getClass()
            r0.<init>(r2)
            goto L_0x03d3
        L_0x03ad:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Object of type "
            r1.<init>(r3)
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = " is not supported for navigation arguments."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03ce:
            j3.z1 r0 = j3.g2.f8549l
        L_0x03d0:
            xa.j.d(r4, r0)
        L_0x03d3:
            j3.m r2 = new j3.m
            boolean r3 = r1.f8604b
            java.lang.Object r4 = r1.f8605c
            boolean r1 = r1.f8606d
            r2.<init>(r0, r3, r4, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.l1.c(android.content.res.TypedArray, android.content.res.Resources, int):j3.m");
    }

    public final c1 a(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i10) {
        int depth;
        int i11;
        Context context;
        l1 l1Var;
        int depth2;
        l1 l1Var2 = this;
        Resources resources2 = resources;
        AttributeSet attributeSet2 = attributeSet;
        int i12 = i10;
        String name = xmlResourceParser.getName();
        j.e("parser.name", name);
        c1 a10 = l1Var2.f8610b.b(name).a();
        Context context2 = l1Var2.f8609a;
        a10.g(context2, attributeSet2);
        int i13 = 1;
        int depth3 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == i13 || ((depth = xmlResourceParser.getDepth()) < depth3 && next == 3)) {
                l1 l1Var3 = l1Var2;
            } else {
                if (next == 2 && depth <= depth3) {
                    String name2 = xmlResourceParser.getName();
                    boolean a11 = j.a("argument", name2);
                    int[] iArr = a.f9075b;
                    boolean z10 = false;
                    if (a11) {
                        TypedArray obtainAttributes = resources2.obtainAttributes(attributeSet2, iArr);
                        j.e("res.obtainAttributes(att… R.styleable.NavArgument)", obtainAttributes);
                        String string = obtainAttributes.getString(0);
                        if (string != null) {
                            a10.f8512n.put(string, c(obtainAttributes, resources2, i12));
                            v vVar = v.f9814a;
                            obtainAttributes.recycle();
                        } else {
                            throw new XmlPullParserException("Arguments must have a name");
                        }
                    } else if (j.a("deepLink", name2)) {
                        TypedArray obtainAttributes2 = resources2.obtainAttributes(attributeSet2, a.f9076c);
                        j.e("res.obtainAttributes(att… R.styleable.NavDeepLink)", obtainAttributes2);
                        String string2 = obtainAttributes2.getString(3);
                        String string3 = obtainAttributes2.getString(i13);
                        String string4 = obtainAttributes2.getString(2);
                        if (string2 == null || string2.length() == 0) {
                            if (string3 == null || string3.length() == 0) {
                                if (string4 == null || string4.length() == 0) {
                                    throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
                                }
                            }
                        }
                        p0 p0Var = new p0();
                        if (string2 != null) {
                            String packageName = context2.getPackageName();
                            j.e("context.packageName", packageName);
                            p0Var.f8651a = w.k(string2, "${applicationId}", packageName);
                        }
                        if (!(string3 == null || string3.length() == 0)) {
                            String packageName2 = context2.getPackageName();
                            j.e("context.packageName", packageName2);
                            String k10 = w.k(string3, "${applicationId}", packageName2);
                            if (k10.length() > 0) {
                                z10 = true;
                            }
                            if (z10) {
                                p0Var.f8652b = k10;
                            } else {
                                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
                            }
                        }
                        if (string4 != null) {
                            String packageName3 = context2.getPackageName();
                            j.e("context.packageName", packageName3);
                            p0Var.f8653c = w.k(string4, "${applicationId}", packageName3);
                        }
                        a10.a(new u0(p0Var.f8651a, p0Var.f8652b, p0Var.f8653c));
                        v vVar2 = v.f9814a;
                        obtainAttributes2.recycle();
                    } else {
                        if (j.a("action", name2)) {
                            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, a.f9074a, 0, 0);
                            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                            h hVar = new h(obtainStyledAttributes.getResourceId(1, 0));
                            m1 m1Var = new m1();
                            context = context2;
                            m1Var.f8615a = obtainStyledAttributes.getBoolean(4, false);
                            m1Var.f8616b = obtainStyledAttributes.getBoolean(10, false);
                            int resourceId2 = obtainStyledAttributes.getResourceId(7, -1);
                            i11 = depth3;
                            boolean z11 = obtainStyledAttributes.getBoolean(8, false);
                            boolean z12 = obtainStyledAttributes.getBoolean(9, false);
                            m1Var.f8617c = resourceId2;
                            m1Var.f8618d = null;
                            m1Var.f8619e = z11;
                            m1Var.f8620f = z12;
                            m1Var.f8621g = obtainStyledAttributes.getResourceId(2, -1);
                            m1Var.f8622h = obtainStyledAttributes.getResourceId(3, -1);
                            m1Var.f8623i = obtainStyledAttributes.getResourceId(5, -1);
                            m1Var.f8624j = obtainStyledAttributes.getResourceId(6, -1);
                            hVar.f8553b = m1Var.a();
                            Bundle bundle = new Bundle();
                            int i14 = 1;
                            int depth4 = xmlResourceParser.getDepth() + 1;
                            while (true) {
                                int next2 = xmlResourceParser.next();
                                if (next2 != i14 && ((depth2 = xmlResourceParser.getDepth()) >= depth4 || next2 != 3)) {
                                    if (next2 == 2 && depth2 <= depth4 && j.a("argument", xmlResourceParser.getName())) {
                                        TypedArray obtainAttributes3 = resources2.obtainAttributes(attributeSet2, iArr);
                                        j.e("res.obtainAttributes(att… R.styleable.NavArgument)", obtainAttributes3);
                                        String string5 = obtainAttributes3.getString(0);
                                        if (string5 != null) {
                                            m c10 = c(obtainAttributes3, resources2, i12);
                                            boolean z13 = c10.f8613c;
                                            if (z13 && z13) {
                                                c10.f8611a.e(bundle, string5, c10.f8614d);
                                            }
                                            v vVar3 = v.f9814a;
                                            obtainAttributes3.recycle();
                                        } else {
                                            throw new XmlPullParserException("Arguments must have a name");
                                        }
                                    }
                                    i12 = i10;
                                    i14 = 1;
                                }
                            }
                            if (!bundle.isEmpty()) {
                                hVar.f8554c = bundle;
                            }
                            if (!(a10 instanceof c)) {
                                if (resourceId != 0) {
                                    a10.f8511m.f(resourceId, hVar);
                                    obtainStyledAttributes.recycle();
                                    l1Var = this;
                                } else {
                                    throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
                                }
                            } else {
                                throw new UnsupportedOperationException("Cannot add action " + resourceId + " to " + a10 + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
                            }
                        } else {
                            context = context2;
                            i11 = depth3;
                            if (!j.a("include", name2) || !(a10 instanceof h1)) {
                                l1Var = this;
                                if (a10 instanceof h1) {
                                    ((h1) a10).h(a(resources, xmlResourceParser, attributeSet, i10));
                                }
                            } else {
                                TypedArray obtainAttributes4 = resources2.obtainAttributes(attributeSet2, t2.f8687c);
                                j.e("res.obtainAttributes(att…n.R.styleable.NavInclude)", obtainAttributes4);
                                l1Var = this;
                                ((h1) a10).h(l1Var.b(obtainAttributes4.getResourceId(0, 0)));
                                v vVar4 = v.f9814a;
                                obtainAttributes4.recycle();
                            }
                        }
                        i12 = i10;
                        l1Var2 = l1Var;
                        context2 = context;
                        depth3 = i11;
                    }
                }
                i13 = 1;
            }
        }
        l1 l1Var32 = l1Var2;
        return a10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[Catch:{ Exception -> 0x0060, all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001f A[Catch:{ Exception -> 0x0060, all -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j3.h1 b(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f8609a
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            java.lang.String r2 = "res.getXml(graphResId)"
            xa.j.e(r2, r1)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r1)
        L_0x0013:
            int r3 = r1.next()     // Catch:{ Exception -> 0x0060 }
            r4 = 2
            if (r3 == r4) goto L_0x001d
            r5 = 1
            if (r3 != r5) goto L_0x0013
        L_0x001d:
            if (r3 != r4) goto L_0x0056
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r4 = "attrs"
            xa.j.e(r4, r2)     // Catch:{ Exception -> 0x0060 }
            j3.c1 r2 = r6.a(r0, r1, r2, r7)     // Catch:{ Exception -> 0x0060 }
            boolean r4 = r2 instanceof j3.h1     // Catch:{ Exception -> 0x0060 }
            if (r4 == 0) goto L_0x0036
            j3.h1 r2 = (j3.h1) r2     // Catch:{ Exception -> 0x0060 }
            r1.close()
            return r2
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0060 }
            r2.<init>()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r4 = "Root element <"
            r2.append(r4)     // Catch:{ Exception -> 0x0060 }
            r2.append(r3)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r2.append(r3)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0060 }
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0060 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0060 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0060 }
            throw r3     // Catch:{ Exception -> 0x0060 }
        L_0x0056:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0060 }
            throw r2     // Catch:{ Exception -> 0x0060 }
        L_0x005e:
            r7 = move-exception
            goto L_0x0088
        L_0x0060:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r4.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r5 = "Exception inflating "
            r4.append(r5)     // Catch:{ all -> 0x005e }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x005e }
            r4.append(r7)     // Catch:{ all -> 0x005e }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x005e }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x005e }
            r4.append(r7)     // Catch:{ all -> 0x005e }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x005e }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x005e }
            throw r3     // Catch:{ all -> 0x005e }
        L_0x0088:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.l1.b(int):j3.h1");
    }
}

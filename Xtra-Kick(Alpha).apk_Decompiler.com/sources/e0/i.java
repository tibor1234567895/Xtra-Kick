package e0;

import android.graphics.Path;
import android.support.v4.media.h;

public final class i {
    private i() {
    }

    public static boolean a(h[] hVarArr, h[] hVarArr2) {
        if (hVarArr == null || hVarArr2 == null || hVarArr.length != hVarArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < hVarArr.length; i10++) {
            h hVar = hVarArr[i10];
            char c10 = hVar.f4862a;
            h hVar2 = hVarArr2[i10];
            if (c10 != hVar2.f4862a || hVar.f4863b.length != hVar2.f4863b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] b(float[] fArr, int i10) {
        if (i10 >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int i11 = i10 - 0;
                int min = Math.min(i11, length - 0);
                float[] fArr2 = new float[i11];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0091, code lost:
        if (r13 == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0093, code lost:
        r8.f4861a = true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0 A[Catch:{ NumberFormatException -> 0x00c4 }, LOOP:3: B:25:0x0073->B:45:0x00a0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x009f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static e0.h[] c(java.lang.String r16) {
        /*
            r0 = r16
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 1
            r4 = 0
        L_0x000e:
            int r5 = r16.length()
            if (r3 >= r5) goto L_0x00e9
        L_0x0014:
            int r5 = r16.length()
            r6 = 69
            r7 = 101(0x65, float:1.42E-43)
            if (r3 >= r5) goto L_0x003a
            char r5 = r0.charAt(r3)
            int r8 = r5 + -65
            int r9 = r5 + -90
            int r9 = r9 * r8
            if (r9 <= 0) goto L_0x0032
            int r8 = r5 + -97
            int r9 = r5 + -122
            int r9 = r9 * r8
            if (r9 > 0) goto L_0x0037
        L_0x0032:
            if (r5 == r7) goto L_0x0037
            if (r5 == r6) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x003a:
            java.lang.String r4 = r0.substring(r4, r3)
            java.lang.String r4 = r4.trim()
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x00e1
            char r5 = r4.charAt(r2)
            r8 = 122(0x7a, float:1.71E-43)
            if (r5 == r8) goto L_0x00d3
            char r5 = r4.charAt(r2)
            r8 = 90
            if (r5 != r8) goto L_0x005a
            goto L_0x00d3
        L_0x005a:
            int r5 = r4.length()     // Catch:{ NumberFormatException -> 0x00c4 }
            float[] r5 = new float[r5]     // Catch:{ NumberFormatException -> 0x00c4 }
            e0.g r8 = new e0.g     // Catch:{ NumberFormatException -> 0x00c4 }
            r8.<init>()     // Catch:{ NumberFormatException -> 0x00c4 }
            int r9 = r4.length()     // Catch:{ NumberFormatException -> 0x00c4 }
            r10 = 1
            r11 = 0
        L_0x006b:
            if (r10 >= r9) goto L_0x00bc
            r8.f4861a = r2     // Catch:{ NumberFormatException -> 0x00c4 }
            r2 = 0
            r12 = 0
            r13 = 0
            r14 = r10
        L_0x0073:
            int r15 = r4.length()     // Catch:{ NumberFormatException -> 0x00c4 }
            if (r14 >= r15) goto L_0x00a3
            char r15 = r4.charAt(r14)     // Catch:{ NumberFormatException -> 0x00c4 }
            r7 = 32
            if (r15 == r7) goto L_0x0099
            r7 = 101(0x65, float:1.42E-43)
            if (r15 == r6) goto L_0x0097
            if (r15 == r7) goto L_0x0097
            switch(r15) {
                case 44: goto L_0x009b;
                case 45: goto L_0x008f;
                case 46: goto L_0x008b;
                default: goto L_0x008a;
            }     // Catch:{ NumberFormatException -> 0x00c4 }
        L_0x008a:
            goto L_0x009c
        L_0x008b:
            if (r12 != 0) goto L_0x0093
            r12 = 1
            goto L_0x009c
        L_0x008f:
            if (r14 == r10) goto L_0x009c
            if (r13 != 0) goto L_0x009c
        L_0x0093:
            r2 = 1
            r8.f4861a = r2     // Catch:{ NumberFormatException -> 0x00c4 }
            goto L_0x009b
        L_0x0097:
            r13 = 1
            goto L_0x009d
        L_0x0099:
            r7 = 101(0x65, float:1.42E-43)
        L_0x009b:
            r2 = 1
        L_0x009c:
            r13 = 0
        L_0x009d:
            if (r2 == 0) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            int r14 = r14 + 1
            goto L_0x0073
        L_0x00a3:
            if (r10 >= r14) goto L_0x00b2
            int r2 = r11 + 1
            java.lang.String r10 = r4.substring(r10, r14)     // Catch:{ NumberFormatException -> 0x00c4 }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ NumberFormatException -> 0x00c4 }
            r5[r11] = r10     // Catch:{ NumberFormatException -> 0x00c4 }
            r11 = r2
        L_0x00b2:
            boolean r2 = r8.f4861a     // Catch:{ NumberFormatException -> 0x00c4 }
            if (r2 == 0) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            int r14 = r14 + 1
        L_0x00b9:
            r10 = r14
            r2 = 0
            goto L_0x006b
        L_0x00bc:
            float[] r2 = b(r5, r11)     // Catch:{ NumberFormatException -> 0x00c4 }
            r5 = 0
            r5 = r2
            r2 = 0
            goto L_0x00d5
        L_0x00c4:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "error in parsing \""
            java.lang.String r3 = "\""
            java.lang.String r2 = android.support.v4.media.h.n(r2, r4, r3)
            r1.<init>(r2, r0)
            throw r1
        L_0x00d3:
            float[] r5 = new float[r2]
        L_0x00d5:
            char r2 = r4.charAt(r2)
            e0.h r4 = new e0.h
            r4.<init>(r2, r5)
            r1.add(r4)
        L_0x00e1:
            int r2 = r3 + 1
            r4 = 0
            r4 = r3
            r3 = r2
            r2 = 0
            goto L_0x000e
        L_0x00e9:
            int r3 = r3 - r4
            r2 = 1
            if (r3 != r2) goto L_0x0102
            int r2 = r16.length()
            if (r4 >= r2) goto L_0x0102
            char r0 = r0.charAt(r4)
            r2 = 0
            float[] r2 = new float[r2]
            e0.h r3 = new e0.h
            r3.<init>(r0, r2)
            r1.add(r3)
        L_0x0102:
            int r0 = r1.size()
            e0.h[] r0 = new e0.h[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            e0.h[] r0 = (e0.h[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.i.c(java.lang.String):e0.h[]");
    }

    public static Path d(String str) {
        Path path = new Path();
        h[] c10 = c(str);
        if (c10 == null) {
            return null;
        }
        try {
            h.b(c10, path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException(h.m("Error in parsing ", str), e10);
        }
    }

    public static h[] e(h[] hVarArr) {
        if (hVarArr == null) {
            return null;
        }
        h[] hVarArr2 = new h[hVarArr.length];
        for (int i10 = 0; i10 < hVarArr.length; i10++) {
            hVarArr2[i10] = new h(hVarArr[i10]);
        }
        return hVarArr2;
    }
}

package va;

import fb.y;
import java.io.File;
import xa.j;

public class k extends j {
    public static final void a(File file) {
        e eVar = new e(new g(file));
        while (true) {
            boolean z10 = true;
            while (true) {
                if (eVar.hasNext()) {
                    File file2 = (File) eVar.next();
                    if (file2.delete() || !file2.exists()) {
                        if (z10) {
                        }
                    }
                    z10 = false;
                } else {
                    return;
                }
            }
        }
    }

    public static final String b(File file) {
        j.f("<this>", file);
        String name = file.getName();
        j.e("name", name);
        return y.K(name, '.', "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (r2 >= 0) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File c(java.io.File r7) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "image_cache"
            r0.<init>(r1)
            java.lang.String r1 = r0.getPath()
            java.lang.String r2 = "path"
            xa.j.e(r2, r1)
            char r2 = java.io.File.separatorChar
            r3 = 0
            r4 = 4
            int r2 = fb.y.t(r1, r2, r3, r3, r4)
            r5 = 1
            if (r2 != 0) goto L_0x003c
            int r2 = r1.length()
            if (r2 <= r5) goto L_0x003a
            char r2 = r1.charAt(r5)
            char r6 = java.io.File.separatorChar
            if (r2 != r6) goto L_0x003a
            r2 = 2
            int r2 = fb.y.t(r1, r6, r2, r3, r4)
            if (r2 < 0) goto L_0x003a
            char r6 = java.io.File.separatorChar
            int r2 = r2 + r5
            int r2 = fb.y.t(r1, r6, r2, r3, r4)
            if (r2 < 0) goto L_0x0054
            goto L_0x0048
        L_0x003a:
            r1 = 1
            goto L_0x005a
        L_0x003c:
            r4 = 58
            if (r2 <= 0) goto L_0x004b
            int r6 = r2 + -1
            char r6 = r1.charAt(r6)
            if (r6 != r4) goto L_0x004b
        L_0x0048:
            int r1 = r2 + 1
            goto L_0x005a
        L_0x004b:
            r5 = -1
            if (r2 != r5) goto L_0x0059
            boolean r2 = fb.y.p(r1, r4)
            if (r2 == 0) goto L_0x0059
        L_0x0054:
            int r1 = r1.length()
            goto L_0x005a
        L_0x0059:
            r1 = 0
        L_0x005a:
            if (r1 <= 0) goto L_0x005e
            r1 = 1
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x0062
            goto L_0x00a8
        L_0x0062:
            java.lang.String r7 = r7.toString()
            java.lang.String r1 = "this.toString()"
            xa.j.e(r1, r7)
            int r1 = r7.length()
            if (r1 != 0) goto L_0x0072
            r3 = 1
        L_0x0072:
            if (r3 != 0) goto L_0x0093
            char r1 = java.io.File.separatorChar
            boolean r1 = fb.y.p(r7, r1)
            if (r1 == 0) goto L_0x007d
            goto L_0x0093
        L_0x007d:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r7 = android.support.v4.media.h.q(r7)
            char r2 = java.io.File.separatorChar
            r7.append(r2)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r1.<init>(r7)
            goto L_0x00a7
        L_0x0093:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r0)
            java.lang.String r7 = r2.toString()
            r1.<init>(r7)
        L_0x00a7:
            r0 = r1
        L_0x00a8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: va.k.c(java.io.File):java.io.File");
    }
}

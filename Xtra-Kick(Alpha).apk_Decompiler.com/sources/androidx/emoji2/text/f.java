package androidx.emoji2.text;

public final class f {
    private f() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[EDGE_INSN: B:20:0x0048->B:12:0x0048 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.emoji2.text.a0 a(android.content.Context r7) {
        /*
            e.a r0 = new e.a
            r0.<init>()
            android.content.pm.PackageManager r1 = r7.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            l0.f.c(r1, r2)
            java.lang.Object r2 = r0.f4852i
            androidx.emoji2.text.c r2 = (androidx.emoji2.text.c) r2
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "androidx.content.action.LOAD_EMOJI_FONT"
            r3.<init>(r4)
            java.util.List r2 = r2.c(r1, r3)
            java.util.Iterator r2 = r2.iterator()
        L_0x0021:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0047
            java.lang.Object r3 = r2.next()
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3
            java.lang.Object r5 = r0.f4852i
            androidx.emoji2.text.c r5 = (androidx.emoji2.text.c) r5
            android.content.pm.ProviderInfo r3 = r5.a(r3)
            if (r3 == 0) goto L_0x0043
            android.content.pm.ApplicationInfo r5 = r3.applicationInfo
            if (r5 == 0) goto L_0x0043
            int r5 = r5.flags
            r6 = 1
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r6 = 0
        L_0x0044:
            if (r6 == 0) goto L_0x0021
            goto L_0x0048
        L_0x0047:
            r3 = r4
        L_0x0048:
            if (r3 != 0) goto L_0x004b
            goto L_0x0056
        L_0x004b:
            androidx.appcompat.widget.b0 r0 = r0.F(r3, r1)     // Catch:{ NameNotFoundException -> 0x0050 }
            goto L_0x0057
        L_0x0050:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
        L_0x0056:
            r0 = r4
        L_0x0057:
            if (r0 != 0) goto L_0x005a
            goto L_0x005f
        L_0x005a:
            androidx.emoji2.text.a0 r4 = new androidx.emoji2.text.a0
            r4.<init>(r7, r0)
        L_0x005f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.f.a(android.content.Context):androidx.emoji2.text.a0");
    }
}

package k0;

import android.text.SpannableStringBuilder;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final l f8942d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f8943e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    public static final String f8944f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    public static final c f8945g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f8946h;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8947a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8948b;

    /* renamed from: c  reason: collision with root package name */
    public final k f8949c;

    static {
        l lVar = n.f8961c;
        f8942d = lVar;
        f8945g = new c(false, 2, lVar);
        f8946h = new c(true, 2, lVar);
    }

    public c(boolean z10, int i10, l lVar) {
        this.f8947a = z10;
        this.f8948b = i10;
        this.f8949c = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0086, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
        r3 = r3 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.CharSequence r9) {
        /*
            k0.b r0 = new k0.b
            r0.<init>(r9)
            r9 = 0
            r0.f8940c = r9
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x000b:
            int r4 = r0.f8940c
            int r5 = r0.f8939b
            r6 = -1
            r7 = 1
            if (r4 >= r5) goto L_0x006e
            if (r1 != 0) goto L_0x006e
            java.lang.CharSequence r5 = r0.f8938a
            char r4 = r5.charAt(r4)
            r0.f8941d = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            if (r4 == 0) goto L_0x0037
            int r4 = r0.f8940c
            int r4 = java.lang.Character.codePointAt(r5, r4)
            int r5 = r0.f8940c
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.f8940c = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L_0x004b
        L_0x0037:
            int r4 = r0.f8940c
            int r4 = r4 + r7
            r0.f8940c = r4
            char r4 = r0.f8941d
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L_0x0047
            byte[] r5 = k0.b.f8937e
            byte r4 = r5[r4]
            goto L_0x004b
        L_0x0047:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L_0x004b:
            if (r4 == 0) goto L_0x0069
            if (r4 == r7) goto L_0x0066
            r5 = 2
            if (r4 == r5) goto L_0x0066
            r5 = 9
            if (r4 == r5) goto L_0x000b
            switch(r4) {
                case 14: goto L_0x0062;
                case 15: goto L_0x0062;
                case 16: goto L_0x005e;
                case 17: goto L_0x005e;
                case 18: goto L_0x005a;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x006c
        L_0x005a:
            int r3 = r3 + -1
            r2 = 0
            goto L_0x000b
        L_0x005e:
            int r3 = r3 + 1
            r2 = 1
            goto L_0x000b
        L_0x0062:
            int r3 = r3 + 1
            r2 = -1
            goto L_0x000b
        L_0x0066:
            if (r3 != 0) goto L_0x006c
            goto L_0x0086
        L_0x0069:
            if (r3 != 0) goto L_0x006c
            goto L_0x008a
        L_0x006c:
            r1 = r3
            goto L_0x000b
        L_0x006e:
            if (r1 != 0) goto L_0x0071
            goto L_0x008f
        L_0x0071:
            if (r2 == 0) goto L_0x0075
            r9 = r2
            goto L_0x008f
        L_0x0075:
            int r2 = r0.f8940c
            if (r2 <= 0) goto L_0x008f
            byte r2 = r0.a()
            switch(r2) {
                case 14: goto L_0x0088;
                case 15: goto L_0x0088;
                case 16: goto L_0x0084;
                case 17: goto L_0x0084;
                case 18: goto L_0x0081;
                default: goto L_0x0080;
            }
        L_0x0080:
            goto L_0x0075
        L_0x0081:
            int r3 = r3 + 1
            goto L_0x0075
        L_0x0084:
            if (r1 != r3) goto L_0x008c
        L_0x0086:
            r9 = 1
            goto L_0x008f
        L_0x0088:
            if (r1 != r3) goto L_0x008c
        L_0x008a:
            r9 = -1
            goto L_0x008f
        L_0x008c:
            int r3 = r3 + -1
            goto L_0x0075
        L_0x008f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.c.a(java.lang.CharSequence):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r1 = r1 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(java.lang.CharSequence r6) {
        /*
            k0.b r0 = new k0.b
            r0.<init>(r6)
            int r6 = r0.f8939b
            r0.f8940c = r6
            r6 = 0
            r1 = 0
            r2 = 0
        L_0x000c:
            int r3 = r0.f8940c
            if (r3 <= 0) goto L_0x0041
            byte r3 = r0.a()
            if (r3 == 0) goto L_0x0039
            r4 = 1
            if (r3 == r4) goto L_0x0032
            r5 = 2
            if (r3 == r5) goto L_0x0032
            r5 = 9
            if (r3 == r5) goto L_0x000c
            switch(r3) {
                case 14: goto L_0x002c;
                case 15: goto L_0x002c;
                case 16: goto L_0x0029;
                case 17: goto L_0x0029;
                case 18: goto L_0x0026;
                default: goto L_0x0023;
            }
        L_0x0023:
            if (r2 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0029:
            if (r2 != r1) goto L_0x002f
            goto L_0x0034
        L_0x002c:
            if (r2 != r1) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            int r1 = r1 + -1
            goto L_0x000c
        L_0x0032:
            if (r1 != 0) goto L_0x0036
        L_0x0034:
            r6 = 1
            goto L_0x0041
        L_0x0036:
            if (r2 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0039:
            if (r1 != 0) goto L_0x003d
        L_0x003b:
            r6 = -1
            goto L_0x0041
        L_0x003d:
            if (r2 != 0) goto L_0x000c
        L_0x003f:
            r2 = r1
            goto L_0x000c
        L_0x0041:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.c.b(java.lang.CharSequence):int");
    }

    public static c c() {
        a aVar = new a();
        int i10 = aVar.f8935b;
        if (i10 != 2 || aVar.f8936c != f8942d) {
            return new c(aVar.f8934a, i10, aVar.f8936c);
        }
        if (aVar.f8934a) {
            return f8946h;
        }
        return f8945g;
    }

    public final SpannableStringBuilder d(CharSequence charSequence, k kVar) {
        boolean z10;
        l lVar;
        char c10;
        l lVar2;
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean b10 = kVar.b(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if ((this.f8948b & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str2 = f8944f;
        String str3 = f8943e;
        boolean z11 = this.f8947a;
        if (z10) {
            if (b10) {
                lVar2 = n.f8960b;
            } else {
                lVar2 = n.f8959a;
            }
            boolean b11 = lVar2.b(charSequence, charSequence.length());
            if (!z11 && (b11 || a(charSequence) == 1)) {
                str = str3;
            } else if (!z11 || (b11 && a(charSequence) != -1)) {
                str = "";
            } else {
                str = str2;
            }
            spannableStringBuilder.append(str);
        }
        if (b10 != z11) {
            if (b10) {
                c10 = 8235;
            } else {
                c10 = 8234;
            }
            spannableStringBuilder.append(c10);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (b10) {
            lVar = n.f8960b;
        } else {
            lVar = n.f8959a;
        }
        boolean b12 = lVar.b(charSequence, charSequence.length());
        if (!z11 && (b12 || b(charSequence) == 1)) {
            str2 = str3;
        } else if (!z11 || (b12 && b(charSequence) != -1)) {
            str2 = "";
        }
        spannableStringBuilder.append(str2);
        return spannableStringBuilder;
    }
}

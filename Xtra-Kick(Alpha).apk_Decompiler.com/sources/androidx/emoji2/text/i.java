package androidx.emoji2.text;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import e.a;
import l.h;
import v0.b;

public final class i extends a {

    /* renamed from: j  reason: collision with root package name */
    public volatile w f1259j;

    /* renamed from: k  reason: collision with root package name */
    public volatile h f1260k;

    public i(p pVar) {
        super(17, (Object) pVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0140, code lost:
        if (r5 != false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0143, code lost:
        if (r5 == false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0145, code lost:
        ((androidx.emoji2.text.f0) r1).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ all -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f A[Catch:{ all -> 0x014d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.CharSequence I(java.lang.CharSequence r17, int r18, int r19, boolean r20) {
        /*
            r16 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r16
            androidx.emoji2.text.w r4 = r3.f1259j
            r4.getClass()
            boolean r5 = r1 instanceof androidx.emoji2.text.f0
            if (r5 == 0) goto L_0x0017
            r6 = r1
            androidx.emoji2.text.f0 r6 = (androidx.emoji2.text.f0) r6
            r6.a()
        L_0x0017:
            java.lang.Class<androidx.emoji2.text.g0> r6 = androidx.emoji2.text.g0.class
            if (r5 != 0) goto L_0x0039
            boolean r7 = r1 instanceof android.text.Spannable     // Catch:{ all -> 0x014d }
            if (r7 == 0) goto L_0x0020
            goto L_0x0039
        L_0x0020:
            boolean r7 = r1 instanceof android.text.Spanned     // Catch:{ all -> 0x014d }
            if (r7 == 0) goto L_0x0037
            r7 = r1
            android.text.Spanned r7 = (android.text.Spanned) r7     // Catch:{ all -> 0x014d }
            int r8 = r0 + -1
            int r9 = r2 + 1
            int r7 = r7.nextSpanTransition(r8, r9, r6)     // Catch:{ all -> 0x014d }
            if (r7 > r2) goto L_0x0037
            androidx.emoji2.text.j0 r7 = new androidx.emoji2.text.j0     // Catch:{ all -> 0x014d }
            r7.<init>((java.lang.CharSequence) r1)     // Catch:{ all -> 0x014d }
            goto L_0x0041
        L_0x0037:
            r7 = 0
            goto L_0x0041
        L_0x0039:
            androidx.emoji2.text.j0 r7 = new androidx.emoji2.text.j0     // Catch:{ all -> 0x014d }
            r8 = r1
            android.text.Spannable r8 = (android.text.Spannable) r8     // Catch:{ all -> 0x014d }
            r7.<init>((android.text.Spannable) r8)     // Catch:{ all -> 0x014d }
        L_0x0041:
            r8 = 0
            if (r7 == 0) goto L_0x006d
            java.lang.Object[] r6 = r7.getSpans(r0, r2, r6)     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.g0[] r6 = (androidx.emoji2.text.g0[]) r6     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x006d
            int r9 = r6.length     // Catch:{ all -> 0x014d }
            if (r9 <= 0) goto L_0x006d
            int r9 = r6.length     // Catch:{ all -> 0x014d }
            r10 = 0
        L_0x0051:
            if (r10 >= r9) goto L_0x006d
            r11 = r6[r10]     // Catch:{ all -> 0x014d }
            int r12 = r7.getSpanStart(r11)     // Catch:{ all -> 0x014d }
            int r13 = r7.getSpanEnd(r11)     // Catch:{ all -> 0x014d }
            if (r12 == r2) goto L_0x0062
            r7.removeSpan(r11)     // Catch:{ all -> 0x014d }
        L_0x0062:
            int r0 = java.lang.Math.min(r12, r0)     // Catch:{ all -> 0x014d }
            int r2 = java.lang.Math.max(r13, r2)     // Catch:{ all -> 0x014d }
            int r10 = r10 + 1
            goto L_0x0051
        L_0x006d:
            if (r0 == r2) goto L_0x0143
            int r6 = r17.length()     // Catch:{ all -> 0x014d }
            if (r0 < r6) goto L_0x0077
            goto L_0x0143
        L_0x0077:
            androidx.emoji2.text.v r6 = new androidx.emoji2.text.v     // Catch:{ all -> 0x014d }
            java.lang.Object r9 = r4.f1296c     // Catch:{ all -> 0x014d }
            l.h r9 = (l.h) r9     // Catch:{ all -> 0x014d }
            java.lang.Object r9 = r9.f9449k     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.d0 r9 = (androidx.emoji2.text.d0) r9     // Catch:{ all -> 0x014d }
            boolean r10 = r4.f1294a     // Catch:{ all -> 0x014d }
            java.lang.Object r11 = r4.f1298e     // Catch:{ all -> 0x014d }
            int[] r11 = (int[]) r11     // Catch:{ all -> 0x014d }
            r6.<init>(r9, r10, r11)     // Catch:{ all -> 0x014d }
            int r9 = java.lang.Character.codePointAt(r1, r0)     // Catch:{ all -> 0x014d }
            r10 = 0
        L_0x008f:
            r11 = r9
            r9 = r0
        L_0x0091:
            r12 = 33
            r13 = 1
            r14 = 2147483647(0x7fffffff, float:NaN)
            r15 = 2
            if (r0 >= r2) goto L_0x00f4
            if (r10 >= r14) goto L_0x00f4
            int r14 = r6.a(r11)     // Catch:{ all -> 0x014d }
            if (r14 == r13) goto L_0x00e3
            if (r14 == r15) goto L_0x00d7
            r13 = 3
            if (r14 == r13) goto L_0x00a8
            goto L_0x0091
        L_0x00a8:
            if (r20 != 0) goto L_0x00b4
            androidx.emoji2.text.d0 r13 = r6.f1289d     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.u r13 = r13.f1248b     // Catch:{ all -> 0x014d }
            boolean r13 = r4.b(r1, r9, r0, r13)     // Catch:{ all -> 0x014d }
            if (r13 != 0) goto L_0x00d5
        L_0x00b4:
            if (r7 != 0) goto L_0x00c0
            androidx.emoji2.text.j0 r7 = new androidx.emoji2.text.j0     // Catch:{ all -> 0x014d }
            android.text.SpannableString r13 = new android.text.SpannableString     // Catch:{ all -> 0x014d }
            r13.<init>(r1)     // Catch:{ all -> 0x014d }
            r7.<init>((android.text.Spannable) r13)     // Catch:{ all -> 0x014d }
        L_0x00c0:
            androidx.emoji2.text.d0 r13 = r6.f1289d     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.u r13 = r13.f1248b     // Catch:{ all -> 0x014d }
            java.lang.Object r14 = r4.f1295b     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.o r14 = (androidx.emoji2.text.o) r14     // Catch:{ all -> 0x014d }
            r14.getClass()     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.g0 r14 = new androidx.emoji2.text.g0     // Catch:{ all -> 0x014d }
            r14.<init>(r13)     // Catch:{ all -> 0x014d }
            r7.setSpan(r14, r9, r0, r12)     // Catch:{ all -> 0x014d }
            int r10 = r10 + 1
        L_0x00d5:
            r9 = r11
            goto L_0x008f
        L_0x00d7:
            int r12 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x014d }
            int r0 = r0 + r12
            if (r0 >= r2) goto L_0x0091
            int r11 = java.lang.Character.codePointAt(r1, r0)     // Catch:{ all -> 0x014d }
            goto L_0x0091
        L_0x00e3:
            int r0 = java.lang.Character.codePointAt(r1, r9)     // Catch:{ all -> 0x014d }
            int r0 = java.lang.Character.charCount(r0)     // Catch:{ all -> 0x014d }
            int r9 = r9 + r0
            if (r9 >= r2) goto L_0x00f2
            int r11 = java.lang.Character.codePointAt(r1, r9)     // Catch:{ all -> 0x014d }
        L_0x00f2:
            r0 = r9
            goto L_0x0091
        L_0x00f4:
            int r2 = r6.f1286a     // Catch:{ all -> 0x014d }
            if (r2 != r15) goto L_0x0109
            androidx.emoji2.text.d0 r2 = r6.f1288c     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.u r2 = r2.f1248b     // Catch:{ all -> 0x014d }
            if (r2 == 0) goto L_0x0109
            int r2 = r6.f1291f     // Catch:{ all -> 0x014d }
            if (r2 > r13) goto L_0x0108
            boolean r2 = r6.c()     // Catch:{ all -> 0x014d }
            if (r2 == 0) goto L_0x0109
        L_0x0108:
            r8 = 1
        L_0x0109:
            if (r8 == 0) goto L_0x0134
            if (r10 >= r14) goto L_0x0134
            if (r20 != 0) goto L_0x0119
            androidx.emoji2.text.d0 r2 = r6.f1288c     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.u r2 = r2.f1248b     // Catch:{ all -> 0x014d }
            boolean r2 = r4.b(r1, r9, r0, r2)     // Catch:{ all -> 0x014d }
            if (r2 != 0) goto L_0x0134
        L_0x0119:
            if (r7 != 0) goto L_0x0121
            androidx.emoji2.text.j0 r2 = new androidx.emoji2.text.j0     // Catch:{ all -> 0x014d }
            r2.<init>((java.lang.CharSequence) r1)     // Catch:{ all -> 0x014d }
            r7 = r2
        L_0x0121:
            androidx.emoji2.text.d0 r2 = r6.f1288c     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.u r2 = r2.f1248b     // Catch:{ all -> 0x014d }
            java.lang.Object r4 = r4.f1295b     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.o r4 = (androidx.emoji2.text.o) r4     // Catch:{ all -> 0x014d }
            r4.getClass()     // Catch:{ all -> 0x014d }
            androidx.emoji2.text.g0 r4 = new androidx.emoji2.text.g0     // Catch:{ all -> 0x014d }
            r4.<init>(r2)     // Catch:{ all -> 0x014d }
            r7.setSpan(r4, r9, r0, r12)     // Catch:{ all -> 0x014d }
        L_0x0134:
            if (r7 == 0) goto L_0x0140
            android.text.Spannable r0 = r7.f1265i     // Catch:{ all -> 0x014d }
            if (r5 == 0) goto L_0x014c
            androidx.emoji2.text.f0 r1 = (androidx.emoji2.text.f0) r1
            r1.b()
            goto L_0x014c
        L_0x0140:
            if (r5 == 0) goto L_0x014b
            goto L_0x0145
        L_0x0143:
            if (r5 == 0) goto L_0x014b
        L_0x0145:
            r0 = r1
            androidx.emoji2.text.f0 r0 = (androidx.emoji2.text.f0) r0
            r0.b()
        L_0x014b:
            r0 = r1
        L_0x014c:
            return r0
        L_0x014d:
            r0 = move-exception
            if (r5 == 0) goto L_0x0155
            androidx.emoji2.text.f0 r1 = (androidx.emoji2.text.f0) r1
            r1.b()
        L_0x0155:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.i.I(java.lang.CharSequence, int, int, boolean):java.lang.CharSequence");
    }

    public final void J(EditorInfo editorInfo) {
        int i10;
        Bundle bundle = editorInfo.extras;
        b bVar = (b) this.f1260k.f9447i;
        int a10 = bVar.a(4);
        if (a10 != 0) {
            i10 = bVar.f15552b.getInt(a10 + bVar.f15551a);
        } else {
            i10 = 0;
        }
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i10);
        Bundle bundle2 = editorInfo.extras;
        ((p) this.f4852i).getClass();
        bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }
}

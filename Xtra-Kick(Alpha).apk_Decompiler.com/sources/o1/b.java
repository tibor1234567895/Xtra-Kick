package o1;

import d9.s0;
import d9.t0;
import java.util.Arrays;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f11855c = new b(new int[]{2}, 8);

    /* renamed from: d  reason: collision with root package name */
    public static final b f11856d = new b(new int[]{2, 5, 6}, 8);

    /* renamed from: e  reason: collision with root package name */
    public static final t0 f11857e;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f11858a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11859b;

    static {
        s0 s0Var = new s0();
        s0Var.b(5, 6);
        s0Var.b(17, 6);
        s0Var.b(7, 6);
        s0Var.b(18, 6);
        s0Var.b(6, 8);
        s0Var.b(8, 8);
        s0Var.b(14, 8);
        f11857e = s0Var.a();
    }

    public b(int[] iArr, int i10) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f11858a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f11858a = new int[0];
        }
        this.f11859b = i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair a(g1.a0 r12) {
        /*
            r11 = this;
            java.lang.String r0 = r12.f6276s
            r0.getClass()
            java.lang.String r1 = r12.f6273p
            int r0 = g1.a1.c(r0, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            d9.t0 r2 = f11857e
            boolean r1 = r2.containsKey(r1)
            r3 = 0
            if (r1 != 0) goto L_0x0019
            return r3
        L_0x0019:
            r1 = 8
            r4 = 6
            r5 = 7
            int[] r6 = r11.f11858a
            r7 = 1
            r8 = 0
            r9 = 18
            if (r0 != r9) goto L_0x0032
            int r10 = java.util.Arrays.binarySearch(r6, r9)
            if (r10 < 0) goto L_0x002d
            r10 = 1
            goto L_0x002e
        L_0x002d:
            r10 = 0
        L_0x002e:
            if (r10 != 0) goto L_0x0032
            r0 = 6
            goto L_0x0040
        L_0x0032:
            if (r0 != r1) goto L_0x0040
            int r10 = java.util.Arrays.binarySearch(r6, r1)
            if (r10 < 0) goto L_0x003c
            r10 = 1
            goto L_0x003d
        L_0x003c:
            r10 = 0
        L_0x003d:
            if (r10 != 0) goto L_0x0040
            r0 = 7
        L_0x0040:
            int r6 = java.util.Arrays.binarySearch(r6, r0)
            if (r6 < 0) goto L_0x0048
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            if (r6 != 0) goto L_0x004c
            return r3
        L_0x004c:
            r6 = -1
            int r10 = r12.F
            if (r10 == r6) goto L_0x0059
            if (r0 != r9) goto L_0x0054
            goto L_0x0059
        L_0x0054:
            int r12 = r11.f11859b
            if (r10 <= r12) goto L_0x0082
            return r3
        L_0x0059:
            int r12 = r12.G
            if (r12 == r6) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r12 = 48000(0xbb80, float:6.7262E-41)
        L_0x0061:
            int r6 = j1.l0.f8453a
            r9 = 29
            if (r6 < r9) goto L_0x006c
            int r12 = o1.a.b(r0, r12)
            goto L_0x0081
        L_0x006c:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            java.lang.Object r12 = r2.getOrDefault(r12, r6)
            java.lang.Integer r12 = (java.lang.Integer) r12
            r12.getClass()
            int r12 = r12.intValue()
        L_0x0081:
            r10 = r12
        L_0x0082:
            int r12 = j1.l0.f8453a
            r2 = 28
            if (r12 > r2) goto L_0x0096
            if (r10 != r5) goto L_0x008b
            goto L_0x0097
        L_0x008b:
            r1 = 3
            if (r10 == r1) goto L_0x0094
            r1 = 4
            if (r10 == r1) goto L_0x0094
            r1 = 5
            if (r10 != r1) goto L_0x0096
        L_0x0094:
            r1 = 6
            goto L_0x0097
        L_0x0096:
            r1 = r10
        L_0x0097:
            r2 = 26
            if (r12 > r2) goto L_0x00a8
            java.lang.String r12 = "fugu"
            java.lang.String r2 = j1.l0.f8454b
            boolean r12 = r12.equals(r2)
            if (r12 == 0) goto L_0x00a8
            if (r1 != r7) goto L_0x00a8
            r1 = 2
        L_0x00a8:
            int r12 = j1.l0.m(r1)
            if (r12 != 0) goto L_0x00af
            return r3
        L_0x00af:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            android.util.Pair r12 = android.util.Pair.create(r0, r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.b.a(g1.a0):android.util.Pair");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Arrays.equals(this.f11858a, bVar.f11858a) && this.f11859b == bVar.f11859b;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f11858a) * 31) + this.f11859b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f11859b + ", supportedEncodings=" + Arrays.toString(this.f11858a) + "]";
    }
}

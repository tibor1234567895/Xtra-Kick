package e3;

import androidx.recyclerview.widget.RecyclerView;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public long f5020a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f5021b = 0;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f5022c;

    /* renamed from: d  reason: collision with root package name */
    public int f5023d = 2;

    /* renamed from: e  reason: collision with root package name */
    public float f5024e = -3.4028235E38f;

    /* renamed from: f  reason: collision with root package name */
    public int f5025f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f5026g = 0;

    /* renamed from: h  reason: collision with root package name */
    public float f5027h = -3.4028235E38f;

    /* renamed from: i  reason: collision with root package name */
    public int f5028i = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: j  reason: collision with root package name */
    public float f5029j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public int f5030k = RecyclerView.UNDEFINED_DURATION;

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0072, code lost:
        if (r5 == 0) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final i1.a a() {
        /*
            r13 = this;
            float r0 = r13.f5027h
            r1 = 1056964608(0x3f000000, float:0.5)
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 5
            r5 = 4
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r7 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r7 == 0) goto L_0x0011
            goto L_0x001e
        L_0x0011:
            int r0 = r13.f5023d
            if (r0 == r5) goto L_0x001d
            if (r0 == r4) goto L_0x001a
            r0 = 1056964608(0x3f000000, float:0.5)
            goto L_0x001e
        L_0x001a:
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            int r7 = r13.f5028i
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = 3
            r10 = 2
            r11 = 1
            if (r7 == r8) goto L_0x0028
            goto L_0x0037
        L_0x0028:
            int r7 = r13.f5023d
            if (r7 == r11) goto L_0x0036
            if (r7 == r9) goto L_0x0034
            if (r7 == r5) goto L_0x0036
            if (r7 == r4) goto L_0x0034
            r7 = 1
            goto L_0x0037
        L_0x0034:
            r7 = 2
            goto L_0x0037
        L_0x0036:
            r7 = 0
        L_0x0037:
            i1.a r8 = new i1.a
            r8.<init>()
            int r12 = r13.f5023d
            if (r12 == r11) goto L_0x0057
            if (r12 == r10) goto L_0x0054
            if (r12 == r9) goto L_0x0051
            if (r12 == r5) goto L_0x0057
            if (r12 == r4) goto L_0x0051
            java.lang.String r4 = "Unknown textAlignment: "
            java.lang.String r5 = "WebvttCueParser"
            android.support.v4.media.h.z(r4, r12, r5)
            r4 = 0
            goto L_0x0059
        L_0x0051:
            android.text.Layout$Alignment r4 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x0059
        L_0x0054:
            android.text.Layout$Alignment r4 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x0059
        L_0x0057:
            android.text.Layout$Alignment r4 = android.text.Layout.Alignment.ALIGN_NORMAL
        L_0x0059:
            r8.f7955c = r4
            float r4 = r13.f5024e
            int r5 = r13.f5025f
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x006e
            if (r5 != 0) goto L_0x006e
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0074
            int r2 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x006e
            goto L_0x0074
        L_0x006e:
            if (r9 == 0) goto L_0x0072
            r6 = r4
            goto L_0x0076
        L_0x0072:
            if (r5 != 0) goto L_0x0076
        L_0x0074:
            r6 = 1065353216(0x3f800000, float:1.0)
        L_0x0076:
            r8.f7957e = r6
            r8.f7958f = r5
            int r2 = r13.f5026g
            r8.f7959g = r2
            r8.f7960h = r0
            r8.f7961i = r7
            float r2 = r13.f5029j
            if (r7 == 0) goto L_0x00a2
            if (r7 == r11) goto L_0x0095
            if (r7 != r10) goto L_0x008b
            goto L_0x00a4
        L_0x008b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = java.lang.String.valueOf(r7)
            r0.<init>(r1)
            throw r0
        L_0x0095:
            r4 = 1073741824(0x40000000, float:2.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x009e
            float r0 = r0 * r4
            goto L_0x00a4
        L_0x009e:
            float r3 = r3 - r0
            float r0 = r3 * r4
            goto L_0x00a4
        L_0x00a2:
            float r0 = r3 - r0
        L_0x00a4:
            float r0 = java.lang.Math.min(r2, r0)
            r8.f7964l = r0
            int r0 = r13.f5030k
            r8.f7968p = r0
            java.lang.CharSequence r0 = r13.f5022c
            if (r0 == 0) goto L_0x00b4
            r8.f7953a = r0
        L_0x00b4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.h.a():i1.a");
    }
}

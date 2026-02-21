package d3;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import c9.h;
import j1.b0;
import j1.l0;
import j1.v;
import java.nio.charset.Charset;
import java.util.List;
import w2.c;
import w2.d;
import w2.f;

public final class a extends c {

    /* renamed from: m  reason: collision with root package name */
    public final b0 f4316m = new b0();

    /* renamed from: n  reason: collision with root package name */
    public final boolean f4317n;

    /* renamed from: o  reason: collision with root package name */
    public final int f4318o;

    /* renamed from: p  reason: collision with root package name */
    public final int f4319p;

    /* renamed from: q  reason: collision with root package name */
    public final String f4320q;

    /* renamed from: r  reason: collision with root package name */
    public final float f4321r;

    /* renamed from: s  reason: collision with root package name */
    public final int f4322s;

    public a(List list) {
        String str = "sans-serif";
        boolean z10 = false;
        if (list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.f4318o = bArr[24];
            this.f4319p = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            int i10 = l0.f8453a;
            this.f4320q = "Serif".equals(new String(bArr, 43, bArr.length - 43, h.f3035c)) ? "serif" : str;
            int i11 = bArr[25] * 20;
            this.f4322s = i11;
            z10 = (bArr[0] & 32) != 0 ? true : z10;
            this.f4317n = z10;
            if (z10) {
                this.f4321r = l0.g(((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i11), 0.0f, 0.95f);
            } else {
                this.f4321r = 0.85f;
            }
        } else {
            this.f4318o = 0;
            this.f4319p = -1;
            this.f4320q = str;
            this.f4317n = false;
            this.f4321r = 0.85f;
            this.f4322s = -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i(android.text.SpannableStringBuilder r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            if (r6 == r7) goto L_0x004c
            r7 = r10 | 33
            r10 = r6 & 1
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x000c
            r10 = 1
            goto L_0x000d
        L_0x000c:
            r10 = 0
        L_0x000d:
            r2 = r6 & 2
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            if (r10 == 0) goto L_0x0023
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            if (r2 == 0) goto L_0x001f
            r4 = 3
            r3.<init>(r4)
            goto L_0x002b
        L_0x001f:
            r3.<init>(r1)
            goto L_0x002b
        L_0x0023:
            if (r2 == 0) goto L_0x002e
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r4 = 2
            r3.<init>(r4)
        L_0x002b:
            r5.setSpan(r3, r8, r9, r7)
        L_0x002e:
            r6 = r6 & 4
            if (r6 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            if (r1 == 0) goto L_0x003e
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            r5.setSpan(r6, r8, r9, r7)
        L_0x003e:
            if (r1 != 0) goto L_0x004c
            if (r10 != 0) goto L_0x004c
            if (r2 != 0) goto L_0x004c
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r0)
            r5.setSpan(r6, r8, r9, r7)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.a.i(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    public final d f(byte[] bArr, int i10, boolean z10) {
        boolean z11;
        String str;
        float f10;
        boolean z12;
        boolean z13;
        boolean z14;
        int i11;
        float f11;
        int i12;
        int i13;
        b0 b0Var = this.f4316m;
        b0Var.E(i10, bArr);
        int i14 = 1;
        int i15 = 2;
        if (b0Var.f8416c - b0Var.f8415b >= 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int A = b0Var.A();
            if (A == 0) {
                str = "";
            } else {
                int i16 = b0Var.f8415b;
                Charset C = b0Var.C();
                int i17 = A - (b0Var.f8415b - i16);
                if (C == null) {
                    C = h.f3035c;
                }
                str = b0Var.t(i17, C);
            }
            if (str.isEmpty()) {
                return b.f4323i;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            i(spannableStringBuilder, this.f4318o, 0, 0, spannableStringBuilder.length(), 16711680);
            int length = spannableStringBuilder.length();
            int i18 = this.f4319p;
            if (i18 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(((i18 & 255) << 24) | (i18 >>> 8)), 0, length, 16711713);
            }
            int length2 = spannableStringBuilder.length();
            String str2 = this.f4320q;
            if (str2 != "sans-serif") {
                spannableStringBuilder.setSpan(new TypefaceSpan(str2), 0, length2, 16711713);
            }
            float f12 = this.f4321r;
            while (true) {
                int i19 = b0Var.f8416c;
                int i20 = b0Var.f8415b;
                if (i19 - i20 >= 8) {
                    int f13 = b0Var.f();
                    int f14 = b0Var.f();
                    if (f14 == 1937013100) {
                        if (b0Var.f8416c - b0Var.f8415b >= i15) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z13) {
                            int A2 = b0Var.A();
                            int i21 = 0;
                            while (i21 < A2) {
                                if (b0Var.f8416c - b0Var.f8415b >= 12) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                if (z14) {
                                    int A3 = b0Var.A();
                                    int A4 = b0Var.A();
                                    b0Var.H(i15);
                                    int v10 = b0Var.v();
                                    b0Var.H(i14);
                                    int f15 = b0Var.f();
                                    int i22 = i21;
                                    if (A4 > spannableStringBuilder.length()) {
                                        i11 = A2;
                                        StringBuilder r10 = android.support.v4.media.h.r("Truncating styl end (", A4, ") to cueText.length() (");
                                        r10.append(spannableStringBuilder.length());
                                        r10.append(").");
                                        v.g("Tx3gDecoder", r10.toString());
                                        A4 = spannableStringBuilder.length();
                                    } else {
                                        i11 = A2;
                                    }
                                    int i23 = A4;
                                    if (A3 >= i23) {
                                        v.g("Tx3gDecoder", "Ignoring styl with start (" + A3 + ") >= end (" + i23 + ").");
                                        i13 = i22;
                                        i12 = i11;
                                        f11 = f12;
                                    } else {
                                        i13 = i22;
                                        f11 = f12;
                                        int i24 = A3;
                                        i12 = i11;
                                        i(spannableStringBuilder, v10, this.f4318o, A3, i23, 0);
                                        if (f15 != i18) {
                                            spannableStringBuilder.setSpan(new ForegroundColorSpan((f15 >>> 8) | ((f15 & 255) << 24)), i24, i23, 33);
                                        }
                                    }
                                    i21 = i13 + 1;
                                    i14 = 1;
                                    i15 = 2;
                                    f12 = f11;
                                    A2 = i12;
                                } else {
                                    throw new f("Unexpected subtitle format.");
                                }
                            }
                            f10 = f12;
                        } else {
                            throw new f("Unexpected subtitle format.");
                        }
                    } else {
                        f10 = f12;
                        if (f14 == 1952608120 && this.f4317n) {
                            if (b0Var.f8416c - b0Var.f8415b >= 2) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                                f12 = l0.g(((float) b0Var.A()) / ((float) this.f4322s), 0.0f, 0.95f);
                                b0Var.G(i20 + f13);
                                i14 = 1;
                                i15 = 2;
                            } else {
                                throw new f("Unexpected subtitle format.");
                            }
                        }
                    }
                    f12 = f10;
                    b0Var.G(i20 + f13);
                    i14 = 1;
                    i15 = 2;
                } else {
                    float f16 = f12;
                    i1.a aVar = new i1.a();
                    aVar.f7953a = spannableStringBuilder;
                    aVar.f7957e = f16;
                    aVar.f7958f = 0;
                    aVar.f7959g = 0;
                    return new b(aVar.a());
                }
            }
        } else {
            throw new f("Unexpected subtitle format.");
        }
    }
}

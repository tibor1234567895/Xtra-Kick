package s1;

import g1.a0;

public final class s extends Exception {

    /* renamed from: h  reason: collision with root package name */
    public final String f14041h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f14042i;

    /* renamed from: j  reason: collision with root package name */
    public final q f14043j;

    /* renamed from: k  reason: collision with root package name */
    public final String f14044k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public s(int i10, a0 a0Var, y yVar, boolean z10) {
        this("Decoder init failed: [" + i10 + "], " + a0Var, yVar, a0Var.f6276s, z10, (q) null, "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i10 < 0 ? "neg_" : "") + Math.abs(i10));
    }

    public s(String str, Throwable th, String str2, boolean z10, q qVar, String str3) {
        super(str, th);
        this.f14041h = str2;
        this.f14042i = z10;
        this.f14043j = qVar;
        this.f14044k = str3;
    }
}

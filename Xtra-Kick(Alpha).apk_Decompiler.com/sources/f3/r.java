package f3;

import android.util.SparseArray;
import d2.r0;
import d2.x0;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f5698a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5699b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5700c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray f5701d = new SparseArray();

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray f5702e = new SparseArray();

    /* renamed from: f  reason: collision with root package name */
    public final r0 f5703f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f5704g;

    /* renamed from: h  reason: collision with root package name */
    public int f5705h;

    /* renamed from: i  reason: collision with root package name */
    public int f5706i;

    /* renamed from: j  reason: collision with root package name */
    public long f5707j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5708k;

    /* renamed from: l  reason: collision with root package name */
    public long f5709l;

    /* renamed from: m  reason: collision with root package name */
    public q f5710m = new q(0);

    /* renamed from: n  reason: collision with root package name */
    public q f5711n = new q(0);

    /* renamed from: o  reason: collision with root package name */
    public boolean f5712o;

    /* renamed from: p  reason: collision with root package name */
    public long f5713p;

    /* renamed from: q  reason: collision with root package name */
    public long f5714q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5715r;

    public r(x0 x0Var, boolean z10, boolean z11) {
        this.f5698a = x0Var;
        this.f5699b = z10;
        this.f5700c = z11;
        byte[] bArr = new byte[128];
        this.f5704g = bArr;
        this.f5703f = new r0(0, 0, 0, bArr);
        this.f5708k = false;
        this.f5712o = false;
        q qVar = this.f5711n;
        qVar.f5683b = false;
        qVar.f5682a = false;
    }
}

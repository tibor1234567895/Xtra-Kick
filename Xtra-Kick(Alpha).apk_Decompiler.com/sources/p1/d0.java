package p1;

import j1.l0;
import java.util.UUID;
import l1.b;

public final class d0 implements b {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f12419d;

    /* renamed from: a  reason: collision with root package name */
    public final UUID f12420a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f12421b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f12422c;

    static {
        boolean z10;
        if ("Amazon".equals(l0.f8455c)) {
            String str = l0.f8456d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z10 = true;
                f12419d = z10;
            }
        }
        z10 = false;
        f12419d = z10;
    }

    public d0(UUID uuid, byte[] bArr, boolean z10) {
        this.f12420a = uuid;
        this.f12421b = bArr;
        this.f12422c = z10;
    }
}

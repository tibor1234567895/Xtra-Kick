package r1;

import d9.p0;
import d9.r0;
import d9.r1;
import g1.u;
import java.util.ArrayList;
import java.util.List;

public final class i extends j {

    /* renamed from: s  reason: collision with root package name */
    public final String f13564s;

    /* renamed from: t  reason: collision with root package name */
    public final r0 f13565t;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i(String str, long j10, long j11, String str2, String str3) {
        this(str, (i) null, "", 0, -1, -9223372036854775807L, (u) null, str2, str3, j10, j11, false, r1.f4658l);
        p0 p0Var = r0.f4657i;
    }

    public final i a(int i10, long j10) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        long j11 = j10;
        while (true) {
            r0 r0Var = this.f13565t;
            if (i11 < r0Var.size()) {
                g gVar = (g) r0Var.get(i11);
                arrayList.add(new g(gVar.f13566h, gVar.f13567i, gVar.f13568j, i10, j11, gVar.f13571m, gVar.f13572n, gVar.f13573o, gVar.f13574p, gVar.f13575q, gVar.f13576r, gVar.f13559s, gVar.f13560t));
                j11 += gVar.f13568j;
                i11++;
            } else {
                return new i(this.f13566h, this.f13567i, this.f13564s, this.f13568j, i10, j10, this.f13571m, this.f13572n, this.f13573o, this.f13574p, this.f13575q, this.f13576r, arrayList);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(String str, i iVar, String str2, long j10, int i10, long j11, u uVar, String str3, String str4, long j12, long j13, boolean z10, List list) {
        super(str, iVar, j10, i10, j11, uVar, str3, str4, j12, j13, z10);
        this.f13564s = str2;
        this.f13565t = r0.j(list);
    }
}

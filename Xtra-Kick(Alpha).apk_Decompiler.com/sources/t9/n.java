package t9;

import android.os.Handler;
import q9.h;
import u9.a;
import xa.j;
import y9.p;
import z5.i;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final p f14887a;

    /* renamed from: b  reason: collision with root package name */
    public final h f14888b;

    /* renamed from: c  reason: collision with root package name */
    public final a f14889c;

    /* renamed from: d  reason: collision with root package name */
    public final l.h f14890d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f14891e;

    /* renamed from: f  reason: collision with root package name */
    public final s9.a f14892f;

    /* renamed from: g  reason: collision with root package name */
    public final i f14893g;

    /* renamed from: h  reason: collision with root package name */
    public final w9.a f14894h;

    public n(p pVar, h hVar, a aVar, l.h hVar2, Handler handler, s9.a aVar2, i iVar, w9.a aVar3) {
        j.g("uiHandler", handler);
        j.g("networkInfoProvider", aVar3);
        this.f14887a = pVar;
        this.f14888b = hVar;
        this.f14889c = aVar;
        this.f14890d = hVar2;
        this.f14891e = handler;
        this.f14892f = aVar2;
        this.f14893g = iVar;
        this.f14894h = aVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return j.a(this.f14887a, nVar.f14887a) && j.a(this.f14888b, nVar.f14888b) && j.a(this.f14889c, nVar.f14889c) && j.a(this.f14890d, nVar.f14890d) && j.a(this.f14891e, nVar.f14891e) && j.a(this.f14892f, nVar.f14892f) && j.a(this.f14893g, nVar.f14893g) && j.a(this.f14894h, nVar.f14894h);
    }

    public final int hashCode() {
        int i10 = 0;
        p pVar = this.f14887a;
        int hashCode = (pVar != null ? pVar.hashCode() : 0) * 31;
        h hVar = this.f14888b;
        int hashCode2 = (hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31;
        a aVar = this.f14889c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        l.h hVar2 = this.f14890d;
        int hashCode4 = (hashCode3 + (hVar2 != null ? hVar2.hashCode() : 0)) * 31;
        Handler handler = this.f14891e;
        int hashCode5 = (hashCode4 + (handler != null ? handler.hashCode() : 0)) * 31;
        s9.a aVar2 = this.f14892f;
        int hashCode6 = (hashCode5 + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
        i iVar = this.f14893g;
        int hashCode7 = (hashCode6 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        w9.a aVar3 = this.f14894h;
        if (aVar3 != null) {
            i10 = aVar3.hashCode();
        }
        return hashCode7 + i10;
    }

    public final String toString() {
        return "Holder(handlerWrapper=" + this.f14887a + ", fetchDatabaseManagerWrapper=" + this.f14888b + ", downloadProvider=" + this.f14889c + ", groupInfoProvider=" + this.f14890d + ", uiHandler=" + this.f14891e + ", downloadManagerCoordinator=" + this.f14892f + ", listenerCoordinator=" + this.f14893g + ", networkInfoProvider=" + this.f14894h + ")";
    }
}

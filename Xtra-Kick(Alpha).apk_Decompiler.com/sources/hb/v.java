package hb;

import java.util.concurrent.CancellationException;
import wa.l;
import xa.j;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final Object f7861a;

    /* renamed from: b  reason: collision with root package name */
    public final i f7862b;

    /* renamed from: c  reason: collision with root package name */
    public final l f7863c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f7864d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f7865e;

    public v(Object obj, i iVar, l lVar, Object obj2, Throwable th) {
        this.f7861a = obj;
        this.f7862b = iVar;
        this.f7863c = lVar;
        this.f7864d = obj2;
        this.f7865e = th;
    }

    public static v a(v vVar, i iVar, CancellationException cancellationException, int i10) {
        Object obj;
        l lVar;
        Object obj2 = null;
        if ((i10 & 1) != 0) {
            obj = vVar.f7861a;
        } else {
            obj = null;
        }
        if ((i10 & 2) != 0) {
            iVar = vVar.f7862b;
        }
        i iVar2 = iVar;
        if ((i10 & 4) != 0) {
            lVar = vVar.f7863c;
        } else {
            lVar = null;
        }
        if ((i10 & 8) != 0) {
            obj2 = vVar.f7864d;
        }
        Object obj3 = obj2;
        Throwable th = cancellationException;
        if ((i10 & 16) != 0) {
            th = vVar.f7865e;
        }
        vVar.getClass();
        return new v(obj, iVar2, lVar, obj3, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return j.a(this.f7861a, vVar.f7861a) && j.a(this.f7862b, vVar.f7862b) && j.a(this.f7863c, vVar.f7863c) && j.a(this.f7864d, vVar.f7864d) && j.a(this.f7865e, vVar.f7865e);
    }

    public final int hashCode() {
        int i10 = 0;
        Object obj = this.f7861a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f7862b;
        int hashCode2 = (hashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        l lVar = this.f7863c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f7864d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f7865e;
        if (th != null) {
            i10 = th.hashCode();
        }
        return hashCode4 + i10;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f7861a + ", cancelHandler=" + this.f7862b + ", onCancellation=" + this.f7863c + ", idempotentResume=" + this.f7864d + ", cancelCause=" + this.f7865e + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Object obj, i iVar, l lVar, CancellationException cancellationException, int i10) {
        this(obj, (i10 & 2) != 0 ? null : iVar, (i10 & 4) != 0 ? null : lVar, (Object) null, (Throwable) (i10 & 16) != 0 ? null : cancellationException);
    }
}

package e5;

import java.util.ArrayList;
import java.util.HashMap;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final f f5046a = new f();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f5047b = new HashMap();

    public final Object a(o oVar) {
        int i10;
        HashMap hashMap = this.f5047b;
        f fVar = (f) hashMap.get(oVar);
        if (fVar == null) {
            fVar = new f(oVar);
            hashMap.put(oVar, fVar);
        } else {
            oVar.a();
        }
        f fVar2 = fVar.f5045d;
        fVar2.f5044c = fVar.f5044c;
        fVar.f5044c.f5045d = fVar2;
        f fVar3 = this.f5046a;
        fVar.f5045d = fVar3;
        f fVar4 = fVar3.f5044c;
        fVar.f5044c = fVar4;
        fVar4.f5045d = fVar;
        fVar.f5045d.f5044c = fVar;
        ArrayList arrayList = fVar.f5043b;
        if (arrayList != null) {
            i10 = arrayList.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            return fVar.f5043b.remove(i10 - 1);
        }
        return null;
    }

    public final void b(o oVar, Object obj) {
        HashMap hashMap = this.f5047b;
        f fVar = (f) hashMap.get(oVar);
        if (fVar == null) {
            fVar = new f(oVar);
            f fVar2 = fVar.f5045d;
            fVar2.f5044c = fVar.f5044c;
            fVar.f5044c.f5045d = fVar2;
            f fVar3 = this.f5046a;
            fVar.f5045d = fVar3.f5045d;
            fVar.f5044c = fVar3;
            fVar3.f5045d = fVar;
            fVar.f5045d.f5044c = fVar;
            hashMap.put(oVar, fVar);
        } else {
            oVar.a();
        }
        if (fVar.f5043b == null) {
            fVar.f5043b = new ArrayList();
        }
        fVar.f5043b.add(obj);
    }

    public final Object c() {
        int i10;
        f fVar = this.f5046a;
        f fVar2 = fVar.f5045d;
        while (true) {
            Object obj = null;
            if (fVar2.equals(fVar)) {
                return null;
            }
            ArrayList arrayList = fVar2.f5043b;
            if (arrayList != null) {
                i10 = arrayList.size();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                obj = fVar2.f5043b.remove(i10 - 1);
            }
            if (obj != null) {
                return obj;
            }
            f fVar3 = fVar2.f5045d;
            fVar3.f5044c = fVar2.f5044c;
            fVar2.f5044c.f5045d = fVar3;
            HashMap hashMap = this.f5047b;
            Object obj2 = fVar2.f5042a;
            hashMap.remove(obj2);
            ((o) obj2).a();
            fVar2 = fVar2.f5045d;
        }
    }

    public final String toString() {
        int i10;
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        f fVar = this.f5046a;
        f fVar2 = fVar.f5044c;
        boolean z10 = false;
        while (!fVar2.equals(fVar)) {
            sb2.append('{');
            sb2.append(fVar2.f5042a);
            sb2.append(':');
            ArrayList arrayList = fVar2.f5043b;
            if (arrayList != null) {
                i10 = arrayList.size();
            } else {
                i10 = 0;
            }
            sb2.append(i10);
            sb2.append("}, ");
            fVar2 = fVar2.f5044c;
            z10 = true;
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}

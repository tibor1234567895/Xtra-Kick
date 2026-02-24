package l9;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class l extends AbstractSet {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9771h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ o f9772i;

    public /* synthetic */ l(o oVar, int i10) {
        this.f9771h = i10;
        this.f9772i = oVar;
    }

    public final void clear() {
        int i10 = this.f9771h;
        o oVar = this.f9772i;
        switch (i10) {
            case 0:
                oVar.clear();
                return;
            default:
                oVar.clear();
                return;
        }
    }

    public final boolean contains(Object obj) {
        int i10 = this.f9771h;
        o oVar = this.f9772i;
        switch (i10) {
            case 0:
                if (!(obj instanceof Map.Entry) || oVar.b((Map.Entry) obj) == null) {
                    return false;
                }
                return true;
            default:
                return oVar.containsKey(obj);
        }
    }

    public final Iterator iterator() {
        switch (this.f9771h) {
            case 0:
                return new k(this);
            default:
                return new k(this, 0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 0
            int r1 = r4.f9771h
            r2 = 1
            l9.o r3 = r4.f9772i
            switch(r1) {
                case 0: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x001d
        L_0x000a:
            boolean r1 = r5 instanceof java.util.Map.Entry
            if (r1 != 0) goto L_0x000f
            goto L_0x001c
        L_0x000f:
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            l9.n r5 = r3.b(r5)
            if (r5 != 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            r3.d(r5, r2)
            r0 = 1
        L_0x001c:
            return r0
        L_0x001d:
            r3.getClass()
            if (r5 == 0) goto L_0x0027
            l9.n r5 = r3.a(r5, r0)     // Catch:{ ClassCastException -> 0x0027 }
            goto L_0x0028
        L_0x0027:
            r5 = 0
        L_0x0028:
            if (r5 == 0) goto L_0x002d
            r3.d(r5, r2)
        L_0x002d:
            if (r5 == 0) goto L_0x0030
            r0 = 1
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.l.remove(java.lang.Object):boolean");
    }

    public final int size() {
        int i10 = this.f9771h;
        o oVar = this.f9772i;
        switch (i10) {
            case 0:
                return oVar.f9788j;
            default:
                return oVar.f9788j;
        }
    }
}

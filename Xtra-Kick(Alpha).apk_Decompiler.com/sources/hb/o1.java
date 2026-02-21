package hb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class o1 extends u1 implements u {

    /* renamed from: j  reason: collision with root package name */
    public final boolean f7832j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o1(l1 l1Var) {
        super(true);
        q qVar;
        q qVar2;
        boolean z10 = true;
        K(l1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = u1.f7860i;
        p pVar = (p) atomicReferenceFieldUpdater.get(this);
        if (pVar instanceof q) {
            qVar = (q) pVar;
        } else {
            qVar = null;
        }
        if (qVar != null) {
            while (true) {
                u1 p10 = qVar.p();
                if (!p10.E()) {
                    p pVar2 = (p) atomicReferenceFieldUpdater.get(p10);
                    if (pVar2 instanceof q) {
                        qVar2 = (q) pVar2;
                        continue;
                    } else {
                        qVar2 = null;
                        continue;
                    }
                    if (qVar == null) {
                        break;
                    }
                } else {
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        this.f7832j = z10;
    }

    public final boolean E() {
        return this.f7832j;
    }

    public final boolean F() {
        return true;
    }
}

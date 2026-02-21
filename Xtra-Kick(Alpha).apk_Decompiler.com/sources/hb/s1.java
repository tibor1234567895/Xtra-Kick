package hb;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import xa.j;

public final class s1 implements f1 {

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7847i;

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7848j;

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7849k;
    private volatile Object _exceptionsHolder;
    private volatile int _isCompleting = 0;
    private volatile Object _rootCause;

    /* renamed from: h  reason: collision with root package name */
    public final y1 f7850h;

    static {
        Class<s1> cls = s1.class;
        f7847i = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting");
        Class<Object> cls2 = Object.class;
        f7848j = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause");
        f7849k = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder");
    }

    public s1(y1 y1Var, Throwable th) {
        this.f7850h = y1Var;
        this._rootCause = th;
    }

    public final void a(Throwable th) {
        Throwable b10 = b();
        if (b10 == null) {
            f7848j.set(this, th);
        } else if (th != b10) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7849k;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
            } else if (obj instanceof Throwable) {
                if (th != obj) {
                    ArrayList arrayList = new ArrayList(4);
                    arrayList.add(obj);
                    arrayList.add(th);
                    atomicReferenceFieldUpdater.set(this, arrayList);
                }
            } else if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
    }

    public final Throwable b() {
        return (Throwable) f7848j.get(this);
    }

    public final boolean c() {
        return b() == null;
    }

    public final boolean d() {
        return b() != null;
    }

    public final boolean e() {
        return f7847i.get(this) != 0;
    }

    public final y1 f() {
        return this.f7850h;
    }

    public final ArrayList g(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7849k;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            throw new IllegalStateException(("State is " + obj).toString());
        }
        Throwable b10 = b();
        if (b10 != null) {
            arrayList.add(0, b10);
        }
        if (th != null && !j.a(th, b10)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, v1.f7871e);
        return arrayList;
    }

    public final String toString() {
        return "Finishing[cancelling=" + d() + ", completing=" + e() + ", rootCause=" + b() + ", exceptions=" + f7849k.get(this) + ", list=" + this.f7850h + ']';
    }
}

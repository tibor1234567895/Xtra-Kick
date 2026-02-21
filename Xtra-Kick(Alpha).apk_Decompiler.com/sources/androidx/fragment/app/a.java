package androidx.fragment.app;

import androidx.lifecycle.s;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public final class a extends p1 implements z0 {

    /* renamed from: q  reason: collision with root package name */
    public final c1 f1319q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1320r;

    /* renamed from: s  reason: collision with root package name */
    public int f1321s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1322t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        super(0);
        aVar.f1319q.G();
        e0 e0Var = aVar.f1319q.f1392v;
        if (e0Var != null) {
            e0Var.f1403i.getClassLoader();
        }
        Iterator it = aVar.f1533a.iterator();
        while (it.hasNext()) {
            this.f1533a.add(new o1((o1) it.next()));
        }
        this.f1534b = aVar.f1534b;
        this.f1535c = aVar.f1535c;
        this.f1536d = aVar.f1536d;
        this.f1537e = aVar.f1537e;
        this.f1538f = aVar.f1538f;
        this.f1539g = aVar.f1539g;
        this.f1540h = aVar.f1540h;
        this.f1541i = aVar.f1541i;
        this.f1544l = aVar.f1544l;
        this.f1545m = aVar.f1545m;
        this.f1542j = aVar.f1542j;
        this.f1543k = aVar.f1543k;
        if (aVar.f1546n != null) {
            ArrayList arrayList = new ArrayList();
            this.f1546n = arrayList;
            arrayList.addAll(aVar.f1546n);
        }
        if (aVar.f1547o != null) {
            ArrayList arrayList2 = new ArrayList();
            this.f1547o = arrayList2;
            arrayList2.addAll(aVar.f1547o);
        }
        this.f1548p = aVar.f1548p;
        this.f1321s = -1;
        this.f1322t = false;
        this.f1319q = aVar.f1319q;
        this.f1320r = aVar.f1320r;
        this.f1321s = aVar.f1321s;
        this.f1322t = aVar.f1322t;
    }

    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (c1.I(2)) {
            toString();
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1539g) {
            return true;
        }
        c1 c1Var = this.f1319q;
        if (c1Var.f1374d == null) {
            c1Var.f1374d = new ArrayList();
        }
        c1Var.f1374d.add(this);
        return true;
    }

    public final void d(int i10, c0 c0Var, String str, int i11) {
        super.d(i10, c0Var, str, i11);
        c0Var.f1370z = this.f1319q;
    }

    public final void f(int i10) {
        if (this.f1539g) {
            if (c1.I(2)) {
                toString();
            }
            ArrayList arrayList = this.f1533a;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                o1 o1Var = (o1) arrayList.get(i11);
                c0 c0Var = o1Var.f1522b;
                if (c0Var != null) {
                    c0Var.f1369y += i10;
                    if (c1.I(2)) {
                        Objects.toString(o1Var.f1522b);
                        int i12 = o1Var.f1522b.f1369y;
                    }
                }
            }
        }
    }

    public final int g() {
        return h(false);
    }

    public final int h(boolean z10) {
        int i10;
        if (!this.f1320r) {
            if (c1.I(2)) {
                toString();
                PrintWriter printWriter = new PrintWriter(new a2());
                j("  ", printWriter, true);
                printWriter.close();
            }
            this.f1320r = true;
            boolean z11 = this.f1539g;
            c1 c1Var = this.f1319q;
            if (z11) {
                i10 = c1Var.f1379i.getAndIncrement();
            } else {
                i10 = -1;
            }
            this.f1321s = i10;
            c1Var.w(this, z10);
            return this.f1321s;
        }
        throw new IllegalStateException("commit already called");
    }

    public final void i() {
        if (!this.f1539g) {
            this.f1540h = false;
            this.f1319q.z(this, false);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public final void j(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1541i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1321s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1320r);
            if (this.f1538f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1538f));
            }
            if (!(this.f1534b == 0 && this.f1535c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1534b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1535c));
            }
            if (!(this.f1536d == 0 && this.f1537e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1536d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1537e));
            }
            if (!(this.f1542j == 0 && this.f1543k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1542j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1543k);
            }
            if (!(this.f1544l == 0 && this.f1545m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1544l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1545m);
            }
        }
        ArrayList arrayList = this.f1533a;
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                o1 o1Var = (o1) arrayList.get(i10);
                switch (o1Var.f1521a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + o1Var.f1521a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(o1Var.f1522b);
                if (z10) {
                    if (!(o1Var.f1524d == 0 && o1Var.f1525e == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(o1Var.f1524d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(o1Var.f1525e));
                    }
                    if (o1Var.f1526f != 0 || o1Var.f1527g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(o1Var.f1526f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(o1Var.f1527g));
                    }
                }
            }
        }
    }

    public final void k(c0 c0Var) {
        c1 c1Var = c0Var.f1370z;
        if (c1Var == null || c1Var == this.f1319q) {
            b(new o1(3, c0Var));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + c0Var.toString() + " is already attached to a FragmentManager.");
    }

    public final void l(c0 c0Var, s sVar) {
        c1 c1Var = c0Var.f1370z;
        c1 c1Var2 = this.f1319q;
        if (c1Var != c1Var2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + c1Var2);
        } else if (sVar == s.INITIALIZED && c0Var.f1352h > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + sVar + " after the Fragment has been created");
        } else if (sVar != s.DESTROYED) {
            b(new o1(c0Var, sVar));
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + sVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public final void m(c0 c0Var) {
        c1 c1Var;
        if (c0Var == null || (c1Var = c0Var.f1370z) == null || c1Var == this.f1319q) {
            b(new o1(8, c0Var));
            return;
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + c0Var.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1321s >= 0) {
            sb2.append(" #");
            sb2.append(this.f1321s);
        }
        if (this.f1541i != null) {
            sb2.append(" ");
            sb2.append(this.f1541i);
        }
        sb2.append("}");
        return sb2.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c1 c1Var) {
        super(0);
        c1Var.G();
        e0 e0Var = c1Var.f1392v;
        if (e0Var != null) {
            e0Var.f1403i.getClassLoader();
        }
        this.f1321s = -1;
        this.f1322t = false;
        this.f1319q = c1Var;
    }
}

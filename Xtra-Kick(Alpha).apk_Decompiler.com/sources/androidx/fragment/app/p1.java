package androidx.fragment.app;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import z0.d;

public abstract class p1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1533a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f1534b;

    /* renamed from: c  reason: collision with root package name */
    public int f1535c;

    /* renamed from: d  reason: collision with root package name */
    public int f1536d;

    /* renamed from: e  reason: collision with root package name */
    public int f1537e;

    /* renamed from: f  reason: collision with root package name */
    public int f1538f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1539g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1540h = true;

    /* renamed from: i  reason: collision with root package name */
    public String f1541i;

    /* renamed from: j  reason: collision with root package name */
    public int f1542j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1543k;

    /* renamed from: l  reason: collision with root package name */
    public int f1544l;

    /* renamed from: m  reason: collision with root package name */
    public CharSequence f1545m;

    /* renamed from: n  reason: collision with root package name */
    public ArrayList f1546n;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList f1547o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1548p = false;

    @Deprecated
    public p1() {
    }

    public final void b(o1 o1Var) {
        this.f1533a.add(o1Var);
        o1Var.f1524d = this.f1534b;
        o1Var.f1525e = this.f1535c;
        o1Var.f1526f = this.f1536d;
        o1Var.f1527g = this.f1537e;
    }

    public final void c(String str) {
        if (this.f1540h) {
            this.f1539g = true;
            this.f1541i = str;
            return;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public void d(int i10, c0 c0Var, String str, int i11) {
        String str2 = c0Var.T;
        if (str2 != null) {
            d.d(c0Var, str2);
        }
        Class<?> cls = c0Var.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = c0Var.F;
            if (str3 == null || str.equals(str3)) {
                c0Var.F = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + c0Var + ": was " + c0Var.F + " now " + str);
            }
        }
        if (i10 != 0) {
            if (i10 != -1) {
                int i12 = c0Var.D;
                if (i12 == 0 || i12 == i10) {
                    c0Var.D = i10;
                    c0Var.E = i10;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + c0Var + ": was " + c0Var.D + " now " + i10);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + c0Var + " with tag " + str + " to container view with no id");
            }
        }
        b(new o1(i11, c0Var));
    }

    public final void e(int i10, c0 c0Var, String str) {
        if (i10 != 0) {
            d(i10, c0Var, str, 2);
            return;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public p1(int i10) {
    }
}

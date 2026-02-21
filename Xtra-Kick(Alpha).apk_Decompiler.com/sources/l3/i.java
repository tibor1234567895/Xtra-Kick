package l3;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import j3.c1;
import j3.o2;
import la.v;
import xa.j;

public final class i extends c1 {

    /* renamed from: r  reason: collision with root package name */
    public String f9546r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(o2 o2Var) {
        super(o2Var);
        j.f("fragmentNavigator", o2Var);
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof i) && super.equals(obj) && j.a(this.f9546r, ((i) obj).f9546r);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        j.f("context", context);
        super.g(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, o.f9561b);
        j.e("context.resources.obtain…leable.FragmentNavigator)", obtainAttributes);
        String string = obtainAttributes.getString(0);
        if (string != null) {
            this.f9546r = string;
        }
        v vVar = v.f9814a;
        obtainAttributes.recycle();
    }

    public final int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f9546r;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" class=");
        String str = this.f9546r;
        if (str == null) {
            str = "null";
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }
}

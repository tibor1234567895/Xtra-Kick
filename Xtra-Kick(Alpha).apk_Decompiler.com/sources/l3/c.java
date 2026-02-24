package l3;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import j3.c1;
import j3.g;
import j3.o2;
import xa.j;

public final class c extends c1 implements g {

    /* renamed from: r  reason: collision with root package name */
    public String f9535r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(o2 o2Var) {
        super(o2Var);
        j.f("fragmentNavigator", o2Var);
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof c) && super.equals(obj) && j.a(this.f9535r, ((c) obj).f9535r);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        j.f("context", context);
        super.g(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, o.f9560a);
        j.e("context.resources.obtain…ntNavigator\n            )", obtainAttributes);
        String string = obtainAttributes.getString(0);
        if (string != null) {
            this.f9535r = string;
        }
        obtainAttributes.recycle();
    }

    public final int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f9535r;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}

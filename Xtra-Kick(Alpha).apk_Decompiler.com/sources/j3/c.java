package j3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import fb.w;
import xa.j;

public final class c extends c1 {

    /* renamed from: r  reason: collision with root package name */
    public Intent f8502r;

    /* renamed from: s  reason: collision with root package name */
    public String f8503s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(o2 o2Var) {
        super(o2Var);
        j.f("activityNavigator", o2Var);
    }

    public static String h(Context context, String str) {
        if (str == null) {
            return null;
        }
        String packageName = context.getPackageName();
        j.e("context.packageName", packageName);
        return w.k(str, "${applicationId}", packageName);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof c) || !super.equals(obj)) {
            return false;
        }
        Intent intent = this.f8502r;
        return (intent != null ? intent.filterEquals(((c) obj).f8502r) : ((c) obj).f8502r == null) && j.a(this.f8503s, ((c) obj).f8503s);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        j.f("context", context);
        super.g(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, t2.f8685a);
        j.e("context.resources.obtain…tyNavigator\n            )", obtainAttributes);
        String h10 = h(context, obtainAttributes.getString(4));
        if (this.f8502r == null) {
            this.f8502r = new Intent();
        }
        Intent intent = this.f8502r;
        j.c(intent);
        intent.setPackage(h10);
        String string = obtainAttributes.getString(0);
        if (string != null) {
            if (string.charAt(0) == '.') {
                string = context.getPackageName() + string;
            }
            ComponentName componentName = new ComponentName(context, string);
            if (this.f8502r == null) {
                this.f8502r = new Intent();
            }
            Intent intent2 = this.f8502r;
            j.c(intent2);
            intent2.setComponent(componentName);
        }
        String string2 = obtainAttributes.getString(1);
        if (this.f8502r == null) {
            this.f8502r = new Intent();
        }
        Intent intent3 = this.f8502r;
        j.c(intent3);
        intent3.setAction(string2);
        String h11 = h(context, obtainAttributes.getString(2));
        if (h11 != null) {
            Uri parse = Uri.parse(h11);
            if (this.f8502r == null) {
                this.f8502r = new Intent();
            }
            Intent intent4 = this.f8502r;
            j.c(intent4);
            intent4.setData(parse);
        }
        this.f8503s = h(context, obtainAttributes.getString(3));
        obtainAttributes.recycle();
    }

    public final int hashCode() {
        int hashCode = super.hashCode() * 31;
        Intent intent = this.f8502r;
        int i10 = 0;
        int filterHashCode = (hashCode + (intent != null ? intent.filterHashCode() : 0)) * 31;
        String str = this.f8503s;
        if (str != null) {
            i10 = str.hashCode();
        }
        return filterHashCode + i10;
    }

    public final String toString() {
        ComponentName componentName;
        Intent intent = this.f8502r;
        String str = null;
        if (intent != null) {
            componentName = intent.getComponent();
        } else {
            componentName = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        if (componentName != null) {
            sb2.append(" class=");
            sb2.append(componentName.getClassName());
        } else {
            Intent intent2 = this.f8502r;
            if (intent2 != null) {
                str = intent2.getAction();
            }
            if (str != null) {
                sb2.append(" action=");
                sb2.append(str);
            }
        }
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }
}

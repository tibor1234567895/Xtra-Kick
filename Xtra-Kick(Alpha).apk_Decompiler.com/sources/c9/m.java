package c9;

import java.util.Arrays;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final String f3041a;

    /* renamed from: b  reason: collision with root package name */
    public final l f3042b;

    /* renamed from: c  reason: collision with root package name */
    public l f3043c;

    public m(String str) {
        l lVar = new l(0);
        this.f3042b = lVar;
        this.f3043c = lVar;
        this.f3041a = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.f3041a);
        sb2.append('{');
        l lVar = this.f3042b.f3040b;
        String str = "";
        while (lVar != null) {
            Object obj = lVar.f3039a;
            boolean z10 = lVar instanceof k;
            sb2.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append(deepToString, 1, deepToString.length() - 1);
            }
            lVar = lVar.f3040b;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }
}

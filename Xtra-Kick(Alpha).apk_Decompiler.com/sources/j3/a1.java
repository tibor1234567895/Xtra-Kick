package j3;

import android.content.Context;
import android.content.res.Resources;
import xa.j;

public final class a1 {
    private a1() {
    }

    public /* synthetic */ a1(int i10) {
        this();
    }

    public static String a(String str) {
        return str != null ? "android-app://androidx.navigation/".concat(str) : "";
    }

    public static String b(Context context, int i10) {
        String str;
        j.f("context", context);
        if (i10 <= 16777215) {
            return String.valueOf(i10);
        }
        try {
            str = context.getResources().getResourceName(i10);
        } catch (Resources.NotFoundException unused) {
            str = String.valueOf(i10);
        }
        j.e("try {\n                co….toString()\n            }", str);
        return str;
    }
}

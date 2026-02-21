package j3;

import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParserException;
import xa.j;

public final class k1 {
    private k1() {
    }

    public /* synthetic */ k1(int i10) {
        this();
    }

    public static g2 a(TypedValue typedValue, g2 g2Var, g2 g2Var2, String str, String str2) {
        j.f("expectedNavType", g2Var2);
        if (g2Var == null || g2Var == g2Var2) {
            return g2Var == null ? g2Var2 : g2Var;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }
}

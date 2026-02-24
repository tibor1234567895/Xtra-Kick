package d0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public final class t {
    private t() {
    }

    public static int a(Context context, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId != 0 ? i10 : i11;
    }

    public static d b(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i10) {
        d dVar;
        if (g(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i10, typedValue);
            int i11 = typedValue.type;
            if (i11 >= 28 && i11 <= 31) {
                return new d((Object) null, typedValue.data, (Object) null);
            }
            try {
                dVar = d.a(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
            } catch (Exception e10) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e10);
                dVar = null;
            }
            if (dVar != null) {
                return dVar;
            }
        }
        return new d((Object) null, 0, (Object) null);
    }

    public static float c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, float f10) {
        return !g(xmlPullParser, str) ? f10 : typedArray.getFloat(i10, f10);
    }

    public static int d(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        return !g(xmlPullParser, str) ? i11 : typedArray.getInt(i10, i11);
    }

    public static String e(TypedArray typedArray, XmlResourceParser xmlResourceParser, String str, int i10) {
        if (!g(xmlResourceParser, str)) {
            return null;
        }
        return typedArray.getString(i10);
    }

    public static String f(TypedArray typedArray, int i10, int i11) {
        String string = typedArray.getString(i10);
        return string == null ? typedArray.getString(i11) : string;
    }

    public static boolean g(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}

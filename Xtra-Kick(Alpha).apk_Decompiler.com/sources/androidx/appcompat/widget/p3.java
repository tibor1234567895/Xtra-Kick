package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import c4.s;

public final class p3 implements o3 {
    public final Drawable a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        try {
            Resources resources = context.getResources();
            s sVar = new s();
            sVar.inflate(resources, xmlResourceParser, attributeSet, theme);
            return sVar;
        } catch (Exception e10) {
            Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e10);
            return null;
        }
    }
}

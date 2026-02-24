package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import i.f;

public final class k3 implements o3 {
    public final Drawable a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        try {
            return f.g(context, theme, context.getResources(), attributeSet, xmlResourceParser);
        } catch (Exception e10) {
            Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
            return null;
        }
    }
}

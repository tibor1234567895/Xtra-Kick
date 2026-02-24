package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import j.b;

public final class n3 implements o3 {
    public final Drawable a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        String classAttribute = attributeSet.getClassAttribute();
        if (classAttribute == null) {
            return null;
        }
        try {
            Drawable drawable = (Drawable) n3.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            b.c(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
            return drawable;
        } catch (Exception e10) {
            Log.e("DrawableDelegate", "Exception while inflating <drawable>", e10);
            return null;
        }
    }
}

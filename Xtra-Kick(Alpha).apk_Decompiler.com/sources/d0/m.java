package d0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f4104a;

    /* renamed from: b  reason: collision with root package name */
    public final Configuration f4105b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4106c;

    public m(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f4104a = colorStateList;
        this.f4105b = configuration;
        this.f4106c = theme == null ? 0 : theme.hashCode();
    }
}

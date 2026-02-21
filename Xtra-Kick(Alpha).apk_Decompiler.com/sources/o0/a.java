package o0;

import android.graphics.Path;
import android.view.animation.PathInterpolator;

public final class a {
    private a() {
    }

    public static PathInterpolator a(float f10, float f11) {
        return new PathInterpolator(f10, f11);
    }

    public static PathInterpolator b(float f10, float f11, float f12, float f13) {
        return new PathInterpolator(f10, f11, f12, f13);
    }

    public static PathInterpolator c(Path path) {
        return new PathInterpolator(path);
    }
}

package e4;

import android.view.View;
import android.view.ViewGroup;

public final class a {
    private a() {
    }

    public static View a(View view, int i10) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View findViewById = viewGroup.getChildAt(i11).findViewById(i10);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }
}

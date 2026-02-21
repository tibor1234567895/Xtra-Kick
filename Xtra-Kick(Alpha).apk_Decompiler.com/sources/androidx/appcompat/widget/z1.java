package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.widget.TextView;

public final class z1 extends y1 {
    public void a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    public boolean b(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}

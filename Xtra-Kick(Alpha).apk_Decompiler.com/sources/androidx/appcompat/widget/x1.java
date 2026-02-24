package androidx.appcompat.widget;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.widget.TextView;

public final class x1 {
    private x1() {
    }

    public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, a2 a2Var) {
        StaticLayout.Builder h10 = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
        StaticLayout.Builder C = h10.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
        if (i11 == -1) {
            i11 = Integer.MAX_VALUE;
        }
        C.setMaxLines(i11);
        try {
            a2Var.a(h10, textView);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return h10.build();
    }
}

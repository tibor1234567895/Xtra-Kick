package q0;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

public final class y {
    private y() {
    }

    public static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static PrecomputedText.Params b(TextView textView) {
        return textView.getTextMetricsParams();
    }

    public static void c(TextView textView, int i10) {
        textView.setFirstBaselineToTopHeight(i10);
    }
}

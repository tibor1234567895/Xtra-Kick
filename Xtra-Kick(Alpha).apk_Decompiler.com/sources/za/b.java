package za;

import androidx.recyclerview.widget.RecyclerView;

public class b extends a {
    public static final int a(double d10) {
        if (Double.isNaN(d10)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d10 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            return d10 < -2.147483648E9d ? RecyclerView.UNDEFINED_DURATION : (int) Math.round(d10);
        }
    }
}

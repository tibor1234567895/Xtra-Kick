package g;

import android.content.Context;
import android.widget.ArrayAdapter;

public final class j extends ArrayAdapter {
    public j(Context context, int i10, CharSequence[] charSequenceArr) {
        super(context, i10, 16908308, charSequenceArr);
    }

    public final long getItemId(int i10) {
        return (long) i10;
    }

    public final boolean hasStableIds() {
        return true;
    }
}

package m0;

import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;

public final class t2 extends s2 {
    public t2(Window window, View view) {
        super(window, view);
    }

    public final void c(boolean z10) {
        if (z10) {
            Window window = this.f10132a;
            window.clearFlags(134217728);
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            g(16);
            return;
        }
        h(16);
    }
}

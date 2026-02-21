package m0;

import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;

public class s2 extends r2 {
    public s2(Window window, View view) {
        super(window, view);
    }

    public final boolean b() {
        return (this.f10132a.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public final void d(boolean z10) {
        if (z10) {
            Window window = this.f10132a;
            window.clearFlags(67108864);
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            g(8192);
            return;
        }
        h(8192);
    }
}

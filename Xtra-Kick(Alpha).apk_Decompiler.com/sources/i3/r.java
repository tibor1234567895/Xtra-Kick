package i3;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import j1.l0;

public final class r extends k2 {

    /* renamed from: h  reason: collision with root package name */
    public final TextView f8159h;

    /* renamed from: i  reason: collision with root package name */
    public final View f8160i;

    public r(View view) {
        super(view);
        if (l0.f8453a < 26) {
            view.setFocusable(true);
        }
        this.f8159h = (TextView) view.findViewById(R.id.exo_text);
        this.f8160i = view.findViewById(R.id.exo_check);
    }
}

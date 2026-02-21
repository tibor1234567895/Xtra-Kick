package t6;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import xa.j;

public final class j0 extends k2 implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final TextView f14615h;

    public j0(View view) {
        super(view);
        View findViewById = view.findViewById(R.id.userName);
        j.e("itemView.findViewById(R.id.userName)", findViewById);
        this.f14615h = (TextView) findViewById;
        view.setOnClickListener(this);
    }

    public final void onClick(View view) {
        j.f("view", view);
    }
}

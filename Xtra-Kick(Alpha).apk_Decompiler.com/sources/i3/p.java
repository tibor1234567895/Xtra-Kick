package i3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import j1.l0;

public final class p extends k2 {

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ int f8148l = 0;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f8149h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f8150i;

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f8151j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ w f8152k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(w wVar, View view) {
        super(view);
        this.f8152k = wVar;
        if (l0.f8453a < 26) {
            view.setFocusable(true);
        }
        this.f8149h = (TextView) view.findViewById(R.id.exo_main_text);
        this.f8150i = (TextView) view.findViewById(R.id.exo_sub_text);
        this.f8151j = (ImageView) view.findViewById(R.id.exo_icon);
        view.setOnClickListener(new i(1, this));
    }
}

package o3;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;

public final class l0 extends k2 {

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f12144h;

    /* renamed from: i  reason: collision with root package name */
    public final ColorStateList f12145i;

    /* renamed from: j  reason: collision with root package name */
    public final SparseArray f12146j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12147k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f12148l;

    public l0(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.f12146j = sparseArray;
        TextView textView = (TextView) view.findViewById(16908310);
        sparseArray.put(16908310, textView);
        sparseArray.put(16908304, view.findViewById(16908304));
        sparseArray.put(16908294, view.findViewById(16908294));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        sparseArray.put(16908350, view.findViewById(16908350));
        this.f12144h = view.getBackground();
        if (textView != null) {
            this.f12145i = textView.getTextColors();
        }
    }

    public final View a(int i10) {
        SparseArray sparseArray = this.f12146j;
        View view = (View) sparseArray.get(i10);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i10);
        if (findViewById != null) {
            sparseArray.put(i10, findViewById);
        }
        return findViewById;
    }
}

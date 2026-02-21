package i3;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.r1;
import com.woxthebox.draglistview.R;
import g1.k1;

public final class q extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f8153a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f8154b;

    /* renamed from: c  reason: collision with root package name */
    public final Drawable[] f8155c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w f8156d;

    public q(w wVar, String[] strArr, Drawable[] drawableArr) {
        this.f8156d = wVar;
        this.f8153a = strArr;
        this.f8154b = new String[strArr.length];
        this.f8155c = drawableArr;
    }

    public final boolean a(int i10) {
        w wVar = this.f8156d;
        k1 k1Var = wVar.f8201o0;
        if (k1Var == null) {
            return false;
        }
        if (i10 == 0) {
            return k1Var.L0(13);
        }
        if (i10 != 1) {
            return true;
        }
        if (!k1Var.L0(30) || !wVar.f8201o0.L0(29)) {
            return false;
        }
        return true;
    }

    public final int getItemCount() {
        return this.f8153a.length;
    }

    public final long getItemId(int i10) {
        return (long) i10;
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        r1 r1Var;
        View view;
        p pVar = (p) k2Var;
        if (a(i10)) {
            view = pVar.itemView;
            r1Var = new r1(-1, -2);
        } else {
            view = pVar.itemView;
            r1Var = new r1(0, 0);
        }
        view.setLayoutParams(r1Var);
        pVar.f8149h.setText(this.f8153a[i10]);
        String str = this.f8154b[i10];
        TextView textView = pVar.f8150i;
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        Drawable drawable = this.f8155c[i10];
        ImageView imageView = pVar.f8151j;
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(drawable);
        }
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        w wVar = this.f8156d;
        return new p(wVar, LayoutInflater.from(wVar.getContext()).inflate(R.layout.exo_styled_settings_list_item, viewGroup, false));
    }
}

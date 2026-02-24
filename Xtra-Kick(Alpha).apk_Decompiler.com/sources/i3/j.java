package i3;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import d9.r1;
import g1.k1;
import g1.y1;

public final class j extends u {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f8110c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w f8111d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(w wVar, int i10) {
        super(wVar);
        this.f8110c = i10;
        this.f8111d = wVar;
    }

    public final void a(r rVar, int i10) {
        int i11;
        switch (this.f8110c) {
            case 1:
                super.a(rVar, i10);
                if (i10 > 0) {
                    s sVar = (s) this.f8177a.get(i10 - 1);
                    View view = rVar.f8160i;
                    if (sVar.f8161a.f6781l[sVar.f8162b]) {
                        i11 = 0;
                    } else {
                        i11 = 4;
                    }
                    view.setVisibility(i11);
                    return;
                }
                return;
            default:
                super.a(rVar, i10);
                return;
        }
    }

    public final boolean b(y1 y1Var) {
        for (int i10 = 0; i10 < this.f8177a.size(); i10++) {
            if (y1Var.F.containsKey(((s) this.f8177a.get(i10)).f8161a.f6778i)) {
                return true;
            }
        }
        return false;
    }

    public final void c(r1 r1Var) {
        Drawable drawable;
        String str;
        int i10 = this.f8110c;
        w wVar = this.f8111d;
        int i11 = 0;
        switch (i10) {
            case 0:
                this.f8177a = r1Var;
                k1 k1Var = wVar.f8201o0;
                k1Var.getClass();
                y1 p02 = k1Var.p0();
                boolean isEmpty = r1Var.isEmpty();
                q qVar = wVar.f8196m;
                if (isEmpty) {
                    qVar.f8154b[1] = wVar.getResources().getString(R.string.exo_track_selection_none);
                    return;
                } else if (!b(p02)) {
                    qVar.f8154b[1] = wVar.getResources().getString(R.string.exo_track_selection_auto);
                    return;
                } else {
                    while (i11 < r1Var.f4660k) {
                        s sVar = (s) r1Var.get(i11);
                        if (sVar.f8161a.f6781l[sVar.f8162b]) {
                            qVar.f8154b[1] = sVar.f8163c;
                            return;
                        }
                        i11++;
                    }
                    return;
                }
            default:
                int i12 = 0;
                while (true) {
                    if (i12 < r1Var.f4660k) {
                        s sVar2 = (s) r1Var.get(i12);
                        if (sVar2.f8161a.f6781l[sVar2.f8162b]) {
                            i11 = 1;
                        } else {
                            i12++;
                        }
                    }
                }
                ImageView imageView = wVar.D;
                if (imageView != null) {
                    if (i11 != 0) {
                        drawable = wVar.f8185g0;
                    } else {
                        drawable = wVar.f8187h0;
                    }
                    imageView.setImageDrawable(drawable);
                    if (i11 != 0) {
                        str = wVar.f8189i0;
                    } else {
                        str = wVar.f8191j0;
                    }
                    wVar.D.setContentDescription(str);
                }
                this.f8177a = r1Var;
                return;
        }
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(k2 k2Var, int i10) {
        switch (this.f8110c) {
            case 1:
                a((r) k2Var, i10);
                return;
            default:
                a((r) k2Var, i10);
                return;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(w wVar, int i10, int i11) {
        this(wVar, 0);
        this.f8110c = i10;
        if (i10 != 1) {
        } else {
            this(wVar, 1);
        }
    }
}

package i3;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import g1.k1;
import g1.v1;
import java.util.ArrayList;
import java.util.List;

public abstract class u extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public List f8177a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f8178b;

    public u(w wVar) {
        this.f8178b = wVar;
    }

    public void a(r rVar, int i10) {
        k1 k1Var = this.f8178b.f8201o0;
        if (k1Var != null) {
            boolean z10 = true;
            int i11 = 0;
            int i12 = 4;
            if (i10 == 0) {
                j jVar = (j) this;
                switch (jVar.f8110c) {
                    case 0:
                        rVar.f8159h.setText(R.string.exo_track_selection_auto);
                        k1 k1Var2 = jVar.f8111d.f8201o0;
                        k1Var2.getClass();
                        if (!jVar.b(k1Var2.p0())) {
                            i12 = 0;
                        }
                        rVar.f8160i.setVisibility(i12);
                        rVar.itemView.setOnClickListener(new i(0, jVar));
                        return;
                    default:
                        rVar.f8159h.setText(R.string.exo_track_selection_none);
                        int i13 = 0;
                        while (true) {
                            if (i13 < jVar.f8177a.size()) {
                                s sVar = (s) jVar.f8177a.get(i13);
                                if (sVar.f8161a.f6781l[sVar.f8162b]) {
                                    z10 = false;
                                } else {
                                    i13++;
                                }
                            }
                        }
                        if (!z10) {
                            i11 = 4;
                        }
                        rVar.f8160i.setVisibility(i11);
                        rVar.itemView.setOnClickListener(new i(2, jVar));
                        return;
                }
            } else {
                s sVar2 = (s) this.f8177a.get(i10 - 1);
                v1 v1Var = sVar2.f8161a.f6778i;
                if (k1Var.p0().F.get(v1Var) == null || !sVar2.f8161a.f6781l[sVar2.f8162b]) {
                    z10 = false;
                }
                rVar.f8159h.setText(sVar2.f8163c);
                if (!z10) {
                    i11 = 4;
                }
                rVar.f8160i.setVisibility(i11);
                rVar.itemView.setOnClickListener(new t(this, k1Var, v1Var, sVar2, 0));
            }
        }
    }

    public final int getItemCount() {
        if (this.f8177a.isEmpty()) {
            return 0;
        }
        return this.f8177a.size() + 1;
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new r(LayoutInflater.from(this.f8178b.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}

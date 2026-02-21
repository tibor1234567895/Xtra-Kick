package w6;

import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.woxthebox.draglistview.R;
import fb.w;
import g.l;
import h3.j4;
import h6.g;
import h9.e0;
import hb.h0;
import pa.e;
import pa.h;
import t6.w0;
import xa.j;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16132h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e0 f16133i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f f16134j;

    public /* synthetic */ c(e0 e0Var, f fVar, int i10) {
        this.f16132h = i10;
        this.f16133i = e0Var;
        this.f16134j = fVar;
    }

    public final void run() {
        boolean z10 = false;
        int i10 = this.f16132h;
        f fVar = this.f16134j;
        e0 e0Var = this.f16133i;
        switch (i10) {
            case 0:
                d dVar = f.H0;
                j.f("$result", e0Var);
                j.f("this$0", fVar);
                if (((j4) e0Var.get()).f7143h == 0) {
                    String string = ((j4) e0Var.get()).f7144i.getString("result");
                    if (string == null || w.h(string)) {
                        z10 = true;
                    }
                    if (!z10) {
                        l lVar = new l(fVar.f0());
                        NestedScrollView nestedScrollView = new NestedScrollView(lVar.getContext(), (AttributeSet) null);
                        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(nestedScrollView.getContext());
                        TextView textView = new TextView(horizontalScrollView.getContext());
                        textView.setText(string);
                        textView.setTextSize(12.0f);
                        textView.setTextIsSelectable(true);
                        horizontalScrollView.addView(textView);
                        nestedScrollView.addView(horizontalScrollView);
                        lVar.setView(nestedScrollView);
                        lVar.setNegativeButton(R.string.copy_clip, new w0(fVar, string, 1));
                        lVar.setPositiveButton(17039370, new g(6));
                        lVar.c();
                        return;
                    }
                    return;
                }
                return;
            default:
                d dVar2 = f.H0;
                j.f("$result", e0Var);
                j.f("this$0", fVar);
                if (((j4) e0Var.get()).f7143h == 0) {
                    int i11 = ((j4) e0Var.get()).f7144i.getInt("result");
                    if (!h0.X0(fVar.f0())) {
                        return;
                    }
                    if (i11 == 404) {
                        h0.X1(fVar.f0(), R.string.stream_ended);
                        return;
                    }
                    h0.C1(fVar.f0(), R.string.player_error);
                    h0.b1(h0.v0(fVar.C()), (h) null, 0, new e(fVar, (e) null), 3);
                    return;
                }
                return;
        }
    }
}

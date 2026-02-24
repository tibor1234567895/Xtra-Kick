package t6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.i5;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.w0;
import com.github.andreyasadchy.xtra.model.ui.Game;
import com.woxthebox.draglistview.R;
import d5.u;
import fb.w;
import h6.b;
import hb.h0;
import s7.h;
import xa.j;

public final class z extends w0 {

    /* renamed from: b  reason: collision with root package name */
    public final c0 f14676b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(c0 c0Var) {
        super(new x());
        j.f("fragment", c0Var);
        this.f14676b = c0Var;
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        String str;
        String str2;
        String str3;
        boolean z10;
        boolean z11;
        Integer vodDuration;
        String num;
        Integer vodPosition;
        String num2;
        y yVar = (y) k2Var;
        j.f("holder", yVar);
        Game game = (Game) this.f2224a.f2038f.get(i10);
        Context f02 = yVar.f14675i.f0();
        i5 i5Var = yVar.f14674h;
        i5Var.a().setOnClickListener(new b(game, 8, yVar));
        String str4 = null;
        if (game != null) {
            str = game.getBoxArt();
        } else {
            str = null;
        }
        Object obj = i5Var.f875c;
        if (str != null) {
            ImageView imageView = (ImageView) obj;
            j.e("gameImage", imageView);
            imageView.setVisibility(0);
            h0.c1(imageView, yVar.f14675i, game.getBoxArt(), false, false, (u) null, 28);
        } else {
            ImageView imageView2 = (ImageView) obj;
            j.e("gameImage", imageView2);
            h0.J0(imageView2);
        }
        if (game != null) {
            str2 = game.getGameName();
        } else {
            str2 = null;
        }
        TextView textView = (TextView) i5Var.f877e;
        j.e("gameName", textView);
        if (str2 != null) {
            textView.setVisibility(0);
            textView.setText(game.getGameName());
        } else {
            h0.J0(textView);
        }
        if (game == null || (vodPosition = game.getVodPosition()) == null || (num2 = Integer.valueOf(vodPosition.intValue() / 1000).toString()) == null) {
            str3 = null;
        } else {
            h.f14375a.getClass();
            str3 = h.h(f02, num2, true);
        }
        if (str3 == null || w.h(str3)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            TextView textView2 = (TextView) i5Var.f880h;
            j.e("viewers", textView2);
            textView2.setVisibility(0);
            ((TextView) i5Var.f880h).setText(f02.getString(R.string.position, new Object[]{str3}));
        } else {
            TextView textView3 = (TextView) i5Var.f880h;
            j.e("viewers", textView3);
            h0.J0(textView3);
        }
        if (!(game == null || (vodDuration = game.getVodDuration()) == null || (num = Integer.valueOf(vodDuration.intValue() / 1000).toString()) == null)) {
            h.f14375a.getClass();
            str4 = h.h(f02, num, true);
        }
        if (str4 == null || w.h(str4)) {
            z11 = true;
        } else {
            z11 = false;
        }
        TextView textView4 = (TextView) i5Var.f876d;
        j.e("broadcastersCount", textView4);
        if (!z11) {
            textView4.setVisibility(0);
            textView4.setText(f02.getString(R.string.duration, new Object[]{str4}));
            return;
        }
        h0.J0(textView4);
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        return new y(i5.b(LayoutInflater.from(viewGroup.getContext()), viewGroup), this.f14676b);
    }
}

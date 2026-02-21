package t6;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.ui.Game;
import xa.j;

public final class x extends w {
    public final boolean a(Object obj, Object obj2) {
        j.f("oldItem", (Game) obj);
        j.f("newItem", (Game) obj2);
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        Game game = (Game) obj;
        Game game2 = (Game) obj2;
        j.f("oldItem", game);
        j.f("newItem", game2);
        return j.a(game.getVodPosition(), game2.getVodPosition());
    }
}

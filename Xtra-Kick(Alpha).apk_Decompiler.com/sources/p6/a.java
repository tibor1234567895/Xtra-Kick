package p6;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.ui.Game;
import xa.j;

public final class a extends w {
    public final boolean a(Object obj, Object obj2) {
        Game game = (Game) obj;
        Game game2 = (Game) obj2;
        j.f("oldItem", game);
        j.f("newItem", game2);
        return j.a(game.getViewersCount(), game2.getViewersCount());
    }

    public final boolean b(Object obj, Object obj2) {
        Game game = (Game) obj;
        Game game2 = (Game) obj2;
        j.f("oldItem", game);
        j.f("newItem", game2);
        if (game.getGameId() == game2.getGameId()) {
            return true;
        }
        return false;
    }
}

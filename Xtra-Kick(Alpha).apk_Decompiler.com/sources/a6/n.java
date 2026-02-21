package a6;

import m.d;
import r3.n0;

public final class n extends d {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f248d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f249e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, n0 n0Var, int i10) {
        super(n0Var);
        this.f248d = i10;
        this.f249e = obj;
    }

    public final String e() {
        switch (this.f248d) {
            case 0:
                return "DELETE FROM recent_emotes WHERE name NOT IN (SELECT name FROM recent_emotes ORDER BY used_at DESC LIMIT 50)";
            case 1:
                return "DELETE FROM video_positions";
            default:
                return "DELETE FROM requests";
        }
    }
}

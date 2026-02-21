package r9;

import v3.d;

public final class g extends a {
    public g() {
        super(2, 3);
    }

    public final void a(d dVar) {
        p9.d dVar2 = p9.d.REPLACE_EXISTING;
        dVar.p("ALTER TABLE 'requests' ADD COLUMN '_enqueue_action' INTEGER NOT NULL DEFAULT 0");
    }
}

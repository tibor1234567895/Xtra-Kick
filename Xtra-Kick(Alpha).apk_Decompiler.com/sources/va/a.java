package va;

import java.io.File;
import xa.j;

public abstract class a extends f {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(File file) {
        super(file);
        j.f("rootDir", file);
    }
}

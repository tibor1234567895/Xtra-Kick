package jb;

import java.util.NoSuchElementException;

public final class m extends NoSuchElementException {
    public m() {
        super("Channel was closed");
    }
}

package p1;

import java.util.UUID;

public final class i extends Exception {
    public i(UUID uuid) {
        super("Media does not support uuid: " + uuid);
    }
}

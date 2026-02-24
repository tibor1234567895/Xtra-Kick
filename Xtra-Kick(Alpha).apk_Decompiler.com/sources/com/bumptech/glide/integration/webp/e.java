package com.bumptech.glide.integration.webp;

import e5.k;
import java.io.InputStream;
import k5.e0;

public final class e {
    public static int a(c cVar) {
        if ((((cVar.b() << 16) & -65536) | (cVar.b() & 65535)) != 1380533830) {
            return 7;
        }
        cVar.a(4);
        if ((((cVar.b() << 16) & -65536) | (cVar.b() & 65535)) != 1464156752) {
            return 7;
        }
        int b10 = ((cVar.b() << 16) & -65536) | (cVar.b() & 65535);
        if (b10 == 1448097824) {
            return 1;
        }
        if (b10 == 1448097868) {
            cVar.a(4);
            return (cVar.g() & 8) != 0 ? 3 : 2;
        } else if (b10 != 1448097880) {
            return 7;
        } else {
            cVar.a(4);
            int g10 = cVar.g();
            if ((g10 & 2) != 0) {
                return 6;
            }
            return (g10 & 16) != 0 ? 5 : 4;
        }
    }

    public static int b(InputStream inputStream, k kVar) {
        if (inputStream == null) {
            return 7;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, kVar);
        }
        inputStream.mark(21);
        try {
            return a(new d(inputStream, 0));
        } finally {
            inputStream.reset();
        }
    }
}

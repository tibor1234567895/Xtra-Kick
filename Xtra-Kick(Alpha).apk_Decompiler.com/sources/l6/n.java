package l6;

import android.app.Dialog;
import android.os.Bundle;
import b8.h;
import b8.i;

public class n extends i {

    /* renamed from: u0  reason: collision with root package name */
    public static final /* synthetic */ int f9653u0 = 0;

    public final Dialog n0(Bundle bundle) {
        h hVar = (h) super.n0(bundle);
        hVar.setOnShowListener(new m(hVar));
        return hVar;
    }
}

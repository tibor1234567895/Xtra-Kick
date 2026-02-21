package f8;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

public final class c extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f5942a;

    public c(Chip chip) {
        this.f5942a = chip;
    }

    public final void getOutline(View view, Outline outline) {
        f fVar = this.f5942a.f3719l;
        if (fVar != null) {
            fVar.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}

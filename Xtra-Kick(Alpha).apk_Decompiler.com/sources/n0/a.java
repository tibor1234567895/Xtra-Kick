package n0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final int f10899a;

    /* renamed from: b  reason: collision with root package name */
    public final i f10900b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10901c;

    public a(int i10, i iVar, int i11) {
        this.f10899a = i10;
        this.f10900b = iVar;
        this.f10901c = i11;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f10899a);
        this.f10900b.f10916a.performAction(this.f10901c, bundle);
    }
}

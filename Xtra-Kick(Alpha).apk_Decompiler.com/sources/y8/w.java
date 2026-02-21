package y8;

import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

public final class w implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f17232h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f17233i;

    public /* synthetic */ w(TextInputLayout textInputLayout, int i10) {
        this.f17232h = i10;
        this.f17233i = textInputLayout;
    }

    public final void run() {
        int i10 = this.f17232h;
        TextInputLayout textInputLayout = this.f17233i;
        switch (i10) {
            case 0:
                CheckableImageButton checkableImageButton = textInputLayout.f3894j.f17161n;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            default:
                textInputLayout.f3896k.requestLayout();
                return;
        }
    }
}

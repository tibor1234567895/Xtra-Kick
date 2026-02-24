package androidx.appcompat.widget;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.bottomappbar.BottomAppBar$Behavior;
import com.woxthebox.draglistview.R;
import o8.d;
import y7.a;

public final class x3 implements View.OnLayoutChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1127h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1128i;

    public /* synthetic */ x3(int i10, Object obj) {
        this.f1127h = i10;
        this.f1128i = obj;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        int i19 = 0;
        int i20 = this.f1127h;
        Object obj = this.f1128i;
        switch (i20) {
            case 0:
                SearchView searchView = (SearchView) obj;
                View view2 = searchView.E;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.f659y.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean a10 = l5.a(searchView);
                    if (searchView.U) {
                        i19 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
                    }
                    SearchView.SearchAutoComplete searchAutoComplete = searchView.f657w;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    int i21 = rect.left;
                    if (a10) {
                        i18 = -i21;
                    } else {
                        i18 = paddingLeft - (i21 + i19);
                    }
                    searchAutoComplete.setDropDownHorizontalOffset(i18);
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + i19) - paddingLeft);
                    return;
                }
                return;
            case 1:
                ((BottomAppBar$Behavior) obj).getClass();
                throw null;
            default:
                d dVar = (d) obj;
                if (dVar.f12322t.getVisibility() == 0) {
                    a aVar = dVar.K;
                    if (aVar != null) {
                        i19 = 1;
                    }
                    if (i19 != 0) {
                        Rect rect2 = new Rect();
                        ImageView imageView = dVar.f12322t;
                        imageView.getDrawingRect(rect2);
                        aVar.setBounds(rect2);
                        aVar.h(imageView, (FrameLayout) null);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}

package s;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Comparator;

public final class g implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13952h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f13953i;

    public /* synthetic */ g(int i10, Object obj) {
        this.f13952h = i10;
        this.f13953i = obj;
    }

    public final int compare(Object obj, Object obj2) {
        int i10;
        int i11;
        switch (this.f13952h) {
            case 0:
                i10 = ((j) obj).f13960i;
                i11 = ((j) obj2).f13960i;
                break;
            case 1:
                i10 = ((int[]) obj)[0];
                i11 = ((int[]) obj2)[0];
                break;
            default:
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f13953i;
                return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
        }
        return i10 - i11;
    }
}

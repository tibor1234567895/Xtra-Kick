package o3;

import android.text.TextUtils;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.woxthebox.draglistview.R;

public final class j implements v {

    /* renamed from: a  reason: collision with root package name */
    public static j f12137a;

    private j() {
    }

    public static j b() {
        if (f12137a == null) {
            f12137a = new j();
        }
        return f12137a;
    }

    public final CharSequence a(Preference preference) {
        ListPreference listPreference = (ListPreference) preference;
        if (TextUtils.isEmpty(listPreference.z())) {
            return listPreference.f1887h.getString(R.string.not_set);
        }
        return listPreference.z();
    }
}

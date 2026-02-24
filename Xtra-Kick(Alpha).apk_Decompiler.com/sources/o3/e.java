package o3;

import android.text.TextUtils;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.woxthebox.draglistview.R;

public final class e implements v {

    /* renamed from: a  reason: collision with root package name */
    public static e f12118a;

    private e() {
    }

    public static e b() {
        if (f12118a == null) {
            f12118a = new e();
        }
        return f12118a;
    }

    public final CharSequence a(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        if (TextUtils.isEmpty(editTextPreference.f1878a0)) {
            return editTextPreference.f1887h.getString(R.string.not_set);
        }
        return editTextPreference.f1878a0;
    }
}

package i6;

import android.os.Bundle;

public final class a {
    private a() {
    }

    public /* synthetic */ a(int i10) {
        this();
    }

    public static e a(int i10, int i11, String str, String str2) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isLive", true);
        bundle.putInt("channel_id", i10);
        bundle.putString("channel_login", str);
        bundle.putString("channel_name", str2);
        bundle.putInt("streamId", i11);
        eVar.j0(bundle);
        return eVar;
    }

    public static e b(int i10, String str, String str2, Double d10) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isLive", false);
        bundle.putInt("channel_id", i10);
        bundle.putString("channel_login", str);
        bundle.putString("videoId", str2);
        if (d10 != null) {
            bundle.putBoolean("startTime_empty", false);
            bundle.putDouble("startTime", d10.doubleValue());
        } else {
            bundle.putBoolean("startTime_empty", true);
        }
        eVar.j0(bundle);
        return eVar;
    }
}

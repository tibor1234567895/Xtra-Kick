package r3;

import xa.j;

public final class s {
    private s() {
    }

    public /* synthetic */ s(int i10) {
        this();
    }

    public static String a(String str, String str2) {
        j.f("tableName", str);
        j.f("triggerType", str2);
        return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
    }
}

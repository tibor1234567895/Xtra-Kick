package b0;

import android.app.Notification;
import android.app.Person;

public final class z {
    private z() {
    }

    public static Notification.Builder a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Notification.Action.Builder b(Notification.Action.Builder builder, int i10) {
        return builder.setSemanticAction(i10);
    }
}

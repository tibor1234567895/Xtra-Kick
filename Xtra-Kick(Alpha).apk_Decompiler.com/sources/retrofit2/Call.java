package retrofit2;

import dc.s0;
import java.io.IOException;
import pb.j1;

public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    j1 request();

    s0 timeout();
}

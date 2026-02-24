package p9;

public enum f {
    UNKNOWN(-1),
    NONE(0),
    FILE_NOT_CREATED(1),
    CONNECTION_TIMED_OUT(2),
    UNKNOWN_HOST(3),
    HTTP_NOT_FOUND(4),
    WRITE_PERMISSION_DENIED(5),
    NO_STORAGE_SPACE(6),
    NO_NETWORK_CONNECTION(7),
    EMPTY_RESPONSE_FROM_SERVER(8),
    REQUEST_ALREADY_EXIST(9),
    DOWNLOAD_NOT_FOUND(10),
    FETCH_DATABASE_ERROR(11),
    REQUEST_WITH_ID_ALREADY_EXIST(13),
    REQUEST_WITH_FILE_PATH_ALREADY_EXIST(14),
    REQUEST_NOT_SUCCESSFUL(15),
    UNKNOWN_IO_ERROR(16),
    FILE_NOT_FOUND(17),
    FETCH_FILE_SERVER_URL_INVALID(19),
    INVALID_CONTENT_HASH(20),
    FAILED_TO_UPDATE_REQUEST(21),
    FAILED_TO_ADD_COMPLETED_DOWNLOAD(22),
    FETCH_FILE_SERVER_INVALID_RESPONSE(23),
    REQUEST_DOES_NOT_EXIST(24),
    ENQUEUE_NOT_SUCCESSFUL(25),
    COMPLETED_NOT_ADDED_SUCCESSFULLY(26),
    ENQUEUED_REQUESTS_ARE_NOT_DISTINCT(27),
    FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE(28),
    FAILED_TO_RENAME_FILE(29),
    FILE_ALLOCATION_FAILED(30),
    HTTP_CONNECTION_NOT_ALLOWED(31);
    
    public static final e O = null;

    /* renamed from: h  reason: collision with root package name */
    public final int f12655h;

    /* access modifiers changed from: public */
    static {
        O = new e(0);
    }

    /* access modifiers changed from: public */
    f(int i10) {
        this.f12655h = i10;
    }
}

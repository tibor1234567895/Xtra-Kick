package p9;

public final class e {
    private e() {
    }

    public /* synthetic */ e(int i10) {
        this();
    }

    public static f a(int i10) {
        switch (i10) {
            case 0:
                return f.NONE;
            case 1:
                return f.FILE_NOT_CREATED;
            case 2:
                return f.CONNECTION_TIMED_OUT;
            case 3:
                return f.UNKNOWN_HOST;
            case 4:
                return f.HTTP_NOT_FOUND;
            case Constants.MAX_COMPATIBILITY_VERSION:
                return f.WRITE_PERMISSION_DENIED;
            case 6:
                return f.NO_STORAGE_SPACE;
            case 7:
                return f.NO_NETWORK_CONNECTION;
            case 8:
                return f.EMPTY_RESPONSE_FROM_SERVER;
            case 9:
                return f.REQUEST_ALREADY_EXIST;
            case 10:
                return f.DOWNLOAD_NOT_FOUND;
            case 11:
                return f.FETCH_DATABASE_ERROR;
            case 13:
                return f.REQUEST_WITH_ID_ALREADY_EXIST;
            case 15:
                return f.REQUEST_NOT_SUCCESSFUL;
            case Constants.IV_SIZE:
                return f.UNKNOWN_IO_ERROR;
            case 17:
                return f.FILE_NOT_FOUND;
            case 19:
                return f.FETCH_FILE_SERVER_URL_INVALID;
            case 20:
                return f.INVALID_CONTENT_HASH;
            case 21:
                return f.FAILED_TO_UPDATE_REQUEST;
            case 22:
                return f.FAILED_TO_ADD_COMPLETED_DOWNLOAD;
            case 23:
                return f.FETCH_FILE_SERVER_INVALID_RESPONSE;
            case 24:
                return f.REQUEST_DOES_NOT_EXIST;
            case 25:
                return f.ENQUEUE_NOT_SUCCESSFUL;
            case 26:
                return f.COMPLETED_NOT_ADDED_SUCCESSFULLY;
            case 27:
                return f.ENQUEUED_REQUESTS_ARE_NOT_DISTINCT;
            case 28:
                return f.FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE;
            case 29:
                return f.FAILED_TO_RENAME_FILE;
            case 30:
                return f.FILE_ALLOCATION_FAILED;
            case 31:
                return f.HTTP_CONNECTION_NOT_ALLOWED;
            default:
                return f.UNKNOWN;
        }
    }
}

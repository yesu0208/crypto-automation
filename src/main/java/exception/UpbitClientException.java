package exception;

public class UpbitClientException extends RuntimeException {
    public UpbitClientException(String message) {
        super(String.format("업비트 API 호출 중 에러 발생, error=%s", message));
    }
}

public class LottoOopException extends Exception{
	public LottoOopException() {
		super("y 혹은 n를 입력해 주세요");
	}
	public LottoOopException(String message) {
		super(message);
	}
}

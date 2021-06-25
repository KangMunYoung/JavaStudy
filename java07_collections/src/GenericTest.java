
// E:element
// K:Key
// VL Value
public class GenericTest<E> {
	private E username;
	
	public GenericTest() {
	}
	
	public GenericTest(String username) {
		
	}
	public GenericTest(E username) {
		this.username = username;
	}
	
	
	public E getUsername() {
		return username;
	}
	public void setUsername(E username) {
		this.username = username;
	}

}

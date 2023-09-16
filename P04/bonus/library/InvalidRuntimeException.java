package library;
import java.lang.ArithmeticException;
/**
 * Throws invalid runtime error
 *
 */
public class InvalidRuntimeException extends ArithmeticException{
	public InvalidRuntimeException(String title, int runtime){
		super(title + " has invalid runtime of " + runtime);
	}
}

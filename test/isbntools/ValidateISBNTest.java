package isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    // 아래와 같이 use case 생성 후, 테스트 진행하여 실패하는 메소드는 리팩토링을 통해 테스트를 통과하도록 수정한다.
    @Test
    public void checkAValidateISBN() {
//        fail();
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue(result);
    }

    @Test
    public void nineDigitISBNsNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class,
                () -> { validator.checkISBN("123456789");});
    }

    @Test
    public void nonNumeric10DigitISBNsNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class,
                () -> { validator.checkISBN("helloworld");});
    }

    @Test
    public void TenDigitISBNsEndingInXAllowed() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkA13DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780553213119");
        assertTrue(result);
    }
}

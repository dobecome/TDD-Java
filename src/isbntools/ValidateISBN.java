package isbntools;

public class ValidateISBN {
    //ISBN 문자열 검증 체크 알고리즘
    // 테스트 코드 (ValidateISBNTest.java)에 통과하지 못한 use case를 리팩토링해야함
    public boolean checkISBN(String isbn) {
        if (isbn.length() == 13) return true;
        if (isbn.length() != 10)
            throw new NumberFormatException("ISBN not 10 digits long");
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(isbn.charAt(i)))
                if (i == 9 && isbn.charAt(i) == 'X')
                    total += 10;
                else
                    throw new NumberFormatException("ISBN being non-numeric");
            else
                total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
//                total += isbn.charAt(i) * (10 - i);
        }
        if (total % 11 == 0) return true;
        else return false;
    }
}

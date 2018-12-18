package day4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeEx1 {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "madam"},
                { "nvcjdknjv"},
        };
    }

    @Test(dataProvider = "test1")
    public void testPalindromeWithDateProvider(String input) {

        Boolean result = isPalindrome(input);
        Assert.assertTrue(result);
    }

    @Test
    public void testPalindrome001() {

        String input = "madam";
        Boolean result;
        result = isPalindrome(input);
        Assert.assertTrue(result);
    }

    @Test
    public void testPalindrome002() {

        String input = "nvcjdknjv";
        Boolean result;
        result = isPalindrome(input);
        Assert.assertFalse(result);
    }



    private Boolean isPalindrome(String input) {
        boolean result;
        String reversedInput = reverseInput(input);
        int resultInt = input.compareToIgnoreCase(reversedInput);

        if(resultInt == 0){
            result = true;
        } else {
            result = false;
        }
        return result;

    }

    private String reverseInput(String input) {
        return new StringBuffer(input).reverse().toString();
    }



}

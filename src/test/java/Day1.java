import org.testng.annotations.Test;

public class Day1 {

    @Test
public void testMethod1(){
        System.out.println("Hello, World!");
    }

    @Test
    public void testMethod2() {
        int myNumber;
        myNumber = 5;
        System.out.println(myNumber);


    }

    @Test
    public void test003() {
        float f = (float) 4.5;
        System.out.println(f);

    }

    @Test
    public void test004() {
        char c = 'g';
        String s2 = "Who who who who!";
        String s3 = "Who let the dogs out?";
        System.out.println(s2+s3);

    }

    @Test
    public void test005() {
        int num = 4;
        String s = "I have " + num + " cookies";
        System.out.println(s);

    }

    @Test
    public void test006() {
        boolean b = false;
        b = true;

        boolean toBe = false;
        b = toBe || !toBe;

        System.out.println(toBe);
    }

    @Test
    public void test007() {
        boolean ifElementIsPresented = false;
        if (ifElementIsPresented) {
            System.out.println("element is presented");
        } else {
            System.out.println("element is NOT presented");
        }
    }

    @Test
    public void test008() {
        int a = 4;
        int b = 5;
        boolean result;
        result = a > b || a < b;
        System.out.println(result);

    }

    @Test
    public void test009() {
        int[] arrayOfIntegers = new int []{22, 33, 45, 56, 67};
        for(int i = 0; i < arrayOfIntegers.length; i++){

            int arrayMember = arrayOfIntegers[i];
            System.out.println(arrayMember);
        }

    }

    @Test
    public void test_EvenInArray() {
        int [] array = {289, 234, 123, 236, 987, 568};
        for( int i = 0; i < array.length; i++)
        {if(array[i] % 2 == 0)
            System.out.println(array[i]);
            else
            System.out.println("Odd");
        }
    }


}

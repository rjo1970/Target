package com.target.mygroovyretail;

/**
 * Created by jrtitko1 on 9/1/16.
 */
public class FizzBuzz {

    public String check(int value, int fizz, int buzz) {
        if (value % (fizz * buzz) == 0) {
            return "FizzBuzz";
        } else if (value % fizz == 0) {
            return "Fizz";
        } else if (value % buzz == 0) {
            return "Buzz";
        }

        return "" + value;
    }
}

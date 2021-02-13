package com.leetCode.algorithms.medium.credit;
/**
 * So what’s the secret formula? Well, most cards use an algorithm invented by Hans Peter
 * Luhn of IBM. According to Luhn’s algorithm, you can determine if a credit card number is (syntactically) valid as follows:
 *
 * Multiply every other digit by 2, starting with the number’s second-to-last digit, and then add those products’ digits together.
 * Add the sum to the sum of the digits that weren’t multiplied by 2.
 * If the total’s last digit is 0 (or, put more formally, if the total modulo 10 is congruent to 0), the number is valid!
 * That’s kind of confusing, so let’s try an example with David’s Visa: 4003600000000014.
 *
 * For the sake of discussion, let’s first underline every other digit, starting with the number’s second-to-last digit:
 *
 * 4003600000000014
 *
 * Okay, let’s multiply each of the underlined digits by 2:
 *
 * 1•2 + 0•2 + 0•2 + 0•2 + 0•2 + 6•2 + 0•2 + 4•2
 *
 * That gives us:
 *
 * 2 + 0 + 0 + 0 + 0 + 12 + 0 + 8
 *
 * Now let’s add those products’ digits (i.e., not the products themselves) together:
 *
 * 2 + 0 + 0 + 0 + 0 + 1 + 2 + 0 + 8 = 13
 *
 * Now let’s add that sum (13) to the sum of the digits that weren’t multiplied by 2 (starting from the end):
 *
 * 13 + 4 + 0 + 0 + 0 + 0 + 0 + 3 + 0 = 20
 *
 * Yup, the last digit in that sum (20) is a 0, so David’s card is legit!
 *
 * So, validating credit card numbers isn’t hard, but it does get a bit tedious by hand. Let’s write a program.
 *
 * @author Ruslan Pipan
 * @version 1.0
 * */
public class LushnessAlgorithm {
    private int count = 0;

    public LushnessAlgorithm(){}

    public synchronized boolean algorithm(long credit){
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        long creditCopy = credit;

        for (int i = 1; creditCopy > 0; i++){
            if ((i%2) == 0){
                temp2 = (int) ((creditCopy % 10) * 2);
                while (temp2 > 0) {
                    temp3 = temp3 + (temp2 % 10);
                    temp2 /= 10;
                }
            }else {
                temp1 = (int) (temp1 + (creditCopy % 10));
            }
            creditCopy /= 10;
            this.count++;
        }
        return (temp3 + temp1) % 10 == 0;
    }


    public int getCount() {
        int tmp = count;
        this.count = 0;
        return tmp;
    }

}

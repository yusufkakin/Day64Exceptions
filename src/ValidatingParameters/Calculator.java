package ValidatingParameters;

public class Calculator {

    public int factorial(int num) {

        if (num > 0) {
            int answer = 1;
            for (int i = 1; i <= num; i++) {
                answer *= i;
            }
            return answer;
        } else {
            throw new IllegalArgumentException("Input needs to be a positive number");
        }

    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if (subsetSize > 0 && subsetSize < setSize) {

            int numerator = factorial(setSize);
            int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

            return numerator / denominator;

        } else
            throw new IllegalArgumentException("Error on factorial");


    }

}
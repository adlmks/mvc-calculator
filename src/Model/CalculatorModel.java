package Model;

/**
 * Модель для калькулятора, выполняющая базовые арифметические операции.
 */
public class CalculatorModel {

    /**
     * Выполняет операцию сложения двух чисел.
     *
     * @param a Первое число.
     * @param b Второе число.
     * @return Сумма чисел a и b.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Выполняет операцию вычитания двух чисел.
     *
     * @param a Уменьшаемое число.
     * @param b Вычитаемое число.
     * @return Разность чисел a и b.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Выполняет операцию умножения двух чисел.
     *
     * @param a Первое число.
     * @param b Второе число.
     * @return Произведение чисел a и b.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Выполняет операцию деления двух чисел с проверкой на деление на ноль.
     *
     * @param a Делимое число.
     * @param b Делитель.
     * @return Частное от деления a на b.
     * @throws ArithmeticException если b равно нулю.
     */
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Ошибка: деление на ноль");
        return a / b;
    }
}

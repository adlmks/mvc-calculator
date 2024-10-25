package Controller;

import Model.CalculatorModel;
import View.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс CalculatorController связывает CalculatorModel и CalculatorView.
 * Обрабатывает пользовательский ввод и передает данные между моделью и представлением.
 */
public class CalculatorController {
    private CalculatorModel model; // Модель калькулятора
    private CalculatorView view;   // Представление калькулятора

    /**
     * Конструктор инициализирует контроллер, модель и представление,
     * а также добавляет слушателя для кнопок операций.
     *
     * @param model объект CalculatorModel, содержащий логику расчетов.
     * @param view объект CalculatorView, представляющий интерфейс пользователя.
     */
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // Добавление слушателя для операций
        this.view.addOperationListener(new OperationListener());
    }

    /**
     * Класс OperationListener обрабатывает события, связанные с нажатиями кнопок операций.
     */
    class OperationListener implements ActionListener {
        /**
         * Выполняет нужную операцию при нажатии на соответствующую кнопку,
         * получает введенные пользователем числа и обновляет результат в представлении.
         *
         * @param e событие действия (ActionEvent), которое происходит при нажатии кнопки.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Получаем числа из текстовых полей
                double firstNumber = view.getFirstNumber();
                double secondNumber = view.getSecondNumber();
                String result;

                // Проверка нажатой кнопки и выполнение соответствующей операции
                if (e.getSource() == view.addButton) {
                    result = String.valueOf(model.add(firstNumber, secondNumber));
                } else if (e.getSource() == view.subtractButton) {
                    result = String.valueOf(model.subtract(firstNumber, secondNumber));
                } else if (e.getSource() == view.multiplyButton) {
                    result = String.valueOf(model.multiply(firstNumber, secondNumber));
                } else if (e.getSource() == view.divideButton) {
                    result = String.valueOf(model.divide(firstNumber, secondNumber));
                } else {
                    result = "Неизвестная операция";
                }

                // Отображение результата в интерфейсе
                view.setResult(result);
            } catch (NumberFormatException ex) {
                // Обработка ошибки, если введены некорректные числовые данные
                view.setResult("Ошибка: введите числовые значения");
            } catch (ArithmeticException ex) {
                // Обработка арифметической ошибки (например, деление на ноль)
                view.setResult(ex.getMessage());
            }
        }
    }
}

import Controller.CalculatorController;
import Model.CalculatorModel;
import View.CalculatorView;


public class Main {
    public static void main(String[] args) {
        // Создание экземпляра модели калькулятора, содержащей логику расчетов
        CalculatorModel model = new CalculatorModel();

        // Создание экземпляра представления калькулятора, представляющего интерфейс пользователя
        CalculatorView view = new CalculatorView();

        // Создание экземпляра контроллера, который связывает модель и представление
        CalculatorController controller = new CalculatorController(model, view);

        // Отображение представления калькулятора на экране
        view.setVisible(true);
    }
}

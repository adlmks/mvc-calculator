package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Класс CalculatorView отвечает за создание пользовательского интерфейса
 * калькулятора, включая поля ввода, кнопки операций и отображение результата.
 */
public class CalculatorView extends JFrame {
    // Поля ввода для чисел
    public JTextField firstNumber = new JTextField(10);
    public JTextField secondNumber = new JTextField(10);

    // Кнопки операций
    public JButton addButton = new JButton("+");
    public JButton subtractButton = new JButton("-");
    public JButton multiplyButton = new JButton("×");
    public JButton divideButton = new JButton("÷");

    // Метки для результата и заголовка
    public JLabel resultLabel = new JLabel("Результат:");
    public JLabel titleLabel = new JLabel("Калькулятор", SwingConstants.CENTER);

    /**
     * Конструктор инициализирует пользовательский интерфейс.
     */
    public CalculatorView() {
        // Настройка окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Калькулятор by Adil");
        this.setLayout(new BorderLayout(10, 10));

        // Настройка заголовка
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setForeground(new Color(60, 63, 65));
        this.add(titleLabel, BorderLayout.NORTH);

        // Панель для ввода чисел и операций
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        // Поля ввода чисел
        c.gridx = 0; c.gridy = 0;
        panel.add(new JLabel("Число 1:"), c);
        c.gridx = 1; c.gridy = 0;
        firstNumber.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(firstNumber, c);

        c.gridx = 0; c.gridy = 1;
        panel.add(new JLabel("Число 2:"), c);
        c.gridx = 1; c.gridy = 1;
        secondNumber.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(secondNumber, c);

        // Панель кнопок операций
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        addButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        subtractButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        multiplyButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        divideButton.setFont(new Font("SansSerif", Font.BOLD, 16));

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Настройка отображения результата
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.WHITE);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        resultLabel.setForeground(new Color(60, 63, 65));
        resultPanel.add(resultLabel);

        // Добавление панелей в основное окно
        this.add(panel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(resultPanel, BorderLayout.EAST);
        this.getContentPane().setBackground(Color.WHITE);
    }

    /**
     * Возвращает значение, введённое в первое поле как число.
     *
     * @return Значение из первого поля ввода.
     */
    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    /**
     * Возвращает значение, введённое во второе поле как число.
     *
     * @return Значение из второго поля ввода.
     */
    public double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText());
    }

    /**
     * Устанавливает текст результата.
     *
     * @param result Результат для отображения в интерфейсе.
     */
    public void setResult(String result) {
        resultLabel.setText("Результат: " + result);
    }

    /**
     * Добавляет слушатели для кнопок операций.
     *
     * @param listener Обработчик событий для кнопок.
     */
    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }
}

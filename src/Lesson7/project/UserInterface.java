package Lesson7.project;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "�������� ��������: " +
                            "1 - �������� ������� ������, " +
                            "2 - �������� ������ �� ��������� 5 ����, " +
                            "����� (exit) - ��������� ������");
            String result = scanner.nextLine();
            checkIsExit(result);

            System.out.println("������� �������� ������ �� ���������� �����");
            String city = scanner.nextLine();
            setGlobalCity(city);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkIsExit(String result) {
        if (result.equalsIgnoreCase("�����") || result.equalsIgnoreCase("exit")) {
            System.out.println("�������� ������");
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws IOException {
        controller.onUserInput(input);
    }
}

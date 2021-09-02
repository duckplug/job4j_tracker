package ru.job4j.tracker;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    private boolean isNumber(String value) {
        boolean rsl = true;
        char[] check = value.toCharArray();
        for (char num : check) {
            if (num < 48 || num > 57) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            String rsl = askStr(question);
            if (!isNumber(rsl)) {
                System.out.println("Please enter validate data again.");
                continue;
            }
            value = Integer.parseInt(rsl);
            invalid = false;
        } while (invalid);
        return value;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }


}
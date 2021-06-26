package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public  Error() {
    }

    public  Err (boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {

        System.out.println("Пользователь в сети: "+ active);
        System.out.println("Статус сообщения: " + status);
        System.out.println("Сообщение: " + message);

    }

     public static void main(String[] args) {
        Error error = new Error();
        Error err = new Err (true, 1, "123");
        error.printInfo();
        err.printInfo();
     }

}



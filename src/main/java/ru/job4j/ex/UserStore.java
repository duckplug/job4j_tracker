package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
         boolean rsl = true;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
             rsl = false;
             break;
            }
        }
        if (rsl) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return null;
    }



    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid()) {
            throw new UserInvalidException("пользователь не прошел валидацию");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Дина имени должна быть больше 3 символов");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException a) {
            a.printStackTrace();

        } catch (UserInvalidException ae) {
            ae.printStackTrace();
        }


    }
}
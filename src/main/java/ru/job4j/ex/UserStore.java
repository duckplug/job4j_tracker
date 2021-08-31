package ru.job4j.ex;
public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                rsl = users[i];
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = user.isValid() && user.getUsername().length() > 3;
        if (rsl == false) {
            throw new UserInvalidException("Юзер не прошел валидацию");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException a) {
            a.printStackTrace();
        } catch (UserNotFoundException b) {
            b.printStackTrace();
        }
    }
}



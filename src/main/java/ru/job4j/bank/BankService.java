package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 * @author OKOLELOV ANTON
 */
public class BankService {
    /**
     * Хранение аккаунтов пользователей банка осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя, если такого ранее не было, и создает
     * коллекцию для его счетов типа ArrayList
     * @param user - пользователь, которого хотят добавить
     * @see ru.job4j.bank.Account
     * @see  ru.job4j.bank.User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод находит пользователя банка по паспортным данным
     * при помощи метода findByPassport {@link ru.job4j.bank.BankService#findByPassport(String)}
     * если такой пользователь есть, то далее проверяется наличие данного счета, если счета не было,
     * то он добавляется
     * @param passport - паспортные данные пользователя
     * @param account - счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> allUser = users.get(user);
            if (!allUser.contains(account)) {
                allUser.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по паспортным данным,
     * если такого пользователя нет, то возвращает null
     * @param passport - паспортные данные
     * @return возвращает найденного пользователя, либо null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод находит счет пользователя по паспортным данным и реквизитам
     * если пользователь найден по паспорту, то ищется аккаунт по заданным реквизитам
     * @param passport - паспортные данные пользователя
     * @param requisite - реквизиты пользователя
     * @return возвращает найденный по входным данным счет, либо null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для реализации перевода банковских средств
     * с одного счета клиента на другой другого клиента этого же банка
     * Сначала находится счет с которого будут списаны средства
     * при помощи метода {@link ru.job4j.bank.BankService#findByRequisite(String, String)}
     * После находится счет зачисления по тому же методу
     * Если все счета найдены и сумма для перевода не превышает возможную для списания,
     * происходит списание суммы с исходного счета на заданный
     *
     * @param srcPassport - паспортные данные пользователя
     * @param srcRequisite - реквизиты счета отправителя
     * @param destPassport - паспортные данные клиента зачислителя
     * @param destRequisite - реквизиты счета зачислителя
     * @param amount - сумма перевода
     * @return метод возвращает true, если перевод прошел успешно и false,
     * если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if ((accountSrc != null) && (accountDest != null) && (accountSrc.getBalance() >= amount)) {
            accountDest.setBalance(amount + accountDest.getBalance());
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
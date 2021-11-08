package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> allUser = users.get(user);
            if (!allUser.contains(account)) {
                allUser.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User findUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                findUser = user;
                break;
            }
        }
        return findUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account findAccount : users.get(user)) {
                if (findAccount.getRequisite().equals(requisite)) {
                    account = findAccount;
                    break;
                }
            }
        }
        return account;
    }

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
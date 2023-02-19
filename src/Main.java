/*
Дан список банковских транзакций (Account debit, Account credit, amount), класс Account(IBAN, Person) - банковский счет.
Необходимо реализовать метод который сортирует транзакции по сумме (по возрастанию, по убыванию),
по номеру счета дебита, по номеру счета кредита, по имени персона в счете по дебету,
по имени персона в счете по кредиту.
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Kirill", "Petrov", 35);
        Person p2 = new Person("Ivan", "Ivanov", 45);
        Person p3 = new Person("Olga", "Vasileva", 22);
        Person p4 = new Person("Olga", "Vasileva", 2222222);

        Account account1 = new Account("DE4545", p1);
        Account account2 = new Account("ES1111", p1);
        Account account3 = new Account("IT2222", p2);
        Account account4 = new Account("FR3333", p2);
        Account account5 = new Account("DE8888", p3);
        Account account6 = new Account("RU4343", p3);

        Transaction transaction1 = new Transaction(account1, account2, 2_000.00);
        Transaction transaction2 = new Transaction(account1, account5, 5_000.45);
        Transaction transaction3 = new Transaction(account2, account1, 200.03);
        Transaction transaction4 = new Transaction(account1, account4, 2_000.15);
        Transaction transaction5 = new Transaction(account2, account5, 1_000.87);
        Transaction transaction6 = new Transaction(account1, account6, 750.58);
        Transaction transaction7 = new Transaction(account5, account3, 300.32);
        Transaction transaction8 = new Transaction(account6, account2, 10.02);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction5);
        transactionList.add(transaction6);
        transactionList.add(transaction7);
        transactionList.add(transaction8);

        Comparator<Transaction> comparatorByAmount = new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                if (o1.getAmount() > o2.getAmount()) return 1;
                if (o1.getAmount() < o2.getAmount()) return -1;
                return 0;
            }
        };

        Comparator<Transaction> comparatorByAccount = new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getDebit().getIBAN().compareTo(o2.getDebit().getIBAN());
            }
        };

        System.out.println(sortTransactions(transactionList, comparatorByAmount));
        System.out.println();
        System.out.println(sortTransactions(transactionList, comparatorByAccount));

    }

    public static List<Transaction> sortTransactions(List<Transaction> list, Comparator<Transaction> comparator) {
        List<Transaction> result = new ArrayList<>(list);

        result.sort(comparator);

        return result;
    }

}
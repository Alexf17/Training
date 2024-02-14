package org.example.TESTING._2024_02_09_morning.taski;

public interface TransactionRepository {
    /**
     * Обрабатывает транзакцию с указанной суммой.
     * @param amount сумма транзакции.
     * @return true, если транзакция успешно обработана, иначе false.
     */
    boolean processTransaction(double amount);
}

package com.bill.transaction

import io.quarkus.mongodb.panache.PanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class AccountingServiceImpl: AccountingService, PanacheMongoRepository<Accounting> {

    override fun saveOrUpdate(balance: Accounting): Accounting =
        balance.also {
            persistOrUpdate(balance)
        }

    override fun findByAccountId(accountId: String): Accounting? =
        find("accountId", accountId).firstResult()

    override fun recalculate(transaction: Transaction): Accounting =
        transaction.let {
            val currentBalance =
                findByAccountId(transaction.accountId) ?:
                Accounting.defaultInstance(transaction.accountId)
            saveOrUpdate(currentBalance.recalculate(transaction))
        }

}
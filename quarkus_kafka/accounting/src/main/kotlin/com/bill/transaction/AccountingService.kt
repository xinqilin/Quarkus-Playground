package com.bill.transaction

interface AccountingService {

    fun saveOrUpdate(balance: Accounting): Accounting

    fun findByAccountId(accountId: String): Accounting?

    fun recalculate(transaction: Transaction): Accounting

}
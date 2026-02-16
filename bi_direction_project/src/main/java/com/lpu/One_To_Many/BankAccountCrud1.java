package com.lpu.One_To_Many;

import java.util.List;

public interface BankAccountCrud1 {
	void saveBank(Bank bank);
	
	void updateBank(int id);
	
	Bank findBankById(int id);
	
	Bank findBankByName(String name);
	
	void giveAccountToBank(int bankId, Account newAccount);
	
	void giveAccountToBank(int bankId, List<Account> accounts);
}

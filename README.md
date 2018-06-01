# bacs-transactions-splitter
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000001
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000002
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000003
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000004
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000005
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000006
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000007
2000001122334401720000077776666000000000000011ALLOKAY   00000001WAGES  00000000001JOHN   00000000008

# Scope of project:
1. Read a bacs file from a path
2. If I want to split these 8 transactions into 2 transactions in each chunk such that it will produce following output in loop as follows:
split1 = first two transactions (2)
parent1 = remaining 6 transactions (6)
split2 = first two transactions from parent1
parent2 = remaining 4 transactions (4)
split3 = first two transactions from parent2
parent3 = remaining 2 transactions
split4 = last two transactions and parent will have no transactions at this time.

3. Generated files split and parent files in as described in step 2.

        String fileName = "files/bacs split/STD18_daily_test_with txns only.txt";
        int txnPerSplit = 2;
        String splitFileName = "files/bacs split/output/_split";
        String parentFileName = "files/bacs split/output/parent";
        String fileExtenstion = ".txt";
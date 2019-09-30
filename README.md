# RelativeBalanceTransferService

RelativeBalanceTransfer App is build to calculate relative balance of an account in reference to transaction list provided for defined timeframe.

Arguments:

accountId: this specifies the account number for which relative balance needs to be found
from: this specifies the duration start time from which transactions need to be considered
to: this specifies the duration end time to which transactions need to be considered

Transaction_Data.csv: included in the project folder which consists of transaction list in a CSV format.
Update pr replace this CSV to include any new transactions on which balance need to be performed.

Output:

Relative balance : this is the relative balance for the given account
Number of transactions : Number of transactions that were considered in calculating the balance


Design:

I have approached this problem using java streams to filter the transactions list to only transactions that is required to be considered
and then calculating the balance and also counting number of transactions after filtering display number of transactions in the output.

Step1: Creating a java stream on transaction list
Step2: Filtering transactions where fromAccountId or toAccountId is the accountId that was provided at run time by the user
Step3: Further filter with transaction type to PAYMENT and which fall within given from and to time.
Step4: Create a list of RelatedTransactionId where payment type is REVERSAL.
Step5: Check whether if filtered transaction id is present in the REVERSAL list, If yes then ignore.
Step6: Once you have the filtered concerned to only given accountId, iterate through and calculate balance.

Using Java Streams have actually simplified the process of identifying the valid transactions on which we need to calculate balance.

Installation and Execution:

Step1: Clone the Repository from GITHub
Step2: Using maven build the project (mvn clean install -DskipITs) to create a .jar file in target directory. (install maven if not available)
Step3: use below command to run the application:

       java -jar relative-balance-app-1.0-SNAPSHOT.jar

Test Cases:

Junit Test cases has been written to test the functional correctness in RelativeBalanceServiceTest and CSVReaderTest classes.

 

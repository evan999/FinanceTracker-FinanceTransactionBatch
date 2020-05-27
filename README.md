# FinanceTracker-FinanceTransactionBatch
Transaction batch data process for Finance Tracker application. Converts CSV file into records of data in PostgreSQL database.

TransactionBatch is a Spring Boot microservice that utilizes Spring Batch and connects with JDBC to read a CSV file 
and inserts each row of data into a record in the PostgreSQL database. The batch job also populates a table of all the batch jobs that have run
and their status in the database. 

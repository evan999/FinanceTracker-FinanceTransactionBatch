package com.financetracker.TransactionBatch.Dao.impl;

import com.financetracker.TransactionBatch.Dao.TransactionDao;
import com.financetracker.TransactionBatch.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TransactionDaoImpl extends JdbcDaoSupport implements TransactionDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(List<? extends Transaction> Transactions) {
        String sql = "INSERT INTO transaction " + "(step, type, amount, nameOrig, oldbalanceOrig, newbalanceOrig, nameDest, oldbalanceDest, newbalanceDest, isFraud, isFlaggedFraud) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Transaction transaction = Transactions.get(i);
                //ps.setLong(1, transaction.getId());
                ps.setInt(1, transaction.getStep());
                ps.setString(2, transaction.getType());
                ps.setDouble(3, transaction.getAmount());
                ps.setString(4, transaction.getNameOrig());
                ps.setDouble(5, transaction.getOldbalanceOrig());
                ps.setDouble(6, transaction.getNewbalanceOrig());
                //ps.setString(7, transaction.getNameDest());
                ps.setDouble(8, transaction.getOldbalanceDest());
                ps.setDouble(9, transaction.getNewbalanceDest());
                ps.setInt(10, transaction.getIsFraud());
                ps.setInt(11, transaction.getIsFlaggedFraud());
            }

            public int getBatchSize() {
                return Transactions.size();
            }
        });

    }

    @Override
    public List<Transaction> loadAllTransactions() {
        String sql = "SELECT * FROM transaction";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Transaction> result = new ArrayList<Transaction>();
        for (Map<String, Object> row : rows) {
            Transaction transaction = new Transaction();
            //transaction.setId((Long) row.get("transaction_id"));
            transaction.setStep((Integer) row.get("step"));
            transaction.setType((String) row.get("type"));
            transaction.setAmount((Double) row.get("amount"));
            transaction.setNameOrig((String) row.get("nameOrig"));
            transaction.setOldbalanceOrig((Double) row.get("oldbalanceOrig"));
            transaction.setNewbalanceOrig((Double) row.get("newbalanceOrig"));
            //transaction.setNameDest((String) row.get("nameDest"));
            transaction.setOldbalanceDest((Double) row.get("oldbalanceDest"));
            transaction.setNewbalanceDest((Double) row.get("newbalanceDest"));
            transaction.setIsFraud((Integer) row.get("isFraud"));
            transaction.setIsFlaggedFraud((Integer) row.get("isFlaggedFraud"));
            result.add(transaction);
        }

        return result;
    }
}


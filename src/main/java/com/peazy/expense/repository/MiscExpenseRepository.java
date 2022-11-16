package com.peazy.expense.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.peazy.expense.model.entity.MiscExpenseEntity;

@Repository
public interface MiscExpenseRepository extends JpaRepository<MiscExpenseEntity, Long> {
        @Query(value = "SELECT SeqNo, CodeKey, Amount, ExpenseDt, CreateUser, CreateDt, UpdateUser, UpdateDt FROM Supplier_MiscExpense WHERE CreateUser = :createUser AND (:fromDate IS NULL OR ExpenseDt >= :fromDate) AND (:toDate IS NULL OR ExpenseDt <= :toDate)",
                        nativeQuery = true)
        public List<MiscExpenseEntity> queryExpense(@Param("createUser") String createUser,
                        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

        @Query(value = "DELETE FROM Supplier_MiscExpense WHERE SeqNo IN (:seqNos)",
                        nativeQuery = true)
        @Modifying
        public void deleteBySeqNoIn(@Param("seqNos") List<Long> seqNos);
}

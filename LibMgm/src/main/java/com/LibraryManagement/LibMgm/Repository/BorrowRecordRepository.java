package com.LibraryManagement.LibMgm.Repository;

import com.LibraryManagement.LibMgm.Entitiy.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}

package com.LibraryManagement.LibMgm.Service;

import com.LibraryManagement.LibMgm.Entitiy.BorrowRecord;

import java.util.List;
import java.util.Optional;

public interface BorrowRecordService {
    BorrowRecord saveBorrowRecord(BorrowRecord borrowRecord);

    List<BorrowRecord> getAllBorrowRecords();

    Optional<BorrowRecord> getBorrowRecordById(Long recordId);

    void deleteBorrowRecord(Long recordId);
}

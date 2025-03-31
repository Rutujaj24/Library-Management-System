package com.LibraryManagement.LibMgm.Service;

import com.LibraryManagement.LibMgm.Entitiy.BorrowRecord;
import com.LibraryManagement.LibMgm.Repository.BorrowRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;

     @Autowired
    public BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

@Transactional
    @Override
    public BorrowRecord saveBorrowRecord(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    @Override
    public Optional<BorrowRecord> getBorrowRecordById(Long recordId) {
        return borrowRecordRepository.findById(recordId);
    }
@Transactional
    @Override
    public void deleteBorrowRecord(Long recordId) {
borrowRecordRepository.deleteById(recordId);
    }
}

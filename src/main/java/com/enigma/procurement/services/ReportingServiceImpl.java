package com.enigma.procurement.services;

import com.enigma.procurement.models.Reporting;
import com.enigma.procurement.models.Transaction;
import com.enigma.procurement.repositories.TransactionRepository;
import com.enigma.procurement.repositories.specifications.ReportingSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {

    private TransactionRepository transactionRepository;

    public ReportingServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Reporting> getAllToday() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<Reporting> reportings = new ArrayList<>();
        for (Transaction transaction:
             transactions) {

            Reporting reporting = new Reporting();
            reporting.setProductId(transaction.getStock().getProduct().getProductId());
            reporting.setQty(transaction.getQty());
            reporting.setDate(transaction.getDateTransaction());
            reporting.setAmount(transaction.getQty()*transaction.getStock().getPriceProduct().getPrice());
            reporting.setCategoryName(transaction.getStock().getProduct().getCategory().getCategoryName());
            reporting.setVendorName(transaction.getStock().getVendor().getVendorName());
            reporting.setProductName(transaction.getStock().getProduct().getProductName());
            reporting.setPriceProduct(transaction.getStock().getPriceProduct().getPrice());

            reportings.add(reporting);
        }

        return reportings;
    }

    @Override
    public List<Reporting> getAllMonth() {
        Specification spec = new ReportingSpec().getAllDateMonth();
        List<Transaction> transactions = transactionRepository.findAll(spec);
        List<Reporting> reportings = new ArrayList<>();

        for (Transaction transaction:
                transactions) {

            Reporting reporting = new Reporting();
            reporting.setProductId(transaction.getStock().getProduct().getProductId());
            reporting.setQty(transaction.getQty());
            reporting.setDate(transaction.getDateTransaction());
            reporting.setAmount(transaction.getQty()*transaction.getStock().getPriceProduct().getPrice());
            reporting.setCategoryName(transaction.getStock().getProduct().getCategory().getCategoryName());
            reporting.setVendorName(transaction.getStock().getVendor().getVendorName());
            reporting.setProductName(transaction.getStock().getProduct().getProductName());
            reporting.setPriceProduct(transaction.getStock().getPriceProduct().getPrice());

            reportings.add(reporting);
        }
    return reportings;
    }
    public List<Reporting> getAll() {
        Specification spec = new ReportingSpec().getAllDateMonth();
        List<Transaction> transactions = transactionRepository.findAll(spec);
        List<Reporting> reportings = new ArrayList<>();



        for (Transaction transaction:
                transactions) {

            Reporting reporting = new Reporting();
            reporting.setProductId(transaction.getStock().getProduct().getProductId());
            reporting.setQty(transaction.getQty());
            reporting.setDate(transaction.getDateTransaction());
            reporting.setAmount(transaction.getQty()*transaction.getStock().getPriceProduct().getPrice());
            reporting.setCategoryName(transaction.getStock().getProduct().getCategory().getCategoryName());
            reporting.setVendorName(transaction.getStock().getVendor().getVendorName());
            reporting.setProductName(transaction.getStock().getProduct().getProductName());
            reporting.setPriceProduct(transaction.getStock().getPriceProduct().getPrice());

            reportings.add(reporting);
        }
        return reportings;
    }
}

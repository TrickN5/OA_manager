package com.oa.manage.service.impl;

import com.oa.commons.PaymentData;
import com.oa.manage.service.PaymentService;
import com.oa.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public List<PaymentData> getPayments() {
        return paymentMapper.getPayments();
    }
}

package org.example.TESTING._2024_02_09_morning.taski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @InjectMocks
    PaymentService paymentService;
    @Mock
    SimpleNotificationService notificationService;

    @Mock
    SimpleTransactionRepository transactionRepository;

//    double aDouble = Mockito.anyDouble();
    @Test
    void makePaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true);
        Assertions.assertTrue(paymentService.makePayment(0.1));
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
        Mockito.verify(transactionRepository).processTransaction(Mockito.anyDouble());
    }
    @Test
    void makePaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(false);
        Assertions.assertFalse(paymentService.makePayment(0.1));
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
        Mockito.verify(transactionRepository).processTransaction(Mockito.anyDouble());
    }

    @Test
    void refundPaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);
        paymentService.refundPayment(-Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
        Mockito.verify(transactionRepository).processTransaction(Mockito.anyDouble());

    }
    @Test
    void refundPaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(false);
        paymentService.refundPayment(-Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
        Mockito.verify(transactionRepository).processTransaction(Mockito.anyDouble());
    }

    @Test
    void adjustPaymentWithRefundResultTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true);
        paymentService.adjustPayment(0.1,0.1);
        Mockito.verify(notificationService,Mockito.times(2)).sendPaymentNotification(Mockito.anyString());
    }
    @Test
    void adjustPaymentWithRefundResultWithOutPaymentResultTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true).thenReturn(false);
//        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(false);
        paymentService.adjustPayment(0.1,0.1);
        Mockito.verify(notificationService,Mockito.times(2)).sendPaymentNotification(Mockito.anyString());
    }
    @Test
    void adjustPaymentWithOutRefundResultTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(false);
        paymentService.adjustPayment(0.1,0.1);
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void verifyPayment() {
    }

    @Test
    void cancelPayment() {
    }

    @Test
    void freezeTransaction() {
    }

    @Test
    void unfreezeTransaction() {
    }

    @Test
    void schedulePayment() {
    }

    @Test
    void confirmPayment() {
    }

    @Test
    void declinePayment() {
    }
}
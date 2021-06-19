package edu.programacion.central.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import edu.programacion.central.dto.Card;
import edu.programacion.central.dto.Payment;
import edu.programacion.central.dto.RegisterCard;
import edu.programacion.central.integration.api.PaymentAPI;

@Controller
public class PaymentController {
    private final PaymentAPI paymentAPI;
    private static final String CARDS_LIST = "card/listcards";
    // private static final String CARD_DELETE = "card/listcards";
    private static final String CARD_REGISTER = "card/register";
    private static final String CARD_DELETE = "card/listcards";
    private static final String CUSTOMER_CARD = "card/customer/cards";
    private static final String PAYMENT_REGISTER = "payment/register";
    private static String MODEL_PAYMENT = "payment";
    private static String MODEL_CARD = "card";
    private static String MODEL_REGISTER_CARD = "register_card";

    public PaymentController(PaymentAPI paymentAPI) {
        this.paymentAPI = paymentAPI;
    }

    @GetMapping(CARDS_LIST)
    public String index(Model model) {
        List<Card> tarjetas = paymentAPI.getCards();
        model.addAttribute("cards", tarjetas);
        return CARDS_LIST;
    }

    @GetMapping(CARD_REGISTER)
    public String create_card(Model model) {
        model.addAttribute(MODEL_REGISTER_CARD, new RegisterCard());
        return CARD_REGISTER;
    }

    @PostMapping(CARD_REGISTER)
    public String createCard(Model model, RegisterCard objCard, BindingResult result) {
        paymentAPI.postCards(objCard);
        model.addAttribute("card", objCard);
        model.addAttribute("mensaje", "Se registro con éxito");
        return CARD_REGISTER;
    }

    @GetMapping(PAYMENT_REGISTER)
    public String create_payment(Model model) {
        model.addAttribute(MODEL_PAYMENT, new Payment());
        return PAYMENT_REGISTER;
    }

    @PostMapping(PAYMENT_REGISTER)
    public String createPayment(Model model, Payment objPay, BindingResult result) {
        paymentAPI.postPayments(objPay);
        model.addAttribute("payment", objPay);
        model.addAttribute("mensaje", "Se registro con éxito");
        return PAYMENT_REGISTER;
    }
}
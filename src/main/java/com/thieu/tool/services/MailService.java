package com.thieu.tool.services;

import com.thieu.tool.models.MailBill;
import com.thieu.tool.models.MailUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailConfirmRegister(MailUser mailUser) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(mailUser.getUserAddress());
        mail.setSubject("Bán hàng cùng Drivy !");
        mail.setText("Chúc mừng bạn " + mailUser.getUserName()
                + " đã đăng ký thành công với tên cửa hàng: \""+ mailUser.getStoreName() +"\" là nhà cung cấp sản phẩm đồng hành cùng Drivy.");
        javaMailSender.send(mail);
    }

    public void senEmailBuyProduct(MailBill mailBill) throws MailException{
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(mailBill.getUserEmail());
        mail.setSubject("Xác nhận đơn hàng với Drivy !");
        mail.setText("Cảm ơn bạn đã tin tưởng và mua hàng tại Drivy. Đơn hàng của bạn: "
                + mailBill.getBill());
        javaMailSender.send(mail);
    }
}

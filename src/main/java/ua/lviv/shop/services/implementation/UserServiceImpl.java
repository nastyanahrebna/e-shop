package ua.lviv.shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.shop.entity.User;
import ua.lviv.shop.repo.UserRepo;
import ua.lviv.shop.services.UserService;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.NoResultException;
import java.util.*;

/**
 * Created by wild_bo on 18.07.16.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public void add(String firsName, String lastName, String password, String email, String phone, String address) {
        User user = new User();
        user.setFirstName(firsName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        userRepo.save(user);
    }

    @Override
    public void add(User user) {
        userRepo.save(user);
    }

    @Override
    public void edit(int id, String firsName, String lastName, String password, String email, String phone, String address) {
        User user = userRepo.findOne(id);
        if(firsName!=null){
            user.setFirstName(firsName);
        }
        if (lastName!=null){
            user.setLastName(lastName);
        }
        if(password!=null){
            user.setPassword(password);
        }
        if(email!=null){
            user.setEmail(email);
        }
        if(phone!=null){
            user.setPhone(phone);
        }
        if(address!=null){
            user.setAddress(address);
        }
        userRepo.save(user);
    }

    @Override
    public void edit(User user) {
        userRepo.save(user);
    }


    @Override
    public void delete(int id) {
        User user = userRepo.findOne(id);
        userRepo.delete(user);
    }

    @Override
    public User findOneById(int id) {
        return userRepo.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }



    @Override
    public void sendEmail(int id, String email, String userName, String password, String registrationVar) {

        try{

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("bybycik@gmail.com", "qfgl");
                }
            });

            mailSession.setDebug(true); // Enable the debug mode

            Message msg = new MimeMessage( mailSession );

            msg.setFrom( new InternetAddress( "bybycik@gmai.com" ) );
            msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(email) );
            msg.setSentDate( new Date());
            msg.setSubject( "Registration" );


            registrationVar = registrationVar.replace(".", "-");


            msg.setText( "Hello " + userName + ",\n Your login: " + email + "\n Your password: " + password
            + "\n Registration link: localhost:8080/registration/" + registrationVar);

            Transport.send( msg );

        }catch(Exception E){
            System.out.println( "Oops something has gone pearshaped!");
            System.out.println( E );
        }


    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user;
        try {
            user = userRepo.findUserByLogin(login);

            System.out.println(user);

        } catch (NoResultException e) {
            return null;
        }
        Collection<SimpleGrantedAuthority>authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()),user.getPassword(),authorities);
    }

}

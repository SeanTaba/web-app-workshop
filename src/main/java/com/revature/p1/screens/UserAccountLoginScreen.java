package com.revature.p1.screens;

import com.revature.orm.MyObjectRelationalMapper;
import com.revature.p1.entities.Credential;
import com.revature.p1.utilities.InputValidator;
import com.revature.p1.utilities.ScreenManager;
import com.revature.p1.utilities.datasource.Session;

import java.util.Scanner;

public class UserAccountLoginScreen extends Screen {

    private final Scanner scanner;
    private final InputValidator inputValidator;
    private final ScreenManager screenManager;
    private final MyObjectRelationalMapper orm;
    private final Session session;

    public UserAccountLoginScreen(  Scanner scanner, InputValidator inputValidator, ScreenManager screenManager,
                                    MyObjectRelationalMapper orm, Session session)
    {
        super("/login");
        this.session = session;
        this.scanner = scanner;
        this.inputValidator = inputValidator;
        this.screenManager = screenManager;
        this.orm = orm;
    }

    @Override
    public void render()
    {
        System.out.println("\n\n*** Login to your account ***\n");
        System.out.println("Enter your username: ");
        String input = scanner.nextLine();
        String username = inputValidator.validate(input, "/isUsername");
        if (username == null)
            return;

        System.out.println("Enter your password: ");
        input = scanner.nextLine();
        String password = inputValidator.validate(input, "/password");
        if (password == null)
            return;
        Credential credential = ((Credential)orm.readRow(new Credential(username, "", "")));
        if(password.equals(credential.getPassword()))
        {
            session.setCredentials(credential);
            session.loadCustomer(credential);
            screenManager.navigate("/customer account");
        } else
        {
            System.out.println("Password was not correct. Please try again.");
        }

    }
}

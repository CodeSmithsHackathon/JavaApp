package com.codesmiths.pane;

import com.codesmiths.structures.Email;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;

public class PopoutPane {
    public static Pane getPane(Email e) {
        GridPane pane = new GridPane();
        FlowPane fp = new FlowPane(), fsender = new FlowPane(), frecipient = new FlowPane(), fsubject = new FlowPane(), fbody = new FlowPane(), fsendDate = new FlowPane(), fattachments = new FlowPane(), buttons = new FlowPane();
        Insets i = new Insets(0, 0, 0,10);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        Text information = new Text("Information");
        Text sender = new Text("Sender:"), subject = new Text("Subject:"), recipient = new Text("Recipient:"), body = new Text("Body:"), sendDate = new Text("Send Date:"), attachments = new Text("Attachments:");

        Text tSender = new Text(e.getSender());
        Text tSubject = new Text(e.getSubject());
        Text tRecipient = new Text(e.getRecipient());
        Text tBody = new Text(e.getBody());
        Text tSendDate = new Text(sdf.format(e.getSendDate()));
        Text tAttachments = new Text(e.getAttachments());

        Button blockSender = new Button("Block sender"), blockDomain = new Button("Block " + e.getSender().substring(e.getSender().indexOf('@') + 1)), remove = new Button("Remove"), release = new Button("Release");

        blockSender.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blockSender(e);
            }
        });

        blockDomain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blockDomain(e);
            }
        });

        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeFromList(e);
            }
        });

        release.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                releaseToInbox(e);
            }
        });

        information.setUnderline(true);
        sender.setUnderline(true);
        recipient.setUnderline(true);
        subject.setUnderline(true);
        body.setUnderline(true);
        sendDate.setUnderline(true);
        attachments.setUnderline(true);
        information.setStyle("-fx-font-size: 30px;");
        pane.setStyle("-fx-font-size: 16px;");
        buttons.setStyle("-fx-font-size: 12px;");

        fp.getChildren().add(information);
        fp.setAlignment(Pos.CENTER);

        tBody.setWrappingWidth(450);

        pane.setVgap(15);

        fsendDate.setPadding(i);
        fsender.setPadding(i);
        frecipient.setPadding(i);
        fsubject.setPadding(i);
        fbody.setPadding(i);
        fattachments.setPadding(i);
        buttons.setHgap(15);

        sender.setWrappingWidth(60);
        recipient.setWrappingWidth(75);
        subject.setWrappingWidth(60);
        sendDate.setWrappingWidth(80);
        attachments.setWrappingWidth(95);

        fsender.getChildren().addAll(sender, tSender);
        frecipient.getChildren().addAll(recipient, tRecipient);
        fsubject.getChildren().addAll(subject, tSubject);
        fbody.getChildren().addAll(body, tBody);
        fsendDate.getChildren().addAll(sendDate, tSendDate);
        fattachments.getChildren().addAll(attachments, tAttachments);
        buttons.getChildren().addAll(release, remove, blockSender, blockDomain);
        buttons.setAlignment(Pos.CENTER);

        pane.addRow(0, fp);
        pane.addRow(1, fsender);
        pane.addRow(2, frecipient);
        pane.addRow(3, fsubject);
        pane.addRow(4, fbody);
        pane.addRow(5, fsendDate);
        pane.addRow(6, fattachments);
        pane.addRow(7, buttons);

        return pane;
}

    private static void blockSender(Email e) {
        // Add a record to the blocked senders table
        System.out.println("Sender " + e.getSender() + " has been blocked");
    }

    private static void blockDomain(Email e) {
        // Add a record to the blocked domains table
        System.out.println("Domain " + e.getSender().substring(e.getSender().indexOf('@') + 1) + " has been blocked");
    }

    private static void removeFromList(Email e) {
        // Remove email from AWS
        System.out.println("Email has been removed from the list");
    }

    private static void releaseToInbox(Email e) {
        // Contact mail server
        System.out.println("Email has been release to the recipients inbox");
    }
}

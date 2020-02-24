package com.didahdx.app;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class Consumer {

   public static void main(String [] args) throws Exception{
      ConnectionFactory connectionFactory =new ConnectionFactory();

         Connection connection = connectionFactory.newConnection();
         Channel channel = connection.createChannel();
         channel.queueDeclare("testing-mq", false, false,
                 false, null);
         channel.basicConsume("testing-mq", true, (consumerTag, delivery) -> {
            String m= new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("I have received a message  "+ m);

         }, consumerTag -> {

         });


   }
}

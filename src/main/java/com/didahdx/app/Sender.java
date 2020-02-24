package com.didahdx.app;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Sender {

   public static void main(String [] args){
      ConnectionFactory connectionFactory =new ConnectionFactory();
String message=": \n"+ new Date().toString()+" \t test Message \n";
      try {
         Connection connection = connectionFactory.newConnection();
         Channel channel = connection.createChannel();
         channel.queueDeclare("testing-mq", false, false,
                 false, null);
         channel.basicPublish("","testing-mq",false,
                 null,message.getBytes());

        System.out.println("RabbitMQ message sent!!!");

      } catch (IOException e) {
         e.printStackTrace();

      } catch (TimeoutException e) {
         e.printStackTrace();
      }catch (Exception e){
         e.printStackTrace();
      }
   }
}

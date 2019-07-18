package SQS_messageQueues;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.Date;
import java.util.List;

/*
Reference: https://github.com/awsdocs/aws-doc-sdk-examples/blob/master/java/example_code/sqs/src/main/java/aws/example/sqs/SendReceiveMessages.java
 */

public class SQSReceiver {

    public static void main(String[] args)
    {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        String[] queueUrl = new String[3];
//        queueUrl[0] = System.getenv("url1");
//        queueUrl[1] = System.getenv("url2");
//        queueUrl[2] = System.getenv("url3");
        queueUrl[0] = System.getenv("QUEUE_1");
        queueUrl[1] = System.getenv("QUEUE_2");
        queueUrl[2] = System.getenv("QUEUE_3");

        while(true) {
            for(int i = 0 ; i < queueUrl.length ; i++) {

            // receive messages from the queue
            List<Message> messages = sqs.receiveMessage(queueUrl[i]).getMessages();

            // delete messages from the queue
            for (Message m : messages) {
                System.out.println("All the messages in all Queue[" + i + "]: " + m.getBody().toString());
                sqs.deleteMessage(queueUrl[i], m.getReceiptHandle());
            }
            }
        }

    }
}

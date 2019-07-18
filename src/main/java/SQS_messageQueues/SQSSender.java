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
public class SQSSender {
    //private static final String QUEUE_NAME = "testQueue" + new Date().getTime();

    public static void main(String[] args) {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        String[] queueUrl = new String[3];
        queueUrl[0] = System.getenv("QUEUE_1");
        queueUrl[1] = System.getenv("QUEUE_2");
        queueUrl[2] = System.getenv("QUEUE_3");

        for(int i = 0 ; i < queueUrl.length; i++){
            SendMessageRequest send_msg_request = new SendMessageRequest()
                    .withQueueUrl(queueUrl[i])
                    .withMessageBody("#Test: Testing the SQS Services")
                    .withDelaySeconds(5);
            sqs.sendMessage(send_msg_request);
        }

/*
        UnComment to  sent multi message
 */
//       Send multiple messages to the queue
//        SendMessageBatchRequest send_batch_request = new SendMessageBatchRequest()
//                .withQueueUrl(queueUrl)
//                .withEntries(
//                        new SendMessageBatchRequestEntry(
//                                "msg_1", "Hello from message 1"),
//                        new SendMessageBatchRequestEntry(
//                                "msg_2", "Hello from message 2")
//                                .withDelaySeconds(10));
//        sqs.sendMessageBatch(send_batch_request);

    }

}

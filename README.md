# SQS_messageQueues
> Implement a few Message Queues and Broadcasters and wiring them through code.

## Feature Task
> Create 3 Standard Queues:
  * QueueA
  * QueueB
  * QueueC
  
> Create command line applications in Java that use these queues
  * Queue Publisher : Sends a message to a queue, using its ARN or URL
  * Queue Client : Receives messages from a Queue (by ARN) and displays them

## References 

> https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/prerequisites.html

## Trouble Shoot Step
> Add: compile 'com.amazonaws:aws-java-sdk-sqs:1.11.587' to the build.gradle

> Import following on your classes:
 * import com.amazonaws.services.sqs.AmazonSQS;
 * import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
 * import com.amazonaws.services.sqs.model.AmazonSQSException;
 * import com.amazonaws.services.sqs.model.CreateQueueRequest;

> Coming Soon

## Deployed Links
> Coming soon

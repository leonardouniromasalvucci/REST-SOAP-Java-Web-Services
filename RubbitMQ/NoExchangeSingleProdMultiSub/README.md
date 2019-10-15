# Architecture
![alt text](../img/2.PNG)

# Specifications
This is a program to send and receive messages from a named queue. In this one we'll create a Work Queue that will be used to distribute time-consuming tasks among multiple workers.\
<br/>
By default, RabbitMQ will send each message to the next consumer, in sequence. On average every consumer will get the same number of messages. This way of distributing messages is called round-robin. Try this out with three or more workers.

` Worker 1 ` <br/>
` => Waiting for messages. To exit press CTRL+C` <br/>
` => Received First message` <br/>
` => Received Third message...` <br/>
` => Received Fifth message.....` <br/>

` Worker 2` <br/>
` =>  Waiting for messages. To exit press CTRL+C` <br/>
` =>  Received Second message..` <br/>
` =>  Received Fourth message....` <br/>

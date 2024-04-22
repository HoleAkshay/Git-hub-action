package io.nimbuspay;

import io.grpc.stub.StreamObserver;
import io.nimbuspay.model.Msg;
import io.nimbuspay.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HelloWorldServiceImpl extends GreeterGrpc.GreeterImplBase {



    @Autowired
    private MessageRepository messageRepostiry;

  /*  public HelloWorldServiceImpl(MessageRepository messageRepostiry){
        this.messageRepostiry = messageRepostiry;
    }*/

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println(" request is: "+request.toString());

        HelloReply.Builder response = HelloReply.newBuilder()
                                                 .setName("Hello!!" + request.getName());

        //response.setMessage("Hello!!" + request.getName());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void createMassage (HelloRequest request, StreamObserver<HelloReply> responceOb)  {
        System.out.println(" request is: "+request.toString());
  
        HelloReply.Builder response = HelloReply.newBuilder();

        Msg msg= new Msg();
        //msg.setName(request.getName());
        msg.setName(request.toString());
        messageRepostiry.save(msg);

        responceOb.onNext(response.build());
        responceOb.onCompleted();
    }
}

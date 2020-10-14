#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sources;

import com.seanjstory.workplace.search.sdk.api.Source;
import com.seanjstory.workplace.search.sdk.api.Yielder;
import ${package}.document.HelloWorldDocument;

import java.time.Instant;
import java.util.Iterator;

public class HelloWorldSource implements Source<HelloWorldDocument> {

    private final String greeting;

    public HelloWorldSource(){
        greeting = "hello, world!";
    }

    public HelloWorldSource(String greeting){
        this.greeting = greeting;
    }

    @Override
    public Iterator<HelloWorldDocument> getDocuments() {

        return new Yielder<HelloWorldDocument>(){
            boolean first =true;
            @Override
            protected void yieldNextCore() {
                if (!first){
                    yieldBreak();
                    return;
                }
                String id = String.valueOf(Instant.now().toEpochMilli());
                String body = greeting;
                yieldReturn(new HelloWorldDocument(id, body));
                first=false;
            }

        }.iterator();
    }
}

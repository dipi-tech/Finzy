package org.finzy.modeltests;

import org.finzy.model.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
public class PostTestCase {

    @Test
    public void returnsSuccessWhenPostIsSentToSameStateWithValidStamp(){
        Post post = new Post(getSenderData(),getRecevierData(),Stamp.LOCAL);
        Message msg = post.send();
        assertThat(msg.getSuccess(), is(true));
        assertThat(msg.getMessage(), is("Post Sent Successfully"));
    }

    @Test
    public void returnsSuccessWhenPostIsSentToDifferentStateWithValidStamp(){
        User sender = getSenderData();
        sender.setState(State.AndraPradesh);
        Post post = new Post(sender,getRecevierData(),Stamp.NATIONAL);
        Message msg = post.send();
        assertThat(msg.getSuccess(), is(true));
        assertThat(msg.getMessage(), is("Post Sent Successfully"));
    }

    @Test
    public void returnsFailureWhenPostIsSentToSameStateWithInvalidStamp(){
        Post post = new Post(getSenderData(),getRecevierData(),Stamp.NATIONAL);
        Message msg = post.send();
        assertThat(msg.getSuccess(), is(false));
        assertThat(msg.getMessage(), is("Stamp Usage Not Correct"));
    }

    @Test
    public void returnsFailureWhenPostIsSentToDifferentStateWithInvalidStamp(){
        User sender = getSenderData();
        sender.setState(State.AndraPradesh);
        Post post = new Post(sender,getRecevierData(),Stamp.LOCAL);
        Message msg = post.send();
        assertThat(msg.getSuccess(), is(false));
        assertThat(msg.getMessage(), is("Stamp Usage Not Correct"));
    }


    public User getSenderData(){
        StandardAddress address = new StandardAddress("10A","4th Cross","JP Nagar","Bengaluru",560002L ,State.Karnataka, Country.India);
        User sender = new User(1L,"Alex",address);
        return sender;
    }

    public User getRecevierData(){
        StandardAddress address = new StandardAddress("20A","4th Cross","KuvempuNagar","Mysuru",560002L ,State.Karnataka, Country.India);
        User recevier = new User(1L,"Alex",address);
        return recevier;
    }

}

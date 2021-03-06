package com.taptrack.tcmptappy.tcmp.commandfamilies.basicnfc;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.TCMPMessage;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class AbstractBasicNfcMessageTest {

    @Test
    public void testGetCommandFamily() throws Exception {
        TCMPMessage message = new AbstractBasicNfcMessage() {
            @Override
            public void parsePayload(byte[] payload) throws MalformedPayloadException {

            }

            @Override
            public byte[] getPayload() {
                return new byte[0];
            }

            @Override
            public byte getCommandCode() {
                return 0;
            }
        };

        assertArrayEquals(message.getCommandFamily(),new byte[]{0x00,0x01});
    }
}
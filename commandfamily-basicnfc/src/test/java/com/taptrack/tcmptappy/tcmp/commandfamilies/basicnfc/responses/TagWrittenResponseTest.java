package com.taptrack.tcmptappy.tcmp.commandfamilies.basicnfc.responses;

import com.taptrack.tcmptappy.tappy.constants.TagTypes;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TagWrittenResponseTest {
    Random random = new Random();

    private byte[] generateTestPayload(byte tagType, byte[] tagCode) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(tagType);
        try {
            byteArrayOutputStream.write(tagCode);
        }
        catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Test
    public void testParsePayload() throws Exception {
        byte tagType = TagTypes.MIFARE_DESFIRE;
        byte[] uid = new byte[10];
        random.nextBytes(uid);
        byte[] payload = generateTestPayload(tagType,uid);

        TagWrittenResponse response = new TagWrittenResponse();
        response.parsePayload(payload);
        assertEquals(tagType, response.getTagType());
        assertArrayEquals(uid,response.getTagCode());
    }

    @Test
    public void testGetPayload() throws Exception {
        byte tagType = TagTypes.MIFARE_DESFIRE;
        byte[] uid = new byte[10];
        random.nextBytes(uid);
        byte[] payload = generateTestPayload(tagType,uid);

        TagWrittenResponse response = new TagWrittenResponse(uid,tagType);
        assertArrayEquals(payload,response.getPayload());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        TagWrittenResponse response = new TagWrittenResponse();
        assertEquals(response.getCommandCode(),0x05);
    }
}
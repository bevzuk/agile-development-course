package ru.unn.agile.Huffman;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class HuffmanTest {

    @Test
    public void emptyInputStringForCompressAreNotAllowed(){
        try{
            Huffman.compress("");
            fail("Runtime exception was expected");
        }
        catch(RuntimeException e){
            assertEquals("Empty string are not allowed for compress",e.getMessage());
        }
        catch (Exception e){
            fail("Unexpected exception: " + e.toString());
        }
    }

    @Test
    public void emptyInputStringForExpandAreNotAllowed(){
        try{
            Huffman.expand("");
            fail("Runtime exception was expected");
        }
        catch(RuntimeException e){
            assertEquals("Empty string are not allowed for expand",e.getMessage());
        }
        catch (Exception e){
            fail("Unexpected exception: " + e.toString());
        }
    }

    @Test
    public void outputStringAfterCompressIsNotEmpty(){
        String outputText=Huffman.compress("Example");
        assertEquals(false,outputText.isEmpty());
    }

    @Test
    public void stringsBeforeCompressAndAfterExpandAreEquals(){
        String inputText="Example";
        String outputAfterCompress=Huffman.compress(inputText);
        String outputAfterExpand=Huffman.expand(outputAfterCompress);
        assertEquals(inputText, outputAfterExpand);
    }

}

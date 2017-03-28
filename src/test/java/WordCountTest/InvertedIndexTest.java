package WordCountTest;

import MapReduce.InvertedIndex.InvertedIndexMapper;
import MapReduce.InvertedIndex.InvertedIndexReducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satheesh on 27/3/17.
 */
public class InvertedIndexTest {
    MapDriver<LongWritable, Text, Text, Text> mapDriver;
    ReduceDriver<Text, Text, Text, Text> reduceDriver;

    @Before
    public void setUp() {
        InvertedIndexMapper mapper = new InvertedIndexMapper();
        InvertedIndexReducer reducer = new InvertedIndexReducer();
        mapDriver = new MapDriver<LongWritable, Text, Text, Text>();
        mapDriver.setMapper(mapper);
        reduceDriver = new ReduceDriver<Text, Text, Text, Text>();
    }

    @Test
    public void testMapper() {
        mapDriver.withInput(new LongWritable(), new Text(
                "T[0]=hi there"));
        mapDriver.addOutput(new Text("hi"), new Text("T[0]"));
        mapDriver.addOutput(new Text("there"), new Text("T[0]"));
        mapDriver.runTest();
    }

   /* @Test
    public void testReducer() {
        List<Text> list = new ArrayList<Text>();
        list.add(new Text("T[0]"));
        list.add(new Text("T[1]"));
        reduceDriver.setInput(new Text("hi"), list);
        reduceDriver.withOutput(new Text("hi"), new Text("T[0] T[1]"));
        reduceDriver.runTest();
    }*/
}

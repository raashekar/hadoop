package MapReduce.Grep;


import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.NullWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;


/**
 * Created by satheesh on 27/3/17.
 */

public class GrepMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

    public void map(Object key, Text value, Context context)

            throws IOException, InterruptedException {


        String txt = value.toString();
 
       String mapRegex = "T[0]*";

   
     if (txt.matches(mapRegex)) {
    
        context.write(NullWritable.get(), value);

        }
    }
}

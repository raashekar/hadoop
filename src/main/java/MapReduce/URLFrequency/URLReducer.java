package MapReduce.URLFrequency;


import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;


/**
 * Created by satheesh on 28/3/17.
 */

public class URLReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    private IntWritable outputValue = new IntWritable();
 
   protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
 
       int sum = 0;

        for(IntWritable value : values) {
  
          sum += value.get();

        }
  
      outputValue.set(sum);

        context.write(key, outputValue);
   
 }
}

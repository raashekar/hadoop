package MapReduce.URLFrequency;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Created by satheesh on 28/3/17.
 */
public class URLMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private IntWritable count = new IntWritable(1);
    private Text outPutKey = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws java.io.IOException, InterruptedException {
        String inputLogLine = value.toString();
        String[] input = inputLogLine.split(" ");
        outPutKey.set(input[0]);
        context.write(outPutKey, count);
    }
}

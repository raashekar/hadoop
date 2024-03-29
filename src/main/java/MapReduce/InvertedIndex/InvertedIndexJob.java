/*
Example chnages

*/

package MapReduce.InvertedIndex;


import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.Text;


import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import java.io.IOException;

/**
 * Created by satheesh on 27/3/17.
 */

public class InvertedIndexJob {

    public static void main(String[] args)
     
       throws IOException, ClassNotFoundException, InterruptedException {


        Job job = new Job();
    
    job.setJarByClass(InvertedIndexJob.class);

        job.setJobName("Inverted Index");

     
   FileInputFormat.addInputPath(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));

   
     job.setMapperClass(InvertedIndexMapper.class);
 
       job.setReducerClass(InvertedIndexReducer.class);


        job.setOutputKeyClass(Text.class);

        job.setOutputValueClass(Text.class);


        job.waitForCompletion(true);

    }
}

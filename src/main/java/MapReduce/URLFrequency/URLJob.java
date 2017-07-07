package MapReduce.URLFrequency;


import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import java.io.IOException;


/**
 * Created by satheesh on 28/3/17.
 */
public class URLJob {

    public static void main(String[] args)
  
          throws IOException, ClassNotFoundException, InterruptedException {

 
       Job job = new Job();
 
       job.setJarByClass(URLJob.class);
   
     job.setJobName("Inverted Index");

 
       FileInputFormat.addInputPath(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));
   
     job.setMapperClass(URLMapper.class);

        job.setReducerClass(URLReducer.class);

  
      job.setOutputKeyClass(Text.class);
  
      job.setOutputValueClass(IntWritable.class);


        job.waitForCompletion(true);

    }
}
